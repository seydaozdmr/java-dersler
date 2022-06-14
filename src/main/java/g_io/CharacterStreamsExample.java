package g_io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamsExample {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try{
            fileReader = new FileReader("test.txt");
            fileWriter=new FileWriter("test3.txt");

            int c;
            while((c=fileReader.read())!=-1){
                System.out.print(c+ " - ");
                fileWriter.write(c);
            }
        }finally {
            if(fileReader!=null)
                fileReader.close();
            if(fileWriter!=null)
                fileWriter.close();
        }
    }
}
