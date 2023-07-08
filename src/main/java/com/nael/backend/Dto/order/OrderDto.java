package com.nael.backend.Dto.order;

import com.nael.backend.entity.Order;

public class OrderDto {
    private Integer id;
    private Integer customerId;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomer().getId();
    }

}
