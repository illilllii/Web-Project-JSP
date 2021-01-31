package com.cos.ediya.domain.admin.menu.bakery.dto;

import lombok.Data;

@Data
public class BakeryDetailRespDto {
	private int id;
	private String name;
	private String subname;
	private String content;
	private String imageSrc;
	private String kind;
	private String recommend;
}
