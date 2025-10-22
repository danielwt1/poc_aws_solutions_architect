package com.aws.study.poc_aws_soluitions_architect.config;

import com.aws.study.poc_aws_soluctions_architect.config.executor.BoundedExecutor;
import feign.Client;
import feign.hc5.ApacheHttp5Client;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class BeansConfiguration {

    private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    @Bean
    public Client feignClient() {
        final PoolingHttpClientConnectionManager connManager = PoolingHttpClientConnectionManagerBuilder.create().build();

        connManager.setMaxTotal(1000);
        connManager.setDefaultMaxPerRoute(1000);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();
        return new ApacheHttp5Client(httpClient);
    }

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster =
                new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(new BoundedExecutor(executor, 50));
        return eventMulticaster;
    }

}