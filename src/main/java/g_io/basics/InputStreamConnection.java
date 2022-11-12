package g_io.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamConnection {
    public static void main(String[] args) {
        FileInputStream fileInputStream;

        try{
            File file = new File("test/test.txt");
            fileInputStream=new FileInputStream(file);

            int bytes ;
            while((bytes=fileInputStream.read())!=-1){
                System.out.println(bytes);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
