package com.cos.ediya.domain.admin.menu.md;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.ediya.config.DB;
import com.cos.ediya.domain.md.Md;

public class AdminMenuMdDao {
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

	public List<Md> findAll() {
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Md> mds = new ArrayList<>();
		String sql = "SELECT id, name, content, imageSrc, recommend FROM md";
	
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
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
}
