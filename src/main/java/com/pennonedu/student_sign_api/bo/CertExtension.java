package com.pennonedu.student_sign_api.bo;

/**
 * The type Extension.
 */
public class CertExtension {
    //相关
    private String oid;
    //危急
    private boolean critical;
    private byte[] value;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }
}
