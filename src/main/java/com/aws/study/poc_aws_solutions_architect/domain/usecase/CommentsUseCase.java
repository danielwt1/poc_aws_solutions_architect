package com.aws.study.poc_aws_solutions_architect.domain.usecase;

import com.aws.study.poc_aws_solutions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_solutions_architect.domain.ports.in.CommentsApiPort;
import com.aws.study.poc_aws_solutions_architect.domain.ports.out.CommentsPort;
import com.aws.study.poc_aws_solutions_architect.domain.ports.out.PushToEventBus;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class CommentsUseCase implements CommentsApiPort {

    private final CommentsPort commentsPort;

    private final PushToEventBus pushToEventBus;

    public CommentsUseCase(CommentsPort commentsPort, PushToEventBus pushToEventBus) {
        this.commentsPort = commentsPort;
        this.pushToEventBus = pushToEventBus;
    }

    @Override
    public void executeTransform() {
        var comments = commentsPort.fetchComments();
        log.info("Comments fetched, init grouping by .com emails");
        Map<String, List<CommentsModel>> groupedComments = comments.stream()
                .collect(Collectors.groupingBy(CommentsModel::email));
        log.info("Comments grouped end emails: {}", groupedComments);
        pushToEventBus.publishEvent(groupedComments);
    }
}
