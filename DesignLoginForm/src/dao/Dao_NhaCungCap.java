package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaCungCap;
import interfaces.I_NhaCungCap;

public class Dao_NhaCungCap implements I_NhaCungCap{
	
	public Dao_NhaCungCap() {
		
	}

	@Override
	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NHACUNGCAP";
			Statement sta = con.createStatement();
			ResultSet rs =sta.executeQuery(sql);
			
			while (rs.next()) {
				String maNhaCungCap = rs.getString("MANHACUNGCAP");
				String tenNhaCungCap = rs.getString("TENNHACUNGCAP");
				String diaChi = rs.getString("DIACHI");
				String sdt = rs.getString("SODIENTHOAI");
				String emmail = rs.getString("EMAIL");
				String tinhTrang = rs.getString("TINHTRANG");
				
				NhaCungCap ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, sdt, emmail, tinhTrang);
				dsNCC.add(ncc);
				
			}
			}catch (Exception e) {
				e.printStackTrace();
		}
		return dsNCC;
	}

	@Override
	public NhaCungCap getNCCTheoMa(String maNCC) {
		NhaCungCap ncc = null;
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NHACUNGCAP where MANHACUNGCAP = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maNCC);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maNhaCungCap = rs.getString("MANHACUNGCAP");
				String tenNhaCungCap = rs.getString("TENNHACUNGCAP");
				String diaChi = rs.getString("DIACHI");
				String sdt = rs.getString("SODIENTHOAI");
				String emmail = rs.getString("EMAIL");
				String tinhTrang = rs.getString("TINHTRANG");
				ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, sdt, emmail, tinhTrang);
				
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
		return ncc;
	}

	@Override
	public ArrayList<NhaCungCap> getNCCTheoTen(String tenNCC) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NHACUNGCAP where TENNHACUNGCAP lIKE ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, "%" + tenNCC + "%");

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maNhaCungCap = rs.getString("MANHACUNGCAP");
				String tenNhaCungCap = rs.getString("TENNHACUNGCAP");
				String diaChi = rs.getString("DIACHI");
				String sdt = rs.getString("SODIENTHOAI");
				String emmail = rs.getString("EMAIL");
				String tinhTrang = rs.getString("TINHTRANG");
				NhaCungCap ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, sdt, emmail, tinhTrang);
				dsNCC.add(ncc);
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
		return dsNCC;
	}

	@Override
	public boolean them(NhaCungCap ncc) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into NHACUNGCAP values(?,?,?,?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1, ncc.getMaNhaCungCap());
			sta.setString(2, ncc.getTenNhaCungCap());
			sta.setString(3, ncc.getDiaChi());
			sta.setString(4, ncc.getSoDienThoai());
			sta.setString(5, ncc.getEmail());
			sta.setString(6, ncc.getTinhTrang());
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
	public boolean capNhat(NhaCungCap ncc) {
		PreparedStatement sta = null;
		int n=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "update NHACUNGCAP set TENNHACUNGCAP = ?, DIACHI = ?, SODIENTHOAI = ?, EMAIL = ?, TINHTRANG = ? where MANHACUNGCAP = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, ncc.getTenNhaCungCap());
			sta.setString(2, ncc.getDiaChi());
			sta.setString(3, ncc.getSoDienThoai());
			sta.setString(4, ncc.getEmail());
			sta.setString(5, ncc.getTinhTrang());
			sta.setString(6, ncc.getMaNhaCungCap());
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
	
	// tìm nhà cung cấp theo số điện thoại
	public ArrayList<NhaCungCap> getNCCTheoSDT(String sdtT) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NHACUNGCAP where SODIENTHOAI = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1,sdtT);

			ResultSet rs = sta.executeQuery();

			while (rs.next()) {
				String maNhaCungCap = rs.getString("MANHACUNGCAP");
				String tenNhaCungCap = rs.getString("TENNHACUNGCAP");
				String diaChi = rs.getString("DIACHI");
				String sdt = rs.getString("SODIENTHOAI");
				String emmail = rs.getString("EMAIL");
				String tinhTrang = rs.getString("TINHTRANG");
				NhaCungCap ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, sdt, emmail, tinhTrang);
				dsNCC.add(ncc);
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
		return dsNCC;
	}
}
