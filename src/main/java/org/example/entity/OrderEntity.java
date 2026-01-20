package org.example.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> itemEntities;


    private double totalAmount;
    private double discount;
    private double shippingCost;

    public OrderEntity() {
    }

    public OrderEntity(CustomerEntity customerEntity, List<ItemEntity> itemEntities,
                       double totalAmount, double discount, double shippingCost) {
        this.customerEntity = customerEntity;
        this.itemEntities = itemEntities;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.shippingCost = shippingCost;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customerEntity;
    }

    public void setCustomer(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public List<ItemEntity> getItems() {
        return itemEntities;
    }

    public void setItems(List<ItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
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
        return "Order{" +
                "id=" + id +
                ", customer=" + customerEntity +
                ", items=" + (itemEntities == null ? null : itemEntities.size() + " items") +
                ", totalAmount=" + totalAmount +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity orderEntity = (OrderEntity) o;
        return id == orderEntity.id && Double.compare(totalAmount, orderEntity.totalAmount) == 0 && Double.compare(discount, orderEntity.discount) == 0 && Double.compare(shippingCost, orderEntity.shippingCost) == 0 && Objects.equals(customerEntity, orderEntity.customerEntity) && Objects.equals(itemEntities, orderEntity.itemEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerEntity, itemEntities, totalAmount, discount, shippingCost);
    }
}