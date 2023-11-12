package entity;

public class VanPhongPham extends SanPham {
	private String thuongHieu;
	private String xuatXu;
	private String mauSac, chatLieu;

	public VanPhongPham(String maSP, String tenSP, float giaMua, int soLuong, float giaBan, float thueVAT,DanhMuc maDanhMuc,
			KeHang maKeHang, KhuyenMai maKhuyenMai, NhaCungCap maNhaCungCap, String tinhTrang, String thuongHieu, String xuatXu, String mauSac,
			String chatLieu) {
		super(maSP, tenSP, giaMua, soLuong, giaBan, thueVAT,maDanhMuc, maKeHang, maKhuyenMai, maNhaCungCap,tinhTrang);
		this.thuongHieu = thuongHieu;
		this.xuatXu = xuatXu;
		this.mauSac = mauSac;
		this.chatLieu = chatLieu;
	}

	public VanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VanPhongPham(String maSP, String tenSP, float giaMua, int soLuong, float giaBan, float thueVAT,DanhMuc maDanhMuc,
			KeHang maKeHang, KhuyenMai maKhuyenMai, NhaCungCap maNhaCungCap, String tinhTrang) {
		super(maSP, tenSP, giaMua, soLuong, giaBan, thueVAT,maDanhMuc, maKeHang, maKhuyenMai, maNhaCungCap,tinhTrang);
		// TODO Auto-generated constructor stub
	}

	public VanPhongPham(String maSP) {
		super(maSP);
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "VanPhongPham [thuongHieu=" + thuongHieu + ", xuatXu=" + xuatXu + ", mauSac=" + mauSac + ", chatLieu="
				+ chatLieu + "]";
	}

}
