package com.javase.c14.socket;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) throws UnknownHostException {
        //封装IP：
        //InetAddress ia = new InetAddress();不能直接创建对象，因为InetAddress()被default修饰了。
        InetAddress ia = InetAddress.getByName("192.168.199.217");
        System.out.println(ia);
        InetAddress ia2 = InetAddress.getByName("localhost");//localhost指代的是本机的ip地址
        System.out.println(ia2);
        InetAddress ia3 = InetAddress.getByName("127.0.0.1");//127.0.0.1指代的是本机的ip地址
        System.out.println(ia3);
        InetAddress ia4 = InetAddress.getByName("LAPTOP-CRIVSRRU");//封装计算机名
        System.out.println(ia4);
        InetAddress ia5 = InetAddress.getByName("www.mashibing.com");//封装域名
        System.out.println(ia5);
        System.out.println(ia5.getHostName());//获取域名
        System.out.println(ia5.getHostAddress());//获取ip地址



        InetSocketAddress isa = new InetSocketAddress("192.168.199.217",8080);
        System.out.println(isa);
        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());
        InetAddress ia6 = isa.getAddress();
        System.out.println(ia6.getHostName());
        System.out.println(ia6.getHostAddress());
    }
}
