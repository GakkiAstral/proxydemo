package com.bjsxt.dynamicproxy.cglibproxy;

public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxyRent cglibProxyRent = new CglibProxyOldlu();
        CglibProxyRent cglibProxyRent1 = (CglibProxyRent) CglibProxyBeanFactory.getProxyBean(cglibProxyRent);
        cglibProxyRent1.Renting();
    }
}
