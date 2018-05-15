/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class DownloadImage {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println(System.getProperty("java.library.path"));
        // TODO Auto-generated method stub
        //download("http://mhpic.mh51.com/comic/D%2F%E6%96%97%E7%BD%97%E5%A4%A7%E9%99%86%E6%8B%86%E5%88%86%E7%89%88%2F1%E8%AF%9D%2F1.jpg-mht.middle.webp",
        //"1_li1325169021.webp","d:\\image\\");

        File file1= new File("D:/image/1_li1325169021.webp");
        File file2= new File("D:/image/1_li1325169021.jpg");


        try {

            BufferedImage im = ImageIO.read(file1);
            ImageIO.write(im, "jpg", file2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void download(String urlString, String filename,String savePath) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

}