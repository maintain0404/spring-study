package com.taein.springboot.example.domain.member.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.taein.springboot.example.domain.member.entity.Member;

@Repository
public class MemberRepositoryMemoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.of(store.get(memberId));
    }

    @Override
    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

}
