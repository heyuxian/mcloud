package me.javaroad.mcloud.blog.mapper;

import java.util.List;
import me.javaroad.mcloud.blog.dto.request.CategoryRequest;
import me.javaroad.mcloud.blog.dto.response.CategoryResponse;
import me.javaroad.mcloud.blog.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category mapRequestToEntity(CategoryRequest categoryRequest);

    CategoryResponse mapEntityToResponse(Category category);

    List<CategoryResponse> mapEntityToResponse(List<Category> categories);

    // TODO 根据需求自行定义
    void updateEntityFromRequest(CategoryRequest categoryRequest, @MappingTarget Category category);
}
