package c_stream.app.repository;

import c_stream.app.model.Product;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ProductStream implements ForwardingStream<Product> {
    private Stream<Product> stream;

    public ProductStream (Stream<Product> stream){
        this.stream=stream;
    }

    public Stream<Product> getStream(){
        return this.stream;
    }

    public ProductStream getExpirationBefore2023(){
        return new ProductStream(stream.filter(e->e.getExpirationDate().isBefore(LocalDate.of(2023,01,01))));
    }

    public ProductStream sortByExpirationDateThenPriceReversed(){
        return new ProductStream(stream.sorted(Comparator.comparing(Product::getExpirationDate).thenComparing(Product::getPrice).reversed()));
    }

    public Optional<Product> getMaxProduct(){
        return stream.max(Comparator.comparing(Product::getPrice));
    }



}
