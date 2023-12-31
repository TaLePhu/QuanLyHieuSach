package entity;

import java.util.Objects;

public class DanhMuc {
	private String maDanhMuc;
	private String tenDanhMuc;
	public String getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public DanhMuc(String maDanhMuc, String tenDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
	}
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DanhMuc(String maDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
	}
	@Override
	public String toString() {
		return "DanhMuc [maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDanhMuc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanhMuc other = (DanhMuc) obj;
		return Objects.equals(maDanhMuc, other.maDanhMuc);
	}
	
	
}
