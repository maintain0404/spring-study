package com.taein.springboot.example.domain.member.repository;

public class MemberRepositoryMemoryImplTest implements MemberRepositoryTest<MemberRepositoryMemoryImpl> {

    public MemberRepositoryMemoryImpl createMemberRepository() {
        return new MemberRepositoryMemoryImpl();
    }
}
