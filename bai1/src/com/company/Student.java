package com.company;

public class Student {

    private String masv;
    private String tensv;
    private float diemtl;
    private String ghichu;

    public Student(String masv, String tensv, float diemtl, String ghichu) {
        this.masv = masv;
        this.tensv = tensv;
        this.diemtl = diemtl;
        this.ghichu = ghichu;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public float getDiemtl() {
        return diemtl;
    }

    public void setDiemtl(float diemtl) {
        this.diemtl = diemtl;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
