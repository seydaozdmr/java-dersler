package c_stream.basics.collector;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicCollectorsExample {
    public static void main(String[] args) {
        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears

        Stream<String> stream = Stream.of("lions", "tigers", "bears");
        Double result1 = stream.collect(Collectors.averagingInt(String::length));
        System.out.println(result1); // 5.333333333333333

        Stream<String> stream1 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> myTree = stream1
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(myTree); // [tigers]

        /**
         * toMap(Function k, Function v)
         * toMap(Function k, Function v, BinaryOperator m)
         * toMap(Function k, Function v, BinaryOperator m, Supplier s)
         * Creates map using
         * functions to map
         * keys, values, optional
         * merge function, and
         * optional map type
         * supplier
         * Map
         */
        //Eğer bir veri kümesinden normal bir map oluşturacaksak (collections içermeyen) Map<String,Integer> gibi
        Stream<String> stream2 = Stream.of("lions", "tigers", "bears","birds");
        Map<String,Integer> myMap=stream2.collect(Collectors.toMap(s->s,String::length));
        System.out.println(myMap);

        Stream<String> stream3 = Stream.of("lions", "tigers", "bears","birds","asdfds","sad","s","rr");
        Map<Integer,String> myMap1=stream3.collect(Collectors.toMap(String::length,s->s,(a,b)->a+","+b));
        System.out.println(myMap1);

    }
}
