package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Dao_Sach;
import entity.Sach;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class pnlSanPham extends JPanel implements ActionListener {
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaMua;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private JTextField txtTacGia;
	private JTextField txtNhaXuatBan;
	private JTextField txtNamXB;
	private JTextField txtSoTrang;
	private JComboBox<String> cbTinhTrang;
	private JComboBox<String> cbMaDanhMuc;
	private JComboBox<String> cbMaKeHang;
	private JComboBox<String> cbMaKhuyenMai;
	private JTextField txtTimKiemSP;
	private JTable tblSach;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTable tblVanPhongPham;
	private JTextField txtTimKiem_1;
	private DefaultTableModel modelSach;
	private DefaultTableModel modelVPPham;
	private Dao_Sach sach_dao = new Dao_Sach();

	/**
	 * Create the panel.
	 */
	public pnlSanPham() {
		setBackground(Color.CYAN);
		setForeground(Color.YELLOW);
		setBounds(0,0, 1163,763);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1163, 763);
		add(tabbedPane);
		
		JPanel pnlSach = new JPanel();
		tabbedPane.addTab("Sách", null, pnlSach, null);
		pnlSach.setLayout(null);
		
		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBorder(new TitledBorder(null, "Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTin.setBounds(10, 10, 322, 716);
		pnlSach.add(pnlThongTin);
		pnlThongTin.setLayout(null);
		
		JPanel pnlMaSP = new JPanel();
		pnlMaSP.setBounds(10, 22, 302, 65);
		pnlThongTin.add(pnlMaSP);
		pnlMaSP.setLayout(null);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm: ");
		lblMaSP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaSP.setBounds(90, 5, 128, 22);
		pnlMaSP.add(lblMaSP);
		
		txtMaSP = new JTextField();
		txtMaSP.setEnabled(false);
		txtMaSP.setEditable(false);
		txtMaSP.setBounds(10, 35, 282, 24);
		pnlMaSP.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		JPanel pnlTenSP = new JPanel();
		pnlTenSP.setLayout(null);
		pnlTenSP.setBounds(10, 100, 302, 65);
		pnlThongTin.add(pnlTenSP);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm: ");
		lblTenSP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenSP.setBounds(88, 5, 139, 22);
		pnlTenSP.add(lblTenSP);
		
		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(10, 35, 282, 24);
		pnlTenSP.add(txtTenSP);
		
		JPanel pnlGiaMua = new JPanel();
		pnlGiaMua.setLayout(null);
		pnlGiaMua.setBounds(10, 178, 302, 65);
		pnlThongTin.add(pnlGiaMua);
		
		JLabel lblGiaMua = new JLabel("Giá Mua: ");
		lblGiaMua.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaMua.setBounds(110, 5, 87, 22);
		pnlGiaMua.add(lblGiaMua);
		
		txtGiaMua = new JTextField();
		txtGiaMua.setColumns(10);
		txtGiaMua.setBounds(10, 35, 282, 24);
		pnlGiaMua.add(txtGiaMua);
		
		JPanel pnlGiaBan = new JPanel();
		pnlGiaBan.setLayout(null);
		pnlGiaBan.setBounds(10, 256, 302, 65);
		pnlThongTin.add(pnlGiaBan);
		
		JLabel lblGiaBan = new JLabel("Giá Bán: ");
		lblGiaBan.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaBan.setBounds(111, 5, 87, 22);
		pnlGiaBan.add(lblGiaBan);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(10, 35, 282, 24);
		pnlGiaBan.add(txtGiaBan);
		
		JPanel pnlSoLuong = new JPanel();
		pnlSoLuong.setLayout(null);
		pnlSoLuong.setBounds(10, 334, 302, 65);
		pnlThongTin.add(pnlSoLuong);
		
		JLabel lblSoLuong = new JLabel("Số Lượng: ");
		lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoLuong.setBounds(105, 5, 99, 22);
		pnlSoLuong.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(10, 35, 282, 24);
		pnlSoLuong.add(txtSoLuong);
		
		JPanel pnlTinhTrang = new JPanel();
		pnlTinhTrang.setLayout(null);
		pnlTinhTrang.setBounds(10, 412, 302, 65);
		pnlThongTin.add(pnlTinhTrang);
		
		JLabel lblTinhTrang = new JLabel("Tinh Trạng: ");
		lblTinhTrang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTinhTrang.setBounds(103, 5, 99, 22);
		pnlTinhTrang.add(lblTinhTrang);
		
		JComboBox cbTinhTrang = new JComboBox();
		cbTinhTrang.setBounds(10, 35, 282, 24);
		pnlTinhTrang.add(cbTinhTrang);
		
		JPanel pnlMaKeHang = new JPanel();
		pnlMaKeHang.setLayout(null);
		pnlMaKeHang.setBounds(10, 490, 302, 65);
		pnlThongTin.add(pnlMaKeHang);
		
		JLabel lblMaKeHang = new JLabel("Mã Kệ Hàng: ");
		lblMaKeHang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKeHang.setBounds(101, 5, 116, 22);
		pnlMaKeHang.add(lblMaKeHang);
		
		JComboBox cbMaKeHang = new JComboBox();
		cbMaKeHang.setModel(new DefaultComboBoxModel(new String[] {"KH001", "KH002", "KH003", "KH004", "KH005", "KH006", "KH007", "KH008"}));
		cbMaKeHang.setBounds(10, 35, 282, 24);
		pnlMaKeHang.add(cbMaKeHang);
		
		JPanel pnlMaDanhMuc = new JPanel();
		pnlMaDanhMuc.setLayout(null);
		pnlMaDanhMuc.setBounds(10, 568, 302, 65);
		pnlThongTin.add(pnlMaDanhMuc);
		
		JLabel lblMaDanhMuc = new JLabel("Mã Danh Mục: ");
		lblMaDanhMuc.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaDanhMuc.setBounds(97, 5, 136, 22);
		pnlMaDanhMuc.add(lblMaDanhMuc);
		
		JComboBox cbMaDanhMuc = new JComboBox();
		cbMaDanhMuc.setModel(new DefaultComboBoxModel(new String[] {"DM001", "DM002", "DM003", "DM004", "DM005", "DM006", "DM007", "DM008"}));
		cbMaDanhMuc.setBounds(10, 35, 282, 24);
		pnlMaDanhMuc.add(cbMaDanhMuc);
		
		JPanel pnlMaKhuyenMai = new JPanel();
		pnlMaKhuyenMai.setLayout(null);
		pnlMaKhuyenMai.setBounds(10, 646, 302, 65);
		pnlThongTin.add(pnlMaKhuyenMai);
		
		JLabel lblMaKhuyenMai = new JLabel("Mã Khuyến Mãi: ");
		lblMaKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKhuyenMai.setBounds(93, 5, 147, 22);
		pnlMaKhuyenMai.add(lblMaKhuyenMai);
		
		JComboBox cbMaKhuyenMai = new JComboBox();
		cbMaKhuyenMai.setBounds(10, 35, 282, 24);
		pnlMaKhuyenMai.add(cbMaKhuyenMai);
		
		JPanel pnlThongTinSach = new JPanel();
		pnlThongTinSach.setBorder(new TitledBorder(null, "Th\u00F4ng tin S\u00E1ch: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSach.setBounds(335, 10, 813, 147);
		pnlSach.add(pnlThongTinSach);
		pnlThongTinSach.setLayout(null);
		
		JPanel pnlChiTiet = new JPanel();
		pnlChiTiet.setLayout(null);
		pnlChiTiet.setBounds(10, 20, 786, 110);
		pnlThongTinSach.add(pnlChiTiet);
		
		JLabel lblTacGia = new JLabel("Tác Giả:");
		lblTacGia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTacGia.setBounds(20, 20, 77, 22);
		pnlChiTiet.add(lblTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(178, 20, 200, 24);
		pnlChiTiet.add(txtTacGia);
		
		JLabel lblNhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblNhaXuatBan.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNhaXuatBan.setBounds(20, 64, 132, 22);
		pnlChiTiet.add(lblNhaXuatBan);
		
		txtNhaXuatBan = new JTextField();
		txtNhaXuatBan.setColumns(10);
		txtNhaXuatBan.setBounds(178, 64, 200, 24);
		pnlChiTiet.add(txtNhaXuatBan);
		
		JLabel lblNamXB = new JLabel("Năm Xuất Bản: ");
		lblNamXB.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNamXB.setBounds(418, 18, 132, 22);
		pnlChiTiet.add(lblNamXB);
		
		txtNamXB = new JTextField();
		txtNamXB.setColumns(10);
		txtNamXB.setBounds(576, 18, 200, 24);
		pnlChiTiet.add(txtNamXB);
		
		JLabel lblSoTrang = new JLabel("Số Trang: ");
		lblSoTrang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoTrang.setBounds(418, 64, 96, 22);
		pnlChiTiet.add(lblSoTrang);
		
		txtSoTrang = new JTextField();
		txtSoTrang.setColumns(10);
		txtSoTrang.setBounds(576, 64, 200, 24);
		pnlChiTiet.add(txtSoTrang);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBounds(335, 167, 813, 175);
		pnlSach.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoi.setBounds(32, 27, 160, 56);
		pnlChucNang.add(btnLamMoi);
		Image img_iconLamMoi = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnLamMoi.setIcon(new ImageIcon(img_iconLamMoi));
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(32, 93, 337, 56);
		pnlChucNang.add(btnThem);
		Image img_iconthem = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnThem.setIcon(new ImageIcon(img_iconthem));
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhat.setBounds(209, 27, 160, 56);
		pnlChucNang.add(btnCapNhat);
		Image img_iconCapNhat = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
		btnCapNhat.setIcon(new ImageIcon(img_iconCapNhat));
		
		JLabel lblTimKiemSP = new JLabel("Tìm kiếm sản phẩm theo mã:");
		lblTimKiemSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiemSP.setBounds(441, 59, 231, 22);
		pnlChucNang.add(lblTimKiemSP);
		
		txtTimKiemSP = new JTextField();
		txtTimKiemSP.setColumns(10);
		txtTimKiemSP.setBounds(441, 91, 231, 24);
		pnlChucNang.add(txtTimKiemSP);
		
		JButton btnTimKiemSP = new JButton("");
		btnTimKiemSP.setBounds(698, 59, 68, 56);
		pnlChucNang.add(btnTimKiemSP);
		Image img_iconTimKiem = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		btnTimKiemSP.setIcon(new ImageIcon(img_iconTimKiem));
		
		JPanel pnlDsSP = new JPanel();
		pnlDsSP.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDsSP.setBounds(335, 352, 813, 374);
		pnlSach.add(pnlDsSP);
		pnlDsSP.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 21, 793, 343);
		pnlDsSP.add(scrollPane);
		
//		tblSach = new JTable();
//		tblSach.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		tblSach.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"M\u00E3 K\u1EC7 H\u00E0ng", "T\u00EAn K\u1EC7 H\u00E0ng", "Gi\u00E1 Mua", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 B\u00E1n", "Nh\u00E0 S\u1EA3n Xu\u1EA5t", "T\u00E1c Gi\u1EA3", "N\u0103m Xu\u1EA5t B\u1EA3n", "S\u1ED1 Trang", "M\u00E3 Danh M\u1EE5c", "M\u00E3 K\u1EC7 H\u00E0ng", "M\u00E3 Khuy\u1EBFn M\u00E3i", "T\u00ECnh Tr\u1EA1ng"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, Float.class, Integer.class, Float.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		scrollPane.setViewportView(tblSach);
		String[] tblS = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Giá mua", "Số lượng", "Giá bán", "Nhà sản xuất","Tác giả", "Năm sản xuất", "Số trang",
				"Mã Danh mục", "Mã kệ hàng","Mã khuyến mãi", "Tình trạng" };
				modelSach = new DefaultTableModel(tblS, 0);
				tblSach = new JTable(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Gi\u00E1 mua", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n", "Nh\u00E0 s\u1EA3n xu\u1EA5t", "T\u00E1c gi\u1EA3", "N\u0103m s\u1EA3n xu\u1EA5t", "S\u1ED1 trang", "M\u00E3 Danh m\u1EE5c", "M\u00E3 k\u1EC7 h\u00E0ng", "M\u00E3 khuy\u1EBFn m\u00E3i", "T\u00ECnh tr\u1EA1ng"
					}
				));
				tblSach.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scrollPane.setViewportView(tblSach);
		
		JPanel pnlVanPhongPham = new JPanel();
		pnlVanPhongPham.setLayout(null);
		tabbedPane.addTab("Văn Phòng Phẩm", null, pnlVanPhongPham, null);
		
		JPanel pnlThongTin_1 = new JPanel();
		pnlThongTin_1.setLayout(null);
		pnlThongTin_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTin_1.setBounds(10, 10, 322, 716);
		pnlVanPhongPham.add(pnlThongTin_1);
		
		JPanel pnlMaSP_1 = new JPanel();
		pnlMaSP_1.setLayout(null);
		pnlMaSP_1.setBounds(10, 22, 302, 65);
		pnlThongTin_1.add(pnlMaSP_1);
		
		JLabel lblNewLabel_3 = new JLabel("Mã Sản Phẩm: ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(90, 5, 128, 22);
		pnlMaSP_1.add(lblNewLabel_3);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(10, 35, 282, 24);
		pnlMaSP_1.add(textField_10);
		
		JPanel pnlTenSP_1 = new JPanel();
		pnlTenSP_1.setLayout(null);
		pnlTenSP_1.setBounds(10, 100, 302, 65);
		pnlThongTin_1.add(pnlTenSP_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Sản Phẩm: ");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(88, 5, 139, 22);
		pnlTenSP_1.add(lblNewLabel_1_2);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(10, 35, 282, 24);
		pnlTenSP_1.add(textField_11);
		
		JPanel pnlGiaMua_1 = new JPanel();
		pnlGiaMua_1.setLayout(null);
		pnlGiaMua_1.setBounds(10, 178, 302, 65);
		pnlThongTin_1.add(pnlGiaMua_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Giá Mua: ");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(110, 5, 87, 22);
		pnlGiaMua_1.add(lblNewLabel_1_1_2);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(10, 35, 282, 24);
		pnlGiaMua_1.add(textField_12);
		
		JPanel pnlGiaBan_1 = new JPanel();
		pnlGiaBan_1.setLayout(null);
		pnlGiaBan_1.setBounds(10, 256, 302, 65);
		pnlThongTin_1.add(pnlGiaBan_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Giá Bán: ");
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_2.setBounds(111, 5, 87, 22);
		pnlGiaBan_1.add(lblNewLabel_1_1_1_2);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(10, 35, 282, 24);
		pnlGiaBan_1.add(textField_13);
		
		JPanel pnlSoLuong_1 = new JPanel();
		pnlSoLuong_1.setLayout(null);
		pnlSoLuong_1.setBounds(10, 334, 302, 65);
		pnlThongTin_1.add(pnlSoLuong_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Số Lượng: ");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_2.setBounds(105, 5, 99, 22);
		pnlSoLuong_1.add(lblNewLabel_1_1_1_1_2);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(10, 35, 282, 24);
		pnlSoLuong_1.add(textField_14);
		
		JPanel pnlTinhTrang_1 = new JPanel();
		pnlTinhTrang_1.setLayout(null);
		pnlTinhTrang_1.setBounds(10, 412, 302, 65);
		pnlThongTin_1.add(pnlTinhTrang_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Tinh Trạng: ");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_2.setBounds(103, 5, 99, 22);
		pnlTinhTrang_1.add(lblNewLabel_1_1_1_1_1_2);
		
		JComboBox cbTinhTrang_1 = new JComboBox();
		cbTinhTrang_1.setBounds(10, 35, 282, 24);
		pnlTinhTrang_1.add(cbTinhTrang_1);
		
		JPanel pnlMaKeHang_1 = new JPanel();
		pnlMaKeHang_1.setLayout(null);
		pnlMaKeHang_1.setBounds(10, 490, 302, 65);
		pnlThongTin_1.add(pnlMaKeHang_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("Mã Kệ Hàng: ");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(101, 5, 116, 22);
		pnlMaKeHang_1.add(lblNewLabel_1_1_1_1_1_1_2);
		
		JComboBox cbKeHang_1 = new JComboBox();
		cbKeHang_1.setModel(new DefaultComboBoxModel(new String[] {"KH001", "KH002", "KH003", "KH004", "KH005", "KH006", "KH007", "KH008"}));
		cbKeHang_1.setBounds(10, 35, 282, 24);
		pnlMaKeHang_1.add(cbKeHang_1);
		
		JPanel pnlMaDanhMuc_1 = new JPanel();
		pnlMaDanhMuc_1.setLayout(null);
		pnlMaDanhMuc_1.setBounds(10, 568, 302, 65);
		pnlThongTin_1.add(pnlMaDanhMuc_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_2 = new JLabel("Mã Danh Mục: ");
		lblNewLabel_1_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_1_2.setBounds(97, 5, 136, 22);
		pnlMaDanhMuc_1.add(lblNewLabel_1_1_1_1_1_1_1_2);
		
		JComboBox cbDanhMuc_1 = new JComboBox();
		cbDanhMuc_1.setModel(new DefaultComboBoxModel(new String[] {"DM001", "DM002", "DM003", "DM004", "DM005", "DM006", "DM007", "DM008"}));
		cbDanhMuc_1.setBounds(10, 35, 282, 24);
		pnlMaDanhMuc_1.add(cbDanhMuc_1);
		
		JPanel pnlMaKhuyenMai_1 = new JPanel();
		pnlMaKhuyenMai_1.setLayout(null);
		pnlMaKhuyenMai_1.setBounds(10, 646, 302, 65);
		pnlThongTin_1.add(pnlMaKhuyenMai_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Mã Khuyến Mãi: ");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(93, 5, 147, 22);
		pnlMaKhuyenMai_1.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JComboBox cbKhuyenMai_1 = new JComboBox();
		cbKhuyenMai_1.setBounds(10, 35, 282, 24);
		pnlMaKhuyenMai_1.add(cbKhuyenMai_1);
		
		JPanel pnlThongTinVanPhongPham = new JPanel();
		pnlThongTinVanPhongPham.setLayout(null);
		pnlThongTinVanPhongPham.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin V\u0103n Ph\u00F2ng Ph\u1EA9m: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlThongTinVanPhongPham.setBounds(335, 10, 813, 147);
		pnlVanPhongPham.add(pnlThongTinVanPhongPham);
		
		JPanel pnlChiTiet_1 = new JPanel();
		pnlChiTiet_1.setLayout(null);
		pnlChiTiet_1.setBounds(10, 20, 786, 110);
		pnlThongTinVanPhongPham.add(pnlChiTiet_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Thương Hiệu:");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_4.setBounds(20, 20, 111, 22);
		pnlChiTiet_1.add(lblNewLabel_2_4);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(178, 20, 200, 24);
		pnlChiTiet_1.add(textField_15);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Xuất xứ:");
		lblNewLabel_2_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(20, 64, 132, 22);
		pnlChiTiet_1.add(lblNewLabel_2_1_2);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(178, 64, 200, 24);
		pnlChiTiet_1.add(textField_16);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Màu Sắc: ");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(418, 18, 132, 22);
		pnlChiTiet_1.add(lblNewLabel_2_2_1);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(576, 18, 200, 24);
		pnlChiTiet_1.add(textField_17);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Chất liệu: ");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_3_1.setBounds(418, 64, 96, 22);
		pnlChiTiet_1.add(lblNewLabel_2_3_1);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(576, 64, 200, 24);
		pnlChiTiet_1.add(textField_18);
		
		JPanel pnlChucNang_1 = new JPanel();
		pnlChucNang_1.setLayout(null);
		pnlChucNang_1.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang_1.setBounds(335, 167, 813, 175);
		pnlVanPhongPham.add(pnlChucNang_1);
		
		JButton btnLamMoi_1 = new JButton("Làm mới");
		btnLamMoi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoi_1.setBounds(32, 27, 160, 56);
		pnlChucNang_1.add(btnLamMoi_1);
		Image img_iconLamMoi_1 = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnLamMoi_1.setIcon(new ImageIcon(img_iconLamMoi_1));
		
		JButton btnThem_2 = new JButton("Thêm");
		btnThem_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem_2.setBounds(32, 93, 337, 56);
		pnlChucNang_1.add(btnThem_2);
		Image img_iconthem_2 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnThem_2.setIcon(new ImageIcon(img_iconthem_2));
		
		JButton btnCapNhat_1 = new JButton("Cập Nhật");
		btnCapNhat_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhat_1.setBounds(209, 27, 160, 56);
		pnlChucNang_1.add(btnCapNhat_1);
		Image img_iconCapNhat_1 = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
		btnCapNhat_1.setIcon(new ImageIcon(img_iconCapNhat_1));
		
		JLabel lblTimKiemSP_1 = new JLabel("Tìm kiếm thông tin sản phẩm:");
		lblTimKiemSP_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiemSP_1.setBounds(441, 59, 231, 22);
		pnlChucNang_1.add(lblTimKiemSP_1);
		
		txtTimKiem_1 = new JTextField();
		txtTimKiem_1.setColumns(10);
		txtTimKiem_1.setBounds(441, 91, 231, 24);
		pnlChucNang_1.add(txtTimKiem_1);
		
		JButton btnTimKiem_1 = new JButton("");
		btnTimKiem_1.setBounds(698, 59, 68, 56);
		pnlChucNang_1.add(btnTimKiem_1);
		Image img_iconTimKiem_1 = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		btnTimKiem_1.setIcon(new ImageIcon(img_iconTimKiem_1));
		
		
		JPanel pnlDsSP_1 = new JPanel();
		pnlDsSP_1.setLayout(null);
		pnlDsSP_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDsSP_1.setBounds(335, 352, 813, 374);
		pnlVanPhongPham.add(pnlDsSP_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 21, 793, 343);
		pnlDsSP_1.add(scrollPane_1);
		
//		tblVanPhongPham = new JTable();
//		tblVanPhongPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		tblVanPhongPham.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Gi\u00E1 Mua", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 B\u00E1n", "Th\u01B0\u01A1ng Hi\u1EC7u", "Xu\u1EA5t X\u1EE9", "M\u00E0u S\u1EAFc", "Ch\u1EA5t Li\u1EC7u", "M\u00E3 Danh M\u1EE5c", "T\u00ECnh Tr\u1EA1ng", "M\u00E3 Khuy\u1EBFn M\u00E3i", "M\u00E3 K\u1EC7 H\u00E0ng"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, Float.class, Integer.class, Float.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		scrollPane_1.setViewportView(tblVanPhongPham);
		String[] tblVP = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Giá mua", "Số lượng", "Giá bán", "Nhà sản xuất","Tác giả", "Năm sản xuất", "Số trang",
				"Mã Danh mục", "Mã kệ hàng","Mã khuyến mãi", "Tình trạng" };
				modelVPPham = new DefaultTableModel(tblVP, 0);
				tblVanPhongPham = new JTable(modelVPPham);
				tblVanPhongPham.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				scrollPane_1.setViewportView(tblVanPhongPham);
				
				
				
		loadDataSach(sach_dao.getAllSanPhamSach());		
				
		btnThem.addActionListener(this);
		btnThem_2.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLamMoi_1.addActionListener(this);
		btnLamMoi_1.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnCapNhat_1.addActionListener(this);
		btnTimKiemSP.addActionListener(this);
		btnTimKiem_1.addActionListener(this);
	}
	
	
	private void XoaTrangSach() {
		txtMaSP.setText("");
		txtTenSP.setText("");
		txtGiaMua.setText("");
		txtGiaBan.setText("");
		txtSoLuong.setText("");
		txtNhaXuatBan.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtSoTrang.setText("");
		cbMaDanhMuc.setSelectedIndex(0);
		cbMaKeHang.setSelectedIndex(0);
		cbMaKhuyenMai.setSelectedIndex(0);
		cbTinhTrang.setSelectedIndex(0);
	}
	
	
	public void loadDataSach(ArrayList<Sach> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblSach.getModel();
		dm.getDataVector().removeAllElements();
		for (Sach s : ds) {
			modelSach.addRow(new Object[] {s.getMaSP(), s.getTenSP(), s.getGiaMua(), s.getSoLuong(),s.getGiaBan(),
					s.getNhaXB(), s.getTacGia(), s.getNamXB(), s.getSoTrang(), s.getMaDanhMuc(), s.getMaKeHang(),
					s.getMaKeHang(), s.getMaKhuyenMai(), s.getTinhTrang()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
