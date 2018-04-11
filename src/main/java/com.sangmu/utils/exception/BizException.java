/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.utils.exception;

/**
 * @author wb-lcw229616
 * @version $Id: BizException.java, v 0.1 2018年04月11日 11:14 wb-lcw229616 Exp $
 */
public class BizException extends RuntimeException {
    /** serialVersionUID */
    private static final long serialVersionUID = 5840651686530819567L;

    /** 异常错误代码 */
    private ResultCodeEnum    code             = ResultCodeEnum.SUCCESS;

    /**
     * 创建一个<code>BizException</code>
     *
     * @param code 错误码
     */
    public BizException(ResultCodeEnum code) {
        super(code.getMsg());
        this.code = code;
    }

    /**
     * 创建一个<code>BizException</code>
     *
     * @param code 错误码
     * @param message 自定义错误信息
     */
    public BizException(ResultCodeEnum code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 创建一个<code>BizException</code>
     *
     * @param code 错误码
     * @param message 自定义错误信息
     */
    public BizException(ResultCodeEnum code, Throwable cause, String message) {
        super(message, cause);
        this.code = code;
    }

    /**
     * 创建一个<code>BizException</code>
     *
     * @param code 错误码
     * @param cause 异常
     */
    public BizException(ResultCodeEnum code, Throwable cause) {
        super(code.getMsg(), cause);
        this.code = code;
    }

    /**
     * @see java.lang.Throwable#toString()
     */
    @Override
    public final String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage();
        return s + ": " + code.getCode() + "[" + message + "]。";
    }

    /**
     * @return Returns the code.
     */
    public ResultCodeEnum getCode() {
        return code;
    }

    /**
     * @param code The code to set.
     */
    public void setCode(ResultCodeEnum code) {
        this.code = code;
    }

}
