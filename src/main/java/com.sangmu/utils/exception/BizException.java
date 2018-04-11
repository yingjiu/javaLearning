/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.utils.exception;

/**
 * @author wb-lcw229616
 * @version $Id: BizException.java, v 0.1 2018��04��11�� 11:14 wb-lcw229616 Exp $
 */
public class BizException extends RuntimeException {
    /** serialVersionUID */
    private static final long serialVersionUID = 5840651686530819567L;

    /** �쳣������� */
    private ResultCodeEnum    code             = ResultCodeEnum.SUCCESS;

    /**
     * ����һ��<code>BizException</code>
     *
     * @param code ������
     */
    public BizException(ResultCodeEnum code) {
        super(code.getMsg());
        this.code = code;
    }

    /**
     * ����һ��<code>BizException</code>
     *
     * @param code ������
     * @param message �Զ��������Ϣ
     */
    public BizException(ResultCodeEnum code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * ����һ��<code>BizException</code>
     *
     * @param code ������
     * @param message �Զ��������Ϣ
     */
    public BizException(ResultCodeEnum code, Throwable cause, String message) {
        super(message, cause);
        this.code = code;
    }

    /**
     * ����һ��<code>BizException</code>
     *
     * @param code ������
     * @param cause �쳣
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
        return s + ": " + code.getCode() + "[" + message + "]��";
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
