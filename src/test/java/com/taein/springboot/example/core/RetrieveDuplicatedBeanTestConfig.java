package com.taein.springboot.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taein.springboot.example.domain.member.repository.MemberRepositoryMemoryImpl;
import com.taein.springboot.example.domain.member.service.MemberService;
import com.taein.springboot.example.domain.member.service.MemberServiceImpl;

@Configuration
public class RetrieveDuplicatedBeanTestConfig {

    @Bean
    public MemberService memberService1() {
        return new MemberServiceImpl(new MemberRepositoryMemoryImpl());
    }

    @Bean
    public MemberService memberService2() {
        return new MemberServiceImpl(new MemberRepositoryMemoryImpl());
    }
}
