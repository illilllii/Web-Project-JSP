package com.cos.ediya.web;

import java.io.BufferedReader;
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
import com.cos.ediya.domain.common.CommonRespDto;
import com.cos.ediya.domain.common.SearchRespDto;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.drinks.dto.DrinksRecommendRespDto;
import com.cos.ediya.domain.md.Md;
import com.cos.ediya.domain.snack.Snack;
import com.cos.ediya.domain.snack.dto.SnackRecommendRespDto;
import com.cos.ediya.service.MenuService;
import com.cos.ediya.util.Script;
import com.google.gson.Gson;

@WebServlet("/menu")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		MenuService menuService = new MenuService();
		if (cmd.equals("drinks")) {
			List<Drinks> drinks = menuService.음료목록보기();
			List<DrinksRecommendRespDto> dto = menuService.추천음료보기();
			request.setAttribute("dto", dto);
			request.setAttribute("drinks", drinks);
			RequestDispatcher dis = request.getRequestDispatcher("menu/drinks.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("bakery")) {
			List<Bakery> bakeries = menuService.베이커리목록보기();
			List<BakeryRecommendRespDto> dto = menuService.추천베이커리보기();
			request.setAttribute("dto", dto);
			request.setAttribute("bakeries", bakeries);
			RequestDispatcher dis = request.getRequestDispatcher("menu/bakery.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("snack")) {
			List<Snack> snacks = menuService.스낵목록보기();
			List<SnackRecommendRespDto> dto = menuService.추천스낵보기();
			request.setAttribute("dto", dto);
			request.setAttribute("snacks", snacks);
			RequestDispatcher dis = request.getRequestDispatcher("menu/snack.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("md")) {
			List<Md> mds = menuService.md목록보기();
			request.setAttribute("mds", mds);
			RequestDispatcher dis = request.getRequestDispatcher("menu/md.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("drinkSearch")) {
	
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();
			Gson gson = new Gson();
			SearchRespDto searchRespDto = gson.fromJson(requestData, SearchRespDto.class);
			
			String[] kinds = searchRespDto.getKind();
			String keyword = searchRespDto.getKeyword();
			
			List<Drinks> drinks = menuService.음료메뉴검색(keyword, kinds);
			CommonRespDto<List<Drinks>> commonRespDto = new CommonRespDto<>();
			
			if(drinks != null) {
				commonRespDto.setStatusCode(1);
				commonRespDto.setData(drinks);
			} else {
				commonRespDto.setStatusCode(-1);
			}
			String responseData = gson.toJson(commonRespDto);
			response.setContentType("application/json;charset=utf-8");
			Script.responseData(response, responseData);
			System.out.println("commonRespDto : "+ commonRespDto);
		} else if (cmd.equals("bakerySearch")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();
			Gson gson = new Gson();
			SearchRespDto searchRespDto = gson.fromJson(requestData, SearchRespDto.class);
			
			String[] kinds = searchRespDto.getKind();
			String keyword = searchRespDto.getKeyword();
			
			List<Bakery> bakeries = menuService.베이커리메뉴검색(keyword, kinds);
			CommonRespDto<List<Bakery>> commonRespDto = new CommonRespDto<>();
			
			if(bakeries != null) {
				commonRespDto.setStatusCode(1);
				commonRespDto.setData(bakeries);
			} else {
				commonRespDto.setStatusCode(-1);
			}
			String responseData = gson.toJson(commonRespDto);
			response.setContentType("application/json;charset=utf-8");
			Script.responseData(response, responseData);
			System.out.println("commonRespDto : "+ commonRespDto);
		} else if (cmd.equals("snackSearch")) {
			
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();
			Gson gson = new Gson();
			SearchRespDto searchRespDto = gson.fromJson(requestData, SearchRespDto.class);
			
			String[] kinds = searchRespDto.getKind();
			String keyword = searchRespDto.getKeyword();
			
			List<Snack> snacks = menuService.스낵메뉴검색(keyword, kinds);
			CommonRespDto<List<Snack>> commonRespDto = new CommonRespDto<>();
			
			if(snacks != null) {
				commonRespDto.setStatusCode(1);
				commonRespDto.setData(snacks);
			} else {
				commonRespDto.setStatusCode(-1);
			}
			String responseData = gson.toJson(commonRespDto);
			response.setContentType("application/json;charset=utf-8");
			Script.responseData(response, responseData);
			System.out.println("commonRespDto : "+ commonRespDto);
		} 
	}

}
