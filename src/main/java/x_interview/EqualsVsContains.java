package x_interview;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
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

        String value = "123.123";

        System.out.println(value.replaceAll("[.,]",""));
        String str = "asd%sdşsad sadl/: asd*_&%+^^";
        //str = str.replaceAll("[^a-zA-Z0-9]", "-");
        System.out.println(str);

        String regex =  "[^a-zA-Z0-9]";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(str).replaceAll("-"));

        LocalDateTime localDateTime= LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-YYYY-hh-mm-")));

    }
}
