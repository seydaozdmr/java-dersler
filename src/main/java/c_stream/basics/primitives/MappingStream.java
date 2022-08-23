package c_stream.basics.primitives;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingStream {
    public static void main(String[] args) {
        Stream<Integer> stream=Stream.of(1,2,3,4,5,6);
        IntStream intStream=stream.mapToInt(x->x); //parametre olarak intFunction alıyor.
        System.out.println(intStream.count());

        //intStream.mapToObj(x-> x); //boxed()

        List<Integer> list=List.of(1,2,3,4,5,6);
        IntStream intStream1=list.stream()
                .flatMapToInt(x->IntStream.of(x));
        intStream1.forEach(System.out::println);

    }
}
