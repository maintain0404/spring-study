package com.taein.springboot.example.domain.member.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Transactional
class MemberRepositoryJpaImplTest implements MemberRepositoryTest<MemberRepositoryJpaImpl> {

    @Autowired
    ApplicationContext ac;

    @Override
    public MemberRepositoryJpaImpl createMemberRepository() {
        return ac.getBean(MemberRepositoryJpaImpl.class);
    }
}