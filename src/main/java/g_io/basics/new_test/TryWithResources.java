package g_io.basics.new_test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {

        try(FileInputStream fis = new FileInputStream("test.txt")){
            int val=0;
            while((val=fis.read())!=-1){
                System.out.println((char)val);
            }
        }catch (IOException e){

        }

        try(FileReader reader=new FileReader("test.txt")){
            int val=0;
            while((val=reader.read())!=-1){
                System.out.println((char)val);
            }
        }catch (IOException e){

        }
    }
}
