package com.vitor.admin.catalogo.application.category.create;

import com.vitor.admin.catalogo.domain.category.Category;
import com.vitor.admin.catalogo.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {
    public static  CreateCategoryOutput from(final Category aCategory){
        return new CreateCategoryOutput(aCategory.getId());
    }

    public static  CreateCategoryOutput from(final CategoryID anId){
        return new CreateCategoryOutput(anId);
    }
}
