package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.DanhMuc;
import entity.KeHang;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.Sach;
import interfaces.I_Sach;

public class Dao_Sach implements I_Sach {

	public Dao_Sach() {

	}
	//lấy toàn bộ sản phẩm sách
	@Override
	public ArrayList<Sach> getAllSanPhamSach() {
		ArrayList<Sach> dsSP = new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SanPham where SOTRANG > 0";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maSanPham = rs.getString("MASANPHAM");
				String tenSanPham = rs.getString("TENSANPHAM");
				float giaMua = rs.getFloat("GIAMUA");
				int soLuong = rs.getInt("SOLUONG");
				float giaBan = rs.getFloat("GIABAN");
				String nhaXuatBan = rs.getString("NHAXUATBAN");
				String tacGia = rs.getString("TACGIA");
				int namXB = rs.getInt("NAMXUATBAN");
				int soTrang = rs.getInt("SOTRANG");
				float thueVAT = rs.getFloat("THUEVAT");
				String maDanhMuc = rs.getString("MADANHMUC");
				String maKeHang = rs.getString("MAKEHANG");
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String maNhaCungCap = rs.getString("MANHACUNGCAP");
				DanhMuc maDM = new DanhMuc(maDanhMuc);
				KeHang maKH = new KeHang(maKeHang);
				KhuyenMai maKM = new KhuyenMai(maKhuyenMai);
				NhaCungCap maNCC = new NhaCungCap(maNhaCungCap);
				String tinhTrang = rs.getString("TINHTRANG");

				Sach sp = new Sach(maSanPham, tenSanPham, giaMua, soLuong, giaBan, nhaXuatBan, tacGia, namXB, soTrang,thueVAT, maDM, maKH, maKM, maNCC, tinhTrang); 
				dsSP.add(sp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSP;
	}
	//tìm theo mã sản phẩm sách
	@Override
	public Sach getTheoMaSPSach(String maSPSach) {
		Sach sach = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SANPHAM where MASANPHAM = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maSPSach);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("MASANPHAM");
				String tenSanPham = rs.getString("TENSANPHAM");
				float giaMua = rs.getFloat("GIAMUA");
				int soLuong = rs.getInt("SOLUONG");
				float giaBan = rs.getFloat("GIABAN");
				String nhaXuatBan = rs.getString("NHAXUATBAN");
				String tacGia = rs.getString("TACGIA");
				int namXB = rs.getInt("NAMXUATBAN");
				int soTrang = rs.getInt("SOTRANG");
				float thueVAT = rs.getFloat("THUEVAT");
				String maDanhMuc = rs.getString("MADANHMUC");
				String maKeHang = rs.getString("MAKEHANG");
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String maNhaCungCap = rs.getString("MANHACUNGCAP");
				DanhMuc maDM = new DanhMuc(maDanhMuc);
				KeHang maKH = new KeHang(maKeHang);
				KhuyenMai maKM = new KhuyenMai(maKhuyenMai);
				NhaCungCap nCC = new NhaCungCap(maNhaCungCap);
				String tinhTrang = rs.getString("TINHTRANG");
				sach = new Sach(maSanPham, tenSanPham, giaMua, soLuong, giaBan, nhaXuatBan, tacGia, namXB, soTrang, thueVAT, maDM, maKH, maKM, nCC, tinhTrang); 
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
		return sach;
	}

//	@Override
//	public SanPham getSoLuongTheoMaSP(String maSP) {
//		SanPham sp = null;
//		PreparedStatement sta = null;
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT SOLUONG FROM SanPham WHERE MASANPHAM = ?";
//			sta = con.prepareStatement(sql);
//			sta.setString(1, maSP);
//			ResultSet rs = sta.executeQuery();
//			while (rs.next()) {
//				int soLuong = rs.getInt("SOLUONG");
//				sp = new SanPham(maSP, soLuong);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				sta.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return sp;
//	}
	//Thêm sản phẩm sách
	@Override
	public boolean themSPSach(Sach s) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into SANPHAM values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1,s.getMaSP());
			sta.setString(2, s.getTenSP());
			sta.setFloat(3, s.getGiaMua());
			sta.setInt(4, s.getSoLuong());
			sta.setFloat(5, s.getGiaBan());
			sta.setString(6, s.getNhaXB());
			sta.setString(7, s.getTacGia());
			sta.setInt(8, s.getNamXB());
			sta.setInt(9, s.getSoTrang());
			sta.setString(10, s.getMaDanhMuc().getMaDanhMuc());
			sta.setString(11, s.getMaKeHang().getMaKeHang());
			sta.setString(12, s.getMaKhuyenMai().getMaKhuyenMai());
			sta.setString(13, s.getTinhTrang());
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
	//Cập nhật sản phẩm sách
	@Override
	public boolean capnhatSPSach(Sach s) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update SANPHAM set TENSANPHAM = ?, GIAMUA = ?, SOLUONG = ?, GIABAN = ?, NHAXUATBAN = ?, TACGIA = ?, NAMXUATBAN = ?, SOTRANG = ?, MADANHMUC = ?,"
					+ " MAKEHANG = ?, MAKHUYENMAI = ? TINHTRANG = ? where MASANPHAM = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, s.getTenSP());
			sta.setFloat(2, s.getGiaMua());
			sta.setInt(3, s.getSoLuong());
			sta.setFloat(4, s.getGiaBan());
			sta.setString(5, s.getNhaXB());
			sta.setString(6, s.getTacGia());
			sta.setInt(7, s.getNamXB());
			sta.setInt(8, s.getSoTrang());
			sta.setString(9, s.getMaDanhMuc().getMaDanhMuc());
			sta.setString(10, s.getMaKeHang().getMaKeHang());
			sta.setString(11, s.getMaKhuyenMai().getMaKhuyenMai());
			sta.setString(12, s.getTinhTrang());
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
