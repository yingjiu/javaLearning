package com.sangmu.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class FirstOpenCV {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //注意程序运行的时候需要在VM option添加该行 指明opencv的dll文件所在路径
        //-Djava.library.path=$PROJECT_DIR$\opencv\x64
    }

    public static void main(String[] args) {
        String root = FirstOpenCV.class.getResource("/").getPath();
        System.out.println("根目录"+root);
        Mat mat = Imgcodecs.imread(root+ "images/opencv.png");
        System.out.println(mat);
    }
}
