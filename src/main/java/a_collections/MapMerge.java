package a_collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMerge {
    public static void main(String[] args) {
        Map<String,Integer> frequencyOfCites=new HashMap<>();
        List<String> cities = List.of("Ankara","İzmir","Antalya","İstanbul","İstanbul","Ankara","İzmit","İzmir","İstanbul","İstanbul");

        for (String city : cities) {
            //city'nin value'sini eğer yoksa 1 yap, varsa değere 1 ekle...
            frequencyOfCites.merge(city,1, (k, v)-> k+1);
        }
        System.out.println(frequencyOfCites);
    }
}
