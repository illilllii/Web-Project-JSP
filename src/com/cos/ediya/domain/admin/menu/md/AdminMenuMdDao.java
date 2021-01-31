package com.cos.ediya.domain.admin.menu.md;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.admin.menu.drinks.dto.DrinksDetailRespDto;
import com.cos.ediya.domain.admin.menu.md.dto.MdDetailRespDto;
import com.cos.ediya.domain.md.Md;

public class AdminMenuMdDao {

	public int count() {
		String sql = "SELECT count(*) FROM md";
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
	public int insertAll(String name, String content, String imageSrc,  String recommend) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO md(name, content, imageSrc, recommend) VALUES (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, content);
			pstmt.setString(3, imageSrc);
			pstmt.setString(4, recommend);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt);
		}
		return -1;
	}
	public int updateById(int id, String name,String content,
			String imageSrc, String recommend) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE md SET name=?, content=?, imageSrc=?, recommend=? WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, content);
			pstmt.setString(3, imageSrc);
			pstmt.setString(4, recommend);
			pstmt.setInt(5, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt);
		}
		
		return -1;
	}
	public MdDetailRespDto findById(int id) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, content, imageSrc, recommend FROM md WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MdDetailRespDto dto = new MdDetailRespDto();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setImageSrc(rs.getString("imageSrc"));
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
		String sql = "DELETE FROM md WHERE id = ?";
		
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

	public List<Md> findAll(int page) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Md> mds = new ArrayList<>();
		String sql = "SELECT id, name, content, imageSrc, recommend FROM md ORDER BY id ASC LIMIT ?, 8";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page*8);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Md md = Md.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc"))
						.recommend(rs.getString("recommend"))
						.build();
				mds.add(md);
			}
			return mds;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
}
