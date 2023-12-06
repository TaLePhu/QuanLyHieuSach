package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Dao_DanhMuc;
import dao.Dao_KeHang;
import dao.Dao_KhuyenMai;
import dao.Dao_NhaCungCap;
import dao.Dao_Sach;
import dao.Dao_VanPhongPham;
import entity.DanhMuc;
import entity.KeHang;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.Sach;
import entity.VanPhongPham;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class pnlSanPham extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final float inc = (float) 1.30;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtGiaMuaSach;
	private JTextField txtGiaBanSach;
	private JTextField txtSoLuongSach;
	private JTextField txtTacGia;
	private JTextField txtNhaXuatBan;
	private JTextField txtNamXB;
	private JTextField txtSoTrang;
	private JComboBox<String> cbTinhTrangSach;
	private JComboBox<String> cbMaKeHangSach;
	private JComboBox<String> cbMaKhuyenMaiSach;
	private JComboBox<String> cbMaDanhMucSach;
	private JComboBox<String> cbMaNhaCungCapSach;
	private JComboBox<String> cbTinhTrangVPP;
	private JComboBox<String> cbMaKeHangVPP;
	private JComboBox<String> cbMaDanhMucVPP;
	private JComboBox<String> cbMaKhuyenMaiVPP;
	private JComboBox<String> cbMaNhaCungCapVPP;
	 
	private JTextField txtTimKiemSach;
	private JCheckBox chkTimTheoTacGia ;
	private JTable tblSach;
	private JTextField txtMaVanPhongPham;
	private JTextField txtTenVanPhongPham;
	private JTextField txtGiaMuaVPP;
	private JTextField txtGiaBanVPP;
	private JTextField txtSoLuongVPP;
	private JTextField txtThuongHieu;
	private JTextField txtXuatXu;
	private JTextField txtMauSac;
	private JTextField txtChatLieu;
	private JTable tblVanPhongPham;
	private JTextField txtTimKiemVPP;
	private DefaultTableModel modelSach;
	private DefaultTableModel modelVPPham;
	private Dao_Sach sach_dao = new Dao_Sach();
	private Dao_VanPhongPham vanPhongPham_dao = new Dao_VanPhongPham();
	private Dao_KeHang keHang_dao = new Dao_KeHang();
	private Dao_KhuyenMai khuyenMai_dao = new Dao_KhuyenMai();
	private Dao_DanhMuc danhMuc_dao = new Dao_DanhMuc();
	private Dao_NhaCungCap nhaCungCap_dao = new Dao_NhaCungCap();
	private JTextField txtThueVATSach;
	private JTextField txtThueVATVPP;
	
	private JButton btnLamMoiSach, btnThemSach, btnCapNhatSach, btnTimKiemSach, btnLamMoiVPP, btnThemVPP, btnCapNhatVPP, btnTimKiemVPP;
	private JTextField txtMessageSach;
	private JTextField txtMessageVPP;
	private JTextField txtMaKeHang;
	private JTextField txtTenKeHang;
	private JTextField txtViTri;
	private JTextField txtSucChua;
	private JTextField txtMessageKeHang;
	private JTextField txtTimKiemKeHang;
	private JComboBox<String> cbTinhTrangKeHang;
	private JButton btnTaoMoiKeHang, btnThemKeHang,btnCapNhatKeHang,btnTimKiemKeHang;
	private JTable tblKeHang;
	private DefaultTableModel modelKeHang;
	private JTextField txtMaDanhMuc;
	private JTextField txtTenDanhMuc;
	private JTextField txtMessageDanhMuc;
	private JTextField txtTimKiemDanhMuc;
	private JTable tblDanhMuc;
	private DefaultTableModel modelDanhMuc;
	private JButton btnTaoMoiDanhMuc, btnThemDanhMuc,btnCapNhatDanhMuc,btnTimKiemDanhMuc;
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
		pnlThongTin.setBounds(10, 10, 262, 716);
		pnlSach.add(pnlThongTin);
		pnlThongTin.setLayout(null);
		
		JPanel pnlMaSP = new JPanel();
		pnlMaSP.setBounds(10, 22, 240, 65);
		pnlThongTin.add(pnlMaSP);
		pnlMaSP.setLayout(null);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm: ");
		lblMaSP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaSP.setBounds(10, 5, 128, 22);
		pnlMaSP.add(lblMaSP);
		
		txtMaSach = new JTextField();
		txtMaSach.setEnabled(false);
		txtMaSach.setEditable(false);
		txtMaSach.setBounds(10, 35, 220, 24);
		pnlMaSP.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JPanel pnlTenSach = new JPanel();
		pnlTenSach.setLayout(null);
		pnlTenSach.setBounds(10, 100, 240, 65);
		pnlThongTin.add(pnlTenSach);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm: ");
		lblTenSP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenSP.setBounds(10, 5, 139, 22);
		pnlTenSach.add(lblTenSP);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(10, 35, 220, 24);
		pnlTenSach.add(txtTenSach);
		
		JPanel pnlGiaMua = new JPanel();
		pnlGiaMua.setLayout(null);
		pnlGiaMua.setBounds(10, 178, 240, 65);
		pnlThongTin.add(pnlGiaMua);
		
		JLabel lblGiaMua = new JLabel("Giá Mua: ");
		lblGiaMua.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaMua.setBounds(10, 5, 87, 22);
		pnlGiaMua.add(lblGiaMua);
		
		txtGiaMuaSach = new JTextField();
		txtGiaMuaSach.setColumns(10);
		txtGiaMuaSach.setBounds(10, 35, 220, 24);
		pnlGiaMua.add(txtGiaMuaSach);
		
		JPanel pnlGiaBan = new JPanel();
		pnlGiaBan.setLayout(null);
		pnlGiaBan.setBounds(10, 256, 240, 65);
		pnlThongTin.add(pnlGiaBan);
		
		JLabel lblGiaBan = new JLabel("Giá Bán: ");
		lblGiaBan.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaBan.setBounds(10, 5, 87, 22);
		pnlGiaBan.add(lblGiaBan);
		
		txtGiaBanSach = new JTextField();
		txtGiaBanSach.setEditable(false);
		txtGiaBanSach.setColumns(10);
		txtGiaBanSach.setBounds(10, 35, 220, 24);
		pnlGiaBan.add(txtGiaBanSach);
		
		JPanel pnlSoLuong = new JPanel();
		pnlSoLuong.setLayout(null);
		pnlSoLuong.setBounds(10, 334, 240, 65);
		pnlThongTin.add(pnlSoLuong);
		
		JLabel lblSoLuong = new JLabel("Số Lượng: ");
		lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoLuong.setBounds(10, 5, 99, 22);
		pnlSoLuong.add(lblSoLuong);
		
		txtSoLuongSach = new JTextField();
		txtSoLuongSach.setColumns(10);
		txtSoLuongSach.setBounds(10, 35, 220, 24);
		pnlSoLuong.add(txtSoLuongSach);
		
		JPanel pnlTinhTrang = new JPanel();
		pnlTinhTrang.setLayout(null);
		pnlTinhTrang.setBounds(10, 412, 240, 65);
		pnlThongTin.add(pnlTinhTrang);
		
		JLabel lblTinhTrang = new JLabel("Tinh Trạng: ");
		lblTinhTrang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTinhTrang.setBounds(10, 5, 99, 22);
		pnlTinhTrang.add(lblTinhTrang);
		
		cbTinhTrangSach = new JComboBox();
		cbTinhTrangSach.setModel(new DefaultComboBoxModel(new String[] {"Đang bán", "Ngưng bán"}));
		cbTinhTrangSach.setBounds(10, 35, 220, 24);
		pnlTinhTrang.add(cbTinhTrangSach);
		
		JPanel pnlMa_1 = new JPanel();
		pnlMa_1.setLayout(null);
		pnlMa_1.setBounds(10, 490, 240, 65);
		pnlThongTin.add(pnlMa_1);
		
		JLabel lblMaKeHang = new JLabel("Mã Kệ Hàng: ");
		lblMaKeHang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKeHang.setBounds(10, 10, 116, 22);
		pnlMa_1.add(lblMaKeHang);
		
		cbMaKeHangSach = new JComboBox();
		cbMaKeHangSach.setBounds(10, 35, 100, 24);
		pnlMa_1.add(cbMaKeHangSach);
		
		JLabel lblMaDanhMuc = new JLabel("Mã Danh Mục: ");
		lblMaDanhMuc.setBounds(122, 10, 122, 22);
		pnlMa_1.add(lblMaDanhMuc);
		lblMaDanhMuc.setFont(new Font("Arial", Font.PLAIN, 18));
		
		cbMaDanhMucSach = new JComboBox();
		cbMaDanhMucSach.setBounds(130, 35, 100, 24);
		pnlMa_1.add(cbMaDanhMucSach);
		
		JPanel pnlMa_2 = new JPanel();
		pnlMa_2.setLayout(null);
		pnlMa_2.setBounds(10, 568, 240, 65);
		pnlThongTin.add(pnlMa_2);
		
		JLabel lblMaKhuyenMai = new JLabel("Mã Khuyến Mãi: ");
		lblMaKhuyenMai.setBounds(5, 10, 134, 22);
		pnlMa_2.add(lblMaKhuyenMai);
		lblMaKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 18));
		
		cbMaKhuyenMaiSach = new JComboBox<String>();
		cbMaKhuyenMaiSach.setBounds(10, 35, 100, 24);
		pnlMa_2.add(cbMaKhuyenMaiSach);
		
		JLabel lblmaNCC = new JLabel("Mã NCC: ");
		lblmaNCC.setFont(new Font("Arial", Font.PLAIN, 18));
		lblmaNCC.setBounds(140, 10, 96, 22);
		pnlMa_2.add(lblmaNCC);
		
		cbMaNhaCungCapSach = new JComboBox<String>();
		cbMaNhaCungCapSach.setBounds(130, 35, 100, 24);
		pnlMa_2.add(cbMaNhaCungCapSach);
		
		JPanel pnlThueVAT = new JPanel();
		pnlThueVAT.setLayout(null);
		pnlThueVAT.setBounds(10, 646, 240, 65);
		pnlThongTin.add(pnlThueVAT);
		
		JLabel lblThueVAT = new JLabel("Thuế VAT: ");
		lblThueVAT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblThueVAT.setBounds(10, 10, 99, 22);
		pnlThueVAT.add(lblThueVAT);
		
		txtThueVATSach = new JTextField();
		txtThueVATSach.setColumns(10);
		txtThueVATSach.setBounds(10, 35, 220, 24);
		pnlThueVAT.add(txtThueVATSach);
		
		JPanel pnlThongTinSach = new JPanel();
		pnlThongTinSach.setBorder(new TitledBorder(null, "Th\u00F4ng tin S\u00E1ch: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSach.setBounds(275, 10, 875, 147);
		pnlSach.add(pnlThongTinSach);
		pnlThongTinSach.setLayout(null);
		
		JPanel pnlChiTiet = new JPanel();
		pnlChiTiet.setLayout(null);
		pnlChiTiet.setBounds(10, 20, 786, 110);
		pnlThongTinSach.add(pnlChiTiet);
		
		JLabel lblTacGia = new JLabel("Tác Giả:");
		lblTacGia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTacGia.setBounds(23, 10, 77, 22);
		pnlChiTiet.add(lblTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(178, 8, 200, 24);
		pnlChiTiet.add(txtTacGia);
		
		JLabel lblNhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblNhaXuatBan.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNhaXuatBan.setBounds(23, 42, 132, 22);
		pnlChiTiet.add(lblNhaXuatBan);
		
		txtNhaXuatBan = new JTextField();
		txtNhaXuatBan.setColumns(10);
		txtNhaXuatBan.setBounds(178, 42, 200, 24);
		pnlChiTiet.add(txtNhaXuatBan);
		
		JLabel lblNamXB = new JLabel("Năm Xuất Bản: ");
		lblNamXB.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNamXB.setBounds(418, 10, 132, 22);
		pnlChiTiet.add(lblNamXB);
		
		txtNamXB = new JTextField();
		txtNamXB.setColumns(10);
		txtNamXB.setBounds(576, 8, 200, 24);
		pnlChiTiet.add(txtNamXB);
		
		JLabel lblSoTrang = new JLabel("Số Trang: ");
		lblSoTrang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoTrang.setBounds(418, 42, 96, 22);
		pnlChiTiet.add(lblSoTrang);
		
		txtSoTrang = new JTextField();
		txtSoTrang.setColumns(10);
		txtSoTrang.setBounds(576, 44, 200, 24);
		pnlChiTiet.add(txtSoTrang);
		
		txtMessageSach = new JTextField();
		txtMessageSach.setBounds(23, 74, 753, 26);
		pnlChiTiet.add(txtMessageSach);
		txtMessageSach.setColumns(10);
		txtMessageSach.setBorder(null);
		txtMessageSach.setEditable(false);
		txtMessageSach.setToolTipText("");
		txtMessageSach.setFont(new Font("Arial", Font.ITALIC, 14));
		txtMessageSach.setBackground(new Color(240, 240, 240));
		txtMessageSach.setText("");
		txtMessageSach.setForeground(new Color(255, 0, 0));
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBounds(275, 167, 875, 175);
		pnlSach.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		btnLamMoiSach = new JButton("Làm mới");
		btnLamMoiSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoiSach.setBounds(32, 27, 160, 56);
		pnlChucNang.add(btnLamMoiSach);
		Image img_iconLamMoi = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnLamMoiSach.setIcon(new ImageIcon(img_iconLamMoi));
		
		btnThemSach = new JButton("Thêm");
		btnThemSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemSach.setBounds(32, 93, 337, 56);
		pnlChucNang.add(btnThemSach);
		Image img_iconthem = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnThemSach.setIcon(new ImageIcon(img_iconthem));
		
		btnCapNhatSach = new JButton("Cập Nhật");
		btnCapNhatSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatSach.setBounds(209, 27, 160, 56);
		pnlChucNang.add(btnCapNhatSach);
		Image img_iconCapNhat = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
		btnCapNhatSach.setIcon(new ImageIcon(img_iconCapNhat));
		
		JLabel lblTimKiemSP = new JLabel("Tìm kiếm theo tên sách:");
		lblTimKiemSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiemSP.setBounds(441, 59, 231, 22);
		pnlChucNang.add(lblTimKiemSP);
		
		txtTimKiemSach = new JTextField();
		txtTimKiemSach.setColumns(10);
		txtTimKiemSach.setBounds(441, 91, 231, 24);
		pnlChucNang.add(txtTimKiemSach);
		
		btnTimKiemSach = new JButton("");
		btnTimKiemSach.setBounds(698, 59, 68, 56);
		pnlChucNang.add(btnTimKiemSach);
		Image img_iconTimKiem = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		btnTimKiemSach.setIcon(new ImageIcon(img_iconTimKiem));
		
		chkTimTheoTacGia = new JCheckBox("Tìm kiếm theo tên tác giả");
		chkTimTheoTacGia.setBounds(441, 128, 188, 21);
		pnlChucNang.add(chkTimTheoTacGia);
		
		JPanel pnlDsSP = new JPanel();
		pnlDsSP.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDsSP.setBounds(275, 352, 875, 374);
		pnlSach.add(pnlDsSP);
		pnlDsSP.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(4, 21, 865, 343);
		pnlDsSP.add(scrollPane);
		
//		tblSach = new JTable();
		String[] tblS = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Giá mua", "Số lượng", "Giá bán", "Nhà xuất bản","Tác giả", "Năm xuất bản", "Số trang",
				"Thuế VAT","Mã Danh mục", "Mã kệ hàng","Mã khuyến mãi", "Mã nhà cung cấp" , "Tình trạng" };
				modelSach = new DefaultTableModel(tblS, 0);
				tblSach = new JTable(modelSach);
				tblSach.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scrollPane.setViewportView(tblSach);
				
		tblSach.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int r = tblSach.getSelectedRow();
			fillForm(r);
			}
		});		
		
		JPanel pnlVanPhongPham = new JPanel();
		pnlVanPhongPham.setLayout(null);
		tabbedPane.addTab("Văn Phòng Phẩm", null, pnlVanPhongPham, null);
		
		JPanel pnlThongTin_1 = new JPanel();
		pnlThongTin_1.setLayout(null);
		pnlThongTin_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTin_1.setBounds(10, 10, 262, 716);
		pnlVanPhongPham.add(pnlThongTin_1);
		
		JPanel pnlMaSP_1 = new JPanel();
		pnlMaSP_1.setLayout(null);
		pnlMaSP_1.setBounds(10, 22, 240, 65);
		pnlThongTin_1.add(pnlMaSP_1);
		
		JLabel lblMaSP_1 = new JLabel("Mã Sản Phẩm: ");
		lblMaSP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaSP_1.setBounds(10, 5, 128, 22);
		pnlMaSP_1.add(lblMaSP_1);
		
		txtMaVanPhongPham = new JTextField();
		txtMaVanPhongPham.setEnabled(false);
		txtMaVanPhongPham.setEditable(false);
		txtMaVanPhongPham.setColumns(10);
		txtMaVanPhongPham.setBounds(10, 35, 220, 24);
		pnlMaSP_1.add(txtMaVanPhongPham);
		
		JPanel pnlTenSP_1 = new JPanel();
		pnlTenSP_1.setLayout(null);
		pnlTenSP_1.setBounds(10, 100, 240, 65);
		pnlThongTin_1.add(pnlTenSP_1);
		
		JLabel lblTenSP_1 = new JLabel("Tên Sản Phẩm: ");
		lblTenSP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenSP_1.setBounds(10, 5, 139, 22);
		pnlTenSP_1.add(lblTenSP_1);
		
		txtTenVanPhongPham = new JTextField();
		txtTenVanPhongPham.setColumns(10);
		txtTenVanPhongPham.setBounds(10, 35, 220, 24);
		pnlTenSP_1.add(txtTenVanPhongPham);
		
		JPanel pnlGiaMua_1 = new JPanel();
		pnlGiaMua_1.setLayout(null);
		pnlGiaMua_1.setBounds(10, 178, 240, 65);
		pnlThongTin_1.add(pnlGiaMua_1);
		
		JLabel lblGiaMua_1 = new JLabel("Giá Mua: ");
		lblGiaMua_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaMua_1.setBounds(10, 5, 87, 22);
		pnlGiaMua_1.add(lblGiaMua_1);
		
		txtGiaMuaVPP = new JTextField();
		txtGiaMuaVPP.setColumns(10);
		txtGiaMuaVPP.setBounds(10, 35, 220, 24);
		pnlGiaMua_1.add(txtGiaMuaVPP);
		
		JPanel pnlGiaBan_1 = new JPanel();
		pnlGiaBan_1.setLayout(null);
		pnlGiaBan_1.setBounds(10, 256, 240, 65);
		pnlThongTin_1.add(pnlGiaBan_1);
		
		JLabel lblGiaBan_1 = new JLabel("Giá Bán: ");
		lblGiaBan_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaBan_1.setBounds(10, 5, 87, 22);
		pnlGiaBan_1.add(lblGiaBan_1);
		
		txtGiaBanVPP = new JTextField();
		txtGiaBanVPP.setColumns(10);
		txtGiaBanVPP.setEditable(false);
		txtGiaBanVPP.setBounds(10, 35, 220, 24);
		pnlGiaBan_1.add(txtGiaBanVPP);
		
		JPanel pnlSoLuong_1 = new JPanel();
		pnlSoLuong_1.setLayout(null);
		pnlSoLuong_1.setBounds(10, 334, 240, 65);
		pnlThongTin_1.add(pnlSoLuong_1);
		
		JLabel lblSoLuong_1 = new JLabel("Số Lượng: ");
		lblSoLuong_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoLuong_1.setBounds(10, 5, 99, 22);
		pnlSoLuong_1.add(lblSoLuong_1);
		
		txtSoLuongVPP = new JTextField();
		txtSoLuongVPP.setColumns(10);
		txtSoLuongVPP.setBounds(10, 35, 220, 24);
		pnlSoLuong_1.add(txtSoLuongVPP);
		
		JPanel pnlTinhTrang_1 = new JPanel();
		pnlTinhTrang_1.setLayout(null);
		pnlTinhTrang_1.setBounds(10, 412, 240, 65);
		pnlThongTin_1.add(pnlTinhTrang_1);
		
		JLabel lblTinhTrang_1 = new JLabel("Tinh Trạng: ");
		lblTinhTrang_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTinhTrang_1.setBounds(10, 5, 99, 22);
		pnlTinhTrang_1.add(lblTinhTrang_1);
		
		cbTinhTrangVPP = new JComboBox();
		cbTinhTrangVPP.setModel(new DefaultComboBoxModel(new String[] {"Đang bán", "Ngưng bán"}));
		cbTinhTrangVPP.setBounds(10, 35, 220, 24);
		pnlTinhTrang_1.add(cbTinhTrangVPP);
		
		JPanel pnlMa_3 = new JPanel();
		pnlMa_3.setLayout(null);
		pnlMa_3.setBounds(10, 490, 240, 65);
		pnlThongTin_1.add(pnlMa_3);
		
		JLabel lblMaKeHang_1 = new JLabel("Mã Kệ Hàng: ");
		lblMaKeHang_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKeHang_1.setBounds(10, 10, 116, 22);
		pnlMa_3.add(lblMaKeHang_1);
		
		cbMaKeHangVPP = new JComboBox();
		cbMaKeHangVPP.setBounds(10, 35, 100, 24);
		pnlMa_3.add(cbMaKeHangVPP);
		
		JLabel lblMaDanhMuc_1 = new JLabel("Mã Danh Mục: ");
		lblMaDanhMuc_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaDanhMuc_1.setBounds(122, 10, 122, 22);
		pnlMa_3.add(lblMaDanhMuc_1);
		
		cbMaDanhMucVPP = new JComboBox();
		cbMaDanhMucVPP.setBounds(130, 35, 100, 24);
		pnlMa_3.add(cbMaDanhMucVPP);
		
		JPanel pnlMa_4 = new JPanel();
		pnlMa_4.setLayout(null);
		pnlMa_4.setBounds(10, 568, 240, 65);
		pnlThongTin_1.add(pnlMa_4);
		
		JLabel lblMaKhuyenMai_1 = new JLabel("Mã Khuyến Mãi: ");
		lblMaKhuyenMai_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKhuyenMai_1.setBounds(5, 10, 134, 22);
		pnlMa_4.add(lblMaKhuyenMai_1);
		
		cbMaKhuyenMaiVPP = new JComboBox();
		cbMaKhuyenMaiVPP.setBounds(10, 35, 100, 24);
		pnlMa_4.add(cbMaKhuyenMaiVPP);
		
		JLabel lblMaNCC_1 = new JLabel("Mã NCC: ");
		lblMaNCC_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaNCC_1.setBounds(140, 10, 96, 22);
		pnlMa_4.add(lblMaNCC_1);
		
		cbMaNhaCungCapVPP = new JComboBox();
		cbMaNhaCungCapVPP.setBounds(130, 35, 100, 24);
		pnlMa_4.add(cbMaNhaCungCapVPP);
		
		JPanel pnlThueVAT_1 = new JPanel();
		pnlThueVAT_1.setLayout(null);
		pnlThueVAT_1.setBounds(10, 646, 240, 65);
		pnlThongTin_1.add(pnlThueVAT_1);
		
		JLabel lblThueVAT_1 = new JLabel("Thuế VAT:");
		lblThueVAT_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblThueVAT_1.setBounds(105, 10, 99, 22);
		pnlThueVAT_1.add(lblThueVAT_1);
		
		txtThueVATVPP = new JTextField();
		txtThueVATVPP.setColumns(10);
		txtThueVATVPP.setBounds(10, 35, 220, 24);
		pnlThueVAT_1.add(txtThueVATVPP);
		
		JPanel pnlThongTinVanPhongPham = new JPanel();
		pnlThongTinVanPhongPham.setLayout(null);
		pnlThongTinVanPhongPham.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin V\u0103n Ph\u00F2ng Ph\u1EA9m: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlThongTinVanPhongPham.setBounds(275, 10, 875, 147);
		pnlVanPhongPham.add(pnlThongTinVanPhongPham);
		
		JPanel pnlChiTiet_1 = new JPanel();
		pnlChiTiet_1.setLayout(null);
		pnlChiTiet_1.setBounds(10, 20, 786, 110);
		pnlThongTinVanPhongPham.add(pnlChiTiet_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Thương Hiệu:");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_4.setBounds(20, 10, 111, 22);
		pnlChiTiet_1.add(lblNewLabel_2_4);
		
		txtThuongHieu = new JTextField();
		txtThuongHieu.setColumns(10);
		txtThuongHieu.setBounds(178, 10, 200, 24);
		pnlChiTiet_1.add(txtThuongHieu);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Xuất xứ:");
		lblNewLabel_2_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(20, 48, 132, 22);
		pnlChiTiet_1.add(lblNewLabel_2_1_2);
		
		txtXuatXu = new JTextField();
		txtXuatXu.setColumns(10);
		txtXuatXu.setBounds(178, 44, 200, 24);
		pnlChiTiet_1.add(txtXuatXu);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Màu Sắc: ");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(418, 10, 132, 22);
		pnlChiTiet_1.add(lblNewLabel_2_2_1);
		
		txtMauSac = new JTextField();
		txtMauSac.setColumns(10);
		txtMauSac.setBounds(576, 10, 200, 24);
		pnlChiTiet_1.add(txtMauSac);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Chất liệu: ");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_3_1.setBounds(418, 48, 96, 22);
		pnlChiTiet_1.add(lblNewLabel_2_3_1);
		
		txtChatLieu = new JTextField();
		txtChatLieu.setColumns(10);
		txtChatLieu.setBounds(576, 44, 200, 24);
		pnlChiTiet_1.add(txtChatLieu);
		
		txtMessageVPP = new JTextField();
		txtMessageVPP.setBounds(20, 78, 756, 22);
		pnlChiTiet_1.add(txtMessageVPP);
		txtMessageVPP.setColumns(10);
		txtMessageVPP.setBorder(null);
		txtMessageVPP.setEditable(false);
		txtMessageVPP.setToolTipText("");
		txtMessageVPP.setFont(new Font("Arial", Font.ITALIC, 14));
		txtMessageVPP.setBackground(new Color(240, 240, 240));
		txtMessageVPP.setText("");
		txtMessageVPP.setForeground(new Color(255, 0, 0));
		
		JPanel pnlChucNang_1 = new JPanel();
		pnlChucNang_1.setLayout(null);
		pnlChucNang_1.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang_1.setBounds(275, 167, 875, 175);
		pnlVanPhongPham.add(pnlChucNang_1);
		
		btnLamMoiVPP = new JButton("Làm mới");
		btnLamMoiVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoiVPP.setBounds(32, 27, 160, 56);
		pnlChucNang_1.add(btnLamMoiVPP);
		Image img_iconLamMoi_1 = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnLamMoiVPP.setIcon(new ImageIcon(img_iconLamMoi_1));
		
		btnThemVPP = new JButton("Thêm");
		btnThemVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemVPP.setBounds(32, 93, 337, 56);
		pnlChucNang_1.add(btnThemVPP);
		Image img_iconthem_2 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnThemVPP.setIcon(new ImageIcon(img_iconthem_2));
		
		btnCapNhatVPP = new JButton("Cập Nhật");
		btnCapNhatVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatVPP.setBounds(209, 27, 160, 56);
		pnlChucNang_1.add(btnCapNhatVPP);
		Image img_iconCapNhat_1 = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
		btnCapNhatVPP.setIcon(new ImageIcon(img_iconCapNhat_1));
		
		JLabel lblTimKiemSP_1 = new JLabel("Tìm kiếm theo tên văn phòng phẩm:");
		lblTimKiemSP_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiemSP_1.setBounds(413, 61, 275, 22);
		pnlChucNang_1.add(lblTimKiemSP_1);
		
		txtTimKiemVPP = new JTextField();
		txtTimKiemVPP.setColumns(10);
		txtTimKiemVPP.setBounds(413, 91, 275, 24);
		pnlChucNang_1.add(txtTimKiemVPP);
		
		btnTimKiemVPP = new JButton("");
		btnTimKiemVPP.setBounds(698, 59, 68, 56);
		pnlChucNang_1.add(btnTimKiemVPP);
		Image img_iconTimKiem_1 = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		btnTimKiemVPP.setIcon(new ImageIcon(img_iconTimKiem_1));
		
		
		JPanel pnlDsSP_1 = new JPanel();
		pnlDsSP_1.setLayout(null);
		pnlDsSP_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDsSP_1.setBounds(275, 352, 875, 374);
		pnlVanPhongPham.add(pnlDsSP_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(4, 21, 865, 343);
		pnlDsSP_1.add(scrollPane_1);
		
		String[] tblVP = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Giá mua", "Số lượng", "Giá bán", "Thương hiệu","Xuất xứ", "Màu sắc", "Chất liệu",
				"Thuế VAT","Mã Danh mục", "Mã kệ hàng","Mã khuyến mãi", "Mã nhà cung cấp", "Tình trạng" };
				modelVPPham = new DefaultTableModel(tblVP, 0);
				tblVanPhongPham = new JTable(modelVPPham);
				tblVanPhongPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scrollPane_1.setViewportView(tblVanPhongPham);
				tblVanPhongPham.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int r = tblVanPhongPham.getSelectedRow();
						fillFormVPP(r);
						}
					});		
				
				JPanel pnlKeHang = new JPanel();
				tabbedPane.addTab("Kệ hàng", null, pnlKeHang, null);
				pnlKeHang.setLayout(null);
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin k\u1EC7 h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 10, 1128, 152);
				pnlKeHang.add(panel_1);
				
				JLabel lblMKHng = new JLabel("Mã kệ hàng:");
				lblMKHng.setFont(new Font("Arial", Font.BOLD, 12));
				lblMKHng.setBounds(24, 28, 76, 22);
				panel_1.add(lblMKHng);
				
				JLabel lblTnKHng = new JLabel("Tên kệ hàng:");
				lblTnKHng.setFont(new Font("Arial", Font.BOLD, 12));
				lblTnKHng.setBounds(545, 28, 74, 22);
				panel_1.add(lblTnKHng);
				
				txtMaKeHang = new JTextField();
				txtMaKeHang.setEnabled(false);
				txtMaKeHang.setEditable(false);
				txtMaKeHang.setColumns(10);
				txtMaKeHang.setBounds(110, 30, 373, 19);
				panel_1.add(txtMaKeHang);
				
				txtTenKeHang = new JTextField();
				txtTenKeHang.setColumns(10);
				txtTenKeHang.setBounds(629, 30, 489, 19);
				panel_1.add(txtTenKeHang);
				
				JLabel lblVTr = new JLabel("Vị trí:");
				lblVTr.setFont(new Font("Arial", Font.BOLD, 12));
				lblVTr.setBounds(24, 71, 45, 22);
				panel_1.add(lblVTr);
				
				txtViTri = new JTextField();
				txtViTri.setColumns(10);
				txtViTri.setBounds(107, 73, 207, 19);
				panel_1.add(txtViTri);
				
				JLabel lblScCha = new JLabel("Sức chứa:");
				lblScCha.setFont(new Font("Arial", Font.BOLD, 12));
				lblScCha.setBounds(338, 71, 76, 22);
				panel_1.add(lblScCha);
				
				txtSucChua = new JTextField();
				txtSucChua.setColumns(10);
				txtSucChua.setBounds(424, 73, 59, 19);
				panel_1.add(txtSucChua);
				
				JLabel lblTnhTrng = new JLabel("Tình trạng:");
				lblTnhTrng.setFont(new Font("Arial", Font.BOLD, 12));
				lblTnhTrng.setBounds(545, 71, 68, 22);
				panel_1.add(lblTnhTrng);
				
				cbTinhTrangKeHang = new JComboBox();
				cbTinhTrangKeHang.setModel(new DefaultComboBoxModel(new String[] {"Còn trống", "Đầy đủ", "Ngưng sử dụng"}));
				cbTinhTrangKeHang.setBounds(629, 72, 489, 21);
				panel_1.add(cbTinhTrangKeHang);
				
				txtMessageKeHang = new JTextField();
				txtMessageKeHang.setToolTipText("");
				txtMessageKeHang.setText("");
				txtMessageKeHang.setForeground(Color.RED);
				txtMessageKeHang.setFont(new Font("Arial", Font.ITALIC, 14));
				txtMessageKeHang.setEditable(false);
				txtMessageKeHang.setColumns(10);
				txtMessageKeHang.setBorder(null);
				txtMessageKeHang.setBackground(UIManager.getColor("Button.background"));
				txtMessageKeHang.setBounds(24, 107, 1094, 22);
				panel_1.add(txtMessageKeHang);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(10, 172, 639, 113);
				pnlKeHang.add(panel);
				
				btnThemKeHang = new JButton("Thêm");
				btnThemKeHang.setBounds(41, 34, 136, 57);
				panel.add(btnThemKeHang);
				Image img_iconThem = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
				btnThemKeHang.setIcon(new ImageIcon(img_iconThem));
				
				btnCapNhatKeHang = new JButton("Cập nhật");
				btnCapNhatKeHang.setBounds(204, 34, 136, 57);
				panel.add(btnCapNhatKeHang);
				Image img_iconUpdate = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
				btnCapNhatKeHang.setIcon(new ImageIcon(img_iconUpdate));
				
				btnTaoMoiKeHang = new JButton("Tạo mới");
				btnTaoMoiKeHang.setBounds(367, 34, 144, 57);
				panel.add(btnTaoMoiKeHang);
				Image img_iconTaoMoi = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
				btnTaoMoiKeHang.setIcon(new ImageIcon(img_iconTaoMoi));
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_2.setBounds(659, 172, 480, 113);
				pnlKeHang.add(panel_2);
				
				btnTimKiemKeHang = new JButton("");
				btnTimKiemKeHang.setBounds(290, 38, 51, 50);
				panel_2.add(btnTimKiemKeHang);
				btnTimKiemKeHang.setIcon(new ImageIcon(img_iconTimKiem));
				
				JLabel lblNewLabel_1 = new JLabel("Nhập tên kệ hàng:");
				lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
				lblNewLabel_1.setBounds(37, 38, 236, 21);
				panel_2.add(lblNewLabel_1);
				
				txtTimKiemKeHang = new JTextField();
				txtTimKiemKeHang.setColumns(10);
				txtTimKiemKeHang.setBounds(37, 69, 236, 19);
				panel_2.add(txtTimKiemKeHang);
				
				
				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch k\u1EC7 h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_3.setBounds(10, 295, 1128, 439);
				pnlKeHang.add(panel_3);
				
				JScrollPane scrollPane_N = new JScrollPane();
				scrollPane_N.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane_N.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane_N.setBounds(10, 20, 1100, 400);
				panel_3.add(scrollPane_N);
				
				String[] tb_KH = new String[] { "Mã kệ hàng", "Tên kệ hàng", "Vị trí", "Sức chứa", "Tình trạng"};
						modelKeHang = new DefaultTableModel(tb_KH, 0);
						tblKeHang = new JTable(modelKeHang);
						
						//table = new JTable();
						scrollPane_N.setViewportView(tblKeHang);
						tblKeHang.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int r = tblKeHang.getSelectedRow();
						        fillFormKeHang(r);

							}
						});
				
				JPanel pnlDanhMuc = new JPanel();
				pnlDanhMuc.setToolTipText("");
				tabbedPane.addTab("Danh mục", null, pnlDanhMuc, null);
				pnlDanhMuc.setLayout(null);
				
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setLayout(null);
				panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin danh m\u1EE5c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1_1.setBounds(10, 10, 1128, 152);
				pnlDanhMuc.add(panel_1_1);
				
				JLabel lblMDanhMc = new JLabel("Mã danh mục:");
				lblMDanhMc.setFont(new Font("Arial", Font.BOLD, 12));
				lblMDanhMc.setBounds(24, 50, 107, 22);
				panel_1_1.add(lblMDanhMc);
				
				JLabel lblTnDanhMc = new JLabel("Tên danh mục:");
				lblTnDanhMc.setFont(new Font("Arial", Font.BOLD, 12));
				lblTnDanhMc.setBounds(547, 50, 94, 22);
				panel_1_1.add(lblTnDanhMc);
				
				txtMaDanhMuc = new JTextField();
				txtMaDanhMuc.setEnabled(false);
				txtMaDanhMuc.setEditable(false);
				txtMaDanhMuc.setColumns(10);
				txtMaDanhMuc.setBounds(141, 52, 373, 19);
				panel_1_1.add(txtMaDanhMuc);
				
				txtTenDanhMuc = new JTextField();
				txtTenDanhMuc.setColumns(10);
				txtTenDanhMuc.setBounds(651, 52, 467, 19);
				panel_1_1.add(txtTenDanhMuc);
				
				txtMessageDanhMuc = new JTextField();
				txtMessageDanhMuc.setToolTipText("");
				txtMessageDanhMuc.setText("");
				txtMessageDanhMuc.setForeground(Color.RED);
				txtMessageDanhMuc.setFont(new Font("Arial", Font.ITALIC, 14));
				txtMessageDanhMuc.setEditable(false);
				txtMessageDanhMuc.setColumns(10);
				txtMessageDanhMuc.setBorder(null);
				txtMessageDanhMuc.setBackground(UIManager.getColor("Button.background"));
				txtMessageDanhMuc.setBounds(24, 107, 1094, 22);
				panel_1_1.add(txtMessageDanhMuc);
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				panel_4.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_4.setBounds(10, 167, 639, 113);
				pnlDanhMuc.add(panel_4);
				
				btnThemDanhMuc = new JButton("Thêm");
				btnThemDanhMuc.setBounds(41, 34, 136, 57);
				panel_4.add(btnThemDanhMuc);
				btnThemDanhMuc.setIcon(new ImageIcon(img_iconThem));
				
				btnCapNhatDanhMuc = new JButton("Cập nhật");
				btnCapNhatDanhMuc.setBounds(204, 34, 136, 57);
				panel_4.add(btnCapNhatDanhMuc);
				btnCapNhatDanhMuc.setIcon(new ImageIcon(img_iconUpdate));
				
				btnTaoMoiDanhMuc = new JButton("Tạo mới");
				btnTaoMoiDanhMuc.setBounds(367, 34, 144, 57);
				panel_4.add(btnTaoMoiDanhMuc);
				btnTaoMoiDanhMuc.setIcon(new ImageIcon(img_iconTaoMoi));
				
				JPanel panel_2_1 = new JPanel();
				panel_2_1.setLayout(null);
				panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_2_1.setBounds(659, 167, 480, 113);
				pnlDanhMuc.add(panel_2_1);
				
				btnTimKiemDanhMuc = new JButton("");
				btnTimKiemDanhMuc.setBounds(290, 38, 51, 50);
				panel_2_1.add(btnTimKiemDanhMuc);
				btnTimKiemDanhMuc.setIcon(new ImageIcon(img_iconTimKiem));
				
				JLabel lblNewLabel_1_1 = new JLabel("Nhập tên danh mục:");
				lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
				lblNewLabel_1_1.setBounds(37, 38, 236, 21);
				panel_2_1.add(lblNewLabel_1_1);
				
				txtTimKiemDanhMuc = new JTextField();
				txtTimKiemDanhMuc.setColumns(10);
				txtTimKiemDanhMuc.setBounds(37, 69, 236, 19);
				panel_2_1.add(txtTimKiemDanhMuc);
				
				JPanel panel_3_1 = new JPanel();
				panel_3_1.setLayout(null);
				panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch danh m\u1EE5c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_3_1.setBounds(10, 290, 1128, 439);
				pnlDanhMuc.add(panel_3_1);
				
				JScrollPane scrollPane_N_1 = new JScrollPane();
				scrollPane_N_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane_N_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane_N_1.setBounds(10, 20, 1100, 400);
				panel_3_1.add(scrollPane_N_1);
				String[] tb_DM = new String[] { "Mã danh mục", "Tên danh mục"};
				modelDanhMuc = new DefaultTableModel(tb_DM, 0);
				tblDanhMuc = new JTable(modelDanhMuc);
				
				//table = new JTable();
				scrollPane_N_1.setViewportView(tblDanhMuc);
				tblDanhMuc.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int r = tblDanhMuc.getSelectedRow();
				        fillFormDanhMuc(r);

					}
				});
		
				
				
		
		napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
		napDuLieuVPPTuCSDL(vanPhongPham_dao.getAllVPP("VPP"));
		napComboBoxMaKeHang(keHang_dao.getAllKeHang());
		napComboBoxMaDanhMuc(danhMuc_dao.getAllDanhMuc());
		napComboBoxMaNhaCungCap(nhaCungCap_dao.getAllNhaCungCap());
		napComboBoxMaKhuyenMai(khuyenMai_dao.getKhuyenMaiTheoDoiTuongApDung("Sản phẩm"));
		napDuLieuKeHangTuCSDL(keHang_dao.getAllKeHang());
		napDuLieuDanhMucTuCSDL(danhMuc_dao.getAllDanhMuc());
				
		
		btnThemSach.addActionListener(this);
		btnThemVPP.addActionListener(this);
		btnLamMoiSach.addActionListener(this);
		btnLamMoiVPP.addActionListener(this);
		btnCapNhatSach.addActionListener(this);
		btnCapNhatVPP.addActionListener(this);
		btnTimKiemSach.addActionListener(this);
		btnTimKiemVPP.addActionListener(this);
		btnThemKeHang.addActionListener(this);
		btnTaoMoiKeHang.addActionListener(this);
		btnCapNhatKeHang.addActionListener(this);
		btnTimKiemKeHang.addActionListener(this);
		btnThemDanhMuc.addActionListener(this);
		btnTaoMoiDanhMuc.addActionListener(this);
		btnCapNhatDanhMuc.addActionListener(this);
		btnTimKiemDanhMuc.addActionListener(this);
	}
	
	public void napDuLieuSachTuCSDL(ArrayList<Sach> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblSach.getModel();
		dm.getDataVector().removeAllElements();
		for (Sach s : ds) {
			modelSach.addRow(new Object[] {s.getMaSP(),s.getTenSP(),s.getGiaMua(),s.getSoLuong(),s.getGiaBan(),s.getNhaXB(),s.getTacGia(),s.getNamXB(),s.getSoTrang(),s.getThueVAT(),s.getDanhMuc().getMaDanhMuc(),s.getKeHang().getMaKeHang(),s.getKhuyenMai().getMaKhuyenMai(),s.getNhaCungCap().getMaNhaCungCap(),s.getTinhTrang()});
		}
	}
	
	public void napDuLieuVPPTuCSDL(ArrayList<VanPhongPham> ds) {
		DefaultTableModel dm = (DefaultTableModel) tblVanPhongPham.getModel();
		dm.getDataVector().removeAllElements();
		for (VanPhongPham v : ds) {
			modelVPPham.addRow(new Object[] {v.getMaSP(),v.getTenSP(),v.getGiaMua(),v.getSoLuong(),v.getGiaBan(),v.getThuongHieu(),v.getXuatXu(),v.getMauSac(),v.getChatLieu(),v.getThueVAT(),v.getDanhMuc().getMaDanhMuc(),v.getKeHang().getMaKeHang(),v.getKhuyenMai().getMaKhuyenMai(),v.getNhaCungCap().getMaNhaCungCap(),v.getTinhTrang()});
		}
	}
	
	public void napComboBoxMaKeHang(ArrayList<KeHang> ds) {
		int n = ds.size();
		String items[] = new String[n];
		int i = 0;
		for (KeHang kh : ds) {
			items[i] = kh.getMaKeHang() + "";
			i++;
		}
		cbMaKeHangSach.setModel(new DefaultComboBoxModel<String>(items));
		cbMaKeHangVPP.setModel(new DefaultComboBoxModel<String>(items));
	}
	public void napComboBoxMaDanhMuc(ArrayList<DanhMuc> ds) {
		int n = ds.size();
		String items[] = new String[n];
		int i = 0;
		for (DanhMuc danhMuc : ds) {
			items[i] = danhMuc.getMaDanhMuc() + "";
			i++;
		}
		cbMaDanhMucSach.setModel(new DefaultComboBoxModel<String>(items));
		cbMaDanhMucVPP.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	public void napComboBoxMaNhaCungCap(ArrayList<NhaCungCap> ds) {
		int n = ds.size();
		String items[] = new String[n];
		int i = 0;
		for (NhaCungCap ncc : ds) {
			items[i] = ncc.getMaNhaCungCap() + "";
			i++;
		}
		cbMaNhaCungCapSach.setModel(new DefaultComboBoxModel<String>(items));
		cbMaNhaCungCapVPP.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	public void napComboBoxMaKhuyenMai(ArrayList<KhuyenMai> ds) {
		int n = ds.size();
		String items[] = new String[n+1];
		items[0] = "";
	    int i = 1;
		for (KhuyenMai km : ds) {
			items[i] = km.getMaKhuyenMai() + "";
			i++;
		}
		cbMaKhuyenMaiSach.setModel(new DefaultComboBoxModel<String>(items));
		cbMaKhuyenMaiVPP.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	
	private void xoaTrangSach() {
		txtMaSach.setText("");
		txtTenSach.setText("");
		txtGiaMuaSach.setText("");
		txtSoLuongSach.setText("");
		txtGiaBanSach.setText("");
		txtNhaXuatBan.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtSoTrang.setText("");
		txtThueVATSach.setText("");
		cbMaDanhMucSach.setSelectedIndex(0);
		cbMaKeHangSach.setSelectedIndex(0);
		cbMaKhuyenMaiSach.setSelectedIndex(0);
		cbMaNhaCungCapSach.setSelectedIndex(0);
		cbTinhTrangSach.setSelectedIndex(0);
		txtTenSach.requestFocus();
	}
	
	private boolean validDateSach() {
		String tenSach = txtTenSach.getText().trim();
		String giaMuaSachStr = txtGiaMuaSach.getText().trim();
		String soLuongSachStr = txtSoLuongSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String thueVATStr = txtThueVATSach.getText().trim();
		String nXB = txtNhaXuatBan.getText().trim();
		String namXBStr = txtNamXB.getText().trim();
		String soTrangStr = txtSoTrang.getText().trim();
		if(tenSach.equals("")) {
			txtMessageSach.setText("Vui lòng nhập tên cuốn sách.");
			txtTenSach.requestFocus();
			return false;
		}
		if(giaMuaSachStr.equals("")) {
			txtMessageSach.setText("Vui lòng nhập giá mua.");
			txtGiaMuaSach.requestFocus();
			return false;
		}else {
			try {
                float giaMua = Float.parseFloat(giaMuaSachStr);
                if (giaMua <= 0) {
                    txtMessageSach.setText("Giá mua phải là số lớn hơn 0!!!");
                    txtGiaMuaSach.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtGiaMuaSach.setText("Giá mua không hợp lệ. Vui lòng nhập số lớn hơn 0!!!");
                return false;
            }
		}
		if(soLuongSachStr.equals("")) {
			txtMessageSach.setText("Vui lòng nhập số lượng sách.");
			txtSoLuongSach.requestFocus();
			return false;
		}else {
			try {
                int soLuong = Integer.parseInt(soLuongSachStr);
                if (soLuong <= 0) {
                    txtMessageSach.setText("Số lượng phải là số nguyên lớn hơn 0!!!");
                    txtSoLuongSach.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtSoLuongSach.setText("Số lượng không hợp lệ. Vui lòng nhập số nguyên lớn hơn 0!!!");
                return false;
            }
		}if(thueVATStr.equals("")) {
			txtMessageSach.setText("Vui lòng nhập thuế giá trị gia tăng.");
			txtThueVATSach.requestFocus();
			return false;
		}else {
			try {
                float thueVAT = Float.parseFloat(thueVATStr);
                if (thueVAT < 0||thueVAT>=0.11) {
                    txtMessageSach.setText("Giá trị VAT phải phải nằm trong khoảng từ 0 -> 0.1!!!");
                    txtThueVATSach.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtThueVATSach.setText("Giá trị VAT không hợp lệ. Vui lòng nhập số nằm trong khoảng từ 0 -> 1!!!");
                return false;
            }
		}
		if(tacGia.equals("")) {
			txtMessageSach.setText("Vui lòng nhập tên tác giả.");
			txtTacGia.requestFocus();
			return false;
		}if(nXB.equals("")) {
			txtMessageSach.setText("Vui lòng nhập tên nhà xuất bản.");
			txtNhaXuatBan.requestFocus();
			return false;
		}if(namXBStr.equals("")) {
			txtMessageSach.setText("Vui lòng nhập năm xuất bản sách.");
			txtNamXB.requestFocus();
			return false;
		}else {
			try {
		        int namXB = Integer.parseInt(namXBStr);
		        int namHienTai = java.time.Year.now().getValue();

		        if (namXB < 0 || namXB > namHienTai) {
		            txtMessageSach.setText("Năm xuất bản phải là số nguyên dương và nhỏ hơn năm hiện tại.");
		            txtNamXB.requestFocus();
		            return false;
		        }
		    } catch (NumberFormatException e) {
		    	txtMessageSach.setText("Năm xuất bản không hợp lệ.");
		    	txtNamXB.requestFocus();
		        return false;
		    }
		}
		if(soTrangStr.equals("")) {
			txtMessageSach.setText("Vui lòng nhập số trang.");
			txtSoTrang.requestFocus();
			return false;
		}else {
			try {
                int soTrang = Integer.parseInt(soTrangStr);
                if (soTrang <= 0) {
                    txtMessageSach.setText("Số trang phải là số nguyên lớn hơn 0!!!");
                    txtSoTrang.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtSoTrang.setText("Số trang không hợp lệ. Vui lòng nhập số nguyên lớn hơn 0!!!");
                return false;
            }
		}
		
		
		return true;
	}
	
	private String phatSinhMaSach() {
		String prefix = "S";
    	return prefix + String.format("%04d", modelSach.getRowCount()+ 1);
	}
	
	private Sach revertSachFromFields() {
		String maSach = "";
		String tenSach= txtTenSach.getText().trim();
		float giaMua = Float.parseFloat(txtGiaMuaSach.getText().trim());
		int soLuong = Integer.parseInt(txtSoLuongSach.getText().trim());
		float giaBan = 0;
		String nhaXuatBan= txtNhaXuatBan.getText().trim();
		String tacGia= txtTacGia.getText().trim();
		int namXuatBan = Integer.parseInt(txtNamXB.getText().trim());
		int soTrang = Integer.parseInt(txtSoTrang.getText().trim());
		float thueVAT = Float.parseFloat(txtThueVATSach.getText().trim());
		DanhMuc dm = new DanhMuc( (String) cbMaDanhMucSach.getSelectedItem());
		KeHang kh = new KeHang( (String) cbMaKeHangSach.getSelectedItem());
		String maKhuyenMai = (String) cbMaKhuyenMaiSach.getSelectedItem();
	    KhuyenMai khuyenMai = null;
	    int ptKhuyenMai = 0;
	    if (maKhuyenMai != null && !maKhuyenMai.isEmpty()) {
	        khuyenMai = new KhuyenMai(maKhuyenMai);
	        String maKhuyenMaiValue = khuyenMai.getMaKhuyenMai();
	        if (maKhuyenMaiValue != null) {
	            KhuyenMai findKhuyenMai = khuyenMai_dao.getKhuyenMaiTheoMa(maKhuyenMaiValue);
	            if (findKhuyenMai != null) {
	                ptKhuyenMai = findKhuyenMai.getGiaTriGiamGia();
	            }
	        }
	    }
		NhaCungCap ncc = new NhaCungCap( (String) cbMaNhaCungCapSach.getSelectedItem());
		String tinhTrang = (String) cbTinhTrangSach.getSelectedItem();
		maSach = phatSinhMaSach();
		giaBan = (giaMua * inc) + (giaMua * inc * thueVAT) - (((giaMua * inc) + (giaMua * inc * thueVAT)) * ptKhuyenMai / 100);
		Sach s = new Sach(maSach, tenSach, giaMua, soLuong, giaBan, thueVAT, dm, kh, khuyenMai, ncc, tinhTrang, tacGia, nhaXuatBan, namXuatBan, soTrang);
		return s;
	}
	
	private void updateSach() {
		int r = tblSach.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			if (validDateSach()) {
					String maSach = txtMaSach.getText().trim();
					String tenSach= txtTenSach.getText().trim();
					float giaMua = Float.parseFloat(txtGiaMuaSach.getText().trim());
					int soLuong = Integer.parseInt(txtSoLuongSach.getText().trim());
					float giaBan = 0;
					String nhaXuatBan= txtNhaXuatBan.getText().trim();
					String tacGia= txtTacGia.getText().trim();
					int namXuatBan = Integer.parseInt(txtNamXB.getText().trim());
					int soTrang = Integer.parseInt(txtSoTrang.getText().trim());
					float thueVAT = Float.parseFloat(txtThueVATSach.getText().trim());
					DanhMuc dm = new DanhMuc( (String) cbMaDanhMucSach.getSelectedItem());
					KeHang kh = new KeHang( (String) cbMaKeHangSach.getSelectedItem());
					String maKhuyenMai = (String) cbMaKhuyenMaiSach.getSelectedItem();
				    KhuyenMai khuyenMai = null;
				    int ptKhuyenMai = 0;
				    if (!maKhuyenMai.isEmpty()) {
				        khuyenMai = new KhuyenMai(maKhuyenMai);
				        String maKhuyenMaiValue = khuyenMai.getMaKhuyenMai();
				        if (maKhuyenMaiValue != null) {
				            KhuyenMai findKhuyenMai = khuyenMai_dao.getKhuyenMaiTheoMa(maKhuyenMaiValue);
				            if (findKhuyenMai != null) {
				                ptKhuyenMai = findKhuyenMai.getGiaTriGiamGia();
				            }
				        }
				    }
					NhaCungCap ncc = new NhaCungCap( (String) cbMaNhaCungCapSach.getSelectedItem());
					String tinhTrang = (String) cbTinhTrangSach.getSelectedItem();
					giaBan = (giaMua * inc) + (giaMua * inc * thueVAT) - (((giaMua * inc) + (giaMua * inc * thueVAT)) * ptKhuyenMai / 100);
					Sach newSach = new Sach(maSach, tenSach, giaMua, soLuong, giaBan, thueVAT, dm, kh, khuyenMai, ncc, tinhTrang, tacGia, nhaXuatBan, namXuatBan, soTrang);
				if (!sach_dao.capnhatSach(newSach)) {
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					tblSach.clearSelection();
				} else {
					
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				}
			}
		}
	}
	
	public void fillForm(int r) {
		txtMaSach.setText(tblSach.getValueAt(r, 0).toString());
		txtTenSach.setText(tblSach.getValueAt(r, 1).toString());
		txtGiaMuaSach.setText(tblSach.getValueAt(r, 2).toString());
		txtSoLuongSach.setText(tblSach.getValueAt(r, 3).toString());
		txtGiaBanSach.setText(tblSach.getValueAt(r, 4).toString());
		txtNhaXuatBan.setText((tblSach.getValueAt(r, 5) != null) ? tblSach.getValueAt(r, 5).toString() : "");
		txtTacGia.setText(tblSach.getValueAt(r, 6).toString());
		txtNamXB.setText((tblSach.getValueAt(r, 7) != null) ? tblSach.getValueAt(r, 7).toString() : "");
		txtSoTrang.setText((tblSach.getValueAt(r, 8) != null) ? tblSach.getValueAt(r, 8).toString() : "");
		txtThueVATSach.setText(tblSach.getValueAt(r, 9).toString());
		cbMaDanhMucSach.setSelectedItem(tblSach.getValueAt(r, 10).toString());
		cbMaKeHangSach.setSelectedItem(tblSach.getValueAt(r, 11).toString());
		Object maKMObject = tblSach.getValueAt(r, 12);
		if (maKMObject != null) {
		    // Giữ nguyên giá trị nếu không phải là null
		    cbMaKhuyenMaiSach.setSelectedItem(maKMObject.toString());
		} else {
		    // Nếu là null, đặt ComboBox thành giá trị rỗng
		    cbMaKhuyenMaiSach.setSelectedItem("");
		}
		cbMaNhaCungCapSach.setSelectedItem(tblSach.getValueAt(r, 13).toString());
		cbTinhTrangSach.setSelectedItem(tblSach.getValueAt(r, 14).toString());
	}
	
	public void timSachTheoTen() {
		String ten = txtTimKiemSach.getText().trim();

		if (ten.isEmpty() || ten.trim() == "") {
			napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
			xoaTrangSach();
		} else {
			ArrayList<Sach> sachList = sach_dao.getListSachTheoTen(ten);
			if (sachList.size() > 0) {
				napDuLieuSachTuCSDL(sachList);
				xoaTrangSach();
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}
	}
	
	public void timSachTheoTacGia() {
		String tentacGia = txtTimKiemSach.getText().trim();
		
		if (tentacGia.isEmpty() || tentacGia.trim() == "") {
			napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
			xoaTrangSach();
		} else {
			ArrayList<Sach> sachList1 = sach_dao.getListSachTheoTacGia(tentacGia);
			if ( sachList1.size() > 0) {
				napDuLieuSachTuCSDL(sachList1);
				xoaTrangSach();
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}
	}
	
//	Văn phòng phẩm
	private void xoaTrangVPP() {
		txtMaVanPhongPham.setText("");
		txtTenVanPhongPham.setText("");
		txtGiaMuaVPP.setText("");
		txtSoLuongVPP.setText("");
		txtGiaBanVPP.setText("");
		txtThuongHieu.setText("");
		txtXuatXu.setText("");
		txtMauSac.setText("");
		txtChatLieu.setText("");
		txtThueVATVPP.setText("");
		cbMaDanhMucVPP.setSelectedIndex(0);
		cbMaKeHangVPP.setSelectedIndex(0);
		cbMaKhuyenMaiVPP.setSelectedIndex(0);
		cbMaNhaCungCapVPP.setSelectedIndex(0);
		cbTinhTrangVPP.setSelectedIndex(0);
		txtTenVanPhongPham.requestFocus();
	}
	
	private boolean validDateVPP() {
		String tenVPP = txtTenVanPhongPham.getText().trim();
		String giaMuaVPPStr = txtGiaMuaVPP.getText().trim();
		String soLuongVPPStr = txtSoLuongVPP.getText().trim();
		String thueVATVPPStr = txtThueVATVPP.getText().trim();
		if(tenVPP.equals("")) {
			txtMessageVPP.setText("Vui lòng nhập tên văn phòng phẩm.");
			txtTenVanPhongPham.requestFocus();
			return false;
		}
		if(giaMuaVPPStr.equals("")) {
			txtMessageVPP.setText("Vui lòng nhập giá mua.");
			txtGiaMuaVPP.requestFocus();
			return false;
		}else {
			try {
                float giaMua = Float.parseFloat(giaMuaVPPStr);
                if (giaMua <= 0) {
                    txtMessageVPP.setText("Giá mua phải là số lớn hơn 0!!!");
                    txtGiaMuaVPP.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtGiaMuaVPP.setText("Giá mua không hợp lệ. Vui lòng nhập số lớn hơn 0!!!");
                return false;
            }
		}
		if(soLuongVPPStr.equals("")) {
			txtMessageVPP.setText("Vui lòng nhập số lượng văn phòng phẩm.");
			txtSoLuongVPP.requestFocus();
			return false;
		}else {
			try {
                int soLuong = Integer.parseInt(soLuongVPPStr);
                if (soLuong <= 0) {
                    txtMessageVPP.setText("Số lượng phải là số nguyên lớn hơn 0!!!");
                    txtSoLuongVPP.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtSoLuongVPP.setText("Số lượng không hợp lệ. Vui lòng nhập số nguyên lớn hơn 0!!!");
                return false;
            }
		}if(thueVATVPPStr.equals("")) {
			txtMessageVPP.setText("Vui lòng nhập thuế giá trị gia tăng.");
			txtThueVATVPP.requestFocus();
			return false;
		}else {
			try {
                float thueVAT = Float.parseFloat(thueVATVPPStr);
                if (thueVAT < 0||thueVAT>=0.11) {
                    txtMessageVPP.setText("Giá trị VAT phải phải nằm trong khoảng từ 0 -> 0.1!!!");
                    txtThueVATVPP.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtThueVATVPP.setText("Giá trị VAT không hợp lệ. Vui lòng nhập số nằm trong khoảng từ 0 -> 0.1!!!");
                return false;
            }
		}
		return true;
	}
	
	private String phatSinhMaVPP() {
		String prefix = "VPP";
    	return prefix + String.format("%04d", modelVPPham.getRowCount()+ 1);
	}
	
	private VanPhongPham revertVPPFromFields() {
		String maVPP = "";
		String tenVPP= txtTenVanPhongPham.getText().trim();
		float giaMua = Float.parseFloat(txtGiaMuaVPP.getText().trim());
		int soLuong = Integer.parseInt(txtSoLuongVPP.getText().trim());
		float giaBan = 0;
		String thuongHieu= txtThuongHieu.getText().trim();
		String xuatXu= txtXuatXu.getText().trim();
		String mauSac= txtMauSac.getText().trim();
		String chatLieu= txtChatLieu.getText().trim();
		float thueVAT = Float.parseFloat(txtThueVATVPP.getText().trim());
		DanhMuc dm = new DanhMuc( (String) cbMaDanhMucVPP.getSelectedItem());
		KeHang km = new KeHang( (String) cbMaKeHangVPP.getSelectedItem());
		String maKhuyenMai = (String) cbMaKhuyenMaiVPP.getSelectedItem();
	    KhuyenMai khuyenMai = null;
	    int ptKhuyenMai = 0;
	    if (maKhuyenMai != null && !maKhuyenMai.isEmpty()) {
	        khuyenMai = new KhuyenMai(maKhuyenMai);
	        String maKhuyenMaiValue = khuyenMai.getMaKhuyenMai();
	        if (maKhuyenMaiValue != null) {
	            KhuyenMai findKhuyenMai = khuyenMai_dao.getKhuyenMaiTheoMa(maKhuyenMaiValue);
	            if (findKhuyenMai != null) {
	                ptKhuyenMai = findKhuyenMai.getGiaTriGiamGia();
	            }
	        }
	    }
		NhaCungCap ncc = new NhaCungCap( (String) cbMaNhaCungCapVPP.getSelectedItem());
		String tinhTrang = (String) cbTinhTrangVPP.getSelectedItem();
		giaBan = (giaMua * inc) + (giaMua * inc * thueVAT) - (((giaMua * inc) + (giaMua * inc * thueVAT)) * ptKhuyenMai / 100);
		maVPP = phatSinhMaVPP();
		VanPhongPham vpp = new VanPhongPham(maVPP, tenVPP, giaMua, soLuong, giaBan, thueVAT, dm, km, khuyenMai, ncc, tinhTrang, thuongHieu, xuatXu, mauSac, chatLieu);
		return vpp;
	}
	
	private void updateVPP() {
		int r = tblVanPhongPham.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			if (validDateVPP()) {
					String maVPP = txtMaVanPhongPham.getText().trim();
					String tenVPP= txtTenVanPhongPham.getText().trim();
					float giaMua = Float.parseFloat(txtGiaMuaVPP.getText().trim());
					int soLuong = Integer.parseInt(txtSoLuongVPP.getText().trim());
					float giaBan = 0;
					String thuongHieu= txtThuongHieu.getText().trim();
					String xuatXu= txtXuatXu.getText().trim();
					String mauSac= txtMauSac.getText().trim();
					String chatLieu= txtChatLieu.getText().trim();
					float thueVAT = Float.parseFloat(txtThueVATVPP.getText().trim());
					DanhMuc dm = new DanhMuc( (String) cbMaDanhMucVPP.getSelectedItem());
					KeHang km = new KeHang( (String) cbMaKeHangVPP.getSelectedItem());
					String maKhuyenMai = (String) cbMaKhuyenMaiVPP.getSelectedItem();
				    KhuyenMai khuyenMai = null;
				    int ptKhuyenMai = 0;
				    if (maKhuyenMai != null && !maKhuyenMai.isEmpty()) {
				        khuyenMai = new KhuyenMai(maKhuyenMai);
				        String maKhuyenMaiValue = khuyenMai.getMaKhuyenMai();
				        if (maKhuyenMaiValue != null) {
				            KhuyenMai findKhuyenMai = khuyenMai_dao.getKhuyenMaiTheoMa(maKhuyenMaiValue);
				            if (findKhuyenMai != null) {
				                ptKhuyenMai = findKhuyenMai.getGiaTriGiamGia();
				            }
				        }
				    }
					NhaCungCap ncc = new NhaCungCap( (String) cbMaNhaCungCapVPP.getSelectedItem());
					String tinhTrang = (String) cbTinhTrangVPP.getSelectedItem();
					giaBan = (giaMua * inc) + (giaMua * inc * thueVAT) - (((giaMua * inc) + (giaMua * inc * thueVAT)) * ptKhuyenMai / 100);
					VanPhongPham newVPP = new VanPhongPham(maVPP, tenVPP, giaMua, soLuong, giaBan, thueVAT, dm, km, khuyenMai, ncc, tinhTrang, thuongHieu, xuatXu, mauSac, chatLieu);
				if (!vanPhongPham_dao.capnhatVPP(newVPP)) {
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					tblVanPhongPham.clearSelection();
				} else {
					
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				}
			}
		}
	}
	
	public void fillFormVPP(int r) {
		txtMaVanPhongPham.setText(tblVanPhongPham.getValueAt(r, 0).toString());
		txtTenVanPhongPham.setText(tblVanPhongPham.getValueAt(r, 1).toString());
		txtGiaMuaVPP.setText(tblVanPhongPham.getValueAt(r, 2).toString());
		txtSoLuongVPP.setText(tblVanPhongPham.getValueAt(r, 3).toString());
		txtGiaBanVPP.setText(tblVanPhongPham.getValueAt(r, 4).toString());
		txtThuongHieu.setText((tblVanPhongPham.getValueAt(r, 5) != null) ? tblVanPhongPham.getValueAt(r, 5).toString() : "");
		txtXuatXu.setText((tblVanPhongPham.getValueAt(r, 6) != null) ? tblVanPhongPham.getValueAt(r, 6).toString() : "");
		txtMauSac.setText((tblVanPhongPham.getValueAt(r, 7) != null) ? tblVanPhongPham.getValueAt(r, 7).toString() : "");
		txtChatLieu.setText((tblVanPhongPham.getValueAt(r, 8) != null) ? tblVanPhongPham.getValueAt(r, 8).toString() : "");
		txtThueVATVPP.setText(tblVanPhongPham.getValueAt(r, 9).toString());
		cbMaDanhMucVPP.setSelectedItem(tblVanPhongPham.getValueAt(r, 10).toString());
		cbMaKeHangVPP.setSelectedItem(tblVanPhongPham.getValueAt(r, 11).toString());
		Object maKMObject = tblVanPhongPham.getValueAt(r, 12);
		if (maKMObject != null) {
		    // Giữ nguyên giá trị nếu không phải là null
		    cbMaKhuyenMaiVPP.setSelectedItem(maKMObject.toString());
		} else {
		    // Nếu là null, đặt ComboBox thành giá trị rỗng
		    cbMaKhuyenMaiVPP.setSelectedItem("");
		}
		cbMaNhaCungCapVPP.setSelectedItem(tblVanPhongPham.getValueAt(r, 13).toString());
		cbTinhTrangVPP.setSelectedItem(tblVanPhongPham.getValueAt(r, 14).toString());
	}
	
	public void timVPPTheoTen() {
		String ten = txtTimKiemVPP.getText().trim();

		if (ten.isEmpty() || ten.trim() == "") {
			napDuLieuVPPTuCSDL(vanPhongPham_dao.getAllVPP("VPP"));
			xoaTrangVPP();
		} else {
			ArrayList<VanPhongPham> vPPList = vanPhongPham_dao.getListVPPTheoTen(ten);
			if (vPPList.size() > 0) {
				napDuLieuVPPTuCSDL(vPPList);
				xoaTrangVPP();
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}
	}
	
//	Kệ hàng
	public void napDuLieuKeHangTuCSDL(ArrayList<KeHang> ds) {
    	DefaultTableModel dm = (DefaultTableModel) tblKeHang.getModel();
		dm.getDataVector().removeAllElements();
		for (KeHang kh : ds) {
			modelKeHang.addRow(new Object[] {kh.getMaKeHang(),kh.getTenKeHang(),kh.getViTri(),kh.getSucChua(),kh.getTinhTrang()});
		}
    }
	
	private boolean validDateKeHang() {
		String tenKeHang = txtTenKeHang.getText().trim();
		String viTri = txtViTri.getText().trim();
		String sucChuaStr = txtSucChua.getText().trim();
		if(tenKeHang.equals("")) {
    		txtMessageKeHang.setText("Tên kệ hàng không được để trống!!!");
    		txtTenKeHang.requestFocus();
    		return false;
    	}
		if(viTri.equals("")) {
    		txtMessageKeHang.setText("Vị trí không được để trống!!!");
    		txtViTri.requestFocus();
    		return false;
    	}
		if(sucChuaStr.equals("")) {
			txtMessageKeHang.setText("Vui lòng nhập sức chứa của kệ hàng.");
			txtSucChua.requestFocus();
			return false;
		}else {
			try {
                int sucChua = Integer.parseInt(sucChuaStr);
                if (sucChua <= 0) {
                    txtMessageKeHang.setText("Sức chứa phải là số nguyên lớn hơn 0!!!");
                    txtSucChua.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                txtMessageKeHang.setText("Sức chứa không hợp lệ. Vui lòng nhập số nguyên lớn hơn 0!!!");
                return false;
            }
		}
		return true;
	}
    
    public void xoaTrangKeHang() {
    	txtMaKeHang.setText("");
    	txtTenKeHang.setText("");
    	txtViTri.setText("");
    	txtSucChua.setText("");
    	cbTinhTrangKeHang.setSelectedIndex(0);
    	txtTenKeHang.requestFocus();
    }
    
    private KeHang revertKeHangFromFields() {
    	String maKH = phatSinhMaKH();
    	String tenKH = txtTenKeHang.getText().trim();
    	String viTri = txtViTri.getText().trim();
    	int sucChua = Integer.parseInt(txtSucChua.getText().trim());
    	String tinhTrang = (String) cbTinhTrangKeHang.getSelectedItem();
    	KeHang kh = new KeHang(maKH, tenKH, viTri, sucChua, tinhTrang);
    	return kh;
    }
    
    public String phatSinhMaKH() {
    	String prefix = "KH";
    	return prefix + String.format("%03d", modelKeHang.getRowCount()+ 1);
    }
    
    public void fillFormKeHang (int r) {
    	txtMaKeHang.setText(tblKeHang.getValueAt(r, 0).toString());
    	txtTenKeHang.setText(tblKeHang.getValueAt(r, 1).toString());
    	txtViTri.setText(tblKeHang.getValueAt(r, 2).toString());
    	txtSucChua.setText(tblKeHang.getValueAt(r, 3).toString());
    	cbTinhTrangKeHang.setSelectedItem(tblKeHang.getValueAt(r, 4).toString());
    }
    
    public void timKeHangTheoTen() {
    	String tenKH = txtTimKiemKeHang.getText().trim();
    	if (tenKH.trim() == "") {
			napDuLieuKeHangTuCSDL(keHang_dao.getAllKeHang());
			xoaTrangKeHang();
		} else {
			ArrayList<KeHang> khList = keHang_dao.getKeHangTheoTen(tenKH);
			if (khList.size() > 0) {
				napDuLieuKeHangTuCSDL(khList);
				xoaTrangKeHang();

			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}
    }
    
    public void updateKeHang() {
    	int r = tblKeHang.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			if(validDateKeHang()) {
				String maKM = txtMaKeHang.getText().trim();
				String tenKM = txtTenKeHang.getText().trim();
				String viTri = txtViTri.getText().trim();
				int sucChua = Integer.parseInt(txtSucChua.getText().trim());
		    	String tinhTrang = cbTinhTrangKeHang.getSelectedItem().toString();
		    	KeHang khMoi = new KeHang(maKM, tenKM, viTri, sucChua, tinhTrang);
				if (!keHang_dao.capNhat(khMoi)) {
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					tblKeHang.clearSelection();
				} else {
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					napDuLieuKeHangTuCSDL(keHang_dao.getAllKeHang());
				}
			}
		}
    }
    
//    Danh mục
    public void napDuLieuDanhMucTuCSDL(ArrayList<DanhMuc> ds) {
    	DefaultTableModel dml = (DefaultTableModel) tblDanhMuc.getModel();
    	dml.getDataVector().removeAllElements();
    	for (DanhMuc danhMuc : ds) {
			modelDanhMuc.addRow(new Object[] {danhMuc.getMaDanhMuc(),danhMuc.getTenDanhMuc()});
		}
    }
    
    private void xoaTrangDanhMuc() {
    	txtMaDanhMuc.setText("");
    	txtTenDanhMuc.setText("");
    }
    
    public String phatSinhMaDM() {
    	String prefix = "DM";
    	return prefix + String.format("%03d", modelDanhMuc.getRowCount()+ 1);
    }
    
    private boolean validDataDanhMuc() {
    	String tenDanhMuc = txtTenDanhMuc.getText().trim();
    	if(tenDanhMuc.equals("")) {
    		txtMessageDanhMuc.setText("Tên danh mục không được để trống!!!");
    		txtTenDanhMuc.requestFocus();
    		return false;
    	}
    	return true;
    }
    
    private DanhMuc revertDanhMucFromFields() {
    	String maDM = phatSinhMaDM();
    	String tenDM = txtTenDanhMuc.getText().trim();
    	DanhMuc dm = new DanhMuc(maDM, tenDM);
    	return dm;
    }
    
    private void updateDanhMuc() {
    	int r = tblDanhMuc.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			if(validDataDanhMuc()) {
				String maDM = txtMaDanhMuc.getText().trim();
				String tenDM = txtTenDanhMuc.getText().trim();
				
		    	DanhMuc dmMoi = new DanhMuc(maDM, tenDM);
				if (!danhMuc_dao.capNhat(dmMoi)) {
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					tblDanhMuc.clearSelection();
				} else {
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					napDuLieuDanhMucTuCSDL(danhMuc_dao.getAllDanhMuc());
				}
			}
		}
    }
    
    public void fillFormDanhMuc(int r) {
    	txtMaDanhMuc.setText(tblDanhMuc.getValueAt(r, 0).toString());
    	txtTenDanhMuc.setText(tblDanhMuc.getValueAt(r, 1).toString());
    }
    
    public void timDMTheoTen() {
    	String ten = txtTimKiemDanhMuc.getText().trim();
    	if (ten.trim() == "") {
			napDuLieuDanhMucTuCSDL(danhMuc_dao.getAllDanhMuc());
			xoaTrangDanhMuc();
		} else {
			ArrayList<DanhMuc> dmList = danhMuc_dao.getDanhMucTheoTen(ten);
			if (dmList.size() > 0) {
				napDuLieuDanhMucTuCSDL(dmList);
				xoaTrangDanhMuc();

			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}
    }
    
    
    private void deleteRowSelected() {
		String listMaDM = "";
		String maDM = "";

		if (tblDanhMuc.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa");
		} else {

//			lay ra danh sach xoa tren GUI
			int[] listIndex = tblDanhMuc.getSelectedRows();
			listMaDM += tblDanhMuc.getValueAt(listIndex[0], 0);
			for (int i = 1; i < tblDanhMuc.getSelectedRowCount(); i++) {
				listMaDM += ", " + tblDanhMuc.getValueAt(listIndex[i], 0);
			}

//			Hien thi thong tin xoa
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa danh mục " + listMaDM + " ?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					while (tblDanhMuc.getSelectedRowCount() > 0) {
						maDM = (String) tblDanhMuc.getValueAt(tblDanhMuc.getSelectedRow(), 0);
						if (!danhMuc_dao.xoa(maDM)) {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, đã xảy ra lỗi");
							tblDanhMuc.clearSelection();
						} else {
							modelDanhMuc.removeRow(tblDanhMuc.getSelectedRow());
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		}
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThemSach)) {
			if (validDateSach()) {
				Sach s = revertSachFromFields();
				if (!sach_dao.themSach(s)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công.");
					napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
					tblSach.clearSelection();
					txtMessageSach.setText("");
				}
			}	
		}else if(o.equals(btnCapNhatSach)) {
			updateSach();
			napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
			tblSach.clearSelection();
			txtMessageSach.setText("");
		}else if(o.equals(btnLamMoiSach)) {
			xoaTrangSach();
			napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
			napComboBoxMaKeHang(keHang_dao.getAllKeHang());
			napComboBoxMaDanhMuc(danhMuc_dao.getAllDanhMuc());
			napComboBoxMaNhaCungCap(nhaCungCap_dao.getAllNhaCungCap());
			napComboBoxMaKhuyenMai(khuyenMai_dao.getKhuyenMaiTheoDoiTuongApDung("Sản phẩm"));
			tblSach.clearSelection();
			txtMessageSach.setText("");
		}else if(o.equals(btnTimKiemSach)) {
			
			boolean timtheoTacGia = chkTimTheoTacGia.isSelected();
			if(timtheoTacGia) {
				timSachTheoTacGia();
			} else {
				timSachTheoTen();
			}
		}else if(o.equals(btnThemVPP)) {
			if (validDateVPP()) {
				VanPhongPham vpp = revertVPPFromFields();
				if (!vanPhongPham_dao.themVPP(vpp)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					napDuLieuVPPTuCSDL(vanPhongPham_dao.getAllVPP("VPP"));
					tblVanPhongPham.clearSelection();
					txtMessageVPP.setText("");
				}
			}	
		}else if(o.equals(btnCapNhatVPP)) {
			updateVPP();
			napDuLieuVPPTuCSDL(vanPhongPham_dao.getAllVPP("VPP"));
			tblVanPhongPham.clearSelection();
			txtMessageVPP.setText("");
		}else if(o.equals(btnLamMoiVPP)) {
			xoaTrangVPP();
			napDuLieuVPPTuCSDL(vanPhongPham_dao.getAllVPP("VPP"));
			napComboBoxMaKeHang(keHang_dao.getAllKeHang());
			napComboBoxMaDanhMuc(danhMuc_dao.getAllDanhMuc());
			napComboBoxMaNhaCungCap(nhaCungCap_dao.getAllNhaCungCap());
			napComboBoxMaKhuyenMai(khuyenMai_dao.getKhuyenMaiTheoDoiTuongApDung("Sản phẩm"));
			tblVanPhongPham.clearSelection();
			txtMessageVPP.setText("");
		}else if(o.equals(btnTimKiemVPP)) {
			timVPPTheoTen();
		}else if(o.equals(btnThemKeHang)) {
			if(validDateKeHang()) {
				KeHang kh = revertKeHangFromFields();
				if (!keHang_dao.them(kh)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm kệ hàng mới thành công");
					napDuLieuKeHangTuCSDL(keHang_dao.getAllKeHang());
					tblKeHang.clearSelection();
					txtMessageKeHang.setText("");
				}
			}
		}else if(o.equals(btnCapNhatKeHang)) {
			updateKeHang();
			napDuLieuKeHangTuCSDL(keHang_dao.getAllKeHang());
			tblKeHang.clearSelection();
			txtMessageKeHang.setText("");
		}else if(o.equals(btnTaoMoiKeHang)) {
			xoaTrangKeHang();
			napDuLieuKeHangTuCSDL(keHang_dao.getAllKeHang());
			tblKeHang.clearSelection();
			txtMessageKeHang.setText("");
		}else if(o.equals(btnTimKiemKeHang)) {
			timKeHangTheoTen();
		}
		else if(o.equals(btnThemDanhMuc)) {
			if(validDataDanhMuc()) {
				DanhMuc dm = revertDanhMucFromFields();
				if (!danhMuc_dao.them(dm)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm danh mục mới thành công");
					napDuLieuDanhMucTuCSDL(danhMuc_dao.getAllDanhMuc());
					tblDanhMuc.clearSelection();
					txtMessageDanhMuc.setText("");
				}
			}
		}else if(o.equals(btnCapNhatDanhMuc)) {
			updateDanhMuc();
			napDuLieuDanhMucTuCSDL(danhMuc_dao.getAllDanhMuc());
			tblDanhMuc.clearSelection();
			txtMessageDanhMuc.setText("");
		}else if(o.equals(btnTaoMoiDanhMuc)) {
			xoaTrangDanhMuc();
			napDuLieuDanhMucTuCSDL(danhMuc_dao.getAllDanhMuc());
			tblDanhMuc.clearSelection();
			txtMessageDanhMuc.setText("");
		}else if(o.equals(btnTimKiemDanhMuc)) {
			timDMTheoTen();
		}
	
	
	}
}
