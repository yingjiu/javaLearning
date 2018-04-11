/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.utils.common;

/**
 * @author wb-lcw229616
 * @version $Id: StringUtil.java, v 0.1 2018��04��11�� 11:23 wb-lcw229616 Exp $
 */
public class StringUtil {
    /* ============================================================================ */
    /*  ������singleton��                                                           */
    /* ============================================================================ */

    /** ���ַ����� */
    public static final String EMPTY_STRING = "";

    /* ============================================================================ */
    /*  �пպ�����                                                                  */
    /*                                                                              */
    /*  ���·��������ж�һ���ַ����Ƿ�Ϊ��                                          */
    /*  1. null                                                                     */
    /*  2. empty - ""                                                               */
    /*  3. blank - "ȫ���ǿհ�" - �հ���Character.isWhitespace�����塣              */
    /* ============================================================================ */

    /**
     * ����ַ����Ƿ�Ϊ<code>null</code>����ַ���<code>""</code>��
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param str Ҫ�����ַ���
     *
     * @return ���Ϊ��, �򷵻�<code>true</code>
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    /**
     * ����ַ����Ƿ���<code>null</code>�Ϳ��ַ���<code>""</code>��
     * <pre>
     * StringUtil.isEmpty(null)      = false
     * StringUtil.isEmpty("")        = false
     * StringUtil.isEmpty(" ")       = true
     * StringUtil.isEmpty("bob")     = true
     * StringUtil.isEmpty("  bob  ") = true
     * </pre>
     *
     * @param str Ҫ�����ַ���
     *
     * @return �����Ϊ��, �򷵻�<code>true</code>
     */
    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }

    /**
     * ����ַ����Ƿ��ǿհף�<code>null</code>�����ַ���<code>""</code>��ֻ�пհ��ַ���
     * <pre>
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank("")        = true
     * StringUtil.isBlank(" ")       = true
     * StringUtil.isBlank("bob")     = false
     * StringUtil.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str Ҫ�����ַ���
     *
     * @return ���Ϊ�հ�, �򷵻�<code>true</code>
     */
    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * ����ַ����Ƿ��ǿհף�<code>null</code>�����ַ���<code>""</code>��ֻ�пհ��ַ���
     * <pre>
     * StringUtil.isBlank(null)      = false
     * StringUtil.isBlank("")        = false
     * StringUtil.isBlank(" ")       = false
     * StringUtil.isBlank("bob")     = true
     * StringUtil.isBlank("  bob  ") = true
     * </pre>
     *
     * @param str Ҫ�����ַ���
     *
     * @return ���Ϊ�հ�, �򷵻�<code>true</code>
     */
    public static boolean isNotBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

}