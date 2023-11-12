package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import dao.Dao_ChiTietHoaDonBan;
import dao.Dao_HoaDonBan;
import dao.Dao_KhachHang;
import dao.Dao_KhuyenMai;
import dao.Dao_NhaCungCap;
import dao.Dao_NhanVien;
import dao.Dao_SanPham;
import entity.ChiTietHoaDonBan;
import entity.HoaDonBan;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;
import entity.TaiKhoan;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class pnlHoadon extends JPanel implements ActionListener,DocumentListener,MouseListener {
	private static final double VAT = 0.01;
	private int stt;
	private float tongThanhTien = 0;
	private float thanhTien = 0;
	DefaultTableModel model;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private JTable table;
	private JTable table_N;
	private JTextField txtSDTKhachHang;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtMaHD;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNV;
	private JTextField txtTongTien;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThua;
	private JTextField txtMaSP_N;
	private JTextField txtTenSP_N;
	private JTextField txtGiaNhap;
	private JTextField txtSoLuong_N;
	private JTextField txtSDTNCC;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChiNCC;
	private JTextField txtMaHD_N;
	private JTextField txtMaNV_N;
	private JTextField txtTenNV_N;
	private JTextField txtTongTien_N;
	private JDateChooser dcrNgayLap;


	private NhaCungCap ncc;
	private KhuyenMai khuyenMai;
	private KhachHang khachHang;
	private SanPham sanPham;
	private HoaDonBan hoaDonBan;
	private NhanVien nhanVien;

	private Dao_NhaCungCap dao_NCC;
	private Dao_KhuyenMai dao_KhuyenMai;
	private Dao_SanPham dao_SanPham;
	private Dao_KhachHang dao_KhachHang;
	private Dao_HoaDonBan dao_HoaDonBan;
	private Dao_NhanVien dao_NhanVien;
	private Dao_ChiTietHoaDonBan dao_ChiTietHoaDonBan;

	private JButton btnXoaSP;
	private JButton btnThemSP;
	private JButton btnSuaSP;
	private JButton btnTimSP;
	private JButton btnTimKhachHang;
	private JButton btnThanhToan;
	private JButton btnTamIn;
	private JButton btnTaoMoi;
	private JButton btnInHoaDon;
	private JButton btnXoaSP_N;
	private JButton btnThemSP_N;
	private JButton btnSuaSP_N;
	private JButton btnTimSP_N;
	private JButton btnTimNCC;
	private JButton btnThanhToan_N;
	private JButton btnTaoMoi_N;

	//public static TaiKhoan taiKhoanLogin;

	/**
	 * Create the panel.
	 */
	public pnlHoadon() {
		setBackground(new Color(224, 255, 255));
		setForeground(Color.BLACK);
		setBounds(0,0, 1163, 763);
		setLayout(null);



		try {
			connectDB.ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ncc = new NhaCungCap();
		khuyenMai = new KhuyenMai();
		sanPham = new SanPham();
		khachHang =  new KhachHang();
		//hoaDonBan = new HoaDonBan();
		//nhanVien = new NhanVien();

		dao_NCC = new Dao_NhaCungCap();
		dao_KhuyenMai = new Dao_KhuyenMai();
		dao_SanPham = new Dao_SanPham();
		dao_KhachHang = new Dao_KhachHang();
		dao_HoaDonBan = new Dao_HoaDonBan();
		dao_NhanVien = new Dao_NhanVien();
		dao_ChiTietHoaDonBan = new Dao_ChiTietHoaDonBan();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1163, 763);
		add(tabbedPane);

		JPanel pnlHDBan = new JPanel();
		tabbedPane.addTab("Hóa đơn bán", null, pnlHDBan, null);
		pnlHDBan.setLayout(null);

		JLabel lblMaSP = new JLabel("Mã sản phẩm");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaSP.setBounds(10, 20, 100, 20);
		pnlHDBan.add(lblMaSP);

		txtMaSP = new JTextField();
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaSP.setBounds(120, 20, 170, 20);
		pnlHDBan.add(txtMaSP);
		txtMaSP.setColumns(10);

		JLabel lblTenSP = new JLabel("Tên sản phẩm");
		lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenSP.setBounds(390, 20, 100, 20);
		pnlHDBan.add(lblTenSP);

		txtTenSP = new JTextField();
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenSP.setEnabled(false);
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(510, 20, 250, 20);
		pnlHDBan.add(txtTenSP);

		JLabel lblGiaBan = new JLabel("Giá");
		lblGiaBan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGiaBan.setBounds(10, 45, 100, 20);
		pnlHDBan.add(lblGiaBan);

		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGiaBan.setEnabled(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(120, 45, 250, 20);
		pnlHDBan.add(txtGiaBan);

		JPanel pnlBorderSP = new JPanel();
		pnlBorderSP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin sản phẩm", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		pnlBorderSP.setBounds(0, 0, 770, 130);
		pnlHDBan.add(pnlBorderSP);
		pnlBorderSP.setLayout(null);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(510, 45, 250, 20);
		pnlBorderSP.add(txtSoLuong);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSoLuong.setColumns(10);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(390, 45, 100, 20);
		pnlBorderSP.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnXoaSP = new JButton("Xóa sản phẩm");
		btnXoaSP.setBounds(560, 70, 200, 50);
		pnlBorderSP.add(btnXoaSP);
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setBounds(80, 70, 200, 50);
		pnlBorderSP.add(btnThemSP);
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnSuaSP = new JButton("Sửa sản phẩm");
		btnSuaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSuaSP.setBounds(320, 70, 200, 50);
		pnlBorderSP.add(btnSuaSP);

		btnTimSP = new JButton("Tìm");
		btnTimSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimSP.setBounds(290, 20, 80, 20);
		pnlBorderSP.add(btnTimSP);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 160, 750, 400);
		pnlHDBan.add(scrollPane);

		String[] tb = new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng","Giá bán", "%VAT",
		"Thành tiền" };
		model = new DefaultTableModel(tb, 0);
		table = new JTable(model);

		//table = new JTable();
		scrollPane.setViewportView(table);



		JPanel pnlGioHang = new JPanel();
		pnlGioHang.setBorder(new TitledBorder(null, "Thông tin giỏ hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGioHang.setBounds(0, 140, 770, 440);
		pnlHDBan.add(pnlGioHang);
		pnlGioHang.setLayout(null);

		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlKhachHang.setBounds(770, 0, 380, 150);
		pnlHDBan.add(pnlKhachHang);
		pnlKhachHang.setLayout(null);

		JLabel lblSDTKhachHang = new JLabel("Số điện thoại");
		lblSDTKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDTKhachHang.setBounds(10, 20, 100, 20);
		pnlKhachHang.add(lblSDTKhachHang);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSDTKhachHang.setColumns(10);
		txtSDTKhachHang.setBounds(120, 20, 170, 20);
		pnlKhachHang.add(txtSDTKhachHang);

		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKH.setBounds(10, 50, 100, 20);
		pnlKhachHang.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(120, 50, 250, 20);
		pnlKhachHang.add(txtMaKH);

		txtTenKH = new JTextField();
		txtTenKH.setEnabled(false);
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(120, 80, 250, 20);
		pnlKhachHang.add(txtTenKH);

		txtDiaChi = new JTextField();
		txtDiaChi.setEnabled(false);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(120, 110, 250, 20);
		pnlKhachHang.add(txtDiaChi);

		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKH.setBounds(10, 80, 100, 20);
		pnlKhachHang.add(lblTenKH);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(10, 110, 100, 20);
		pnlKhachHang.add(lblDiaChi);

		btnTimKhachHang = new JButton("Tìm");
		btnTimKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKhachHang.setBounds(290, 20, 80, 20);
		pnlKhachHang.add(btnTimKhachHang);

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setLayout(null);
		pnlHoaDon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlHoaDon.setBounds(770, 170, 380, 150);
		pnlHDBan.add(pnlHoaDon);

		JLabel lblMaHD = new JLabel("Mã hóa đơn");
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD.setBounds(10, 20, 100, 20);
		pnlHoaDon.add(lblMaHD);

		txtMaHD = new JTextField();
		txtMaHD.setEnabled(false);
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(120, 20, 250, 20);
		pnlHoaDon.add(txtMaHD);

		JLabel lblNgayLapHD = new JLabel("Ngày lập hóa đơn");
		lblNgayLapHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHD.setBounds(10, 50, 112, 20);
		pnlHoaDon.add(lblNgayLapHD);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(120, 80, 250, 20);
		pnlHoaDon.add(txtMaNhanVien);

		txtTenNV = new JTextField();
		txtTenNV.setEnabled(false);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(120, 110, 250, 20);
		pnlHoaDon.add(txtTenNV);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(10, 80, 100, 20);
		pnlHoaDon.add(lblMaNV);

		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setBounds(10, 110, 100, 20);
		pnlHoaDon.add(lblTenNV);

		dcrNgayLap = new JDateChooser();
		dcrNgayLap.setBounds(120, 50, 250, 20);

		dcrNgayLap.setLocale(new Locale("vi", "VN"));
		dcrNgayLap.setDateFormatString("dd/MM/yyyy");
		dcrNgayLap.setDate(new Date(System.currentTimeMillis()));
		dcrNgayLap.setEnabled(false); // chi duoc doc

		pnlHoaDon.add(dcrNgayLap);

		JPanel pnlThanhToan = new JPanel();
		pnlThanhToan.setLayout(null);
		pnlThanhToan.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin thanh toán", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlThanhToan.setBounds(0, 590, 770, 136);
		pnlHDBan.add(pnlThanhToan);

		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongTien.setBounds(10, 30, 130, 30);
		pnlThanhToan.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongTien.setEnabled(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(130, 30, 250, 30);
		pnlThanhToan.add(txtTongTien);

		JLabel lblTienKhachDua = new JLabel("Tiền khách đưa");
		lblTienKhachDua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTienKhachDua.setBounds(10, 80, 130, 30);
		pnlThanhToan.add(lblTienKhachDua);

		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(130, 80, 250, 30);
		pnlThanhToan.add(txtTienKhachDua);

		JLabel lblTienThua = new JLabel("Tiền thừa");
		lblTienThua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTienThua.setBounds(400, 30, 110, 30);
		pnlThanhToan.add(lblTienThua);

		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTienThua.setEnabled(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(510, 28, 250, 30);
		pnlThanhToan.add(txtTienThua);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThanhToan.setBounds(810, 600, 310, 110);
		pnlHDBan.add(btnThanhToan);

		btnTamIn = new JButton("Tạm in");
		btnTamIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTamIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTamIn.setBounds(810, 430, 310, 70);
		pnlHDBan.add(btnTamIn);

		btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTaoMoi.setBounds(810, 345, 310, 70);
		pnlHDBan.add(btnTaoMoi);

		btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInHoaDon.setBounds(810, 515, 310, 70);
		pnlHDBan.add(btnInHoaDon);

		JPanel pnlHDNhap = new JPanel();
		pnlHDNhap.setLayout(null);
		tabbedPane.addTab("Hóa đơn nhập", null, pnlHDNhap, null);

		JLabel lblMaSP_N = new JLabel("Mã sản phẩm");
		lblMaSP_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaSP_N.setBounds(10, 20, 100, 20);
		pnlHDNhap.add(lblMaSP_N);

		txtMaSP_N = new JTextField();
		txtMaSP_N.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaSP_N.setColumns(10);
		txtMaSP_N.setBounds(120, 20, 170, 20);
		pnlHDNhap.add(txtMaSP_N);

		JLabel lblTenSP_N = new JLabel("Tên sản phẩm");
		lblTenSP_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenSP_N.setBounds(390, 20, 100, 20);
		pnlHDNhap.add(lblTenSP_N);

		txtTenSP_N = new JTextField();
		txtTenSP_N.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenSP_N.setEnabled(false);
		txtTenSP_N.setColumns(10);
		txtTenSP_N.setBounds(510, 20, 250, 20);
		pnlHDNhap.add(txtTenSP_N);

		JLabel lblGiaNhap = new JLabel("Giá");
		lblGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGiaNhap.setBounds(10, 45, 100, 20);
		pnlHDNhap.add(lblGiaNhap);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGiaNhap.setEnabled(false);
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(120, 45, 250, 20);
		pnlHDNhap.add(txtGiaNhap);

		JPanel pnlBorderSP_N = new JPanel();
		pnlBorderSP_N.setLayout(null);
		pnlBorderSP_N.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin sản phẩm nhập", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		pnlBorderSP_N.setBounds(0, 0, 770, 130);
		pnlHDNhap.add(pnlBorderSP_N);

		txtSoLuong_N = new JTextField();
		txtSoLuong_N.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSoLuong_N.setColumns(10);
		txtSoLuong_N.setBounds(510, 45, 250, 20);
		pnlBorderSP_N.add(txtSoLuong_N);

		JLabel lblSoLuong_N = new JLabel("Số lượng");
		lblSoLuong_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuong_N.setBounds(390, 45, 100, 20);
		pnlBorderSP_N.add(lblSoLuong_N);

		btnXoaSP_N = new JButton("Xóa sản phẩm");
		btnXoaSP_N.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaSP_N.setBounds(560, 70, 200, 50);
		pnlBorderSP_N.add(btnXoaSP_N);

		btnThemSP_N = new JButton("Thêm sản phẩm");
		btnThemSP_N.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemSP_N.setBounds(80, 70, 200, 50);
		pnlBorderSP_N.add(btnThemSP_N);

		btnSuaSP_N = new JButton("Sửa sản phẩm");
		btnSuaSP_N.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSuaSP_N.setBounds(320, 70, 200, 50);
		pnlBorderSP_N.add(btnSuaSP_N);

		btnTimSP_N = new JButton("Tìm");
		btnTimSP_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimSP_N.setBounds(290, 20, 80, 20);
		pnlBorderSP_N.add(btnTimSP_N);

		JScrollPane scrollPane_N = new JScrollPane();
		scrollPane_N.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setBounds(10, 160, 1138, 400);
		pnlHDNhap.add(scrollPane_N);


		String[] tb_N = new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Nhà cung cấp", "Đơn giá nhập", "Số lượng",
		"Thành tiền" };
		DefaultTableModel model_N = new DefaultTableModel(tb_N, 0);
		table_N = new JTable(model_N);

		//table = new JTable();
		scrollPane_N.setViewportView(table_N);

		JPanel pnlGioHang_N = new JPanel();
		pnlGioHang_N.setLayout(null);
		pnlGioHang_N.setBorder(new TitledBorder(null, "Thông tin giỏ hàng nhập", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGioHang_N.setBounds(0, 140, 1158, 440);
		pnlHDNhap.add(pnlGioHang_N);

		JPanel pnlNCC = new JPanel();
		pnlNCC.setLayout(null);
		pnlNCC.setBorder(new TitledBorder(null, "Thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlNCC.setBounds(770, 0, 388, 140);
		pnlHDNhap.add(pnlNCC);

		JLabel lblSDTNCC = new JLabel("Số điện thoại");
		lblSDTNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDTNCC.setBounds(10, 20, 100, 20);
		pnlNCC.add(lblSDTNCC);

		txtSDTNCC = new JTextField();
		txtSDTNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSDTNCC.setColumns(10);
		txtSDTNCC.setBounds(120, 20, 170, 20);
		pnlNCC.add(txtSDTNCC);

		JLabel lblMaNCC = new JLabel("Mã nhà cung cấp");
		lblMaNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNCC.setBounds(10, 50, 112, 20);
		pnlNCC.add(lblMaNCC);

		txtMaNCC = new JTextField();
		txtMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaNCC.setEnabled(false);
		txtMaNCC.setColumns(10);
		txtMaNCC.setBounds(120, 50, 250, 20);
		pnlNCC.add(txtMaNCC);

		txtTenNCC = new JTextField();
		txtTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenNCC.setEnabled(false);
		txtTenNCC.setColumns(10);
		txtTenNCC.setBounds(120, 80, 250, 20);
		pnlNCC.add(txtTenNCC);

		txtDiaChiNCC = new JTextField();
		txtDiaChiNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChiNCC.setEnabled(false);
		txtDiaChiNCC.setColumns(10);
		txtDiaChiNCC.setBounds(120, 110, 250, 20);
		pnlNCC.add(txtDiaChiNCC);

		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp");
		lblTenNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNCC.setBounds(10, 80, 112, 20);
		pnlNCC.add(lblTenNCC);

		JLabel lblDiaChiNCC = new JLabel("Địa chỉ");
		lblDiaChiNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChiNCC.setBounds(10, 110, 100, 20);
		pnlNCC.add(lblDiaChiNCC);

		btnTimNCC = new JButton("Tìm");
		btnTimNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimNCC.setBounds(290, 20, 80, 20);
		pnlNCC.add(btnTimNCC);

		JPanel pnlHoaDon_N = new JPanel();
		pnlHoaDon_N.setLayout(null);
		pnlHoaDon_N.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin hóa đơn nhập", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlHoaDon_N.setBounds(0, 590, 380, 140);
		pnlHDNhap.add(pnlHoaDon_N);

		JLabel lblMaHD_N = new JLabel("Mã hóa đơn");
		lblMaHD_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD_N.setBounds(10, 20, 100, 20);
		pnlHoaDon_N.add(lblMaHD_N);

		txtMaHD_N = new JTextField();
		txtMaHD_N.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaHD_N.setEnabled(false);
		txtMaHD_N.setColumns(10);
		txtMaHD_N.setBounds(120, 20, 250, 20);
		pnlHoaDon_N.add(txtMaHD_N);

		JLabel lblNgayLapHD_N = new JLabel("Ngày lập hóa đơn");
		lblNgayLapHD_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHD_N.setBounds(10, 50, 112, 20);
		pnlHoaDon_N.add(lblNgayLapHD_N);

		txtMaNV_N = new JTextField();
		txtMaNV_N.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaNV_N.setEnabled(false);
		txtMaNV_N.setColumns(10);
		txtMaNV_N.setBounds(120, 80, 250, 20);
		pnlHoaDon_N.add(txtMaNV_N);

		txtTenNV_N = new JTextField();
		txtTenNV_N.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenNV_N.setEnabled(false);
		txtTenNV_N.setColumns(10);
		txtTenNV_N.setBounds(120, 110, 250, 20);
		pnlHoaDon_N.add(txtTenNV_N);

		JLabel lblMaNV_N = new JLabel("Mã nhân viên");
		lblMaNV_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV_N.setBounds(10, 80, 100, 20);
		pnlHoaDon_N.add(lblMaNV_N);

		JLabel lblTenNV_N = new JLabel("Tên nhân viên");
		lblTenNV_N.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV_N.setBounds(10, 110, 100, 20);
		pnlHoaDon_N.add(lblTenNV_N);

		JDateChooser dcrNgayLap_N = new JDateChooser();
		dcrNgayLap_N.setLocale(new Locale("vi", "VN"));
		dcrNgayLap_N.setEnabled(false);
		dcrNgayLap_N.setDateFormatString("dd/MM/yyyy");
		dcrNgayLap_N.setDate(new Date(System.currentTimeMillis()));
		dcrNgayLap_N.setBounds(120, 50, 250, 20);
		pnlHoaDon_N.add(dcrNgayLap_N);

		pnlHoaDon.add(dcrNgayLap);

		JPanel pnlThanhToan_N = new JPanel();
		pnlThanhToan_N.setLayout(null);
		pnlThanhToan_N.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlThanhToan_N.setBounds(390, 590, 380, 136);
		pnlHDNhap.add(pnlThanhToan_N);

		JLabel lblTongTien_N = new JLabel("Tổng tiền");
		lblTongTien_N.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongTien_N.setBounds(10, 30, 130, 30);
		pnlThanhToan_N.add(lblTongTien_N);

		txtTongTien_N = new JTextField();
		txtTongTien_N.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongTien_N.setEnabled(false);
		txtTongTien_N.setColumns(10);
		txtTongTien_N.setBounds(130, 30, 240, 30);
		pnlThanhToan_N.add(txtTongTien_N);

		btnThanhToan_N = new JButton("Thanh toán");
		btnThanhToan_N.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThanhToan_N.setBounds(810, 590, 300, 60);
		pnlHDNhap.add(btnThanhToan_N);

		btnTaoMoi_N = new JButton("Tạo mới");
		btnTaoMoi_N.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTaoMoi_N.setBounds(810, 660, 300, 60);
		pnlHDNhap.add(btnTaoMoi_N);

		// add icon vao btn
		btnThemSP.setIcon(new ImageIcon("img/add_32.png"));
		btnSuaSP.setIcon(new ImageIcon("img/update2.png"));
		btnXoaSP.setIcon(new ImageIcon("img/delete.png"));
		btnThemSP_N.setIcon(new ImageIcon("img/add_32.png"));
		btnSuaSP_N.setIcon(new ImageIcon("img/update2.png"));
		btnXoaSP_N.setIcon(new ImageIcon("img/delete.png"));
		btnTaoMoi.setIcon(new ImageIcon("img/update.png"));
		btnTaoMoi_N.setIcon(new ImageIcon("img/update.png"));
		btnThanhToan.setIcon(new ImageIcon("img/thanhToan.png"));
		btnThanhToan_N.setIcon(new ImageIcon("img/thanhToan.png"));
		btnTimNCC.setIcon(new ImageIcon("img/find16.png"));
		btnTimSP.setIcon(new ImageIcon("img/find16.png"));
		btnTimSP_N.setIcon(new ImageIcon("img/find16.png"));
		btnTimKhachHang.setIcon(new ImageIcon("img/find16.png"));

		// add event
		btnXoaSP.addActionListener(this);
		btnInHoaDon.addActionListener(this);
		btnTamIn.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThanhToan_N.addActionListener(this);
		btnThemSP.addActionListener(this);
		btnThemSP_N.addActionListener(this);
		btnXoaSP.addActionListener(this);
		btnXoaSP_N.addActionListener(this);
		btnTaoMoi.addActionListener(this);
		btnTaoMoi_N.addActionListener(this);
		btnTimNCC.addActionListener(this);
		btnTimSP.addActionListener(this);
		btnTimSP_N.addActionListener(this);
		btnTimKhachHang.addActionListener(this);
		btnSuaSP.addActionListener(this);
		table.addMouseListener(this);

		//txtMaSP.getDocument().addDocumentListener(this);
		//txtMaSP_N.getDocument().addDocumentListener(this);
		//txtSDTKhachHang.getDocument().addDocumentListener(this);
		//txtSDTNCC.getDocument().addDocumentListener(this);
		//txtMaKM.getDocument().addDocumentListener(this);

		// lấy thông tin nhân viên

		NhanVien nvLogin = null;
		if (FrameDashBoard.taiKhoanLogin != null) {
		    nvLogin = FrameDashBoard.taiKhoanLogin.getNhanVien();
		}

		// Nếu nvLogin vẫn là null, kiểm tra FrameDashBoardNVBH
		if (nvLogin == null && FrameDashBoardNVBH.taiKhoanLogin != null) {
		    nvLogin = FrameDashBoardNVBH.taiKhoanLogin.getNhanVien();
		}

		if (nvLogin != null) {
		    NhanVien findNVLogin = dao_NhanVien.getTheoMaNV(nvLogin.getMaNhanVien());
		    txtMaNhanVien.setText(findNVLogin.getMaNhanVien());
		    txtTenNV.setText(findNVLogin.getHoTenNhanVien());
		} else {
		    JOptionPane.showMessageDialog(this, "Lỗi ngoại lệ.");
		}


	}

	public void phatsinhma() {
		int soHD = dao_HoaDonBan.getSoLuong();
		String maHD;
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String currentDateStr = dateFormat.format(currentDate);
		if (soHD == -1) {
			soHD = 0;
			maHD = String.format("HD%s%04d",currentDateStr,soHD + 1);
		} else {
			maHD = String.format("HD%s%04d",currentDateStr,soHD + 1);
		}
		txtMaHD.setText(maHD);
		// Lấy mã hóa đơn cuối cùng trong ngày

	}

	// tìm số điện thoại nhà cung cấp theo số điện thoại
	public void timTheoSDTNCC() {
		String sdt = txtSDTNCC.getText();
		if (sdt.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");	

		} 
		else {
			ArrayList<NhaCungCap> ds = dao_NCC.getNCCTheoSDT(sdt);
			if (ds.size()==0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy mã khuyến mãi");
			}
			else {
				for (NhaCungCap t : ds) {
					txtMaNCC.setText(t.getMaNhaCungCap());
					txtDiaChiNCC.setText(t.getDiaChi());
					txtTenNCC.setText(t.getTenNhaCungCap());
				}
			}

		}
	}

	//tìm kiếm khuyến mãi theo mã khuyến mãi
//	public void timKMTheoMaKM() {
//		String ma = txtMaKM.getText();
//		if (ma.isEmpty()) {
//			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khuyến mãi");	
//
//		} 
//		else {
//			ArrayList<KhuyenMai> ds = dao_KhuyenMai.getKhuyenMaiTheoMaMang(ma);
//			if (ds.size()==0) {
//				JOptionPane.showMessageDialog(this, "Không tìm thấy mã khuyến mãi");
//			}
//			else {
//				for (KhuyenMai t : ds) {
//					dcrNgayBDKM.setDate(t.getNgayBatDau());
//					dcrNgayKTKM.setDate(t.getNgayBatDau());
//					txtGiaTriGG.setText(String.valueOf(t.getGiaTriGiamGia()));
//				}
//			}
//		}
//
//	}

	public void timSPTheoMaSP() {
		String ma = txtMaSP.getText();
		if (ma.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm");	

		} 
		else {
			ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(ma);
			if (ds.size()==0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy mã khuyến mãi");
			}
			else {
				for (SanPham t : ds) {
					txtTenSP.setText(t.getTenSP());
					txtGiaBan.setText(String.valueOf(t.getGiaBan()));
				}
			}
		}		
	}

	public void timKHTheoSDT() {
		String sdt = txtSDTKhachHang.getText();
		if (sdt.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");	

		} 
		else {
			ArrayList<KhachHang> ds = dao_KhachHang.getKHTheoSDT(sdt);
			if (ds.size()==0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy mã khuyến mãi");
			}
			else {
				for (KhachHang t : ds) {
					txtTenKH.setText(t.getTenKhachHang());
					txtMaKH.setText(t.getMaKhachhang());
					txtDiaChi.setText(t.getDiaChi());
				}
			}

		}
	}
	
	//Kiểm tra tiền khách đưa: tiền nhập vào là số thực và lớn hơn 0
	public boolean validDataTKD() {
		String tienKD = txtTienKhachDua.getText().trim();
		if(tienKD.length() > 0) {
			try {
				float x = Float.parseFloat(tienKD);
				float y = Float.parseFloat(txtTongTien.getText().trim());
				if(x < y) {
					JOptionPane.showMessageDialog(this,"Tiền khách đưa không đủ");
					return false;
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,"Tiền khách đưa nhập vào phải là kiểu số");
			}
		} else {
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số tiền khách đưa");
			return false;
		}
		return true;
	}
	// kiểm tra số lượng sản phẩm muốn bán
	public boolean validDataSLSP() {
		String soLuong = txtSoLuong.getText().trim();
		if(soLuong.length() > 0) {
			try {
				int soL = Integer.parseInt(soLuong);
				String maSP = txtMaSP.getText();
				int soLuongTon = 0;
				ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(maSP);
				for (SanPham sanPham : ds) {
					soLuongTon = sanPham.getSoLuong();
				}
				if(soL > soLuongTon) {
					JOptionPane.showMessageDialog(this,"Sản phẩm hiện chỉ còn: "+soLuongTon);
					return false;
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,"Số lượng nhập vào phải là kiểu số");
			}
		} else {
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số lượng sản phẩm");
			return false;
		}
		return true;
	}

	//	private HoaDonBan createHDB() {
	//		int soHD = dao_HoaDonBan.getSoLuong();
	//		String maHD;
	//		if (soHD == -1) {
	//			soHD = 0;
	//			maHD = String.format("HD%03d", soHD + 1);
	//		} else {
	//			maHD = String.format("HD%03d", soHD + 1);
	//		}
	//		txtMaHD.setText(maHD);
	//	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
//		if(o.equals(btnTimKhuyenMai)) {
//			timKMTheoMaKM();
//		}
		if(o.equals(btnTimNCC)) {
			timTheoSDTNCC();
			
		}
		else if(o.equals(btnTimSP)) {
			timSPTheoMaSP();
		}
		else if(o.equals(btnTimKhachHang)) {
			timKHTheoSDT();
		}
		else if(o.equals(btnThanhToan)) {
			phatsinhma();
			if(validDataTKD()) {
				String trangThai = "Đã thanh toán";
				int soLuongTon = 0;
				int soLuongConLai = 0; //sau khi thanh toán
				float tienKD = Float.parseFloat(txtTienKhachDua.getText());
				float tienTL = tienKD - tongThanhTien;
				txtTienThua.setText(tienTL + "");
				
				Date dateNgayLapHD = dcrNgayLap.getDate();
				java.sql.Date sqlNgayLapHD = new java.sql.Date(dateNgayLapHD.getTime());
				
				String maHD = txtMaHD.getText();
				String maNV = txtMaNhanVien.getText();
				NhanVien nv = new NhanVien(maNV);
				String maKH = txtMaKH.getText();
				KhachHang kh = new KhachHang(maKH);
				float vat = (float) (VAT);
				HoaDonBan hd = new HoaDonBan(maHD, nv, kh, sqlNgayLapHD, trangThai, vat, tienKD, tongThanhTien, tienTL);
				try {
					if(!dao_HoaDonBan.createHoaDon(hd)) {
						JOptionPane.showMessageDialog(this,"Trùng mã - Kiểm trả lại");
					}else {
						int flag = 0;
						for(int i = 0; i < model.getRowCount();i++) {
							String maSP = model.getValueAt(i, 1).toString();
							//String soLB = model.getValueAt(i, 3).toString();
							//String thanhTien = model.getValueAt(i, 6).toString();
							int soL = Integer.parseInt(model.getValueAt(i, 3).toString());
							float TT = Float.parseFloat(model.getValueAt(i, 6).toString());
							SanPham sp = new SanPham(maSP);
							ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(maSP);
							for (SanPham sanPham : ds) {
								soLuongTon = sanPham.getSoLuong();
							}
							ChiTietHoaDonBan cthd = new ChiTietHoaDonBan(hd, sp, soL, TT);
							if(!dao_ChiTietHoaDonBan.createCTHoaDon(cthd)) {
								JOptionPane.showMessageDialog(this,"Lỗi lưu chi tiết hóa đơn");
							}
							else {
								
							}
							soLuongConLai = soLuongTon - soL;
							if(!dao_SanPham.update(maSP,soLuongConLai)) {
								JOptionPane.showMessageDialog(this,"Cập nhật số lượng thất bại");
							}
							else {
							}
							flag = 1;
							
						}
						if(flag == 1) {
							JOptionPane.showMessageDialog(this,"Thanh toán thành công");
						}else {
							JOptionPane.showMessageDialog(this,"Thanh toán thất bại");
						}
							
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else if(o.equals(btnThemSP)) {
			stt = model.getRowCount();
			if(txtMaSP.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,"Vui lòng nhập mã sản phẩm");
			}
			else {
				String ma = txtMaSP.getText();
				String soLuong = txtSoLuong.getText();
				int soL = Integer.parseInt(soLuong);
				ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(ma );
				for (SanPham sp : ds) {
					thanhTien = (float) (sp.getGiaBan()*soL + sp.getGiaBan()*soL*VAT);
					tongThanhTien += thanhTien;
					model.addRow(new Object[] {++stt,ma,sp.getTenSP(),soL,sp.getGiaBan(),VAT,thanhTien + ""});
					txtTongTien.setText(tongThanhTien + "");
				}
			}

		}
		else if(o.equals(btnTaoMoi)) {
			txtMaSP.setText("");
			txtTenSP.setText("");
			txtGiaBan.setText("");
			txtSoLuong.setText("");
			txtSDTKhachHang.setText("");
			txtMaKH.setText("");
			txtTenKH.setText("");
			txtDiaChi.setText("");
			txtMaHD.setText("");
			while (model.getRowCount() != 0) {
				model.removeRow(0);
			}
		}
		else if(o.equals(btnXoaSP)) {
			int row = table.getSelectedRow();
			String ma = model.getValueAt(row,1).toString();
			if(row < 0) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm muốn xóa");
			}
			else if(JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa sản phẩm có mã: " + ma, "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String thanhTienXoa = model.getValueAt(row,6).toString();
				float ttx = Float.parseFloat(thanhTienXoa);
				float tonngTienXoa = Float.parseFloat(txtTongTien.getText());
				float TTSX = tonngTienXoa-ttx;
				txtTongTien.setText(TTSX + "");
				model.removeRow(row);
				for (int i = row; i < model.getRowCount(); i++) {
					model.setValueAt(i + 1, i, 0); // Cập nhật số thứ tự (STT)
				}
			}
		}
		else if(o.equals(btnSuaSP)) {
			int rowu = table.getSelectedRow();
			String ma = model.getValueAt(rowu,1).toString();
			
			if(rowu < 0) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm muốn xóa");
				return;
			}
			else {
				String thanhTienXoa = model.getValueAt(rowu,6).toString();
				float ttx = Float.parseFloat(thanhTienXoa);
				float tonngTienXoa = Float.parseFloat(txtTongTien.getText());
				float TTSX = tonngTienXoa-ttx;
				model.removeRow(rowu);
				stt = model.getRowCount();
				String soLuong = txtSoLuong.getText();
				int soL = Integer.parseInt(soLuong);
				ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(ma );
				for (SanPham sp : ds) {
					thanhTien = (float) (sp.getGiaBan()*soL + sp.getGiaBan()*soL*VAT);
					tongThanhTien = TTSX +thanhTien; 
					model.addRow(new Object[] {++stt,ma,sp.getTenSP(),soL,sp.getGiaBan(),VAT,thanhTien + ""});
					txtTongTien.setText(tongThanhTien + "");
				}
			}

		}
		else if(o.equals(btnTamIn)) {
			phatsinhma();
			if(validDataTKD()) {
				String trangThai = "Tạm in";
				int soLuongTon = 0;
				int soLuongConLai = 0; //sau khi thanh toán
				float tienKD = Float.parseFloat(txtTienKhachDua.getText());
				float tienTL = tienKD - tongThanhTien;
				txtTienThua.setText(tienTL + "");
				
				Date dateNgayLapHD = dcrNgayLap.getDate();
				java.sql.Date sqlNgayLapHD = new java.sql.Date(dateNgayLapHD.getTime());
				
				String maHD = txtMaHD.getText();
				String maNV = txtMaNhanVien.getText();
				NhanVien nv = new NhanVien(maNV);
				String maKH = txtMaKH.getText();
				KhachHang kh = new KhachHang(maKH);
				float vat = (float) (VAT);
				HoaDonBan hd = new HoaDonBan(maHD, nv, kh, sqlNgayLapHD, trangThai, vat, tienKD, tongThanhTien, tienTL);
				try {
					if(!dao_HoaDonBan.createHoaDon(hd)) {
						JOptionPane.showMessageDialog(this,"Trùng mã - Kiểm trả lại");
					}else {
						int flag = 0;
						for(int i = 0; i < model.getRowCount();i++) {
							String maSP = model.getValueAt(i, 1).toString();
							//String soLB = model.getValueAt(i, 3).toString();
							//String thanhTien = model.getValueAt(i, 6).toString();
							int soL = Integer.parseInt(model.getValueAt(i, 3).toString());
							float TT = Float.parseFloat(model.getValueAt(i, 6).toString());
							SanPham sp = new SanPham(maSP);
							ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(maSP);
							for (SanPham sanPham : ds) {
								soLuongTon = sanPham.getSoLuong();
							}
							ChiTietHoaDonBan cthd = new ChiTietHoaDonBan(hd, sp, soL, TT);
							if(!dao_ChiTietHoaDonBan.createCTHoaDon(cthd)) {
								JOptionPane.showMessageDialog(this,"Lỗi tạm in chi tiết hóa đơn");
							}
							else {
								
							}
							soLuongConLai = soLuongTon - soL;
							if(!dao_SanPham.update(maSP,soLuongConLai)) {
								JOptionPane.showMessageDialog(this,"Cập nhật số lượng thất bại");
							}
							else {
							}
							flag = 1;
							
						}
						if(flag == 1) {
							JOptionPane.showMessageDialog(this,"In tạm thành công");
						}else {
							JOptionPane.showMessageDialog(this,"In tạm thất bại");
						}
							
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		//timTheoSDTNCC();
		//timKMTheoMaKM();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		//timTheoSDTNCC();
		//timKMTheoMaKM();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		//timTheoSDTNCC();
		//timKMTheoMaKM();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaSP.setText(model.getValueAt(row,1).toString());
		txtTenSP.setText(model.getValueAt(row,2).toString());
		txtSoLuong.setText(model.getValueAt(row,3).toString());
		txtGiaBan.setText(model.getValueAt(row,4).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
