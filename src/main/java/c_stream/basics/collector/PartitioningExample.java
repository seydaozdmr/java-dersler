package c_stream.basics.collector;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningExample {
    public static void main(String[] args) {
        var stream2 = Stream.of("lions", "tigers", "bears","sd","fsd","dasfsdaf","lions");
        Map<Boolean, Set<String>> map=stream2.collect(Collectors.partitioningBy(a->a.length()>5, Collectors.toSet()));

//        Map<Boolean,List<String>> newMap=stream2.collect(Collectors.groupingBy(a->a.length()>5));
        System.out.println(map);
    }
}
