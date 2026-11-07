package Project.ShoppingCart;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    public void sortProducts(){
        List<Product> sortedProducts = new ArrayList<>(products.values());
        sortedProducts.sort(
                Comparator.comparing(Product::getPrice)
                        .thenComparing(
                                Product::getName,
                                Comparator.reverseOrder()
                        )
        );

        for (Product product : sortedProducts){
            IO.println(product);
        }
    }

    public void printProductsSortedByPrice() {
        List<Map.Entry<String, Product>> sortedEntries =
                new ArrayList<>(products.entrySet());

        sortedEntries.sort(
                Comparator.comparing(entry -> entry.getValue().getPrice())
        );

        for (Map.Entry<String, Product> entry : sortedEntries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void increasePrices(){
        Iterator<Product> iterator = products.values().iterator();

        while (iterator.hasNext()){
            Product product = iterator.next();
            product.setPrice(product.getPrice() * 1.10);

        }
    }

    public void printAllProducts(){

        if(products.isEmpty()){
            System.out.println("The shopping cart is empty.");
            return;
        }

        products.values().forEach(product -> {
            System.out.println("Code: " + product.getCode());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
        });
    }

    public void applyDiscount(double percentage){
        if (!Double.isFinite(percentage) || percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }

        products.values().forEach(product -> {
            product.setPrice(product.getPrice()*(1-percentage/100));
        });
    }

    public void printProductsAbovePrice(double minPrice){
        if(!Double.isFinite(minPrice) || minPrice < 0){
            throw new IllegalArgumentException("Invalid price");
        }

    AtomicBoolean found = new AtomicBoolean(false);
    products.values().forEach(product -> {
            if(product.getPrice() > minPrice){
                found.set(true);
                IO.println(product);
            }
        });

    if(!found.get()){
        IO.println("No product");
    }
    }

    public void printProductsInPriceRange(double minPrice, double maxPrice){
        if(!Double.isFinite(minPrice) || !Double.isFinite(maxPrice) || minPrice < 0 || minPrice > maxPrice || maxPrice <= 0){
            throw new IllegalArgumentException("Invalid input");
        }

        Predicate<Product> condition =
                product -> product.getPrice() >= minPrice;

        Predicate<Product> condition2 =
                product -> product.getPrice() <= maxPrice;

        Predicate<Product> combined = condition.and(condition2);

        products.values().forEach(product ->{
            if(combined.test(product)){
                System.out.println(product);
            }
        });
    }

    public void printPriceIncrease(){
        Function<Product, Double> getProductPrice = product -> product.getPrice() * 1.10;

        products.values().forEach(product -> {

            Double priceIncrease = getProductPrice.apply(product);
            IO.println(product.getName() + " - " + priceIncrease);
                }

                );
    }

    public void printCartStatus(){
        Supplier<String> successMessage = () -> "The shopping cart contains products";
        Supplier<String> failedMessage = () -> "The shopping cart is empty";

        IO.println(products.isEmpty() ? failedMessage.get() : successMessage.get());
    }

    public void printProductNames(){
        Function<Product, String> productName = Product::getName;

        Consumer<String> print = System.out::println;

        products.values().forEach(product ->
                print.accept(productName.apply(product))
        );
    }
}
