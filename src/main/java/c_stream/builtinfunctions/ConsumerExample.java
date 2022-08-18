package c_stream.builtinfunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> elem=new ArrayList<>();
        Consumer<String> addElement=elem::add;
        addElement.accept("ankara");
        addElement.accept("izmir");
        //parametre alan ve void olan tüm methodlarda kullanılabilir

        Map<String,Integer> myMap=new HashMap<>();
        BiConsumer<String,Integer> addElements=myMap::put;
        addElements.accept("ankara","ankara".length());



    }
}
