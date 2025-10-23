package com.aws.study.poc_aws_solutions_architect.infraestructure.out.eventbus.dto;

import lombok.Builder;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class EventRequestDTO<T> extends ApplicationEvent {
    private UUID id;
    private String type;
    private T payload;

    @Builder
    public EventRequestDTO(UUID id, String type, T payload) {
        super(payload); // ApplicationEvent requiere un source, usamos el payload
        this.id = id;
        this.type = type;
        this.payload = payload;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public T getPayload() {
        return payload;
    }
}
