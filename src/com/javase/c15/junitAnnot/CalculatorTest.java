package com.javase.c15.junitAnnot;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    //测试add方法
    @Test
    public void testAdd(){
        System.out.println("测试add方法");
        Calculator cal = new Calculator();
        int result = cal.add(10, 30);
        System.out.println(result);
        Assert.assertEquals(40,result);
    }
    //测试sub方法
    @Test
    public void testSub(){
        System.out.println("测试sub方法");
        Calculator cal = new Calculator();
        int result = cal.sub(10, 30);
        System.out.println(result);
    }
}

class Calculator {
    //加法：
    public int add(int a,int b){
        return a+b;
    }
    //减法：
    public int sub(int a,int b){
        return a-b;
    }
}
