package com.cos.ediya.service;

import java.util.List;

import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.bakery.BakeryDao;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.drinks.DrinksDao;
import com.cos.ediya.domain.md.Md;
import com.cos.ediya.domain.md.MdDao;
import com.cos.ediya.domain.snack.Snack;
import com.cos.ediya.domain.snack.SnackDao;

public class MenuService {

	private DrinksDao drinksDao;
	private BakeryDao bakeryDao;
	private SnackDao snackDao;
	private MdDao mdDao;
	
	public MenuService() {
		drinksDao = new DrinksDao();
		bakeryDao = new BakeryDao();
		snackDao = new SnackDao();
		mdDao = new MdDao();
	}
	public List<Drinks> 음료목록보기(){
		return drinksDao.findAll();
	}
	public List<Bakery> 베이커리목록보기(){
		return bakeryDao.findAll();
	}
	public List<Snack> 스낵목록보기(){
		return snackDao.findAll();
	}
	public List<Md> md목록보기(){
		return mdDao.findAll();
	}
}
