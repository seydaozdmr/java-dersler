package c_stream.methodreferancing.constructer;

import c_stream.methodreferancing.instancemethod.MyFunc;

public class MyClass<T> {

    private T val;

    public MyClass(T val) {
        this.val = val;
    }

    public MyClass(){

    }

    public T getVal(){
        return val;
    }
}
