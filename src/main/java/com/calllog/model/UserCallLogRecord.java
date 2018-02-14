package com.calllog.model;

public class UserCallLogRecord  {
	private String id;
	private String uri;
	private String sessionId;
	private CallLogCallerInfo from;
	private CallLogCallerInfo to;
	private String type;
	private String direction;
	private String startTime;
	private Integer duration;
	private RecordingInfo recording;
	
	public UserCallLogRecord() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public CallLogCallerInfo getFrom() {
		return from;
	}

	public void setFrom(CallLogCallerInfo from) {
		this.from = from;
	}

	public CallLogCallerInfo getTo() {
		return to;
	}

	public void setTo(CallLogCallerInfo to) {
		this.to = to;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public RecordingInfo getRecording() {
		return recording;
	}

	public void setRecording(RecordingInfo recording) {
		this.recording = recording;
	}
}
