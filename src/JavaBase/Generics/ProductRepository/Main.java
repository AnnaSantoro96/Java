package JavaBase.Generics.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Repository<Product> repository = new Repository<>();

        repository.addItem(new Product("Mouse", 12.0));
        repository.addItem(new Product("Laptop", 1500.0));
        repository.addItem(new Product("Monitor", 150.30));

        List<Product> products = repository.getAll();
        ProductUtils.printProducts(products);

        List<Object> objects = new ArrayList<>();
        ProductUtils.addProduct(objects, new Product("Monitor", 300));
        ProductUtils.addProduct(objects, new Product("Laptop", 2500));

        System.out.println(objects);
    }
}
