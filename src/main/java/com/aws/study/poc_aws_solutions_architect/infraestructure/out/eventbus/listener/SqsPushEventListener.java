package com.aws.study.poc_aws_solutions_architect.infraestructure.out.eventbus.listener;

import com.aws.study.poc_aws_solutions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_solutions_architect.infraestructure.out.eventbus.dto.EventRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SqsException;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class SqsPushEventListener {

    @Value("${url.sqs.message}")
    private String QUEUE_URL;

    private final SqsClient sqsClient;

    public SqsPushEventListener(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }



    @Async
    @EventListener
    public void onApplicationEvent(EventRequestDTO<Map<String, List<CommentsModel>>> event) {
        try{
            this.sqsClient.sendMessage(builder -> builder
                    .queueUrl("https://sqs.us-east-1.amazonaws.com/123456789012/MyQueue")
                    .messageBody(event.toString())
            );
        } catch(SqsException e){
            log.error("Error sending message to SQS: {}", e.getMessage());
        }

    }
}
