package com.taein.springboot.example.domain.member.repository;

import jakarta.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import com.taein.springboot.example.domain.member.entity.Member;
import com.taein.springboot.example.domain.member.enums.Grade;

// TODO: Figure out how to remove injecting implementation class from application context;
@SpringBootTest
@Transactional
@TestInstance(Lifecycle.PER_CLASS)
public interface MemberRepositoryTest<T extends MemberRepository> {

    T createMemberRepository();

    @Test
    default void testMember() {
        MemberRepository memberRepository = createMemberRepository();
        Member member = new Member("name", Grade.BASIC);
        Member memberSaved = memberRepository.save(member);

        Member memberFound = memberRepository.findById(memberSaved.getId()).get();

        Assertions.assertThat(memberFound.getId()).isEqualTo(member.getId());
    }

}
