package g_io.basics.new_test;

import java.io.*;

public class ByteStreamExample {
    public static void main(String[] args) {
        File file = new File("test.txt");
        InputStream is=null;
        try {
            is= new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int elem=0;
        while(true){
            try {
                if (!((elem=is.read())!=-1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println((char)elem);
        }
        try {
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Reader reader =null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if (!((elem=reader.read())!=-1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println((char) elem);
        }


    }
}
