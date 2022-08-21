package a_collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortOnList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("istanbul","ankara","izmir");

        list.sort(Comparator.comparing(String::toString));
        System.out.println(list);
    }
}
