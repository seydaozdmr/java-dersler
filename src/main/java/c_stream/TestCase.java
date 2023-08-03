package c_stream;

import j_oop.basics.C;

import java.util.Comparator;
import java.util.List;

public class TestCase {
    public static void main(String[] args) {
        List<Country> elems = List.of(new Country("Türkiye",88000000,578000),new Country("Yunan",15000,120000),new Country("Amerika",300000000,2600000));
        Country c = elems.stream().max(Comparator.comparingInt(e->e.area/e.population)).get();
        System.out.println(c.name);
    }
}

class Country{

    String name;
    Integer population;
    Integer area;

    public Country(String name, Integer population, Integer area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }
}
