package com.taein.springboot.example.member.service;

import com.taein.springboot.example.member.entity.Member;
import com.taein.springboot.example.member.repository.MemberRepository;
import com.taein.springboot.example.member.repository.MemberRepositoryMemoryImpl;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemberRepositoryMemoryImpl();

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    
}
