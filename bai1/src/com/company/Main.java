package com.company;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        String choose = null ;
        boolean exit = false;

        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.NhapDuLieu();
                    break;
                case "2":
                    studentManager.HienThi();
                    break;
                case "3":
                    studentManager.SapXep();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Không tồn tại số quy định:");
                    break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Nhập dữ liệu.");
        System.out.println("2. Hiển thị.");
        System.out.println("3. Sắp xếp.");
        System.out.println("4. Thoát.");
        System.out.println("---------------------------");
        System.out.print("Mời chọn số: ");
    }
}
