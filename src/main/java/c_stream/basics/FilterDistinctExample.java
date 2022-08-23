package c_stream.basics;

import java.util.stream.Stream;

public class FilterDistinctExample {
    public static void main(String[] args) {
//        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
//        s.filter(x ->
//                x.startsWith("m"))
//                .forEach(System.out::print); // monkey
//
//        /**
//         * The distinct() method returns a stream with duplicate values removed. The duplicates do not
//         * need to be adjacent to be removed. As you might imagine, Java calls equals() to determine
//         * whether the objects are equivalent.
//         */
//        Stream<String> s1 = Stream.of("duck", "duck", "duck", "goose");
//        s1.distinct()
//                .forEach(System.out::print); // duckgoose
//
//        Stream<Integer> s2 = Stream.iterate(1, n -> n + 1);
//        s2.skip(5)
//                .limit(2)
//                .forEach(System.out::print); // 67
//
//        printFirst20DivideBy5Or7();

        Stream.iterate(0,e->e<100,i->i+1).forEach(System.out::println);
    }
    private static void printFirst20DivideBy5Or7(){
        Stream.iterate(0,n -> n+1)
                .filter(e-> e%5==0 || e%7==0)
                .limit(20)
                .forEach(System.out::println);
    }
}
