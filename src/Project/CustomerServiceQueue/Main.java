package Project.CustomerServiceQueue;

import java.util.Queue;

public class Main {
    static void main() {
        CustomerQueue customer = new CustomerQueue();

        customer.addCustomer(new Customer("Anna"));
        customer.addCustomer(new Customer("Luca"));
        customer.addCustomer(new Customer("Paolo"));
        customer.addCustomer(new Customer("Elisa"));

        IO.println("Customers list");
        customer.printQueue();
        IO.println();

        IO.println("Serve the customer");
        customer.serveCustomer();
        customer.printQueue();
        IO.println();

        IO.println("Show the next customer");
        customer.showNextCustomer();
        customer.printQueue();
        IO.println();

        IO.println("The list is empty?");
        boolean resulte = customer.isQueueEmpty();
        System.out.println(resulte);

    }
}
