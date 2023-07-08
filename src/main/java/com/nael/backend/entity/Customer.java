package com.nael.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String number;
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;


    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Customer(String name, String number, Set<Order> orders) {
        this.name = name;
        this.number = number;
        this.orders = orders;
    }

    public Customer(Integer id, String name, String number, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", orders=" + orders +
                '}';
    }
}
