package c_stream.sort;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1,"kola",LocalDate.of(2022,5,12)));
        productList.add(new Product(2,"gofret",LocalDate.of(2023,1,12)));
        productList.add(new Product(3,"kitap",LocalDate.of(2021,9,12)));
        productList.add(new Product(4,"defter",LocalDate.of(2022,3,12)));
        productList.add(new Product(5,"kalem",LocalDate.of(2021,1,12)));
        productList.add(new Product(6,"silgi",LocalDate.of(2023,2,12)));
        productList.add(new Product(7,"çikolata",LocalDate.of(2020,6,12)));
        productList.add(new Product(8,"telefon",LocalDate.of(2019,7,12)));
        productList.add(new Product(9,"bilgisayar",LocalDate.of(2013,4,12)));
        productList.add(new Product(10,"televizyon",LocalDate.of(2022,7,12)));
    }

    public static void main(String[] args) {
        List<Product> sorted = productList.stream().sorted(Comparator.comparing(Product::getDate).reversed()).collect(Collectors.toList());
        System.out.println(sorted);
    }


    private static class Product{
        private int id;
        private String name;
        private LocalDate date;

        public Product(int id, String name, LocalDate date) {
            this.id = id;
            this.name = name;
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public LocalDate getDate() {
            return date;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", date=" + date +
                    '}';
        }
    }
}
