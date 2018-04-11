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
 * @version $Id: HomeLink.java, v 0.1 2018��04��11�� 15:11 wb-lcw229616 Exp $
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
        System.out.println("�������ң��Ұ�����ҷ���..");
        //��һ��������target,Ҳ���Ǳ�������Ķ��󣻵ڶ��������Ƿ����еĲ���
        method.invoke(target, args);
        System.out.println("�������ң��Ѿ�������..");
        return null;
    }
}