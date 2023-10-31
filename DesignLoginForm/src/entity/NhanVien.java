package entity;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private String maNhanvien;
	private String tenNhanVien;
	private Date ngaySinh;
	private String diaChi;
	private String email;
	private boolean gioiTinh;
	private String chucVu;
	private String tinhTrang;

	public NhanVien(String maNhanvien, String tenNhanVien, Date ngaySinh, String diaChi, String email, boolean gioiTinh,
			String chucVu, String tinhTrang) {
		super();
		this.maNhanvien = maNhanvien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.tinhTrang = tinhTrang;
	}

	public NhanVien(String maNhanvien) {
		super();
		this.maNhanvien = maNhanvien;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaNhanvien() {
		return maNhanvien;
	}

	public void setMaNhanvien(String maNhanvien) {
		this.maNhanvien = maNhanvien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanvien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanvien, other.maNhanvien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanvien=" + maNhanvien + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh
				+ ", diaChi=" + diaChi + ", email=" + email + ", gioiTinh=" + gioiTinh + ", chucVu=" + chucVu
				+ ", tinhTrang=" + tinhTrang + "]";
	}

}
