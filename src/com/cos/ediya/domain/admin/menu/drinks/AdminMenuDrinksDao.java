package com.cos.ediya.domain.admin.menu.drinks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksDetailRespDto;
import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.drinks.Drinks;

public class AdminMenuDrinksDao {
	public int count() {
		String sql = "SELECT count(*) FROM drinks";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1); // index count(*)->1, count(*), id이면 id->2
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return -1;
		
	}
	public List<Drinks> findAll(int page) {		
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Drinks> drinks = new ArrayList<>();
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM drinks ORDER BY id ASC LIMIT ?, 8";
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page*8);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Drinks drink = Drinks.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.subname(rs.getString("subname"))
						.content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc"))
						.kind(rs.getString("kind"))
						.recommend(rs.getString("recommend"))
						.build();
				drinks.add(drink);
			}
			return drinks;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
		
	}
	public int insertAll(String name, String subname, String content, String imageSrc, String kind, String recommend) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO drinks(name, subname, content, imageSrc, kind, recommend) VALUES (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, subname);
			pstmt.setString(3, content);
			pstmt.setString(4, imageSrc);
			pstmt.setString(5, kind);
			pstmt.setString(6, recommend);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt);
		}
		return -1;
	}
	public int updateById(int id, String name, String subname, String content,
			String imageSrc, String kind, String recommend) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE drinks SET name=?, subname=?, content=?, imageSrc=?, kind=?, recommend=? WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, subname);
			pstmt.setString(3, content);
			pstmt.setString(4, imageSrc);
			pstmt.setString(5, kind);
			pstmt.setString(6, recommend);
			pstmt.setInt(7, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt);
		}
		
		return -1;
	}
	public DrinksDetailRespDto findById(int id) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM drinks WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				DrinksDetailRespDto dto = new DrinksDetailRespDto();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setSubname(rs.getString("subname"));
				dto.setContent(rs.getString("content"));
				dto.setImageSrc(rs.getString("imageSrc"));
				dto.setKind(rs.getString("kind"));
				dto.setRecommend(rs.getString("recommend"));
				
				return dto;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	public int deleteById(int id) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM drinks WHERE id = ?";
		
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
	
	
}
