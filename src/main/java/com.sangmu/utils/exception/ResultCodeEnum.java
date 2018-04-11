/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.utils.exception;

/**
 * @author wb-lcw229616
 * @version $Id: ResultCodeEnum.java, v 0.1 2018年04月11日 11:15 wb-lcw229616 Exp $
 */
public enum ResultCodeEnum {
    /** 入参为空 */
    PARAMETER_IS_NULL("SOCIAL_COMMON_0003", "入参为空"),

    /** 入参不合法 */
    PARAMETER_IS_ILLEGAL("SOCIAL_COMMON_0004", "入参不合法"),

    /** 处理成功 */
    SUCCESS("0000", "处理成功");

    /** 响应结果码 */
    private String code;

    /** 响应结果信息 */
    private String msg;

    /**
     * 响应结果枚举构造方法
     * @param code 响应结果码
     * @param msg 响应结果信息
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