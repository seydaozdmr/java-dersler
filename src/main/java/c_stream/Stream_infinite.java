package c_stream;

import java.util.Random;
import java.util.stream.Stream;

public class Stream_infinite {
    public static void main(String[] args) {
        Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
        //TODO bunların kaç adet olduğunu bulalım
        Long count= randomNumbers.limit(100).filter(e -> e>50).count();
        System.out.println(count);

        Stream<String> infiniteString=Stream.generate(()->"test");


        //TODO 1'den 100'e kadar olan çift sayıları yazdırma
        Stream<Integer> infinite=Stream.iterate(100,e->e+5);
        //infinite.limit(1000).filter(e-> e<=1000).forEach(System.out::println);


        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
    }
}
