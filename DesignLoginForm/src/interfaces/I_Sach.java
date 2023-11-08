package interfaces;

import java.util.ArrayList;

import entity.Sach;

public interface I_Sach {
	public ArrayList<Sach> getAllSanPhamSach();

	public Sach getTheoMaSPSach(String maSPSach);
	
	public boolean themSPSach(Sach s);
	
	public boolean capnhatSPSach(Sach s);
}

