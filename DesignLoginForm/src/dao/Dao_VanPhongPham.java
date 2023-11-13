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
import entity.VanPhongPham;
import interfaces.I_VanPhongPham;

public class Dao_VanPhongPham implements I_VanPhongPham{
	public Dao_VanPhongPham() {
	}
	
	//Lấy toàn bộ sản phẩm văn phòng phẩm
	public ArrayList<VanPhongPham> getAllSanPhamVanPhong() {
		ArrayList<VanPhongPham> dsSP = new ArrayList<VanPhongPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SanPham where SOTRANG IS NULL";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maSanPham = rs.getString("MASANPHAM");
				String tenSanPham = rs.getString("TENSANPHAM");
				float giaMua = rs.getFloat("GIAMUA");
				int soLuong = rs.getInt("SOLUONG");
				float giaBan = rs.getFloat("GIABAN");
				String thuongHieu = rs.getString("THUONGHIEU");
				String xuatXu = rs.getString("XUATXU");
				String mauSac = rs.getString("MAUSAC");
				String chatLieu = rs.getString("CHATLIEU");
				float thueVAT = rs.getFloat("THUEVAT");
				String maDanhMuc = rs.getString("MADANHMUC");
				String maKeHang = rs.getString("MAKEHANG");
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				String maNhaCungCap = rs.getNString("MANHACUNGCAP");
				DanhMuc maDM = new DanhMuc(maDanhMuc);
				KeHang maKH = new KeHang(maKeHang);
				KhuyenMai maKM = new KhuyenMai(maKhuyenMai);
				NhaCungCap maNCC = new NhaCungCap(maNhaCungCap);
				String tinhTrang = rs.getString("TINHTRANG");

				VanPhongPham sp = new VanPhongPham(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thuongHieu, xuatXu, mauSac, chatLieu, thueVAT, maDM, maKH, maKM, maNCC, tinhTrang); 
				dsSP.add(sp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSP;
	}
	
	//tìm theo mã sản phẩm sách
		@Override
		public VanPhongPham getTheoMaSPVanPhong(String maSPVanPhong) {
			VanPhongPham vpp = null;
			PreparedStatement sta = null;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select * from SANPHAM where MASANPHAM = ?";
				sta = con.prepareStatement(sql);
				sta.setString(1, maSPVanPhong);
				ResultSet rs = sta.executeQuery();
				while (rs.next()) {
					String maSanPham = rs.getString("MASANPHAM");
					String tenSanPham = rs.getString("TENSANPHAM");
					float giaMua = rs.getFloat("GIAMUA");
					int soLuong = rs.getInt("SOLUONG");
					float giaBan = rs.getFloat("GIABAN");
					String thuongHieu = rs.getString("THUONGHIEU");
					String xuatXu = rs.getString("XUATXU");
					String mauSac = rs.getString("MAUSAC");
					String chatLieu = rs.getString("CHATLIEU");
					float thueVAT = rs.getFloat("THUEVAT");
					String maDanhMuc = rs.getString("MADANHMUC");
					String maKeHang = rs.getString("MAKEHANG");
					String maKhuyenMai = rs.getString("MAKHUYENMAI");
					String maNhaCungCap = rs.getNString("MANHACUNGCAP");
					DanhMuc maDM = new DanhMuc(maDanhMuc);
					KeHang maKH = new KeHang(maKeHang);
					KhuyenMai maKM = new KhuyenMai(maKhuyenMai);
					NhaCungCap maNCC = new NhaCungCap(maNhaCungCap);
					String tinhTrang = rs.getString("TINHTRANG");
					vpp = new VanPhongPham(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thuongHieu, xuatXu, mauSac, chatLieu, thueVAT, maDM, maKH, maKM, maNCC, tinhTrang); 
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
			return vpp;
		}
		
		//Thêm sản phẩm sách
		@Override
		public boolean themSPVanPhong(VanPhongPham v) {
			PreparedStatement sta = null;
			int n=0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "insert into SANPHAM values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				sta = con.prepareStatement(sql);
				sta.setString(1,v.getMaSP());
				sta.setString(2, v.getTenSP());
				sta.setFloat(3, v.getGiaMua());
				sta.setInt(4, v.getSoLuong());
				sta.setFloat(5, v.getGiaBan());
				sta.setString(6, v.getThuongHieu());
				sta.setString(7, v.getXuatXu());
				sta.setString(8, v.getMauSac());
				sta.setString(9, v.getChatLieu());
				sta.setString(10, v.getMaDanhMuc().getMaDanhMuc());
				sta.setString(11, v.getMaKeHang().getMaKeHang());
				sta.setString(12, v.getMaKhuyenMai().getMaKhuyenMai());
				sta.setString(13, v.getTinhTrang());
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
		public boolean capnhatSPVanPhong(VanPhongPham v) {
			PreparedStatement sta = null;
			int n=0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "update SANPHAM set TENSANPHAM = ?, GIAMUA = ?, SOLUONG = ?, GIABAN = ?, THUONGHIEU = ?, XUATXU = ?, MAUSAC = ?, CHATLIEU = ?, MADANHMUC = ?,"
						+ " MAKEHANG = ?, MAKHUYENMAI = ? TINHTRANG = ? where MASANPHAM = ?";
				sta = con.prepareStatement(sql);
				sta.setString(1, v.getTenSP());
				sta.setFloat(2, v.getGiaMua());
				sta.setInt(3, v.getSoLuong());
				sta.setFloat(4, v.getGiaBan());
				sta.setString(5, v.getThuongHieu());
				sta.setString(6, v.getXuatXu());
				sta.setString(7, v.getMauSac());
				sta.setString(8, v.getChatLieu());
				sta.setString(9, v.getMaDanhMuc().getMaDanhMuc());
				sta.setString(10, v.getMaKeHang().getMaKeHang());
				sta.setString(11, v.getMaKhuyenMai().getMaKhuyenMai());
				sta.setString(12, v.getTinhTrang());
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
