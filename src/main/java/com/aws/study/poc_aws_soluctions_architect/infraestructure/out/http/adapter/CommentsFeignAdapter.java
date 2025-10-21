package com.aws.study.poc_aws_soluctions_architect.infraestructure.out.http.adapter;

import com.aws.study.poc_aws_soluctions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_soluctions_architect.domain.ports.out.CommentsPort;
import com.aws.study.poc_aws_soluctions_architect.infraestructure.out.http.client.JsonPlaceHolderClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsFeignAdapter implements CommentsPort {

    private final JsonPlaceHolderClient jsonPlaceHolderClient;

    public CommentsFeignAdapter(JsonPlaceHolderClient jsonPlaceHolderClient) {
        this.jsonPlaceHolderClient = jsonPlaceHolderClient;
    }


    @Override
    public List<CommentsModel> fetchComments() {
        return List.of();
    }
}
