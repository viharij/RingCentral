package com.calllog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RecordingInfo {
	private String id;
	private String uri;
	private String type;
	private String contentUri ;
}
