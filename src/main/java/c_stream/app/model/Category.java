package c_stream.app.model;

import java.util.List;
import java.util.Objects;

public class Category {
    private String id;
    private String description;
    private List<Product> products;

    public Category(String description) {
        this.description = description;
    }

    public Category(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Category(String id, String description, List<Product> products) {
        this.id = id;
        this.description = description;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "Category{" +
                "description='" + description + '\'' +
                '}';
    }
}
