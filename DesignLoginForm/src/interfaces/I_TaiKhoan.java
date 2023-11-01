package interfaces;

import java.util.ArrayList;

import entity.TaiKhoan;

public interface I_TaiKhoan {
	
	public ArrayList<TaiKhoan> getAllTaiKhoan();
	
	public TaiKhoan getTheoMaTK(String maTK);
	
	public boolean them(TaiKhoan tk);
	
	public boolean capNhat(TaiKhoan tk);
	
	public ArrayList<TaiKhoan> getTKTheoEmailNV(String email);
	
	public ArrayList<TaiKhoan> getTKTheoTenNV(String tenNV);

}
