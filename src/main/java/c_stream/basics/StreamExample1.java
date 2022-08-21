package c_stream.basics;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample1 {
    /**
     * A stream in Java is a sequence of data. A stream pipeline consists of the operations that run
     * on a stream to produce a result. First, we look at the flow of pipelines conceptually. After
     * that, we get into the code.
     */
    static Stream<Integer> nums=Stream.of(1,2,3,4,5,6);

    public static void main(String[] args) {
        nums.forEach(System.out::print);

        //infinite streams
        Stream<Double> generate=Stream.generate(Math::random);
        generate
                .filter(a->a>0.40)
                .limit(100)
                .forEach(System.out::println);

        Stream<Integer> oddNumbers=Stream.iterate(0,n->n+2);
        oddNumbers
                .limit(100)
                .forEach(System.out::println);

        Stream<String> cities=Stream.of("ankara","izmir","istanbul");
        System.out.println(cities.count());

        List<String> cityList=List.of("ankara","izmir","istanbul");

        String result =cityList.stream()
                .min(String::compareTo)
                .get();
        System.out.println(result);

        /**
         * For now, you can’t have both, at least not using these methods.
         * Remember, a stream can have only one terminal operation. Once a
         * terminal operation has been run, the stream cannot be used again.
         */
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() ->
                "chimp");
        s.findAny().ifPresent(System.out::println); // monkey (usually)
        infinite.findAny().ifPresent(System.out::println); // chimp

        var list = List.of("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() ->
                "chimp");
        Predicate<String> pred = x ->
                Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite2.anyMatch(pred)); // true

        list.forEach(x->x.substring(x.length()/2));
        list.forEach(System.out::println);

    }



}
