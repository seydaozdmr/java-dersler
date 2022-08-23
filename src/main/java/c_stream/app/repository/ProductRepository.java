package c_stream.app.repository;

import c_stream.app.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepository {
    private List<Product> products;

    {
        Company cola = new Company(UUID.randomUUID().toString(),"Cocacola");
        Company ulker = new Company(UUID.randomUUID().toString(),"Ülker");
        Company johnAndJohns=new Company(UUID.randomUUID().toString(),"JohnsonAndJohnson");
        Company eti = new Company(UUID.randomUUID().toString(),"Eti");

        Category drinks=new Category(UUID.randomUUID().toString(),"İçecek");
        Category biscuit=new Category(UUID.randomUUID().toString(),"Bisküvi");
        Category chocolate=new Category(UUID.randomUUID().toString(),"Çikolata");
        Category wafer =new Category(UUID.randomUUID().toString(),"Gofret");
        Category cleaning=new Category(UUID.randomUUID().toString(),"Temizlik");
        products=new ArrayList<>();

        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(10.10),"Gofret", LocalDate.of(2022,10,30),ulker,wafer,
                ProducedCountry.TURKEY,List.of(new Ingredient("Fındık"),new Ingredient("Şeker"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(15.25),"Çikolatalı Gofret", LocalDate.of(2023,10,30),eti,wafer,
                ProducedCountry.TURKEY,List.of(new Ingredient("Fındık"),new Ingredient("Şeker"),new Ingredient("Çikolata"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(6.10),"Eti Cin", LocalDate.of(2022,9,10),eti,biscuit,
                ProducedCountry.TURKEY,List.of(new Ingredient("Un"),new Ingredient("Şeker"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(20.0),"Sütlü Çikolata", LocalDate.of(2023,1,30),ulker,chocolate,
                ProducedCountry.FR,List.of(new Ingredient("Süt"),new Ingredient("Şeker"),new Ingredient("Çikolata"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(18.50),"Bitter Çikolata", LocalDate.of(2023,2,16),ulker,chocolate,
                ProducedCountry.TURKEY,List.of(new Ingredient("Çikolata"),new Ingredient("Şeker"),new Ingredient("Kakao"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(4.25),"Kremalı Bisküvi", LocalDate.of(2022,12,30),eti,biscuit,
                ProducedCountry.USA,List.of(new Ingredient("Süt"),new Ingredient("Şeker"),new Ingredient("Un"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(7.70),"Albeni", LocalDate.of(2023,5,30),ulker,wafer,
                ProducedCountry.TURKEY,List.of(new Ingredient("Süt"),new Ingredient("Şeker"),new Ingredient("Karamel"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(5.15),"CocoStar", LocalDate.of(2022,9,30),ulker,wafer,
                ProducedCountry.UK,List.of(new Ingredient("Hindistan Cevizi"),new Ingredient("Şeker"),new Ingredient("Çikolata"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(8.80),"Dido", LocalDate.of(2023,3,30),eti,wafer,
                ProducedCountry.TURKEY,List.of(new Ingredient("Süt"),new Ingredient("Şeker"),new Ingredient("Fıstık"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(35.10),"Çokokrem", LocalDate.of(2023,12,30),ulker,chocolate,
                ProducedCountry.TURKEY,List.of(new Ingredient("Fındık"),new Ingredient("Şeker"),new Ingredient("Kakao"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(25.10),"Hobby", LocalDate.of(2023,8,30),ulker,chocolate,
                ProducedCountry.TURKEY,List.of(new Ingredient("Fındık"),new Ingredient("Şeker"),new Ingredient("Kakao"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(17.10),"Biskrem", LocalDate.of(2023,2,16),eti,biscuit,
                ProducedCountry.UK,List.of(new Ingredient("Fındık"),new Ingredient("Şeker"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(5.0),"Çokomel", LocalDate.of(2022,9,30),ulker,chocolate,
                ProducedCountry.TURKEY,List.of(new Ingredient("Fındık"),new Ingredient("Şeker"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(17.0),"Kola", LocalDate.of(2023,1,30),cola,drinks,
                ProducedCountry.FR,List.of(new Ingredient("Su"),new Ingredient("Şeker"),new Ingredient("Meyan"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(14.33),"Fanta", LocalDate.of(2022,12,30),cola,drinks,
                ProducedCountry.USA,List.of(new Ingredient("Su"),new Ingredient("Şeker"),new Ingredient("Portakal"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(13.13),"Sprite", LocalDate.of(2023,3,30),cola,drinks,
                ProducedCountry.TURKEY,List.of(new Ingredient("Su"),new Ingredient("Şeker"),new Ingredient("Limon"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(10.0),"Dan Kek", LocalDate.of(2022,12,30),ulker,wafer,
                ProducedCountry.TURKEY,List.of(new Ingredient("Fındık"),new Ingredient("Şeker"),new Ingredient("Un"),new Ingredient("Kabartma Tozu"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(40.10),"Domestos", LocalDate.of(2024,10,30),johnAndJohns,cleaning,
                ProducedCountry.TURKEY,List.of(new Ingredient("Sodyum Hipoklorit"),new Ingredient("Sürfaktanlar"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(20.20),"Cif", LocalDate.of(2025,10,30),johnAndJohns,cleaning,
                ProducedCountry.TURKEY,List.of(new Ingredient("Sodium Hydroxide"),new Ingredient("Dimethicone"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(50.0),"Bulaşık Tableti", LocalDate.of(2024,10,30),johnAndJohns,cleaning,
                ProducedCountry.UK,List.of(new Ingredient("Sodyum Perokside"),new Ingredient("Dimethicone"))));
        products.add(new Product(UUID.randomUUID().toString(),
                BigDecimal.valueOf(55.0),"Çamaşır Deterjanı", LocalDate.of(2025,10,30),ulker,wafer,
                ProducedCountry.FR,List.of(new Ingredient("Sodyum Perokside"),new Ingredient("Dimethicone"))));
    }

    public List<Product> getProducts() {
        return products;
    }

}
