package c_stream.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder word = stream.collect(()->new StringBuilder(),
                (a,b)->a.append(b),
                (a,b)->a.append(b));
        System.out.println(word);

        Stream<String> stream0 = Stream.of("ankara","istanbul","izmir","antalya");
        Map<String,Integer> collectStats0= stream0
                .collect(HashMap::new
                        , (a,b)-> a.put(b, b.length())
                        , Map::putAll);
        System.out.println(collectStats0);

        Stream<String> stream1 = Stream.of("ankara","istanbul","izmir","antalya","istanbul");
        Map<String,Integer> collectStats= stream1
                .collect(HashMap::new
                        , (a,b)-> a.put(b, a.merge (b,1,Integer::sum))
                        , Map::putAll);
        System.out.println(collectStats);

        /**
         * The final parameter is the combiner, which is another BiConsumer. It is responsible for
         * taking two data collections and merging them. This is useful when we are processing in
         * parallel. Two smaller collections are formed and then merged into one. This would work
         * with StringBuilder only if we didn’t care about the order of the letters. In this case, the accumulator
         * and combiner have similar logic.
         * The collector has three parts as before. The supplier creates an empty TreeSet. The accumulator
         * adds a single String from the Stream to the TreeSet. The combiner adds all of
         * the elements of one TreeSet to another in case the operations were done in parallel and
         * need to be merged.
         */


        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set =
                stream2.collect(Collectors.toCollection(TreeSet::new));

//        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
//        Set<String> set1 = stream.collect(Collectors.toSet());
//        System.out.println(set1); // [f, w, l, o]


    }
}
