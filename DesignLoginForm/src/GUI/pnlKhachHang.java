package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import GUI.FrameDashBoard.PanelbtnMouseAdapter;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

public class pnlKhachHang extends JPanel {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSoDT;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Create the panel.
	 */
	public pnlKhachHang() {
		setBackground(Color.WHITE);
		setBounds(0,0, 1163, 763);
		setLayout(null);
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlTitle.setBounds(10, 10, 1143, 56);
		add(pnlTitle);
		pnlTitle.setLayout(null);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(244, 0, 628, 56);
		pnlTitle.add(lblTitle);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfo.setBounds(20, 76, 289, 677);
		add(pnlInfo);
		pnlInfo.setLayout(null);
		
		JPanel pnlMaKH = new JPanel();
		pnlMaKH.setBounds(10, 30, 270, 80);
		pnlInfo.add(pnlMaKH);
		pnlMaKH.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaKH.setBounds(10, 10, 200, 30);
		pnlMaKH.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(10, 40, 250, 30);
		pnlMaKH.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JPanel pnlMaKH_1 = new JPanel();
		pnlMaKH_1.setLayout(null);
		pnlMaKH_1.setBounds(10, 120, 270, 80);
		pnlInfo.add(pnlMaKH_1);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKH.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTenKH.setBounds(10, 0, 200, 30);
		pnlMaKH_1.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(10, 40, 250, 30);
		pnlMaKH_1.add(txtTenKH);
		
		JPanel pnlNgaySinh = new JPanel();
		pnlNgaySinh.setBounds(10, 210, 270, 80);
		pnlInfo.add(pnlNgaySinh);
		pnlNgaySinh.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ngày sinh:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 137, 25);
		pnlNgaySinh.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 45, 250, 35);
		pnlNgaySinh.add(dateChooser);
		
		JPanel pnlGioi = new JPanel();
		pnlGioi.setBounds(10, 300, 270, 45);
		pnlInfo.add(pnlGioi);
		pnlGioi.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Giới tính:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 10, 86, 25);
		pnlGioi.add(lblNewLabel_1);
		
		JRadioButton radNam = new JRadioButton("Nam");
		radNam.setFont(new Font("Arial", Font.PLAIN, 18));
		radNam.setBounds(102, 10, 74, 25);
		pnlGioi.add(radNam);
		
		JRadioButton radNu = new JRadioButton("Nữ");
		radNu.setFont(new Font("Arial", Font.PLAIN, 18));
		radNu.setBounds(192, 10, 61, 25);
		pnlGioi.add(radNu);
		
		JPanel pnlSoDT = new JPanel();
		pnlSoDT.setLayout(null);
		pnlSoDT.setBounds(10, 355, 270, 80);
		pnlInfo.add(pnlSoDT);
		
		JLabel lblSoDT = new JLabel("Số điện thoại:");
		lblSoDT.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoDT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoDT.setBounds(10, 10, 200, 30);
		pnlSoDT.add(lblSoDT);
		
		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(10, 43, 250, 30);
		pnlSoDT.add(txtSoDT);
		
		JPanel pnlSoDT_1 = new JPanel();
		pnlSoDT_1.setLayout(null);
		pnlSoDT_1.setBounds(10, 445, 270, 80);
		pnlInfo.add(pnlSoDT_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(10, 0, 200, 30);
		pnlSoDT_1.add(lblEmail);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 40, 250, 30);
		pnlSoDT_1.add(textField);
		
		JPanel pnlSoDT_1_1 = new JPanel();
		pnlSoDT_1_1.setLayout(null);
		pnlSoDT_1_1.setBounds(10, 546, 270, 80);
		pnlInfo.add(pnlSoDT_1_1);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setHorizontalAlignment(SwingConstants.LEFT);
		lblaCh.setFont(new Font("Arial", Font.PLAIN, 18));
		lblaCh.setBounds(10, 0, 200, 30);
		pnlSoDT_1_1.add(lblaCh);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 40, 250, 30);
		pnlSoDT_1_1.add(textField_1);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new TitledBorder(null, "chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBounds(319, 76, 834, 228);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		JPanel pnlThemKH = new JPanel();
		//thêm sự kiện mouse
		pnlThemKH.addMouseListener(new PanelbtnMouseAdapter(pnlThemKH) {		
		});
		pnlThemKH.setBackground(new Color(176, 196, 222));
		pnlThemKH.setBounds(45, 21, 228, 63);
		pnlChucNang.add(pnlThemKH);
		pnlThemKH.setLayout(null);
		
		JLabel lblThemKH = new JLabel("Thêm khách hàng");
		lblThemKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemKH.setFont(new Font("Arial", Font.BOLD, 15));
		lblThemKH.setBounds(69, 9, 147, 43);
		pnlThemKH.add(lblThemKH);
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAdd.setBounds(10, 0, 62, 63);
		pnlThemKH.add(lblIconAdd);
		Image img_iconAdd = new ImageIcon(this.getClass().getResource("/icon_add_s.png")).getImage();
		lblIconAdd.setIcon(new ImageIcon(img_iconAdd));
		
		//panel update customer
		JPanel pnlUpdate = new JPanel();
		pnlUpdate.addMouseListener(new PanelbtnMouseAdapter(pnlUpdate) {
		});
		pnlUpdate.setBackground(new Color(176, 196, 222));
		pnlUpdate.setLayout(null);
		pnlUpdate.setBounds(321, 21, 228, 63);
		pnlChucNang.add(pnlUpdate);
		
		JLabel lblThemKH_1 = new JLabel("Sửa thông tin");
		lblThemKH_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemKH_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblThemKH_1.setBounds(69, 9, 147, 43);
		pnlUpdate.add(lblThemKH_1);
		
		JLabel lblIconUpdate = new JLabel("");
		lblIconUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUpdate.setBounds(0, 0, 72, 63);
		pnlUpdate.add(lblIconUpdate);
		Image img_iconUpdate = new ImageIcon(this.getClass().getResource("/icon_update_s.png")).getImage();
		lblIconUpdate.setIcon(new ImageIcon(img_iconUpdate));
		
		//Panel làm mới khách hàng
		JPanel pnlLammoi = new JPanel();
		pnlLammoi.addMouseListener(new PanelbtnMouseAdapter(pnlLammoi) {
			
		});
		pnlLammoi.setBackground(new Color(176, 196, 222));
		pnlLammoi.setLayout(null);
		pnlLammoi.setBounds(580, 21, 228, 63);
		pnlChucNang.add(pnlLammoi);
		
		JLabel lblLammoi = new JLabel("Làm mới");
		lblLammoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblLammoi.setFont(new Font("Arial", Font.BOLD, 15));
		lblLammoi.setBounds(69, 9, 147, 43);
		pnlLammoi.add(lblLammoi);
		
		JLabel lblIconLammoi = new JLabel("");
		lblIconLammoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLammoi.setBounds(0, 0, 72, 63);
		pnlLammoi.add(lblIconLammoi);
		Image img_iconLammoi = new ImageIcon(this.getClass().getResource("/icon_lammoi_s.png")).getImage();
		lblIconLammoi.setIcon(new ImageIcon(img_iconLammoi));
		
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBounds(21, 124, 787, 78);
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
		
		//chức năng search
		JPanel pnlSearch = new JPanel();
		pnlSearch.addMouseListener(new PanelbtnMouseAdapter(pnlSearch) {
			
		});
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
		
		JPanel pnlDSKH = new JPanel();
		pnlDSKH.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDSKH.setBounds(319, 321, 834, 432);
		add(pnlDSKH);
		pnlDSKH.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 814, 402);
		pnlDSKH.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		setVisible(true);
	}

	// xử lý sự kiện nhấp chuột 
	private class PanelbtnMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelbtnMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		/*Phương thức này được gọi khi con trỏ chuột vào 
		 đối tượng JPanel mà đối tượng PanelbtnMouseAdapter được gắn vào
		 * */
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(230, 230, 250));
		}

		/*Phương thức này được gọi khi con trỏ chuột rời khỏi đối tượng JPanel
		 * */
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(176, 196, 222));
		}

		 /*Phương thức này được gọi khi người 
		  * dùng nhấn chuột lên đối tượng JPanel*/
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}

		
		/*
		 * Phương thức này được gọi khi người dùng thả chuột sau khi đã nhấn*/
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(176, 196, 222));
		}

	}
}
