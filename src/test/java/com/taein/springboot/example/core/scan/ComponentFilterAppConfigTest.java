package com.taein.springboot.example.core.scan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.context.annotation.ComponentScan.Filter;

public class ComponentFilterAppConfigTest {
    
    @Test
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanIncluded bi = ac.getBean("beanIncluded", BeanIncluded.class);
        assertThat(bi).isNotNull();

        Assertions.assertThrows(
            NoSuchBeanDefinitionException.class,
            () -> ac.getBean("beanExcluded", BeanExcluded.class)
        );
    }

    @Configuration
    @ComponentScan(
        includeFilters = @Filter(type = FilterType.ANNOTATION, classes = IncludeComponent.class),
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = ExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
