/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author wb-lcw229616
 * @version $Id: Money.java, v 0.1 2018��04��11�� 12:07 wb-lcw229616 Exp $
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MoneyValidator.class)
public @interface Money {
    String message() default"���ǽ����ʽ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}