package com.cos.ediya.domain.md;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Md {
	private int id;
	private String name;
	private String content;
	private String imageSrc;
	private String recommend;
}
