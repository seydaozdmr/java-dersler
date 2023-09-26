package j_oop.defaultMethods;

import java.util.ArrayList;
import java.util.List;

public class DefaultExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");


        String[] myList = new String[100]; //->allocate

        int zero = 0;

        System.out.println(zero++); //get and increment
        System.out.println(zero);

//        for(int i=0;i<10;i++){
//            System.out.println(i);
//        }
        test();

        int test =0;

        while(test<10){
            System.out.println(test);
            test++; //parametre olarak değeri verir arttırır;
            System.out.println(test++);
        }



    }

    private static void test(){
        System.out.println(1);
        System.out.println(2);
    }
}
