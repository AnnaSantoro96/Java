package Project.EcommerceManagementSystem.model;

import Project.EcommerceManagementSystem.enums.Category;

public class Product {
    private final String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;

    public Product(String id, String name, String description, double price, int quantity, Category category){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
        setName(name);
        setDescription(description);
        setPrice(price);
        setQuantity(quantity);
        setCategory(category);
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(!Double.isFinite(price) || price < 0){
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if(category == null){
            throw new IllegalArgumentException("Invalid category");
        }
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nDescription: " + description + "\nPrice: " + price + "\nCategory: " + category + "\nQuantity: " + quantity;
    }
}
