package com.taein.springboot.example.domain.discount.policy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

public interface DiscountPolicyStrategyTest<T extends DiscountPolicyStrategy> {

    T getDiscountPolicyStrategy();

    @Test
    @DisplayName("VIP이면 할인이 적용되어야 한다.")
    default void vip_o() {
        Member member = new Member("memberVIP", Grade.VIP);

        Long discount = getDiscountPolicyStrategy().discount(member, 10000L);

        Assertions.assertThat(discount).isLessThan(10000L);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    default void vip_x() {
        Member member = new Member("memberVIP", Grade.BASIC);

        Long discount = getDiscountPolicyStrategy().discount(member, 10000L);

        Assertions.assertThat(discount).isEqualTo(10000L);
    }

}
