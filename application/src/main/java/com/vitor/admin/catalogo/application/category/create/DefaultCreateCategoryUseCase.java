package com.vitor.admin.catalogo.application.category.create;

import com.vitor.admin.catalogo.domain.category.Category;
import com.vitor.admin.catalogo.domain.category.CategoryGateway;
import com.vitor.admin.catalogo.domain.validation.handler.Notification;
import com.vitor.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Try;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand aCommand) {

        final var aName = aCommand.name();
        final var aDescription = aCommand.description();
        final var isActive = aCommand.isActive();

        final var notification = Notification.create();

        final var aCategory = Category.newCategory(aName, aDescription, isActive);

        aCategory.validate(notification);


        return notification.hasError() ? API.Left(notification) : create(aCategory);
    }

    private Either<Notification, CreateCategoryOutput> create(final Category aCategory) {

        return Try(()  -> this.categoryGateway.create(aCategory))
                .toEither()
                .bimap(Notification::create, CreateCategoryOutput::from );

    }
}
