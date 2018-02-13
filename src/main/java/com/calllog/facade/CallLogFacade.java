package com.calllog.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.calllog.client.CallLogRestEntity;
import com.calllog.model.UserCallLogRecord;

@Component
public class CallLogFacade {
	
	@Autowired
	private CallLogRestEntity callLogRestEntity;
	
	public UserCallLogRecord getCallRecordsById(List<String> callRecordId, String extensionId, String accountId, String view) {
		return callLogRestEntity.getCallRecordsById(accountId, extensionId, callRecordId, view);
	}
}
