package com.taein.springboot.example.discount.policy;

import com.taein.springboot.example.member.entity.Member;
import com.taein.springboot.example.member.enums.Grade;

public class DiscountPolicyFixedImpl implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}
