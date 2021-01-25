package com.cos.ediya.domain.md;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;

public class MdDao {
	public List<Md> findAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, content, imageSrc, recommend FROM md ORDER BY id";
		List<Md> mds = new ArrayList<Md>();
		try {
			pstmt = conn.prepareStatement(sql);
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
}
