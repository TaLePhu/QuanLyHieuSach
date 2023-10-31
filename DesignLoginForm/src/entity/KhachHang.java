package entity;

import java.util.Date;
import java.util.Objects;

public class KhachHang {
	private String maKhachhang;
	private String tenKhachHang;
	private String diaChi;
	private Date ngaySinh;
	private String soDT;
	private String email;
	private boolean gioiTinh;

	public KhachHang(String maKhachhang, String tenKhachHang, String diaChi, Date ngaySinh, String soDT, String email,
			boolean gioiTinh) {
		super();
		this.maKhachhang = maKhachhang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.soDT = soDT;
		this.email = email;
		this.gioiTinh = gioiTinh;
	}

	public KhachHang(String maKhachhang) {
		super();
		this.maKhachhang = maKhachhang;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaKhachhang() {
		return maKhachhang;
	}

	public void setMaKhachhang(String maKhachhang) {
		this.maKhachhang = maKhachhang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhachhang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachhang, other.maKhachhang);
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachhang=" + maKhachhang + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi
				+ ", ngaySinh=" + ngaySinh + ", soDT=" + soDT + ", email=" + email + ", gioiTinh=" + gioiTinh + "]";
	}

}
