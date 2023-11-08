package interfaces;

import java.util.ArrayList;

import entity.VanPhongPham;

public interface I_VanPhongPham {

	public ArrayList<VanPhongPham> getAllSanPhamVanPhong();

	public VanPhongPham getTheoMaSPVanPhong(String maSPVanPhong);

	public boolean capnhatSPVanPhong(VanPhongPham v);

	public boolean themSPVanPhong(VanPhongPham v);
}
