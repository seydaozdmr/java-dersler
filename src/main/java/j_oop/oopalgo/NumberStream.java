package j_oop.oopalgo;

import com.google.common.collect.Streams;
import j_oop.app.service.ForwardingStream;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class NumberStream implements ForwardingStream<Integer> {
    private Stream<Integer> stream;


    @Override
    public Stream<Integer> getStream() {
        return this.stream;
    }

    private NumberStream (Stream<Integer> stream){
        this.stream=stream;
    }

    public static NumberStream of(Stream<Integer> stream){
        return new NumberStream(stream);
    }

    public StraightNumber multiplyWith(int... factors){
        return new StraightNumber(this.multiplyWithAsInt(factors));
    }

    private int multiplyWithAsInt(int... factors){
        return Streams.zip(getStream(),repeatEndlessly(factors),(a,b)->a*b)
                .mapToInt(n->n)
                .sum();
    }

    private Stream<Integer> repeatEndlessly(int... factors){
        return Stream.iterate(factors, UnaryOperator.identity())
                .flatMapToInt(Arrays::stream)
                .boxed();
    }
}
