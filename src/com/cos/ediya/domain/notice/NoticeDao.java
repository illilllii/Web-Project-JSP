package com.cos.ediya.domain.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.notice.dto.SaveReqDto;

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
	
	public List<Notice> findAll(int page){ // 공지사항 목록보기
		String sql = "SELECT * FROM  notice ORDER BY id DESC LIMIT ?, 4";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		List<Notice> notices = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page*4);
			rs =  pstmt.executeQuery();
			
			while(rs.next()) { 
				Notice notice = Notice.builder() 
						.id(rs.getInt("id"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createDate(rs.getTimestamp("createDate"))
						.importantNotice(rs.getString("importantNotice"))
						.build();
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


}
