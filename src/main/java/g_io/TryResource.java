package g_io;

import java.io.*;

public class TryResource {
    public static void main(String[] args) {
        try(BufferedInputStream bis=new BufferedInputStream(new FileInputStream("test.txt"));
                BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("test7.txt"))){
            int c;
            while((c=bis.read())!=-1){
                bos.write(c);
            }
        }catch (IOException e){

        }
    }
}
