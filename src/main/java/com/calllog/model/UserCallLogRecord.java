package com.calllog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
}
