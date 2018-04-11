/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.Proxy;

import java.io.FileOutputStream;

import sun.misc.ProxyGenerator;

/**
 * @author wb-lcw229616
 * @version $Id: TestSearchHouse.java, v 0.1 2018年04月11日 15:17 wb-lcw229616 Exp $
 *
 * 参考文章  https://www.cnblogs.com/lfdingye/p/7717063.html
 *
 */
public class TestSearchHouse {
    public static void main(String[] args) {
        Person person = (Person) new HomeLink().getInstance(new Master());
        person.searchHouse();
        try {
            byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("D:/$Proxy0.class");
            os.write(data);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}