package com.calllog.client;

import java.util.List;

import javax.annotation.Resource;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.calllog.model.Token;
import com.calllog.model.UserCallLogRecord;
import com.calllog.util.CallLogLiterals;

public class CallLogRestEntity {
	@Resource
    private RestTemplate restTemplate;

    private String credentials;

    private Token token;
    
    private String acceptType;

    private String callLogServiceUrl;

    public CallLogRestEntity(String credentials, String urlBase, String acceptType,String Token) {
        this.credentials = credentials;
        this.callLogServiceUrl = urlBase;
        this.acceptType = acceptType;
        //this.token =getAccessToken();
    }
   
    public UserCallLogRecord getCallRecordsById(String accountId, String extensionId, List<String> callRecordId, String view) {
    	if(token==null){
    		token = getAccessToken();
    	}
    	UserCallLogRecord  userCallLogRecord = null;
    	HttpHeaders headers = getHttpHeaders(acceptType, MediaType.APPLICATION_JSON);
    	HttpEntity<String> httpEntity = new HttpEntity<>(CallLogLiterals.PARAMETERS, headers);
        ResponseEntity<UserCallLogRecord> response = restTemplate.exchange(prepareCallLogService(accountId, extensionId, callRecordId, view), HttpMethod.GET, httpEntity, UserCallLogRecord.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
        	userCallLogRecord = response.getBody();
        }
        return userCallLogRecord;
    }
    
    private Token getAccessToken(){
    	Token token = null;
    	MultiValueMap<String, String> httpHeaders = getHttpHeadersForToken(acceptType);
    	HttpEntity<String> httpEntity = new HttpEntity<>(CallLogLiterals.PARAMETERS,httpHeaders);
        ResponseEntity<Token> response = restTemplate.exchange(prepareAuthorizationUri(), HttpMethod.GET, httpEntity, Token.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
        	token = response.getBody();
        }
        return token;
    }
    
    private MultiValueMap<String, String> getHttpHeadersForToken(String acceptHeader) {
        String plainCreds = credentials;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        headers.set("Accept", acceptHeader);
        headers.set("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        //headers.set("grant_type", "password&username=18582573546&extension=101&password=susi@1911");
        //Content-Type: application/x-www-form-urlencoded;charset=UTF-8
        //grant_type=password&username=18887776655&extension=102&password=Myp@ssw0rd
        return headers;
    }
    
    private String prepareAuthorizationUri() {
        StringBuilder uri = new StringBuilder(callLogServiceUrl);
        uri.append(CallLogLiterals.SLASH);
        uri.append(CallLogLiterals.OAUTH);
        uri.append(CallLogLiterals.SLASH);
        uri.append(CallLogLiterals.TOKEN);
        uri.append(CallLogLiterals.QUESTION);
        uri.append("grant_type=password&username=18582573546&extension=101&password=susi@1911");
        return uri.toString();
    }
    
    private HttpHeaders getHttpHeaders(String acceptHeader, MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+token);
        headers.set("Accept", acceptHeader);
        headers.set("Content-Type", "");
        headers.setContentType(mediaType);
        return headers;
    }
    
    private String prepareCallLogService(String accountId, String extensionId, List<String> callRecordId, String view) {
        StringBuilder uri = new StringBuilder(callLogServiceUrl);
        uri.append(CallLogLiterals.SLASH);
        uri.append(CallLogLiterals.VERSION);
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
