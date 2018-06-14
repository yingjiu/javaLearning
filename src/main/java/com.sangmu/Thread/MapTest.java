/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.Thread;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author wb-lcw229616
 * @version $Id: MapTest.java, v 0.1 2018年05月31日 11:53 wb-lcw229616 Exp $
 */
public class MapTest {
    public static  HashMap hashMap = new HashMap();

    public static void main(String[] args) {
        for(int i = 1 ;i<11;i++){
            hashMap.put(i,"第"+i);
        }


    }
}