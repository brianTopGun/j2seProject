package com.javase.c11.collection;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //创建一个TreeSet:
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(12);
        ts.add(3);
        ts.add(7);
        ts.add(9);
        ts.add(3);
        ts.add(16);
        System.out.println(ts.size());
        System.out.println(ts);


    TreeSet<Student> ts1 = new TreeSet<>();
        ts1.add(new Student(10,"elili"));
        ts1.add(new Student(8,"blili"));
        ts1.add(new Student(4,"alili"));
        ts1.add(new Student(9,"elili"));
        ts1.add(new Student(10,"flili"));
        ts1.add(new Student(1,"dlili"));
        System.out.println(ts1.size());
        System.out.println(ts1);
    }
}

