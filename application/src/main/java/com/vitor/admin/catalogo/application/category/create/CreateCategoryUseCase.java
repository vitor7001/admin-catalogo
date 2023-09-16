package com.vitor.admin.catalogo.application.category.create;

import com.vitor.admin.catalogo.application.UseCase;
import com.vitor.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends
        UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
