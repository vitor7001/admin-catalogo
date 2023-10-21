package com.vitor.admin.catalogo.infrastructure.category;

import com.vitor.admin.catalogo.domain.category.Category;
import com.vitor.admin.catalogo.domain.category.CategoryGateway;
import com.vitor.admin.catalogo.domain.category.CategoryID;
import com.vitor.admin.catalogo.domain.category.CategorySearchQuery;
import com.vitor.admin.catalogo.domain.pagination.Pagination;
import com.vitor.admin.catalogo.infrastructure.category.persistence.CategoryJpaEntity;
import com.vitor.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import com.vitor.admin.catalogo.infrastructure.utils.SpecificationUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.Objects;
import java.util.Optional;

import static com.vitor.admin.catalogo.infrastructure.utils.SpecificationUtils.like;

@Service
public class CategoryMySQLGateway implements CategoryGateway {

    private final CategoryRepository repository;

    public CategoryMySQLGateway(final CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public void deleteById(final CategoryID anId) {
        final String anIdValue = anId.getValue();
        if (this.repository.existsById(anIdValue)) {
            this.repository.deleteById(anIdValue);
        }
    }

    @Override
    public Optional<Category> findById(final CategoryID anId) {
        return this.repository.findById(anId.getValue())
                .map(CategoryJpaEntity::toAggregate);
    }

    @Override
    public Category update(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public Pagination<Category> findAll(CategorySearchQuery aQuery) {

        //paginação
        final var page = PageRequest.of(
                aQuery.page(),
                aQuery.perPage(),
                Sort.by(Direction.fromString(aQuery.direction()), aQuery.sort())
        );

        //busca dinâmica pelo criterio terms (name ou description)
        final var specifications = Optional.ofNullable(aQuery.terms())
                .filter(str -> !str.isBlank())
                .map(str -> {
                            final Specification<CategoryJpaEntity> nameLike = like("name", str);
                            final Specification<CategoryJpaEntity> descriptionLike = like("description", str);
                            return nameLike.or(descriptionLike);
                        }
                )
                .orElse(null);

        final var pageResult = this.repository.findAll(Specification.where(specifications), page);
        return new Pagination<>(
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.map(CategoryJpaEntity::toAggregate).toList()
        );
    }

    private Category save(final Category aCategory) {
        return this.repository.save(CategoryJpaEntity.from(aCategory)).toAggregate();
    }
}
