package Project.ShoppingCart;

public class Product implements Comparable<Product>{
    private String code;
    private String name;
    private double price;

    public Product(String code, String name, double price){
        setCode(code);
        setName(name);
        setPrice(price);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null || code.isBlank()){
            throw new IllegalArgumentException("Invalid code");
        }
        this.code = code;
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
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Code: " + code + "\nName: " + name + "\nPrice: " + price;
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price, o.price);
    }
}
