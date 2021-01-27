package com.cos.ediya.domain.admin.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.user.User;

public class AdminUserDao {
	public List<User> findAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<>();
		String sql = "SELECT id, email, username, phone, nickname, userRole, createDate FROM user";
	
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.phone(rs.getString("phone"))
						.nickname(rs.getString("nickname"))
						.userRole(rs.getString("userRole"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				users.add(user);
			}
			return users;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int deleteById(int id) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM user WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public int updateById(int id, String userRole) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE user SET userRole = ?  WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userRole);
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt);
		}
		return -1;
	}
}
