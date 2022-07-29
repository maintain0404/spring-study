package com.taein.springboot.example.core;

import com.taein.springboot.example.domain.discount.policy.DiscountPolicy;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyFixedImpl;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyRateImpl;
import com.taein.springboot.example.domain.member.repository.MemberRepository;
import com.taein.springboot.example.domain.member.repository.MemberRepositoryMemoryImpl;
import com.taein.springboot.example.domain.member.service.MemberService;
import com.taein.springboot.example.domain.member.service.MemberServiceImpl;
import com.taein.springboot.example.domain.order.service.OrderService;
import com.taein.springboot.example.domain.order.service.OrderServiceDefaultImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemberRepositoryMemoryImpl());
    }

    public OrderService orderService() {
        return new OrderServiceDefaultImpl(
            new MemberRepositoryMemoryImpl(),
            new DiscountPolicyFixedImpl()
        );
    }
    
    public MemberRepository memberRepository() {
        return new MemberRepositoryMemoryImpl();
    }

    public DiscountPolicy discountPolicy() {
        return new DiscountPolicyRateImpl();
    }
}
