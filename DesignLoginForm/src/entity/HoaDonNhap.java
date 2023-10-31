package entity;

import java.util.Date;
import java.util.Objects;

public class HoaDonNhap {
	private String maHDNhap;
	private String trangThai;
	private nhaCungCap nhaCC;
	private NhanVien nhanVien;
	private Date ngayGiaoDich;
	private float tongThanhTien;

	public HoaDonNhap(String maHDNhap, String trangThai, nhaCungCap nhaCC, NhanVien nhanVien, Date ngayGiaoDich,
			float tongThanhTien) {
		super();
		this.maHDNhap = maHDNhap;
		this.trangThai = trangThai;
		this.nhaCC = nhaCC;
		this.nhanVien = nhanVien;
		this.ngayGiaoDich = ngayGiaoDich;
		this.tongThanhTien = tongThanhTien;
	}

	public HoaDonNhap(String maHDNhap) {
		super();
		this.maHDNhap = maHDNhap;
	}

	public HoaDonNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaHDNhap() {
		return maHDNhap;
	}

	public void setMaHDNhap(String maHDNhap) {
		this.maHDNhap = maHDNhap;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public nhaCungCap getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(nhaCungCap nhaCC) {
		this.nhaCC = nhaCC;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Date getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(Date ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}

	public float getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(float tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHDNhap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonNhap other = (HoaDonNhap) obj;
		return Objects.equals(maHDNhap, other.maHDNhap);
	}

	@Override
	public String toString() {
		return "HoaDonNhap [maHDNhap=" + maHDNhap + ", trangThai=" + trangThai + ", nhaCC=" + nhaCC + ", nhanVien="
				+ nhanVien + ", ngayGiaoDich=" + ngayGiaoDich + ", tongThanhTien=" + tongThanhTien + "]";
	}

}
