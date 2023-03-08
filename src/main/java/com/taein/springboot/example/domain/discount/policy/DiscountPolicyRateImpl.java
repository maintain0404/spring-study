package com.taein.springboot.example.domain.discount.policy;

import org.springframework.stereotype.Component;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

@Component
public class DiscountPolicyRateImpl implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
    
}
