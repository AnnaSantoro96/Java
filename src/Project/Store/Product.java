package Project.Store;

public class Product {

    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        } else {
            System.out.println(
                    "ERROR: the value must be greater than zero"
            );
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println(
                    "ERROR: the value must be greater than zero"
            );
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void printInfo(){
        System.out.println("\nName: " + name + "\nPrice: " + price + "\nQuantity: " + quantity + "\nCategory: " + category);
    }
}
