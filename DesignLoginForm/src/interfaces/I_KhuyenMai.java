package interfaces;

import java.util.ArrayList;

import entity.KhuyenMai;


public interface I_KhuyenMai {
	
	public ArrayList<KhuyenMai> getAllKhuyenMai();
	
	public KhuyenMai getKhuyenMaiTheoMa(String maKM);
	
	public ArrayList<KhuyenMai> getKhuyenMaiTheoTen(String tenKM);
	
	public boolean them(KhuyenMai km);
	
	public boolean capNhat(KhuyenMai km);
	

}
