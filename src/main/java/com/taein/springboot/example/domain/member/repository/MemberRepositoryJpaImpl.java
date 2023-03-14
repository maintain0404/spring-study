package com.taein.springboot.example.domain.member.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.taein.springboot.example.domain.member.entity.Member;

@Primary
@Repository
public class MemberRepositoryJpaImpl implements MemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.of(em.find(Member.class, memberId));
    }
}
