package com.taein.springboot.example.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategy;
import com.taein.springboot.example.domain.discount.policy.DiscountPolicyStrategyNoneImpl;

class BeanFieldTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + " object=" + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name" + beanDefinitionName + " object=" + bean);
            }
        }
    }

    @Test
    @DisplayName("Bean 이름으로 조회")
    void findBeanByName() {
        DiscountPolicyStrategy discountPolicyStrategy = ac.getBean("discountPolicyStrategy", DiscountPolicyStrategy.class);
        assertThat(discountPolicyStrategy).isInstanceOf(DiscountPolicyStrategy.class);
    }

    @Test
    @DisplayName("타입으로만 조회")
    void findBeanByType() {
        DiscountPolicyStrategy discountPolicyStrategy = ac.getBean(DiscountPolicyStrategy.class);
        assertThat(discountPolicyStrategy).isInstanceOf(DiscountPolicyStrategy.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        DiscountPolicyStrategy discountPolicyStrategy = ac.getBean("discountPolicyStrategy", DiscountPolicyStrategyNoneImpl.class);
        assertThat(discountPolicyStrategy).isInstanceOf(DiscountPolicyStrategyNoneImpl.class);
    }

    @Test
    @DisplayName("이름없이 조회")
    void findBeanWithoutName() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class , () -> ac.getBean("NO", DiscountPolicyStrategy.class));
    }
}


 