package com.bjsxt.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyBeanFactory {
    public static Object getProxyBean(CglibProxyRent rent){
        CglibMyAspect cglibMyAspect = new CglibMyAspect();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rent.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o 代理对象的引用
             * @param method 目标对象的方法对象
             * @param objects 目标方法的参数列表
             * @param methodProxy 目标方法的方法对象的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                cglibMyAspect.before();
                Object object = method.invoke(rent,objects);
                cglibMyAspect.after();
                return object;
            }
        });
        return enhancer.create();
    }
}
