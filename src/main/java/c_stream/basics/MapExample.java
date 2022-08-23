package c_stream.basics;

import java.util.List;
import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length)
                .forEach(System.out::print); // 676

        //flatMap

        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(m ->
                m.stream())
                .forEach(System.out::println);

        List<List<String>> list = List.of(List.of("ankara","izmir"),List.of("istanbu","antalya"));
        //list.stream().flatMap(e->e.stream()).forEach(System.out::println);
        //list.stream().forEach(System.out::println);

        Stream<String> s1 =Stream.of("ankara","istanbul");
        Stream<String> s2 = Stream.of("izmir","muğla");
        Stream s3=Stream.concat(s1,s2);
        s3.forEach(System.out::println);



    }
}
