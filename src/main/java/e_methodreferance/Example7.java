package e_methodreferance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Example7 {
    //sınıfa ait predicate
    public static boolean myPredicate2(int e){
        return e>5;
    }
    static Predicate<Integer> myPredicate1=(Integer e)->e>3;

    public static void writeAfterFive(List<Integer> myList, Predicate<Integer> predicate){
        myList.stream().filter(predicate).forEach(System.out::println);
    }

    private static String toS(Integer a){
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        List<Integer> myList=List.of(1,2,3,4,5,6,7,8,9);
//        writeAfterFive(myList, (e)->e>5 );

        myList.stream().filter(Example7::myPredicate2).forEach(System.out::println);
        myList.stream().filter(e-> e > 10);
        List<Integer> myTemp=new ArrayList<>();
        for(Integer e:myList){
            if(e>5){
                myTemp.add(e);
                System.out.println(e);
            }
        }
        //myList.stream().map(String::valueOf).collect(Collectors.toList()).forEach(System.out::println);

//        System.out.println("predicate");
//        writeAfterFive(myList,Example7::myPredicate);
//
//        System.out.println("Sınıfa ait predicate");




        //consumer:
//        myList.forEach(System.out::println);

    }


    public static boolean myPredicate(Integer e){
        return e>8;
    }


}

