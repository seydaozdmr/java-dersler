package a_collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceAllExample {
    public static void main(String[] args) {
        UnaryOperator<String> upperCase=String::toUpperCase;
        List<String> elems= Arrays.asList("ankara","izmir","istanbul");
        elems.replaceAll(upperCase);
        elems.forEach(System.out::println);
    }
}
