package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


import connectDB.ConnectDB;
import entity.HoaDonBan;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;

public class Dao_HoaDonBan {
	public Dao_HoaDonBan() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<HoaDonBan> getAllHoaDonBan() {
		ArrayList<HoaDonBan> dsHD = new ArrayList<HoaDonBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from HoaDonBan";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("MAHOADONBAN");
				Timestamp ngay = rs.getTimestamp("NGAYGIAODICH");
				String maKH = rs.getString("MAKHACHHANG");
				String maNV = rs.getString("MANHANVIEN");
				float tongThanhTien = rs.getFloat("TONGTHANHTIEN");
				String trangThai = rs.getString("TRANGTHAI");
				String maKM = rs.getString("MAKHUYENMAI");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				KhuyenMai km = new KhuyenMai(maKM);
				HoaDonBan hd = new HoaDonBan(maHD, nv, kh, km, ngay, trangThai, tongThanhTien);
				dsHD.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	
	public boolean createHoaDon(HoaDonBan hd) throws SQLException {
		PreparedStatement stmt = null;
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into HOADONBAN values(?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			//stmt = con.prepareStatement("insert into HOADONBAN values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHDBan());
			stmt.setString(2, hd.getMaNV().getMaNhanVien());
			stmt.setString(3, hd.getMaKH().getMaKhachhang());
			stmt.setString(4, hd.getMaKM().getMaKhuyenMai());
			LocalDateTime currentDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(currentDateTime);
			stmt.setTimestamp(5, timestamp);
			stmt.setString(6, hd.getTrangThai());
			stmt.setFloat(7, hd.getTongThanhTien());
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
	
	public boolean xoaHoaDonBanTheoMa(HoaDonBan hd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "delete from HOADONBAN where MAHOADONBAN = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hd.getMaHDBan());
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
	
	public int getSoLuong() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			//LocalDateTime currentDate = LocalDateTime.now();
			Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
            String currentDateStr = dateFormat.format(currentDate);
            String sql = "SELECT COUNT(*) AS COUNT_HOADON FROM HOADONBAN WHERE SUBSTRING(MAHOADONBAN, 3, 6) = ?";
            
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                // Đặt tham số cho truy vấn
                statement.setString(1,currentDateStr);
                // Thực hiện truy vấn
                try (ResultSet resultSet = statement.executeQuery()) {
                	if(resultSet.next()) {
                		String countHoaDon = resultSet.getString("COUNT_HOADON");
                        return Integer.parseInt(countHoaDon);
                	}
                    
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// tìm hóa đơn theo mã nhân viên
	public ArrayList<HoaDonBan> getKHTheoSDT(String ma) {
		ArrayList<HoaDonBan> dsHD = new ArrayList<HoaDonBan>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HOA where MANHANVIEN = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1,ma);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString("MAHOADONBAN");
				Timestamp ngay = rs.getTimestamp("NGAYGIAODICH");
				String maKH = rs.getString("MAKHACHHANG");
				String maNV = rs.getString("MANHANVIEN");
				float tongThanhTien = rs.getFloat("TONGTHANHTIEN");
				String trangThai = rs.getString("TRANGTHAI");
				String maKM = rs.getString("MAKHUYENMAI");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				KhuyenMai km = new KhuyenMai(maKM);
				HoaDonBan hd = new HoaDonBan(maHD, nv, kh, km, ngay, trangThai, tongThanhTien); 
				dsHD.add(hd);
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
		return dsHD;
	}
	
	// tìm hóa đơn theo mã
	public ArrayList<HoaDonBan> getHDTheoMa(String ma) {
		ArrayList<HoaDonBan> dsHD = new ArrayList<HoaDonBan>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HOADONBAN where MAHOADONBAN = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1,ma);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString("MAHOADONBAN");
				Timestamp ngay = rs.getTimestamp("NGAYGIAODICH");
				String maKH = rs.getString("MAKHACHHANG");
				String maNV = rs.getString("MANHANVIEN");
				float tongThanhTien = rs.getFloat("TONGTHANHTIEN");
				String trangThai = rs.getString("TRANGTHAI");
				String maKM = rs.getString("MAKHUYENMAI");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				KhuyenMai km = new KhuyenMai(maKM);
				HoaDonBan hd = new HoaDonBan(maHD, nv, kh, km, ngay, trangThai, tongThanhTien); 
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public boolean capNhat(String ma,String trangT) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update HOADONBAN set TRANGTHAI = ? where MAHOADONBAN = ?";
			sta = con.prepareStatement(sql);
			
			sta.setString(1, trangT);
			sta.setString(2, ma);
			n=sta.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
}
