package g_io;

import java.io.*;

public class BufferedInputStreamExample {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bf=new BufferedInputStream(new FileInputStream("test.txt"));
        BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(new FileOutputStream("test6.txt"));

        int c;
        while ((c= bf.read())!=-1) {
            System.out.println((char)c);
            bufferedOutputStream.write(c);
        }
         bf.close();
         bufferedOutputStream.close();

    }
}
