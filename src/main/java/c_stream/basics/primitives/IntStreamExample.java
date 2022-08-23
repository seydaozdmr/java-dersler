package c_stream.basics.primitives;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {
    public static void main(String[] args) {
        IntStream intStream=IntStream.of(1,2,3,4);
        Optional<Double> avg=intStream
                .average()
                .stream()
                .mapToObj(e-> e + 10)
                .findFirst();
        System.out.println(avg);

        int sumOf3s=IntStream.iterate(0,n->n+1)
                .filter(a->a%3==0)
                .limit(20)
                .sum();
        System.out.println(sumOf3s);
        System.out.println("*****Statics*****");
        IntSummaryStatistics statistics = getStats(100);
        System.out.println("average : "+ statistics.getAverage());
        System.out.println("max : "+statistics.getMax());
        System.out.println("min : "+statistics.getMin());
        System.out.println("count : "+statistics.getCount());

        printElements(5,25);


    }

    private static IntSummaryStatistics getStats(int a){
        return IntStream.range(0,a)
                .filter(x->x%2==0)
                .summaryStatistics();

    }
    private static void printElements(int a,int b){
        IntStream.range(a,b)
                .filter(x->x%2==0)
                .forEach(System.out::println);
    }
}
