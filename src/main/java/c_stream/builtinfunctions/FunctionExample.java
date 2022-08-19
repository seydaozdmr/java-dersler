package c_stream.builtinfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String,Integer> function=String::length;
        System.out.println(function.apply("ankara"));




        BiFunction<String,String,String> concat=String::concat;
        System.out.println(concat.apply("ank","ara"));

        BiFunction<String,String,Integer> length=(a,b)->a.length()+b.length();
        System.out.println(length.apply("ankara","istanbul"));


    }


}
