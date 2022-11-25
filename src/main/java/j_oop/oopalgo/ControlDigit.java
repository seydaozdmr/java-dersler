package j_oop.oopalgo;

public interface ControlDigit {

    static ControlDigitAlgorithm accountingAlgorithm(){
        return PonderingModuloAlgorithm.multipleDigitsModulo(StraightNumber::digitsFromLeastSignificant,11,0,3,1);
    }

    static ControlDigitAlgorithm salesAlgorithmLegacy(){
        return PonderingModuloAlgorithm.singleDigitsModulo(StraightNumber::digitsFromMostSignificant,7,7,3,2);
    }

    static ControlDigitAlgorithm salesAlgorithmMay2017(){
        return PonderingModuloAlgorithm.singleDigitsModulo(StraightNumber::digitsFromMostSignificant,10,7,3);
    }
}
