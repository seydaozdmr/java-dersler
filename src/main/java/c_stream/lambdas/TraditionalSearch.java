package c_stream.lambdas;

import java.util.List;

public class TraditionalSearch {
    public static void main(String[] args) {
        List<Animal> animals=List.of(new Animal("fish",false,true)
                ,new Animal("kangaroo",true,false)
                ,new Animal("rabbit",true,false)
                ,new Animal("turtle",false,true));

        printCanHop(animals);
    }
    private static void printCanHop(List<Animal> animals){
        for(Animal elem:animals){
            if(elem.isCanHop())
                System.out.println(elem);
        }
    }
}
