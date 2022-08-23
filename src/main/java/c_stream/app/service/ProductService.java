package c_stream.app.service;

import c_stream.app.model.Category;
import c_stream.app.model.Company;
import c_stream.app.model.ProducedCountry;
import c_stream.app.model.Product;
import c_stream.app.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public List<String> findNamesOfAllProducts(){
        return productRepository.getProducts().stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    public String findNamesOfAllProductsToString(){
        return productRepository.getProducts()
                .stream()
                .map(Product::getName)
                .collect(Collectors.joining(","));
    }

    public long countAllProductsByCategory(Category category){
        return productRepository.getProducts()
                .stream()
                .filter(e->e.getCategory().equals(category))
                .count();
    }

    public List<String> getNamesOfCompanyProducts(Company company){
        return productRepository.getProducts().stream()
                .filter(e->e.getCompany().equals(company))
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByCategory(Category category){
        return productRepository.getProducts().stream()
                .filter(e->e.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByNotExistCategory(Category category){
        return productRepository.getProducts().stream()
                .filter(e->!e.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsCompanyWithPrice(Company company, BigDecimal price){
        return productRepository.getProducts().stream()
                .filter(e->e.getCompany().equals(company))
                .filter(e->e.getPrice().compareTo(price)>0)
                .collect(Collectors.toList());
    }

    public boolean companiesProductsAnyMatchCategory(Company company,Category category){
        return productRepository.getProducts().stream()
                .filter(e->e.getCompany().equals(company))
                .anyMatch(e->e.getCategory().equals(category));
    }

    public long countWafers(){
        return productRepository.getProducts()
                .stream()
                .filter(e->e.getCategory().getDescription().equals("Wafer"))
                .count();
    }

    public Map<Company,List<Product>> findCompanyProducts(Company company){
        return productRepository.getProducts().stream()
                .filter(e->e.getCompany().equals(company))
                .collect(Collectors.groupingBy(Product::getCompany));
    }

    public Map<ProducedCountry,List<Product>> findProductsByCountry(){
        return productRepository.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getProducedCountry));
    }

    public Map<ProducedCountry,Long> findProductsByCountry1(){
        return productRepository.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getProducedCountry,Collectors.counting()));
    }

    public Map<Company,Double> findProductsByAveraging(){
        return productRepository.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getCompany,Collectors.averagingDouble(e->e.getPrice().doubleValue())));
    }


    //1- son kullanma tarihi partitioningBy
    //2- malzemelerin olduğu ürünlerin map olarak bulunması
    //3- Collectors.mapping
    //4- Collectors.toMap









}
