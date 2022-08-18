package c_stream.builtinfunctions.primitives;

import java.util.function.DoubleFunction;

public class DoubleFunctionExample {
    public static void main(String[] args) {
        DoubleFunction<String> test = String::valueOf;

        System.out.println(test.apply(10.19));
        System.out.println(test.apply(20.21).length());
    }
}
