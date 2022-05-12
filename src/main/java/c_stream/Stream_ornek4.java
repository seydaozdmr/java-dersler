package c_stream;

import java.util.ArrayList;
import java.util.List;

public class Stream_ornek4 {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        // This is more compact approach for filtering data
//        productsList.stream()
//                .filter(product -> product.getPrice() == 30000)
//                .forEach(product -> System.out.println(product.getPrice()));

//        //TODO belirli bir fiyatın altındaki ürünlerin fiyat toplamını bul predicate
//        float totalPrice2 = productsList.stream()
//                .map(product->product.getPrice())
//                .filter(e->e<30000)//içine aldığı elemanla çeşitli işlemler yapıp farklı türde döner
//                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class
//        System.out.println(totalPrice2);

        int a=10;
        int b=5;
        System.out.println(a>b ? "büyük" : "küçük");

        Product productA = productsList.stream()
                .max((p1, p2)->p1.getPrice() > p2.getPrice() ? 1 : -1)
                .get();
        System.out.println(productA);
        // min() method to get min Product price
        Product productB = productsList.stream()
                .min((product1, product2)->product1.getPrice() > product2.getPrice() ? 1: -1)
                .get();
        System.out.println(productB);

        //TODO 25000'den büyük olan ilk product
        Product c=productsList.stream()
                .filter(e->e.getPrice()>100000)
                .findFirst().get();//.orElseThrow(()-> new PriceFilterException("ürün bulunamamıstır"));
        System.out.println(c);



        // count number of products based on the filter
        long count = productsList.stream()
                .filter(product->product.getPrice()<30000)
                .count();
        System.out.println(count);

        //method referance
        //optional
    }
}
