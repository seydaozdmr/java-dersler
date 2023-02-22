package g_io.filewriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileReader {
    public static void main(String[] args) {
        File signals=new File("signals.txt");

        try(BufferedReader reader=new BufferedReader(new java.io.FileReader(signals))){
            StringBuilder builder =new StringBuilder();
            String elem="";
            while((elem=reader.readLine())!=null){
                builder.append(elem);
            }

            String [] elems=builder.toString().split("SignalDTO");
            String [][] dtos =new String[elems.length][];
            int start=0;
            for(String e:elems){
                //System.out.println(e);
                String[]dto=e.split(",");
                dtos[start++]=dto;
            }
            //Arrays.stream(dtos[2]).forEach(System.out::println);
            //System.out.println(elems.length);

            Map<String,Integer> analytic=new HashMap<>();

            int count=0;

            //TEKRAR EDEN IDLER
            for(String[] elms:dtos){
                if(elms.length>1){
                    //System.out.println(elms[4]);
                    String id=elms[0];
                    if(count==5758){
                        System.out.println(id.substring(4));
                    }
                    count++;

//                    if(id!=null)
//                        id=id.substring(4);
//                    //System.out.println(id);
//                    analytic.merge(id,1,Integer::sum);
                }
            }
            //null olan değerlere bak?
//            for(String[] elms:dtos){
//                if(elms.length>1){
//                    //System.out.println(elms[5]);
//                    String id=elms[5];
//                    String result="";
//                    if(id.contains("signalContent") && id!=null){
//                        result=id.substring(14,id.length()-1);
//                        if(result.length()==0)
//                            System.out.println(id);
//                    }
//
//                    //System.out.println(id);
//
//                }
//            }
//
//            //System.out.println(analytic);
//            int duplicateCounter=0;
//            for(Map.Entry<String,Integer> e:analytic.entrySet()){
//                if(e.getValue()>1){
//                    System.out.println(e);
//                    duplicateCounter++;
//                }
//            }
//
//            System.out.println("tekrar eden sinyal sayısı : "+duplicateCounter);
//
//            List<String> result = findSignal(dtos,"16396");
//            for (String signal:result){
//                System.out.println(signal);
//            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<String> findSignal(String [][] dtos,String key){
        int count=0;
        List<String> elems=new ArrayList<>();
        for(String[] elms:dtos){
            if(elms.length>1){
                if(elms[0].substring(4).equals(key)){
                    elems.add(Arrays.stream(elms).collect(Collectors.joining(",")));
                    System.out.println("Tekrar eden sinyal sırada : "+count);
                }
                count++;
            }

        }
        return elems;
    }
}
