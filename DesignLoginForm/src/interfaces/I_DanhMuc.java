package interfaces;

import java.util.ArrayList;

import entity.DanhMuc;

public interface I_DanhMuc {
	public ArrayList<DanhMuc> getAllDanhMuc();
	
	public ArrayList<DanhMuc> getDanhMucTheoTen(String tenDanhMuc);
	
	public DanhMuc getDanhMucTheoMa(String maDanhMuc);
	
	public boolean them(DanhMuc dm);
	
	public boolean capNhat(DanhMuc dm);
	
	public boolean xoa (String maDanhMuc );
}
