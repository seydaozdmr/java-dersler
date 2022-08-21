package a_collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

public class MergingDataToMap {

    public static void main(String[] args) {
        //Bifunction da olabilir
        BinaryOperator<String> compareLength= (a1,a2)->a1.length()>a2.length() ? a1:a2;

        Map<String,String> myMap=new HashMap<>();
        myMap.put("ali","yılmaz");
        myMap.put("hasan","özdemir");
        myMap.put("mehmet","öz");

        myMap.merge("mehmet","Yıldırım",compareLength);
        System.out.println(myMap);


        List<String> cities=List.of("ankara","istanbul","izmir","istanbul","izmir","amtalya");
        var cityMap=new HashMap<String,Integer>();
        for(String elem:cities){
            cityMap.merge(elem,1,Integer::sum);
        }
        System.out.println(cityMap);

    }
}
