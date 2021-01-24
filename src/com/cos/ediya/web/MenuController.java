package com.cos.ediya.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.service.DrinksService;

@WebServlet("/menu")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MenuController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		DrinksService drinksService = new DrinksService();
		if(cmd.equals("drinks")) {
			List<Drinks> drinks = drinksService.메뉴목록보기();
			request.setAttribute("drinks", drinks);
			RequestDispatcher dis = request.getRequestDispatcher("menu/drinks.jsp");
			dis.forward(request, response);
		}
	}

}
