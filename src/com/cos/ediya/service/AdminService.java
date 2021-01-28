package com.cos.ediya.service;

import java.util.List;

import com.cos.ediya.domain.admin.menu.bakery.AdminMenuBakeryDao;
import com.cos.ediya.domain.admin.menu.bakery.dto.BakeryDetailRespDto;
import com.cos.ediya.domain.admin.menu.drinks.AdminMenuDrinksDao;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksDetailRespDto;
import com.cos.ediya.domain.admin.menu.md.AdminMenuMdDao;
import com.cos.ediya.domain.admin.menu.snack.AdminMenuSnackDao;
import com.cos.ediya.domain.admin.user.AdminUserDao;
import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.md.Md;
import com.cos.ediya.domain.snack.Snack;
import com.cos.ediya.domain.user.User;

public class AdminService {
	private AdminUserDao adminUserDao;
	private AdminMenuDrinksDao adminMenuDrinksDao;
	private AdminMenuBakeryDao adminMenuBakeryDao;
	private AdminMenuSnackDao adminMenuSnackDao;
	private AdminMenuMdDao adMenuMdDao;
	public AdminService() {
		adminUserDao = new AdminUserDao();
		adminMenuDrinksDao = new AdminMenuDrinksDao();
		adminMenuBakeryDao = new AdminMenuBakeryDao();
		adminMenuSnackDao = new AdminMenuSnackDao();
		adMenuMdDao = new AdminMenuMdDao();
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
		return adminMenuDrinksDao.findAll();
	}
	public int 음료삭제(int id) {
		return adminMenuDrinksDao.deleteById(id);
	}
	public int 음료메뉴수정(int id, String name, String subname, String content,
			String imageSrc, String kind, String recommend) {
		
		return adminMenuDrinksDao.updateById(id, name, subname, content, imageSrc, kind, recommend);
	}
	public DrinksDetailRespDto 음료상세보기(int id) {
		return adminMenuDrinksDao.findById(id);
	}
	public List<Bakery> 베이커리목록보기() {
		return adminMenuBakeryDao.findAll();
	}
	public int 베이커리삭제(int id) {
		return adminMenuBakeryDao.deleteById(id);
	}
	public int 베이커리메뉴수정(int id, String name, String subname, String content,
			String imageSrc, String kind, String recommend) {
		
		return adminMenuBakeryDao.updateById(id, name, subname, content, imageSrc, kind, recommend);
	}
	public BakeryDetailRespDto 베이커리상세보기(int id) {
		return adminMenuBakeryDao.findById(id);
	}
	public List<Snack> 스낵목록보기() {
		return adminMenuSnackDao.findAll();
	}
	public int 스낵삭제(int id) {
		return adminMenuSnackDao.deleteById(id);
	}
	public List<Md> MD목록보기() {
		return adMenuMdDao.findAll();
	}
	public int MD삭제(int id) {
		return adMenuMdDao.deleteById(id);
	}
}
