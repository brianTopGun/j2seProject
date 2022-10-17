package com.javase.c11.collection;

import java.util.ArrayList;
import java.util.List;

public class genericTest {

    public static void main(String[] args) {

        GeneriClass clazz = new GeneriClass();
        clazz.a(11);
        clazz.a("fda");
        clazz.b(new String[]{"s","d","x"});
        clazz.c(true);

        List list = new ArrayList<>();
        list.add("a");
        list.add("ab");

        List list2 = new ArrayList();
        list2.add("cc");

        list.containsAll(list2);

        System.out.println(list.toString());

    }


}

class GeneriClass<E>{

    int age;
    String name;
    E sex;

    public void a(E e){

    }
    public void b(E[] m){

    }

    public <T> void c(T t){

    }


}
