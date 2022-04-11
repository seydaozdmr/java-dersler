package c_stream;

import java.util.List;
import java.util.stream.Stream;

public class Stream_giris {
    public static void main(String[] args) {
        //Stream bir dizi datayı,veriyi ifade eder.

        //collection , array, i/o kanal (dosyadan veri okuma)
        Stream<Integer> stream=Stream.of(1,2,3,4,5,6,7,8);
        //source
        //intermediate operations
        //result (terminal)
        stream.forEach(System.out::println);
        //stream.forEach((e)-> System.out.println(e));

        Stream<String> states=Stream.of("ankara","izmir","antalya","kayseri");
        states.filter(e-> e.startsWith("a")).forEach(System.out::println);


        Integer[] arr=new Integer[]{1,2,3,4,5,6,7};
        Stream<Integer> arrStream=Stream.of(arr);
        arrStream.limit(2).forEach(System.out::println);


        List<Integer> listOfNums=List.of(1,2,3,4,5,6,7,8,9);
        Stream<Integer> listOfStream=listOfNums.stream();
        listOfStream.map(String::valueOf).forEach(System.out::println);





    }
}
