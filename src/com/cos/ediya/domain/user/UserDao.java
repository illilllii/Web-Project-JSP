package com.cos.ediya.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.ediya.domain.user.dto.LoginReqDto;
import com.cos.ediya.domain.user.dto.UpdateReqDto;
import com.cos.ediya.config.DB;
import com.cos.ediya.domain.user.dto.JoinReqDto;

public class UserDao {

	public int save(JoinReqDto dto) { // 회원가입
		String sql = "INSERT INTO user(email, username, phone, password, nickname, userRole, createDate) VALUES(?,?,?,?,?, 'USER', now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getPassword());
			pstmt.setString(5, dto.getNickname());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	
	public int findByEmail(String email) { // 아이디(이메일) 중복확인
		String sql = "SELECT * FROM user WHERE email = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs =  pstmt.executeQuery();	
			if(rs.next()) {
				return 1; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			DB.close(conn, pstmt, rs);
		}
		return -1; 
	}
	
	public User findByEmailAndPassword(LoginReqDto dto) { // 로그인
		String sql = "SELECT id, email, username, phone, password, nickname FROM user WHERE email = ? AND password = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			rs =  pstmt.executeQuery();
			
			if(rs.next()) {
				User user = User.builder()
						.id(rs.getInt("id"))
						.email(rs.getString("email"))
						.username(rs.getString("username"))
						.phone(rs.getString("phone"))
						.password(rs.getString("password"))
						.nickname(rs.getString("nickname"))
						.build();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	
	public int update(UpdateReqDto dto) {
		String sql = "UPDATE user SET phone = ?, password = ?, nickname = ?  WHERE email = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getEmail());
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
