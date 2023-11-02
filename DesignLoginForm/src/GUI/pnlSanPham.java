package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
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
import javax.swing.ScrollPaneConstants;

public class pnlSanPham extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;

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
		
		JLabel lblNewLabel = new JLabel("Mã Sản Phẩm: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(90, 5, 128, 22);
		pnlMaSP.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 282, 24);
		pnlMaSP.add(textField);
		textField.setColumns(10);
		
		JPanel pnlTenSP = new JPanel();
		pnlTenSP.setLayout(null);
		pnlTenSP.setBounds(10, 100, 302, 65);
		pnlThongTin.add(pnlTenSP);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Sản Phẩm: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(88, 5, 139, 22);
		pnlTenSP.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 35, 282, 24);
		pnlTenSP.add(textField_1);
		
		JPanel pnlGiaMua = new JPanel();
		pnlGiaMua.setLayout(null);
		pnlGiaMua.setBounds(10, 178, 302, 65);
		pnlThongTin.add(pnlGiaMua);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá Mua: ");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(110, 5, 87, 22);
		pnlGiaMua.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 35, 282, 24);
		pnlGiaMua.add(textField_2);
		
		JPanel pnlGiaBan = new JPanel();
		pnlGiaBan.setLayout(null);
		pnlGiaBan.setBounds(10, 256, 302, 65);
		pnlThongTin.add(pnlGiaBan);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giá Bán: ");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(111, 5, 87, 22);
		pnlGiaBan.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 35, 282, 24);
		pnlGiaBan.add(textField_3);
		
		JPanel pnlSoLuong = new JPanel();
		pnlSoLuong.setLayout(null);
		pnlSoLuong.setBounds(10, 334, 302, 65);
		pnlThongTin.add(pnlSoLuong);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số Lượng: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(105, 5, 99, 22);
		pnlSoLuong.add(lblNewLabel_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 35, 282, 24);
		pnlSoLuong.add(textField_4);
		
		JPanel pnlTinhTrang = new JPanel();
		pnlTinhTrang.setLayout(null);
		pnlTinhTrang.setBounds(10, 412, 302, 65);
		pnlThongTin.add(pnlTinhTrang);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tinh Trạng: ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(103, 5, 99, 22);
		pnlTinhTrang.add(lblNewLabel_1_1_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 35, 282, 24);
		pnlTinhTrang.add(comboBox);
		
		JPanel pnlMaKeHang = new JPanel();
		pnlMaKeHang.setLayout(null);
		pnlMaKeHang.setBounds(10, 490, 302, 65);
		pnlThongTin.add(pnlMaKeHang);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Mã Kệ Hàng: ");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1.setBounds(101, 5, 116, 22);
		pnlMaKeHang.add(lblNewLabel_1_1_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 35, 282, 24);
		pnlMaKeHang.add(comboBox_1);
		
		JPanel pnlMaDanhMuc = new JPanel();
		pnlMaDanhMuc.setLayout(null);
		pnlMaDanhMuc.setBounds(10, 568, 302, 65);
		pnlThongTin.add(pnlMaDanhMuc);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Mã Danh Mục: ");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(97, 5, 136, 22);
		pnlMaDanhMuc.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(10, 35, 282, 24);
		pnlMaDanhMuc.add(comboBox_1_1);
		
		JPanel pnlMaKhuyenMai = new JPanel();
		pnlMaKhuyenMai.setLayout(null);
		pnlMaKhuyenMai.setBounds(10, 646, 302, 65);
		pnlThongTin.add(pnlMaKhuyenMai);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Mã Khuyến Mãi: ");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(93, 5, 147, 22);
		pnlMaKhuyenMai.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(10, 35, 282, 24);
		pnlMaKhuyenMai.add(comboBox_1_1_1);
		
		JPanel pnlThongTinSach = new JPanel();
		pnlThongTinSach.setBorder(new TitledBorder(null, "Th\u00F4ng tin S\u00E1ch: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSach.setBounds(335, 10, 813, 147);
		pnlSach.add(pnlThongTinSach);
		pnlThongTinSach.setLayout(null);
		
		JPanel pnlChiTiet = new JPanel();
		pnlChiTiet.setLayout(null);
		pnlChiTiet.setBounds(10, 20, 786, 110);
		pnlThongTinSach.add(pnlChiTiet);
		
		JLabel lblNewLabel_2 = new JLabel("Tác Giả:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 20, 77, 22);
		pnlChiTiet.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 20, 200, 24);
		pnlChiTiet.add(textField_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nhà Xuất Bản:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(20, 64, 132, 22);
		pnlChiTiet.add(lblNewLabel_2_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(178, 64, 200, 24);
		pnlChiTiet.add(textField_6);
		
		JLabel lblNewLabel_2_2 = new JLabel("Năm Xuất Bản: ");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(418, 18, 132, 22);
		pnlChiTiet.add(lblNewLabel_2_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(576, 18, 200, 24);
		pnlChiTiet.add(textField_7);
		
		JLabel lblNewLabel_2_3 = new JLabel("Số Trang: ");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(418, 64, 96, 22);
		pnlChiTiet.add(lblNewLabel_2_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(576, 64, 200, 24);
		pnlChiTiet.add(textField_8);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBounds(335, 167, 813, 175);
		pnlSach.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setBounds(70, 28, 144, 49);
		pnlChucNang.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_1.setBounds(329, 28, 144, 49);
		pnlChucNang.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cập Nhật");
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(602, 28, 144, 49);
		pnlChucNang.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tìm kiếm sản phẩm:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(70, 114, 177, 22);
		pnlChucNang.add(lblNewLabel_2_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(279, 114, 395, 24);
		pnlChucNang.add(textField_9);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(686, 114, 60, 24);
		pnlChucNang.add(btnNewButton_2);
		
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Gi\u00E1 Mua", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 B\u00E1n", "Nh\u00E0 Xu\u1EA5t B\u1EA3n", "T\u00E1c Gi\u1EA3", "N\u0103m Xu\u1EA5t B\u1EA3n", "S\u1ED1 Trang", "M\u00E3 Danh M\u1EE5c", "M\u00E3 K\u1EC7 H\u00E0ng", "M\u00E3 Khuy\u1EBFn M\u00E3i", "T\u00ECnh Tr\u1EA1ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Float.class, Integer.class, Float.class, String.class, String.class, Integer.class, Integer.class, Object.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
}
