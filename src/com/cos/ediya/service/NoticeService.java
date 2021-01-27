package com.cos.ediya.service;

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

}
