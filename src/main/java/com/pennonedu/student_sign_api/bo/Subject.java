package com.pennonedu.student_sign_api.bo;

/**
 * @author jishuai
 */
public class Subject {
    private String CN = "网签凭证";
    private String OU;
    private String O = "青岛培诺教育股份有限公司";
    private String C = "CN";
    private String E = "it@hgedu.com";
    private String L = "青岛";
    private String ST = "山东";

    public String getCN() {
        return CN;
    }

    public void setCN(String CN) {
        this.CN = CN;
    }

    public String getOU() {
        return OU;
    }

    public void setOU(String OU) {
        this.OU = OU;
    }

    public String getO() {
        return O;
    }

    public void setO(String o) {
        O = o;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getL() {
        return L;
    }

    public void setL(String l) {
        L = l;
    }

    public String getST() {
        return ST;
    }

    public void setST(String s) {
        ST = s;
    }

    @Override
    public String toString() {
        return "CN=" + CN + ",OU=" + OU + ",O=" + O + ",C=" + C + ",E=" + E + ",L=" + L + ",ST=" + ST;
    }
}
