/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.sangmu.utils.common.ValidateHolder;
import com.sangmu.validator.ValidateGroups.GroupV1;
import com.sangmu.validator.bean.ParentInfo;

/**
 * @author wb-lcw229616
 * @version $Id: ValidatorMain.java, v 0.1 2018年04月11日 11:28 wb-lcw229616 Exp $
 */
public class ValidatorMain {
    public static void main(String[] args) {
        ValidatorBean request = new ValidatorBean();
        request.setCode("1122222");
        request.setMoney(100.01);


        ParentInfo parentInfo = new ParentInfo();
        //ValidateHolder.validate(request, "[业务标签]", GroupV1.class);
        parentInfo.setMotherName("123");

        List temp = new ArrayList<ParentInfo>();
        temp.add(parentInfo);
        request.setParentInfos(temp);
        //request.setParentInfo(parentInfo);

        //ValidateHolder.validate(request, "[业务标签]", GroupV1.class);
        // ValidateHolder.validate(request, "[业务标签]");

        SelfValidate(parentInfo);



    }

    public  static  void SelfValidate(Object request){
        Class<?> requestClass = request.getClass();
        //获取所有属性
        Field[] fields = requestClass.getDeclaredFields();
        try{
            for(Field field:fields){
                field.setAccessible(true);
                System.out.println(field.getName());
                System.out.println(field.getType());
                System.out.println(field.get(request));
                Annotation[] annotations = field.getAnnotations();
                for(Annotation annotation:annotations){
                    System.out.println(annotation.annotationType().getName());


                }

            }
        }catch (Exception e){

        }


    }
}