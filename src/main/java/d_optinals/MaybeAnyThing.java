package d_optinals;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaybeAnyThing {
    private static abstract class Maybe<T> {
        public abstract <TResult> Maybe<TResult> map (Function<T,TResult> transform);
        public abstract <TResult> Maybe<TResult> flatMap(Function<T,Maybe<TResult>> transform);
        public abstract T orElse(T substitute);
        public abstract boolean isPresent();
        public abstract T get();
    }

    private static class Some<T> extends Maybe<T> {
        private T content;

        public Some(T content) {
            this.content = content;
        }

        @Override
        public <TResult> Maybe<TResult> map(Function<T, TResult> transform) {
            return new Some(transform.apply(content));
        }

        @Override
        public <TResult> Maybe<TResult> flatMap(Function<T, Maybe<TResult>> transform) {
            return transform.apply(content);
        }

        @Override
        public T orElse(T substitute) {
            return this.content;
        }

        @Override
        public boolean isPresent() {
            return true;
        }

        @Override
        public T get() {
            return this.content;
        }
    }

    private static class None<T> extends Maybe<T>{

        @Override
        public <TResult> Maybe<TResult> map(Function<T, TResult> transform) {
            return new None<>();
        }

        @Override
        public <TResult> Maybe<TResult> flatMap(Function<T, Maybe<TResult>> transform) {
            return new None<>();
        }

        @Override
        public T orElse(T substitute) {
            return substitute;
        }

        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public T get() {
            throw new IllegalStateException("there is no element in None");
        }
    }
    private void display(Maybe<String> value){
        System.out.println(value.map(String::toUpperCase).orElse("Nothing to show!"));
    }

    private void displayAsSquare(Maybe<String> value){
        System.out.println();
        this.display(this.toSquare(value));
    }

    private Maybe<String> toSquare(Maybe<String> value){
        return value.flatMap(this::toSquare);
    }

    private Maybe<String> toSquare(String value){
        return this.trySqrt(value.length())
                .map(colums->this.toMatrix(value,(int) Math.ceil(colums)));
    }

    private Maybe<Double> trySqrt(int value){
        return value<0?new None<Double>()
                :new Some<>(Math.sqrt((double)value));
    }

    private String toMatrix(String value ,int colums){
        return this.toMatrix(value,colums,(value.length() +colums-1)/colums);
    }

    private String toMatrix(String value,int colums,int rows){
        return IntStream.range(0,rows).map(row->row*colums)
                .mapToObj(startIndex-> value.substring(startIndex,Math.min(startIndex+colums,value.length())) )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static void main(String[] args) {
        MaybeAnyThing maybeAnyThing=new MaybeAnyThing();
        maybeAnyThing.displayAsSquare(new Some<>("TEST CONTENT"));
        maybeAnyThing.displayAsSquare(new Some<>("MEHMET BERKAN GÖRAL"));
        System.out.println(Math.sqrt((double)18));
        System.out.println((int) Math.ceil(Math.sqrt((double)18)));
    }
}
