package com.calllog.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.calllog.client.CallLogRestEntity;

@Configuration
public class RestEntityConfig {

	public final static String APPLICATION_JSON_VALUE = "application/json";
   
    @Value("${token}")
    private String token;

    @Value("${callLog.url}")
    private String callLogServiceURL;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        //restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        //restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    @Bean
    public CallLogRestEntity callLogRestEntity() {
        return new CallLogRestEntity(token, callLogServiceURL, APPLICATION_JSON_VALUE);
    }

}