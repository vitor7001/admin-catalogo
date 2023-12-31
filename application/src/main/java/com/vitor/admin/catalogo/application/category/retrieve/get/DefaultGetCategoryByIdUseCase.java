package com.vitor.admin.catalogo.application.category.retrieve.get;

import com.vitor.admin.catalogo.domain.category.CategoryGateway;
import com.vitor.admin.catalogo.domain.category.CategoryID;
import com.vitor.admin.catalogo.domain.exceptions.DomainException;
import com.vitor.admin.catalogo.domain.validation.Error;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetCategoryByIdUseCase extends GetCategoryByIdUseCase{

    private final CategoryGateway categoryGateway;

    public DefaultGetCategoryByIdUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public CategoryOutput execute(final String anIn) {
        final var anCategoryId = CategoryID.from(anIn);

        return this.categoryGateway.findById(anCategoryId)
                .map(CategoryOutput::from)
                .orElseThrow(notfound(anCategoryId));
    }

    private Supplier<DomainException> notfound(CategoryID anId) {
        return () -> DomainException.with(
                new Error("Category with ID %s was not found"
                        .formatted(anId.getValue())));
    }
}
