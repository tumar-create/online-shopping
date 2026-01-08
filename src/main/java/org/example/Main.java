package org.example;

import org.example.model.Cloth;
import org.example.model.Customer;
import org.example.model.Phone;
import org.example.service.StoreService;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StoreService service = new StoreService();

        Phone p1 = new Phone("iPhone 15", 1200, "New", true, "Apple", "15", "Black", 256);
        Phone p2 = new Phone("Samsung S24", 900, "Top", true, "Samsung", "S24", "Gray", 128);
        Cloth c1 = new Cloth("Nike Shirt", 40, "Sport", true, 42, "Summer", "T-Shirt", "Cotton");

        service.addItem(p1);
        service.addItem(p2);
        service.addItem(c1);

        service.showInventory();

        System.out.println("\n>>> 2. Создаем заказ...");
        Customer customer = new Customer("Tumar", "tumar@mail.com", "Astana", "8777");

        service.createOrder(customer, Arrays.asList(1, 3));
    }
}