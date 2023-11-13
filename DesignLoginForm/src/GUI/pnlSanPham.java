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
import dao.Dao_VanPhongPham;
import entity.Sach;
import entity.VanPhongPham;

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
	private JTextField txtMaSP_1;
	private JTextField txtTenSP_1;
	private JTextField txtGiaMua_1;
	private JTextField txtGiaBan_1;
	private JTextField txtSoLuong_1;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTable tblVanPhongPham;
	private JTextField txtTimKiem_1;
	private DefaultTableModel modelSach;
	private DefaultTableModel modelVPPham;
	private Dao_Sach sach_dao = new Dao_Sach();
	private Dao_VanPhongPham vpPham_dao = new Dao_VanPhongPham();
	private JTextField txtThueVAT;
	private JTextField txtThueVAT_1;

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
		txtGiaBan.setEditable(false);
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
		
		JPanel pnlMa_1 = new JPanel();
		pnlMa_1.setLayout(null);
		pnlMa_1.setBounds(10, 490, 302, 65);
		pnlThongTin.add(pnlMa_1);
		
		JLabel lblMaKeHang = new JLabel("Mã Kệ Hàng: ");
		lblMaKeHang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKeHang.setBounds(28, 10, 116, 22);
		pnlMa_1.add(lblMaKeHang);
		
		JComboBox cbMaKeHang = new JComboBox();
		cbMaKeHang.setModel(new DefaultComboBoxModel(new String[] {"KH001", "KH002", "KH003", "KH004", "KH005", "KH006", "KH007", "KH008"}));
		cbMaKeHang.setBounds(10, 35, 138, 24);
		pnlMa_1.add(cbMaKeHang);
		
		JLabel lblMaDanhMuc = new JLabel("Mã Danh Mục: ");
		lblMaDanhMuc.setBounds(166, 10, 136, 22);
		pnlMa_1.add(lblMaDanhMuc);
		lblMaDanhMuc.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JComboBox cbMaDanhMuc_1 = new JComboBox();
		cbMaDanhMuc_1.setBounds(158, 35, 138, 24);
		pnlMa_1.add(cbMaDanhMuc_1);
		cbMaDanhMuc_1.setModel(new DefaultComboBoxModel(new String[] {"DM001", "DM002", "DM003", "DM004", "DM005", "DM006", "DM007", "DM008"}));
		
		JPanel pnlMa_2 = new JPanel();
		pnlMa_2.setLayout(null);
		pnlMa_2.setBounds(10, 568, 302, 65);
		pnlThongTin.add(pnlMa_2);
		
		JLabel lblMaKhuyenMai = new JLabel("Mã Khuyến Mãi: ");
		lblMaKhuyenMai.setBounds(20, 10, 138, 22);
		pnlMa_2.add(lblMaKhuyenMai);
		lblMaKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JComboBox cbMaKhuyenMai_1 = new JComboBox();
		cbMaKhuyenMai_1.setBounds(10, 35, 138, 24);
		pnlMa_2.add(cbMaKhuyenMai_1);
		
		JLabel lblmaNCC = new JLabel("Mã NCC: ");
		lblmaNCC.setFont(new Font("Arial", Font.PLAIN, 18));
		lblmaNCC.setBounds(184, 10, 96, 22);
		pnlMa_2.add(lblmaNCC);
		
		JComboBox cbMaNCC = new JComboBox();
		cbMaNCC.setBounds(158, 35, 138, 24);
		pnlMa_2.add(cbMaNCC);
		
		JPanel pnlThueVAT = new JPanel();
		pnlThueVAT.setLayout(null);
		pnlThueVAT.setBounds(10, 646, 302, 65);
		pnlThongTin.add(pnlThueVAT);
		
		JLabel lblThueVAT = new JLabel("Thuế VAT: ");
		lblThueVAT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblThueVAT.setBounds(105, 10, 99, 22);
		pnlThueVAT.add(lblThueVAT);
		
		txtThueVAT = new JTextField();
		txtThueVAT.setColumns(10);
		txtThueVAT.setBounds(10, 35, 282, 24);
		pnlThueVAT.add(txtThueVAT);
		
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
		String[] tblS = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Giá mua", "Số lượng", "Giá bán", "Nhà xuất bản","Tác giả", "Năm xuất bản", "Số trang",
				"Thuế VAT","Mã Danh mục", "Mã kệ hàng","Mã khuyến mãi", "Mã nhà cung cấp" , "Tình trạng" };
				modelSach = new DefaultTableModel(tblS, 0);
				tblSach = new JTable(modelSach);
				tblSach.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
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
		
		JLabel lblMaSP_1 = new JLabel("Mã Sản Phẩm: ");
		lblMaSP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaSP_1.setBounds(90, 5, 128, 22);
		pnlMaSP_1.add(lblMaSP_1);
		
		txtMaSP_1 = new JTextField();
		txtMaSP_1.setEnabled(false);
		txtMaSP_1.setEditable(false);
		txtMaSP_1.setColumns(10);
		txtMaSP_1.setBounds(10, 35, 282, 24);
		pnlMaSP_1.add(txtMaSP_1);
		
		JPanel pnlTenSP_1 = new JPanel();
		pnlTenSP_1.setLayout(null);
		pnlTenSP_1.setBounds(10, 100, 302, 65);
		pnlThongTin_1.add(pnlTenSP_1);
		
		JLabel lblTenSP_1 = new JLabel("Tên Sản Phẩm: ");
		lblTenSP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenSP_1.setBounds(88, 5, 139, 22);
		pnlTenSP_1.add(lblTenSP_1);
		
		txtTenSP_1 = new JTextField();
		txtTenSP_1.setColumns(10);
		txtTenSP_1.setBounds(10, 35, 282, 24);
		pnlTenSP_1.add(txtTenSP_1);
		
		JPanel pnlGiaMua_1 = new JPanel();
		pnlGiaMua_1.setLayout(null);
		pnlGiaMua_1.setBounds(10, 178, 302, 65);
		pnlThongTin_1.add(pnlGiaMua_1);
		
		JLabel lblGiaMua_1 = new JLabel("Giá Mua: ");
		lblGiaMua_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaMua_1.setBounds(110, 5, 87, 22);
		pnlGiaMua_1.add(lblGiaMua_1);
		
		txtGiaMua_1 = new JTextField();
		txtGiaMua_1.setColumns(10);
		txtGiaMua_1.setBounds(10, 35, 282, 24);
		pnlGiaMua_1.add(txtGiaMua_1);
		
		JPanel pnlGiaBan_1 = new JPanel();
		pnlGiaBan_1.setLayout(null);
		pnlGiaBan_1.setBounds(10, 256, 302, 65);
		pnlThongTin_1.add(pnlGiaBan_1);
		
		JLabel lblGiaBan_1 = new JLabel("Giá Bán: ");
		lblGiaBan_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaBan_1.setBounds(111, 5, 87, 22);
		pnlGiaBan_1.add(lblGiaBan_1);
		
		txtGiaBan_1 = new JTextField();
		txtGiaBan_1.setColumns(10);
		txtGiaBan_1.setBounds(10, 35, 282, 24);
		pnlGiaBan_1.add(txtGiaBan_1);
		
		JPanel pnlSoLuong_1 = new JPanel();
		pnlSoLuong_1.setLayout(null);
		pnlSoLuong_1.setBounds(10, 334, 302, 65);
		pnlThongTin_1.add(pnlSoLuong_1);
		
		JLabel lblSoLuong_1 = new JLabel("Số Lượng: ");
		lblSoLuong_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoLuong_1.setBounds(105, 5, 99, 22);
		pnlSoLuong_1.add(lblSoLuong_1);
		
		txtSoLuong_1 = new JTextField();
		txtSoLuong_1.setEditable(false);
		txtSoLuong_1.setColumns(10);
		txtSoLuong_1.setBounds(10, 35, 282, 24);
		pnlSoLuong_1.add(txtSoLuong_1);
		
		JPanel pnlTinhTrang_1 = new JPanel();
		pnlTinhTrang_1.setLayout(null);
		pnlTinhTrang_1.setBounds(10, 412, 302, 65);
		pnlThongTin_1.add(pnlTinhTrang_1);
		
		JLabel lblTinhTrang_1 = new JLabel("Tinh Trạng: ");
		lblTinhTrang_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTinhTrang_1.setBounds(103, 5, 99, 22);
		pnlTinhTrang_1.add(lblTinhTrang_1);
		
		JComboBox cbTinhTrang_1 = new JComboBox();
		cbTinhTrang_1.setBounds(10, 35, 282, 24);
		pnlTinhTrang_1.add(cbTinhTrang_1);
		
		JPanel pnlMa_3 = new JPanel();
		pnlMa_3.setLayout(null);
		pnlMa_3.setBounds(10, 490, 302, 65);
		pnlThongTin_1.add(pnlMa_3);
		
		JLabel lblMaKeHang_1 = new JLabel("Mã Kệ Hàng: ");
		lblMaKeHang_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKeHang_1.setBounds(28, 10, 116, 22);
		pnlMa_3.add(lblMaKeHang_1);
		
		JComboBox cbMaKeHang_1 = new JComboBox();
		cbMaKeHang_1.setModel(new DefaultComboBoxModel(new String[] {"KH001", "KH002", "KH003", "KH004", "KH005", "KH006", "KH007", "KH008"}));
		cbMaKeHang_1.setBounds(10, 35, 138, 24);
		pnlMa_3.add(cbMaKeHang_1);
		
		JLabel lblMaDanhMuc_1 = new JLabel("Mã Danh Mục: ");
		lblMaDanhMuc_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaDanhMuc_1.setBounds(166, 10, 136, 22);
		pnlMa_3.add(lblMaDanhMuc_1);
		
		JComboBox cbMaDanhMuc_1_1 = new JComboBox();
		cbMaDanhMuc_1_1.setBounds(158, 35, 138, 24);
		pnlMa_3.add(cbMaDanhMuc_1_1);
		
		JPanel pnlMa_4 = new JPanel();
		pnlMa_4.setLayout(null);
		pnlMa_4.setBounds(10, 568, 302, 65);
		pnlThongTin_1.add(pnlMa_4);
		
		JLabel lblMaKhuyenMai_1 = new JLabel("Mã Khuyến Mãi: ");
		lblMaKhuyenMai_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKhuyenMai_1.setBounds(20, 10, 138, 22);
		pnlMa_4.add(lblMaKhuyenMai_1);
		
		JComboBox cbKhuyenMai_1 = new JComboBox();
		cbKhuyenMai_1.setBounds(10, 35, 138, 24);
		pnlMa_4.add(cbKhuyenMai_1);
		
		JLabel lblMaNCC_1 = new JLabel("Mã NCC: ");
		lblMaNCC_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaNCC_1.setBounds(184, 10, 96, 22);
		pnlMa_4.add(lblMaNCC_1);
		
		JComboBox cbMaNCC_1 = new JComboBox();
		cbMaNCC_1.setBounds(158, 35, 138, 24);
		pnlMa_4.add(cbMaNCC_1);
		
		JPanel pnlThueVAT_1 = new JPanel();
		pnlThueVAT_1.setLayout(null);
		pnlThueVAT_1.setBounds(10, 646, 302, 65);
		pnlThongTin_1.add(pnlThueVAT_1);
		
		JLabel lblThueVAT_1 = new JLabel("Thuế VAT:");
		lblThueVAT_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblThueVAT_1.setBounds(105, 10, 99, 22);
		pnlThueVAT_1.add(lblThueVAT_1);
		
		txtThueVAT_1 = new JTextField();
		txtThueVAT_1.setColumns(10);
		txtThueVAT_1.setBounds(10, 35, 282, 24);
		pnlThueVAT_1.add(txtThueVAT_1);
		
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
		
		String[] tblVP = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Giá mua", "Số lượng", "Giá bán", "Thương hiệu","Xuất xứ", "Màu sắc", "Chất liệu",
				"Thuế VAT","Mã Danh mục", "Mã kệ hàng","Mã khuyến mãi", "Mã nhà cung cấp", "Tình trạng" };
				modelVPPham = new DefaultTableModel(tblVP, 0);
				tblVanPhongPham = new JTable(modelVPPham);
				tblVanPhongPham.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				scrollPane_1.setViewportView(tblVanPhongPham);
				
				
				
		loadDataSach(sach_dao.getAllSanPhamSach());	
		loadDataVPPham(vpPham_dao.getAllSanPhamVanPhong());
				
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
	
	//hàm load dữ liệu lên tab sách
	public void loadDataSach(ArrayList<Sach> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblSach.getModel();
		dm.getDataVector().removeAllElements();
		for (Sach s : ds) {
			modelSach.addRow(new Object[] {
		            getValueOrDefault(s.getMaSP(), "x"),
		            getValueOrDefault(s.getTenSP(), "x"),
		            getValueOrDefault(s.getGiaMua(), "x"),
		            getValueOrDefault(s.getSoLuong(), "x"),
		            getValueOrDefault(s.getGiaBan(), "x"),
		            getValueOrDefault(s.getNhaXB(), "x"),
		            getValueOrDefault(s.getTacGia(), "x"),
		            getValueOrDefault(s.getNamXB(), "x"),
		            getValueOrDefault(s.getSoTrang(), "x"),
		            getValueOrDefault(s.getThueVAT(), "x"),
		            getValueOrDefault(s.getMaDanhMuc().getMaDanhMuc(), "x"),
		            getValueOrDefault(s.getMaKeHang().getMaKeHang(), "x"),
		            getValueOrDefault(s.getMaKhuyenMai().getMaKhuyenMai(), "x"),
		            getValueOrDefault(s.getMaNhaCungCap().getMaNhaCungCap(), "x"),
		            getValueOrDefault(s.getTinhTrang(), "x")
		        });
		}
	}

	//hàm lấy giá trị mặc định nếu là null
	private Object getValueOrDefault(Object value, Object defaultValue) {
	    return (value != null) ? value : defaultValue;
	}
	
	//hàm load dữ liệu lên tab văn phòng phẩm
	public void loadDataVPPham(ArrayList<VanPhongPham> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblVanPhongPham.getModel();
		dm.getDataVector().removeAllElements();
		for (VanPhongPham vpp : ds) {
			modelVPPham.addRow(new Object[] {
		            getValueOrDefault(vpp.getMaSP(), "x"),
		            getValueOrDefault(vpp.getTenSP(), "x"),
		            getValueOrDefault(vpp.getGiaMua(), "x"),
		            getValueOrDefault(vpp.getSoLuong(), "x"),
		            getValueOrDefault(vpp.getGiaBan(), "x"),
		            getValueOrDefault(vpp.getThuongHieu(), "x"),
		            getValueOrDefault(vpp.getXuatXu(), "x"),
		            getValueOrDefault(vpp.getMauSac(), "x"),
		            getValueOrDefault(vpp.getChatLieu(), "x"),
		            getValueOrDefault(vpp.getThueVAT(), "x"),
		            getValueOrDefault(vpp.getMaDanhMuc().getMaDanhMuc(), "x"),
		            getValueOrDefault(vpp.getMaKeHang().getMaKeHang(), "x"),
		            getValueOrDefault(vpp.getMaKhuyenMai().getMaKhuyenMai(), "x"),
		            getValueOrDefault(vpp.getMaNhaCungCap().getMaNhaCungCap(), "x"),
		            getValueOrDefault(vpp.getTinhTrang(), "x")
		        });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
