package com.aws.study.poc_aws_solutions_architect.domain.model;

public record CommentsModel(String postId, String id, String name, String email, String body) {
}
