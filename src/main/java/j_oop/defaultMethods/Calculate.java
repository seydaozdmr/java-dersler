package j_oop.defaultMethods;

import java.io.IOException;

public class Calculate {

    public int pow(int a) throws IllegalArgumentException{
        return  a * a;
    }

    private String pow(int a, int b) throws NullPointerException{
        for(int i=0;i<b;i++){
            a = a * a;
        }
        return String.valueOf(a);
    }

    protected Number add ( int a ,int b) throws IOException {
        return a+b;
    }
}
