package com.taein.springboot.example.domain.order.service;


import com.taein.springboot.example.domain.order.entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
