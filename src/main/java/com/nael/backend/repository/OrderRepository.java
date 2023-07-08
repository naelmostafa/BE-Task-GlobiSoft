package com.nael.backend.repository;

import com.nael.backend.entity.Customer;
import com.nael.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByCustomerOrderByCreatedDateDesc(Customer customer);
}
