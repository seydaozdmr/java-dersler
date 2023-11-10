package c_stream.functions;

import java.util.function.Function;

public class  OperatorClass <T> {


    private static final String R = "asad";
    private final T T = (T) "asdasd";

    public static void main(String[] args) {

    }


    public<T,R>String operate(Function<T,R> genericFunction){

        R returnElem= genericFunction.apply((T) T);

        return R;
    }
}
