package entity;

import java.util.Date;
import java.util.Objects;

public class HoaDonBan {
	private String maHDBan;
	private NhanVien maNV;
	private KhachHang maKH;
	private Date ngayGD;
	private String trangThai;
	private float thueVAT;
	private float tienKhachDua;
	private float tongThanhTien;
	private float tienThua;

	public HoaDonBan(String maHDBan, NhanVien maNV, KhachHang maKH, Date ngayGD, String trangThai, float thueVAT,
			float tienKhachDua, float tongThanhTien, float tienThua) {
		super();
		this.maHDBan = maHDBan;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayGD = ngayGD;
		this.trangThai = trangThai;
		this.thueVAT = thueVAT;
		this.tienKhachDua = tienKhachDua;
		this.tongThanhTien = tongThanhTien;
		this.tienThua = tienThua;
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

	public float getThueVAT() {
		return thueVAT;
	}

	public void setThueVAT(float thueVAT) {
		this.thueVAT = thueVAT;
	}

	public float getTienKhachDua() {
		return tienKhachDua;
	}

	public void setTienKhachDua(float tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}

	public float getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(float tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	public float getTienThua() {
		return tienThua;
	}

	public void setTienThua(float tienThua) {
		this.tienThua = tienThua;
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
		return "HoaDonBan [maHDBan=" + maHDBan + ", maNV=" + maNV + ", maKH=" + maKH + ", ngayGD=" + ngayGD
				+ ", trangThai=" + trangThai + ", thueVAT=" + thueVAT + ", tienKhachDua=" + tienKhachDua
				+ ", tongThanhTien=" + tongThanhTien + ", tienThua=" + tienThua + "]";
	}

}
