package com.cos.ediya.domain.drinks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drinks {
	private int id;
	private String name;
	private String subname;
	private String content;
	private String imageSrc;
	private String kind;
	private String recommend;
	
}
