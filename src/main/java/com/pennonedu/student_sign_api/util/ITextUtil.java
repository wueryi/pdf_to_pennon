package com.pennonedu.student_sign_api.util;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.pdf.security.*;
import com.pennonedu.student_sign_api.bo.RectangleCentre;
import com.pennonedu.student_sign_api.bo.SignatureInfo;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The type Text util.
 *
 * @author jishuai
 */
public final class ITextUtil {
    /**
     * Sign string.
     *
     * @param src           输入pdf路径，url/相对位置
     * @param dest          输出地址，相对位置
     * @param signatureInfo the signature info
     * @return the string
     * @throws IOException              the io exception
     * @throws DocumentException        the document exception
     * @throws GeneralSecurityException the general security exception
     */
    public static synchronized String sign(String src, String dest, SignatureInfo signatureInfo) throws IOException, DocumentException, GeneralSecurityException {
        // 读取pdf文件
        PdfReader reader = new PdfReader(new FileInputStream(src));
        //目标输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // 创建签章工具PdfStamper ，最后一个boolean参数
        // false，pdf文件只允许被签名一次，多次签名，最后一次有效
        // true，pdf可以被追加签名，验签工具可以识别出每次签名之后文档是否被修改
        PdfStamper stamper = PdfStamper.createSignature(reader, byteArrayOutputStream, '\0', null, true);
        // 获取数字签章属性对象，设定数字签章的属性
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        // 签名原因
        appearance.setReason(signatureInfo.getReason());
        // 签名地点
        appearance.setLocation(signatureInfo.getLocation());
        // 设置签名的位置，页码，签名域名称，多次追加签名的时候，签名域名称不能一样 图片大小受表单域大小影响（过小导致压缩）
        // 签名的位置，是图章相对于pdf页面的位置坐标，原点为pdf页面左下角
        // 四个参数的分别是，图章左下角x，图章左下角y，图章右上角x，图章右上角y
        appearance.setVisibleSignature(
                new Rectangle(
                        signatureInfo.getLlx(),
                        signatureInfo.getLly(),
                        signatureInfo.getUrx(),
                        signatureInfo.getUry()
                ),
                signatureInfo.getPage(),
                signatureInfo.getFieldName()
        );
        // 读取图章图片
        Image image = Image.getInstance(signatureInfo.getImagePath());
        appearance.setSignatureGraphic(image);
        // 设置认证等级
        appearance.setCertificationLevel(signatureInfo.getCertificationLevel());
        // 设置图章的显示方式，如下选择的是只显示图章（还有其他的模式，可以图章和签名描述一同显示）
        appearance.setRenderingMode(signatureInfo.getRenderingMode());
        // 摘要算法
        ExternalDigest digest = new BouncyCastleDigest();
        // 签名算法
        ExternalSignature signature = new PrivateKeySignature(signatureInfo.getPk(), signatureInfo.getDigestAlgorithm(), null);
        // 调用itext签名方法完成pdf签章
        // 数字签名格式，CMS,CADE
        MakeSignature.signDetached(appearance, digest, signature, signatureInfo.getChain(), null, null, null, 0, MakeSignature.CryptoStandard.CADES);

        // 目标文件输出流
        File file = new File(dest);
        File parentFile = file.getParentFile();
        parentFile.mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        reader.close();

        return dest;
    }

    /**
     * Fill string.
     *
     * @param src           输入pdf路径，url/相对位置
     * @param dest          输出地址，相对位置
     * @param params the params
     * @return the string
     * @throws IOException       the io exception
     * @throws DocumentException the document exception
     */
    public static synchronized String fill(String src, String dest, Map<String, String> params) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(new FileInputStream(src));
        //目标文件输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        File file = new File(dest);
        File parentFile = file.getParentFile();
        parentFile.mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        PdfStamper stamper = new PdfStamper(reader, bos);
        AcroFields form = stamper.getAcroFields();

        // 使用中文字体
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        ArrayList<BaseFont> fontList = new ArrayList<>();
        fontList.add(baseFont);

        form.setSubstitutionFonts(fontList);
        for (String key : params.keySet()) {
            String value = params.get(key);
            form.setField(key, value, true);
        }
        stamper.setFormFlattening(true);
        stamper.close();

        fileOutputStream.write(bos.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        bos.close();

        return dest;
    }

    /**
     * Gets rectangle by keywords.
     *
     * @param src           输入pdf路径，url/相对位置
     * @param keywords the keywords
     * @return the rectangle by keywords
     * @throws IOException the io exception
     */
    public static RectangleCentre getRectangleByKeywords(String src, String keywords) throws IOException {
        RectangleCentre rectangleCentre = new RectangleCentre();
        PdfReader pdfReader = new PdfReader(new FileInputStream(src));
        int pageNum = pdfReader.getNumberOfPages();
        PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);
        StringBuilder stringBuilder = new StringBuilder();
        int maxLength = keywords.length();

        for (int i = 1; i <= pageNum; i++) {
            int finalI = i;
            pdfReaderContentParser.processContent(finalI, new RenderListener() {
                @Override
                public void renderText(TextRenderInfo textRenderInfo) {
                    // 设置 关键字文本为单独的块，不然会错位
                    boolean isKeywordChunk = textRenderInfo.getText().length() == maxLength;
                    if (isKeywordChunk) {
                        // 文档按照 块 读取
                        stringBuilder.delete(0, stringBuilder.length());
                        stringBuilder.append(textRenderInfo.getText());
                    } else {
                        // 有些文档 单字一个块的情况
                        // 拼接字符串
                        stringBuilder.append(textRenderInfo.getText());
                        // 去除首部字符串，使长度等于关键字长度
                        if (stringBuilder.length() > maxLength) {
                            stringBuilder.delete(0, stringBuilder.length() - maxLength);
                        }
                    }
                    // 判断是否匹配上
                    if (keywords.equals(stringBuilder.toString())) {
                        // 计算中心点坐标
                        Rectangle2D.Float baseFloat = textRenderInfo.getBaseline().getBoundingRectange();
                        Rectangle2D.Float ascentFloat = textRenderInfo.getAscentLine().getBoundingRectange();
                        float centreX;
                        float centreY;
                        centreX = baseFloat.x + ascentFloat.width / 2;
                        centreY = baseFloat.y + ((ascentFloat.y - baseFloat.y) / 2);

                        rectangleCentre.setCentreX(centreX);
                        rectangleCentre.setCentreY(centreY);
                        rectangleCentre.setPage(finalI);
                        // 匹配完后 清除
                        stringBuilder.delete(0, stringBuilder.length());
                    }
                }

                @Override
                public void renderImage(ImageRenderInfo arg0) {
                }

                @Override
                public void endTextBlock() {
                }

                @Override
                public void beginTextBlock() {
                }
            });
        }
        return rectangleCentre;
    }
}
