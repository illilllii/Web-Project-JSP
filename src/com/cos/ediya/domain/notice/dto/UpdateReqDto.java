package com.cos.ediya.domain.notice.dto;

import lombok.Data;

@Data
public class UpdateReqDto {
	private int id;
	private String title;
	private String content;
}
