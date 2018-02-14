package com.calllog.model;

public class CallLogCallerInfo {
	private String phoneNumber;
	private String extensionNumber;
	private String location;
	private String name;
	private CallLogRecordDeviceInfo device;
	
	public CallLogCallerInfo() {
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getExtensionNumber() {
		return extensionNumber;
	}

	public void setExtensionNumber(String extensionNumber) {
		this.extensionNumber = extensionNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CallLogRecordDeviceInfo getDevice() {
		return device;
	}

	public void setDevice(CallLogRecordDeviceInfo device) {
		this.device = device;
	}
}
