package com.bjsxt.dynamicproxy.jdkproxy;

public class MyAspect {
    public void before(){
        System.out.println("带领房客看房。。。签租房协议");
    }
    public void after(){
        System.out.println("售后服务");
    }
}

