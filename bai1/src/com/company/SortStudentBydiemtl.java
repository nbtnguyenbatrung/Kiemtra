package com.company;

import java.util.Comparator;

public class SortStudentBydiemtl implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getDiemtl() > o2.getDiemtl()) {
            return 1;
        }
        return -1;
    }
}
