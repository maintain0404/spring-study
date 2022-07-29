package com.taein.springboot.example.domain.discount.policy;

import com.taein.springboot.example.domain.member.entity.Member;

public interface DiscountPolicy {
    /**
     * @return Discount price.
     */
    int discount(Member member, int price);
}
