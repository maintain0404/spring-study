package com.taein.springboot.example.domain.member.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

import org.assertj.core.api.Assertions;

@SpringBootTest
@Disabled("JPA 미적용 버전의 테스트. 리팩토링 필요")
@DataJpaTest
public class MemberServiceTest {
    
    @Autowired
    MemberService memberService;

    @Test
    void join() {
        Member member = new Member("memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
