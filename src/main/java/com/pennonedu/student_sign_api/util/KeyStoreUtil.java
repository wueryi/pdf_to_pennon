package com.pennonedu.student_sign_api.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * @author jishuai
 */
public class KeyStoreUtil {
    public static PublicKey getPublicKeyByP12(String src, String password) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(new FileInputStream(src), password.toCharArray());
        String alias = ks.aliases().nextElement();
        return ks.getCertificate(alias).getPublicKey();
    }

    public static PrivateKey getPrivateKeyByP12(String src, String password) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(new FileInputStream(src), password.toCharArray());
        String alias = ks.aliases().nextElement();
        return (PrivateKey) ks.getKey(alias, password.toCharArray());
    }
}
