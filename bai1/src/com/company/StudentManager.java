package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {

    public static final Scanner scanner = new Scanner(System.in);
    private List<Student> studentList = new ArrayList<>();

    public void NhapDuLieu() {

        int n;
        do {
            System.out.println("Nhập số lượng sinh viên: ");
            n = scanner.nextInt();
        } while (n<=0);

        for (int i = 0; i < n; i++) {
            String masv = inputMasv();
            scanner.nextLine();
            String tensv = inputTensv() ;
            Float diemtl = inputDiemtl();
            scanner.nextLine();
            String ghichu = inputGhichu() ;
            Student student = new Student(masv, tensv, diemtl, ghichu);
            studentList.add(student);
        }
    }

    private String inputMasv() {
        System.out.print("Nhập mã sinh viên: ");
        return scanner.next();
    }
    private String inputTensv() {
        System.out.print("Nhập tên sinh viên: ");
        return scanner.nextLine();
    }
    private Float inputDiemtl() {
        System.out.print("Nhập điểm tích lũy: ");
        return scanner.nextFloat();
    }
    private String inputGhichu() {
        System.out.print("Nhập ghi chú: ");
        return scanner.nextLine();
    }

    public void HienThi() {
        for (Student student : studentList) {
            System.out.println("Sinh viên có mã sinh viên: "+ student.getMasv() +
                    " tên sinh viên: " + student.getTensv() +
                    " điểm tích lũy: " + student.getDiemtl() +
                    " ghi chú: " + student.getGhichu() );
        }
    }

    public void SapXep() {
        System.out.println("Danh sách sinh viên trước khi sắp xếp ");
        for (Student student : studentList) {
            System.out.println("Sinh viên có mã sinh viên: "+ student.getMasv() +
                    " tên sinh viên: " + student.getTensv() +
                    " điểm tích lũy: " + student.getDiemtl() +
                    " ghi chú: " + student.getGhichu() );
        }

        System.out.println("Danh sách sinh viên sau khi sắp xếp ");
        List<Student> list = sortStudentByDiemtl();

        for (Student student : list) {
            System.out.println("Sinh viên có mã sinh viên: "+ student.getMasv() +
                    " tên sinh viên: " + student.getTensv() +
                    " điểm tích lũy: " + student.getDiemtl() +
                    " ghi chú: " + student.getGhichu() );
        }

    }

    public List<Student> sortStudentByDiemtl() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getDiemtl).reversed())
                .collect(Collectors.toList());
    }

}
