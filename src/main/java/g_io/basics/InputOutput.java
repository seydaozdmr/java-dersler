package g_io.basics;

import java.io.*;

public class InputOutput {
    public static void main(String[] args) throws IOException {
        File inputFile=new File(args[0]); //exist
        File output=new File(args[1]); //not exist
        if(!inputFile.exists())
            throw new RuntimeException("Verilen giriş dosyası bulunmamaktadır.");
        else
            System.out.println("Veri dosyası bulundu");

        if(!output.exists()){
            output.createNewFile();
            System.out.println("Çıkış dosyası yaratıldı");
        }


        FileInputStream fis= new FileInputStream(inputFile);
        FileOutputStream fos=new FileOutputStream(output);

        try{
            int bytes;

            while((bytes=fis.read())!=-1){
                System.out.println(bytes);

                    char elem = (char)bytes;
                    Integer variable = Integer.parseInt(String.valueOf(elem));
                    int result=variable*2;

            }
        }catch (IOException e){
            System.out.println("hata");
        }finally {
            if(fis!=null)
                fis.close();
            if(fos!=null)
                fos.close();
        }


    }
}
