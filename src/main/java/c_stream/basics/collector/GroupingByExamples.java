package c_stream.basics.collector;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByExamples {
    public static void main(String[] args) {

        /**
         * The overloaded methods of groupingBy are:
         *
         * First, with a classification function as the method parameter:
         *
         * static <T,K> Collector<T,?,Map<K,List<T>>>
         *   groupingBy(Function<? super T,? extends K> classifier)
         * Secondly, with a classification function and a second collector as method parameters:
         *
         * static <T,K,A,D> Collector<T,?,Map<K,D>>
         *   groupingBy(Function<? super T,? extends K> classifier,
         *     Collector<? super T,A,D> downstream)
         * Finally, with a classification function, a supplier method (that provides the Map implementation which contains the end result), and a second collector as method parameters:
         *
         * static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M>
         *   groupingBy(Function<? super T,? extends K> classifier,
         *     Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
         */
//        var ohMy = Stream.of("lions", "tigers", "bears","lions");
//        //Streamin bir özelliğine göre map şeklinde gruplamak üzere kullanılır.
//        Map<Integer, List<String>> map = ohMy.collect( Collectors.groupingBy(String::length));
//        System.out.println(map);
//
//        var stream = Stream.of("lions", "tigers", "bears","bird");
//        Map<Character,List<String>> myMap=stream.collect(Collectors.groupingBy(s->s.charAt(0)));
//        System.out.println(myMap);
//
//        var stream1 = Stream.of("lions", "tigers", "bears" ,"lions");
//        Map<Integer, Set<String>> setMap = stream1.collect(
//                Collectors.groupingBy( String::length, Collectors.toSet()));
//        System.out.println(setMap);
//
//        var stream2 = Stream.of("lions", "tigers", "bears");
//        TreeMap<Integer, Set<String>> map7 = stream2.collect(
//                Collectors.groupingBy(
//                        String::length,
//                        TreeMap::new,
//                        Collectors.toSet()));
//        System.out.println(map7); //
//
//        var stream3 = Stream.of("lions", "tigers", "bears");
//        Map<Integer, Optional<Character>> map2 = stream3.collect(
//                Collectors.groupingBy(
//                        String::length,
//                        Collectors.mapping(s -> s.charAt(0), Collectors.minBy((a, b) -> a - b))));
//        System.out.println(map2);
        var stream4 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<String>> map3 = stream4.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(s->s.substring(0,3),Collectors.minBy(String::compareTo))));
        System.out.println(map3);



        var stream5 = Stream.of("lions", "tigers", "bears");
        Map<Integer,List<Character>> map4=stream5.collect(
                Collectors.groupingBy(String::length,
                        Collectors.mapping(s->s.charAt(0),Collectors.toList()))
        );
        System.out.println(map4);
    }
}
