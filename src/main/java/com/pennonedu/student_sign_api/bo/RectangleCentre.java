package com.pennonedu.student_sign_api.bo;

public class RectangleCentre {
    private int page = 1;
    private float centreX;
    private float centreY;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float getCentreX() {
        return centreX;
    }

    public void setCentreX(float centreX) {
        this.centreX = centreX;
    }

    public float getCentreY() {
        return centreY;
    }

    public void setCentreY(float centreY) {
        this.centreY = centreY;
    }

    public SealPosition getPosition(float height, float width) {
        //自己可以调整图片的大小                                                                                                                     
        float halfWith = width / 2;
        float halfHeight = height / 2;
        SealPosition sealPosition = new SealPosition();
        sealPosition.setPage(this.page);
        sealPosition.setLlx(this.centreX - halfWith);
        sealPosition.setLly(this.centreY - halfHeight);
        sealPosition.setUrx(this.centreX + halfWith);
        sealPosition.setUry(this.centreY + halfHeight);
        return sealPosition;
    }

    @Override
    public String toString() {
        return "RectangleCentre{" +
                "page=" + page +
                ", centreX=" + centreX +
                ", centreY=" + centreY +
                '}';
    }
}
