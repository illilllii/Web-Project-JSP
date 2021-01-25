package com.cos.ediya.domain.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.snack.dto.SnackRecommendRespDto;

public class SnackDao {
	public List<Snack> findAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM snack ORDER BY id";
		List<Snack> snacks = new ArrayList<Snack>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Snack snack = Snack.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.subname(rs.getString("subname"))
						.content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc"))
						.kind(rs.getString("kind"))
						.recommend(rs.getString("recommend"))
						.build();
				snacks.add(snack);
				
			}
			return snacks;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<SnackRecommendRespDto> findByRecommend() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc FROM snack WHERE recommend = 'Y'";
		List<SnackRecommendRespDto> recommends = new ArrayList<SnackRecommendRespDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SnackRecommendRespDto snackRecommendRespDto = new SnackRecommendRespDto();
				snackRecommendRespDto.setId(rs.getInt("id"));
				snackRecommendRespDto.setName(rs.getString("name"));
				snackRecommendRespDto.setSubname(rs.getString("subname"));
				snackRecommendRespDto.setContent(rs.getString("content"));
				snackRecommendRespDto.setImageSrc(rs.getString("imageSrc"));

				recommends.add(snackRecommendRespDto);

			}
			return recommends;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	public List<Snack> findByKeyword(String keyword) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM snack WHERE name like ? OR subname like ?";
		List<Snack> snacks = new ArrayList<Snack>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Snack snack =  Snack.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
				snacks.add(snack);
			}
			return snacks;
		
		} catch (Exception e) {

		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
}
