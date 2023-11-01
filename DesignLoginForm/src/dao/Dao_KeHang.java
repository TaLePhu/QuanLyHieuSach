package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KeHang;
import interfaces.I_KeHang;

public class Dao_KeHang implements I_KeHang{
	
	public Dao_KeHang() {
		
	}

	@Override
	public ArrayList<KeHang> getAllKeHang() {
		ArrayList<KeHang> dsKH = new ArrayList<KeHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KEHANG";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MAKEHANG");
				String tenKH = rs.getString("TENKEHANG");
				String viTri = rs.getString("VITRI");
				int sucChua = rs.getInt("SUCCHUA");
				String tinhTrang = rs.getString("TINHTRANG");
				KeHang kh = new KeHang(maKH, tenKH, viTri, sucChua, tinhTrang);
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}

	@Override
	public ArrayList<KeHang> getKeHangTheoTen(String tenKeHang) {
		ArrayList<KeHang> dsKH = new ArrayList<KeHang>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KEHANG where TENKEHANG LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + tenKeHang + "%");

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("MAKEHANG");
				String tenKH = rs.getString("TENKEHANG");
				String viTri = rs.getString("VITRI");
				int sucChua = rs.getInt("SUCCHUA");
				String tinhTrang = rs.getString("TINHTRANG");
				KeHang kh = new KeHang(maKH, tenKH, viTri,sucChua, tinhTrang);
				dsKH.add(kh);
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
		return dsKH;
	}

	@Override
	public boolean them(KeHang kh) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into KEHANG values(?,?,?,?,?)";
			sta = con.prepareStatement(sql);

			sta.setString(1, kh.getMaKeHang());
			sta.setString(2, kh.getTenKeHang());
			sta.setString(3, kh.getViTri());
			sta.setInt(4, kh.getSucChua());
			sta.setString(5, kh.getTinhTrang());
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
	public boolean capNhat(KeHang kh) {
		PreparedStatement sta = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "update KEHANG set TENKEHANG = ?, VITRI = ?, SUCCHUA = ?, TINHTRANG = ? where MAKEHANG = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, kh.getTenKeHang());
			sta.setString(2, kh.getViTri());
			sta.setInt(3, kh.getSucChua());
			sta.setString(4, kh.getTinhTrang());
			sta.setString(5, kh.getMaKeHang());
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
	public KeHang getKeHangTheoMa(String maKeHang) {
		KeHang kh = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KEHANG where MAKEHANG = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maKeHang);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("MAKEHANG");
				String tenKH = rs.getString("TENKEHANG");
				String viTri = rs.getString("VITRI");
				int sucChua = rs.getInt("SUCCHUA");
				String tinhTrang = rs.getString("TINHTRANG");
				kh = new KeHang(maKH, tenKH, viTri, sucChua, tinhTrang);
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
		return kh;
	}

}
