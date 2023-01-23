package Basics;

import java.util.Arrays;
import java.util.Optional;

public class EnumTest {
    public static void main(String[] args) {
        Car [] result = Car.values();
        Optional<Car> re= Arrays.stream(result).filter(e->e.name().equals("BMW")).findFirst();
        re.ifPresent(System.out::println);

    }
}
