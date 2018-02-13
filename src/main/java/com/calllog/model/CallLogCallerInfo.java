package com.calllog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CallLogCallerInfo {
	private String phoneNumber;
	private String extensionNumber;
	private String location;
	private String name;
	private CallLogRecordDeviceInfo device;
}
