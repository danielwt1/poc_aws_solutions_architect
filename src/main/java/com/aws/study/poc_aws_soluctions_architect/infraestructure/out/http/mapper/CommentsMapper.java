package com.aws.study.poc_aws_soluctions_architect.infraestructure.out.http.mapper;

import com.aws.study.poc_aws_soluctions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_soluctions_architect.infraestructure.out.http.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CommentsMapper {
    PostDto toDto(CommentsModel commentsModel);
    CommentsModel toModel(PostDto postDto);
}
