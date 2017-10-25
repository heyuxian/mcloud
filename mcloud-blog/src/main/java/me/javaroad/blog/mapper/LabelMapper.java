package me.javaroad.blog.mapper;

import me.javaroad.blog.dto.request.LabelRequest;
import me.javaroad.blog.dto.response.LabelResponse;
import me.javaroad.blog.entity.Label;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface LabelMapper {

    LabelMapper INSTANCE = Mappers.getMapper(LabelMapper.class);

    Label mapRequestToEntity(LabelRequest labelRequest);

    LabelResponse mapEntityToResponse(Label label);
}
