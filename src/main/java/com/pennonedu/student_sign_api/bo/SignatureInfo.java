package com.pennonedu.student_sign_api.bo;

import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.security.DigestAlgorithms;

import java.security.PrivateKey;
import java.security.cert.Certificate;

/**
 * The type Signature info.
 *
 * @author jishuai
 */
public class SignatureInfo {
    //签名的原因，显示在pdf签名属性中
    private String reason;
    //签名的地点，显示在pdf签名属性中
    private String location;
    //摘要算法名称，例如SHA-1
    private String digestAlgorithm = DigestAlgorithms.SHA256;
    //图章路径
    private String imagePath;
    //表单域名称
    private String fieldName;
    //证书链
    private Certificate[] chain;
    //签名私钥
    private PrivateKey pk;
    //批准签章
    private int certificationLevel = PdfSignatureAppearance.NOT_CERTIFIED;
    //表现形式：仅描述，仅图片，图片和描述，签章者和描述
    private PdfSignatureAppearance.RenderingMode renderingMode = PdfSignatureAppearance.RenderingMode.GRAPHIC;
    /**
     * 图章属性
     */
    //页码
    private int page = 1;
    //图章左下角x
    private float llx;
    //图章左下角y
    private float lly;
    //图章右上角x
    private float urx;
    //图章右上角y
    private float ury;

    /**
     * Gets reason.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets reason.
     *
     * @param reason the reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets digest algorithm.
     *
     * @return the digest algorithm
     */
    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    /**
     * Sets digest algorithm.
     *
     * @param digestAlgorithm the digest algorithm
     */
    public void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    /**
     * Gets image path.
     *
     * @return the image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets image path.
     *
     * @param imagePath the image path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Gets field name.
     *
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets field name.
     *
     * @param fieldName the field name
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Get chain certificate [ ].
     *
     * @return the certificate [ ]
     */
    public Certificate[] getChain() {
        return chain;
    }

    /**
     * Sets chain.
     *
     * @param chain the chain
     */
    public void setChain(Certificate[] chain) {
        this.chain = chain;
    }

    /**
     * Gets pk.
     *
     * @return the pk
     */
    public PrivateKey getPk() {
        return pk;
    }

    /**
     * Sets pk.
     *
     * @param pk the pk
     */
    public void setPk(PrivateKey pk) {
        this.pk = pk;
    }

    /**
     * Gets certification level.
     *
     * @return the certification level
     */
    public int getCertificationLevel() {
        return certificationLevel;
    }

    /**
     * Sets certification level.
     *
     * @param certificationLevel the certification level
     */
    public void setCertificationLevel(int certificationLevel) {
        this.certificationLevel = certificationLevel;
    }

    /**
     * Gets rendering mode.
     *
     * @return the rendering mode
     */
    public PdfSignatureAppearance.RenderingMode getRenderingMode() {
        return renderingMode;
    }

    /**
     * Sets rendering mode.
     *
     * @param renderingMode the rendering mode
     */
    public void setRenderingMode(PdfSignatureAppearance.RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Gets llx.
     *
     * @return the llx
     */
    public float getLlx() {
        return llx;
    }

    /**
     * Sets llx.
     *
     * @param llx the llx
     */
    public void setLlx(float llx) {
        this.llx = llx;
    }

    /**
     * Gets lly.
     *
     * @return the lly
     */
    public float getLly() {
        return lly;
    }

    /**
     * Sets lly.
     *
     * @param lly the lly
     */
    public void setLly(float lly) {
        this.lly = lly;
    }

    /**
     * Gets urx.
     *
     * @return the urx
     */
    public float getUrx() {
        return urx;
    }

    /**
     * Sets urx.
     *
     * @param urx the urx
     */
    public void setUrx(float urx) {
        this.urx = urx;
    }

    /**
     * Gets ury.
     *
     * @return the ury
     */
    public float getUry() {
        return ury;
    }

    /**
     * Sets ury.
     *
     * @param ury the ury
     */
    public void setUry(float ury) {
        this.ury = ury;
    }
}
