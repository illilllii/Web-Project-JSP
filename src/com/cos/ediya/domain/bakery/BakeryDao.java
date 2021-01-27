package com.cos.ediya.domain.bakery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.bakery.dto.BakeryRecommendRespDto;
import com.cos.ediya.domain.drinks.Drinks;

public class BakeryDao {
	public List<Bakery> findAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM bakery ORDER BY id";
		List<Bakery> bakerys = new ArrayList<Bakery>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Bakery bakery = Bakery.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.subname(rs.getString("subname"))
						.content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc"))
						.kind(rs.getString("kind"))
						.recommend(rs.getString("recommend"))
						.build();
				bakerys.add(bakery);
				
			}
			return bakerys;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	public List<BakeryRecommendRespDto> findByRecommend() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc FROM bakery WHERE recommend = 'Y'";
		List<BakeryRecommendRespDto> recommends = new ArrayList<BakeryRecommendRespDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BakeryRecommendRespDto bakeryRecommendRespDto = new BakeryRecommendRespDto();
				bakeryRecommendRespDto.setId(rs.getInt("id"));
				bakeryRecommendRespDto.setName(rs.getString("name"));
				bakeryRecommendRespDto.setSubname(rs.getString("subname"));
				bakeryRecommendRespDto.setContent(rs.getString("content"));
				bakeryRecommendRespDto.setImageSrc(rs.getString("imageSrc"));

				recommends.add(bakeryRecommendRespDto);

			}
			return recommends;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	public List<Bakery> findByKeyword(String keyword) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM bakery WHERE name like ? OR subname like ?";
		List<Bakery> bakeries = new ArrayList<Bakery>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Bakery bakery =  Bakery.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
				bakeries.add(bakery);
			}
			return bakeries;
		
		} catch (Exception e) {

		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	public List<Bakery> findByKind(String[] kinds) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, name, subname, content, imageSrc, kind, recommend FROM bakery WHERE ");

		for (int i = 0; i < kinds.length; i++) {
			if (i == kinds.length - 1) {
				sb.append("kind = ?");
			} else {
				sb.append("kind = ? OR ");
			}

		}
		String sql = sb.toString();
		List<Bakery> bakeries = new ArrayList<Bakery>();
		try {
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < kinds.length; i++) {
				pstmt.setString(i + 1, kinds[i]);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bakery bakery = Bakery.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
				bakeries.add(bakery);
			}
			return bakeries;

		} catch (Exception e) {

		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Bakery> findByKeywordKind(String keyword, String[] kinds) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		// select * from drinks where (name like "%딸기%" OR subname like "%딸기%") AND kind
		// = 'BEVERAGE';
		sb.append("SELECT id, name, subname, content, imageSrc, kind, recommend FROM bakery WHERE ");

		for (int i = 0; i < kinds.length; i++) {
			if (i == kinds.length - 1) {
				sb.append("((name like ? OR subname like ?) AND kind = ?)");
			} else {
				sb.append("((name like ? OR subname like ?) AND kind = ?) OR ");
			}

		}
		String sql = sb.toString();
		List<Bakery> bakeries = new ArrayList<Bakery>();
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
				Bakery bakery = Bakery.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
				bakeries.add(bakery);
			}
			return bakeries;

		} catch (Exception e) {

		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
}
