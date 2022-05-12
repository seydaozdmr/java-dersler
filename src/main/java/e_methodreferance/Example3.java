package e_methodreferance;

import java.util.function.Function;

public class Example3 {
    public static int alan(int x){
        return x*x;
    }

    public static void main(String[] args) {
        //eğer static ise [sınıf ismi]::[method ismi]
        Function<Integer,Integer> myFunction=(x)->x*x;
        System.out.println(myFunction.apply(11));

        Function<Integer,Integer> classFunction= Example3::alan;

        System.out.println(classFunction.apply(10));


//        Supplier<String> myString=String::new;
//        Supplier<String> test=()->new String();
//        Supplier<Example3> test2=Example3::new;
//        Example3 example3= test2.get();

    }

}
