package c_stream.basics;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortExample {

    public static void main(String[] args) {
        /**
         * public Stream<T> sorted()
         * public Stream<T> sorted(Comparator<? super T> comparator)
         */

        Stream<String> s = Stream.of("brown-", "bear-");
        s.sorted()
                .forEach(System.out::print); // bear-brown-

        System.out.println();

        Stream<String> s1 = Stream.of("brown bear-",
                "grizzly-");
        s1.sorted(Comparator.reverseOrder())
                .forEach(System.out::print); // grizzly-brown bear-
    }
}
