package com.cos.ediya.domain.user;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private int id;
	private String email;
	private String username;
	private String phone;
	private String password;
	private String nickname;
	private String userRole; // admin, user
	private Timestamp createDate;
}
