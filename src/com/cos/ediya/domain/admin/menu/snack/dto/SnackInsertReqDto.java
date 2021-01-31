package com.cos.ediya.domain.admin.menu.snack.dto;

import lombok.Data;

@Data
public class SnackInsertReqDto {
	private String name;
	private String subname;
	private String content;
	private String imageSrc;
	private String kind;
	private String recommend;
}
