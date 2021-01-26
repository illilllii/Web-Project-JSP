package com.cos.ediya.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		UserService userService = new UserService();
		
		if(cmd.equals("joinForm")) { // 회원가입 페이지로 이동
			response.sendRedirect("user/joinForm.jsp");
		}else if(cmd.equals("join")) { // 회원가입
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
			System.out.println("회원가입 : "+dto);
			int result = userService.회원가입(dto);
			if(result == 1) {
				response.sendRedirect("index.jsp");
			}else {
				Script.back(response, "회원가입 실패");
			}
		}else if(cmd.equals("userIdCheck")) { // 아이디(이메일) 중복확인
			BufferedReader br = request.getReader();
			String email = br.readLine();
			System.out.println(email);
			int result = userService.아이디중복체크(email);
			PrintWriter out = response.getWriter();
			if(result == 1) {
				out.print("ok");
			}else {
				out.print("fail");
			}
			out.flush();
		}else if(cmd.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
