package Project.Store;

import java.util.ArrayList;

public class Store {

    private ArrayList<Product> products;

    public Store(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Product searchProduct(String name){
        for(Product product : products){
            if(product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }

        return null;
    }

    public boolean sellProduct(String name, int quantity){
        for(Product product : products) {
                if (product.getName().equalsIgnoreCase(name) && product.getQuantity() > 0) {
                    if (quantity > 0 && quantity <= product.getQuantity()) {
                    int sellQuantity = product.getQuantity() - quantity;
                    product.setQuantity(sellQuantity);
                    return true;
                    }
            }
        }
        return false;
    }

    public void restockProduct(String name, int quantity){
        for(Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    if (quantity > 0) {
                    int restock = product.getQuantity() + quantity;
                    product.setQuantity(restock);
                    break;
                }
            }
        }
    }

    public double calculateInventoryValue(){
        double total = 0;

        for(int i = 0; i < products.size(); i++){
            total = total + (products.get(i).getPrice() * products.get(i).getQuantity());
        }

        return total;
    }

    public void printProducts(){
        for(Product product : products){
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Category: " + product.getCategory());
            System.out.println();
        }
    }

    public ArrayList<Product> searchProductsByCategory(String category){
        ArrayList<Product> products1 = new ArrayList<>();
        for(Product p : products){
            if(p.getCategory().equalsIgnoreCase(category)){
                products1.add(p);
            }

        }

        return products1;
    }
}
