package JavaBase.Generics.ProductRepository;

import java.util.List;

public class ProductUtils {
    public static void printProducts(List<? extends Product> products){
        for(Product product : products){
            IO.println(product);
        }
    }

    public static void addProduct(List<? super Product> products, Product product){
        products.add(product);
    }
}
