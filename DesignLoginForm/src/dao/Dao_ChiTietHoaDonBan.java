package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.ChiTietHoaDonBan;
import entity.HoaDonBan;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;
import entity.SanPham;

public class Dao_ChiTietHoaDonBan {
	public Dao_ChiTietHoaDonBan() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ChiTietHoaDonBan> getAllCTHoaDonBan() {
		ArrayList<ChiTietHoaDonBan> dsHD = new ArrayList<ChiTietHoaDonBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from CHITIETHOADONBAN";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("MAHOADONBAN");
				String maSP = rs.getString("MASANPHAM");
				int soLuong = rs.getInt("SOLUONG");
				float ThanhTien = rs.getFloat("THANHTIEN");
				HoaDonBan hd = new HoaDonBan(maHD);
				SanPham sp = new SanPham(maSP);
				ChiTietHoaDonBan ct = new ChiTietHoaDonBan(hd, sp, soLuong, ThanhTien);
				dsHD.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	// thêm chi tiết hóa đơn
	public boolean createCTHoaDon(ChiTietHoaDonBan cthd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into CHITIETHOADONBAN values(?,?,?,?)");
			stmt.setString(1, cthd.getHoaDonBan().getMaHDBan());
			stmt.setString(2, cthd.getSanPham().getMaSP());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setFloat(4,cthd.getThanhTien());
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
	
	public boolean xoaHoaDonBanTheoMa(String ma) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "delete from CHITIETHOADONBAN where MAHOADONBAN = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
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
	
	// tìm chi tiết theo ma
	public ArrayList<ChiTietHoaDonBan> getCTHoaDonBanTheoMa(String ma) {
		ArrayList<ChiTietHoaDonBan> dsHD = new ArrayList<ChiTietHoaDonBan>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from CHITIETHOADONBAN where MAHOADONBAN=?";
			sta = con.prepareStatement(sql);
			sta.setString(1, ma);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("MAHOADONBAN");
				String maSP = rs.getString("MASANPHAM");
				int soLuong = rs.getInt("SOLUONG");
				float ThanhTien = rs.getFloat("THANHTIEN");
				HoaDonBan hd = new HoaDonBan(maHD);
				SanPham sp = new SanPham(maSP);
				ChiTietHoaDonBan ct = new ChiTietHoaDonBan(hd, sp, soLuong, ThanhTien);
				dsHD.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
}
