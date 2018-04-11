/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.omg.CORBA.ObjectHelper;

/**
 * @author wb-lcw229616
 * @version $Id: HomeLink.java, v 0.1 2018年04月11日 15:11 wb-lcw229616 Exp $
 */
public class HomeLink implements InvocationHandler {
    private Person  target;
    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;


    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是链家，我帮别人找房子..");
        //第一个参数是target,也就是被代理类的对象；第二个参数是方法中的参数
        method.invoke(target, args);
        System.out.println("我是链家，已经找完了..");
        return null;
    }
}