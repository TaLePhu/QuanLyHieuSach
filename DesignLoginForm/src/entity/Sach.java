package entity;

import java.util.Objects;

public class Sach extends SanPham {
	private String tacGia;
	private String nhaXB;
	private int namXB;
	private int soTrang;
	
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNhaXB() {
		return nhaXB;
	}
	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public Sach(String maSP, String tenSP, float giaMua, int soLuong, float giaBan, float thueVAT, DanhMuc danhMuc,
			KeHang keHang, KhuyenMai khuyenMai, NhaCungCap nhaCungCap, String tinhTrang, String tacGia, String nhaXB,
			int namXB, int soTrang) {
		super(maSP, tenSP, giaMua, soLuong, giaBan, thueVAT, danhMuc, keHang, khuyenMai, nhaCungCap, tinhTrang);
		this.tacGia = tacGia;
		this.nhaXB = nhaXB;
		this.namXB = namXB;
		this.soTrang = soTrang;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sach(String maSP) {
		super(maSP);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sach [tacGia=" + tacGia + ", nhaXB=" + nhaXB + ", namXB=" + namXB + ", soTrang=" + soTrang + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(namXB, nhaXB, soTrang, tacGia);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return namXB == other.namXB && Objects.equals(nhaXB, other.nhaXB) && soTrang == other.soTrang
				&& Objects.equals(tacGia, other.tacGia);
	}
	

	

}
