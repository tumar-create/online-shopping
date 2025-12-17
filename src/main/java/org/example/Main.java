package org.example;

import org.example.entity.Customer;
import org.example.entity.Item;
import org.example.entity.Order;

public class Main {
    public static void main(String[] args) {

        Item item1 = new Item();
        item1.setId(1);
        item1.setDescription("Iphone 15");
        item1.setName("Phone");
        item1.setPrice(350000);
        item1.setSize("500x200");
        item1.setInStock(false);

        Item item2 = new Item();
        item2.setId(2);
        item2.setDescription("Iphone 16");
        item2.setName("Phone");
        item2.setPrice(400000);
        item2.setSize("400x200");
        item2.setInStock(false);

        Item item3 = new Item();
        item3.setId(3);
        item3.setDescription("Xiaomi Note 15 Pro Max Ultra Super");
        item3.setName("Phone");
        item3.setPrice(150000);
        item3.setSize("700x200");
        item3.setInStock(true);

        Item item4 = new Item(4, "MacBook Air 15",
                700500, "Laptop", "15", true);

        Item[] items = new Item[]{item1, item2, item3};
        Item[] items2 = new Item[]{item1, item2};

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFullName("Tumar");
        customer1.setEmail("test@mail.com");
        customer1.setPhoneNumber("7777");
        customer1.setAddress("Astana");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFullName("Mike");
        customer2.setEmail("mike@mail.com");
        customer2.setPhoneNumber("212121");
        customer2.setAddress("Almaty");

        Order order1 = new Order(1, customer1, items,
                900000, 10, 1500);
        Order order2 = new Order(2, customer2, items2,
                700000, 20, 1000);

        System.out.println("=== ORDER 1 ===");
        order1.printOrderDetails();
        order1.showAllItems();

        System.out.println("=== ORDER 2 ===");
        order2.printOrderDetails();
        order2.showAllItems();

        System.out.println("=== ITEMS ===");
        item1.printDetails();
        item2.printDetails();
        item3.printDetails();
        item4.printDetails();

        System.out.println("Is MacBook in stock?: " + item4.isInStock());

        System.out.println("Item1 and Item2 have same name: " + item1.hasSameName(item2));
        System.out.println("Item3 and Item4 have same name: " + item3.hasSameName(item4));

        System.out.println("Item1 is cheaper than Item2: " + item1.isCheaperThan(item2));
        System.out.println("Item3 is cheaper than Item4: " + item3.isCheaperThan(item4));

        System.out.println("=== CUSTOMERS ===");
        customer1.printDetails();
        customer2.printDetails();
        System.out.println("Customer1 and Customer2 have same email: "
                + customer1.hasSameEmail(customer2));
        System.out.println("Customer1 and Customer2 live in same city: "
                + customer1.livesInSameCity(customer2));

        double final1 = order1.calculateFinalTotal();
        double final2 = order2.calculateFinalTotal();

        System.out.println("Final total of order1: " + final1);
        System.out.println("Final total of order2: " + final2);
        System.out.println("Order1 is more expensive than Order2: " + (final1 > final2));

        System.out.println("Orders have same customer: "
                + (order1.getCustomer().getId() == order2.getCustomer().getId()));

        System.out.println("Order1 and Order2 have same number of items: "
                + (order1.getItems().length == order2.getItems().length));
    }
}