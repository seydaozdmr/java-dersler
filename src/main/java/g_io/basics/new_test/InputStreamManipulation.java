package g_io.basics.new_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class InputStreamManipulation {

    public static void main(String[] args) {
        Set<Character> elems = new HashSet<>();
        StringBuilder stringBuilder=new StringBuilder();

        try(InputStream is = new FileInputStream("chars.txt")){
            int i;
            while((i=is.read())!=-1){
                if(' '!=(char)i)
                    if(elems.add((char)i))
                        stringBuilder.append((char)i);
            }
        }catch (IOException e){

        }
        System.out.println(stringBuilder);
    }
}
