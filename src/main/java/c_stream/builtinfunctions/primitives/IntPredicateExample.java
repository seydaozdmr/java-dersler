package c_stream.builtinfunctions.primitives;

import java.util.function.IntPredicate;

public class IntPredicateExample {
    public static void main(String[] args) {
        IntPredicate intPredicate=(a)->a>5;

        System.out.println(intPredicate.test(10));
    }
}
