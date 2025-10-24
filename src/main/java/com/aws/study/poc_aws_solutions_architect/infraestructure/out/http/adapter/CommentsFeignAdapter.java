package com.aws.study.poc_aws_solutions_architect.infraestructure.out.http.adapter;

import com.aws.study.poc_aws_solutions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_solutions_architect.domain.ports.out.CommentsPort;
import com.aws.study.poc_aws_solutions_architect.infraestructure.out.http.client.JsonPlaceHolderClient;
import com.aws.study.poc_aws_solutions_architect.infraestructure.out.http.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsFeignAdapter implements CommentsPort {

    private final JsonPlaceHolderClient jsonPlaceHolderClient;

    private final CommentsMapper commentsMapper;

    public CommentsFeignAdapter(JsonPlaceHolderClient jsonPlaceHolderClient, CommentsMapper commentsMapper) {
        this.jsonPlaceHolderClient = jsonPlaceHolderClient;
        this.commentsMapper = commentsMapper;
    }


    @Override
    public List<CommentsModel> fetchComments() {
        return this.commentsMapper.toModel(jsonPlaceHolderClient.getComments());
    }
}
