package interfaces;

import java.util.ArrayList;

import entity.Sach;

public interface I_Sach {
	public ArrayList<Sach> getAllSach(String maSach);

	public Sach getSachTheoMa(String maSach);
	
	public boolean themSach(Sach s);
	
	public boolean capnhatSach(Sach s);
	
	public ArrayList<Sach> getListSachTheoTen(String tenSach);
	
	public ArrayList<Sach> getListSachTheoTacGia(String tenTacGia);
}

