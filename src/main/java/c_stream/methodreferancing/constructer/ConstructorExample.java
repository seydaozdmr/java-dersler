package c_stream.methodreferancing.constructer;

import c_stream.methodreferancing.instancemethod.MyFunc;

public class ConstructorExample {

    static <R,T> R myClassFactory(MyFuncConst<R,T> f,T v){
        return f.func(v);
    }

    public static void main(String[] args) {
        MyFuncConst<MyClass<Double>,Double> myClassCons = MyClass<Double>::new;

        MyClass<Double> myClass = myClassCons.func(10.0);

        System.out.println(myClass.getVal());

        MyFuncConst<MyClass2,String> myClass2Cons=MyClass2::new;

        MyClass2 myClass2=myClass2Cons.func("hello");

        System.out.println(myClass2.getVal());

    }
}
