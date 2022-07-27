package com.taein.springboot.example.member.repository;

import com.taein.springboot.example.member.entity.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
