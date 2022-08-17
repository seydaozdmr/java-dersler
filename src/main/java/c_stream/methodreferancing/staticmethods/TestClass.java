package c_stream.methodreferancing.staticmethods;

public class TestClass {
    public static void main(String[] args) {
        Convert convert=Math::round;
        System.out.println(convert.round(100.1));

        Convert convertFromCallConverter=CallConverter::round;
        System.out.println(convertFromCallConverter.round(100.2));

        testRounder(100.2,CallConverter::round);
    }

    private static void testRounder(double num,Convert convert){
        System.out.println(convert.round(num));
    }
}
