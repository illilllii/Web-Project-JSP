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

import com.cos.ediya.domain.admin.menu.bakery.dto.BakeryDetailRespDto;
import com.cos.ediya.domain.admin.menu.bakery.dto.BakeryInsertReqDto;
import com.cos.ediya.domain.admin.menu.bakery.dto.BakeryPageRespDto;
import com.cos.ediya.domain.admin.menu.bakery.dto.BakeryUpdateReqDto;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksDetailRespDto;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksInsertReqDto;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksPageRespDto;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksUpdateReqDto;
import com.cos.ediya.domain.admin.menu.md.dto.MdDetailRespDto;
import com.cos.ediya.domain.admin.menu.md.dto.MdInsertReqDto;
import com.cos.ediya.domain.admin.menu.md.dto.MdPageRespDto;
import com.cos.ediya.domain.admin.menu.md.dto.MdUpdateReqDto;
import com.cos.ediya.domain.admin.menu.snack.dto.SnackDetailRespDto;
import com.cos.ediya.domain.admin.menu.snack.dto.SnackInsertReqDto;
import com.cos.ediya.domain.admin.menu.snack.dto.SnackPageRespDto;
import com.cos.ediya.domain.admin.menu.snack.dto.SnackUpdateReqDto;
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

			int bakeryCount = adminService.베이커리개수();
			System.out.println("bakeryCount: "+bakeryCount);
			int bakeryLastPage = (bakeryCount-1)/4;
			request.setAttribute("bakeryLastPage", bakeryLastPage);
			
			int drinksCount = adminService.음료개수();
			int drinksLastPage = (drinksCount-1)/8;
			System.out.println("drinksCount: "+drinksCount);
			request.setAttribute("drinksLastPage", drinksLastPage);
			
			int snackCount = adminService.스낵개수();
			int snackLastPage = (snackCount-1)/4;
			System.out.println("snackCount: "+snackCount);
			request.setAttribute("snackLastPage", snackLastPage);
			
			int mdCount = adminService.MD개수();
			int mdLastPage = (mdCount-1)/4;
			System.out.println("mdCount: "+mdCount);
			request.setAttribute("mdLastPage", mdLastPage);
			
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
		} else if (cmd.equals("bakeryDetail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			BakeryDetailRespDto dto = adminService.베이커리상세보기(id);
			if (dto != null) {
				request.setAttribute("dto", dto);
				RequestDispatcher dis = request.getRequestDispatcher("admin/menuBakeryDetail.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response, "상세보기에 실패하였습니다");
			}
		} else if (cmd.equals("snackDetail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			SnackDetailRespDto dto = adminService.스낵상세보기(id);
			if (dto != null) {
				request.setAttribute("dto", dto);
				RequestDispatcher dis = request.getRequestDispatcher("admin/menuSnackDetail.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response, "상세보기에 실패하였습니다");
			}
		} else if (cmd.equals("mdDetail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			MdDetailRespDto dto = adminService.MD상세보기(id);
			if (dto != null) {
				request.setAttribute("dto", dto);
				RequestDispatcher dis = request.getRequestDispatcher("admin/menuMdDetail.jsp");
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
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			BakeryUpdateReqDto dto = gson.fromJson(requestData, BakeryUpdateReqDto.class);

			int id = dto.getId();
			String name = dto.getName();
			String subname = dto.getSubname();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String kind = dto.getKind();
			String recommend = dto.getRecommend();

			int result = adminService.베이커리메뉴수정(id, name, subname, content, imageSrc, kind, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("snackUpdate")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			SnackUpdateReqDto dto = gson.fromJson(requestData, SnackUpdateReqDto.class);

			int id = dto.getId();
			String name = dto.getName();
			String subname = dto.getSubname();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String kind = dto.getKind();
			String recommend = dto.getRecommend();

			int result = adminService.스낵메뉴수정(id, name, subname, content, imageSrc, kind, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("mdUpdate")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			MdUpdateReqDto dto = gson.fromJson(requestData, MdUpdateReqDto.class);

			int id = dto.getId();
			String name = dto.getName();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String recommend = dto.getRecommend();

			int result = adminService.MD메뉴수정(id, name, content, imageSrc, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();
		} else if (cmd.equals("drinksInsert")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			DrinksInsertReqDto dto = gson.fromJson(requestData, DrinksInsertReqDto.class);

			String name = dto.getName();
			String subname = dto.getSubname();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String kind = dto.getKind();
			String recommend = dto.getRecommend();

			int result = adminService.음료메뉴추가(name, subname, content, imageSrc, kind, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();

		} else if (cmd.equals("drinksInsertForm")) {
			RequestDispatcher dis = request.getRequestDispatcher("admin/menuDrinksInsertForm.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("bakeryInsert")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			BakeryInsertReqDto dto = gson.fromJson(requestData, BakeryInsertReqDto.class);

			String name = dto.getName();
			String subname = dto.getSubname();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String kind = dto.getKind();
			String recommend = dto.getRecommend();

			int result = adminService.베이커리메뉴추가(name, subname, content, imageSrc, kind, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();

		} else if (cmd.equals("bakeryInsertForm")) {
			RequestDispatcher dis = request.getRequestDispatcher("admin/menuBakeryInsertForm.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("snackInsert")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			SnackInsertReqDto dto = gson.fromJson(requestData, SnackInsertReqDto.class);

			String name = dto.getName();
			String subname = dto.getSubname();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String kind = dto.getKind();
			String recommend = dto.getRecommend();

			int result = adminService.스낵메뉴추가(name, subname, content, imageSrc, kind, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();

		} else if (cmd.equals("snackInsertForm")) {
			RequestDispatcher dis = request.getRequestDispatcher("admin/menuSnackInsertForm.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("mdInsert")) {
			BufferedReader br = request.getReader(); // http body 데이터 순수하게 읽기
			String requestData = br.readLine();

			Gson gson = new Gson();
			MdInsertReqDto dto = gson.fromJson(requestData, MdInsertReqDto.class);

			String name = dto.getName();
			String content = dto.getContent();
			String imageSrc = dto.getImageSrc();
			String recommend = dto.getRecommend();

			int result = adminService.MD메뉴추가(name, content, imageSrc, recommend);

			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			commonRespDto.setStatusCode(result);
			commonRespDto.setData("성공");

			String respData = gson.toJson(commonRespDto);
			PrintWriter out = response.getWriter();
			out.print(respData);
			out.flush();

		} else if (cmd.equals("mdInsertForm")) {
			RequestDispatcher dis = request.getRequestDispatcher("admin/menuMdInsertForm.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("bakeryList")) {
			BufferedReader br = request.getReader();
			String requestData = br.readLine();
			Gson gson = new Gson();
			BakeryPageRespDto bakeryPageRespDto = gson.fromJson(requestData, BakeryPageRespDto.class);
			int page = bakeryPageRespDto.getPage();
			List<Bakery> bakeries = adminService.베이커리목록보기(page);
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
			

		} else if(cmd.equals("drinksList")) {
			BufferedReader br = request.getReader();
			String requestData = br.readLine();
			Gson gson = new Gson();
			DrinksPageRespDto drinksPageRespDto = gson.fromJson(requestData, DrinksPageRespDto.class);
			int page = drinksPageRespDto.getPage();
			List<Drinks> drinks = adminService.음료목록보기(page);
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
		} else if(cmd.equals("snackList")) {
			BufferedReader br = request.getReader();
			String requestData = br.readLine();
			Gson gson = new Gson();
			SnackPageRespDto snackPageRespDto = gson.fromJson(requestData, SnackPageRespDto.class);
			int page = snackPageRespDto.getPage();
			List<Snack> snacks = adminService.스낵목록보기(page);
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
		} else if(cmd.equals("mdList")) {
			BufferedReader br = request.getReader();
			String requestData = br.readLine();
			Gson gson = new Gson();
			MdPageRespDto mdPageRespDto = gson.fromJson(requestData, MdPageRespDto.class);
			int page = mdPageRespDto.getPage();
			List<Md> mds = adminService.MD목록보기(page);
			CommonRespDto<List<Md>> commonRespDto = new CommonRespDto<>();
			
			if(mds != null) {
				commonRespDto.setStatusCode(1);
				commonRespDto.setData(mds);

			} else {
				commonRespDto.setStatusCode(-1);
			}
			
			String responseData = gson.toJson(commonRespDto);
			response.setContentType("application/json;charset=utf-8");
			Script.responseData(response, responseData);
		}
	}

}
