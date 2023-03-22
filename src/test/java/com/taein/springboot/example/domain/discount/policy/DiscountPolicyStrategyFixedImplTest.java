package com.taein.springboot.example.domain.discount.policy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

public class DiscountPolicyStrategyFixedImplTest implements DiscountPolicyStrategyTest<DiscountPolicyStrategyFixedImpl>{

    private final Long amount = 10L;

    @Override
    public DiscountPolicyStrategyFixedImpl getDiscountPolicyStrategy() {
        return new DiscountPolicyStrategyFixedImpl(amount);
    }

    @Test
    @DisplayName("원가를 넘어선 할인은 불가능하다.")
    public void discountOverPriceIsImpossible() {
        DiscountPolicyStrategy discountPolicyStrategy = getDiscountPolicyStrategy();
        Member member = new Member("NAME", Grade.VIP);

        Assertions.assertThat(discountPolicyStrategy.discount(member, 1L)).isEqualTo(1L);
    }
}
