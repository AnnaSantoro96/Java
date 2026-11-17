package JavaBase.Generics.ProductRepository;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price){
        setName(name);
        setPrice(price);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPrice: " + price;
    }
}
