package interfaces;

import java.util.ArrayList;

import entity.VanPhongPham;

public interface I_VanPhongPham {

	public ArrayList<VanPhongPham> getAllVPP(String maVPP);

	public VanPhongPham getVPPTheoMa(String maVPP);

	public boolean capnhatVPP(VanPhongPham vpp);

	public boolean themVPP(VanPhongPham vpp);
	
	public ArrayList<VanPhongPham> getListVPPTheoTen(String tenVPP);
}
