package g_io.basics;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedExample {
    public static void main(String[] args) throws IOException {
        try(FileInputStream fis =new FileInputStream("test/test.txt");
                BufferedInputStream bis= new BufferedInputStream(fis)){ //Decorator pattern
            int bytes;
            while((bytes=bis.read())!=-1){
                System.out.println((char)bytes);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
