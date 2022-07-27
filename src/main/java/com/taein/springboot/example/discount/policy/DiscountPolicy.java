package com.taein.springboot.example.discount.policy;

import com.taein.springboot.example.member.entity.Member;

public interface DiscountPolicy {
    /**
     * @return Discount price.
     */
    int discount(Member member, int price);
}
