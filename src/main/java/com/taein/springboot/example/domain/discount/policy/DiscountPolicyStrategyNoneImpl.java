package com.taein.springboot.example.domain.discount.policy;

import com.taein.springboot.example.domain.member.entity.Member;

public class DiscountPolicyStrategyNoneImpl implements DiscountPolicyStrategy {
    public DiscountPolicyStrategyNoneImpl(Long amount) {
    }

    @Override
    public Long discount(Member member, Long price) {
        return price;
    }
}
