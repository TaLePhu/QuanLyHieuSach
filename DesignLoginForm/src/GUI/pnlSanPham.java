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

public class pnlSanPham extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Dao_VanPhongPham vpPham_dao = new Dao_VanPhongPham();
	private Dao_KeHang keHang_dao = new Dao_KeHang();
	private Dao_KhuyenMai khuyenMai_dao = new Dao_KhuyenMai();
	private Dao_DanhMuc danhMuc_dao = new Dao_DanhMuc();
	private Dao_NhaCungCap nhaCungCap_dao = new Dao_NhaCungCap();
	private JTextField txtThueVATSach;
	private JTextField txtThueVATVPP;
	
	private JButton btnLamMoiSach, btnThemSach, btnCapNhatSach, btnTimKiemSach, btnLamMoiVPP, btnThemVPP, btnCapNhatVPP, btnTimKiemVPP;
	private JTextField txtMessageSach;
	private JTextField txtMessageVPP;

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
		
		txtMaSach = new JTextField();
		txtMaSach.setEnabled(false);
		txtMaSach.setEditable(false);
		txtMaSach.setBounds(10, 35, 282, 24);
		pnlMaSP.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JPanel pnlTenSach = new JPanel();
		pnlTenSach.setLayout(null);
		pnlTenSach.setBounds(10, 100, 302, 65);
		pnlThongTin.add(pnlTenSach);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm: ");
		lblTenSP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenSP.setBounds(88, 5, 139, 22);
		pnlTenSach.add(lblTenSP);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(10, 35, 282, 24);
		pnlTenSach.add(txtTenSach);
		
		JPanel pnlGiaMua = new JPanel();
		pnlGiaMua.setLayout(null);
		pnlGiaMua.setBounds(10, 178, 302, 65);
		pnlThongTin.add(pnlGiaMua);
		
		JLabel lblGiaMua = new JLabel("Giá Mua: ");
		lblGiaMua.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaMua.setBounds(110, 5, 87, 22);
		pnlGiaMua.add(lblGiaMua);
		
		txtGiaMuaSach = new JTextField();
		txtGiaMuaSach.setColumns(10);
		txtGiaMuaSach.setBounds(10, 35, 282, 24);
		pnlGiaMua.add(txtGiaMuaSach);
		
		JPanel pnlGiaBan = new JPanel();
		pnlGiaBan.setLayout(null);
		pnlGiaBan.setBounds(10, 256, 302, 65);
		pnlThongTin.add(pnlGiaBan);
		
		JLabel lblGiaBan = new JLabel("Giá Bán: ");
		lblGiaBan.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaBan.setBounds(111, 5, 87, 22);
		pnlGiaBan.add(lblGiaBan);
		
		txtGiaBanSach = new JTextField();
		txtGiaBanSach.setEditable(false);
		txtGiaBanSach.setColumns(10);
		txtGiaBanSach.setBounds(10, 35, 282, 24);
		pnlGiaBan.add(txtGiaBanSach);
		
		JPanel pnlSoLuong = new JPanel();
		pnlSoLuong.setLayout(null);
		pnlSoLuong.setBounds(10, 334, 302, 65);
		pnlThongTin.add(pnlSoLuong);
		
		JLabel lblSoLuong = new JLabel("Số Lượng: ");
		lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoLuong.setBounds(105, 5, 99, 22);
		pnlSoLuong.add(lblSoLuong);
		
		txtSoLuongSach = new JTextField();
		txtSoLuongSach.setColumns(10);
		txtSoLuongSach.setBounds(10, 35, 282, 24);
		pnlSoLuong.add(txtSoLuongSach);
		
		JPanel pnlTinhTrang = new JPanel();
		pnlTinhTrang.setLayout(null);
		pnlTinhTrang.setBounds(10, 412, 302, 65);
		pnlThongTin.add(pnlTinhTrang);
		
		JLabel lblTinhTrang = new JLabel("Tinh Trạng: ");
		lblTinhTrang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTinhTrang.setBounds(103, 5, 99, 22);
		pnlTinhTrang.add(lblTinhTrang);
		
		cbTinhTrangSach = new JComboBox();
		cbTinhTrangSach.setBounds(10, 35, 282, 24);
		pnlTinhTrang.add(cbTinhTrangSach);
		
		JPanel pnlMa_1 = new JPanel();
		pnlMa_1.setLayout(null);
		pnlMa_1.setBounds(10, 490, 302, 65);
		pnlThongTin.add(pnlMa_1);
		
		JLabel lblMaKeHang = new JLabel("Mã Kệ Hàng: ");
		lblMaKeHang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKeHang.setBounds(28, 10, 116, 22);
		pnlMa_1.add(lblMaKeHang);
		
		cbMaKeHangSach = new JComboBox();
		cbMaKeHangSach.setBounds(10, 35, 138, 24);
		pnlMa_1.add(cbMaKeHangSach);
		
		JLabel lblMaDanhMuc = new JLabel("Mã Danh Mục: ");
		lblMaDanhMuc.setBounds(166, 10, 136, 22);
		pnlMa_1.add(lblMaDanhMuc);
		lblMaDanhMuc.setFont(new Font("Arial", Font.PLAIN, 18));
		
		cbMaDanhMucSach = new JComboBox();
		cbMaDanhMucSach.setBounds(158, 35, 138, 24);
		pnlMa_1.add(cbMaDanhMucSach);
		
		JPanel pnlMa_2 = new JPanel();
		pnlMa_2.setLayout(null);
		pnlMa_2.setBounds(10, 568, 302, 65);
		pnlThongTin.add(pnlMa_2);
		
		JLabel lblMaKhuyenMai = new JLabel("Mã Khuyến Mãi: ");
		lblMaKhuyenMai.setBounds(20, 10, 138, 22);
		pnlMa_2.add(lblMaKhuyenMai);
		lblMaKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 18));
		
		cbMaKhuyenMaiSach = new JComboBox<String>();
		cbMaKhuyenMaiSach.setBounds(10, 35, 138, 24);
		pnlMa_2.add(cbMaKhuyenMaiSach);
		
		JLabel lblmaNCC = new JLabel("Mã NCC: ");
		lblmaNCC.setFont(new Font("Arial", Font.PLAIN, 18));
		lblmaNCC.setBounds(184, 10, 96, 22);
		pnlMa_2.add(lblmaNCC);
		
		cbMaNhaCungCapSach = new JComboBox<String>();
		cbMaNhaCungCapSach.setBounds(158, 35, 138, 24);
		pnlMa_2.add(cbMaNhaCungCapSach);
		
		JPanel pnlThueVAT = new JPanel();
		pnlThueVAT.setLayout(null);
		pnlThueVAT.setBounds(10, 646, 302, 65);
		pnlThongTin.add(pnlThueVAT);
		
		JLabel lblThueVAT = new JLabel("Thuế VAT: ");
		lblThueVAT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblThueVAT.setBounds(105, 10, 99, 22);
		pnlThueVAT.add(lblThueVAT);
		
		txtThueVATSach = new JTextField();
		txtThueVATSach.setColumns(10);
		txtThueVATSach.setBounds(10, 35, 282, 24);
		pnlThueVAT.add(txtThueVATSach);
		
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
		txtMessageSach.setBounds(21, 74, 755, 26);
		pnlChiTiet.add(txtMessageSach);
		txtMessageSach.setColumns(10);
		txtMessageSach.setToolTipText("");
		txtMessageSach.setFont(new Font("Arial", Font.ITALIC, 10));
		txtMessageSach.setBackground(new Color(240, 240, 240));
		txtMessageSach.setText("");
		txtMessageSach.setBorder(null);
		txtMessageSach.setEditable(false);
		txtMessageSach.setBounds(24, 107, 1094, 19);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBounds(335, 167, 813, 175);
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
		
		JLabel lblTimKiemSP = new JLabel("Tìm kiếm sản phẩm theo mã:");
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
		
		txtMaVanPhongPham = new JTextField();
		txtMaVanPhongPham.setEnabled(false);
		txtMaVanPhongPham.setEditable(false);
		txtMaVanPhongPham.setColumns(10);
		txtMaVanPhongPham.setBounds(10, 35, 282, 24);
		pnlMaSP_1.add(txtMaVanPhongPham);
		
		JPanel pnlTenSP_1 = new JPanel();
		pnlTenSP_1.setLayout(null);
		pnlTenSP_1.setBounds(10, 100, 302, 65);
		pnlThongTin_1.add(pnlTenSP_1);
		
		JLabel lblTenSP_1 = new JLabel("Tên Sản Phẩm: ");
		lblTenSP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenSP_1.setBounds(88, 5, 139, 22);
		pnlTenSP_1.add(lblTenSP_1);
		
		txtTenVanPhongPham = new JTextField();
		txtTenVanPhongPham.setColumns(10);
		txtTenVanPhongPham.setBounds(10, 35, 282, 24);
		pnlTenSP_1.add(txtTenVanPhongPham);
		
		JPanel pnlGiaMua_1 = new JPanel();
		pnlGiaMua_1.setLayout(null);
		pnlGiaMua_1.setBounds(10, 178, 302, 65);
		pnlThongTin_1.add(pnlGiaMua_1);
		
		JLabel lblGiaMua_1 = new JLabel("Giá Mua: ");
		lblGiaMua_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaMua_1.setBounds(110, 5, 87, 22);
		pnlGiaMua_1.add(lblGiaMua_1);
		
		txtGiaMuaVPP = new JTextField();
		txtGiaMuaVPP.setColumns(10);
		txtGiaMuaVPP.setBounds(10, 35, 282, 24);
		pnlGiaMua_1.add(txtGiaMuaVPP);
		
		JPanel pnlGiaBan_1 = new JPanel();
		pnlGiaBan_1.setLayout(null);
		pnlGiaBan_1.setBounds(10, 256, 302, 65);
		pnlThongTin_1.add(pnlGiaBan_1);
		
		JLabel lblGiaBan_1 = new JLabel("Giá Bán: ");
		lblGiaBan_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiaBan_1.setBounds(111, 5, 87, 22);
		pnlGiaBan_1.add(lblGiaBan_1);
		
		txtGiaBanVPP = new JTextField();
		txtGiaBanVPP.setColumns(10);
		txtGiaBanVPP.setBounds(10, 35, 282, 24);
		pnlGiaBan_1.add(txtGiaBanVPP);
		
		JPanel pnlSoLuong_1 = new JPanel();
		pnlSoLuong_1.setLayout(null);
		pnlSoLuong_1.setBounds(10, 334, 302, 65);
		pnlThongTin_1.add(pnlSoLuong_1);
		
		JLabel lblSoLuong_1 = new JLabel("Số Lượng: ");
		lblSoLuong_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoLuong_1.setBounds(105, 5, 99, 22);
		pnlSoLuong_1.add(lblSoLuong_1);
		
		txtSoLuongVPP = new JTextField();
		txtSoLuongVPP.setEditable(false);
		txtSoLuongVPP.setColumns(10);
		txtSoLuongVPP.setBounds(10, 35, 282, 24);
		pnlSoLuong_1.add(txtSoLuongVPP);
		
		JPanel pnlTinhTrang_1 = new JPanel();
		pnlTinhTrang_1.setLayout(null);
		pnlTinhTrang_1.setBounds(10, 412, 302, 65);
		pnlThongTin_1.add(pnlTinhTrang_1);
		
		JLabel lblTinhTrang_1 = new JLabel("Tinh Trạng: ");
		lblTinhTrang_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTinhTrang_1.setBounds(103, 5, 99, 22);
		pnlTinhTrang_1.add(lblTinhTrang_1);
		
		cbTinhTrangVPP = new JComboBox();
		cbTinhTrangVPP.setBounds(10, 35, 282, 24);
		pnlTinhTrang_1.add(cbTinhTrangVPP);
		
		JPanel pnlMa_3 = new JPanel();
		pnlMa_3.setLayout(null);
		pnlMa_3.setBounds(10, 490, 302, 65);
		pnlThongTin_1.add(pnlMa_3);
		
		JLabel lblMaKeHang_1 = new JLabel("Mã Kệ Hàng: ");
		lblMaKeHang_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKeHang_1.setBounds(28, 10, 116, 22);
		pnlMa_3.add(lblMaKeHang_1);
		
		cbMaKeHangVPP = new JComboBox();
		cbMaKeHangVPP.setBounds(10, 35, 138, 24);
		pnlMa_3.add(cbMaKeHangVPP);
		
		JLabel lblMaDanhMuc_1 = new JLabel("Mã Danh Mục: ");
		lblMaDanhMuc_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaDanhMuc_1.setBounds(166, 10, 136, 22);
		pnlMa_3.add(lblMaDanhMuc_1);
		
		cbMaDanhMucVPP = new JComboBox();
		cbMaDanhMucVPP.setBounds(158, 35, 138, 24);
		pnlMa_3.add(cbMaDanhMucVPP);
		
		JPanel pnlMa_4 = new JPanel();
		pnlMa_4.setLayout(null);
		pnlMa_4.setBounds(10, 568, 302, 65);
		pnlThongTin_1.add(pnlMa_4);
		
		JLabel lblMaKhuyenMai_1 = new JLabel("Mã Khuyến Mãi: ");
		lblMaKhuyenMai_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKhuyenMai_1.setBounds(20, 10, 138, 22);
		pnlMa_4.add(lblMaKhuyenMai_1);
		
		cbMaKhuyenMaiVPP = new JComboBox();
		cbMaKhuyenMaiVPP.setBounds(10, 35, 138, 24);
		pnlMa_4.add(cbMaKhuyenMaiVPP);
		
		JLabel lblMaNCC_1 = new JLabel("Mã NCC: ");
		lblMaNCC_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaNCC_1.setBounds(184, 10, 96, 22);
		pnlMa_4.add(lblMaNCC_1);
		
		cbMaNhaCungCapVPP = new JComboBox();
		cbMaNhaCungCapVPP.setBounds(158, 35, 138, 24);
		pnlMa_4.add(cbMaNhaCungCapVPP);
		
		JPanel pnlThueVAT_1 = new JPanel();
		pnlThueVAT_1.setLayout(null);
		pnlThueVAT_1.setBounds(10, 646, 302, 65);
		pnlThongTin_1.add(pnlThueVAT_1);
		
		JLabel lblThueVAT_1 = new JLabel("Thuế VAT:");
		lblThueVAT_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblThueVAT_1.setBounds(105, 10, 99, 22);
		pnlThueVAT_1.add(lblThueVAT_1);
		
		txtThueVATVPP = new JTextField();
		txtThueVATVPP.setColumns(10);
		txtThueVATVPP.setBounds(10, 35, 282, 24);
		pnlThueVAT_1.add(txtThueVATVPP);
		
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
		txtMessageVPP.setBounds(20, 76, 756, 24);
		pnlChiTiet_1.add(txtMessageVPP);
		txtMessageVPP.setColumns(10);
		txtMessageVPP.setToolTipText("");
		txtMessageVPP.setFont(new Font("Arial", Font.ITALIC, 10));
		txtMessageVPP.setBackground(new Color(240, 240, 240));
		txtMessageVPP.setText("");
		txtMessageVPP.setBorder(null);
		txtMessageVPP.setEditable(false);
		txtMessageVPP.setBounds(24, 107, 1094, 19);
		
		JPanel pnlChucNang_1 = new JPanel();
		pnlChucNang_1.setLayout(null);
		pnlChucNang_1.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang_1.setBounds(335, 167, 813, 175);
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
		
		JLabel lblTimKiemSP_1 = new JLabel("Tìm kiếm thông tin sản phẩm:");
		lblTimKiemSP_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiemSP_1.setBounds(441, 59, 231, 22);
		pnlChucNang_1.add(lblTimKiemSP_1);
		
		txtTimKiemVPP = new JTextField();
		txtTimKiemVPP.setColumns(10);
		txtTimKiemVPP.setBounds(441, 91, 231, 24);
		pnlChucNang_1.add(txtTimKiemVPP);
		
		btnTimKiemVPP = new JButton("");
		btnTimKiemVPP.setBounds(698, 59, 68, 56);
		pnlChucNang_1.add(btnTimKiemVPP);
		Image img_iconTimKiem_1 = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		btnTimKiemVPP.setIcon(new ImageIcon(img_iconTimKiem_1));
		
		
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
				
		napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
		napDuLieuVPPTuCSDL(vpPham_dao.getAllVPP("VPP"));
		napComboBoxMaKeHang(keHang_dao.getAllKeHang());
		napComboBoxMaDanhMuc(danhMuc_dao.getAllDanhMuc());
		napComboBoxMaNhaCungCap(nhaCungCap_dao.getAllNhaCungCap());
		napComboBoxMaKhuyenMai(khuyenMai_dao.getKhuyenMaiTheoDoiTuongApDung("Sản phẩm"));
				
				
		
		btnThemSach.addActionListener(this);
		btnThemVPP.addActionListener(this);
		btnLamMoiSach.addActionListener(this);
		btnLamMoiVPP.addActionListener(this);
		btnCapNhatSach.addActionListener(this);
		btnCapNhatVPP.addActionListener(this);
		btnTimKiemSach.addActionListener(this);
		btnTimKiemVPP.addActionListener(this);
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
		cbMaDanhMucVPP.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	public void napComboBoxMaKhuyenMai(ArrayList<KhuyenMai> ds) {
		int n = ds.size();
		String items[] = new String[n+1];
		items[0] = " ";
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
		float giaBan = Float.parseFloat(txtGiaBanSach.getText().trim());
		String nhaXuatBan= txtNhaXuatBan.getText().trim();
		String tacGia= txtTacGia.getText().trim();
		int namXuatBan = Integer.parseInt(txtNamXB.getText().trim());
		int soTrang = Integer.parseInt(txtSoTrang.getText().trim());
		float thueVAT = Float.parseFloat(txtThueVATSach.getText().trim());
		DanhMuc dm = new DanhMuc( (String) cbMaDanhMucSach.getSelectedItem());
		KeHang km = new KeHang( (String) cbMaKeHangSach.getSelectedItem());
		String maKhuyenMai = (String) cbMaKhuyenMaiSach.getSelectedItem();
		KhuyenMai khuyenMai;
	    if (maKhuyenMai.isEmpty()) {
	        khuyenMai = null;  
	    } else {
	        khuyenMai = new KhuyenMai(maKhuyenMai);
	    }
		khuyenMai= new KhuyenMai( maKhuyenMai);
		NhaCungCap ncc = new NhaCungCap( (String) cbMaNhaCungCapSach.getSelectedItem());
		String tinhTrang = (String) cbTinhTrangSach.getSelectedItem();
		maSach = phatSinhMaSach();
		Sach s = new Sach(maSach, tenSach, giaMua, soLuong, giaBan, thueVAT, dm, km, khuyenMai, ncc, tinhTrang, tacGia, nhaXuatBan, namXuatBan, soTrang);
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
					float giaBan = Float.parseFloat(txtGiaBanSach.getText().trim());
					String nhaXuatBan= txtNhaXuatBan.getText().trim();
					String tacGia= txtTacGia.getText().trim();
					int namXuatBan = Integer.parseInt(txtNamXB.getText().trim());
					int soTrang = Integer.parseInt(txtSoTrang.getText().trim());
					float thueVAT = Float.parseFloat(txtThueVATSach.getText().trim());
					DanhMuc dm = new DanhMuc( (String) cbMaDanhMucSach.getSelectedItem());
					KeHang km = new KeHang( (String) cbMaKeHangSach.getSelectedItem());
					KhuyenMai khuyenMai = new KhuyenMai( (String) cbMaKhuyenMaiSach.getSelectedItem());
					NhaCungCap ncc = new NhaCungCap( (String) cbMaNhaCungCapSach.getSelectedItem());
					String tinhTrang = (String) cbTinhTrangSach.getSelectedItem();
					Sach newSach = new Sach(maSach, tenSach, giaMua, soLuong, giaBan, thueVAT, dm, km, khuyenMai, ncc, tinhTrang, tacGia, nhaXuatBan, namXuatBan, soTrang);
				if (!sach_dao.capnhatSach(newSach)) {
					System.out.println(newSach);
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
		txtNhaXuatBan.setText(tblSach.getValueAt(r, 5).toString());
		txtTacGia.setText(tblSach.getValueAt(r, 6).toString());
		txtNamXB.setText(tblSach.getValueAt(r, 7).toString());
		txtSoTrang.setText(tblSach.getValueAt(r, 8).toString());
		txtThueVATSach.setText(tblSach.getValueAt(r, 9).toString());
		cbMaDanhMucSach.setSelectedItem(tblSach.getValueAt(r, 10).toString());
		cbMaKeHangSach.setSelectedItem(tblSach.getValueAt(r, 11).toString());
		// Check for null before calling toString()
	    Object maKMObject = tblSach.getValueAt(r, 12);
	    String maKM = (maKMObject != null) ? maKMObject.toString() : "";

	    if (maKM.isEmpty()) {
	        cbMaKhuyenMaiSach.setSelectedItem("KM001");
	    } else {
	        cbMaKhuyenMaiSach.setSelectedItem(maKM);
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
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThemSach)) {
			if (validDateSach()) {
				Sach s = revertSachFromFields();
				if (!sach_dao.themSach(s)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
					tblSach.clearSelection();
//					txtMessage.setText("");
				}
			}	
		}else if(o.equals(btnCapNhatSach)) {
			updateSach();
			napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
			tblSach.clearSelection();
		}else if(o.equals(btnLamMoiSach)) {
			xoaTrangSach();
			napDuLieuSachTuCSDL(sach_dao.getAllSach("S"));
			tblSach.clearSelection();
		}else if(o.equals(btnTimKiemSach)) {
			timSachTheoTen();
		}
	
	
	}
}
