package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n ;
        do {
            System.out.print("Nhập số lượng xe : ");
            n = sc.nextInt();
        } while ( n <= 0);

        List<XeMay> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            XeMay xeMay = new XeMay();
            xeMay = xeMay.nhap();
            list.add(xeMay);
        }

        List<XeMay> list1 = list.stream()
                .sorted(Comparator.comparingDouble(XeMay::getGiaXe).reversed())
                .collect(Collectors.toList());

        list1.get(0).HienThi();

        System.out.print("Nhập số biển số xe cần tìm : ");
        String s = sc.nextLine();

        List<XeMay> listS = list.stream()
                .filter(xeMay -> xeMay.getBienSo().equals(s))
                .collect(Collectors.toList());

        listS.forEach(XeMay::HienThi);
    }
}
