package com.cos.ediya.domain.drinks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Drinks drink =  Drinks.builder().id(rs.getInt("id")).name(rs.getString("name"))
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
