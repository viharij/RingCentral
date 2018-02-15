package com.calllog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.calllog.client.CallLogRestEntity;

@Configuration
public class RestEntityConfig {

	public final static String APPLICATION_JSON_VALUE = "application/json";
   
    @Value("${clientid}:${clientsecret}")
    private String credentials;

    @Value("${callLog.url}")
    private String callLogServiceURL;
    
    private String token;

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
        return new CallLogRestEntity(credentials, callLogServiceURL, APPLICATION_JSON_VALUE,token);
    }
    
    
          
   
    
   

}