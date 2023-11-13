package entity;

import java.util.Date;
import java.util.Objects;

public class HoaDonBan {
	private String maHDBan;
	private NhanVien maNV;
	private KhachHang maKH;
	private KhuyenMai maKM;
	private Date ngayGD;
	private String trangThai;
	private float tongThanhTien;

	
	public HoaDonBan(String maHDBan, NhanVien maNV, KhachHang maKH, KhuyenMai maKM, Date ngayGD, String trangThai,
			float tongThanhTien) {
		super();
		this.maHDBan = maHDBan;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maKM = maKM;
		this.ngayGD = ngayGD;
		this.trangThai = trangThai;
		this.tongThanhTien = tongThanhTien;
	}

	public HoaDonBan() {
		// TODO Auto-generated constructor stub
	}	

	public HoaDonBan(String maHDBan) {
		super();
		this.maHDBan = maHDBan;
	}

	

	public String getMaHDBan() {
		return maHDBan;
	}

	public void setMaHDBan(String maHDBan) {
		this.maHDBan = maHDBan;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public KhuyenMai getMaKM() {
		return maKM;
	}

	public void setMaKM(KhuyenMai maKM) {
		this.maKM = maKM;
	}

	public Date getNgayGD() {
		return ngayGD;
	}

	public void setNgayGD(Date ngayGD) {
		this.ngayGD = ngayGD;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public float getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(float tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHDBan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonBan other = (HoaDonBan) obj;
		return Objects.equals(maHDBan, other.maHDBan);
	}

	@Override
	public String toString() {
		return "HoaDonBan [maHDBan=" + maHDBan + ", maNV=" + maNV + ", maKH=" + maKH + ", maKM=" + maKM + ", ngayGD="
				+ ngayGD + ", trangThai=" + trangThai + ", tongThanhTien=" + tongThanhTien + "]";
	}

	

}
