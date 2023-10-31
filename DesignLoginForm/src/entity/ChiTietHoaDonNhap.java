package entity;

public class ChiTietHoaDonNhap {
	private HoaDonNhap hoaDonNhap;
	private SanPham sanPham;
	private int soLuong;
	private float donGia;
	private float thanhTien;

	public ChiTietHoaDonNhap(HoaDonNhap hoaDonNhap, SanPham sanPham, int soLuong, float donGia, float thanhTien) {
		super();
		this.hoaDonNhap = hoaDonNhap;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}

	public ChiTietHoaDonNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDonNhap getHoaDonNhap() {
		return hoaDonNhap;
	}

	public void setHoaDonNhap(HoaDonNhap hoaDonNhap) {
		this.hoaDonNhap = hoaDonNhap;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonNhap [hoaDonNhap=" + hoaDonNhap + ", sanPham=" + sanPham + ", soLuong=" + soLuong
				+ ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
	}

}
