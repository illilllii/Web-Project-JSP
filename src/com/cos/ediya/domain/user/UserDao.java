package com.cos.ediya.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.ediya.domain.user.dto.LoginReqDto;
import com.cos.ediya.domain.user.dto.UpdateReqDto;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;
import com.cos.ediya.config.DB;
import com.cos.ediya.domain.user.dto.FindEmailReqDto;
import com.cos.ediya.domain.user.dto.FindPwdReqDto;
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
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
		String sql = "SELECT id, email, username, phone, password, nickname, userRole FROM user WHERE email = ? AND password = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				User user = User.builder()
						.id(rs.getInt("id"))
						.email(rs.getString("email"))
						.username(rs.getString("username"))
						.phone(rs.getString("phone"))
						.password(rs.getString("password"))
						.nickname(rs.getString("nickname"))
						.userRole(rs.getString("userRole"))
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

	public int update(UpdateReqDto dto) { // 회원정보수정
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

	// 회원정보 수정 후, 다시 회원정보 불러오기
	public User findByEmailAfterUpdate(String email) {
		String sql = "SELECT id, email, username, phone, password, nickname FROM user WHERE email =?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// 물음표 완성하기
			pstmt.setString(1, email);
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
	
	public int deleteByEmail(String email) { // 회원탈퇴
		String sql = "DELETE FROM user WHERE email = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public User findEmail(FindEmailReqDto dto) { // 이메일 찾기
		String sql = "SELECT id, email, username, phone, password, nickname FROM user WHERE phone = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
	
	public User findPwd(FindPwdReqDto dto) { // 비밀번호 찾기
		String sql = "SELECT id, email, username, phone, password, nickname FROM user WHERE email = ? AND phone = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPhone());
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

}
