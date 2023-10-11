package com.vitor.admin.catalogo.infrastructure;

import com.vitor.admin.catalogo.application.UseCase;
import com.vitor.admin.catalogo.infrastructure.configuration.WebServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(WebServiceConfig.class ,args);
    }
}