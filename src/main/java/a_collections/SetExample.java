package a_collections;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set example=new TreeSet();
        example.add(1);
        example.add(2);
        example.add(3);

        Iterator iterator= example.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Map<String,String> identity=new IdentityHashMap<>();
        identity.put(new String("a"),"alanya");
        identity.put(new String("a"),"almanya");
        System.out.println(identity);

        Map<String,String> hashMap=new HashMap<>();
        hashMap.put(new String("a"),"alanya");
        hashMap.put(new String("a"),"almanya");
        System.out.println(hashMap);
    }
}
