package a_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {
    public static void main(String[] args) {
        List<String> failFast=new ArrayList<>();
        failFast.add("1");
        failFast.add("2");

        Iterator<String> iterator=failFast.iterator();
        while(iterator.hasNext()){
            String elem=iterator.next();
            System.out.println(elem);
            //failFast.add("3");
        }

        List<String> failSafe=new CopyOnWriteArrayList<>();
        failSafe.add("1");
        failSafe.add("2");
        Iterator<String> iterator1=failSafe.iterator();
        while (iterator1.hasNext()){
            String elem=iterator1.next();
            System.out.println(elem);
            failSafe.add("3");
        }

    }
}
