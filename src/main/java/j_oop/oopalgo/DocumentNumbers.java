package j_oop.oopalgo;

public class DocumentNumbers {
    private StraightNumber raw;
    private ControlDigitAlgorithm algorithm;

    public DocumentNumbers(int raw, ControlDigitAlgorithm algorithm) {
        this.raw = new StraightNumber(raw);
        this.algorithm = algorithm;
    }

    private int getControlDigit(){
        return this.algorithm.getControlDigit(this.raw);
    }

    @Override
    public String toString() {
        return this.raw + "-" + this.getControlDigit();
    }
}
