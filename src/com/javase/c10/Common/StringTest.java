package com.javase.c10.Common;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {


        //字符串的截取：
        String s10 = "abcdefhijk";
        System.out.println(s10.substring(3));
        System.out.println(s10.substring(3, 6));//[3,6)
        //字符串的合并/拼接操作：
        System.out.println(s10.concat("pppp"));
        //字符串中的字符的替换：
        String s11 = "abcdeahija";
        System.out.println(s11.replace('a', 'u'));
        //按照指定的字符串进行分裂为数组的形式：
        String s12 = "a-b-c-d-e-f";
        String[] strs = s12.split("-");
        System.out.println(Arrays.toString(strs));
        //转大小写的方法：
        String s13 = "abc";
        System.out.println(s13.toUpperCase());
        System.out.println(s13.toUpperCase().toLowerCase());
        //去除收尾空格：
        String s14 = "    a  b  c    ";
        System.out.println(s14.trim());
        //toString()
        String s15 = "abc";
        System.out.println(s15.toString());
        //转换为String类型：
        System.out.println(String.valueOf(false));

        //字符串的截取：
        String s101 = "abcdefhijk";
        System.out.println(s101.substring(3));
        System.out.println(s101.substring(3, 6));//[3,6)
        //字符串的合并/拼接操作：
        System.out.println(s101.concat("pppp"));
        //字符串中的字符的替换：
        String s111 = "abcdeahija";
        System.out.println(s111.replace('a', 'u'));
        //按照指定的字符串进行分裂为数组的形式：
        String s122 = "a-b-c-d-e-f";
        String[] strss = s122.split("-");
        System.out.println(Arrays.toString(strss));
        //转大小写的方法：
        String s133 = "abc";
        System.out.println(s133.toUpperCase());
        System.out.println(s133.toUpperCase().toLowerCase());
        //去除收尾空格：
        String s144 = "    a  b  c    ";
        System.out.println(s144.trim());
        //toString()
        String s155 = "abc";
        System.out.println(s155.toString());
        //转换为String类型：
        System.out.println(String.valueOf(false));

        testStringBuilder();
    }

    private static void testStringBuilder() {
        StringBuilder sb=new StringBuilder("nihaojavawodeshijie");
        //增
        sb.append("这是梦想");
        System.out.println(sb);//nihaojavawodeshijie这是梦想
        //删
        sb.delete(3, 6);//删除位置在[3,6)上的字符
        System.out.println(sb);//nihavawodeshijie这是梦想
        sb.deleteCharAt(16);//删除位置在16上的字符
        System.out.println(sb);//nihavawodeshijie是梦想
        //改-->插入
        StringBuilder sb1=new StringBuilder("$23445980947");
        sb1.insert(3, ",");//在下标为3的位置上插入 ,
        System.out.println(sb1);
        StringBuilder sb2=new StringBuilder("$2你好吗5980947");
        //改-->替换
        sb2.replace(3, 5, "我好累");//在下标[3,5)位置上插入字符串
        System.out.println(sb2);
        sb.setCharAt(3, '!');
        System.out.println(sb);
        //查
        StringBuilder sb3=new StringBuilder("asdfa");
        for (int i = 0; i < sb3.length(); i++) {
            System.out.print(sb3.charAt(i)+"\t");
        }
        System.out.println();
        //截取
        String str=sb3.substring(2,4);//截取[2,4)返回的是一个新的String，对StringBuilder没有影响
        System.out.println(str);
        System.out.println(sb3);
    }

    public void testStringBuffer(){
        StringBuffer sb=new StringBuffer("nihaojavawodeshijie");
        //增
        sb.append("这是梦想");
        System.out.println(sb);//nihaojavawodeshijie这是梦想
        //删
        sb.delete(3, 6);//删除位置在[3,6)上的字符
        System.out.println(sb);//nihavawodeshijie这是梦想
        sb.deleteCharAt(16);//删除位置在16上的字符
        System.out.println(sb);//nihavawodeshijie是梦想
        //改-->插入
        StringBuilder sb1=new StringBuilder("$23445980947");
        sb1.insert(3, ",");//在下标为3的位置上插入 ,
        System.out.println(sb1);
        StringBuilder sb2=new StringBuilder("$2你好吗5980947");
        //改-->替换
        sb2.replace(3, 5, "我好累");//在下标[3,5)位置上插入字符串
        System.out.println(sb2);
        sb.setCharAt(3, '!');
        System.out.println(sb);
        //查
        StringBuilder sb3=new StringBuilder("asdfa");
        for (int i = 0; i < sb3.length(); i++) {
            System.out.print(sb3.charAt(i)+"\t");
        }
        System.out.println();
        //截取
        String str=sb3.substring(2,4);//截取[2,4)返回的是一个新的String，对StringBuilder没有影响
        System.out.println(str);
        System.out.println(sb3);
    }
}
