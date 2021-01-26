package com.cos.ediya.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.ediya.domain.user.User;
import com.cos.ediya.domain.user.dto.LoginReqDto;
import com.cos.ediya.domain.user.dto.UpdateReqDto;
import com.cos.ediya.domain.user.dto.FindEmailReqDto;
import com.cos.ediya.domain.user.dto.FindPwdReqDto;
import com.cos.ediya.domain.user.dto.JoinReqDto;
import com.cos.ediya.util.Script;
import com.cos.ediya.service.UserService;

//http://localhost:8080/ediya/user
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		UserService userService = new UserService();

		if (cmd.equals("joinForm")) { // 회원가입 페이지로 이동
			RequestDispatcher dis = request.getRequestDispatcher("user/joinForm.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("join")) { // 회원가입
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			JoinReqDto dto = new JoinReqDto();
			dto.setEmail(email);
			dto.setUsername(username);
			dto.setPhone(phone);
			dto.setPassword(password);
			dto.setNickname(nickname);
			System.out.println("회원가입 : " + dto);
			int result = userService.회원가입(dto);
			if (result == 1) {
				response.sendRedirect("index.jsp");
			} else {
				Script.back(response, "회원가입 실패");
			}
		} else if (cmd.equals("userIdCheck")) { // 아이디(이메일) 중복확인
			BufferedReader br = request.getReader();
			String email = br.readLine();
			System.out.println(email);
			int result = userService.아이디중복체크(email);
			PrintWriter out = response.getWriter();
			if (result == 1) {
				out.print("ok");
			} else {
				out.print("fail");
			}
			out.flush();
		} else if (cmd.equals("logout")) { // 로그아웃
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else if (cmd.equals("loginForm")) { // 로그인 페이지로 이동
			RequestDispatcher dis = request.getRequestDispatcher("user/loginForm.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("login")) { // 로그인
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			LoginReqDto dto = new LoginReqDto();
			dto.setEmail(email);
			dto.setPassword(password);
			User userEntity = userService.로그인(dto);
			if (userEntity != null) {
				HttpSession session = request.getSession();
				session.setAttribute("principal", userEntity); 
				response.sendRedirect("index.jsp");
			} else {
				Script.back(response, "회원정보를 찾을 수 없습니다.");
			}
		} else if (cmd.equals("myPage")) { // 마이페이지 이동
			RequestDispatcher dis = request.getRequestDispatcher("user/myPage.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("updateForm")) { // 회원정보수정 페이지 이동
			RequestDispatcher dis = request.getRequestDispatcher("user/editPage.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("update")) { // 회원정보수정
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
	
			UpdateReqDto dto = new UpdateReqDto();
			dto.setEmail(email);
			dto.setPhone(phone);
			dto.setPassword(password);
			dto.setNickname(nickname);
			int result = userService.회원수정(dto);

			// update 성공 -> 세션등록
			if(result == 1) {
				User userEntity= userService.회원정보불러오기(email);
				HttpSession session = request.getSession();
				session.setAttribute("principal", userEntity); 
				Script.back(response, "수정 되었습니다");
			}else {
				Script.back(response, "회원수정 실패");
			}
		} else if (cmd.equals("delete")) { // 회원탈퇴
			String email = request.getParameter("email");
			int result =  userService.회원탈퇴(email);
			if (result == 1) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("index.jsp");
			} else {
				Script.back(response, "회원탈퇴 실패");
			}
		} else if (cmd.equals("findEmail")) { // 이메일찾기
			String phone = request.getParameter("phone");
			FindEmailReqDto dto = new FindEmailReqDto();
			dto.setPhone(phone);
			User userEntity = userService.이메일찾기(dto);
			if (userEntity != null) {
				Script.back(response, userEntity.getEmail());
			} else {
				Script.back(response, "회원정보를 찾을 수 없습니다.");
			}
		} else if (cmd.equals("findPwd")) { // 비밀번호 찾기
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			FindPwdReqDto dto = new FindPwdReqDto();
			dto.setEmail(email);
			dto.setPhone(phone);
			User userEntity = userService.비밀번호찾기(dto);
			if (userEntity != null) {
				Script.back(response, userEntity.getPassword()); // utf-8필터 만들기!!!
			} else {
				Script.back(response, "회원정보를 찾을 수 없습니다.");
			}
		}
	}
}
