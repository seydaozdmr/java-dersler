package d_optinals;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Exercise_1 {
    private static Optional<Double> average(int ... scores){
        if(scores.length==0) return Optional.empty();
        int sum = Arrays.stream(scores).sum();
        return Optional.of((double)sum/scores.length);
    }

    public static void main(String[] args) {
//        Optional<String> name=Optional.of("Elma");
//        String name2 = null;
//        if(name.isPresent()){
//             name2 = name.get();
//        }
//
//        System.out.println(name2);
//
//        Optional<String> lastName=Optional.empty();
//        if(lastName.isPresent()){
//            System.out.println(lastName.get());
//        }
//
//        Optional<String> name3= Optional.empty();
//        System.out.println(name3.orElseThrow(()->new NoSuchElementException("Bu eleman yok")));
//        name3.ifPresent(elem-> System.out.println(elem));
//        //System.out.println(name3.orElseGet(()->"Veli"));
//        if(name3!=null){
//            System.out.println(name3);
//        }

        Optional<Double> opt = average(90, 100);
        if (opt.isPresent())
            System.out.println(opt.get()); // 95.0

    }
}
