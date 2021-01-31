package com.cos.ediya.service;

import java.util.List;

import com.cos.ediya.domain.notice.Notice;
import com.cos.ediya.domain.notice.NoticeDao;
import com.cos.ediya.domain.notice.dto.DetailRespDto;
import com.cos.ediya.domain.notice.dto.ImportantNoticeRespDto;
import com.cos.ediya.domain.notice.dto.NextRespDto;
import com.cos.ediya.domain.notice.dto.PreviousRespDto;
import com.cos.ediya.domain.notice.dto.SaveReqDto;
import com.cos.ediya.domain.notice.dto.UpdateReqDto;

public class NoticeService {

	private NoticeDao noticeDao;

	public NoticeService() {
		noticeDao = new NoticeDao();
	}

	public int 공지사항등록(SaveReqDto dto) {
		return noticeDao.save(dto);
	}

	public List<Notice> 공지사항목록보기(int page) {
		return noticeDao.findAll(page);
	}

	public int 글개수() {
		return noticeDao.count();
	}

	public DetailRespDto 공지사항상세보기(int id) {
		return noticeDao.findById(id);
	}

	public List<ImportantNoticeRespDto> 주요공지사항() {
		return noticeDao.findByImportant();
	}

	public PreviousRespDto 이전글보기(int id) {
		return noticeDao.findPrevious(id);
	}

	public NextRespDto 다음글보기(int id) {
		return noticeDao.findNext(id);
	}
	
	public int 공지사항삭제(int id) {
		return noticeDao.deleteById(id);
	}
	
	public int 공지사항수정(UpdateReqDto dto) {
		return noticeDao.update(dto);
	}

}
