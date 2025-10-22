package com.aws.study.poc_aws_soluctions_architect.infraestructure.out.eventbus.listener;

import com.aws.study.poc_aws_soluctions_architect.domain.model.CommentsModel;
import com.aws.study.poc_aws_soluctions_architect.infraestructure.out.eventbus.dto.EventRequestDTO;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SqsPushEventListener {


    @Async
    @EventListener
    public void onApplicationEvent(EventRequestDTO<Map<String, List<CommentsModel>>> event) {

    }
}
