package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
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
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.sql.Timestamp;
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

import org.apache.poi.hssf.record.PageBreakRecord.Break;

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
	//	private static final double VAT = 0.01;
	private int stt;
	private float km=0;
	private float tongThanhTien = 0;
	private float thanhTien = 0;
	DefaultTableModel model;
	DefaultTableModel modelHD;
	DefaultTableModel modelCTHD;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private JTable table;
	private JTable tableHD;
	private JTable tableCTHD;
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
	private JTextField txtMaHD_T;
	private JTextField txtTimSDTKH;
	private JTextField txtTimTenKH;
	private JDateChooser dcrNgayLap;
	private JDateChooser dcrNgayLap_T;


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
	private JButton btnTimTheoMaHD;
	private JButton btnTaoMoi_N;
	private JTextField txtKhuyenMai;
	private JLabel lblNgayLap;
	private JButton btnTimTheoNgay;
	private JButton btnXuLyTI;
	private JButton btnInHD_DS;
	private JButton btnHuyHD;
	private JPanel pnlCTHD;
	private JButton btnTimTheoSDTKH;
	private JButton btnTimTenKH;
	private JTabbedPane tabbedPane;

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

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1163, 763);
		add(tabbedPane);

		JPanel pnlHDBan = new JPanel();
		tabbedPane.addTab("Hóa đơn bán", null, pnlHDBan, null);
		pnlHDBan.setLayout(null);

		JLabel lblMaSP = new JLabel("Mã sản phẩm");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaSP.setBounds(10, 20, 100, 25);
		pnlHDBan.add(lblMaSP);

		txtMaSP = new JTextField();
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSP.setBounds(120, 20, 170, 25);
		pnlHDBan.add(txtMaSP);
		txtMaSP.setColumns(10);

		JLabel lblTenSP = new JLabel("Tên sản phẩm");
		lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenSP.setBounds(390, 20, 100, 25);
		pnlHDBan.add(lblTenSP);

		txtTenSP = new JTextField();
		txtTenSP.setEditable(false);
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(510, 20, 250, 25);
		pnlHDBan.add(txtTenSP);

		JPanel pnlBorderSP = new JPanel();
		pnlBorderSP.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin sản phẩm", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		pnlBorderSP.setBounds(0, 0, 770, 160);
		pnlHDBan.add(pnlBorderSP);
		pnlBorderSP.setLayout(null);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(510, 60, 250, 25);
		pnlBorderSP.add(txtSoLuong);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoLuong.setColumns(10);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(390, 60, 100, 25);
		pnlBorderSP.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnXoaSP = new JButton("Xóa sản phẩm");
		btnXoaSP.setBounds(560, 100, 200, 50);
		pnlBorderSP.add(btnXoaSP);
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setBounds(80, 100, 200, 50);
		pnlBorderSP.add(btnThemSP);
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnSuaSP = new JButton("Sửa sản phẩm");
		btnSuaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSuaSP.setBounds(320, 100, 200, 50);
		pnlBorderSP.add(btnSuaSP);

		btnTimSP = new JButton("Tìm");
		btnTimSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimSP.setBounds(290, 20, 80, 25);
		pnlBorderSP.add(btnTimSP);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 190, 750, 370);
		pnlHDBan.add(scrollPane);

		String[] tb = new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng","Giá bán",
		"Thành tiền" };
		model = new DefaultTableModel(tb, 0);
		table = new JTable(model);

		//table = new JTable();
		scrollPane.setViewportView(table);



		JPanel pnlGioHang = new JPanel();
		pnlGioHang.setBorder(new TitledBorder(null, "Thông tin giỏ hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGioHang.setBounds(0, 170, 770, 410);
		pnlHDBan.add(pnlGioHang);
		pnlGioHang.setLayout(null);

		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlKhachHang.setBounds(770, 0, 380, 170);
		pnlHDBan.add(pnlKhachHang);
		pnlKhachHang.setLayout(null);

		JLabel lblSDTKhachHang = new JLabel("Số điện thoại");
		lblSDTKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDTKhachHang.setBounds(10, 20, 100, 25);
		pnlKhachHang.add(lblSDTKhachHang);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSDTKhachHang.setColumns(10);
		txtSDTKhachHang.setBounds(120, 20, 170, 25);
		pnlKhachHang.add(txtSDTKhachHang);

		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKH.setBounds(10, 55, 100, 25);
		pnlKhachHang.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(120, 55, 250, 25);
		pnlKhachHang.add(txtMaKH);

		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(120, 90, 250, 25);
		pnlKhachHang.add(txtTenKH);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(120, 125, 250, 25);
		pnlKhachHang.add(txtDiaChi);

		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKH.setBounds(10, 90, 100, 25);
		pnlKhachHang.add(lblTenKH);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(10, 125, 100, 25);
		pnlKhachHang.add(lblDiaChi);

		btnTimKhachHang = new JButton("Tìm");
		btnTimKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKhachHang.setBounds(290, 20, 80, 25);
		pnlKhachHang.add(btnTimKhachHang);

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setLayout(null);
		pnlHoaDon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlHoaDon.setBounds(770, 190, 380, 170);
		pnlHDBan.add(pnlHoaDon);

		JLabel lblMaHD = new JLabel("Mã hóa đơn");
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD.setBounds(10, 20, 100, 25);
		pnlHoaDon.add(lblMaHD);

		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(120, 20, 250, 25);
		pnlHoaDon.add(txtMaHD);

		JLabel lblNgayLapHD = new JLabel("Ngày lập hóa đơn");
		lblNgayLapHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHD.setBounds(10, 55, 112, 25);
		pnlHoaDon.add(lblNgayLapHD);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(120, 90, 250, 25);
		pnlHoaDon.add(txtMaNhanVien);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(120, 124, 250, 25);
		pnlHoaDon.add(txtTenNV);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(10, 90, 100, 25);
		pnlHoaDon.add(lblMaNV);

		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setBounds(10, 125, 100, 25);
		pnlHoaDon.add(lblTenNV);

		dcrNgayLap = new JDateChooser();
		dcrNgayLap.setBounds(120, 55, 250, 25);

		dcrNgayLap.setLocale(new Locale("vi", "VN"));
		dcrNgayLap.setDateFormatString("dd/MM/yyyy");
		dcrNgayLap.setDate(new Date(System.currentTimeMillis()));
		dcrNgayLap.setEnabled(false);

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
		txtTongTien.setEditable(false);
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		txtTienThua.setEditable(false);
		txtTienThua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(510, 28, 250, 30);
		pnlThanhToan.add(txtTienThua);

		JLabel lblKhuyenMai = new JLabel("Khuyến mãi");
		lblKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKhuyenMai.setBounds(400, 80, 110, 30);
		pnlThanhToan.add(lblKhuyenMai);

		txtKhuyenMai = new JTextField();
		txtKhuyenMai.setEditable(false);
		txtKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKhuyenMai.setColumns(10);
		txtKhuyenMai.setBounds(510, 80, 250, 30);
		pnlThanhToan.add(txtKhuyenMai);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThanhToan.setBounds(810, 570, 310, 70);
		pnlHDBan.add(btnThanhToan);

		btnTamIn = new JButton("Lưu tạm hóa đơn");
		btnTamIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTamIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTamIn.setBounds(810, 480, 310, 70);
		pnlHDBan.add(btnTamIn);

		btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTaoMoi.setBounds(810, 390, 310, 70);
		pnlHDBan.add(btnTaoMoi);

		JPanel pnlDSHD = new JPanel();
		pnlDSHD.setLayout(null);
		tabbedPane.addTab("Danh sách hóa đơn", null, pnlDSHD, null);

		JLabel lblMaHD_T = new JLabel("Mã hóa đơn");
		lblMaHD_T.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD_T.setBounds(20, 20, 170, 20);
		pnlDSHD.add(lblMaHD_T);

		txtMaHD_T = new JTextField();
		txtMaHD_T.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaHD_T.setColumns(10);
		txtMaHD_T.setBounds(190, 20, 250, 20);
		pnlDSHD.add(txtMaHD_T);

		JLabel lblTimTheoSDTKH = new JLabel("Số điện thoại khách hàng");
		lblTimTheoSDTKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimTheoSDTKH.setBounds(20, 50, 170, 20);
		pnlDSHD.add(lblTimTheoSDTKH);

		JPanel pnlBorderDSHD = new JPanel();
		pnlBorderDSHD.setLayout(null);
		pnlBorderDSHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm hóa đơn", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		pnlBorderDSHD.setBounds(0, 0, 1158, 195);
		pnlDSHD.add(pnlBorderDSHD);

		txtTimTenKH = new JTextField();
		txtTimTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTimTenKH.setColumns(10);
		txtTimTenKH.setBounds(735, 50, 250, 20);
		pnlBorderDSHD.add(txtTimTenKH);

		JLabel lblTimSDTNV = new JLabel("Tên khách hàng");
		lblTimSDTNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimSDTNV.setBounds(570, 50, 127, 20);
		pnlBorderDSHD.add(lblTimSDTNV);

		btnTimTheoMaHD = new JButton("Tìm");
		btnTimTheoMaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimTheoMaHD.setBounds(450, 20, 100, 20);
		pnlBorderDSHD.add(btnTimTheoMaHD);

		JScrollPane scrollPane_DS = new JScrollPane();
		scrollPane_DS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_DS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_DS.setBounds(10, 225, 1138, 230);
		pnlDSHD.add(scrollPane_DS);


		String[] tb_N = new String[] { "STT", "Mã hóa đơn", "Tên khách hàng", "Tên nhân viên", "Thời gian lập hóa đơn", "Trạng thái",
		"Thành tiền" };
		modelHD = new DefaultTableModel(tb_N, 0);
		tableHD = new JTable(modelHD);

		//table = new JTable();
		scrollPane_DS.setViewportView(tableHD);

		JPanel pnlTTDSHD = new JPanel();
		pnlTTDSHD.setLayout(null);
		pnlTTDSHD.setBorder(new TitledBorder(null, "Thông tin danh sách hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTTDSHD.setBounds(0, 205, 1158, 260);
		pnlDSHD.add(pnlTTDSHD);

		//pnlHoaDon.add(dcrNgayLap);

		// add icon vao btn
		btnThemSP.setIcon(new ImageIcon("img/add_32.png"));
		btnSuaSP.setIcon(new ImageIcon("img/update2.png"));
		btnXoaSP.setIcon(new ImageIcon("img/delete.png"));
		btnTaoMoi.setIcon(new ImageIcon("img/update.png"));
		btnThanhToan.setIcon(new ImageIcon("img/thanhToan.png"));
		btnTimSP.setIcon(new ImageIcon("img/find16.png"));

		JLabel lblGiaBan = new JLabel("Giá");
		lblGiaBan.setBounds(10, 60, 100, 25);
		pnlBorderSP.add(lblGiaBan);
		lblGiaBan.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtGiaBan = new JTextField();
		txtGiaBan.setBounds(120, 60, 250, 25);
		pnlBorderSP.add(txtGiaBan);
		txtGiaBan.setEditable(false);
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaBan.setColumns(10);
		
		

		lblNgayLap = new JLabel("Tìm theo ngày");
		lblNgayLap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLap.setBounds(570, 20, 100, 20);
		pnlBorderDSHD.add(lblNgayLap);

		btnTimTheoNgay = new JButton("Tìm");
		btnTimTheoNgay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimTheoNgay.setBounds(990, 20, 100, 20);
		pnlBorderDSHD.add(btnTimTheoNgay);

		dcrNgayLap_T = new JDateChooser();
		dcrNgayLap_T.setBounds(735, 20, 250, 20);
		pnlBorderDSHD.add(dcrNgayLap_T);
		dcrNgayLap_T.setLocale(new Locale("vi", "VN"));
		dcrNgayLap_T.setDateFormatString("dd/MM/yyyy");
		//dcrNgayLap_T.setDate(new Date(System.currentTimeMillis()));

		txtTimSDTKH = new JTextField();
		txtTimSDTKH.setBounds(190, 50, 250, 20);
		pnlBorderDSHD.add(txtTimSDTKH);
		txtTimSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTimSDTKH.setColumns(10);

		btnTaoMoi_N = new JButton("Tạo mới");
		btnTaoMoi_N.setBounds(610, 100, 200, 60);
		pnlBorderDSHD.add(btnTaoMoi_N);
		btnTaoMoi_N.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTaoMoi_N.setIcon(new ImageIcon("img/update.png"));

		btnXuLyTI = new JButton("Xử lý hóa đơn tạm");
		btnXuLyTI.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnXuLyTI.setBounds(70, 100, 200, 60);
		pnlBorderDSHD.add(btnXuLyTI);

		btnInHD_DS = new JButton("In hóa đơn");
		btnInHD_DS.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInHD_DS.setBounds(340, 100, 200, 60);
		pnlBorderDSHD.add(btnInHD_DS);

		btnHuyHD = new JButton("Hủy hóa đơn");
		btnHuyHD.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHuyHD.setBounds(880, 100, 200, 60);
		pnlBorderDSHD.add(btnHuyHD);

		btnTimTheoSDTKH = new JButton("Tìm");
		btnTimTheoSDTKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimTheoSDTKH.setBounds(450, 51, 100, 20);
		pnlBorderDSHD.add(btnTimTheoSDTKH);

		btnTimTenKH = new JButton("Tìm");
		btnTimTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimTenKH.setBounds(990, 51, 100, 20);
		pnlBorderDSHD.add(btnTimTenKH);

		pnlCTHD = new JPanel();
		pnlCTHD.setLayout(null);
		pnlCTHD.setBorder(new TitledBorder(null, "Thông tin chi tiết hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlCTHD.setBounds(0, 470, 1158, 260);
		pnlDSHD.add(pnlCTHD);

		String[] tb_CT = new String[] { "STT", "Mã hóa đơn", "Mã sản phẩm","Tên sản phẩm","Số lượng", "%VAT",
		"Thành tiền" };
		modelCTHD = new DefaultTableModel(tb_CT, 0);
		tableCTHD = new JTable(modelCTHD);

		JScrollPane scrollPaneCTHD = new JScrollPane();
		scrollPaneCTHD.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCTHD.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneCTHD.setBounds(10, 20, 1138, 230);
		pnlCTHD.add(scrollPaneCTHD);

		scrollPaneCTHD.setViewportView(tableCTHD);

		btnTimKhachHang.setIcon(new ImageIcon("img/find16.png"));
		btnTimTheoMaHD.setIcon(new ImageIcon("img/find16.png"));
		//btnTimKhachHang.setIcon(new ImageIcon("img/find16.png"));
		btnTimTenKH.setIcon(new ImageIcon("img/find16.png"));
		btnTimTheoNgay.setIcon(new ImageIcon("img/find16.png"));
		btnTimTheoSDTKH.setIcon(new ImageIcon("img/find16.png"));
		btnTimTenKH.setIcon(new ImageIcon("img/find16.png"));
		btnTamIn.setIcon(new ImageIcon("img/cart48.png"));
		btnHuyHD.setIcon(new ImageIcon("img/delete.png"));
		btnInHD_DS.setIcon(new ImageIcon("img/in48.png"));

		

		// add event
		btnTaoMoi_N.addActionListener(this);
		btnXoaSP.addActionListener(this);
		btnTamIn.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemSP.addActionListener(this);
		btnTaoMoi.addActionListener(this);
		btnTimSP.addActionListener(this);
		btnTimTheoMaHD.addActionListener(this);
		btnTimKhachHang.addActionListener(this);
		btnSuaSP.addActionListener(this);
		btnXuLyTI.addActionListener(this);
		btnHuyHD.addActionListener(this);
		btnInHD_DS.addActionListener(this);
		btnTimTheoNgay.addActionListener(this);
		btnTimTheoSDTKH.addActionListener(this);
		btnTimTenKH.addActionListener(this);
		table.addMouseListener(this);
		tableHD.addMouseListener(this);

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

		//Lay du lieu hoa don cua nhan vien dang nhap vao
		
		
		NhanVien nvph = dao_NhanVien.getTheoMaNV(txtMaNhanVien.getText());
		
		if("Nhân viên bán hàng".equals(nvph.getChucVu())) {
			ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoNgayHT_PH(txtMaNhanVien.getText());
			napDuLieuHDTuCSDL(dsHD);
			
		}else {
			ArrayList<HoaDonBan> dsHD1 = dao_HoaDonBan.getHDTheoNgayHT_PH_NVQL();
			napDuLieuHDTuCSDL(dsHD1);
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

	public void napDuLieuHDTuCSDL(ArrayList<HoaDonBan> ds) {
		modelHD.setRowCount(0);
		int STT=0;
		for (HoaDonBan hd : ds) {
			KhachHang kh = dao_KhachHang.getTheoMaKH(hd.getMaKH().getMaKhachhang());
			NhanVien nv = dao_NhanVien.getTheoMaNV(hd.getMaNV().getMaNhanVien());
			modelHD.addRow(new Object[] {++STT,hd.getMaHDBan(),kh.getTenKhachHang(),nv.getHoTenNhanVien(),hd.getNgayGD(),hd.getTrangThai(),hd.getTongThanhTien()});
		}
	}


	// tìm số điện thoại nhà cung cấp theo số điện thoại
	//	public void timTheoSDTNCC() {
	//		String sdt = txtSDTNCC.getText();
	//		if (sdt.isEmpty()) {
	//			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");	
	//
	//		} 
	//		else {
	//			ArrayList<NhaCungCap> ds = dao_NCC.getNCCTheoSDT(sdt);
	//			if (ds.size()==0) {
	//				JOptionPane.showMessageDialog(this, "Không tìm thấy mã khuyến mãi");
	//			}
	//			else {
	//				for (NhaCungCap t : ds) {
	//					txtMaNCC.setText(t.getMaNhaCungCap());
	//					txtDiaChiNCC.setText(t.getDiaChi());
	//					txtTenNCC.setText(t.getTenNhaCungCap());
	//				}
	//			}
	//
	//		}
	//	}

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
				JOptionPane.showMessageDialog(this, "Không tìm thấy mã sản phẩm");
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
				JOptionPane.showMessageDialog(this, "Không tìm thấy số điện thoại khách hàng");
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
		String maKH = txtMaKH.getText().trim();
		if(model.getRowCount() ==0) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập sản phẩm khách hàng mua");
			return false;
		}
		if(txtSDTKhachHang.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại để tìm thông tin khách hàng");
			return false;
		}
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
	
	// kiemr tra lưu tạm
	public boolean validDataLT() {
		String maKH = txtMaKH.getText().trim();
		if(model.getRowCount() ==0) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập sản phẩm khách hàng mua");
			return false;
		}
		if(txtSDTKhachHang.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại để tìm thông tin khách hàng");
			return false;
		}
		
		return true;
	}
	// kiểm tra số lượng sản phẩm muốn bán
	public boolean validDataSLSP() {
		String soLuong = txtSoLuong.getText().trim();
		String ma = txtMaSP.getText().trim();
		//int soLC = Integer.parseInt(soLuong);
		ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(ma);
		if(ma.length() > 0) {
			if(ds.size() <= 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mã sản phẩm theo cấu trúc S0001 hoặc VPP0001");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm");
			return false;
		}
		if(soLuong.length() > 0 && Integer.parseInt(soLuong) >0) {
			try {
				int soL = Integer.parseInt(soLuong);

				int soLuongTon = 0;

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
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số lượng sản phẩm và số lượng sản phẩm là số nguyên dương");
			return false;
		}
		return true;
	}
	// kiểm tra khuyen mai
	public void kiemTraKM() {
		float tt = Float.parseFloat(txtTongTien.getText());
		ArrayList<KhuyenMai> ds = dao_KhuyenMai.getKhuyenMaiTheoTinhTrang("Đang diễn ra","Hóa đơn");
		float max = Float.MIN_VALUE;
		for (KhuyenMai khuyenMai : ds) {
			if(khuyenMai.getGiaTriGiamGia()>max) {
				max = khuyenMai.getGiaTriGiamGia();
			}
			km = (float) (max*0.01);
			if(tt >= 500000) {
				txtKhuyenMai.setText(km+"");
			}
			else {
				km=0;
				txtKhuyenMai.setText(km+"");
			}
		}


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
		if(o.equals(btnTimSP)) {
			timSPTheoMaSP();
		}
		else if(o.equals(btnTimKhachHang)) {
			timKHTheoSDT();
		}
		else if(o.equals(btnThanhToan)) {

			int r = tableHD.getSelectedRow();
			if(r<0) {
				if(validDataTKD()) {
					tongThanhTien =0;
					int rowCount = table.getRowCount();
					for (int row = 0; row < rowCount; row++) {
						tongThanhTien += Float.parseFloat(model.getValueAt(row,5).toString());
					}
					txtTongTien.setText(tongThanhTien+"");
					phatsinhma();
					String trangThai = "Đã thanh toán";
					int soLuongTon = 0;
					int soLuongConLai = 0; //sau khi thanh toán


					float tt = Float.parseFloat(txtTongTien.getText());
					ArrayList<KhuyenMai> ds1 = dao_KhuyenMai.getKhuyenMaiTheoTinhTrang("Đang diễn ra","Hóa đơn");
					String maKM = null ;
					float max = Float.MIN_VALUE;
					for (KhuyenMai khuyenMai : ds1) {
						if(khuyenMai.getGiaTriGiamGia()>max) {
							max = khuyenMai.getGiaTriGiamGia();
							maKM = khuyenMai.getMaKhuyenMai();
						}
						km = (float) (max*0.01);
						if(tt >= 500000) {
							txtKhuyenMai.setText(km+"");
						}
						else {
							km=0;
							txtKhuyenMai.setText(km+"");
							maKM = null ;
						}
					}
					
					txtKhuyenMai.setText(km+"");

					float tkm = km*tongThanhTien;
					tongThanhTien -= tkm;
					

					float tienKD = Float.parseFloat(txtTienKhachDua.getText());
					float tienTL = tienKD - tongThanhTien;
					txtTienThua.setText(tienTL + "");
					
					KhuyenMai kmLuu = new KhuyenMai(maKM);

					Date dateNgayLapHD = dcrNgayLap.getDate();
					Timestamp sqlNgayLapHD = new Timestamp(dateNgayLapHD.getTime());

					String maHD = txtMaHD.getText();
					String maNV = txtMaNhanVien.getText();
					NhanVien nv = new NhanVien(maNV);
					String maKH = txtMaKH.getText();
					KhachHang kh = new KhachHang(maKH);
					HoaDonBan hd = new HoaDonBan(maHD, nv, kh, kmLuu, sqlNgayLapHD, trangThai, tongThanhTien);
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
								float TT = Float.parseFloat(model.getValueAt(i, 5).toString());
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
								if(JOptionPane.showConfirmDialog(this,"Bạn có muốn in hóa đơn không ?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
									NhanVien nvIn = dao_NhanVien.getTheoMaNV(maNV);
									KhachHang khIn = dao_KhachHang.getTheoMaKH(maKH);
									SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						            String currentDateStr = dateFormat.format(dateNgayLapHD);
									inHoaDon in = new inHoaDon(maHD, currentDateStr, nvIn.getMaNhanVien(), khIn.getTenKhachHang(), khIn.getSoDT(), khIn.getDiaChi());
									in.setVisible(true);
								}

							}else {
								JOptionPane.showMessageDialog(this,"Thanh toán thất bại");

							}

						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return;
			}
			String ttt = modelHD.getValueAt(r, 5).toString(); 
			if("Tạm in".equals(ttt)) {
				//String tt = "Đã thanh toán";
				String ma = txtMaHD.getText();
				float tienKD = Float.parseFloat(txtTienKhachDua.getText());
				float tienTL = tienKD - tongThanhTien;
				txtTienThua.setText(tienTL + "");
				txtKhuyenMai.setText(km+"");
				if(dao_HoaDonBan.capNhat(ma, "Đã thanh toán")) {
					JOptionPane.showMessageDialog(this,"Thanh toán hóa đơn tạm thành công");
					if(JOptionPane.showConfirmDialog(this,"Bạn có muốn in hóa đơn không ?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						String maNV = txtMaNhanVien.getText();
						NhanVien nvIn = dao_NhanVien.getTheoMaNV(maNV);
						String maKH = txtMaKH.getText();
						KhachHang khIn = dao_KhachHang.getTheoMaKH(maKH);
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			            String currentDateStr = dateFormat.format(dcrNgayLap.getDate());
			            //String date = dcrNgayLap.getDate().toString();
						inHoaDon in = new inHoaDon(ma,currentDateStr, nvIn.getMaNhanVien(), khIn.getTenKhachHang(), khIn.getSoDT(), khIn.getDiaChi());
						in.setVisible(true);
					}
				}else {
					JOptionPane.showMessageDialog(this,"Thanh toán hóa đơn tạm thất bại");
				}

			}
		}
		else if(o.equals(btnThemSP)) {
			stt = model.getRowCount();
			if(validDataSLSP()) {
				String ma = txtMaSP.getText();
				String soLuong = txtSoLuong.getText();
				for(int i = 0; i< table.getRowCount();i++) {
					if (model.getValueAt(i, 1).toString().equals(ma) && stt!=0) {
						int sl = Integer.parseInt(model.getValueAt(i, 3).toString());
						int sln = Integer.parseInt(soLuong);
						float gia = Float.parseFloat(model.getValueAt(i,4).toString());
						float tc = sl*gia;
						float tt = (sl+sln)*gia;
						model.setValueAt(sl+sln, i, 3);
						model.setValueAt(tt, i, 5);
						tongThanhTien =tongThanhTien + tt - tc;
						txtTongTien.setText(tongThanhTien + "");
						kiemTraKM();
						return;
					}
				}
				int soL = Integer.parseInt(soLuong);
				ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(ma);
				for (SanPham sp : ds) {
					thanhTien = (float) (sp.getGiaBan()*soL);
					tongThanhTien += thanhTien;
					model.addRow(new Object[] {++stt,ma,sp.getTenSP(),soL,sp.getGiaBan(),thanhTien + ""});
					txtTongTien.setText(tongThanhTien + "");
				}
				kiemTraKM();
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
			txtTongTien.setText("");
			txtTienThua.setText("");
			txtTienKhachDua.setText("");
			txtKhuyenMai.setText("");
			tongThanhTien =0;
			km=0;
			while (model.getRowCount() != 0) {
				model.removeRow(0);
			}
		}
		else if(o.equals(btnXoaSP)) {
			int row = table.getSelectedRow();
			if(row < 0) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm muốn xóa");
				return;
			}
			String ma = model.getValueAt(row,1).toString();
			if(JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa sản phẩm có mã: " + ma, "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String thanhTienXoa = model.getValueAt(row,5).toString();
				float ttx = Float.parseFloat(thanhTienXoa);
				float tonngTienXoa = Float.parseFloat(txtTongTien.getText());
				float TTSX = tonngTienXoa-ttx;
				txtTongTien.setText(TTSX + "");
				tongThanhTien = TTSX;
				model.removeRow(row);
				for (int i = row; i < model.getRowCount(); i++) {
					model.setValueAt(i + 1, i, 0); // Cập nhật số thứ tự (STT)
				}
				txtKhuyenMai.setText("");
				kiemTraKM();
			}
		}
		else if(o.equals(btnSuaSP)) {
			int rowu = table.getSelectedRow();
			if(rowu < 0) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm muốn sửa");
				return;
			}
			String ma = model.getValueAt(rowu,1).toString();
			if(rowu >=0) {
				String thanhTienXoa = model.getValueAt(rowu,5).toString();
				float ttx = Float.parseFloat(thanhTienXoa);
				//float tonngTienXoa = Float.parseFloat(txtTongTien.getText());
				//float TTSX = tonngTienXoa-ttx;
				String soLuong = txtSoLuong.getText();
				//				model.removeRow(rowu);
				//				stt = model.getRowCount();
				//				String soLuong = txtSoLuong.getText();
				//				int soL = Integer.parseInt(soLuong);
				//				ArrayList<SanPham> ds = dao_SanPham.getSPTheoMa(ma );
				//				for (SanPham sp : ds) {
				//					thanhTien = (float) (sp.getGiaBan()*soL);
				//					tongThanhTien = TTSX +thanhTien;
				//					model.addRow(new Object[] {stt,ma,sp.getTenSP(),soL,sp.getGiaBan(),sp.getThueVAT(),thanhTien + ""});
				//					txtTongTien.setText(tongThanhTien + "");
				//				}
				//				txtKhuyenMai.setText("");
				//				kiemTraKM();
				int sln = Integer.parseInt(soLuong);
				float gia = Float.parseFloat(model.getValueAt(rowu,4).toString());
				float tt = (sln)*gia;
				model.setValueAt(sln, rowu, 3);
				model.setValueAt(tt, rowu, 5);
				float tienSua = tt - ttx;
				tongThanhTien += tienSua;
				txtTongTien.setText(tongThanhTien + "");
				kiemTraKM();
			}

		}
		else if(o.equals(btnTamIn)) {
			phatsinhma();
			if(validDataLT()) {
				tongThanhTien =0;
				int rowCount = table.getRowCount();
				for (int row = 0; row < rowCount; row++) {
					tongThanhTien += Float.parseFloat(model.getValueAt(row,5).toString());
				}
				txtTongTien.setText(tongThanhTien+"");
				String trangThai = "Tạm in";
				int soLuongTon = 0;
				int soLuongConLai = 0; //sau khi thanh toán
				//txtTienThua.setText(tienTL + "");

				Date dateNgayLapHD = dcrNgayLap.getDate();
				Timestamp sqlNgayLapHD = new Timestamp(dateNgayLapHD.getTime());
				
				float tt = Float.parseFloat(txtTongTien.getText());
				ArrayList<KhuyenMai> ds1 = dao_KhuyenMai.getKhuyenMaiTheoTinhTrang("Đang diễn ra","Hóa đơn");
				String maKM = null ;
				float max = Float.MIN_VALUE;
				for (KhuyenMai khuyenMai : ds1) {
					if(khuyenMai.getGiaTriGiamGia()>max) {
						max = khuyenMai.getGiaTriGiamGia();
						maKM = khuyenMai.getMaKhuyenMai();
					}
					km = (float) (max*0.01);
					if(tt >= 500000) {
						txtKhuyenMai.setText(km+"");
					}
					else {
						km=0;
						txtKhuyenMai.setText(km+"");
						maKM = null ;
					}
				}
				
				KhuyenMai kmLuu = new KhuyenMai(maKM);
				
				txtKhuyenMai.setText(km+"");

				float tkm = km*tongThanhTien;
				tongThanhTien -= tkm;
				

				String maHD = txtMaHD.getText();
				String maNV = txtMaNhanVien.getText();
				NhanVien nv = new NhanVien(maNV);
				String maKH = txtMaKH.getText();
				KhachHang kh = new KhachHang(maKH);
				HoaDonBan hd = new HoaDonBan(maHD, nv, kh, kmLuu, sqlNgayLapHD, trangThai,tongThanhTien);
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
							float TT = Float.parseFloat(model.getValueAt(i, 5).toString());
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
		else if(o.equals(btnTaoMoi_N)) {
			NhanVien nvph = dao_NhanVien.getTheoMaNV(txtMaNhanVien.getText());
			
			if("Nhân viên bán hàng".equals(nvph.getChucVu())) {
				ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoNgayHT_PH(txtMaNhanVien.getText());
				napDuLieuHDTuCSDL(dsHD);
				
			}else {
				ArrayList<HoaDonBan> dsHD1 = dao_HoaDonBan.getHDTheoNgayHT_PH_NVQL();
				napDuLieuHDTuCSDL(dsHD1);
			}
		}
		else if(o.equals(btnXuLyTI)) {
			int r = tableHD.getSelectedRow();
			int STT=0;
			tongThanhTien=0;
			km=0;
			txtTongTien.setText("");

			if(r < 0 ) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn tạm in cần xử lý");
				return;
			}
			if(modelHD.getValueAt(r, 5).toString().equals("Đã thanh toán")) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn tạm in cần xử lý");
				return;
			}
			String ma = modelHD.getValueAt(r,1).toString();
			//String ttTBL = modelHD.getValueAt(r, 5).toString();
			if(JOptionPane.showConfirmDialog(this,"Bạn có muốn xử lý hóa đơn tạm tin có mã: "+ma,"",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				model.setRowCount(0);
				ArrayList<ChiTietHoaDonBan> ct = dao_ChiTietHoaDonBan.getCTHoaDonBanTheoMa(ma);
				for (ChiTietHoaDonBan cthd : ct) {
					String maSP = cthd.getSanPham().getMaSP();
					SanPham sp = dao_SanPham.getTheoMa(maSP);
					model.addRow(new Object [] {++STT,sp.getMaSP(),sp.getTenSP(),cthd.getSoLuong(),sp.getGiaBan(),cthd.getThanhTien()});
					tongThanhTien +=cthd.getThanhTien();
					txtTongTien.setText(tongThanhTien+"");
					kiemTraKM();
				}
				txtKhuyenMai.setText(km+"");
				float tkm = km*tongThanhTien;
				tongThanhTien += tkm;
				txtTongTien.setText(tongThanhTien+"");
				txtMaHD.setText(ma);
				ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoMa(ma);
				for (HoaDonBan hd : dsHD) {
					KhachHang kh = dao_KhachHang.getTheoMaKH(hd.getMaKH().getMaKhachhang());
					txtSDTKhachHang.setText(kh.getSoDT());
					txtMaKH.setText(kh.getMaKhachhang());
					txtTenKH.setText(kh.getTenKhachHang());
					txtDiaChi.setText(kh.getDiaChi());
				}
				tabbedPane.setSelectedIndex(0);
			}
		}
		else if(o.equals(btnTimTheoMaHD)) {
			String maTim = txtMaHD_T.getText();
			if (maTim.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn muốn tìm");	

			} 
			else {
				NhanVien nvph = dao_NhanVien.getTheoMaNV(txtMaNhanVien.getText());
				if("Nhân viên bán hàng".equals(nvph.getChucVu())) {
					ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoMa_NVBH(maTim,txtMaNhanVien.getText());
					if (dsHD.size()==0) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy mã hóa đơn");
					}
					else {
						napDuLieuHDTuCSDL(dsHD);
					}
					
				}else {
					ArrayList<HoaDonBan> dsHD1 = dao_HoaDonBan.getHDTheoMa(maTim);
					if (dsHD1.size()==0) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy mã hóa đơn");
					}
					else {
						napDuLieuHDTuCSDL(dsHD1);
					}
				}
				

			}
		}
		else if(o.equals(btnTimTheoSDTKH)) {
			String maTim = txtTimSDTKH.getText();
			
			if (maTim.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng muốn tìm");	

			} 
			else {
				KhachHang khT = dao_KhachHang.getTheoSDT(maTim);
				if(khT == null) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy số điện thoại khách hàng");
				}
				else {
					NhanVien nvph = dao_NhanVien.getTheoMaNV(txtMaNhanVien.getText());
					if("Nhân viên bán hàng".equals(nvph.getChucVu())) {
						ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoMAKH_NVBH(khT.getMaKhachhang(),txtMaNhanVien.getText());
						if (dsHD.size()==0) {
							JOptionPane.showMessageDialog(this, "Không tìm thấy số điện thoại khách hàng");
						}
						else {
							napDuLieuHDTuCSDL(dsHD);
						}
						
					}else {
						ArrayList<HoaDonBan> dsHD1 = dao_HoaDonBan.getHDTheoMAKH(khT.getMaKhachhang());
						if (dsHD1.size()==0) {
							JOptionPane.showMessageDialog(this, "Không tìm thấy mã hóa đơn");
						}
						else {
							napDuLieuHDTuCSDL(dsHD1);
						}
					}
				}
				
				

			}
		}
		else if(o.equals(btnTimTenKH)) {
			String maTim = txtTimTenKH.getText();
			
			if (maTim.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên khách hàng muốn tìm");	

			} 
			else {
				ArrayList<KhachHang> khT = dao_KhachHang.getKHTheoHoTen(maTim);
				if(khT.size()==0) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy họ tên khách hàng");
				}
				else {
					NhanVien nvph = dao_NhanVien.getTheoMaNV(txtMaNhanVien.getText());
					if("Nhân viên bán hàng".equals(nvph.getChucVu())) {
						for (KhachHang khachHang : khT) {
							ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoMAKH_NVBH(khachHang.getMaKhachhang(),txtMaNhanVien.getText());
							if (dsHD.size()==0) {
								JOptionPane.showMessageDialog(this, "Không tìm thấy mã hóa đơn");
							}
							else {
								napDuLieuHDTuCSDL(dsHD);
							}
						}		
					}else {
						for (KhachHang khachHang : khT) {
							ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoMAKH(khachHang.getMaKhachhang());
							if (dsHD.size()==0) {
								JOptionPane.showMessageDialog(this, "Không tìm thấy mã hóa đơn");
							}
							else {
								napDuLieuHDTuCSDL(dsHD);
							}
						}
					}
				}
			}
		}
		else if(o.equals(btnTimTheoNgay)) {
			Date currentDate = dcrNgayLap_T.getDate();
			
			if (currentDate == null) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày lập hóa đơn muốn tìm");	

			} 
			else {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	            String currentDateStr = dateFormat.format(currentDate);
				NhanVien nvph = dao_NhanVien.getTheoMaNV(txtMaNhanVien.getText());
				if("Nhân viên bán hàng".equals(nvph.getChucVu())) {
					ArrayList<HoaDonBan> dsHD = dao_HoaDonBan.getHDTheoNgay_NVBH(currentDateStr,txtMaNhanVien.getText());
					if (dsHD.size()==0) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy ngày lập hóa đơn");
					}
					else {
						napDuLieuHDTuCSDL(dsHD);
					}
					
				}else {
					ArrayList<HoaDonBan> dsHD1 = dao_HoaDonBan.getHDTheoNgay(currentDateStr);
					if (dsHD1.size()==0) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy ngày lập hóa đơn");
					}
					else {
						napDuLieuHDTuCSDL(dsHD1);
					}
				}
				

			}
		}
		else if(o.equals(btnInHD_DS)) {
			int r = tableHD.getSelectedRow();
			String tt = modelHD.getValueAt(r, 5).toString();
			if(r>=0) {
				
				if(tt.equals("Tạm in")) {
					JOptionPane.showMessageDialog(this,"Hóa đơn chưa thanh toán không thể in lại");
				}
				else {
					String maHD = modelHD.getValueAt(r, 1).toString();
					ArrayList<HoaDonBan> ds = dao_HoaDonBan.getHDTheoMa(maHD);
					String maNV=null;
					String maKH=null;
					Date dateNgayLapHD =null;
					for (HoaDonBan hd : ds) {
						maNV = hd.getMaNV().getMaNhanVien();
						maKH = hd.getMaKH().getMaKhachhang();
						dateNgayLapHD = hd.getNgayGD();
					}
					NhanVien nvIn = dao_NhanVien.getTheoMaNV(maNV);
					KhachHang khIn = dao_KhachHang.getTheoMaKH(maKH);
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		            String currentDateStr = dateFormat.format(dateNgayLapHD);
					inHoaDon in = new inHoaDon(maHD, currentDateStr, nvIn.getMaNhanVien(), khIn.getTenKhachHang(), khIn.getSoDT(), khIn.getDiaChi());
					in.setVisible(true);
					
				}
				
			}
			else {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn muốn in lại");
				return;
			}
			
		}
		else if(o.equals(btnHuyHD)) {
			int r = tableHD.getSelectedRow();
			String maHD = modelHD.getValueAt(r, 1).toString();
			String tt = modelHD.getValueAt(r, 5).toString();
			if(r<0) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn hóa đơn muốn in lại");
				return;
			}
			else {
				if(tt.equals("Đã thanh toán")) {
					JOptionPane.showMessageDialog(this,"Hóa đơn có mã "+maHD+"đã thanh toán nên không thể hủy");
				}
				else {
					if(JOptionPane.showConfirmDialog(this,"Bạn có muốn hủy hóa đơn có mã: " + maHD, "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						try {
							if(dao_ChiTietHoaDonBan.xoaHoaDonBanTheoMa(maHD)&&dao_HoaDonBan.xoaHoaDonBanTheoMa(maHD)) {
								JOptionPane.showMessageDialog(this,"Hủy thanh công hóa đơn có mã" +maHD);
							}
						} catch (HeadlessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
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
		if (row<0) {
			while (modelCTHD.getRowCount() != 0) {
				modelCTHD.removeRow(0);
			}
			int STT = 0;
			int r = tableHD.getSelectedRow();
			String maHD = modelHD.getValueAt(r, 1).toString();
			ArrayList<ChiTietHoaDonBan> ct = dao_ChiTietHoaDonBan.getCTHoaDonBanTheoMa(maHD);
			for (ChiTietHoaDonBan dsct : ct) {
				SanPham sp = dao_SanPham.getTheoMa(dsct.getSanPham().getMaSP());
					modelCTHD.addRow(new Object[] {++STT,maHD,sp.getMaSP(),sp.getTenSP(),dsct.getSoLuong(),sp.getThueVAT(),sp.getGiaBan()*dsct.getSoLuong()});
			}	
		}
		else {
			txtMaSP.setText(model.getValueAt(row,1).toString());
			txtTenSP.setText(model.getValueAt(row,2).toString());
			txtSoLuong.setText(model.getValueAt(row,3).toString());
			txtGiaBan.setText(model.getValueAt(row,4).toString());
		}
		
		
		
		
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
