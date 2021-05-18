package com.bjsxt.staticproxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        Rent rent = new Oldlu();
        StaticProxyRent staticProxyRent = new StaticProxyRent(rent);
        staticProxyRent.renting();
    }
}
