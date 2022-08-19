package c_stream.builtinfunctions.primitives;

import java.util.function.IntToDoubleFunction;
import java.util.function.ToDoubleBiFunction;

public class ToDoubleBiFunctionExample {
    public static void main(String[] args) {
        ToDoubleBiFunction<String,Integer> test=(a,b)-> (double)a.length()* (double)b;


/**
 * Since lambda parameters are just like method parameters, you can add modifiers to them.
 * Specifically, you can add the final modifier or an annotation, as shown in this example:
 * public void counts(List<Integer> list) {
 * list.sort((final var x, @Deprecated var y) ->
 * x.compareTo(y));
 * }
 * While this tends to be uncommon in real life, modifiers such as these have been known to
 * appear in passing on the exam.
  */
    }
}
