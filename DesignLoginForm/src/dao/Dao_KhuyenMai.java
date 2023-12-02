package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhuyenMai;
import interfaces.I_KhuyenMai;

public class Dao_KhuyenMai implements I_KhuyenMai{
	
	public Dao_KhuyenMai() {
		
	}

	@Override
	public ArrayList<KhuyenMai> getAllKhuyenMai() {
		ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhuyenMai";
			Statement sta = con.createStatement();
			ResultSet rs =sta.executeQuery(sql);
			
			while (rs.next()) {
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String tenKhuyenMai = rs.getString("TENKHUYENMAI");
				int giaTriGiamGia = rs.getInt("GIATRIGIAMGIA");
				Date ngayBatDau = rs.getDate("NGAYBATDAU");
				Date ngayKetThuc = rs.getDate("NGAYKETTHUC");
				String doiTuongApDung = rs.getString("DOITUONGAPDUNG");
				String tinhTrang = rs.getString("TINHTRANG");
				
				KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, giaTriGiamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
				dsKM.add(km);
				
			}
			}catch (Exception e) {
				e.printStackTrace();
		}
		return dsKM;
	}

	@Override
	public KhuyenMai getKhuyenMaiTheoMa(String maKM) {
		KhuyenMai km = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHUYENMAI where MAKHUYENMAI = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maKM);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String tenKhuyenMai = rs.getString("TENKHUYENMAI");
				int giaTriGiamGia = rs.getInt("GIATRIGIAMGIA");
				Date ngayBatDau = rs.getDate("NGAYBATDAU");
				Date ngayKetThuc = rs.getDate("NGAYKETTHUC");
				String doiTuongApDung = rs.getString("DOITUONGAPDUNG");
				String tinhTrang = rs.getString("TINHTRANG");
				km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, giaTriGiamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
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
		return km;
	}

	@Override
	public ArrayList<KhuyenMai> getKhuyenMaiTheoTen(String tenKM) {
		ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHUYENMAI where TENKHUYENMAI LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + tenKM + "%");

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String tenKhuyenMai = rs.getString("TENKHUYENMAI");
				int giaTriGiamGia = rs.getInt("GIATRIGIAMGIA");
				Date ngayBatDau = rs.getDate("NGAYBATDAU");
				Date ngayKetThuc = rs.getDate("NGAYKETTHUC");
				String doiTuongApDung = rs.getString("DOITUONGAPDUNG");
				String tinhTrang = rs.getString("TINHTRANG");

				KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, giaTriGiamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
				dsKM.add(km);
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
		return dsKM;
	}

	@Override
	public boolean them(KhuyenMai km) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into KHUYENMAI values(?,?,?,?,?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1, km.getMaKhuyenMai());
			sta.setString(2, km.getTenKhuyenMai());
			sta.setInt(3, km.getGiaTriGiamGia());
			sta.setDate(4, km.getNgayBatDau());
			sta.setDate(5, km.getNgayKetThuc());
			sta.setString(6, km.getDoiTuongApDung());
			sta.setString(7, km.getTinhTrang());
			n = sta.executeUpdate();
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

	@Override
	public boolean capNhat(KhuyenMai km) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update KHUYENMAI set TENKHUYENMAI = ?, GIATRIGIAMGIA = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?, DOITUONGAPDUNG = ?, TINHTRANG = ? where MAKHUYENMAI = ?";
			sta = con.prepareStatement(sql);
			
			sta.setString(1, km.getTenKhuyenMai());
			sta.setInt(2, km.getGiaTriGiamGia());
			sta.setDate(3, km.getNgayBatDau());
			sta.setDate(4, km.getNgayKetThuc());
			sta.setString(5, km.getDoiTuongApDung());
			sta.setString(6, km.getTinhTrang());
			sta.setString(7, km.getMaKhuyenMai());
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
	
	public ArrayList<KhuyenMai> getKhuyenMaiTheoMaMang(String maKM) {
		ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHUYENMAI where MAKHUYENMAI = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maKM);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String tenKhuyenMai = rs.getString("TENKHUYENMAI");
				int giaTriGiamGia = rs.getInt("GIATRIGIAMGIA");
				Date ngayBatDau = rs.getDate("NGAYBATDAU");
				Date ngayKetThuc = rs.getDate("NGAYKETTHUC");
				String doiTuongApDung = rs.getString("DOITUONGAPDUNG");
				String tinhTrang = rs.getString("TINHTRANG");

				KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, giaTriGiamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
				dsKM.add(km);
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
		return dsKM;
	}
	
	public ArrayList<KhuyenMai> getKhuyenMaiTheoDoiTuongApDung(String doiTuong) {
		ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHUYENMAI where DOITUONGAPDUNG = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, doiTuong);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String tenKhuyenMai = rs.getString("TENKHUYENMAI");
				int giaTriGiamGia = rs.getInt("GIATRIGIAMGIA");
				Date ngayBatDau = rs.getDate("NGAYBATDAU");
				Date ngayKetThuc = rs.getDate("NGAYKETTHUC");
				String doiTuongApDung = rs.getString("DOITUONGAPDUNG");
				String tinhTrang = rs.getString("TINHTRANG");

				KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, giaTriGiamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
				dsKM.add(km);
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
		return dsKM;
	}
	
	public ArrayList<KhuyenMai> getKhuyenMaiTheoTinhTrang(String TinhTrang, String doiTuong) {
		ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KHUYENMAI where TINHTRANG = ? and DOITUONGAPDUNG = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, TinhTrang);
			sta.setString(2, doiTuong);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String tenKhuyenMai = rs.getString("TENKHUYENMAI");
				int giaTriGiamGia = rs.getInt("GIATRIGIAMGIA");
				Date ngayBatDau = rs.getDate("NGAYBATDAU");
				Date ngayKetThuc = rs.getDate("NGAYKETTHUC");
				String doiTuongApDung = rs.getString("DOITUONGAPDUNG");
				String tinhTrang = rs.getString("TINHTRANG");

				KhuyenMai km = new KhuyenMai(maKhuyenMai, tenKhuyenMai, giaTriGiamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
				dsKM.add(km);
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
		return dsKM;
	}

}
