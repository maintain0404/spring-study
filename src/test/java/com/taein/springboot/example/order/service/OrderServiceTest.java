package com.taein.springboot.example.order.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.taein.springboot.example.member.entity.Member;
import com.taein.springboot.example.member.enums.Grade;
import com.taein.springboot.example.member.service.MemberService;
import com.taein.springboot.example.member.service.MemberServiceImpl;
import com.taein.springboot.example.order.entity.Order;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceDefaultImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
