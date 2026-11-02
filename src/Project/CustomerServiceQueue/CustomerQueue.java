package Project.CustomerServiceQueue;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private Queue<Customer> customers;

    public CustomerQueue(){

        customers = new LinkedList<>();
    }

    public void addCustomer(Customer customer){
        if(customer == null){
            throw new IllegalArgumentException("Invalid name");
        }
            customers.offer(customer);
    }

    public void serveCustomer(){
        if(customers.isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        customers.poll();
    }

    public void showNextCustomer(){
        Customer nextCustomer = customers.peek();

        if (nextCustomer == null) {
            System.out.println("The queue is empty.");
            return;
        }

        nextCustomer.printInfo();
    }

    public void printQueue(){
        for (Customer  customer : customers){
            customer.printInfo();
        }
    }

    public boolean isQueueEmpty() {
        return customers.isEmpty();
    }

}
