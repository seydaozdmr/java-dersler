package j_oop.oopalgo;

public class Demo {

    public static void main(String[] args) {
        System.out.println(new DocumentNumbers(123456,ControlDigit.accountingAlgorithm()));
        System.out.println(new DocumentNumbers(123456,ControlDigit.salesAlgorithmLegacy()));
        System.out.println(new DocumentNumbers(123456,ControlDigit.salesAlgorithmMay2017()));
        //System.out.println("123456-"+getControlDigit(new StraightNumber(123456)));
    }
}
