package com.cos.ediya.domain.user.dto;

import lombok.Data;

@Data
public class JoinReqDto {
	private int id;
	private String email;
	private String username;
	private String phone;
	private String password;
	private String nickname;
}
