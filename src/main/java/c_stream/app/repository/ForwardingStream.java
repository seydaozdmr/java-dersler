package c_stream.app.repository;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.*;

public interface ForwardingStream <T> extends Stream<T> {
    Stream<T> getStream();

    @Override
    default Stream<T> filter(Predicate<? super T> predicate) {
        return getStream().filter(predicate);
    }

    @Override
    default  <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return getStream().map(mapper);
    }

    @Override
    default IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return getStream().mapToInt(mapper);
    }

    @Override
    default LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return getStream().mapToLong(mapper);
    }

    @Override
    default DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return getStream().mapToDouble(mapper);
    }

    @Override
    default  <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return getStream().flatMap(mapper);
    }

    @Override
    default IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return getStream().flatMapToInt(mapper);
    }

    @Override
    default LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return getStream().flatMapToLong(mapper);
    }

    @Override
    default DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return getStream().flatMapToDouble(mapper);
    }

    @Override
    default Stream<T> distinct() {
        return getStream().distinct();
    }

    @Override
    default Stream<T> sorted() {
        return getStream().sorted();
    }

    @Override
    default Stream<T> sorted(Comparator<? super T> comparator) {
        return getStream().sorted(comparator);
    }

    @Override
    default Stream<T> peek(Consumer<? super T> action) {
        return getStream().peek(action);
    }

    @Override
    default Stream<T> limit(long maxSize) {
        return getStream().limit(maxSize);
    }

    @Override
    default Stream<T> skip(long n) {
        return getStream().skip(n);
    }

    @Override
    default Stream<T> takeWhile(Predicate<? super T> predicate) {
        return getStream().takeWhile(predicate);
    }

    @Override
    default Stream<T> dropWhile(Predicate<? super T> predicate) {
        return getStream().dropWhile(predicate);
    }

    @Override
    default void forEach(Consumer<? super T> action) {
        getStream().forEach(action);
    }

    @Override
    default void forEachOrdered(Consumer<? super T> action) {
        getStream().forEachOrdered(action);
    }

    @Override
    default Object[] toArray() {
        return getStream().toArray();
    }

    @Override
    default  <A> A[] toArray(IntFunction<A[]> generator) {
        return getStream().toArray(generator);
    }

    @Override
    default T reduce(T identity, BinaryOperator<T> accumulator) {
        return getStream().reduce(identity, accumulator);
    }

    @Override
    default Optional<T> reduce(BinaryOperator<T> accumulator) {
        return getStream().reduce(accumulator);
    }

    @Override
    default  <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return getStream().reduce(identity, accumulator, combiner);
    }

    @Override
    default  <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return getStream().collect(supplier, accumulator, combiner);
    }

    @Override
    default  <R, A> R collect(Collector<? super T, A, R> collector) {
        return getStream().collect(collector);
    }

    @Override
    default Optional<T> min(Comparator<? super T> comparator) {
        return getStream().min(comparator);
    }

    @Override
    default Optional<T> max(Comparator<? super T> comparator) {
        return getStream().max(comparator);
    }

    @Override
   default long count() {
        return getStream().count();
    }

    @Override
    default boolean anyMatch(Predicate<? super T> predicate) {
        return getStream().anyMatch(predicate);
    }

    @Override
    default boolean allMatch(Predicate<? super T> predicate) {
        return getStream().allMatch(predicate);
    }

    @Override
   default boolean noneMatch(Predicate<? super T> predicate) {
        return getStream().noneMatch(predicate);
    }

    @Override
    default Optional<T> findFirst() {
        return getStream().findFirst();
    }

    @Override
    default Optional<T> findAny() {
        return getStream().findAny();
    }

    public static <T1> Builder<T1> builder() {
        return Stream.builder();
    }

    public static <T1> Stream<T1> empty() {
        return Stream.empty();
    }

    public static <T1> Stream<T1> of(T1 t1) {
        return Stream.of(t1);
    }

    public static <T1> Stream<T1> ofNullable(T1 t1) {
        return Stream.ofNullable(t1);
    }

    @SafeVarargs
    public static <T1> Stream<T1> of(T1... values) {
        return Stream.of(values);
    }

    public static <T1> Stream<T1> iterate(T1 seed, UnaryOperator<T1> f) {
        return Stream.iterate(seed, f);
    }

    public static <T1> Stream<T1> iterate(T1 seed, Predicate<? super T1> hasNext, UnaryOperator<T1> next) {
        return Stream.iterate(seed, hasNext, next);
    }

    public static <T1> Stream<T1> generate(Supplier<? extends T1> s) {
        return Stream.generate(s);
    }

    public static <T1> Stream<T1> concat(Stream<? extends T1> a, Stream<? extends T1> b) {
        return Stream.concat(a, b);
    }

    @Override
    default Iterator<T> iterator() {
        return getStream().iterator();
    }

    @Override
    default Spliterator<T> spliterator() {
        return getStream().spliterator();
    }

    @Override
    default boolean isParallel() {
        return getStream().isParallel();
    }

    @Override
    default Stream<T> sequential() {
        return getStream().sequential();
    }

    @Override
    default Stream<T> parallel() {
        return getStream().parallel();
    }

    @Override
    default Stream<T> unordered() {
        return getStream().unordered();
    }

    @Override
    default Stream<T> onClose(Runnable closeHandler) {
        return getStream().onClose(closeHandler);
    }

    @Override
    default void close() {
        getStream().close();
    }
}
