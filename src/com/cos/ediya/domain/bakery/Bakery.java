package com.cos.ediya.domain.bakery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bakery {
	private int id;
	private String name;
	private String subname;
	private String content;
	private String imageSrc;
	private String kind;
	private String recommend;
}
