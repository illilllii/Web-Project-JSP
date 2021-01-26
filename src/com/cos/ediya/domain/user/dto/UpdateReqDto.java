package com.cos.ediya.domain.user.dto;

import lombok.Data;

@Data
public class UpdateReqDto {
	private String email;
	private String phone;
	private String password;
	private String nickname;
}
