package com.cos.ediya.domain.notice;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notice {
	private int id;
	private String title;
	private String content;
	private Timestamp createDate;
	private String importantNotice; // 중요한 공지(맨 처음)
	
	public String getContent() {
		return content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	}
}
