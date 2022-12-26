package a_collections.splitMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartitionHashMap {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList("a1", "a2", "a3"));
        map.put("B", Arrays.asList("b1", "b2", "b3"));
        map.put("C", Arrays.asList("c1", "c2", "c3"));
        map.put("D", Arrays.asList("a1", "a2", "a3"));
        map.put("E", Arrays.asList("b1", "b2", "b3"));
        map.put("F", Arrays.asList("c1", "c2", "c3"));
        map.put("G", Arrays.asList("a1", "a2", "a3"));
        map.put("H", Arrays.asList("b1", "b2", "b3"));
        map.put("I", Arrays.asList("c1", "c2", "c3"));
        map.put("J", Arrays.asList("a1", "a2", "a3"));
        map.put("K", Arrays.asList("b1", "b2", "b3"));
        map.put("L", Arrays.asList("c1", "c2", "c3"));

        List<Map.Entry<String,List<String>>> entryList = new ArrayList<>(map.entrySet());

        split(entryList,2).forEach(System.out::println);
        Map<String,List<String>> result1=split(entryList,2).get(0).stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println(result1);
        List<String> name = List.of("Ali","Ali","Hasan","Hasan","Hüsayin","Hüsayin","Hüsayin");

        Map<String,Integer> result = name.stream()
                .collect(Collectors.toMap(Function.identity(),e->1,Integer::sum));
        System.out.println(result);

    }

    private static List<List<Map.Entry<String, List<String>>>> split(List<Map.Entry<String, List<String>>> entryList, int size) {
        List<List<Map.Entry<String, List<String>>>> result = new ArrayList<>();
        for (int i = 0; i < entryList.size(); i += size) {
            result.add(entryList.subList(i, Math.min(i + size, entryList.size())));
        }
        return result;
    }
}
