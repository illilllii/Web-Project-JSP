package com.cos.ediya.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.md.Md;
import com.cos.ediya.domain.snack.Snack;
import com.cos.ediya.service.MenuService;

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
		MenuService menuService = new MenuService();
		if(cmd.equals("drinks")) {
			List<Drinks> drinks = menuService.음료목록보기();
			request.setAttribute("drinks", drinks);
			RequestDispatcher dis = request.getRequestDispatcher("menu/drinks.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("bakery")) {
			List<Bakery> bakerys = menuService.베이커리목록보기();
			request.setAttribute("bakerys", bakerys);
			RequestDispatcher dis = request.getRequestDispatcher("menu/bakery.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("snack")) {
			List<Snack> snacks = menuService.스낵목록보기();
			request.setAttribute("snacks", snacks);
			RequestDispatcher dis = request.getRequestDispatcher("menu/snack.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("md")) {
			List<Md> mds = menuService.md목록보기();
			request.setAttribute("mds", mds);
			RequestDispatcher dis = request.getRequestDispatcher("menu/md.jsp");
			dis.forward(request, response);
		}
		
	}

}
