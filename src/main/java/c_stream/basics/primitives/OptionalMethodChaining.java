package c_stream.basics.primitives;

import java.util.Optional;

public class OptionalMethodChaining {
    public static void main(String[] args) {
        threeDigit(Optional.of(123));
        Optional.of(1234)
                .map(e->""+e)
                .filter(s->s.length()==4)
                .ifPresent(System.out::println);

        String elem = ""+123;

    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }
}
