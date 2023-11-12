package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import GUI.FrameDashBoard.PanelbtnMouseAdapter;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_KhachHang;
import entity.KhachHang;

import javax.swing.JButton;

public class pnlKhachHang extends JPanel implements ActionListener, MouseListener, DocumentListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSoDT;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JTable table;
	private JTextField txtSearch;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JDateChooser jdNgaySinh;
	private JButton btnThem, btnSua, btnLammoi;
	private Dao_KhachHang khachHang_dao;
	private DefaultTableModel modelKH;

	/**
	 * Create the panel.
	 */
	public pnlKhachHang() {
		// Khởi tạo kết nối đến database
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		khachHang_dao = new Dao_KhachHang();

		setBackground(Color.WHITE);
		setBounds(0, 0, 1163, 763);
		setLayout(null);

		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlInfo.setBounds(20, 10, 237, 743);
		add(pnlInfo);
		pnlInfo.setLayout(null);

		JPanel pnlMaKH = new JPanel();
		pnlMaKH.setBounds(10, 30, 218, 80);
		pnlInfo.add(pnlMaKH);
		pnlMaKH.setLayout(null);

		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaKH.setBounds(10, 10, 138, 30);
		pnlMaKH.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(10, 40, 201, 30);
		pnlMaKH.add(txtMaKH);
		txtMaKH.setColumns(10);

		JPanel pnlMaKH_1 = new JPanel();
		pnlMaKH_1.setLayout(null);
		pnlMaKH_1.setBounds(10, 120, 218, 80);
		pnlInfo.add(pnlMaKH_1);

		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKH.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenKH.setBounds(10, 0, 200, 30);
		pnlMaKH_1.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(10, 40, 200, 30);
		pnlMaKH_1.add(txtTenKH);

		JPanel pnlNgaySinh = new JPanel();
		pnlNgaySinh.setBounds(10, 210, 218, 80);
		pnlInfo.add(pnlNgaySinh);
		pnlNgaySinh.setLayout(null);

		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNgaySinh.setBounds(10, 10, 106, 25);
		pnlNgaySinh.add(lblNgaySinh);

		jdNgaySinh = new JDateChooser();
		jdNgaySinh.setDateFormatString("yyyy-MM-dd");
		jdNgaySinh.setBounds(10, 45, 200, 35);
		pnlNgaySinh.add(jdNgaySinh);

		// giới tính
		JPanel pnlGioi = new JPanel();
		pnlGioi.setBounds(10, 300, 218, 70);
		pnlInfo.add(pnlGioi);
		pnlGioi.setLayout(null);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGioiTinh.setBounds(10, 10, 86, 25);
		pnlGioi.add(lblGioiTinh);

		radNam = new JRadioButton("Nam");
		radNam.setFont(new Font("Arial", Font.PLAIN, 18));
		radNam.setBounds(10, 39, 69, 25);
		pnlGioi.add(radNam);

		radNu = new JRadioButton("Nữ");
		radNu.setFont(new Font("Arial", Font.PLAIN, 18));
		radNu.setBounds(114, 39, 61, 25);
		pnlGioi.add(radNu);

		ButtonGroup group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);

		// panel số điện thoại
		JPanel pnlSoDT = new JPanel();
		pnlSoDT.setLayout(null);
		pnlSoDT.setBounds(10, 380, 218, 80);
		pnlInfo.add(pnlSoDT);

		JLabel lblSoDT = new JLabel("Số điện thoại:");
		lblSoDT.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoDT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoDT.setBounds(10, 10, 119, 30);
		pnlSoDT.add(lblSoDT);

		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(10, 43, 200, 30);
		pnlSoDT.add(txtSoDT);

		JPanel pnlEmail = new JPanel();
		pnlEmail.setLayout(null);
		pnlEmail.setBounds(10, 470, 218, 80);
		pnlInfo.add(pnlEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(10, 0, 99, 30);
		pnlEmail.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 40, 200, 30);
		pnlEmail.add(txtEmail);

		// panel Địa chỉ
		JPanel pnlDiaChi = new JPanel();
		pnlDiaChi.setLayout(null);
		pnlDiaChi.setBounds(10, 560, 218, 80);
		pnlInfo.add(pnlDiaChi);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDiaChi.setBounds(10, 0, 71, 30);
		pnlDiaChi.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 40, 200, 30);
		pnlDiaChi.add(txtDiaChi);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(null, "chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBounds(260, 10, 893, 219);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);
		Image img_iconAdd = new ImageIcon(this.getClass().getResource("/icon_add_s.png")).getImage();
		Image img_iconUpdate = new ImageIcon(this.getClass().getResource("/icon_update_s.png")).getImage();
		Image img_iconLammoi = new ImageIcon(this.getClass().getResource("/icon_lammoi_s.png")).getImage();

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBounds(22, 116, 787, 78);
		pnlChucNang.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		JLabel lblSearch = new JLabel("Tìm Kiếm khách hàng:");
		lblSearch.setFont(new Font("Arial", Font.BOLD, 18));
		lblSearch.setBounds(10, 10, 206, 48);
		pnlTimKiem.add(lblSearch);

		txtSearch = new JTextField();
		txtSearch.setBounds(226, 21, 428, 31);
		pnlTimKiem.add(txtSearch);
		txtSearch.setColumns(10);

		// chức năng search
		JPanel pnlSearch = new JPanel();
//		pnlSearch.addMouseListener(new PanelbtnMouseAdapter(pnlSearch) {
//
//		});
		pnlSearch.setBackground(SystemColor.activeCaption);
		pnlSearch.setBounds(687, 10, 60, 60);
		pnlTimKiem.add(pnlSearch);
		pnlSearch.setLayout(null);

		JLabel lblIconSearch = new JLabel("");
		lblIconSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSearch.setBounds(0, 0, 60, 60);
		pnlSearch.add(lblIconSearch);
		Image img_iconSearch = new ImageIcon(this.getClass().getResource("/icon_search_s.png")).getImage();
		lblIconSearch.setIcon(new ImageIcon(img_iconSearch));

		// nút thêm khách hàng
		btnThem = new JButton("Thêm khách hàng");
		btnThem.setFont(new Font("Arial", Font.BOLD, 15));
		btnThem.setBounds(22, 21, 228, 63);
		btnThem.setIcon(new ImageIcon(img_iconAdd));
		pnlChucNang.add(btnThem);

		btnSua = new JButton("Sửa khách hàng");
		btnSua.setFont(new Font("Arial", Font.BOLD, 15));
		btnSua.setBounds(283, 21, 228, 63);
		btnSua.setIcon(new ImageIcon(img_iconUpdate));
		pnlChucNang.add(btnSua);

		btnLammoi = new JButton("Làm mới");
		btnLammoi.setFont(new Font("Arial", Font.BOLD, 15));
		btnLammoi.setBounds(549, 21, 228, 63);
		btnLammoi.setIcon(new ImageIcon(img_iconLammoi));
		pnlChucNang.add(btnLammoi);

		JPanel pnlDSKH = new JPanel();
		pnlDSKH.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlDSKH.setBounds(260, 239, 893, 514);
		add(pnlDSKH);
		pnlDSKH.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 873, 484);
		pnlDSKH.add(scrollPane);

		// Create Table
		String[] cols = new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Địa chỉ",
				"Giới tính", "Ngày sinh" };
		modelKH = new DefaultTableModel(cols, 0);

		table = new JTable(modelKH);
		scrollPane.setViewportView(table);

		// goi ham do data on table
		DoDataOnTable();

		setVisible(true);

		// đăng ký sự kiện
		table.addMouseListener(this);
		txtSearch.getDocument().addDocumentListener(this);
		btnLammoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
	}

//	// xử lý sự kiện nhấp chuột
//	private class PanelbtnMouseAdapter extends MouseAdapter {
//		JPanel panel;
//
//		public PanelbtnMouseAdapter(JPanel panel) {
//			this.panel = panel;
//		}
//
//		/*
//		 * Phương thức này được gọi khi con trỏ chuột vào đối tượng JPanel mà đối tượng
//		 * PanelbtnMouseAdapter được gắn vào
//		 */
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			panel.setBackground(new Color(230, 230, 250));
//		}
//
//		/*
//		 * Phương thức này được gọi khi con trỏ chuột rời khỏi đối tượng JPanel
//		 */
//		@Override
//		public void mouseExited(MouseEvent e) {
//			panel.setBackground(new Color(176, 196, 222));
//		}
//
//		/*
//		 * Phương thức này được gọi khi người dùng nhấn chuột lên đối tượng JPanel
//		 */
//		@Override
//		public void mousePressed(MouseEvent e) {
//			panel.setBackground(new Color(60, 179, 113));
//		}
//
//		/*
//		 * Phương thức này được gọi khi người dùng thả chuột sau khi đã nhấn
//		 */
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			panel.setBackground(new Color(176, 196, 222));
//		}
//
//	}

	/*
	 * ham do data on tale
	 */
	public void DoDataOnTable() {
		khachHang_dao = new Dao_KhachHang();
		List<KhachHang> dsKhachHang = khachHang_dao.getAllKhachHang();
		for (KhachHang kh : dsKhachHang) {
			modelKH.addRow(new Object[] { kh.getMaKhachhang(), kh.getTenKhachHang(), kh.getSoDT(), kh.getEmail(),
					kh.getDiaChi(), kh.isGioiTinh() ? "Nam" : "Nữ", kh.getNgaySinh() });
		}
	}

	/*
	 * hàm get data lên txtField
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaKH.setText(modelKH.getValueAt(row, 0).toString());
		txtTenKH.setText(modelKH.getValueAt(row, 1).toString());
		txtSoDT.setText(modelKH.getValueAt(row, 2).toString());
		txtEmail.setText(modelKH.getValueAt(row, 3).toString());
		txtDiaChi.setText(modelKH.getValueAt(row, 4).toString());
		String gt = table.getValueAt(row, 5).toString();
		if (gt.equals("Nam")) {
			radNam.setSelected(true);
		} else {
			radNu.setSelected(true);
		}

		jdNgaySinh.setDate((java.util.Date) modelKH.getValueAt(row, 6));

	}

	/*
	 * xoa data on table
	 */
	private void clearDataOnTalbe() {
		while (modelKH.getRowCount() != 0) {
			modelKH.removeRow(0);
		}
	}

	/*
	 * xóa rỗng textField
	 */
	private void clearTextField() {
		Date now = new Date();
		txtMaKH.setText("");
		txtTenKH.setText("");
		jdNgaySinh.setDate(null);
		radNam.setSelected(true);
		txtSoDT.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
	}

	/*
	 * update info khachHang
	 */
	private void replaceID() {
		int pos = table.getSelectedRow();

		if (pos == -1) {
			JOptionPane.showMessageDialog(null, "vui long chon dong can sua");
			return;
		}

		String ma = txtMaKH.getText();
		String ten = txtTenKH.getText();
		String diachi = txtDiaChi.getText();
		String sdt = txtSoDT.getText();
		String email = txtEmail.getText();
		boolean gioi = radNam.isSelected();
		Date ngaySinh = jdNgaySinh.getDate();
		java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());

		KhachHang kh = new KhachHang(ma, ten, diachi, sqlNgaySinh, sdt, email, gioi);

		try {
			khachHang_dao.update(kh);
			clearDataOnTalbe();
			DoDataOnTable();
			JOptionPane.showMessageDialog(this, "sua thanh con");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	/*
	 * hàm genarateOBJKhachhang lấy data from TXT thành OBJ
	 */
	private KhachHang genarateOBJKH() {
		KhachHang temp;

		int soLuong = khachHang_dao.getSoLuong();
		if (soLuong == -1) {
			JOptionPane.showMessageDialog(null, " phát sinh mã thất bại - vui lòng thử lại");
			return null;
		}

		String ma = String.format("KH%07d", soLuong + 1);

		if (txtTenKH.getText().isEmpty()) {
			return null;
		}
		String ten = txtTenKH.getText();
		Date dateNS = jdNgaySinh.getDate();
		java.sql.Date sqlNS = new java.sql.Date(dateNS.getTime());

		boolean gioi = radNam.isSelected();

		if (txtSoDT.getText().isEmpty()) {
			return null;
		}
		String sdt = txtSoDT.getText();
		String email = txtEmail.getText();
		String diachi = txtDiaChi.getText();
		try {
			temp = new KhachHang(ma, ten, diachi, sqlNS, sdt, email, gioi);
			return temp;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	/*
	 * kiểm tra data
	 */
	private boolean validData() {
		String ten = txtTenKH.getText().trim();
		String sdt = txtSoDT.getText().trim();
		String email = txtEmail.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		Date now = new Date();
		Date ngaySinh = jdNgaySinh.getDate();
		String gioi;

		if (!(ten.matches("[\\p{L}\\p{M} ]+") && ten.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên  không được rỗng, là kí tự");
			txtTenKH.requestFocus();
			return false;
		}

		if (ngaySinh != null) {
			if (ngaySinh.after(now)) {
				JOptionPane.showMessageDialog(this, "Ngày sinh phải trước ngày hiện tại!!");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "vui lòng chọn ngày sinh!!!");
			return false;
		}

		if (!radNam.isSelected() && !radNu.isSelected()) {
			JOptionPane.showMessageDialog(this, "vui lòng chọn giới!!!");
			return false;
		} else {
			if (radNam.isSelected()) {
				gioi = "Nam";
			} else {
				gioi = "Nữ";
			}
		}

		if (sdt.length() > 0) {
			try {
//				int sdtInt = Integer.parseInt(sdt);
//				if (sdtInt < 0) {
//					JOptionPane.showMessageDialog(this, "số điện thoại có định dạng là số nguyên là 10 chữ số!!");
//					return false;
				if (!Pattern.matches("^\\d{10}$", sdt)) {
					JOptionPane.showMessageDialog(this, "số điện thoại có định dạng là số nguyên là 10 chữ số!!");
					return false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "vui lòng nhập lại số điện thoại đúng định dạng là 10 chữ số!!");
				txtSoDT.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "vui lòng nhập số điện thoại");
			return false;
		}

		if (!email.matches(
				"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
				txtEmail.setText("Email sai cú pháp!!!");
				txtEmail.requestFocus();
				return false;
			}

		if (!(diachi.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được rỗng, là kí tự");
			txtDiaChi.requestFocus();
			return false;
		}

		return true;

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

	// su kien nghe
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnLammoi)) {
			clearTextField();
		}

		if (o.equals(btnSua)) {
			replaceID();
		}

		if (o.equals(btnThem)) {
			if (!txtMaKH.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "dang trong che do chinh sua !!!");
				return;
			}

			if (validData()) {
				KhachHang kh = genarateOBJKH();
				try {
					if (!khachHang_dao.createKhachHang(kh)) {
						JOptionPane.showInternalMessageDialog(null, "trung ma");
						return;
					} else {
						clearTextField();
						clearDataOnTalbe();
						DoDataOnTable();
						JOptionPane.showMessageDialog(this, "them khach hang thanh cong");
					}
				} catch (Exception e21) {
					JOptionPane.showMessageDialog(null, e21.getMessage());
				}
			}

		}

	}

	/*
	 * xử lí sự kiện DocumentEvent
	 */

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateTable();

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateTable();

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateTable();

	}

	// tìm kiếm và hiển thị lại danh sách
	public void updateTable() {
		String sdt = txtSearch.getText();
		ArrayList<KhachHang> ds = khachHang_dao.getAllKhachHang();
		ArrayList<KhachHang> dsMoi = new ArrayList<KhachHang>();

		modelKH = (DefaultTableModel) table.getModel();
		modelKH.getDataVector().removeAllElements();

		if (sdt.isEmpty()) {
			DoDataOnTable();
		} else {
			for (KhachHang kh : ds) {
				if (kh.getSoDT().startsWith(sdt)) {
					dsMoi.add(kh);
				}
			}
			for (KhachHang kh : dsMoi) {
				modelKH.addRow(new Object[] { kh.getMaKhachhang(), kh.getTenKhachHang(), kh.getSoDT(), kh.getEmail(),
						kh.getDiaChi(), kh.isGioiTinh() ? "Nam" : "Nữ", kh.getNgaySinh() });
			}
		}
	}

}
