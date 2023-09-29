package com.vitor.admin.catalogo.application.category.update;

import com.vitor.admin.catalogo.application.UseCase;
import com.vitor.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase extends UseCase<UpdateCategoryCommand,
        Either<Notification, UpdateCategoryOutput>> {
}
