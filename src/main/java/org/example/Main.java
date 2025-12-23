package org.example;

import org.example.entity.*;
import org.example.service.StoreService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StoreService service = new StoreService();
        System.out.println("Adding items:");

        service.addItem(new Phone(1, "iPhone 15 Pro", 500210.0, "Titanium model", true, "Apple", "15 Pro", "Natural", 256));
        service.addItem(new Phone(2, "Samsung S24", 550500.0, "AI Phone", true, "Samsung", "S24", "Black", 128));
        service.addItem(new Phone(3, "Nokia 3310", 15000, "Classic brick", true, "Nokia", "3310", "Blue", 2));

        service.addItem(new Cloth(4, "Q T-Shirt", 5000, "Expensive cotton", true, 42, "Summer", "T-Shirt", "Cotton"));
        service.addItem(new Cloth(5, "Winter Jacket", 250000, "North Face style", true, 50, "Winter", "Jacket", "Polyester"));


        service.addItem(new Phone(6, "Broken iPhone", 5000, "For parts only", false, "Apple", "X", "White", 64));

        service.showInventory();



        System.out.println("Finding Iphone");
        List<Item> searchResult = service.searchByName("iPhone");
        for (Item item : searchResult) {
            System.out.println("Found: " + item.getName() + " | " + item.getPrice());
        }

        System.out.println("Item price from 5000 to 50000");
        List<Item> cheapItems = service.filterByPriceRange(5000, 500000);
        for (Item item : cheapItems) {
            System.out.println("Items: " + item.getName() + " | " + item.getPrice());
        }


        System.out.println("Sorting...");
        service.sortByName();
        service.showInventory();


        System.out.println("Creating client1 and order:");
        Customer client = new Customer(1, "Tumar", "tumar@gmail.com", "Astana", "77777");
        List<Integer> cart = Arrays.asList(1, 2, 4);
        service.createOrder(client, cart);



        System.out.println("Creating client2 and order:");
        Customer student = new Customer(102, "Arlan", "arlan@box.kz", "Astana", "8777-123-456");
        List<Integer> studentCart = Arrays.asList(3, 6);
        service.createOrder(student, studentCart);



        System.out.println("Deleting item:");
        service.deleteItem(2);


        Item deletedItem = service.findById(2);
        if (deletedItem == null) {
            System.out.println("Samsung S24 not found");
        }
    }
}