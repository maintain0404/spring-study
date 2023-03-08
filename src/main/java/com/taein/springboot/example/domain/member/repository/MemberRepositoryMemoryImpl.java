package com.taein.springboot.example.domain.member.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.taein.springboot.example.domain.member.entity.Member;

@Component
public class MemberRepositoryMemoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

}
