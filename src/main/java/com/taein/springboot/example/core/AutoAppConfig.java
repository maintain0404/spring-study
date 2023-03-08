package com.taein.springboot.example.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.taein.springboot.example.ExampleApplication;

import static org.springframework.context.annotation.ComponentScan.*;

@ComponentScan(
    // Give definite scan scopes.
    // or you can use basePackages with package path string.
    basePackageClasses = ExampleApplication.class,
    excludeFilters = @Filter(
        type = FilterType.ANNOTATION, classes = Configuration.class
    )
)
public class AutoAppConfig {
    
}
