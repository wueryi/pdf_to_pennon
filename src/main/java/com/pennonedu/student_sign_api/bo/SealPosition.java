package com.pennonedu.student_sign_api.bo;

public class SealPosition {
    private int page;
    private float llx;
    private float lly;
    private float urx;
    private float ury;

    public SealPosition() {
    }

    public SealPosition(int page, float llx, float lly, float urx, float ury) {
        this.page = page;
        this.llx = llx;
        this.lly = lly;
        this.urx = urx;
        this.ury = ury;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float getLlx() {
        return llx;
    }

    public void setLlx(float llx) {
        this.llx = llx;
    }

    public float getLly() {
        return lly;
    }

    public void setLly(float lly) {
        this.lly = lly;
    }

    public float getUrx() {
        return urx;
    }

    public void setUrx(float urx) {
        this.urx = urx;
    }

    public float getUry() {
        return ury;
    }

    public void setUry(float ury) {
        this.ury = ury;
    }
}
