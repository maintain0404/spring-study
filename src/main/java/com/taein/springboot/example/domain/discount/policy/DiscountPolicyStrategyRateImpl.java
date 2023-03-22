package com.taein.springboot.example.domain.discount.policy;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

public class DiscountPolicyStrategyRateImpl implements DiscountPolicyStrategy {

    private Long discountPercent;

    public DiscountPolicyStrategyRateImpl(Long amount) {
        this.discountPercent = amount;
    }

    @Override
    public Long discount(Member member, Long price) {
        if (member.getGrade() == Grade.VIP) {
            return price - (price * discountPercent / 100);
        } else {
            return price;
        }
    }   
}
