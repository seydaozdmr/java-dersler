package c_stream;

import java.util.stream.Stream;

public class Stream_ornek3 {
    public static void main(String[] args){
        //TODO 5'e tam bolunen ilk beş sayı ekrana yazdırılacak


        Stream <Integer> stream= Stream.iterate(0,e->e=e+1);
        stream
                .filter(e->e%5==0)
                .limit(20)
                .forEach(System.out::println);













//        Stream.iterate(1, element->element+1)
//                .filter(element->element%5==0)
//                .limit(5)
//                .forEach(System.out::println);
    }
}
