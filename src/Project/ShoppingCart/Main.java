package Project.ShoppingCart;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    private static String readNoBlankString(Scanner in, String message, String errorMessage){
        IO.println(message);
        String value = in.nextLine();

        while (value.isBlank()){
            IO.println(errorMessage);
            IO.println(message);
            value = in.nextLine();
        }
        return value.trim();
    }

    private static double readDouble(Scanner in, String message, String errorMessage){
        IO.println(message);
        double value = in.nextDouble();

        while (value <= 0){
            IO.println(errorMessage);
            IO.println(message);
            value = in.nextDouble();
        }
        return value;
    }

    private static int readInt(Scanner in, String message, String errorMessage, int min, int max) {
        while (true) {
            System.out.println(message);

            if (!in.hasNextInt()) {
                System.out.println(errorMessage);
                in.nextLine();
                continue;
            }

            int value = in.nextInt();
            in.nextLine();

            if (value < min || value > max) {
                System.out.println(errorMessage);
                continue;
            }

            return value;
        }
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        int value = -1;

        do {
            System.out.println("\n===== SHOPPING CART =====");
            System.out.println("1.Add product");
            System.out.println("2.Remove product");
            System.out.println("3.Find product");
            System.out.println("4.Count products");
            System.out.println("5.Calculate total price");
            System.out.println("6.Print products");
            System.out.println("0. Exit");

            value = readInt(in, "Choose an option", "Invalid value", 0, 6);

            if(value == 0){
                IO.println("BYE BYE...");
                break;
            }

            switch (value){
                case 1:
                    IO.println("Add a product");
                    String code = readNoBlankString(in, "Enter the code", "Invalid code");
                    String name = readNoBlankString(in, "Enter the name", "Invalid name");
                    double price = readDouble(in, "Enter the price", "Invalid price");

                    try {
                        shoppingCart.addProduct(new Product(code, name, price));
                        IO.println("Product added successfully!");
                    }catch (IllegalArgumentException e){
                        IO.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2:
                    String code1 = readNoBlankString(in, "Enter the code", "Invalid code");

                    try {
                        shoppingCart.removeProduct(code1);
                        IO.println("Product removed successfully!");
                    }catch (IllegalArgumentException e){
                        IO.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 3:
                    String code2 = readNoBlankString(in, "Enter the code of the product you want find", "Invalid code");

                    try {
                        Product product = shoppingCart.findProduct(code2);
                        if(product == null){
                            IO.println("Product not found");
                        }else{
                            IO.println(product);
                        }
                    }catch (IllegalArgumentException e){
                        IO.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 4:
                    IO.println("Total products present in the cart");
                    IO.println(shoppingCart.countProducts());
                    break;

                case 5:
                    IO.println("Total price");
                    IO.println(shoppingCart.calculateTotal());
                    break;

                case 6:
                    IO.println("Products");
                    shoppingCart.printProducts();
                    break;

                default:
                    IO.println("ERROR...");
                    break;
            }

        }while (value != 0);
    }
}
