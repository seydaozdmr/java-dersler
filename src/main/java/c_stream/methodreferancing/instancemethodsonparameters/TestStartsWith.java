package c_stream.methodreferancing.instancemethodsonparameters;

public class TestStartsWith {
    public static void main(String[] args) {
        StartWithExample example = String::startsWith;
        System.out.println(example.test("ankara","an"));

        String name="hasan";
        name.startsWith("asldjaslşd");
    }
}
