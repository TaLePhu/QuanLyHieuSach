package entity;

import java.util.Objects;

public class SanPham {
	private String maSP;
	private String tenSP;
	private float giaMua;
	private int soLuong;
	private float giaBan;
	private float thueVAT;
	private DanhMuc danhMuc;
	private KeHang keHang;
	private KhuyenMai khuyenMai;
	private NhaCungCap nhaCungCap;
	private String tinhTrang;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public float getGiaMua() {
		return giaMua;
	}
	public void setGiaMua(float giaMua) {
		this.giaMua = giaMua;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public float getThueVAT() {
		return thueVAT;
	}
	public void setThueVAT(float thueVAT) {
		this.thueVAT = thueVAT;
	}
	public DanhMuc getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	public KeHang getKeHang() {
		return keHang;
	}
	public void setKeHang(KeHang keHang) {
		this.keHang = keHang;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public SanPham(String maSP, String tenSP, float giaMua, int soLuong, float giaBan, float thueVAT, DanhMuc danhMuc,
			KeHang keHang, KhuyenMai khuyenMai, NhaCungCap nhaCungCap, String tinhTrang) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaMua = giaMua;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thueVAT = thueVAT;
		this.danhMuc = danhMuc;
		this.keHang = keHang;
		this.khuyenMai = khuyenMai;
		this.nhaCungCap = nhaCungCap;
		this.tinhTrang = tinhTrang;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaMua=" + giaMua + ", soLuong=" + soLuong
				+ ", giaBan=" + giaBan + ", thueVAT=" + thueVAT + ", danhMuc=" + danhMuc + ", keHang=" + keHang
				+ ", khuyenMai=" + khuyenMai + ", nhaCungCap=" + nhaCungCap + ", tinhTrang=" + tinhTrang + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}

	

}
