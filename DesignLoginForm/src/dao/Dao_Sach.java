package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.DanhMuc;
import entity.KeHang;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Sach;
import interfaces.I_Sach;

public class Dao_Sach implements I_Sach {

	public Dao_Sach() {

	}
	//lấy toàn bộ sản phẩm sách
	@Override
	public ArrayList<Sach> getAllSach(String maSach) {
		ArrayList<Sach> dsS = new ArrayList<Sach>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SANPHAM where MASANPHAM LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + maSach + "%");

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
				DanhMuc danhMuc = new DanhMuc(rs.getString("MADANHMUC"));
				KeHang keHang = new KeHang(rs.getString("MAKEHANG"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MAKHUYENMAI"));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MANHACUNGCAP"));
				String tinhTrang = rs.getString("TINHTRANG");

				Sach s = new Sach(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang, tacGia, nhaXuatBan, namXB, soTrang);
				dsS.add(s);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsS;
	}
	//tìm theo mã sản phẩm sách
	@Override
	public Sach getSachTheoMa(String maSPSach) {
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
				DanhMuc danhMuc = new DanhMuc(rs.getString("MADANHMUC"));
				KeHang keHang = new KeHang(rs.getString("MAKEHANG"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MAKHUYENMAI"));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MANHACUNGCAP"));
				String tinhTrang = rs.getString("TINHTRANG");
				sach = new Sach(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang, tacGia, nhaXuatBan, namXB, soTrang);
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

	//Thêm sản phẩm sách
	@Override
	public boolean themSach(Sach s) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into SANPHAM (MASANPHAM, TENSANPHAM, GIAMUA, SOLUONG, GIABAN, NHAXUATBAN, TACGIA, NAMXUATBAN, SOTRANG, THUEVAT, MADANHMUC, MAKEHANG, MAKHUYENMAI, MANHACUNGCAP, TINHTRANG) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1, s.getMaSP());
			sta.setString(2, s.getTenSP());
			sta.setFloat(3, s.getGiaMua());
			sta.setInt(4, s.getSoLuong());
			sta.setFloat(5, s.getGiaBan());
			sta.setString(6, s.getNhaXB());
			sta.setString(7, s.getTacGia());
			sta.setInt(8, s.getNamXB());
			sta.setInt(9, s.getSoTrang());
			sta.setFloat(10, s.getThueVAT());
			sta.setString(11, s.getDanhMuc().getMaDanhMuc());
			sta.setString(12, s.getKeHang().getMaKeHang());

			// Check if KhuyenMai is not null before setting its value
			if (s.getKhuyenMai() != null) {
			    sta.setString(13, s.getKhuyenMai().getMaKhuyenMai());
			} else {
			    sta.setNull(13, Types.VARCHAR); // Set as NULL in the database
			}

			sta.setString(14, s.getNhaCungCap().getMaNhaCungCap());
			sta.setString(15, s.getTinhTrang());
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
	public boolean capnhatSach(Sach s) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update SANPHAM set TENSANPHAM = ?, GIAMUA = ?, SOLUONG = ?, GIABAN = ?, NHAXUATBAN = ?, TACGIA = ?, NAMXUATBAN = ?, SOTRANG = ?, THUEVAT = ?, MADANHMUC = ?,"
					+ " MAKEHANG = ?, MAKHUYENMAI = ?, MANHACUNGCAP = ?, TINHTRANG = ? where MASANPHAM = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, s.getTenSP());
			sta.setFloat(2, s.getGiaMua());
			sta.setInt(3, s.getSoLuong());
			sta.setFloat(4, s.getGiaBan());
			sta.setString(5, s.getNhaXB());
			sta.setString(6, s.getTacGia());
			sta.setInt(7, s.getNamXB());
			sta.setInt(8, s.getSoTrang());
			sta.setFloat(9, s.getThueVAT());
			sta.setString(10, s.getDanhMuc().getMaDanhMuc());
			sta.setString(11, s.getKeHang().getMaKeHang());
			// Check if KhuyenMai is not null before setting its value
	        if (s.getKhuyenMai() != null) {
	            sta.setString(12, s.getKhuyenMai().getMaKhuyenMai());
	        } else {
	            sta.setNull(12, Types.VARCHAR); // Set as NULL in the database
	        }
			sta.setString(13, s.getNhaCungCap().getMaNhaCungCap());
			sta.setString(14, s.getTinhTrang());
			sta.setString(15, s.getMaSP());
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
	@Override
	public ArrayList<Sach> getListSachTheoTen(String tenSach) {
		ArrayList<Sach> dsS = new ArrayList<Sach>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SANPHAM where TENSANPHAM LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + tenSach + "%");

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
				DanhMuc danhMuc = new DanhMuc(rs.getString("MADANHMUC"));
				KeHang keHang = new KeHang(rs.getString("MAKEHANG"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MAKHUYENMAI"));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MANHACUNGCAP"));
				String tinhTrang = rs.getString("TINHTRANG");

				Sach s = new Sach(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang, tacGia, nhaXuatBan, namXB, soTrang);
				dsS.add(s);
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
		return dsS;
	}
	@Override
	public ArrayList<Sach> getListSachTheoTacGia(String tenTacGia) {
		ArrayList<Sach> dsS = new ArrayList<Sach>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SANPHAM where TACGIA LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + tenTacGia + "%");

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
				DanhMuc danhMuc = new DanhMuc(rs.getString("MADANHMUC"));
				KeHang keHang = new KeHang(rs.getString("MAKEHANG"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MAKHUYENMAI"));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MANHACUNGCAP"));
				String tinhTrang = rs.getString("TINHTRANG");

				Sach s = new Sach(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang, tacGia, nhaXuatBan, namXB, soTrang);
				dsS.add(s);
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
		return dsS;
	}
	
	

}
