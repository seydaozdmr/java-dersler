package g_io;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ByteStreamStringArray {
    public static void main(String[] args) {
        FileInputStream on=null;
        FileOutputStream ou=null;

        try {
            String [] result;
            on=new FileInputStream(new File("test.txt"));
            ou=new FileOutputStream(new File("countres.txt"));
            StringBuilder st=new StringBuilder();
            int c;

            while ((c=on.read()) !=-1) {
                st.append((char)c);
            }
            result=st.toString().split(",");

            for (int i=0; i<result.length;i++){
                for (int j=0; j<result[i].length();j++){
                    ou.write(result[i].charAt(j));
                }
                if(i==1)
                    break;
                ou.write('-');
            }

            //TODO ikinci tireyi çözmek gerekiyor
            /**
             * Builder ile append edip
             * StringBuilder
             * a l m a n y a - t ü r k i y e break
             * using Camunda bpm
             * selenium
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    //            Iterator<String> iterator= Arrays.stream(result).iterator();
//            while(iterator.hasNext())
//                System.out.println(iterator.next());
//
//            List<String> countries= List.of("Almanya","Türkiye");
//            Iterator<String> myIter=countries.iterator();
//            while (myIter.hasNext())
//                System.out.println(myIter.next());
//            //System.out.println(result.toString());

}
