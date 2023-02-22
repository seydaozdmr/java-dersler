package g_io.filewriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReader2 {
    public static void main(String[] args) {
        File file=new File("signals2.txt");

        String[] dtos=null;
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String elem="";
            String result="";
            while((elem= reader.readLine())!=null){
                result+=elem;
            }

            dtos=result.split("SignalDTO");
        }catch (IOException e){
            e.printStackTrace();
        }
        int count=0;
        for(String e:dtos){

        }
    }
}
