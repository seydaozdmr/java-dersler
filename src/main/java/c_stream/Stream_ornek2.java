package c_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_ornek2 {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        List<Float> productPriceList = new ArrayList<>();
        //TODO price more than 3000 will be collect
        for(Product product: productsList){
            // filtering data of list
            if(product.getPrice()<30000){
                productPriceList.add(product.getPrice());    // adding price to a productPriceList
            }
        }
        System.out.println(productPriceList);   // displaying data
        //TODO List<Float> yalnızca fiyatlarıgetPricen listesini bulalım
        List<Float> list =productsList
                .stream()
                .map(e-> e.getPrice())
                .filter(e-> e<30000)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
