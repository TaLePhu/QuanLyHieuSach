package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DanhMuc;
import interfaces.I_DanhMuc;

public class Dao_DanhMuc implements I_DanhMuc{
	
	public Dao_DanhMuc() {
		
	}

	@Override
	public ArrayList<DanhMuc> getAllDanhMuc() {
		ArrayList<DanhMuc> dsDM = new ArrayList<DanhMuc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "Select * from DANHMUC";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);

			while (rs.next()) {
				String maDanhMuc = rs.getString("MADANHMUC");
				String tenDanhMuc = rs.getString("TENDANHMUC");
				DanhMuc dm = new DanhMuc(maDanhMuc, tenDanhMuc);
				dsDM.add(dm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDM;
	}

	@Override
	public ArrayList<DanhMuc> getDanhMucTheoTen(String tenDanhMuc) {
		ArrayList<DanhMuc> dsDM = new ArrayList<DanhMuc>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DANHMUC where TENDANHMUC LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + tenDanhMuc + "%");

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maDM = rs.getString("MADANHMUC");
				String tenDM = rs.getString("TENDANHMUC");
				
				DanhMuc dm = new DanhMuc(maDM, tenDM);
				dsDM.add(dm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dsDM;
	}

	@Override
	public DanhMuc getDanhMucTheoMa(String maDanhMuc) {
		DanhMuc dm = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DANHMUC where MADANHMUC = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maDanhMuc);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maDM = rs.getString("MADANHMUC");
				String tenDM = rs.getString("TENDANHMUC");
				
				dm = new DanhMuc(maDM, tenDM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dm;
	}

	@Override
	public boolean them(DanhMuc dm) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into DANHMUC values(?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, dm.getMaDanhMuc());
			sta.setString(2, dm.getTenDanhMuc());
			n = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	@Override
	public boolean capNhat(DanhMuc dm) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "update DANHMUC set TENDANHMUC = ? where MADANHMUC = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, dm.getTenDanhMuc());
			sta.setString(2, dm.getMaDanhMuc());
			n = sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	@Override
	public boolean xoa(String maDanhMuc) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "delete from DANHMUC where MADANHMUC = ?";
			sta = con.prepareStatement(sql);

			sta.setString(1, maDanhMuc);
			n = sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	
}
