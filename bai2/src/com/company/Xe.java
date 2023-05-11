package com.company;

public class Xe {

    private String tenXe;
    private String mauXe;

    public Xe() {
    }

    public Xe(String tenXe, String mauXe) {
        this.tenXe = tenXe;
        this.mauXe = mauXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }
}
