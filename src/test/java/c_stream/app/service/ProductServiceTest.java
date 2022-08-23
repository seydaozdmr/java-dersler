package c_stream.app.service;

import c_stream.app.model.Category;
import c_stream.app.model.Company;
import c_stream.app.model.ProducedCountry;
import c_stream.app.model.Product;
import c_stream.app.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class ProductServiceTest {

    List<Product> list;

    @Mock
    ProductService service;
    @BeforeEach
    void setUp() {
        list=new ProductRepository().getProducts();
        service=new ProductService();
    }

    @Test
    void findNamesOfAllProducts() {
        int result = service.findNamesOfAllProducts().size();
        Assertions.assertEquals(21,result);
    }

    @Test
    void findNamesOfAllProductsToString() {
        Assertions.assertEquals("Gofret,Çikolatalı Gofret,Eti Cin,Sütlü Çikolata,Bitter Çikolata,Kremalı Bisküvi,Albeni,CocoStar,Dido,Çokokrem,Hobby,Biskrem,Çokomel,Kola,Fanta,Sprite,Dan Kek,Domestos,Cif,Bulaşık Tableti,Çamaşır Deterjanı",service.findNamesOfAllProductsToString());
    }

//    @Test
//    void getNamesOfCompanyProducts() {
//        Company test=new Company(UUID.randomUUID().toString(),"asd");
//        Product p1=new Product(UUID.randomUUID().toString()
//                , BigDecimal.valueOf(10)
//                ,"gofret"
//                , LocalDate.of(2022,12,23)
//                , test , new Category(UUID.randomUUID().toString(),"atıştırma"), ProducedCountry.UK,null);
//
//
//        Mockito.when(service.getNamesOfCompanyProducts(any(Company.class))).thenReturn(List.of(p1.getName()));
//
//        List<String> elems=service.getNamesOfCompanyProducts(test);
//        Assertions.assertEquals(1,elems.size());
//    }

    @Test
    void getProductsByCategory() {
    }

    @Test
    void getProductsByNotExistCategory() {
    }

    @Test
    void getProductsCompanyWithPrice() {
    }

    @Test
    void companiesProductsAnyMatchCategory() {
    }

    @Test
    void countWafers() {
    }

    @Test
    void findCompanyProducts() {
    }

    @Test
    void countAllProductsByDrink(){
        long count = service.countAllProductsByCategory(new Category(UUID.randomUUID().toString(),"İçecek"));
        Assertions.assertEquals(3,count);
    }
}