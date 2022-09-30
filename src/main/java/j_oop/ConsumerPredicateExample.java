package j_oop;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class ConsumerPredicateExample {

    static IntPredicate oddNumberPredicate = e -> e%2==0;
    static IntConsumer printValues = System.out::println;

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        Values values = new Values(nums);
        values.setSelector(oddNumberPredicate);
        values.setConsumer(printValues);
        values.print();
        values.setSelector(e->e%3==0);
        values.print();



    }
    static class Values{
        private int [] values;
        private IntPredicate selector;
        private IntConsumer consumer;

        public Values(int[] values) {
            this.values = values;
        }

        public void setSelector(IntPredicate selector){
            this.selector=selector;
        }

        public void setConsumer(IntConsumer consumer) {
            this.consumer = consumer;
        }

        public int sum(){
            return Arrays.stream(values)
                    .filter(selector)
                    .sum();
        }
        public void print(){
            consumer.accept(sum());
        }


    }
}
