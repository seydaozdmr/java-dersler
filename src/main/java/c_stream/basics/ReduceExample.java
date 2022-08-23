package c_stream.basics;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceExample {
    public static void main(String[] args) {
        List<String> list=List.of("A","B","C","D");

        String result = list.stream()
                .reduce("", (a,b)->a.concat(b));
        System.out.println(result);


        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty.reduce((a, b) -> a * b).ifPresent(System.out::println); // no output
        oneElement.reduce(op).ifPresent(System.out::println); // 3
        threeElements.reduce(op).ifPresent(System.out::println); // 90

        Stream<Integer> nums=Stream.of(1,2,3,4,5);
        Integer multi =nums
                .filter(e-> e>5 )
                .reduce(1,(a,b)->a*b);
        System.out.println(multi);


        Stream<String> stream = Stream.of("w", "o", "l", "f!");
        int length = stream.reduce(0, (i, s) -> i+s.length(), (a, b) -> a+b);
        System.out.println(length); // 5

    }
}
