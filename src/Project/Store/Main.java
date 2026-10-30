package Project.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner in = new Scanner(System.in);
        Store store = new Store();
        int value = -1;

        do {

            System.out.println("\n===== STORE MENU =====");
            System.out.println("1. Add a product");
            System.out.println("2. Print all products");
            System.out.println("3. Search a product");
            System.out.println("4. Sell a product");
            System.out.println("5. Restock a product");
            System.out.println("6. Calculate inventory");
            System.out.println("7. Search products by category");
            System.out.println("0. Exit");
            System.out.println("Choose an option:");

            if (!in.hasNextInt()) {
                System.out.println("Incorrect input...");
                in.nextLine();
                continue;
            }

            value = in.nextInt();
            in.nextLine();



            if(value == 0){
                System.out.println("BYE BYE...");
                break;
            }

            if (value < 0 || value > 7) {
                System.out.println("Incorrect value");
                continue;
            }

            switch (value){
                case 1:
                    System.out.println("ENTER A NEW PRODUCT");
                    System.out.println("Enter the product name");
                    String name = in.nextLine();
                    System.out.println("Enter the product price");
                    while (!in.hasNextDouble()){
                        System.out.println("Incorrect input...");
                        in.nextLine();
                        System.out.println("Enter a numeric input:");
                    }
                    double price = in.nextDouble();
                    in.nextLine();

                    System.out.println("Enter the product quantity");
                    while (!in.hasNextInt()){
                        System.out.println("Incorrect input...");
                        in.nextLine();
                        System.out.println("Enter a numeric input:");
                    }
                    int quantity = in.nextInt();
                    in.nextLine();

                    System.out.println("Enter the product category");
                    String category = in.nextLine();

                    store.addProduct(new Product(name, price, quantity, category));
                    break;

                case 2:
                    store.printProducts();
                    break;

                case 3:
                    System.out.println("Enter the product name:");
                    String searchName = in.nextLine();

                    Product foundProduct = store.searchProduct(searchName);

                    if(foundProduct == null){
                        System.out.println("Product not present...");
                    }else {
                        foundProduct.printInfo();
                    }
                    break;

                case 4:
                    System.out.println("Enter the product name");
                    String n = in.nextLine();
                    System.out.println("Enter the quantity");
                    while(!in.hasNextInt()){
                        System.out.println("Incorrect input...");
                        in.nextLine();
                        System.out.println("Enter a numeric input:");
                    }
                    int q = in.nextInt();
                    in.nextLine();
                    boolean success = store.sellProduct(n, q);

                    if(success){
                        System.out.println("Product sold successfully!");
                    }else {
                        System.out.println("Error...");
                    }

                    break;

                case 5:
                    System.out.println("Enter the product name");
                    String nm = in.nextLine();
                    System.out.println("Enter the quantity");
                    while(!in.hasNextInt()){
                        System.out.println("Incorrect input...");
                        in.nextLine();
                        System.out.println("Enter a numeric input:");
                    }
                    int qu = in.nextInt();
                    in.nextLine();
                    store.restockProduct(nm, qu);
                    break;

                case 6:
                    double total = store.calculateInventoryValue();
                    System.out.println(total);
                    break;

                case 7:
                    System.out.println("Enter a category");
                    String c = in.nextLine();
                    ArrayList<Product> products = store.searchProductsByCategory(c);

                    if(products.isEmpty()){
                        System.out.println("No products present...");
                    }else{
                        for(Product p : products){
                            p.printInfo();
                        }
                    }
                    break;

                default:
                    System.out.println("ERROR...");

            }
        }while(value != 0);
    }
}
