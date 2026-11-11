package Project.EcommerceManagementSystem.service;

import Project.EcommerceManagementSystem.enums.OrderStatus;
import Project.EcommerceManagementSystem.model.Customer;
import Project.EcommerceManagementSystem.model.Order;
import Project.EcommerceManagementSystem.model.OrderItem;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class OrderService {
    private final Map<String, Order> orders;

    public OrderService(){
        orders = new HashMap<>();
    }

    public boolean addOrder(Order order){
        if(order == null){
            throw new IllegalArgumentException("Invalid order");
        }

        if(orders.containsKey(order.getId())){
            return false;
        }

        orders.put(order.getId(), order);
        return true;
    }

    public Order removeOrder(String orderId){
        if(orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Invalid order ID");
        }
        return orders.remove(orderId);
    }

    public Order findOrderById(String orderId){
        if(orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Invalid order ID");
        }

        return orders.get(orderId);
    }

    public int getOrderCount(){
        return orders.size();
    }

    public List<Order> getOrdersByStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        List<Order> result = new ArrayList<>();

        for(Order order : orders.values()){
            if(order.getStatus() == status){
                result.add(order);
            }
        }
        return result;
    }
    public int countOrdersByStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        int count = 0;
        for(Order order : orders.values()){
            if(order.getStatus() == status){
                count++;
            }
        }
        return count;
    }

    public List<Order> getAllOrders(){
        return new ArrayList<>(orders.values());
    }

    public List<Order> getOrdersByCustomer(String customerId){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        List<Order> result = new ArrayList<>();
        for(Order order : orders.values()){
            Customer customer = order.getCustomer();

            if(customer.getId().equals(customerId)){
                result.add(order);
            }
        }
        return result;
    }

    public List<Order> getOrdersBetweenDates(LocalDateTime startDate, LocalDateTime endDate){
        if(startDate == null){
            throw new IllegalArgumentException("Invalid start date");
        }

        if(endDate == null){
            throw new IllegalArgumentException("Invalid end date");
        }

        if(startDate.isAfter(endDate)){
            throw new IllegalArgumentException("Invalid date range");
        }

        List<Order> result = new ArrayList<>();
        for(Order order : orders.values()){
            if(!order.getOrderDate().isBefore(startDate)
                    && !order.getOrderDate().isAfter(endDate)){
                result.add(order);
            }
        }
        return result;
    }

    public List<Order> getOrdersAboveAmount(double minAmount){
        if(!Double.isFinite(minAmount) || minAmount < 0){
            throw new IllegalArgumentException("Invalid price");
        }

        List<Order> result = new ArrayList<>();
        for (Order order : orders.values()){
            if(order.getTotalAmount() > minAmount){
                result.add(order);
            }
        }
        return result;
    }

    public List<Order> getOrdersSortedByAmount(){
        List<Order> result = new ArrayList<>(orders.values());
        Comparator<Order> comparator = Comparator.comparing(Order::getTotalAmount);
         result.sort(comparator);
         return result;
    }
    public List<Order> getOrdersSortedByAmountDescending(){
        List<Order> result = new ArrayList<>(orders.values());
        Comparator<Order> comparator = Comparator.comparing(Order::getTotalAmount).reversed();
        result.sort(comparator);
        return result;
    }
    public Order getMostExpensiveOrder(){
        if(orders.isEmpty()){
            return null;
        }

        Order max = null;
        for(Order order : orders.values()){
            if(max == null || order.getTotalAmount() > max.getTotalAmount()){
                max = order;
            }
        }
        return max;
    }

    public Order getCheapestOrder(){
        if(orders.isEmpty()){
            return null;
        }

        Order min = null;
        for(Order order : orders.values()){
            if(min == null || order.getTotalAmount() < min.getTotalAmount()){
                min = order;
            }
        }
        return min;
    }

    public Map<OrderStatus, List<Order>> groupOrdersByStatus(){
        Map<OrderStatus, List<Order>> result = new HashMap<>();

        for(Order order : orders.values()){
            OrderStatus status = order.getStatus();
            List<Order> orderList = result.computeIfAbsent(status, s -> new ArrayList<>());
            orderList.add(order);
        }
        return result;
    }

    public Map<String, List<Order>> groupOrdersByCustomer(){
        Map<String, List<Order>> result = new HashMap<>();

        for(Order order : orders.values()){
            String customerId = order.getCustomer().getId();
            List<Order> orderList = result.computeIfAbsent(customerId, id -> new ArrayList<>());
            orderList.add(order);
        }
        return result;
    }

    public Map<String, Double> getTotalAmountByCustomer(){
        Map<String, Double> result = new HashMap<>();

        for(Order order : orders.values()){
            String customerId = order.getCustomer().getId();
            double amount = order.getTotalAmount();
            result.merge(customerId, amount,
                    (oldValue, newValue) -> oldValue + newValue);
        }
        return result;
    }

    public Map<String, Integer> countOrdersByCustomer(){
        Map<String, Integer> result = new HashMap<>();

        for(Order order : orders.values()){
            String customerId = order.getCustomer().getId();
            result.merge(customerId, 1, (oldValue, newValue) -> oldValue + 1);
        }
        return result;
    }

    public boolean confirmOrder(String orderId){
        if(orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Invalid order ID");
        }

        Order order = findOrderById(orderId);
        if(order == null){
            return false;
        }

        if(!order.isModifiable()){
            return false;
        }

        if(order.isEmpty()){
            return false;
        }

        for (OrderItem orderItem : order.getItems()){
            if(orderItem.getQuantity() > orderItem.getProduct().getQuantity()){
                return false;
            }
        }

        for(OrderItem orderItem : order.getItems()){
            int available = orderItem.getProduct().getQuantity();
            int ordered = orderItem.getQuantity();
            int newQuantity = available - ordered;
            orderItem.getProduct().setQuantity(newQuantity);
        }
        order.confirmOrder();
        return true;
    }

    public boolean cancelOrder(String orderId){
        if(orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Invalid order ID");
        }

        Order order = findOrderById(orderId);
        if(order == null){
            return false;
        }

        if (order.getStatus() != OrderStatus.CONFIRMED){
            return false;
        }

        for(OrderItem orderItem : order.getItems()){
            int available = orderItem.getProduct().getQuantity();
            int ordered = orderItem.getQuantity();
            int newQuantity = available + ordered;
            orderItem.getProduct().setQuantity(newQuantity);
        }
        order.cancelOrder();
        return true;
    }

    public boolean shipOrder(String orderId){
        if(orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Invalid order ID");
        }

        Order order = findOrderById(orderId);
        if(order == null){
            return false;
        }

        if (order.getStatus() != OrderStatus.CONFIRMED){
            return false;
        }

        order.shipOrder();
        return true;
    }

    public boolean deliverOrder(String orderId){
        if(orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Invalid order ID");
        }

        Order order = findOrderById(orderId);
        if(order == null){
            return false;
        }

        if (order.getStatus() != OrderStatus.SHIPPED){
            return false;
        }

        order.deliverOrder();
        return true;
    }

    public List<Order> getOrdersByStatusAndCustomer(String customerId, OrderStatus status){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        List<Order> result = new ArrayList<>();
        for(Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId) && order.getStatus() == status){
                result.add(order);
            }
        }
        return result;
    }

    public int countOrdersByStatusAndCustomer(String customerId, OrderStatus status){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        int count = 0;

        for(Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId) && order.getStatus() == status){
                count++;
            }
        }
        return count;
    }

    public double getTotalAmountByStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        double totalAmount = 0;
        for (Order order : orders.values()){
            if(order.getStatus() == status){
                totalAmount += order.getTotalAmount();
            }
        }
        return totalAmount;
    }

    public Order getMostExpensiveOrderByStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        Order max = null;
        for(Order order : orders.values()){
            if(order.getStatus() == status){
                if(max == null || order.getTotalAmount() > max.getTotalAmount()){
                    max = order;
                }
            }
        }
        return max;
    }

    public Order getCheapestOrderByStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        Order min = null;
        for(Order order : orders.values()){
            if(order.getStatus() == status){
                if(min == null || order.getTotalAmount() < min.getTotalAmount()){
                    min = order;
                }
            }
        }
        return min;
    }

    public List<Order> getOrdersByCustomerAndMinAmount(String customerId, double minAmount){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        if(!Double.isFinite(minAmount) || minAmount < 0){
            throw new IllegalArgumentException("Invalid price");
        }

        List<Order> result = new ArrayList<>();

        for(Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId)){
                if(order.getTotalAmount() >= minAmount){
                    result.add(order);
                }
            }
        }
        return result;
    }

    public List<Order> getOrdersByCustomerStatusAndMinAmount(String customerId, OrderStatus status, double minAmount){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        if(!Double.isFinite(minAmount) || minAmount < 0){
            throw new IllegalArgumentException("Invalid price");
        }

        List<Order> result = new ArrayList<>();
        for(Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId) && order.getStatus() == status && order.getTotalAmount() >= minAmount){
                result.add(order);
            }
        }
        return result;
    }
    public List<Order> getOrdersContainingProduct(String productId){
        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        List<Order> result = new ArrayList<>();
        for(Order order : orders.values()){
            if(order.containsProduct(productId)){
                result.add(order);
            }
        }
        return result;
    }

    public int countOrdersContainingProduct(String productId){
        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        int count = 0;
        for(Order order : orders.values()){
            if(order.containsProduct(productId)){
                count++;
            }
        }
        return count;
    }

    public int getTotalQuantitySold(String productId){
        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        int count = 0;
        for (Order order : orders.values()){
            if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                OrderItem orderItem = order.getItemByProductId(productId);

                if(orderItem != null){
                    count += orderItem.getQuantity();
                }
            }
        }
        return count;
    }

    public double getTotalRevenueByProduct(String productId){
        if(productId == null || productId.isBlank()){
            throw new IllegalArgumentException("Invalid product ID");
        }

        double total = 0;
        for(Order order : orders.values()){
            if (order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                OrderItem orderItem = order.getItemByProductId(productId);
                if(orderItem != null){
                    total += orderItem.getSubtotal();
                }
            }
        }
        return total;
    }

    public double getTotalRevenueByCustomer(String customerId){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        double total = 0;
        for(Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId)){
                if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                    total += order.getTotalAmount();
                }
            }
        }
        return total;
    }

    public String getTopCustomerByRevenue(){

        Map<String, Double> result = new HashMap<>();

        for(Order order : orders.values()){
            if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                String customerId = order.getCustomer().getId();
                double total = order.getTotalAmount();
                result.merge(customerId, total, (oldValue, newValue) -> oldValue + newValue);
            }
        }

        String topCustomer = null;
        double maxRevenue = 0;

        for(Map.Entry<String, Double> entry : result.entrySet()){
           if(entry.getValue() > maxRevenue){
               topCustomer = entry.getKey();
               maxRevenue = entry.getValue();
           }

        }
        return topCustomer;
    }

    public double getAverageOrderAmount(){
        double total = 0;
        int count = 0;

        for(Order order : orders.values()){
            if(order.getStatus() != OrderStatus.PENDING &&
                    order.getStatus() != OrderStatus.CANCELLED){
                total += order.getTotalAmount();
                count++;
            }
        }

        if(count == 0){
            return 0;
        }

        double average = total / count;
        return average;
    }

    public double getAverageOrderAmountByCustomer(String customerId){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        double total = 0;
        int count = 0;

        for(Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId)){
                if(order.getStatus() != OrderStatus.CANCELLED && order.getStatus() != OrderStatus.PENDING){
                    total += order.getTotalAmount();
                    count++;
                }

            }
        }

        if(count == 0){
            return 0;
        }
        return total / count;
    }

    public double getAverageOrderAmountByStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        double total = 0;
        int count = 0;

        for(Order order : orders.values()){
            if(order.getStatus() == status){
                total += order.getTotalAmount();
                count++;
            }
        }

        if(count == 0){
            return 0;
        }
        return total / count;
    }

    public double getAverageOrderAmountByCustomerAndStatus(String customerId, OrderStatus status){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        double total = 0;
        int count = 0;

        for (Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId) && order.getStatus() == status){
                total += order.getTotalAmount();
                count++;
            }
        }

        if(count == 0){
            return 0;
        }

        return total / count;
    }

    public double getTotalRevenueByStatusAndCustomer(String customerId, OrderStatus status){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        double sum = 0;

        for(Order order : orders.values()){
            if(order.getCustomer().getId().equals(customerId) && order.getStatus() == status){
                sum += order.getTotalAmount();
            }
        }
        return sum;
    }

    public Map<OrderStatus, Double> getRevenueByStatus(){
        Map<OrderStatus, Double> result = new HashMap<>();

        for(Order order : orders.values()){
            OrderStatus status = order.getStatus();
            Double total = order.getTotalAmount();
            result.merge(status, total, (oldValue, newValue) -> oldValue + newValue);
        }
        return result;
    }

    public Map<String, Double> getRevenueByCustomerAndStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        Map<String, Double> result = new HashMap<>();

        for(Order order : orders.values()){
            if(order.getStatus() == status){
                String customerId = order.getCustomer().getId();
                Double total = order.getTotalAmount();
                result.merge(customerId, total, (oldValue, newValue) -> oldValue + newValue);
            }
        }

        return result;
    }

    public Map<OrderStatus, Integer> getOrderCountByStatus(){
        Map<OrderStatus, Integer> result = new HashMap<>();

        for (Order order : orders.values()){
            OrderStatus orderStatus = order.getStatus();
            result.merge(orderStatus, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        return result;
    }

    public Map<String, Integer> getOrderCountByCustomer(){
        Map<String, Integer> result = new HashMap<>();

        for(Order order : orders.values()){
            String customerId = order.getCustomer().getId();
            result.merge(customerId, 1, Integer::sum);
        }
        return result;
    }

    public String getTopCustomerByOrderCount(){
        Map<String, Integer> result = getOrderCountByCustomer();

        String topCustomer = null;
        int maxOrders = 0;

        for(Map.Entry<String, Integer> entry : result.entrySet()){
            if(entry.getValue() > maxOrders){
                topCustomer = entry.getKey();
                maxOrders = entry.getValue();
            }

        }
            return topCustomer;
    }

    public String getTopCustomerByAverageOrderAmount(){
        Map<String, Double> revenueByCustomer = new HashMap<>();
        Map<String, Integer> countByCustomer = new HashMap<>();

        for(Order order : orders.values()){
            if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                String customerId = order.getCustomer().getId();
                Double total = order.getTotalAmount();
                revenueByCustomer.merge(customerId, total, (oldValue, newValue) -> oldValue + newValue);
                countByCustomer.merge(customerId, 1, Integer::sum);
            }
        }
        Map<String, Double> averageByCustomer = new HashMap<>();
        for(Map.Entry<String, Double> entry : revenueByCustomer.entrySet()){
            String customerId = entry.getKey();
            double totalRevenue = entry.getValue();
            int orderCount = countByCustomer.get(customerId);
            double average = totalRevenue / orderCount;
            averageByCustomer.put(customerId, average);
        }

        String topCustomer = null;
        double maxAverage = 0;

        for(Map.Entry<String, Double> entry : averageByCustomer.entrySet()){
            if(entry.getValue() > maxAverage){
                topCustomer = entry.getKey();
                maxAverage = entry.getValue();
            }

        }
        return topCustomer;
    }

    public String getTopCustomerByAverageOrderAmountWithMinOrders(int minOrders){
        if(minOrders <= 0){
            throw new IllegalArgumentException("Invalid order number");
        }

        Map<String, Double> revenueByCustomer = new HashMap<>();
        Map<String, Integer> countByCustomer = new HashMap<>();

        for(Order order : orders.values()){
            if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                String customerId = order.getCustomer().getId();
                double total = order.getTotalAmount();
                revenueByCustomer.merge(customerId, total, (oldValue, newValue) -> oldValue + newValue);
                countByCustomer.merge(customerId, 1, Integer::sum);
            }
        }

        Map<String, Double> averageByCustomer = new HashMap<>();
        for(Map.Entry<String, Double> entry : revenueByCustomer.entrySet()){
            String customerId = entry.getKey();
            double totalRevenue = entry.getValue();
            int orderCount = countByCustomer.get(customerId);

            if(orderCount >= minOrders){
                double average = totalRevenue / orderCount;
                averageByCustomer.put(customerId, average);
            }
        }

        String topCustomer = null;
        double maxAverage = 0;

        for(Map.Entry<String, Double> entry : averageByCustomer.entrySet()){
            if(entry.getValue() > maxAverage){
                topCustomer = entry.getKey();
                maxAverage = entry.getValue();
            }

        }
        return topCustomer;
    }

    public Map<String, List<String>> getCustomersGroupedByRevenue(){
        Map<String, Double> totalRevenue = new HashMap<>();
        Map<String, List<String>> customersId = new HashMap<>();

        for(Order order : orders.values()){
            if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                String customerId = order.getCustomer().getId();
                Double total = order.getTotalAmount();
                totalRevenue.merge(customerId, total, (oldValue, newValue) -> oldValue + newValue);
            }
        }

        for(Map.Entry<String, Double> entry : totalRevenue.entrySet()){
            String customerId = entry.getKey();
            double revenue = entry.getValue();
            String category = null;

            if(revenue < 100){
                category = "LOW";
            } else if (revenue >= 100 && revenue < 500) {
                category = "MEDIUM";
            }else {
                category = "HIGH";
            }
            customersId.computeIfAbsent(category, k -> new ArrayList<>()).add(customerId);
        }
        return customersId;
    }

    public Map<String, List<String>> getCustomersGroupedByRevenueSorted(){
        Map<String, Double> totalRevenue = new HashMap<>();
        Map<String, List<String>> customersId = new HashMap<>();

        for(Order order : orders.values()){
            if(order.getStatus() == OrderStatus.CONFIRMED || order.getStatus() == OrderStatus.SHIPPED || order.getStatus() == OrderStatus.DELIVERED){
                String customerId = order.getCustomer().getId();
                Double total = order.getTotalAmount();
                totalRevenue.merge(customerId, total, (oldValue, newValue) -> oldValue + newValue);
            }
        }

        for(Map.Entry<String, Double> entry : totalRevenue.entrySet()){
            String customerId = entry.getKey();
            double revenue = entry.getValue();
            String category = null;

            if(revenue < 100){
                category = "LOW";
            } else if (revenue >= 100 && revenue < 500) {
                category = "MEDIUM";
            }else {
                category = "HIGH";
            }
            customersId.computeIfAbsent(category, k -> new ArrayList<>()).add(customerId);
        }

        for(List<String> customerIds : customersId.values()){
            Collections.sort(customerIds);
        }
        return customersId;
    }

    public Map<Integer, List<String>> getCustomersGroupedByOrderCount(){
            Map<Integer, List<String>> customersByOrderCount = new HashMap<>();
            Map<String, Integer> order = getOrderCountByCustomer();

            for(Map.Entry<String, Integer> entry : order.entrySet()){
                String customerId = entry.getKey();
                int numberOrders = entry.getValue();
                customersByOrderCount.computeIfAbsent(numberOrders, k -> new ArrayList<>()).add(customerId);
            }
        return customersByOrderCount;
    }

    public Map<Integer, List<String>> getCustomersGroupedByOrderCountSorted(){
        Map<Integer, List<String>> customersByOrderCount = getCustomersGroupedByOrderCount();

        for(List<String> customerIds : customersByOrderCount.values()){
            Collections.sort(customerIds);
        }
        return customersByOrderCount;
    }

    public List<String> getCustomersWithMinOrders(int minOrders){
        if(minOrders <= 0){
            throw new IllegalArgumentException("Invalid value");
        }

        Map<String, Integer> orderCountByCustomer = getOrderCountByCustomer();
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : orderCountByCustomer.entrySet()){
            String customerId = entry.getKey();
            int numberOrder = entry.getValue();

            if(numberOrder >= minOrders){
                result.add(customerId);
            }
        }
            return result;
    }

    public List<String> getCustomersWithOrdersBetween(int minOrders, int maxOrders){
        if(minOrders <= 0){
            throw new IllegalArgumentException("Invalid min value");
        }

        if(maxOrders <= 0){
            throw new IllegalArgumentException("Invalid max value");
        }

        if(minOrders > maxOrders){
            throw new IllegalArgumentException("Invalid values");
        }

        Map<String, Integer> orderCountByCustomer = getOrderCountByCustomer();
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : orderCountByCustomer.entrySet()){
            String customerId = entry.getKey();
            int numberOrder = entry.getValue();

            if(numberOrder >= minOrders && numberOrder <= maxOrders){
                result.add(customerId);
            }
        }
        return result;
    }

    public String getTopCustomerByOrderCountBetween(int minOrders, int maxOrders) {
        if (minOrders <= 0) {
            throw new IllegalArgumentException("Invalid min value");
        }

        if (maxOrders <= 0) {
            throw new IllegalArgumentException("Invalid max value");
        }

        if(minOrders > maxOrders){
            throw new IllegalArgumentException("Invalid values");
        }

        Map<String, Integer> orderCountByCustomer = getOrderCountByCustomer();

        String topCustomer = null;
        int max = 0;

        for(Map.Entry<String, Integer> entry : orderCountByCustomer.entrySet()){
            if(entry.getValue() >= minOrders && entry.getValue() <= maxOrders){
                if(entry.getValue() > max){
                    max = entry.getValue();
                    topCustomer = entry.getKey();
                }
            }
        }
        return topCustomer;
    }

    public Map<String, Integer> getOrderCountByCustomerAndStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        Map<String, Integer> result = new HashMap<>();
        List<Order> filteredOrders = getOrdersByStatus(status);

        for(Order order : filteredOrders){
            String customerId = order.getCustomer().getId();
            result.merge(customerId, 1, Integer::sum);
        }
        return result;
    }

    public Map<OrderStatus, Integer> getOrderCountByCustomerGroupedByStatus(String customerId){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        Map<OrderStatus, Integer> result = new HashMap<>();
        List<Order> orderList = getOrdersByCustomer(customerId);

        for(Order order : orderList){
            OrderStatus orderStatus = order.getStatus();
            result.merge(orderStatus, 1, Integer::sum);
        }
        return result;
    }

    public Map<OrderStatus, Double> getRevenueByCustomerGroupedByStatus(String customerId){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Invalid customer ID");
        }

        Map<OrderStatus, Double> result = new HashMap<>();
        List<Order> orderList = getOrdersByCustomer(customerId);

        for(Order order : orderList){
            OrderStatus orderStatus = order.getStatus();
            Double total = order.getTotalAmount();
            result.merge(orderStatus, total, Double::sum);
        }
        return result;
    }

    public Map<String, Double> getAverageOrderAmountByCustomerAndStatus(OrderStatus status){
        if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        Map<String, Double> totalRevenue = new HashMap<>();
        Map<String, Integer> orderCount = new HashMap<>();
        List<Order> orderList = getOrdersByStatus(status);

        for(Order order : orderList){
            String customerId = order.getCustomer().getId();
            double totalAmount = order.getTotalAmount();
            totalRevenue.merge(customerId, totalAmount, Double::sum);
            orderCount.merge(customerId, 1, Integer::sum);
        }

        Map<String, Double> averageByCustomer = new HashMap<>();
        for(Map.Entry<String, Double> entry : totalRevenue.entrySet()){
            String customerId = entry.getKey();
            double total = entry.getValue();
            int numberOfOrders = orderCount.get(customerId);
            double average = total / numberOfOrders;
            averageByCustomer.put(customerId, average);
        }
        return averageByCustomer;
    }

    public String getTopCustomerByAverageOrderAmountAndStatus(OrderStatus status){
       if(status == null){
            throw new IllegalArgumentException("Invalid status");
        }

        Map<String, Double> average = getAverageOrderAmountByCustomerAndStatus(status);

        String topCustomer = null;
        double maxAverage = 0;

        for(Map.Entry<String, Double> entry : average.entrySet()){
            if(entry.getValue() > maxAverage){
                topCustomer = entry.getKey();
                maxAverage = entry.getValue();
            }

        }
        return topCustomer;
    }
}
