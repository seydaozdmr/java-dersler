package g_io.basics.new_test;

import java.io.*;
import java.nio.charset.Charset;

public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));

        String result = reader.readLine();
        System.out.println(result);
        File file=new File("test.txt");
        reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String asd="";
        while((asd=reader.readLine())!=null){
            System.out.println(asd);
        }
    }
}
