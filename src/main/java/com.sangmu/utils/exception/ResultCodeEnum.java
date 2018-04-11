/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.utils.exception;

/**
 * @author wb-lcw229616
 * @version $Id: ResultCodeEnum.java, v 0.1 2018��04��11�� 11:15 wb-lcw229616 Exp $
 */
public enum ResultCodeEnum {
    /** ���Ϊ�� */
    PARAMETER_IS_NULL("SOCIAL_COMMON_0003", "���Ϊ��"),

    /** ��β��Ϸ� */
    PARAMETER_IS_ILLEGAL("SOCIAL_COMMON_0004", "��β��Ϸ�"),

    /** ����ɹ� */
    SUCCESS("0000", "����ɹ�");

    /** ��Ӧ����� */
    private String code;

    /** ��Ӧ�����Ϣ */
    private String msg;

    /**
     * ��Ӧ���ö�ٹ��췽��
     * @param code ��Ӧ�����
     * @param msg ��Ӧ�����Ϣ
     */
    ResultCodeEnum(final String code, final String msg) {
        this.code = code;
        this.msg = msg;

    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     *
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property <tt>msg</tt>.
     *
     * @param msg value to be assigned to property msg
     */
    public void setMsg(final String msg) {
        this.msg = msg;
    }
}