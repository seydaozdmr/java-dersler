package c_stream.builtinfunctions;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        String test="ankara";
        Predicate<String> testWhetherEmptyOrNot=String::isEmpty;
        testWhetherEmptyOrNot.test("Ankara");

        Predicate<String> adsad=test::startsWith;

        Predicate<String> combineIsEmptyAndStartsWith= adsad.and(testWhetherEmptyOrNot);
        System.out.println(combineIsEmptyAndStartsWith.test("ank"));

        StringStart stringStart=s->test.startsWith(s);

        StringChecker stringChecker=()->test.isEmpty();

        BiPredicate<String,String> b1=String::startsWith;
        System.out.println(b1.test("ali","a"));

    }

    private boolean test(String r){
        return r.isEmpty();
    }

    interface StringChecker {
        boolean check();
    }
    interface StringStart {
        boolean beginningCheck(String prefix);
    }

}
