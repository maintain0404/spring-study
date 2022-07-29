package com.taein.springboot.example.domain.member.service;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

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