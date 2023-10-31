package entity;

import java.util.Date;
import java.util.Objects;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private int giaTriGiam;
	private Date ngayBD;
	private Date ngayKT;
	private String doiTuongApDung;
	
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, int giaTriGiam, Date ngayBD, Date ngayKT,
			String doiTuongApDung) {
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.giaTriGiam = giaTriGiam;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
		this.doiTuongApDung = doiTuongApDung;
	}
	public KhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public KhuyenMai() {
	}
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public int getGiaTriGiam() {
		return giaTriGiam;
	}
	public void setGiaTriGiam(int giaTriGiam) {
		this.giaTriGiam = giaTriGiam;
	}
	public Date getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}
	public Date getNgayKT() {
		return ngayKT;
	}
	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}
	public String getDoiTuongApDung() {
		return doiTuongApDung;
	}
	public void setDoiTuongApDung(String doiTuongApDung) {
		this.doiTuongApDung = doiTuongApDung;
	}
	@Override
	public String toString() {
		return "KhuyenMai [maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", giaTriGiam=" + giaTriGiam
				+ ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + ", doiTuongApDung=" + doiTuongApDung + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhuyenMai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(maKhuyenMai, other.maKhuyenMai);
	}
	
	 
	
}
