package org.example.dto;

import java.util.List;

public class OrderRequest {

    private Integer customerId;
    private List<Integer> itemIds;
    private double discount;
    private double shippingCost;


    public int getCustomerId() { return customerId; }
    public List<Integer> getItemIds() { return itemIds; }
    public double getDiscount() { return discount; }
    public double getShippingCost() { return shippingCost; }
}