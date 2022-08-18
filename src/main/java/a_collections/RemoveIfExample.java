package a_collections;

import java.util.ArrayList;
import java.util.Collection;

public class RemoveIfExample {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list); // [Magician, Assistant]
        String a="A";
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]
    }
}
