package com.taein.springboot.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategy;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategyNoneImpl;

@Configuration
public class AppConfig {

    // @Bean
    // public MemberService memberService() {
    // return new MemberServiceImpl(new MemberRepositoryMemoryImpl());
    // }

    // @Bean
    // public OrderService orderService() {
    // return new OrderServiceDefaultImpl(
    // new MemberRepositoryMemoryImpl(),
    // new DiscountPolicyFixedImpl());
    // }

    @Bean
    public DiscountPolicyStrategy discountPolicyStrategy() {
        return new DiscountPolicyStrategyNoneImpl(null);
    }
}
