package com.cos.ediya.domain.admin.menu.drinks.dto;

import lombok.Data;

@Data
public class DrinksInsertReqDto {
	private String name;
	private String subname;
	private String content;
	private String imageSrc;
	private String kind;
	private String recommend;
}
