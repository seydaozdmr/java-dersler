package c_stream.app.service;

import c_stream.app.model.Category;
import c_stream.app.model.Company;
import c_stream.app.model.ProducedCountry;
import c_stream.app.model.Product;
import c_stream.app.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


class ProductServiceTest {

    @Mock
    ProductService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findNamesOfAllProducts() {
        //when
        service.findNamesOfAllProducts();
        //then
        Mockito.verify(service).findNamesOfAllProducts();


    }

    @Test
    void findProductNotExists_thenThrownException(){
        when(service.findProduct(anyString())).thenThrow(NoSuchElementException.class);
        assertThrows(NoSuchElementException.class,()->service.findProduct("ekmek"));


    }

    @Test
    void findNamesOfAllProductsToString() {
        //given
        Product p1=new Product(UUID.randomUUID().toString()
                , BigDecimal.valueOf(10)
                ,"gofret"
                , LocalDate.of(2022,12,23)
                , null , new Category(UUID.randomUUID().toString(),"atıştırma"), ProducedCountry.UK,null);

        when(service.findNamesOfAllProducts()).thenReturn(List.of(p1.getName()));

        //when
        List<String> result = service.findNamesOfAllProducts();

        //then
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void getNamesOfCompanyProducts() {
        //given
        Company test=new Company(UUID.randomUUID().toString(),"asd");
        Product p1=new Product(UUID.randomUUID().toString()
                , BigDecimal.valueOf(10)
                ,"gofret"
                , LocalDate.of(2022,12,23)
                , test , new Category(UUID.randomUUID().toString(),"atıştırma"), ProducedCountry.UK,null);
        when(service.getNamesOfCompanyProducts(any(Company.class))).thenReturn(List.of(p1.getName()));

        //when
        List<String> elems=service.getNamesOfCompanyProducts(test);
        //then
        assertThat(elems.size()).isEqualTo(1);
    }

//    @Test
//    void getProductsByCategory() {
////        ProductService servce = mock(ProductService.class);
//        Company test=new Company(UUID.randomUUID().toString(),"asd");
//        when(service.getProductsByCategory(any(Category.class))).thenReturn(List.of(new Product(UUID.randomUUID().toString()
//                , BigDecimal.valueOf(10)
//                ,"gofret"
//                , LocalDate.of(2022,12,23)
//                , test , new Category(UUID.randomUUID().toString(),"atıştırma"), ProducedCountry.UK,null)));
////        verify(servce).getProductsByCategory(any());
//
//        int size = service.getProductsByCategory(any()).size();
//
//        assertThat(size).isEqualTo(1);
//    }

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
        when(service.countAllProductsByCategory(any(Category.class))).thenReturn(5L);
        long count = service.countAllProductsByCategory(new Category(UUID.randomUUID().toString(),"İçecek"));
        Assertions.assertEquals(5,count);
    }
}