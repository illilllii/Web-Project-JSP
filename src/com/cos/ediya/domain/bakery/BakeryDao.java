package com.cos.ediya.domain.bakery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;

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
}
