package c_stream.methodreferancing.instancemethodsonparameters;

public class TestClass {
    String value;


    public TestClass(String value) {
        this.value = value;
    }

    public TestClass() {

    }

    public boolean test(){
        return value==null;
    }
    public static void main(String[] args) {
        StringParameterChecker stringParameterChecker = String::isEmpty;
        System.out.println(stringParameterChecker.check("sad"));

        TestClass testClass=new TestClass();
        TestClassInstanceMethodCall testClassInstanceMethodCall=TestClass::test;
        testClassInstanceMethodCall.check(testClass);

    }
}
