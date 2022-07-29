package com.taein.springboot.example.domain.order;


import com.taein.springboot.example.core.AppConfig;
import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;
import com.taein.springboot.example.domain.member.service.MemberService;
import com.taein.springboot.example.domain.order.service.OrderService;
import com.taein.springboot.example.domain.order.entity.Order;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
