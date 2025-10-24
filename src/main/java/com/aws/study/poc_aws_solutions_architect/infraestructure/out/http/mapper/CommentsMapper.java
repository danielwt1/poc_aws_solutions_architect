package com.aws.study.poc_aws_solutions_architect.infraestructure.out.http.mapper;

import com.aws.study.poc_aws_solutions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_solutions_architect.infraestructure.out.http.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CommentsMapper {
    PostDto toDto(CommentsModel commentsModel);
    List<CommentsModel> toModel(List<PostDto> postDto);
}
