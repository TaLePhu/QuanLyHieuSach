package entity;

public class Sach extends SanPham {
	private String tacGia;
	private String nhaXB;
	private int namXB;
	private int soTrang;

	public Sach(String maSP, String tenSP, float giaMua, int soLuong, float giaBan,float thueVAT, DanhMuc maDanhMuc, KeHang maKeHang,
			KhuyenMai maKhuyenMai,NhaCungCap maNhaCungCap, String tinhTrang, String tacGia, String nhaXB, int namXB, int soTrang) {
		super(maSP, tenSP, giaMua, soLuong, giaBan,thueVAT,  maDanhMuc, maKeHang, maKhuyenMai,maNhaCungCap, tinhTrang);
		this.tacGia = tacGia;
		this.nhaXB = nhaXB;
		this.namXB = namXB;
		this.soTrang = soTrang;
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSP, String tenSP, float giaMua, int soLuong, float giaBan, float thueVAT, DanhMuc maDanhMuc, KeHang maKeHang,
			KhuyenMai maKhuyenMai, NhaCungCap maNhaCungCap,String tinhTrang) {
		super(maSP, tenSP, giaMua, soLuong, giaBan, thueVAT, maDanhMuc, maKeHang, maKhuyenMai, maNhaCungCap, tinhTrang);
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSP) {
		super(maSP);
		// TODO Auto-generated constructor stub
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	@Override
	public String toString() {
		return "Sach [tacGia=" + tacGia + ", nhaXB=" + nhaXB + ", namXB=" + namXB + ", soTrang=" + soTrang + "]";
	}

}
