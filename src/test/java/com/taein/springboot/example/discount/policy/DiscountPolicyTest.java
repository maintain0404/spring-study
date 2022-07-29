package com.taein.springboot.example.discount.policy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.taein.springboot.example.domain.discount.policy.DiscountPolicy;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyRateImpl;
import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

public class DiscountPolicyTest {
    DiscountPolicy discountPolicy = new DiscountPolicyRateImpl();

    @Test
    @DisplayName("VIP 10% 할인이 적용되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);
        
        Assertions.assertThat(discount).isEqualTo(0);
    }

}
