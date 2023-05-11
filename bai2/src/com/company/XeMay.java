package com.company;

import java.util.Scanner;

public class XeMay extends Xe{

    private String bienSo;
    private String loaiXe;
    private Float giaXe;
    private Scanner s;

    public XeMay() {
    }

    public XeMay(String bienSo, String loaiXe, Float giaXe, Scanner s) {
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.giaXe = giaXe;
        this.s = s;
    }

    public XeMay(String tenXe, String mauXe, String bienSo, String loaiXe, Float giaXe, Scanner s) {
        super(tenXe, mauXe);
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.giaXe = giaXe;
        this.s = s;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public Float getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(Float giaXe) {
        this.giaXe = giaXe;
    }

    public Scanner getS() {
        return s;
    }

    public void setS(Scanner s) {
        this.s = s;
    }

    public XeMay nhap(){
        XeMay xe = new XeMay();
        xe.setS(new Scanner(System.in));
        System.out.println("Nhập tên xe: ");
        xe.setTenXe(xe.getS().nextLine());
        System.out.println("Nhập màu xe: ");
        xe.setMauXe(xe.getS().nextLine());
        System.out.println("Nhập biển số xe: ");
        xe.setBienSo(xe.getS().nextLine());
        System.out.println("Nhập loại xe: ");
        xe.setLoaiXe(xe.getS().nextLine());
        System.out.println("Nhập giá xe: ");
        xe.setGiaXe(xe.getS().nextFloat());
        return xe;
    }

    public void HienThi(){
        System.out.println("Thông tin xe: tên xe : " + this.getTenXe() +
                " màu xe : " + this.getMauXe() +
                " biển số xe : " + this.getBienSo() +
                " loại xe : " + this.getLoaiXe() +
                " giá xe : " + this.getGiaXe());
    }
}
