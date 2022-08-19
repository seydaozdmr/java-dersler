package c_stream.builtinfunctions;

import java.util.function.Predicate;

public class LambdaBlocks {
    /**
     * Keep Your Lambdas Short
     * Having a lambda with multiple lines and a return statement is often a clue that you
     * should refactor and put that code in a method. For example, the previous example could be
     * rewritten as
     * Predicate<Integer> p1 = a ->
     * returnSame(a);
     * This simpler form can be further refactored to use a method reference:
     * Keep Your Lambdas Short
     * Having a lambda with multiple lines and a return statement is often a clue that you
     * should refactor and put that code in a method. For example, the previous example could be
     * rewritten as
     * Predicate<Integer> p1 = a ->
     * returnSame(a);
     * This simpler form can be further refactored to use a method reference:
     */
    public static void main(String[] args) {
    }
    int field=100;

     boolean testLengthGreaterThen100(int l){
        int z=5;
        Predicate<String> test=a->{
             var name="asdasd";
             int length = a.length();
             length=field+10;
             System.out.println(l);
             return length>100;
         };

         return test.test("ali");
    }

    /**
     * TABLE 8.8 Rules for accessing a variable from a lambda body inside a method
     * Variable type Rule
     * Instance variable Allowed
     * Static variable Allowed
     * Local variable Allowed if final or effectively final
     * Method parameter Allowed if final or effectively final
     * Lambda parameter Allowed
     */
}
