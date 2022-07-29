package com.taein.springboot.example.domain.member.repository;

import com.taein.springboot.example.domain.member.entity.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
