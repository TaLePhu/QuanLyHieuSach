package entity;

import java.util.Objects;

public class KeHang {
	private String maKeHang;
	private String tenKeHang;
	private String viTri;
	private int sucChua;
	private String tinhTrang;
	public String getMaKeHang() {
		return maKeHang;
	}
	public void setMaKeHang(String maKeHang) {
		this.maKeHang = maKeHang;
	}
	public String getTenKeHang() {
		return tenKeHang;
	}
	public void setTenKeHang(String tenKeHang) {
		this.tenKeHang = tenKeHang;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public KeHang(String maKeHang, String tenKeHang, String viTri, int sucChua, String tinhTrang) {
		super();
		this.maKeHang = maKeHang;
		this.tenKeHang = tenKeHang;
		this.viTri = viTri;
		this.sucChua = sucChua;
		this.tinhTrang = tinhTrang;
	}
	public KeHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KeHang(String maKeHang) {
		super();
		this.maKeHang = maKeHang;
	}
	@Override
	public String toString() {
		return "KeHang [maKeHang=" + maKeHang + ", tenKeHang=" + tenKeHang + ", viTri=" + viTri + ", sucChua=" + sucChua
				+ ", tinhTrang=" + tinhTrang + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKeHang, sucChua, tenKeHang, tinhTrang, viTri);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeHang other = (KeHang) obj;
		return Objects.equals(maKeHang, other.maKeHang) && sucChua == other.sucChua
				&& Objects.equals(tenKeHang, other.tenKeHang) && Objects.equals(tinhTrang, other.tinhTrang)
				&& Objects.equals(viTri, other.viTri);
	}
	
	
}
