package com.aws.study.poc_aws_soluctions_architect.domain.usecase;

import com.aws.study.poc_aws_soluctions_architect.domain.ports.in.CommentsApiPort;
import com.aws.study.poc_aws_soluctions_architect.domain.ports.out.CommentsPort;

public class CommentsUseCase implements CommentsApiPort {

    private final CommentsPort commentsPort;

    public CommentsUseCase(CommentsPort commentsPort) {
        this.commentsPort = commentsPort;
    }

    @Override
    public void executeTransform() {

    }
}
