package com.cos.ediya.service;

import com.cos.ediya.domain.user.dto.JoinReqDto;
import com.cos.ediya.domain.user.UserDao;

public class UserService {

	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}
	
	public int 회원가입(JoinReqDto dto) {
		int result = userDao.save(dto);
		return result;
	}
	
	public int 아이디중복체크(String email) {
		int result = userDao.findByEmail(email);
		return result;
	}
}
