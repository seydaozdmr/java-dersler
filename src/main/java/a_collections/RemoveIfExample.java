package a_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RemoveIfExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        list.add("Actor");
        list.add("A");

        System.out.println(list); // [Magician, Assistant]
        String a="Ankara";
        //list.removeIf(s -> s.startsWith("A"));
        list.removeIf(a::startsWith);

        System.out.println(list); // [Magician]
    }
}
