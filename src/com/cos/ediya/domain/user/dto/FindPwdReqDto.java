package com.cos.ediya.domain.user.dto;

import lombok.Data;

@Data
public class FindPwdReqDto {
	private String email;
	private String phone;
}
