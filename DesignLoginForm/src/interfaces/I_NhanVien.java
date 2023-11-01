package interfaces;

import java.util.ArrayList;

import entity.NhanVien;

public interface I_NhanVien {
	
	public ArrayList<NhanVien> getAllNhanVien();
	
	public NhanVien getTheoMaNV(String maNV);
	
	public ArrayList<NhanVien> getTheoHoTen(String hoTen);
	
	public ArrayList<NhanVien> getTheoSDT(String sdt);
	
	public boolean them(NhanVien nv);
	
	public boolean capNhat(NhanVien nv);
	
}
