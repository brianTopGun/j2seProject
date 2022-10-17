package com.javase.c16.reflex;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

public class Person implements Serializable {
    //属性
    private int age;
    public String name;
    //方法
    private void eat(){
        System.out.println("Person---eat");
    }
    public void sleep(){
        System.out.println("Person---sleep");
    }
}
interface MyInterface {//自定义的接口
    //随便定义一个抽象方法：
    void myMethod();
}

/*
@Target:定义当前注解能够修饰程序中的哪些元素
@Retention:定义注解的声明周期
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
  @interface MyAnnotation {
    String value();//属性
}

class Student extends Person implements MyInterface{
    //属性：
    private int sno;//学号
    double height;//身高
    protected double weight;//体重
    public double score;//成绩
    //方法：
    @MyAnnotation(value="himethod")
    public String showInfo(){
        return "我是一名三好学生";
    }
    public String showInfo(int a,int b){
        return "重载方法====我是一名三好学生";
    }
    private void work(){
        System.out.println("我以后会找工作--》成为码农  程序员 程序猿  程序媛");
    }
    void happy(){
        System.out.println("做人最重要的就是开心每一天");
    }
    protected int getSno(){
        return sno;
    }
    //构造器
    public Student(){
        System.out.println("空参构造器");
    }
    private Student(int sno){
        this.sno = sno;
    }
    private Student(int sno,double weight){
        this.sno = sno;
        this.weight = weight;
    }
    protected Student(int sno,double height,double weight){
        this.sno = sno;
    }
    @Override
    @MyAnnotation(value="hellomyMethod")
    public void myMethod() {
        System.out.println("我重写了myMethod方法。。");
    }
    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }
}
