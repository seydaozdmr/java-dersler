package x_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EqualsVsContains {
    public static void main(String[] args) {
        List<String> elems= new ArrayList<>();
        for(int i=0;i<10000000;i++){
            elems.add(String.valueOf(i)+"a");
        }

        long start= System.currentTimeMillis();
//        if(elems.contains("9999999a")){
//            System.out.println("bulundu");
//        }
//        for(String e:elems){
//            if(e.equals("9999999a"))
//                System.out.println("bulundu");
//        }
        elems.stream().filter(e->e.equals("9999999a")).findFirst();

        System.out.println(System.currentTimeMillis()-start);
    }
}
