package c_stream.methodreferancing.instancemethod;

public class Test {
    public static void main(String[] args) {
        String name="asd";
        StringChecker checker=name::isEmpty;
        name.isEmpty();
        StringChecker ch2= () -> name.startsWith("a");

        StringStart stringStart = name::startsWith;
        stringStart.starW("a");

    }
}
