package com.taein.springboot.example.domain.member.repository;

import java.util.Optional;

import com.taein.springboot.example.domain.member.entity.Member;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long memberId);
}
