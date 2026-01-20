package org.example.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;

    public CustomerEntity() {
    }

    public CustomerEntity(String fullName, String email, String address, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void printDetails() {
        System.out.println("Customer ID: " + id + " name: " + fullName + " email: " + email);
        System.out.println("Address: " + address + " phone: " + phoneNumber);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity customerEntity = (CustomerEntity) o;
        return id == customerEntity.id && Objects.equals(fullName, customerEntity.fullName) && Objects.equals(email, customerEntity.email) && Objects.equals(address, customerEntity.address) && Objects.equals(phoneNumber, customerEntity.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, address, phoneNumber);
    }
}