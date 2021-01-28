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

import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksDetailRespDto;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksUpdateReqDto;
import com.cos.ediya.domain.admin.user.dto.UpdateRespDto;
import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.common.CommonRespDto;
import com.cos.ediya.domain.common.SearchRespDto;
import com.cos.ediya.domain.drinks.Drinks;
import com.cos.ediya.domain.md.Md;
import com.cos.ediya.domain.snack.Snack;
import com.cos.ediya.domain.user.User;
import com.cos.ediya.service.AdminService;
import com.cos.ediya.util.Script;
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
			int id = Integer.parseInt(request.getParameter("id"));
			int result = adminService.회원삭제(id);

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

			int result = adminService.회원수정(id, userRole);

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
			List<Snack> snacks = adminService.스낵목록보기();
			List<Md> mds = adminService.MD목록보기();
			request.setAttribute("drinks", drinks);
			request.setAttribute("bakerys", bakerys);
			request.setAttribute("snacks", snacks);
			request.setAttribute("mds", mds);

			RequestDispatcher dis = request.getRequestDispatcher("admin/menuList.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("drinksDelete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = adminService.음료삭제(id);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			Gson gson = new Gson();

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("bakeryDelete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = adminService.베이커리삭제(id);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			Gson gson = new Gson();

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("snackDelete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = adminService.스낵삭제(id);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			Gson gson = new Gson();

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("mdDelete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = adminService.MD삭제(id);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			Gson gson = new Gson();

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("drinksDetail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			DrinksDetailRespDto dto = adminService.음료상세보기(id);
			if (dto != null) {
				request.setAttribute("dto", dto);
				RequestDispatcher dis = request.getRequestDispatcher("admin/menuDrinksDetail.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response, "상세보기에 실패하였습니다");
			}
		} else if (cmd.equals("drinksUpdate")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			DrinksUpdateReqDto dto = gson.fromJson(requestData, DrinksUpdateReqDto.class);

			int id = dto.getId();
			String name = dto.getName();
			String subname = dto.getSubname();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String kind = dto.getKind();
			String recommend = dto.getRecommend();
			
			int result = adminService.음료메뉴수정(id, name, subname, content, imageSrc, kind, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("bakeryUpdate")) {
			
		} else if (cmd.equals("snackUpdate")) {
			
		} else if (cmd.equals("mdUpdate")) {
			
		}
	}

}
