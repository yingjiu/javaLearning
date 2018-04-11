/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.sangmu.utils.common;

/**
 * 生成随机数工具类
 * @author alice.fy
 * @version $Id: RandomUtils.java, v 0.1 2016年4月18日 下午7:31:43 alice.fy Exp $
 */
public class RandomUtils {

    /** 字符常量 */
    private final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                                           'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                                           'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                                           'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                           'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                                           'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    /**
     * 生成随机不重复的领取码
     * @param lenght
     * @return
     */
    public static String getAccessCode(int lenght) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < lenght; i++) {
            Double number = Math.random() * (digits.length - 1);
            str.append(digits[number.intValue()]);
        }

        return str.toString();
    }
}
