package com.cos.ediya.domain.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.notice.dto.DetailRespDto;
import com.cos.ediya.domain.notice.dto.ImportantNoticeRespDto;
import com.cos.ediya.domain.notice.dto.NextRespDto;
import com.cos.ediya.domain.notice.dto.PreviousRespDto;
import com.cos.ediya.domain.notice.dto.SaveReqDto;
import com.cos.ediya.domain.notice.dto.UpdateReqDto;

public class NoticeDao {

	public int save(SaveReqDto dto) { // 공지사항 등록
		String sql = "INSERT INTO notice(title, content, createDate, importantNotice) VALUES(?,?, now(), 'N')";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt);
		}
		return -1;
	}

	public List<Notice> findAll(int page) { // 공지사항 목록보기
		String sql = "SELECT * FROM  notice ORDER BY id DESC LIMIT ?, 4";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice> notices = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page * 4);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Notice notice = Notice.builder().id(rs.getInt("id")).title(rs.getString("title"))
						.content(rs.getString("content")).createDate(rs.getTimestamp("createDate"))
						.importantNotice(rs.getString("importantNotice")).build();
				notices.add(notice);
			}
			return notices;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public int count() { // 공지사항 글개수
		String sql = "SELECT count(*), id FROM notice";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return -1;
	}

	public DetailRespDto findById(int id) {
		String sql = "SELECT id, title, content, createDate, importantNotice FROM notice WHERE id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			// Persistence API
			if (rs.next()) { // 커서를 이동하는 함수
				DetailRespDto dto = new DetailRespDto();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setCreateDate(rs.getTimestamp("createDate"));
				dto.setImportantNotice(rs.getString("importantNotice"));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<ImportantNoticeRespDto> findByImportant() { // 주요공지사항
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, title, content, createDate FROM notice WHERE  importantNotice= 'Y'";
		List<ImportantNoticeRespDto> importants = new ArrayList<ImportantNoticeRespDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ImportantNoticeRespDto importantNoticeRespDto = new ImportantNoticeRespDto();
				importantNoticeRespDto.setId(rs.getInt("id"));
				importantNoticeRespDto.setTitle(rs.getString("title"));
				importantNoticeRespDto.setContent(rs.getString("content"));
				importantNoticeRespDto.setCreateDate(rs.getTimestamp("createDate"));
				importants.add(importantNoticeRespDto);

			}
			return importants;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public PreviousRespDto findPrevious(int id) { // 이전글
		String sql = "SELECT *  FROM notice WHERE id < ?  ORDER BY id DESC LIMIT 1";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			// Persistence API
			if (rs.next()) { // 커서를 이동하는 함수
				PreviousRespDto previous = new PreviousRespDto();
				previous.setId(rs.getInt("id"));
				previous.setTitle(rs.getString("title"));
				previous.setContent(rs.getString("content"));
				previous.setCreateDate(rs.getTimestamp("createDate"));
				return previous;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public NextRespDto findNext(int id) { // 다음글
		String sql = "SELECT *  FROM notice WHERE id > ?  ORDER BY id  LIMIT 1";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			// Persistence API
			if (rs.next()) { // 커서를 이동하는 함수
				NextRespDto next = new NextRespDto();
				next.setId(rs.getInt("id"));
				next.setTitle(rs.getString("title"));
				next.setContent(rs.getString("content"));
				next.setCreateDate(rs.getTimestamp("createDate"));
				return next;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public int deleteById(int id) {
		String sql = "DELETE FROM notice WHERE id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public int update(UpdateReqDto dto) {
		String sql = "UPDATE notice SET title = ?, content = ? WHERE id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	

}
