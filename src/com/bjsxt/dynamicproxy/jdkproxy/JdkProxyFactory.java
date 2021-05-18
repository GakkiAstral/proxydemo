package com.bjsxt.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    /**
     * 动态生成代理对象
     */
    public static Object getProxyBean(Object target){
        Class clazz = target.getClass();
        MyAspect myAspect = new MyAspect();
        //在JDK中动态生成代理对象的方法
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            /**
             * invoke指的是动态生成代理对象中的方法
             * @param proxy 动态生成的代理对象
             * @param method 目标方法的方法对象
             * @param args 传递到目标方法中的参数列表
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                myAspect.before();
                Object obj = method.invoke(target,args);
                myAspect.after();
                return obj;
            }
        });
    }
}
