package Project.EcommerceManagementSystem.model;
public class OrderItem {

    private final Product product;
    private int quantity;
    private final double unitPrice;

    public OrderItem(Product product, int quantity, double unitPrice){
        if (product == null){
            throw new IllegalArgumentException("Invalid product");
        }
        this.product = product;
        setQuantity(quantity);
        if(!Double.isFinite(unitPrice) || unitPrice < 0){
            throw new IllegalArgumentException("Invalid unit price");
        }
        this.unitPrice = unitPrice;
    }

     Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        if(quantity <= 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Product: " + product + "\nQuantity: " + quantity + "\nUnit price: " + unitPrice;
    }

    public double getSubtotal(){
        return unitPrice * quantity;
    }
}
