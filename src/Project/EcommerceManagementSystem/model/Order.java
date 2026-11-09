package Project.EcommerceManagementSystem.model;
import Project.EcommerceManagementSystem.enums.Category;
import Project.EcommerceManagementSystem.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Order {
    private final String id;
    private Customer customer;
    private LocalDateTime orderDate;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(String id, Customer customer, LocalDateTime orderDate){
        items = new ArrayList<>();
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
        setCustomer(customer);
        setOrderDate(orderDate);
        this.status = OrderStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if(customer == null){
            throw new IllegalArgumentException("Invalid customer");
        }
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        if(orderDate == null){
            throw new IllegalArgumentException("Invalid order date");
        }
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nCustomer: " + customer + "\nOrder date: " + orderDate + "\nStatus: " + status;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(OrderItem item){
        if(!isModifiable()){
            throw new IllegalStateException("Order cannot be modified");
        }
        if(item == null){
            throw new IllegalArgumentException("Invalid item");
        }

        for(OrderItem item1 : items){

            if(item1.getProduct().getId().equals(item.getProduct().getId())){
                if(item1.getProduct().getQuantity() < item1.getQuantity() + item.getQuantity()){
                    throw new IllegalArgumentException("Insufficient stock");
                }
                item1.setQuantity(item1.getQuantity() + item.getQuantity());
                return;
            }
        }
        if(item.getProduct().getQuantity() < item.getQuantity()){
            throw new IllegalArgumentException("Insufficient stock");
        }
         items.add(item);
    }

    public double getTotalAmount(){
        double total = 0;

        for(OrderItem item : items){
            total = total + item.getSubtotal();
        }
        return total;
    }

    public boolean removeItem(String productId){
        if(!isModifiable()){
            throw new IllegalStateException("Order cannot be modified");
        }

        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        Iterator<OrderItem> iterator = items.iterator();
        while (iterator.hasNext()){
            OrderItem item = iterator.next();
            if(item.getProduct().getId().equalsIgnoreCase(productId)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateItemQuantity(String productId, int newQuantity){
        if(!isModifiable()){
            throw new IllegalStateException("Order cannot be modified");
        }

        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        if(newQuantity <= 0){
            throw new IllegalArgumentException("Invalid quantity");
        }


        for(OrderItem item : items){
            if(item.getProduct().getId().equalsIgnoreCase(productId)){
                if(item.getProduct().getQuantity() < newQuantity){
                    throw new IllegalArgumentException("The quantity is too high");
                }
                item.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    public boolean containsProduct(String productId){
        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        for(OrderItem item : items){
            if(item.getProduct().getId().equalsIgnoreCase(productId)){
                return true;
            }
        }
        return false;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public boolean isEmpty(){
      return items.isEmpty();
    }

    public int getTotalItems(){
        int total = 0;

        for(OrderItem item : items){
            total = total + item.getQuantity();
        }
        return total;
    }

    public void clearItems(){
        if(!isModifiable()){
            throw new IllegalStateException("Order cannot be modified");
        }

        items.clear();
    }

    public int getItemCount(){
        return items.size();
    }

    public OrderItem getItemByProductId(String productId){
        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        for(OrderItem item : items){
            if(item.getProduct().getId().equalsIgnoreCase(productId)){
                return item;
            }
        }
        return null;
    }

    public List<OrderItem> getItemsByCategory(Category category){
        if(category == null){
            throw new IllegalArgumentException("Invalid category");
        }

        List<OrderItem> results = new ArrayList<>();
        for(OrderItem item : items){
            if(item.getProduct().getCategory().equals(category)){
                results.add(item);
            }
        }
        return results;
    }

    public List<OrderItem> getItemsAbovePrice(double minPrice){
        if(!Double.isFinite(minPrice) || minPrice < 0){
            throw new IllegalArgumentException("Invalid price");
        }

        List<OrderItem> result = new ArrayList<>();
        for(OrderItem item : items){
            if(item.getUnitPrice() > minPrice){
                result.add(item);
            }
        }
        return result;
    }

    public List<OrderItem> getItemsBetweenPrices(double minPrice, double maxPrice){
        if(!Double.isFinite(minPrice) || minPrice < 0){
            throw new IllegalArgumentException("Invalid min price");
        }

        if(!Double.isFinite(maxPrice) || maxPrice < 0){
            throw new IllegalArgumentException("Invalid max price");
        }

        if(minPrice > maxPrice){
            throw new IllegalArgumentException("Min price cannot be greater than max price");
        }

        List<OrderItem> result = new ArrayList<>();
        for(OrderItem item : items){
            if(item.getUnitPrice() >= minPrice && item.getUnitPrice() <= maxPrice){
                result.add(item);
            }
        }
        return result;
    }

    public boolean isModifiable(){
        return status == OrderStatus.PENDING;
    }

    public void confirmOrder(){
        if(!isModifiable()){
            throw new IllegalStateException("Order cannot be confirmed");
        }

        if(isEmpty()){
            throw new IllegalStateException("The list is empty");
        }

        this.status = OrderStatus.CONFIRMED;
    }

    public boolean cancelOrder(){
        if(status == OrderStatus.PENDING){
            this.status = OrderStatus.CANCELLED;
            return true;
        }
        return false;
    }

    public boolean shipOrder(){
        if(status == OrderStatus.CONFIRMED){
            this.status = OrderStatus.SHIPPED;
            return true;
        }
        return false;
    }

    public boolean deliverOrder(){
        if(status == OrderStatus.SHIPPED){
            this.status = OrderStatus.DELIVERED;
            return true;
        }
        return false;
    }

    public void printOrderSummary(){
        IO.println("ID: " + getId() + "\nName: " + getCustomer().getName() + "\nLastName: " + getCustomer().getLastName() + "\nOrder date: " + getOrderDate() +
                "\nStatus: " + getStatus() + "\nProducts numbers: " + getTotalItems() + "\nTotal amount: " + getTotalAmount());
    }
}
