package com.bjsxt.dynamicproxy.jdkproxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        JdkProxyRent jdkProxyRent = new JdkProxyOldlu();
        JdkProxyRent jdkProxyRent1 =(JdkProxyRent) JdkProxyFactory.getProxyBean(jdkProxyRent);
        jdkProxyRent1.renting();
    }
}
