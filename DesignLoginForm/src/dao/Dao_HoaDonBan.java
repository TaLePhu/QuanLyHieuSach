package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import entity.HoaDonBan;
import entity.KhachHang;
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
				Date ngay = rs.getDate("NGAYGIAODICH");
				String maKH = rs.getString("MAKHACHHANG");
				String maNV = rs.getString("MANHANVIEN");
				float tongThanhTien = rs.getFloat("TONGTHANHTIEN");
				String trangThai = rs.getString("TRANGTHAI");
				float tienKhachDua = rs.getFloat("TIENKHACHDUA");
				float vat = rs.getFloat("THUEVAT");
				float tienThua = rs.getFloat("TIENTHUA");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDonBan hd = new HoaDonBan(maHD, nv, kh, ngay, trangThai, vat, tienKhachDua, tongThanhTien, tienThua); 
				dsHD.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	
	public boolean createHoaDon(HoaDonBan hd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HOADONBAN values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHDBan());
			stmt.setString(2, hd.getMaNV().getMaNhanVien());
			stmt.setString(3, hd.getMaKH().getMaKhachhang());
			
			stmt.setDate(4, (java.sql.Date) hd.getNgayGD());
			stmt.setString(5, hd.getTrangThai());
			stmt.setFloat(6, hd.getThueVAT());
			stmt.setFloat(7, hd.getTienKhachDua());
			stmt.setFloat(8, hd.getTongThanhTien());
			stmt.setFloat(9, hd.getTienThua());
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
			
			Date currentDate = new Date(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
            String currentDateStr = dateFormat.format(currentDate);
            String sql = "SELECT COUNT(*) AS COUNT_HOADON FROM HOADONBAN WHERE SUBSTRING(MAHOADONBAN, 3, 6) = ?";
            
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                // Đặt tham số cho truy vấn
                statement.setString(1, "HD" + currentDateStr);

                // Thực hiện truy vấn
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int countHoaDon = resultSet.getInt("COUNT_HOADON");
                        return countHoaDon;
                    }
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
