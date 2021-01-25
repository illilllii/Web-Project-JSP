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
import com.cos.ediya.domain.bakery.dto.BakeryRecommendRespDto;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.drinks.dto.DrinksRecommendRespDto;
import com.cos.ediya.domain.md.Md;
import com.cos.ediya.domain.snack.Snack;
import com.cos.ediya.domain.snack.dto.SnackRecommendRespDto;
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
			List<DrinksRecommendRespDto> dto = menuService.추천음료보기();		
			request.setAttribute("dto", dto);
			request.setAttribute("drinks", drinks);
			RequestDispatcher dis = request.getRequestDispatcher("menu/drinks.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("bakery")) {
			List<Bakery> bakeries = menuService.베이커리목록보기();
			List<BakeryRecommendRespDto> dto = menuService.추천베이커리보기();
			request.setAttribute("dto", dto);
			request.setAttribute("bakeries", bakeries);
			RequestDispatcher dis = request.getRequestDispatcher("menu/bakery.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("snack")) {
			List<Snack> snacks = menuService.스낵목록보기();
			List<SnackRecommendRespDto> dto = menuService.추천스낵보기();
			request.setAttribute("dto", dto);
			request.setAttribute("snacks", snacks);
			RequestDispatcher dis = request.getRequestDispatcher("menu/snack.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("md")) {
			List<Md> mds = menuService.md목록보기();
			request.setAttribute("mds", mds);
			RequestDispatcher dis = request.getRequestDispatcher("menu/md.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("drinkSearch")) {
			String keyword = request.getParameter("keyword");		
			List<Drinks> drinks = menuService.음료메뉴검색(keyword);
			request.setAttribute("drinks", drinks);
			List<DrinksRecommendRespDto> dto = menuService.추천음료보기();
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("menu/drinks.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("bakerySearch")) {
			String keyword = request.getParameter("keyword");
			List<Bakery> bakeries = menuService.베이커리메뉴검색(keyword);
			request.setAttribute("bakeries", bakeries);
			List<BakeryRecommendRespDto> dto = menuService.추천베이커리보기();
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("menu/bakery.jsp");
			dis.forward(request, response);
		}else if(cmd.equals("snackSearch")) {
			String keyword = request.getParameter("keyword");
			List<Snack> snacks = menuService.스낵메뉴검색(keyword);
			request.setAttribute("snacks", snacks);
			List<SnackRecommendRespDto> dto = menuService.추천스낵보기();
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("menu/snack.jsp");
			dis.forward(request, response);
		}
		
	}

}
