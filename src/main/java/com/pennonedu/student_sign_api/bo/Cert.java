package com.pennonedu.student_sign_api.bo;

import java.security.cert.Certificate;
import java.util.Date;

public class Cert {
    private Certificate certificate;
    private byte[] keyStoreData;
    private byte[] certificateData;
    private byte[] publicKey;
    private byte[] privateKey;
    private Date startTime;
    private Date endTime;

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public byte[] getKeyStoreData() {
        return keyStoreData;
    }

    public void setKeyStoreData(byte[] keyStoreData) {
        this.keyStoreData = keyStoreData;
    }

    public byte[] getCertificateData() {
        return certificateData;
    }

    public void setCertificateData(byte[] certificateData) {
        this.certificateData = certificateData;
    }

    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    public byte[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(byte[] privateKey) {
        this.privateKey = privateKey;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
