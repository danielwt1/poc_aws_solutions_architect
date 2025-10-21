package com.aws.study.poc_aws_soluctions_architect.domain.ports.out;

import com.aws.study.poc_aws_soluctions_architect.domain.model.CommentsModel;

import java.util.List;

public interface CommentsPort {

    List<CommentsModel> fetchComments();
}
