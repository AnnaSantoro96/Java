package Project.ProductCatalog;
import java.util.TreeMap;

public class ProductCatalog {

    private TreeMap<Integer, Product> products;

    public ProductCatalog(){
        products = new TreeMap<>();
    }

    public void addProduct(int ID, Product product){
        if (product == null){
            throw new IllegalArgumentException("Invalid product");
        }

        if(ID <= 0){
            throw new IllegalArgumentException("Invalid ID");
        }

        if (products.containsKey(ID)){
            throw new IllegalArgumentException("Product already exists");
        }
         products.put(ID, product);
    }

    public Product findProductById(int ID){
        if(ID <= 0){
            throw new IllegalArgumentException("Invalid ID");
        }

        return products.get(ID);
    }

    public void removeProduct(int ID){
        if(ID <= 0){
            throw new IllegalArgumentException("Invalid ID");
        }

        if(products.isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        if(!products.containsKey(ID)){
            System.out.println("The product doesn't exist");
            return;
        }

        products.remove(ID);
    }

    public void printProducts(){
        for(Product product : products.values()){
            System.out.println(product);
        }
    }

    public Product getLowestIdProduct() {
        if(products.isEmpty()){
            System.out.println("The list is empty");
            return null;
        }
        return products.get(products.firstKey());
    }


    public Product getHighestIdProduct(){
        if(products.isEmpty()){
            System.out.println("The list is empty");
            return null;
        }

        return products.get(products.lastKey());
    }

}
