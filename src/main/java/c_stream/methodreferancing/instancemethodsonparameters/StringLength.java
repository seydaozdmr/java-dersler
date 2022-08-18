package c_stream.methodreferancing.instancemethodsonparameters;

public class StringLength {
    interface SayLength{
        int length(String elem);
    }

    public static void main(String[] args) {
        SayLength sayLength=String::length;
        System.out.println(sayLength.length("ankara"));
    }
}
