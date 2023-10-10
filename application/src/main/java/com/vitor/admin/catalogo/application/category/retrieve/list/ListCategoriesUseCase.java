package com.vitor.admin.catalogo.application.category.retrieve.list;

import com.vitor.admin.catalogo.application.UseCase;
import com.vitor.admin.catalogo.domain.category.CategorySearchQuery;
import com.vitor.admin.catalogo.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase
extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}
