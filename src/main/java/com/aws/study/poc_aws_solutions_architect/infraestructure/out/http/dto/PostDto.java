package com.aws.study.poc_aws_solutions_architect.infraestructure.out.http.dto;


public record PostDto(String postId, String id, String name, String email, String body) {
}
