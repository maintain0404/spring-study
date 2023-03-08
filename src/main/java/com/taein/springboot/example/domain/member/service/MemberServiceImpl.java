package com.taein.springboot.example.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    
}
