package c_stream.builtinfunctions.primitives;

import java.util.function.IntPredicate;

public class IntPredicateExample {
    public static void main(String[] args) {
        IntPredicate intPredicate=(a)->a>5;
        IntPredicate checkA= a -> a>18;
        System.out.println(checkA.test(22));
        System.out.println(intPredicate.test(10));
    }

    boolean checkAge(int age){
        return age>18;
    }
}
