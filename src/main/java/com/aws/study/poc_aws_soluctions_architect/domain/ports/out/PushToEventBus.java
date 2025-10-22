package com.aws.study.poc_aws_soluctions_architect.domain.ports.out;

import com.aws.study.poc_aws_soluctions_architect.domain.model.CommentsModel;

import java.util.List;
import java.util.Map;

public interface PushToEventBus {
    void publishEvent(Map<String, List<CommentsModel>> event);
}
