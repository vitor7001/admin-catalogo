package com.vitor.admin.catalogo.application;

import com.vitor.admin.catalogo.IntegrationTest;
import com.vitor.admin.catalogo.application.category.create.CreateCategoryUseCase;
import com.vitor.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@IntegrationTest
public class SampleIT {

    @Autowired
    private CreateCategoryUseCase useCase;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testInjection(){
        Assertions.assertNotNull(useCase);
        Assertions.assertNotNull(categoryRepository);
    }
}
