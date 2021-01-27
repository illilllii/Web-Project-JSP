package com.cos.ediya.service;

import java.util.List;

import com.cos.ediya.domain.admin.menu.AdminMenuDao;
import com.cos.ediya.domain.admin.user.AdminUserDao;
import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.user.User;

public class AdminService {
	private AdminUserDao adminUserDao;
	private AdminMenuDao adminMenuDao;
	public AdminService() {
		adminUserDao = new AdminUserDao();
		adminMenuDao = new AdminMenuDao();
	}
	
	public List<User> 회원목록보기(){
		return adminUserDao.findAll();
	}
	
	public int 회원삭제(int id) {
		return adminUserDao.deleteById(id);
	}
	
	public int 회원수정(int id, String userRole) {
		return adminUserDao.updateById(id, userRole);
	}
	
	public List<Drinks> 음료목록보기() {
		return adminMenuDao.drinksFindAll();
	}
	
	public List<Bakery> 베이커리목록보기() {
		return adminMenuDao.bakeryFindAll();
	}
}
