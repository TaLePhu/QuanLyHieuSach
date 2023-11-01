package interfaces;

import java.util.ArrayList;

import entity.KeHang;

public interface I_KeHang {

	public ArrayList<KeHang> getAllKeHang();
	
	public ArrayList<KeHang> getKeHangTheoTen(String tenKeHang);
	
	public KeHang getKeHangTheoMa(String maKeHang);
	
	public boolean them(KeHang kh);
	
	public boolean capNhat(KeHang kh);
	
}
