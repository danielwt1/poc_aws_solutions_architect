package com.aws.study.poc_aws_solutions_architect.infraestructure.in.rest.http.ctrl;

import com.aws.study.poc_aws_solutions_architect.domain.ports.in.CommentsApiPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/internal/comments-executor")
public class CommentsExecutorCtrl {

    private final CommentsApiPort commentsApiPort;

    public CommentsExecutorCtrl(CommentsApiPort commentsApiPort) {
        this.commentsApiPort = commentsApiPort;
    }

    @PostMapping
    public ResponseEntity<Void> executeCommentsFetch() {
        return ResponseEntity.ok().build();
    }


}
