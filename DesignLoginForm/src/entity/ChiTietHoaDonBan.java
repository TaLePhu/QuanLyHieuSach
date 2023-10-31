package entity;

public class ChiTietHoaDonBan {
	private HoaDonBan hoaDonBan;
	private SanPham sanPham;
	private int soLuong;
	private float thanhTien;

	public ChiTietHoaDonBan(HoaDonBan hoaDonBan, SanPham sanPham, int soLuong, float thanhTien) {
		super();
		this.hoaDonBan = hoaDonBan;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public ChiTietHoaDonBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDonBan getHoaDonBan() {
		return hoaDonBan;
	}

	public void setHoaDonBan(HoaDonBan hoaDonBan) {
		this.hoaDonBan = hoaDonBan;
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

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonBan [hoaDonBan=" + hoaDonBan + ", sanPham=" + sanPham + ", soLuong=" + soLuong
				+ ", thanhTien=" + thanhTien + "]";
	}

}
