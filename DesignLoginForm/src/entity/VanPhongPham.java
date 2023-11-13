package entity;

import java.util.Objects;

public class VanPhongPham extends SanPham {
	private String thuongHieu;
	private String xuatXu;
	private String mauSac; 
	private String chatLieu;
	
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public VanPhongPham(String maSP, String tenSP, float giaMua, int soLuong, float giaBan, float thueVAT,
			DanhMuc danhMuc, KeHang keHang, KhuyenMai khuyenMai, NhaCungCap nhaCungCap, String tinhTrang,
			String thuongHieu, String xuatXu, String mauSac, String chatLieu) {
		super(maSP, tenSP, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang);
		this.thuongHieu = thuongHieu;
		this.xuatXu = xuatXu;
		this.mauSac = mauSac;
		this.chatLieu = chatLieu;
	}
	public VanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VanPhongPham(String maSP) {
		super(maSP);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VanPhongPham [thuongHieu=" + thuongHieu + ", xuatXu=" + xuatXu + ", mauSac=" + mauSac + ", chatLieu="
				+ chatLieu + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(chatLieu, mauSac, thuongHieu, xuatXu);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VanPhongPham other = (VanPhongPham) obj;
		return Objects.equals(chatLieu, other.chatLieu) && Objects.equals(mauSac, other.mauSac)
				&& Objects.equals(thuongHieu, other.thuongHieu) && Objects.equals(xuatXu, other.xuatXu);
	}
	
	
	
	

	

}
