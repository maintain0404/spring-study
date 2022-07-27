package com.taein.springboot.example.order.service;

import com.taein.springboot.example.member.entity.Member;
import com.taein.springboot.example.discount.policy.DiscountPolicy;
import com.taein.springboot.example.discount.policy.DiscountPolicyFixedImpl;
import com.taein.springboot.example.member.repository.MemberRepository;
import com.taein.springboot.example.member.repository.MemberRepositoryMemoryImpl;
import com.taein.springboot.example.order.entity.Order;

public class OrderServiceDefaultImpl implements OrderService{
    private final MemberRepository memberRepository = new MemberRepositoryMemoryImpl();
    private final DiscountPolicy discountPolicy = new DiscountPolicyFixedImpl();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountedPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountedPrice);
    }

}
