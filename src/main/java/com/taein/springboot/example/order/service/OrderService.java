package com.taein.springboot.example.order.service;


import com.taein.springboot.example.order.entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
