package com.cos.ediya.domain.admin.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.bakery.Bakery;
import com.cos.ediya.domain.drinks.Drinks;

public class AdminMenuDao {
	public List<Drinks> drinksFindAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Drinks> drinks = new ArrayList<>();
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM drinks";
	
		try {
			pstmt = conn.prepareStatement(sql);
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
	
	public List<Bakery> bakeryFindAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Bakery> bakerys = new ArrayList<>();
		String sql = "SELECT id, name, subname, content, imageSrc, kind, recommend FROM bakery";
	
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
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
}
