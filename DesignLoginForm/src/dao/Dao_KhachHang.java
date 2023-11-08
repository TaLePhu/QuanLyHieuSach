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

public class Dao_KhachHang {
	// get all data on table
		public ArrayList<KhachHang> getAllKhachHang() {
			ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();

				String sql = "select * from KhachHang";
				Statement sta = con.createStatement();
				ResultSet rs =sta.executeQuery(sql);
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
		
		//thêm khách hàng
		public boolean createKhachHang(KhachHang kh) throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("insert into" + "KHACHHANG values(?,?,?,?,?,?)");
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
			return n >0;
		}
		
//		lấy số lượng khách hàng
		public int getSoLuong() {
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				
				String sql = "SELECT TOP 1 MAKHACHHANG FROM KHACHHANG ORDER BY MAKHACHHANG desc";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					String temp = rs.getString("MAKHACHHANG");
					temp = temp.replace("KH", "");
					return Integer.parseInt(temp);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
}
