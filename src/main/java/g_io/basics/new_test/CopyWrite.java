package g_io.basics.new_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyWrite {
    public static void main(String[] args) {

        try(var fis=new FileInputStream("test.txt");var fos=new FileOutputStream("test2.txt")){
            int val=0;
            while((val=fis.read())!=-1){
                fos.write(val);
            }

        }catch (IOException e){

        }
    }
}
