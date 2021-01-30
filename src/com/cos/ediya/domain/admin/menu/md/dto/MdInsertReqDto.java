package com.cos.ediya.domain.admin.menu.md.dto;

import lombok.Data;

@Data
public class MdInsertReqDto {
	private String name;
	private String content;
	private String imageSrc;
	private String recommend;
}
