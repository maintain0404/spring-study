
package com.taein.springboot.example.domain.order.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;
import com.taein.springboot.example.domain.member.service.MemberService;

@SpringBootTest
@Disabled("JPA 미적용 버전의 테스트. 리팩토링 필요")
public class OrderServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    OrderService orderService;

    @Test
    void createOrder() {
        Member member = new Member("memberA", Grade.VIP);
        memberService.join(member);

        // Order order = orderService.createOrder(member, "itemA", 10000);
        // Assertions.assertThat(order.getDiscountedPrice()).isEqualTo(1000);
    }
}
