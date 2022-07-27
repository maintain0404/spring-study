package com.taein.springboot.example.member.repository;

import java.util.HashMap;
import java.util.Map;

import com.taein.springboot.example.member.entity.Member;

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
