package com.calllog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.calllog.facade.CallLogFacade;
import com.calllog.model.UserCallLogRecord;

@RestController
@RequestMapping(value="/api/v1")
public class CallLogController {

	@Autowired
	private CallLogFacade callLogfacade;
	
	@RequestMapping(method=RequestMethod.GET, value="/account/{accountId}/extension/{extensionId}/call-log/{callRecordId}")
	@ResponseBody
	@ResponseStatus
	public ResponseEntity<UserCallLogRecord> getCallRecordsById(@PathVariable(name="callRecordId") List<String> callRecordId,
																@PathVariable(name="extensionId") String extensionId, 
																@PathVariable(name="accountId") String accountId,
																@RequestParam(name="view") String view) {
		callLogfacade.getCallRecordsById(callRecordId, extensionId, accountId, view);
		return null;
	}
	
}
