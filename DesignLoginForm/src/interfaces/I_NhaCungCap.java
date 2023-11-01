package interfaces;

import java.util.ArrayList;

import entity.NhaCungCap;

public interface I_NhaCungCap {

	public ArrayList<NhaCungCap> getAllNhaCungCap();
	
	public NhaCungCap getNCCTheoMa(String maNCC);
	
	public ArrayList<NhaCungCap> getNCCTheoTen(String tenNCC);
	
	public boolean them(NhaCungCap ncc);
	
	public boolean capNhat(NhaCungCap ncc);
}
