package com.cos.ediya.domain.notice.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ImportantNoticeRespDto {
	private int id;
	private String title;
	private String content;
	private Timestamp createDate;
}
