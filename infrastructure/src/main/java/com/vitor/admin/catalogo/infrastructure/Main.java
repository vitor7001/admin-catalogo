package com.vitor.admin.catalogo.infrastructure;

import com.vitor.admin.catalogo.application.UseCase;
import com.vitor.admin.catalogo.application.category.create.CreateCategoryUseCase;
import com.vitor.admin.catalogo.application.category.delete.DeleteCategoryUseCase;
import com.vitor.admin.catalogo.application.category.retrieve.get.GetCategoryByIdUseCase;
import com.vitor.admin.catalogo.application.category.retrieve.list.ListCategoriesUseCase;
import com.vitor.admin.catalogo.application.category.update.UpdateCategoryUseCase;
import com.vitor.admin.catalogo.infrastructure.configuration.WebServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "development");
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "development");
        SpringApplication.run(WebServiceConfig.class ,args);
    }

}