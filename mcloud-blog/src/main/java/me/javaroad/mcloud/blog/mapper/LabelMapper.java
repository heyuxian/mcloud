package me.javaroad.mcloud.blog.mapper;

import me.javaroad.mcloud.blog.dto.request.LabelRequest;
import me.javaroad.mcloud.blog.dto.response.LabelResponse;
import me.javaroad.mcloud.blog.entity.Label;
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
