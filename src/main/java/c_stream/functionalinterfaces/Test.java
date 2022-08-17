package c_stream.functionalinterfaces;

public class Test {
    public static void main(String[] args) {
        Sprint runner = a-> System.out.println(a);
        runner.sprint(200);

        Tiger tiger=new Tiger();
        tiger.sprint(100);


    }
}
