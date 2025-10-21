package com.aws.study.poc_aws_soluctions_architect.infraestructure.out.http.client;

import com.aws.study.poc_aws_soluctions_architect.infraestructure.out.http.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "jsonPlaceHolderClient", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceHolderClient {
    @GetMapping("/comments")
    List<PostDto> getComments();
}

