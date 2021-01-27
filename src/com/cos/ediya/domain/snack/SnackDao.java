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
	public List<Snack> findByKind(String[] kinds) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, name, subname, content, imageSrc, kind, recommend FROM snack WHERE ");

		for (int i = 0; i < kinds.length; i++) {
			if (i == kinds.length - 1) {
				sb.append("kind = ?");
			} else {
				sb.append("kind = ? OR ");
			}

		}
		String sql = sb.toString();
		List<Snack> snacks = new ArrayList<Snack>();
		try {
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < kinds.length; i++) {
				pstmt.setString(i + 1, kinds[i]);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Snack snack = Snack.builder().id(rs.getInt("id")).name(rs.getString("name"))
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
	
	public List<Snack> findByKeywordKind(String keyword, String[] kinds) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		// select * from drinks where (name like "%딸기%" OR subname like "%딸기%") AND kind
		// = 'BEVERAGE';
		sb.append("SELECT id, name, subname, content, imageSrc, kind, recommend FROM snack WHERE ");

		for (int i = 0; i < kinds.length; i++) {
			if (i == kinds.length - 1) {
				sb.append("((name like ? OR subname like ?) AND kind = ?)");
			} else {
				sb.append("((name like ? OR subname like ?) AND kind = ?) OR ");
			}

		}
		String sql = sb.toString();
		List<Snack> snacks = new ArrayList<Snack>();
		try {
			pstmt = conn.prepareStatement(sql);

			int paramIndex = 0;
			for (int i = 0; i < kinds.length; i++) {
				pstmt.setString(++paramIndex, "%" + keyword + "%");
				pstmt.setString(++paramIndex, "%" + keyword + "%");
				pstmt.setString(++paramIndex, kinds[i]);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Snack snack = Snack.builder().id(rs.getInt("id")).name(rs.getString("name"))
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
