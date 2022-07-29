package com.taein.springboot.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taein.springboot.example.domain.discount.policy.DiscountPolicy;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyFixedImpl;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyRateImpl;
import com.taein.springboot.example.domain.member.repository.MemberRepository;
import com.taein.springboot.example.domain.member.repository.MemberRepositoryMemoryImpl;
import com.taein.springboot.example.domain.member.service.MemberService;
import com.taein.springboot.example.domain.member.service.MemberServiceImpl;
import com.taein.springboot.example.domain.order.service.OrderService;
import com.taein.springboot.example.domain.order.service.OrderServiceDefaultImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(new MemberRepositoryMemoryImpl());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceDefaultImpl(
            new MemberRepositoryMemoryImpl(),
            new DiscountPolicyFixedImpl()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryMemoryImpl();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new DiscountPolicyRateImpl();
    }
}
