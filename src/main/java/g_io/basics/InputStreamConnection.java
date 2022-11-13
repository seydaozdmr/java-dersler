package g_io.basics;

import java.io.*;

public class InputStreamConnection {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=null; //Byte verisi olarak okumak

        try{
            File file = new File("test/test.txt");

            fileInputStream=new FileInputStream(file);

            int bytes ;
            while((bytes=fileInputStream.read())!=-1){
                char elem = (char)bytes;
                Integer variable = Integer.parseInt(String.valueOf(elem));
                System.out.println(variable*2);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fileInputStream!=null)
                fileInputStream.close();
        }

        File myWay=new File("test/test3.txt");
        myWay.createNewFile();

        try(FileOutputStream fis=new FileOutputStream(myWay)){
            String variable="deneme2";
//            byte[] test=variable.getBytes();
//            for(byte a:test){
//                fis.write(a);
//            }
            for(char c:variable.toCharArray()){
                fis.write(c);
            }
        }


    }
}
