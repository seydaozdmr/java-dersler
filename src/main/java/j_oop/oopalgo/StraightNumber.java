package j_oop.oopalgo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StraightNumber {
    private int value;

    public StraightNumber(int value) {
        this.value = value;
    }

    public NumberStream digitsFromLeastSignificant(){
        return NumberStream.of(Stream.iterate(value,n->n/10)
                .takeWhile(e->e>0)
                .map(n->n%10));
    }

    public NumberStream digitsFromMostSignificant(){
        List<Integer> list= digitsFromLeastSignificant().collect(Collectors.toList());
        Collections.reverse(list);
        return NumberStream.of(list.stream());
    }

    public StraightNumber modulo(int divisor){
        return new StraightNumber(this.value % divisor);
    }

    public int asDigitOr(int substitute){
        return this.value<10 ? this.value : substitute;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int asDigit() {
        if (this.value >= 10) throw new IllegalStateException();
        return value;
    }
}
