package Project.ShoppingCart;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class ShoppingCart {
    private LinkedHashMap<String, Product> products;

    public ShoppingCart(){
        products = new LinkedHashMap<>();
    }

    public void addProduct(Product product){
        if(product == null){
            throw new IllegalArgumentException("Invalid product");
        }

        if(products.containsKey(product.getCode())){
            throw new IllegalArgumentException("The product is already present");
        }

        products.put(product.getCode(), product);
    }

    public Product findProduct(String code){
        if(code == null || code.isBlank()){
            throw new IllegalArgumentException("Invalid code");
        }

        return products.get(code);
    }

    public void removeProduct(String code){
        if(code == null || code.isBlank()){
            throw new IllegalArgumentException("Invalid code");
        }

        if(!products.containsKey(code)){
            throw new IllegalArgumentException("The product is not present");
        }

        products.remove(code);
    }

    public void printProducts(){
        if(products.isEmpty()){
            System.out.println("The shopping cart is empty.");
            return;
        }

        for(Product product : products.values()){
            IO.println(product);
        }
    }

    public int countProducts(){
        return products.size();
    }

    public double calculateTotal(){
        double total = 0;

        for(Product product : products.values()){
            total = total + product.getPrice();
        }
        return total;
    }

    public void printProductsBelowPrice(double maxPrice){
        if (!Double.isFinite(maxPrice) || maxPrice < 0){
            throw new IllegalArgumentException("Invalid price");
        }
        boolean found = false;

        for(Product product : products.values()){
            if(product.getPrice() < maxPrice){
                found = true;
                IO.println(product);
            }
        }
        if(!found){
            IO.println("There aren't products with price < " + maxPrice);
        }
    }

    public int removeProductsAbovePrice(double maxPrice){
        if (!Double.isFinite(maxPrice) || maxPrice < 0){
            throw new IllegalArgumentException("Invalid price");
        }

        int productsRemoved = 0;
        Iterator<Product> iterator = products.values().iterator();

        while (iterator.hasNext()){
            Product product = iterator.next();
            if(product.getPrice() > maxPrice){
                iterator.remove();
                productsRemoved++;
            }
        }
        return productsRemoved;
    }
}
