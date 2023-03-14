package com.taein.springboot.example.domain.member.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.repository.MemberRepository;

@Primary
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

}
