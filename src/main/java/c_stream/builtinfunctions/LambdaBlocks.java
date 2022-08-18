package c_stream.builtinfunctions;

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
