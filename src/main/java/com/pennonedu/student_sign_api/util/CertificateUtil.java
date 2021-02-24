package com.pennonedu.student_sign_api.util;

import com.pennonedu.student_sign_api.bo.Cert;
import com.pennonedu.student_sign_api.bo.CertExtension;
import com.pennonedu.student_sign_api.exception.BusinessException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @author jishuai
 */
public class CertificateUtil {
    public final static String ISSUER = "CN=网签凭证,OU=技术部,O=青岛培诺教育股份有限公司,C=CN,E=it@hgedu.com,L=青岛,ST=山东";
    public final static String CERTIFICATE_URL = "http://crl.pennon.com.cn";
    public final static int TERM_OF_VALIDITY_YEAR = 4;
    private final static String ALIAS = "pennon";
    private final static String ROOT_CA_SRC = "/usr/local/sign/resources/ca/root/pennon_root.p12";
    private final static String ROOT_CA_PASSWORD = "pennon808";

    public static String createP12(String dest, String password, String subject) {
        try {
            // 目标文件输出流
            File file = new File(dest);
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Cert cert = createCert(password, ISSUER, subject, CERTIFICATE_URL, "PKCS12", false);
            fileOutputStream.write(cert.getKeyStoreData());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BusinessException("创建P12证书失败："+exception.getMessage());
        }
        return dest;
    }

    private static KeyPair getKey() throws NoSuchAlgorithmException {
        // 密钥对 生成器，RSA算法 生成的  提供者是 BouncyCastle
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", new BouncyCastleProvider());
        // 密钥长度 1024
        generator.initialize(2048);
        // 证书中的密钥 公钥和私钥
        return generator.generateKeyPair();
    }

    private static Cert createCert(String password, String issuer, String subject, String certificateCRL, String type, boolean isRoot) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, OperatorCreationException, InvalidKeyException, NoSuchProviderException, UnrecoverableKeyException, SignatureException {
        Cert cert = new Cert();
        KeyStore keyStore;
        if (type.equals(KeyStore.getDefaultType().toUpperCase())) {
            // 生成JKS证书
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } else {
            // 标志生成PKCS12证书
            keyStore = KeyStore.getInstance(type, new BouncyCastleProvider());
        }
        keyStore.load(null, null);
        KeyPair keyPair = getKey();
        //  issuer与 subject相同的证书就是CA证书
        Cert certByCertificateV3 = certificateV3Builder(issuer, subject, keyPair, cert, certificateCRL, isRoot, null);
        // 标识别名
        keyStore.setKeyEntry(ALIAS, keyPair.getPrivate(), password.toCharArray(), new Certificate[]{certByCertificateV3.getCertificate()});
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PublicKey pk;
        if (isRoot) {
            //根证书
            pk = keyPair.getPublic();
        } else {
            //非根证书
            pk = KeyStoreUtil.getPublicKeyByP12(ROOT_CA_SRC, ROOT_CA_PASSWORD);
        }
        certByCertificateV3.getCertificate().verify(pk);
        keyStore.store(byteArrayOutputStream, password.toCharArray());
        byte[] keyStoreData = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        cert.setKeyStoreData(keyStoreData);
        return cert;
    }

    private static Cert certificateV3Builder(String issuer, String subject, KeyPair keyPair, Cert cert, String certificateCRL, boolean isRoot, List<CertExtension> extensions) throws OperatorCreationException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        ByteArrayInputStream byteArrayInputStream;
        X509Certificate x509Certificate;
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        //计算有效期
        Date startTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.YEAR, TERM_OF_VALIDITY_YEAR);
        Date endTime = calendar.getTime();
        // 证书序列号
        BigInteger serial = BigInteger.probablePrime(256, new Random());
        X509v3CertificateBuilder x509v3CertificateBuilder = new JcaX509v3CertificateBuilder(new X500Name(issuer), serial, startTime, endTime, new X500Name(subject), publicKey);
        JcaContentSignerBuilder jBuilder = new JcaContentSignerBuilder("SHA1withRSA");
        SecureRandom secureRandom = new SecureRandom();
        jBuilder.setSecureRandom(secureRandom);

        PrivateKey pk;
        if (isRoot) {
            pk = privateKey;
        } else {
            pk = KeyStoreUtil.getPrivateKeyByP12(ROOT_CA_SRC, ROOT_CA_PASSWORD);
        }
        ContentSigner contentSigner = jBuilder.setProvider(new BouncyCastleProvider()).build(pk);
        // 分发点
        ASN1ObjectIdentifier crlDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
        GeneralName generalName = new GeneralName(GeneralName.uniformResourceIdentifier, certificateCRL);
        GeneralNames generalNames = new GeneralNames(generalName);
        DistributionPointName distributionPoint = new DistributionPointName(generalNames);
        DistributionPoint[] points = new DistributionPoint[1];
        points[0] = new DistributionPoint(distributionPoint, null, null);
        CRLDistPoint crlDistPoint = new CRLDistPoint(points);
        x509v3CertificateBuilder.addExtension(crlDistributionPoints, true, crlDistPoint);
        // 用途
        ASN1ObjectIdentifier keyUsage = new ASN1ObjectIdentifier("2.5.29.15");
        // | KeyUsage.nonRepudiation | KeyUsage.keyCertSign
        x509v3CertificateBuilder.addExtension(keyUsage, true, new KeyUsage(KeyUsage.digitalSignature | KeyUsage.keyEncipherment));
        // 基本限制 X509Extension.java
        ASN1ObjectIdentifier basicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
        x509v3CertificateBuilder.addExtension(basicConstraints, true, new BasicConstraints(true));
        // privateKey:使用自己的私钥进行签名，CA证书
        if (extensions != null) {
            for (CertExtension extension : extensions) {
                x509v3CertificateBuilder.addExtension(
                        new ASN1ObjectIdentifier(extension.getOid()),
                        extension.isCritical(),
                        ASN1Primitive.fromByteArray(extension.getValue()));
            }
        }
        X509CertificateHolder x509CertificateHolder = x509v3CertificateBuilder.build(contentSigner);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        byteArrayInputStream = new ByteArrayInputStream(x509CertificateHolder.toASN1Structure().getEncoded());
        x509Certificate = (X509Certificate) cf.generateCertificate(byteArrayInputStream);
        byteArrayInputStream.close();
        byte[] certificateData = x509CertificateHolder.getEncoded();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        cert.setCertificateData(certificateData);
        cert.setPublicKey(publicKey.getEncoded());
        cert.setPrivateKey(privateKey.getEncoded());
        cert.setStartTime(startTime);
        cert.setEndTime(endTime);
        cert.setCertificate(x509Certificate);
        return cert;
    }
}
