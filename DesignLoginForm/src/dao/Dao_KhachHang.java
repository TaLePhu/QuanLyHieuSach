package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import connectDB.ConnectDB;

import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;

public class Dao_KhachHang {
	// get all data on table
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from KhachHang";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("MAKHACHHANG");
				String ten = rs.getString("HOTENKHACHHANG");

				Date ngaySinh = rs.getDate("NGAYSINH");
				String diaChi = rs.getString("DIACHI");
				String soDT = rs.getString("SODIENTHOAI");
				Boolean gioiTinh = rs.getBoolean("GIOITINH");
				String email = rs.getString("EMAIL");
				KhachHang khachHang = new KhachHang(ma, ten, diaChi, ngaySinh, soDT, email, gioiTinh);
				dsKhachHang.add(khachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	// thêm khách hàng
	public boolean createKhachHang(KhachHang kh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KHACHHANG values(?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKhachhang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setDate(3, (java.sql.Date) kh.getNgaySinh());
			stmt.setString(4, kh.getDiaChi());
			stmt.setString(5, kh.getSoDT());
			stmt.setString(6, kh.getEmail());
			stmt.setBoolean(7, kh.isGioiTinh());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	//lấy số lượng khách hàng
	public int getSoLuong() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT TOP 1 MAKHACHHANG FROM KHACHHANG ORDER BY MAKHACHHANG desc";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String temp = rs.getString("MAKHACHHANG");
				temp = temp.replace("KH", "").trim();
				return Integer.parseInt(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// update
	public void update(KhachHang k) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"update KHACHHANG SET HOTENKHACHHANG = ?, NGAYSINH=?, DIACHI=?, SODIENTHOAI=?, EMAIL=?, GIOITINH=?"
							+ "WHERE MAKHACHHANG = ?");
			stmt.setString(1, k.getTenKhachHang());
			stmt.setString(3, k.getDiaChi());
			java.sql.Date sqlNgaySinh = new java.sql.Date(k.getNgaySinh().getTime());
			stmt.setDate(2, sqlNgaySinh);
			stmt.setString(4, k.getSoDT());
			stmt.setString(5, k.getEmail());
			stmt.setBoolean(6, k.isGioiTinh());
			stmt.setString(7, k.getMaKhachhang());

			int n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// them
	// thêm khách hàng
	public ArrayList<KhachHang> getKHTheoSDT(String sdtT) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHACHHANG where SODIENTHOAI = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1,sdtT);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String ma = rs.getString("MAKHACHHANG");
				String ten = rs.getString("HOTENKHACHHANG");

				Date ngaySinh = rs.getDate("NGAYSINH");
				String diaChi = rs.getString("DIACHI");
				String soDT = rs.getString("SODIENTHOAI");
				Boolean gioiTinh = rs.getBoolean("GIOITINH");
				String email = rs.getString("EMAIL");
				KhachHang khachHang = new KhachHang(ma, ten, diaChi, ngaySinh, soDT, email, gioiTinh);
				dsKH.add(khachHang);
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
	
	
	public KhachHang getTheoMaKH(String maKH) {
		KhachHang kh = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHACHHANG where MAKHACHHANG = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maKH);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MAKHACHHANG");
				String ten = rs.getString("HOTENKHACHHANG");

				Date ngaySinh = rs.getDate("NGAYSINH");
				String diaChi = rs.getString("DIACHI");
				String soDT = rs.getString("SODIENTHOAI");
				Boolean gioiTinh = rs.getBoolean("GIOITINH");
				String email = rs.getString("EMAIL");
				kh = new KhachHang(ma, ten, diaChi, ngaySinh, soDT, email, gioiTinh);
				
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
	
	public KhachHang getTheoSDT(String sdt) {
		KhachHang kh = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHACHHANG where SODIENTHOAI = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, sdt);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MAKHACHHANG");
				String ten = rs.getString("HOTENKHACHHANG");

				Date ngaySinh = rs.getDate("NGAYSINH");
				String diaChi = rs.getString("DIACHI");
				String soDT = rs.getString("SODIENTHOAI");
				Boolean gioiTinh = rs.getBoolean("GIOITINH");
				String email = rs.getString("EMAIL");
				kh = new KhachHang(ma, ten, diaChi, ngaySinh, soDT, email, gioiTinh);
				
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
	
	public ArrayList<KhachHang> getKHTheoHoTen(String hoTen) {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHACHHANG where HOTENKHACHHANG LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + hoTen + "%");

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String ma = rs.getString("MAKHACHHANG");
				String ten = rs.getString("HOTENKHACHHANG");

				Date ngaySinh = rs.getDate("NGAYSINH");
				String diaChi = rs.getString("DIACHI");
				String soDT = rs.getString("SODIENTHOAI");
				Boolean gioiTinh = rs.getBoolean("GIOITINH");
				String email = rs.getString("EMAIL");
				KhachHang khachHang = new KhachHang(ma, ten, diaChi, ngaySinh, soDT, email, gioiTinh);
				dsKH.add(khachHang);
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
}
