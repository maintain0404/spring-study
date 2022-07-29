package com.taein.springboot.example.domain.member.service;

import com.taein.springboot.example.domain.member.entity.Member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
