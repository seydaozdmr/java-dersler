package c_stream.app.test;

import c_stream.app.model.*;
import c_stream.app.service.ProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TestController {
    private ProductService productService;

    public TestController() {
        this.productService = new ProductService();
    }

    public void printProducts(){
        System.out.println(productService.findNamesOfAllProductsToString());
    }

    public static void main(String[] args) {
        TestController testController=new TestController();
//        testController.printProducts();
//        System.out.println(testController.productAndCategory());
////        testController.printCounties();
//        System.out.println(testController.printCountiesCounting());
//        System.out.println(testController.printCompaniesAveraging());
//        System.out.println(testController.getNamesOfProductsNamesByExpirationDate(LocalDate.of(2023,07,10)));
//        testController.ingredientListMap().forEach((k,v)-> System.out.println(k.getName()+" : "+
//                v.stream().map(Product::getName).reduce("",(a,b)->a+" "+b)));
//        System.out.println(testController.getProductsByExpirationDate());
//        System.out.println(testController.getProductsByExpirationDateUnder2022());

        //System.out.println(testController.getProductsAveragePrice());
        System.out.println(testController.getHighPricedProduct());

    }

    public boolean productAndCategory(){
        return productService.companiesProductsAnyMatchCategory(new Company("Ülker"),new Category("Çikolata"));
    }

    public void printCounties(){
        productService.findProductsByCountry().forEach((k,v)-> System.out.println(k+":"+v));
    }

    public Map<ProducedCountry,Long> printCountiesCounting(){
        return productService.findProductsByCountry1();
    }

    public Map<Company,Double> printCompaniesAveraging(){
        return productService.findProductsByAveraging();
    }

    public Map<Boolean, String> getNamesOfProductsNamesByExpirationDate(LocalDate localDate){
        return productService.findProductsByExpirationDate(localDate);
    }
    public Map<Ingredient,List<Product>> ingredientListMap(){
        return productService.distinctIngredientOfProducts();
    }

    public Map<String,Integer> getProductsByExpirationDate(){
        return productService.findProductsByNameAndExpirationDate();
    }

    public List<Product> getProductsByExpirationDateUnder2022(){
        return productService.getProductsByExpirationDateUnder2022();
    }

    public Map<String,Double> getProductsAveragePrice(){
        return productService.getProductsAveragePrice();
    }
    public String getHighPricedProduct(){
        return productService.getHighPricedProduct();
    }

}
