package com.taein.springboot.example.member.service;

import org.junit.jupiter.api.Test;

import com.taein.springboot.example.member.entity.Member;
import com.taein.springboot.example.member.enums.Grade;

import org.assertj.core.api.Assertions;

public class MemberServiceTest {
    
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
