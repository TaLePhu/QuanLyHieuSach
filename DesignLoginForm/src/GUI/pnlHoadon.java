package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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

public class pnlHoadon extends JPanel {
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private JTable table;
	private JTextField txtSDTKhachHang;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtMaHD;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNV;
	private JTextField txtMaKM;
	private JTextField txtGiaTriGG;
	private JTextField txtTongTien;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThua;

	/**
	 * Create the panel.
	 */
	public pnlHoadon() {
		setBackground(new Color(224, 255, 255));
		setForeground(Color.BLACK);
		setBounds(0,0, 1163, 763);
		setLayout(null);
		
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
		txtMaSP.setBounds(120, 20, 250, 20);
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
		
		JButton btnXoaSP = new JButton("Xóa sản phẩm");
		btnXoaSP.setBounds(510, 75, 250, 40);
		pnlBorderSP.add(btnXoaSP);
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setBounds(240, 75, 250, 40);
		pnlBorderSP.add(btnThemSP);
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 160, 750, 400);
		pnlHDBan.add(scrollPane);
		
		String[] tb = new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn vị tính", "Đơn giá bán", "Số lượng","Khuyến mãi", "%VAT",
		"Thành tiền" };
		DefaultTableModel model = new DefaultTableModel(tb, 0);
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
		txtSDTKhachHang.setBounds(120, 20, 250, 20);
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
		
		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setLayout(null);
		pnlHoaDon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlHoaDon.setBounds(770, 160, 380, 150);
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
		
		JDateChooser dcrNgayLap = new JDateChooser();
		dcrNgayLap.setBounds(120, 50, 250, 20);
		
		dcrNgayLap.setLocale(new Locale("vi", "VN"));
		dcrNgayLap.setDateFormatString("dd/MM/yyyy");
		dcrNgayLap.setDate(new Date(System.currentTimeMillis()));
		dcrNgayLap.setEnabled(false); // chi duoc doc
		
		pnlHoaDon.add(dcrNgayLap);
		
		JPanel pnlHoaDon_1 = new JPanel();
		pnlHoaDon_1.setLayout(null);
		pnlHoaDon_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlHoaDon_1.setBounds(770, 320, 380, 150);
		pnlHDBan.add(pnlHoaDon_1);
		
		JLabel maKhuyenMai = new JLabel("Mã khuyễn mãi");
		maKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 12));
		maKhuyenMai.setBounds(10, 20, 100, 20);
		pnlHoaDon_1.add(maKhuyenMai);
		
		txtMaKM = new JTextField();
		txtMaKM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaKM.setColumns(10);
		txtMaKM.setBounds(120, 20, 250, 20);
		pnlHoaDon_1.add(txtMaKM);
		
		JLabel lblNgayBDKM = new JLabel("Ngày bắt đầu");
		lblNgayBDKM.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayBDKM.setBounds(10, 50, 112, 20);
		pnlHoaDon_1.add(lblNgayBDKM);
		
		txtGiaTriGG = new JTextField();
		txtGiaTriGG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGiaTriGG.setEnabled(false);
		txtGiaTriGG.setColumns(10);
		txtGiaTriGG.setBounds(120, 110, 250, 20);
		pnlHoaDon_1.add(txtGiaTriGG);
		
		JLabel lblGiaTriGG = new JLabel("Giá trị");
		lblGiaTriGG.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGiaTriGG.setBounds(10, 110, 100, 20);
		pnlHoaDon_1.add(lblGiaTriGG);
		
		JDateChooser dcrNgayBDKM = new JDateChooser();
		dcrNgayBDKM.setLocale(new Locale("vi", "VN"));
		dcrNgayBDKM.setEnabled(false);
		dcrNgayBDKM.setDateFormatString("dd/MM/yyyy");
		dcrNgayBDKM.setBounds(120, 50, 250, 20);
		pnlHoaDon_1.add(dcrNgayBDKM);
		
		JLabel lblNgayKTKM = new JLabel("Ngày kết thuc");
		lblNgayKTKM.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayKTKM.setBounds(10, 80, 112, 20);
		pnlHoaDon_1.add(lblNgayKTKM);
		
		JDateChooser dcrNgayKTKM = new JDateChooser();
		dcrNgayKTKM.setLocale(new Locale("vi", "VN"));
		dcrNgayKTKM.setEnabled(false);
		dcrNgayKTKM.setDateFormatString("dd/MM/yyyy");
		dcrNgayKTKM.setBounds(120, 80, 250, 20);
		pnlHoaDon_1.add(dcrNgayKTKM);
		
		JPanel pnlThanhToan = new JPanel();
		pnlThanhToan.setLayout(null);
		pnlThanhToan.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnThanhToan.setBounds(810, 490, 300, 70);
		pnlHDBan.add(btnThanhToan);
		
		JButton btnTamIn = new JButton("In tạm hóa đơn");
		btnTamIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTamIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTamIn.setBounds(810, 570, 300, 70);
		pnlHDBan.add(btnTamIn);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnXoaTrang.setBounds(810, 650, 300, 70);
		pnlHDBan.add(btnXoaTrang);
		btnXoaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel pnlHDNhap = new JPanel();
		tabbedPane.addTab("Hóa đơn nhập", null, pnlHDNhap, null);
		pnlHDNhap.setLayout(null);
	}
}
