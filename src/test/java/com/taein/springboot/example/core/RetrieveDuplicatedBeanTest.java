package com.taein.springboot.example.core;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.taein.springboot.example.domain.member.service.MemberService;

public class RetrieveDuplicatedBeanTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            RetrieveDuplicatedBeanTestConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 있으면 중복 오류")
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberService.class));
    }

    @Test
    @DisplayName("같은 타입이 둘 이상이라면, 이름으로")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService1", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("하위 타입 모두 조회")
    void findBeanBySubType() {
        Map<String, MemberService> beansOfType = ac.getBeansOfType(MemberService.class);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("Key = " + key + " value=" + beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("Object 하위 타입(모두) 조회")
    void findAllBeanObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        // Assertions.assertThat(beansOfType.size()).isEqualTo(2);
        // 기본적으로 주입되는 bean이 있어 2개가 아니다.
        for (String key : beansOfType.keySet()) {
            System.out.println("Key = " + key + " value=" + beansOfType.get(key));
        }
    }
}
