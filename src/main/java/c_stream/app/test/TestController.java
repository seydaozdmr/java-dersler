package c_stream.app.test;

import c_stream.app.model.Category;
import c_stream.app.model.Company;
import c_stream.app.model.ProducedCountry;
import c_stream.app.service.ProductService;

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
        testController.printProducts();
        System.out.println(testController.productAndCategory());
//        testController.printCounties();
        System.out.println(testController.printCountiesCounting());
        System.out.println(testController.printCompaniesAveraging());

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


}
