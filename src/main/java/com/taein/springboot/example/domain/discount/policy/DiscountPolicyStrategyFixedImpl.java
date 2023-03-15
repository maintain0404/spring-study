package com.taein.springboot.example.domain.discount.policy;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

// 같은 빈에 한 클래스만 있어야 해서 얘는 @Component 안 함
public class DiscountPolicyStrategyFixedImpl implements DiscountPolicyStrategy {

    private Long discountFixAmount;
    
    public DiscountPolicyStrategyFixedImpl(Long amount) {
        this.discountFixAmount = amount;
    }
    @Override
    public Long discount(Member member, Long price) {
        if (member.getGrade() == Grade.VIP) {
            Long discounted = price - discountFixAmount;
            if (discounted <= 0) {
                return price;
            } else {
                return discounted;
            }
        } else {
            return price;
        }
    }

}
