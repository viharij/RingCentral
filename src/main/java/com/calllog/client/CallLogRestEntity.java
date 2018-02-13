package com.calllog.client;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.calllog.model.UserCallLogRecord;
import com.calllog.util.CallLogLiterals;

public class CallLogRestEntity {
	private static final String PARAMETERS = "parameters";
	 
	@Resource
    private RestTemplate restTemplate;

    private String token;

    private String acceptType;

    private String callLogServiceUrl;

    public CallLogRestEntity(String token, String urlBase, String acceptType) {
        this.token = token;
        this.callLogServiceUrl = urlBase;
        this.acceptType = acceptType;
    }
   
    public UserCallLogRecord getCallRecordsById(String accountId, String extensionId, List<String> callRecordId, String view) {
    	UserCallLogRecord  userCallLogRecord = null;
    	HttpHeaders headers = getHttpHeaders(acceptType, MediaType.APPLICATION_JSON);
    	HttpEntity<String> httpEntity = new HttpEntity<>(PARAMETERS, headers);
        ResponseEntity<UserCallLogRecord> response = restTemplate.exchange(prepareCallLogService(accountId, extensionId, callRecordId, view), HttpMethod.GET, httpEntity, new ParameterizedTypeReference<UserCallLogRecord>() {});
        if (response.getStatusCode().equals(HttpStatus.OK)) {
        	userCallLogRecord = response.getBody();
        }
        return userCallLogRecord;
    }

    public HttpHeaders getHttpHeaders(String acceptHeader, MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+token);
        headers.set("Accept", acceptHeader);
        headers.set("Content-Type", acceptHeader);
        headers.setContentType(mediaType);
        return headers;
    }

    private String prepareCallLogService(String accountId, String extensionId, List<String> callRecordId, String view) {
        StringBuilder uri = new StringBuilder(callLogServiceUrl);
        uri.append(CallLogLiterals.SLASH);
        uri.append(CallLogLiterals.ACCOUNT);
        uri.append(CallLogLiterals.SLASH);
        uri.append(accountId);
        uri.append(CallLogLiterals.SLASH);
        uri.append(CallLogLiterals.EXTENSION);
        uri.append(CallLogLiterals.SLASH);
        uri.append(extensionId);
        uri.append(CallLogLiterals.SLASH);
        uri.append(CallLogLiterals.CALL_LOG);
        uri.append(CallLogLiterals.SLASH);
        uri.append(callRecordId.toString());
        uri.append(CallLogLiterals.QUESTION);
        uri.append(CallLogLiterals.VIEW);
        uri.append(CallLogLiterals.EQUAL);
        uri.append(view);
        return uri.toString();
    }
}
