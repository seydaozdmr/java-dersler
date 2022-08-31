package c_stream.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Product implements Comparable<Product>{
    private String id;
    private BigDecimal price;
    private String name;
    private LocalDate expirationDate;
    private Company company;
    private Category category;
    private ProducedCountry producedCountry;
    private List<Ingredient> ingredients;

    public Product(String id, BigDecimal price
            , String name,
                   LocalDate expirationDate,
                   Company company,
                   Category category,
                   ProducedCountry producedCountry,
                   List<Ingredient> ingredients) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.expirationDate = expirationDate;
        this.company = company;
        this.category = category;
        this.producedCountry = producedCountry;
        this.ingredients = ingredients;
    }

    /**
     * son kullanma tarihi en yakın 5 ürünü sırala
     * bir şirkete ait ürünleri sırala
     * bir şirkete ait en ucuz 5 ürünü sırala
     * bir şirketin türkiyede ürettiği en ucuz 5 ürünü sırala
     */



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProducedCountry getProducedCountry() {
        return producedCountry;
    }

    public void setProducedCountry(ProducedCountry producedCountry) {
        this.producedCountry = producedCountry;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", company=" + company +
                ", category=" + category +
                ", producedCountry=" + producedCountry +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.id.compareTo(o.id);
    }
}
