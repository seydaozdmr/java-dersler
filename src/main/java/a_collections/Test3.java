package a_collections;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"Ali");
        map.put(2,"Mehmet");
        map.put(3,"Ahmet");
        map.put(4,"Hasan");
        map.put(4,"hüseyin");
        System.out.println(map);


        for (Map.Entry eleman: map.entrySet()) {
            System.out.println(eleman.getKey()+" "+eleman.getValue());
        }



    }
}
