package dao;

import java.sql.Connection;
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
import entity.Sach;
import entity.VanPhongPham;
import interfaces.I_VanPhongPham;

public class Dao_VanPhongPham implements I_VanPhongPham{
	public Dao_VanPhongPham() {
	}
	
	//Lấy toàn bộ sản phẩm văn phòng phẩm
	public ArrayList<VanPhongPham> getAllVPP( String maVPP) {
		ArrayList<VanPhongPham> dsVPP = new ArrayList<VanPhongPham>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SANPHAM where MASANPHAM LIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + maVPP + "%");
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
				DanhMuc danhMuc = new DanhMuc(rs.getString("MADANHMUC"));
				KeHang keHang = new KeHang(rs.getString("MAKEHANG"));
				KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MAKHUYENMAI"));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MANHACUNGCAP"));
				String tinhTrang = rs.getString("TINHTRANG");

				VanPhongPham vpp = new VanPhongPham(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang, thuongHieu, xuatXu, mauSac, chatLieu);
				dsVPP.add(vpp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsVPP;
	}
	
	//Tim VPP theo mã
		@Override
		public VanPhongPham getVPPTheoMa(String maVPP) {
			VanPhongPham vpp = null;
			PreparedStatement sta = null;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select * from SANPHAM where MASANPHAM = ?";
				sta = con.prepareStatement(sql);
				sta.setString(1, maVPP);
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
					DanhMuc danhMuc = new DanhMuc(rs.getString("MADANHMUC"));
					KeHang keHang = new KeHang(rs.getString("MAKEHANG"));
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MAKHUYENMAI"));
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MANHACUNGCAP"));
					String tinhTrang = rs.getString("TINHTRANG");
					vpp = new VanPhongPham(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang, thuongHieu, xuatXu, mauSac, chatLieu);
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
		
		//Thêm VPP
		@Override
		public boolean themVPP(VanPhongPham vpp) {
			PreparedStatement sta = null;
			int n=0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "insert into SANPHAM (MASANPHAM, TENSANPHAM, GIAMUA, SOLUONG, GIABAN, THUONGHIEU, XUATXU, MAUSAC, CHATLIEU, THUEVAT, MADANHMUC, MAKEHANG, MAKHUYENMAI, MANHACUNGCAP, TINHTRANG) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				sta = con.prepareStatement(sql);
				sta.setString(1,vpp.getMaSP());
				sta.setString(2, vpp.getTenSP());
				sta.setFloat(3, vpp.getGiaMua());
				sta.setInt(4, vpp.getSoLuong());
				sta.setFloat(5, vpp.getGiaBan());
				sta.setString(6, vpp.getThuongHieu());
				sta.setString(7, vpp.getXuatXu());
				sta.setString(8, vpp.getMauSac());
				sta.setString(9, vpp.getChatLieu());
				sta.setFloat(10, vpp.getThueVAT());
				sta.setString(11, vpp.getDanhMuc().getMaDanhMuc());
				sta.setString(12, vpp.getKeHang().getMaKeHang());
				// Check if KhuyenMai is not null before setting its value
				if (vpp.getKhuyenMai() != null) {
				    sta.setString(13, vpp.getKhuyenMai().getMaKhuyenMai());
				} else {
				    sta.setNull(13, Types.VARCHAR); // Set as NULL in the database
				}
				sta.setString(14, vpp.getNhaCungCap().getMaNhaCungCap());
				sta.setString(15, vpp.getTinhTrang());
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
		//Cập nhật VPP
		@Override
		public boolean capnhatVPP(VanPhongPham vpp) {
			PreparedStatement sta = null;
			int n=0;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "update SANPHAM set TENSANPHAM = ?, GIAMUA = ?, SOLUONG = ?, GIABAN = ?, THUONGHIEU = ?, XUATXU = ?, MAUSAC = ?, CHATLIEU = ?, THUEVAT = ?, MADANHMUC = ?,"
						+ " MAKEHANG = ?, MAKHUYENMAI = ?, MANHACUNGCAP = ?, TINHTRANG = ? where MASANPHAM = ?";
				sta = con.prepareStatement(sql);
				sta.setString(1, vpp.getTenSP());
				sta.setFloat(2, vpp.getGiaMua());
				sta.setInt(3, vpp.getSoLuong());
				sta.setFloat(4, vpp.getGiaBan());
				sta.setString(5, vpp.getThuongHieu());
				sta.setString(6, vpp.getXuatXu());
				sta.setString(7, vpp.getMauSac());
				sta.setString(8, vpp.getChatLieu());
				sta.setFloat(9, vpp.getThueVAT());
				sta.setString(10, vpp.getDanhMuc().getMaDanhMuc());
				sta.setString(11, vpp.getKeHang().getMaKeHang());
				// Check if KhuyenMai is not null before setting its value
				if (vpp.getKhuyenMai() != null) {
				    sta.setString(12, vpp.getKhuyenMai().getMaKhuyenMai());
				} else {
				    sta.setNull(12, Types.VARCHAR); // Set as NULL in the database
				}
				sta.setString(13, vpp.getNhaCungCap().getMaNhaCungCap());
				sta.setString(14, vpp.getTinhTrang());
				sta.setString(15,vpp.getMaSP());
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
		public ArrayList<VanPhongPham> getListVPPTheoTen(String tenVPP) {
			ArrayList<VanPhongPham> dsVPP = new ArrayList<VanPhongPham>();
			PreparedStatement sta = null;
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select * from SANPHAM where TENSANPHAM LIKE ?";
				sta = con.prepareStatement(sql);
				sta.setString(1, "%" + tenVPP + "%");
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
					DanhMuc danhMuc = new DanhMuc(rs.getString("MADANHMUC"));
					KeHang keHang = new KeHang(rs.getString("MAKEHANG"));
					KhuyenMai khuyenMai = new KhuyenMai(rs.getString("MAKHUYENMAI"));
					NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MANHACUNGCAP"));
					String tinhTrang = rs.getString("TINHTRANG");
					VanPhongPham vpp = new VanPhongPham(maSanPham, tenSanPham, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang, thuongHieu, xuatXu, mauSac, chatLieu);
					dsVPP.add(vpp);
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
			return dsVPP;
		}
		

}
