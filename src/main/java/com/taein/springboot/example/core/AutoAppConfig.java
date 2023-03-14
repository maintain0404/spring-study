package com.taein.springboot.example.core;

import org.springframework.context.annotation.ComponentScan;

import com.taein.springboot.example.ExampleApplication;

@ComponentScan(
        // Give definite scan scopes.
        // or you can use basePackages with package path string.
        basePackageClasses = ExampleApplication.class)
public class AutoAppConfig {
}
