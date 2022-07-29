package com.taein.springboot.example.domain.member;

import com.taein.springboot.example.core.AppConfig;
import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;
import com.taein.springboot.example.domain.member.service.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L,  "memberA", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("found Member = " + foundMember.getName());
    }
    
}
