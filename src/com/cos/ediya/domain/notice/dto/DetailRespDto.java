package com.cos.ediya.domain.notice.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DetailRespDto {
	private int id;
	private String title;
	private String content;
	private Timestamp createDate;
	private String importantNotice;
	
	public String getContent() {
		return content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	}
}
