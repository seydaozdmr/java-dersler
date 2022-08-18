package c_stream.builtinfunctions;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinary {
    public static void main(String[] args) {
        String elem="ank";
        UnaryOperator<String> test=elem::concat;
        UnaryOperator<String> test2=(s)-> elem.concat(s);


        System.out.println(test.apply("ara"));
        BinaryOperator<String> binaryOperator=String::concat;
        System.out.println(binaryOperator.apply("ank","ara"));
        /**
         * Notice that this does the same thing as the BiFunction example. The code is more succinct,
         * which shows the importance of using the best functional interface. It’s nice to have one
         * generic type specified instead of three.
         */
    }
}
