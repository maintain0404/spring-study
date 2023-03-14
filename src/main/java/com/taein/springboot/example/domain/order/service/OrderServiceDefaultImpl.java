package com.taein.springboot.example.domain.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taein.springboot.example.domain.discount.policy.DiscountPolicy;
import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.repository.MemberRepository;
import com.taein.springboot.example.domain.order.entity.Order;

@Component
public class OrderServiceDefaultImpl implements OrderService {
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceDefaultImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId).get();
        int discountedPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountedPrice);
    }

}
