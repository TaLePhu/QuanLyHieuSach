package entity;

import java.util.Objects;

public class nhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String diaChi;
	private String soDT;
	private String email;
	private String tinhTrang;
	public nhaCungCap(String maNCC, String tenNCC, String diaChi, String soDT, String email, String tinhTrang) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
		this.tinhTrang = tinhTrang;
	}
	public nhaCungCap(String maNCC) {
		super();
		this.maNCC = maNCC;
	}
	public nhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNCC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		nhaCungCap other = (nhaCungCap) obj;
		return Objects.equals(maNCC, other.maNCC);
	}
	@Override
	public String toString() {
		return "nhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", soDT=" + soDT
				+ ", email=" + email + ", tinhTrang=" + tinhTrang + "]";
	}
	
}
