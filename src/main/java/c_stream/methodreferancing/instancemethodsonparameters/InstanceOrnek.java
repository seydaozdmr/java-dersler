package c_stream.methodreferancing.instancemethodsonparameters;

public class InstanceOrnek {

    public int length(String s){
        return s.length();
    }

    interface Test{
        int length(InstanceOrnek ornek,String s);
    }

    public static void main(String[] args) {
        Test test = InstanceOrnek::length;

        System.out.println(test.length(new InstanceOrnek(),"test"));
    }



}
