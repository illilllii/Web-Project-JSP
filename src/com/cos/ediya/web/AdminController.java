package com.cos.ediya.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.ediya.domain.admin.user.dto.UpdateRespDto;
import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.common.CommonRespDto;
import com.cos.ediya.domain.common.SearchRespDto;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.user.User;
import com.cos.ediya.service.AdminService;
import com.google.gson.Gson;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
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
		AdminService adminService = new AdminService();

		if (cmd.equals("userList")) {
			List<User> users = adminService.회원목록보기();
			request.setAttribute("users", users);
			RequestDispatcher dis = request.getRequestDispatcher("admin/userList.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("userDelete")) {
			// 1. 요청 받은 json 데이터를 자바 오브젝트로 파싱
			int id = Integer.parseInt(request.getParameter("id"));
			// 2. DB에서 받은 id값으로 글 삭제
			int result = adminService.회원삭제(id);

			// 3.응답할 json 데이터를 생성
			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			Gson gson = new Gson();

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();

			// HttpSession session = request.getSession();
			// session.invalidate();
		} else if (cmd.equals("userUpdate")) {
			
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();
			Gson gson = new Gson();
			UpdateRespDto updateRespDto = gson.fromJson(requestData, UpdateRespDto.class);
			
			int id = updateRespDto.getId();
			String userRole = updateRespDto.getUserRole();
			// 1. 요청 받은 json 데이터를 자바 오브젝트로 파싱
			// 2. DB에서 받은 id값으로 글 삭제
			int result = adminService.회원수정(id, userRole);
			
			// 3.응답할 json 데이터를 생성
			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("menuList")) {
			List<Drinks> drinks = adminService.음료목록보기();
			List<Bakery> bakerys = adminService.베이커리목록보기();
			request.setAttribute("drinks", drinks);
			request.setAttribute("bakerys", bakerys);
			
			RequestDispatcher dis = request.getRequestDispatcher("admin/menuList.jsp");
			dis.forward(request, response);
		}
	}

}
