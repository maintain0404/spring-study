package com.taein.springboot.example.member.service;

import com.taein.springboot.example.member.entity.Member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
