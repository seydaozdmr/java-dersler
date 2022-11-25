package j_oop.oopalgo;

import java.util.function.Function;

public class PonderingModuloAlgorithm implements ControlDigitAlgorithm {

    private Function<StraightNumber,NumberStream> digitExtractor;
    private int [] factors;
    private Function<StraightNumber,Integer> reduce;

    private PonderingModuloAlgorithm(Function<StraightNumber, NumberStream> digitExtractor, int[] factors,Function<StraightNumber,Integer> reduce) {
        this.digitExtractor = digitExtractor;
        this.factors=factors;
        this.reduce=reduce;
    }

    public static ControlDigitAlgorithm multipleDigitsModulo(
            Function<StraightNumber,NumberStream> digitsExtractor,
            int divisor, int substitute, int...factors
    ){
        return new PonderingModuloAlgorithm(digitsExtractor,factors,n->n.modulo(divisor).asDigitOr(substitute));
    }

    public static ControlDigitAlgorithm singleDigitsModulo(
            Function<StraightNumber,NumberStream> digitsExtractor,
            int divisor, int...factors
    ){
        return new PonderingModuloAlgorithm(digitsExtractor,factors,n->n.modulo(divisor).asDigit());
    }



    @Override
    public int getControlDigit(StraightNumber straightNumber) {
        return this.reduce.apply(digitExtractor.apply(straightNumber)
                .multiplyWith(this.factors));

    }


}
