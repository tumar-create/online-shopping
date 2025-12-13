package org.example;

import org.example.entity.Customer;
import org.example.entity.Item;
import org.example.entity.Order;

public class Main {
    public static void main(String[] args){
        Item item1 = new Item();
        item1.setId(1);
        item1.setDescription("Iphone 15");
        item1.setName("Phone");
        item1.setPrice(350000);
        item1.setSize("500x200");
        item1.setInStock(false);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setFullName("Tumar");
        customer.setEmail("test@mail.com");
        customer.setPhoneNumber("7777");
        customer.setAddress("Astana");

        Order order = new Order(1, customer, item1, 360000, 10,1500);

        System.out.println(customer.getFullName());
        System.out.println(order.toString());
        System.out.println(item1.getName());
        System.out.println(item1.getDescription());
    }
}
