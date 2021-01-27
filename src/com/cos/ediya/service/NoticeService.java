package com.cos.ediya.service;

import java.util.List;

import com.cos.ediya.domain.notice.Notice;
import com.cos.ediya.domain.notice.NoticeDao;
import com.cos.ediya.domain.notice.dto.SaveReqDto;

public class NoticeService {
	
	private NoticeDao noticeDao;

	public NoticeService() {
		noticeDao = new NoticeDao();
	}

	public int 공지사항등록(SaveReqDto dto) {
		return noticeDao.save(dto);
	}
	
	public List<Notice> 공지사항목록보기(int page){
		return noticeDao.findAll(page);
	}


}
