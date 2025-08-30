package com.dao;
import com.connection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.*;

public class sharedFileDao {
	DBConnection db = new DBConnection();
	
	public void addSharedFile(sharedFile sf) throws SQLException
	{
		String sql = "insert into shared_files (file_id, shared_with, can_download) values (?,?,?)";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		 ps.setInt(1, sf.getFileId());
	     ps.setInt(2, sf.getSharedWith());
	     ps.setBoolean(3, sf.isCanDownload());
		 ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
	    if (rs.next()) {
	        int generatedId = rs.getInt(1);
	        sf.setShareId(generatedId);
	    }
	}

	public List<sharedFile> getAllSharedFiles() throws SQLException {
		List<sharedFile> list = new ArrayList<>();
		String sql = "select * from shared_files";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sharedFile sf = new sharedFile();
            sf.setShareId(rs.getInt("share_id"));
            sf.setFileId(rs.getInt("file_id"));
            sf.setSharedWith(rs.getInt("shared_with"));
            sf.setCanDownload(rs.getBoolean("can_download"));
            sf.setSharedAt(rs.getTimestamp("shared_at"));
            list.add(sf);
		}
		return list;
	}

	public sharedFile getSharedFileById(int id) throws SQLException {
		sharedFile sf = null;

		String sql = "select * from shared_files where share_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			 sf = new sharedFile();
	         sf.setShareId(rs.getInt("share_id"));
	         sf.setFileId(rs.getInt("file_id"));
	         sf.setSharedWith(rs.getInt("shared_with"));
	         sf.setCanDownload(rs.getBoolean("can_download"));
	         sf.setSharedAt(rs.getTimestamp("shared_at"));
		}
		return sf;
	}

	public void updateSharedFile(sharedFile sf) throws SQLException {
		String sql = "update shared_files set file_id = ?, shared_with = ?, can_download = ? where share_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, sf.getFileId());
        ps.setInt(2, sf.getSharedWith());
        ps.setBoolean(3, sf.isCanDownload());
        ps.setInt(4, sf.getShareId());
		ps.executeUpdate();
	}

	public void deleteSharedFile(int id) throws SQLException {
		String sql = "delete from shared_files where share_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
