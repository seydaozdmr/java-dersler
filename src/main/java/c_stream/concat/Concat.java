package c_stream.concat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concat {
    public static void main(String[] args) {
        List<String> cities = List.of("Ankara","İstanbul","İzmir","Antalya","Muğla");
        List<String> cities2= List.of("Adana","Gaziantep","Mersin","Muğla","Antalya","İzmir");

        Set<String> cities3 = Stream.concat(cities2.stream(),cities.stream()).collect(Collectors.toSet());
        cities3.forEach(System.out::println);



    }
}
