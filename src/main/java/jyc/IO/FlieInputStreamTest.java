package jyc.IO;

import java.io.*;

public class FlieInputStreamTest {

    public static void main(String[] args) {
        String s = null;
        File file = new File("D:\\test.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader in = new BufferedReader(isr);
            char[] buff = new char[inputStream.available()];
            in.read(buff, 0, inputStream.available());
            s = new String(buff);
            in.close();
            isr.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

}
