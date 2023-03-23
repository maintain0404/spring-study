package com.taein.springboot.example.domain.order.service;

import com.taein.springboot.example.domain.discount.enums.DiscountPolicy;
import com.taein.springboot.example.domain.order.entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice, DiscountPolicy discountPolicy);
}
