package com.aws.study.poc_aws_solutions_architect.infraestructure.out.eventbus.publisher;

import com.aws.study.poc_aws_solutions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_solutions_architect.domain.ports.out.PushToEventBus;
import com.aws.study.poc_aws_solutions_architect.infraestructure.out.eventbus.dto.EventRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class EventPublisherAdapter implements PushToEventBus {
    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(Map<String, List<CommentsModel>> event) {
        log.info("Publishing event: {}", event);
        EventRequestDTO<Map<String, List<CommentsModel>>> payload = EventRequestDTO.<Map<String, List<CommentsModel>>>builder()
                .id(UUID.randomUUID())
                .type("CommentsGroupedByEmailEvent")
                .payload(event).build();
        applicationEventPublisher.publishEvent(payload);
    }
}
