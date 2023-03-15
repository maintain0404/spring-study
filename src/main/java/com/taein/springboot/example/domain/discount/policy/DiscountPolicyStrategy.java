package com.taein.springboot.example.domain.discount.policy;

import com.taein.springboot.example.domain.member.entity.Member;

public interface DiscountPolicyStrategy {
    /**
     * @return Discount price.
     */
    Long discount(Member member, Long price);
}
