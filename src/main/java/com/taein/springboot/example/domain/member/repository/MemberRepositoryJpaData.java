package com.taein.springboot.example.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taein.springboot.example.domain.member.entity.Member;

public interface MemberRepositoryJpaData extends JpaRepository<Member, Long>, MemberRepository {

}
