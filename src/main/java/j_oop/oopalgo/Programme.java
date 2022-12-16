package j_oop.oopalgo;

import com.amazonaws.services.s3.model.CSVOutput;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Programme {

    static void sumElements(int a, int b , Predicate<Integer> condition){
        if(condition.test(a)){
            System.out.println(a+b);
        }else if(condition.test(b)){
            System.out.println(a);
        }
    }
    static void execute(int a, int b, BiFunction<Integer,Integer,Integer> function){
        System.out.println(function.apply(a,b));
    }

    public static void main(String[] args) {
        //sumElements(6,9,elem->elem%2==0);

        execute(5,10,(a,b)->a*b);


        Runnable a= () -> System.out.println("Anonim sınıf");

        print(a);

        Calculate sum1=(k,l)-> System.out.println(k+l);
        Calculate sum2 = new Calculate() {
            @Override
            public void sum(int a, int b) {
                a=a/2;
                System.out.println(a+b);
            }
        };

        System.out.println(lengthString("Ankara",(e)->e.length()));
        System.out.println(lengthString("www.test.com/asdgfsdh4yt984yt4",(e)->e
                .substring(e.indexOf('/')+1)
                .length()));

    }

    static int lengthString(String value , Function<String,Integer> length){
        return length.apply(value);
    }

    static void print(Runnable a){
        a.run();
    }

    @FunctionalInterface
    interface Calculate{
        void sum(int a,int b);
    }
}
