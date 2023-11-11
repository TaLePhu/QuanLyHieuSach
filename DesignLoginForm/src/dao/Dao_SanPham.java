package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DanhMuc;
import entity.KeHang;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.SanPham;

public class Dao_SanPham {
	public Dao_SanPham() {
		
	}
	// tim san pham theo ma
	public ArrayList<SanPham> getSPTheoMa(String ma) {
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SANPHAM where MASANPHAM = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1,ma);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maSanPham = rs.getString("MASANPHAM");
				String tenSanPham = rs.getString("TENSANPHAM");
				float giaMua = rs.getFloat("GIAMUA");
				int soLuong = rs.getInt("SOLUONG");
				float giaBan = rs.getFloat("GIABAN");
				String maDanhMuc = rs.getString("MADANHMUC");
				String maKeHang = rs.getString("MAKEHANG");
				String maKhuyenMai = rs.getString("MAKHUYENMAI");
				DanhMuc maDM = new DanhMuc(maDanhMuc);
				KeHang maKH = new KeHang(maKeHang);
				KhuyenMai maKM = new KhuyenMai(maKhuyenMai);
				String tinhTrang = rs.getString("TINHTRANG");
				
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaMua, soLuong, giaBan, maDM, maKH, maKM, tinhTrang);
				dsSP.add(sp);
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
		return dsSP;
	}
	
	// update lại số sản phẩm còn lại sao khi bán
	public boolean update(String ma, int soLuong) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n =0;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"update SANPHAM SET SOLUONG = ? WHERE MASANPHAM = ?");
			stmt.setInt(1, soLuong);
			stmt.setString(2, ma);

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
		return n>0;
	}
}
