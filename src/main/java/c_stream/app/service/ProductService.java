package c_stream.app.service;

import c_stream.app.model.*;
import c_stream.app.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public List<Product> findAllProducts(){
        return new ArrayList<>(productRepository.getProducts());
    }

    public Product findProduct(String name){
        return productRepository.getProducts().stream()
                .filter(name::equals)
                .findFirst()
                .orElseThrow(()->new NoSuchElementException("aranan eleman bulunamadı"));
    }



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

    public Map<Ingredient,List<Product>> distinctIngredientOfProducts(){
        return productRepository.getProducts().stream()
                .collect(
                        HashMap::new,
                        (Map<Ingredient, List<Product>> map, Product next) -> next.getIngredients()
                                .forEach(i -> map.computeIfAbsent(i, k -> new ArrayList<>()).add(next)),
                        (left, right) -> right.forEach((i, prods) ->
                                left.merge(i, prods, (oldV, newV) -> {
                                    oldV.addAll(newV);
                                    return oldV;
                                }))
                );
    }

    public Map<Boolean,String> findProductsByExpirationDate(LocalDate localDate) {
        return productRepository.getProducts().stream()
                .collect(Collectors
                        .partitioningBy(e->e.getExpirationDate().compareTo(localDate)<0,
                              Collectors.mapping(Product::getName,Collectors.joining(","))));
    }


    //1- son kullanma tarihi partitioningBy -> names joining ,
    //2- malzemelerin olduğu ürünlerin map olarak bulunması
    //3- Collectors.mapping
    //4- Collectors.toMap









}
