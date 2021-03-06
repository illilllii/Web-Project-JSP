package com.cos.ediya.service;

import com.cos.ediya.domain.user.dto.FindEmailReqDto;
import com.cos.ediya.domain.user.dto.FindPwdReqDto;
import com.cos.ediya.domain.user.dto.JoinReqDto;
import com.cos.ediya.domain.user.User;
import com.cos.ediya.domain.user.dto.LoginReqDto;
import com.cos.ediya.domain.user.dto.UpdateReqDto;
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
	
	public User 로그인(LoginReqDto dto) {
		return userDao.findByEmailAndPassword(dto);
	}
	
	public int 회원수정(UpdateReqDto dto) {
		int result = userDao.update(dto);
		return result;
	}
	
	public User 회원정보불러오기(String email) {
		return userDao.findByEmailAfterUpdate(email);
	}
	
	public int 회원탈퇴(String email) {
		return userDao.deleteByEmail(email);
	}
	
	public User 이메일찾기(FindEmailReqDto dto) {
		return userDao.findEmail(dto);
	}
	
	public User 비밀번호찾기(FindPwdReqDto dto) {
		return userDao.findPwd(dto);
	}
}
