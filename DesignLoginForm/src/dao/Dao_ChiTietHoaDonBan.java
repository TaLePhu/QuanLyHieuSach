package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.ChiTietHoaDonBan;
import entity.HoaDonBan;

public class Dao_ChiTietHoaDonBan {
	public Dao_ChiTietHoaDonBan() {
		// TODO Auto-generated constructor stub
	}
	
	// thêm chi tiết hóa đơn
	public boolean createCTHoaDon(ChiTietHoaDonBan cthd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into CHITIETHOADONBAN values(?,?,?,?)");
			stmt.setString(1, cthd.getHoaDonBan().getMaHDBan());
			stmt.setString(2, cthd.getSanPham().getMaSP());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setFloat(4,cthd.getThanhTien());
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
}
