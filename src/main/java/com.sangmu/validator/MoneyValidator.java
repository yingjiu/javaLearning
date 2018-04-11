/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.validator;

/**
 * @author wb-lcw229616
 * @version $Id: MoneyValidator.java, v 0.1 2018��04��11�� 12:36 wb-lcw229616 Exp $
 */
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MoneyValidator implements ConstraintValidator<Money, Double> {

    private String  moneyReg     = "^\\d+(\\.\\d{1,2})?$";//��ʾ����������ʽ
    private Pattern moneyPattern = Pattern.compile(moneyReg);

    @Override
    public void initialize(Money money) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext arg1) {
        if (value == null){
            return true;
        } else{
            //����ǿյģ�����true������Ϊ���null�������@NotNull������ʾ
            //�������false�Ļ����ǽ����null��@Money�е�messageҲ�������ʾ
            //�Լ����Գ���

            return moneyPattern.matcher(value.toString()).matches();
        }
    }
}