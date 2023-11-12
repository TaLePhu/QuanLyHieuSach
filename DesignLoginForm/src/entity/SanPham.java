package entity;

import java.util.Objects;

public class SanPham {
	private String maSP;
	private String tenSP;
	private float giaMua;
	private int soLuong;
	private float giaBan;
	private float thueVAT;
	private DanhMuc maDanhMuc;
	private KeHang maKeHang;
	private KhuyenMai maKhuyenMai;
	private NhaCungCap maNhaCungCap;
	private String tinhTrang;

	public SanPham(String maSP, String tenSP, float giaMua, int soLuong, float giaBan, float thueVAT, DanhMuc maDanhMuc,
			KeHang maKeHang, KhuyenMai maKhuyenMai, NhaCungCap maNhaCungCap, String tinhTrang) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaMua = giaMua;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thueVAT = thueVAT;
		this.maDanhMuc = maDanhMuc;
		this.maKeHang = maKeHang;
		this.maKhuyenMai = maKhuyenMai;
		this.maNhaCungCap = maNhaCungCap;
		this.tinhTrang = tinhTrang;
	}

	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public DanhMuc getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(DanhMuc maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public KeHang getMaKeHang() {
		return maKeHang;
	}

	public void setMaKeHang(KeHang maKeHang) {
		this.maKeHang = maKeHang;
	}

	public KhuyenMai getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(KhuyenMai maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public NhaCungCap getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(NhaCungCap maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
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

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaMua=" + giaMua + ", soLuong=" + soLuong
				+ ", giaBan=" + giaBan + ", thueVAT=" + thueVAT + ", maDanhMuc=" + maDanhMuc + ", maKeHang=" + maKeHang
				+ ", maKhuyenMai=" + maKhuyenMai + ", maNhaCungCap=" + maNhaCungCap + ", tinhTrang=" + tinhTrang + "]";
	}

	


}
