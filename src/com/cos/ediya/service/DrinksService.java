package com.cos.ediya.service;

import java.util.List;

import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.drinks.DrinksDao;

public class DrinksService {

	private DrinksDao drinksDao;
	public DrinksService() {
		drinksDao = new DrinksDao();
	}
	public List<Drinks> 메뉴목록보기(){
		return drinksDao.findAll();
	}
}
