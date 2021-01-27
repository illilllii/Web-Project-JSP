package com.cos.ediya.domain.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
