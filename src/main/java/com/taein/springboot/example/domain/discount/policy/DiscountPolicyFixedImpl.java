package com.taein.springboot.example.domain.discount.policy;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

// 같은 빈에 한 클래스만 있어야 해서 얘는 @Component 안 함
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
