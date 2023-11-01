package entity;

import java.util.Objects;

public class TaiKhoan {
	private String maTaiKhoan;
	private String matKhau;
	private String tenTaiKhoan;
	private NhanVien nhanVien;
	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public TaiKhoan(String maTaiKhoan, String matKhau, String tenTaiKhoan, NhanVien nhanVien) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.matKhau = matKhau;
		this.tenTaiKhoan = tenTaiKhoan;
		this.nhanVien = nhanVien;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String maTaiKhoan) {
		super();
		this.maTaiKhoan = maTaiKhoan;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", matKhau=" + matKhau + ", tenTaiKhoan=" + tenTaiKhoan
				+ ", nhanVien=" + nhanVien + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTaiKhoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTaiKhoan, other.maTaiKhoan);
	}
	
	
	
	
}
