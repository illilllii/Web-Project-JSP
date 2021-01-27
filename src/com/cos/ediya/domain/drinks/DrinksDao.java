package com.cos.ediya.domain.drinks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.drinks.dto.DrinksRecommendRespDto;

public class DrinksDao {
	public List<Drinks> findAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM drinks ORDER BY id";
		List<Drinks> drinks = new ArrayList<Drinks>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Drinks drink = Drinks.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
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

	public List<DrinksRecommendRespDto> findByRecommend() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc FROM drinks WHERE recommend = 'Y'";
		List<DrinksRecommendRespDto> recommends = new ArrayList<DrinksRecommendRespDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DrinksRecommendRespDto drinksRecommendRespDto = new DrinksRecommendRespDto();
				drinksRecommendRespDto.setId(rs.getInt("id"));
				drinksRecommendRespDto.setName(rs.getString("name"));
				drinksRecommendRespDto.setSubname(rs.getString("subname"));
				drinksRecommendRespDto.setContent(rs.getString("content"));
				drinksRecommendRespDto.setImageSrc(rs.getString("imageSrc"));

				recommends.add(drinksRecommendRespDto);

			}
			return recommends;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<Drinks> findByKeyword(String keyword) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM drinks WHERE name like ? OR subname like ?";

		List<Drinks> drinks = new ArrayList<Drinks>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Drinks drink = Drinks.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
				drinks.add(drink);
			}
			return drinks;

		} catch (Exception e) {

		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<Drinks> findByKind(String[] kinds) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, name, subname, content, imageSrc, kind, recommend FROM drinks WHERE ");

		for (int i = 0; i < kinds.length; i++) {
			if (i == kinds.length - 1) {
				sb.append("kind = ?");
			} else {
				sb.append("kind = ? OR ");
			}

		}
		String sql = sb.toString();
		List<Drinks> drinks = new ArrayList<Drinks>();
		try {
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < kinds.length; i++) {
				pstmt.setString(i + 1, kinds[i]);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Drinks drink = Drinks.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
				drinks.add(drink);
			}
			return drinks;

		} catch (Exception e) {

		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<Drinks> findByKeywordKind(String keyword, String[] kinds) {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		// select * from drinks where (name like "%딸기%" OR subname like "%딸기%") AND kind
		// = 'BEVERAGE';
		sb.append("SELECT id, name, subname, content, imageSrc, kind, recommend FROM drinks WHERE ");

		for (int i = 0; i < kinds.length; i++) {
			if (i == kinds.length - 1) {
				sb.append("((name like ? OR subname like ?) AND kind = ?)");
			} else {
				sb.append("((name like ? OR subname like ?) AND kind = ?) OR ");
			}

		}
		String sql = sb.toString();
		List<Drinks> drinks = new ArrayList<Drinks>();
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
				Drinks drink = Drinks.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.subname(rs.getString("subname")).content(rs.getString("content"))
						.imageSrc(rs.getString("imageSrc")).kind(rs.getString("kind"))
						.recommend(rs.getString("recommend")).build();
				drinks.add(drink);
			}
			return drinks;

		} catch (Exception e) {

		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}

}
