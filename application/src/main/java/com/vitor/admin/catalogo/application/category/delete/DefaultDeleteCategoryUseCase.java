package com.vitor.admin.catalogo.application.category.delete;

import com.vitor.admin.catalogo.domain.category.CategoryGateway;
import com.vitor.admin.catalogo.domain.category.CategoryID;

import java.util.Objects;

public class DefaultDeleteCategoryUseCase extends DeleteCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public DefaultDeleteCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public void execute(String anIn) {
        this.categoryGateway.deleteById(CategoryID.from(anIn));
    }
}
