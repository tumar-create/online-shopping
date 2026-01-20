package org.example.dto;

import java.util.List;
import java.util.Objects;

public class OrderDto {

    private Integer id;
    private CustomerDto customerDto;
    private List<ItemDto> items;

    private double totalAmount;
    private double discount;
    private double shippingCost;

    public OrderDto(CustomerDto customerDto, List<ItemDto> items, double totalAmount, double discount, double shippingCost) {
        this.customerDto = customerDto;
        this.items = items;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.shippingCost = shippingCost;
    }

    public OrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", customerDto=" + customerDto +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return id == orderDto.id && Double.compare(totalAmount, orderDto.totalAmount) == 0 && Double.compare(discount, orderDto.discount) == 0 && Double.compare(shippingCost, orderDto.shippingCost) == 0 && Objects.equals(customerDto, orderDto.customerDto) && Objects.equals(items, orderDto.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerDto, items, totalAmount, discount, shippingCost);
    }
}