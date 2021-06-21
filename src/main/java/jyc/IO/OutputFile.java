package jyc.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class OutputFile {

    public static void main(String[] args) {
        String text="AAAAA";
        try {
            //1、打开流
            Writer w=new FileWriter("D:/测试.txt",true);
            //2、写入内容
            w.write(text);
            //3、关闭流
            w.close();
        } catch (IOException e) {
            System.out.println("文件写入错误："+e.getMessage());
        }
    }

}
