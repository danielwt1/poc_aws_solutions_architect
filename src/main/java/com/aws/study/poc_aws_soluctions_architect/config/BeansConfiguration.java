package com.aws.study.poc_aws_soluctions_architect.config;

import feign.Client;
import feign.hc5.ApacheHttp5Client;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

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
}