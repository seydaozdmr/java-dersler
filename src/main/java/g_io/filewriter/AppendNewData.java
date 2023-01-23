package g_io.filewriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendNewData {

    public static void main(String[] args) {
        File file=new File("Append.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
            for(int i=0;i<10;i++){
                writer.write(""+i);
            }
        }catch (IOException e){

        }
    }
}
