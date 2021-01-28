package com.cos.ediya.web;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.ediya.util.Script;
import com.cos.ediya.domain.user.User;
import com.cos.ediya.domain.user.dto.FindPwdReqDto;
import com.cos.ediya.config.CommonRespDto;
import com.cos.ediya.domain.drinks.dto.DrinksRecommendRespDto;
import com.cos.ediya.domain.notice.Notice;
import com.cos.ediya.domain.notice.dto.DetailRespDto;
import com.cos.ediya.domain.notice.dto.ImportantNoticeRespDto;
import com.cos.ediya.domain.notice.dto.SaveReqDto;
import com.cos.ediya.service.NoticeService;

//http://localhost:8080/ediya/notice
@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeController() {
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
		NoticeService noticeService = new NoticeService();

		if (cmd.equals("noticeList")) { // 공지사항
			int page = Integer.parseInt(request.getParameter("page"));
			List<Notice> notices = noticeService.공지사항목록보기(page);
			List<ImportantNoticeRespDto> importants = noticeService.주요공지사항();
			request.setAttribute("notices", notices);
			request.setAttribute("importants", importants);
			int noticeCount = noticeService.글개수();
			int lastPage = (noticeCount - 1) / 4; // 2/4 = 0, 3/4 = 0, 4/4 = 1, 9/4 = 2 ( 0page, 1page, 2page)
			double currentPosition = (double) page / (lastPage) * 100;

			request.setAttribute("lastPage", lastPage);
			request.setAttribute("currentPosition", currentPosition);
			RequestDispatcher dis = request.getRequestDispatcher("board/noticeList.jsp");
			dis.forward(request, response);

		} else if (cmd.equals("noticeForm")) { // 공지사항 글쓰기페이지로 이동(관리자만!!)
			RequestDispatcher dis = request.getRequestDispatcher("board/noticeForm.jsp"); // 나중에 수정하기
			dis.forward(request, response);
		} else if (cmd.equals("saveNotice")) { // 공지사항 등록
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			SaveReqDto dto = new SaveReqDto();
			dto.setTitle(title);
			dto.setContent(content);

			int result = noticeService.공지사항등록(dto);
			if (result == 1) { // 등록성공	
			RequestDispatcher dis = request.getRequestDispatcher("board/noticeList.jsp"); // 나중에 수정하기
			} else {
				Script.back(response, "글쓰기실패");
			}
		} else if (cmd.equals("detail")) { // 공지사항 상세보기
			int id = Integer.parseInt(request.getParameter("id"));
			DetailRespDto dto = noticeService.공지사항상세보기(id); 
			if (dto == null) {
				Script.back(response, "상세보기에 실패하였습니다");
			} else {
				request.setAttribute("dto", dto);
				RequestDispatcher dis = request.getRequestDispatcher("board/noticeDetail.jsp");
				dis.forward(request, response);
			}

		}

	}

}
