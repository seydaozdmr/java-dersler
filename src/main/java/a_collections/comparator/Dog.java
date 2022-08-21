package a_collections.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dog implements Comparable<Dog>{

    private String name;
    private double weight;

    public Dog(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Dog o) {
        if (o == null)
            throw new IllegalArgumentException("Poorly formed dog!");
        if (this.name == null && o.name == null)
            return 0;
        else if (this.name == null) return -1;
        else if (o.name == null) return 1;
        else return name.compareTo(o.name);
    }

    public static void main(String[] args) {
        List<Dog> dogs= Arrays.asList(new Dog("Lessie", 10.12), new Dog("Çomar", 5.56)
                , new Dog("Garip", 12.12), new Dog("Hellim", 3.32));

        Collections.sort(dogs);
        dogs.forEach(System.out::println);

        Collections.sort(dogs,(d1,d2)->(int)d1.getWeight()-(int)d2.getWeight());
        dogs.forEach(System.out::println);

        Collections.sort(dogs, Comparator.comparing(Dog::getWeight).reversed());
        dogs.forEach(System.out::println);
    }
}
