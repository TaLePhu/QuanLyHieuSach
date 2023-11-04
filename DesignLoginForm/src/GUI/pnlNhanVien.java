package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;

public class pnlNhanVien extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNhanVien;
	private JTextField txtHoTenNhanVien;
	private JTextField txtDiaChi;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JDateChooser jdNgaySinh;
	private JComboBox<String> cbChucVu;
	private JComboBox<String> cbTinhTrang;
	private JComboBox<String> cbMaNhanVien;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;
	private JTextField txtMessage;
	private JTextField txtTimKiem;
	private JTable tblNhanVien;
	private JTextField txtMaTK;
	private JTextField txtMatKhau;
	private JTextField txtTenTK;
	private JTextField txtMessageTK;
	private JTextField txtTimTK;
	private JTable tblTaiKhoan;
	private static final String SECRET_KEY = "ThisIsASecretKey";
	private Dao_NhanVien nhanVien_dao = new Dao_NhanVien();
    private Dao_TaiKhoan taiKhoan_dao = new Dao_TaiKhoan();
    private DefaultTableModel modelNV;
    private DefaultTableModel modelTK;
    private JButton btnThem, btnCapNhat, btnTaoMoi, btnThemTK, btnCapNhatTK,btnTaoMoiTK,btnTim, btnTimTK;

	/**
	 * Create the panel.
	 */
	public pnlNhanVien() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.PINK);
		setBounds(0,0, 1163,763);
		setLayout(null);
		
		JTabbedPane tpNhanVien = new JTabbedPane(JTabbedPane.TOP);
		tpNhanVien.setBounds(0, 0, 1153, 763);
		add(tpNhanVien);
		
		JPanel panelNhanVien = new JPanel();
		tpNhanVien.addTab("Nhân viên", null, panelNhanVien, null);
		panelNhanVien.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 1128, 152);
		panelNhanVien.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(24, 28, 91, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lblHTnNhn = new JLabel("Họ tên nhân viên:");
		lblHTnNhn.setFont(new Font("Arial", Font.BOLD, 12));
		lblHTnNhn.setBounds(241, 28, 111, 22);
		panel_1.add(lblHTnNhn);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBounds(125, 30, 91, 19);
		panel_1.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtHoTenNhanVien = new JTextField();
		txtHoTenNhanVien.setBounds(356, 30, 187, 19);
		panel_1.add(txtHoTenNhanVien);
		txtHoTenNhanVien.setColumns(10);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setFont(new Font("Arial", Font.BOLD, 12));
		lblNgySinh.setBounds(567, 28, 68, 22);
		panel_1.add(lblNgySinh);
		
		jdNgaySinh = new JDateChooser();
		jdNgaySinh.setDateFormatString("yyyy-MM-dd");
		jdNgaySinh.setBounds(645, 31, 128, 19);
		panel_1.add(jdNgaySinh);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Arial", Font.BOLD, 12));
		lblaCh.setBounds(807, 28, 49, 22);
		panel_1.add(lblaCh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(866, 30, 252, 19);
		panel_1.add(txtDiaChi);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 12));
		lblSinThoi.setBounds(24, 71, 91, 22);
		panel_1.add(lblSinThoi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(125, 73, 91, 19);
		panel_1.add(txtSoDienThoai);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(241, 71, 45, 22);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(286, 73, 139, 19);
		panel_1.add(txtEmail);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Arial", Font.BOLD, 12));
		lblGiiTnh.setBounds(438, 71, 60, 22);
		panel_1.add(lblGiiTnh);
		
		
		rdNam = new JRadioButton("Nam");
		rdNam.setBounds(504, 72, 54, 21);
		panel_1.add(rdNam);
		
		rdNu = new JRadioButton("Nữ");
		rdNu.setBounds(558, 72, 47, 21);
		panel_1.add(rdNu);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdNam);
		group.add(rdNu);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setFont(new Font("Arial", Font.BOLD, 12));
		lblChcV.setBounds(611, 71, 68, 22);
		panel_1.add(lblChcV);
		
		cbChucVu = new JComboBox();
		cbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên bán hàng", "Nhân viên quản lý"}));
		cbChucVu.setBounds(689, 72, 167, 21);
		panel_1.add(cbChucVu);
		
		JLabel lblTnhTrng = new JLabel("Tình trạng:");
		lblTnhTrng.setFont(new Font("Arial", Font.BOLD, 12));
		lblTnhTrng.setBounds(866, 71, 68, 22);
		panel_1.add(lblTnhTrng);
		
		cbTinhTrang = new JComboBox();
		cbTinhTrang.setModel(new DefaultComboBoxModel(new String[] {"Đang làm việc", "Tạm ngưng"}));
		cbTinhTrang.setBounds(944, 72, 174, 21);
		panel_1.add(cbTinhTrang);
		
		txtMessage = new JTextField();
		txtMessage.setToolTipText("");
		txtMessage.setFont(new Font("Arial", Font.ITALIC, 10));
		txtMessage.setBackground(new Color(240, 240, 240));
		txtMessage.setText("");
		txtMessage.setForeground(new Color(255, 0, 0));
		txtMessage.setColumns(10);
		txtMessage.setBorder(null);
		txtMessage.setEditable(false);
		txtMessage.setBounds(24, 107, 1094, 19);
		panel_1.add(txtMessage);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 164, 639, 113);
		panelNhanVien.add(panel);
		panel.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(41, 34, 136, 57);
		panel.add(btnThem);
		Image img_iconThem = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnThem.setIcon(new ImageIcon(img_iconThem));
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(204, 34, 136, 57);
		panel.add(btnCapNhat);
		Image img_iconUpdate = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
		btnCapNhat.setIcon(new ImageIcon(img_iconUpdate));
		
		btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.setBounds(367, 34, 144, 57);
		panel.add(btnTaoMoi);
		Image img_iconTaoMoi = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnTaoMoi.setIcon(new ImageIcon(img_iconTaoMoi));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(658, 164, 480, 113);
		panelNhanVien.add(panel_2);
		
		btnTim = new JButton("");
		btnTim.setBounds(290, 38, 51, 50);
		panel_2.add(btnTim);
		Image img_iconFind = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		btnTim.setIcon(new ImageIcon(img_iconFind));
		
		JLabel lblNewLabel_1 = new JLabel("Nhập số điện thoại nhân viên để tìm kiếm:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(37, 38, 236, 21);
		panel_2.add(lblNewLabel_1);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(37, 69, 236, 19);
		panel_2.add(txtTimKiem);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 287, 1128, 439);
		panelNhanVien.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_N = new JScrollPane();
		scrollPane_N.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setBounds(10, 20, 1100, 400);
		panel_3.add(scrollPane_N);
		
		
		String[] tb_N = new String[] { "Mã nhân viên", "Họ tên nhân viên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Email",
		"Giới tính", "Chức vụ", "Tình trạng" };
		modelNV = new DefaultTableModel(tb_N, 0);
		tblNhanVien = new JTable(modelNV);
		
		//table = new JTable();
		scrollPane_N.setViewportView(tblNhanVien);
		tblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblNhanVien.getSelectedRow();
		        fillForm(r);

			}
		});
		
		JPanel panelTaiKhoan = new JPanel();
		tpNhanVien.addTab("Tài khoản", null, panelTaiKhoan, null);
		panelTaiKhoan.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 10, 1128, 142);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTaiKhoan.add(panel_1_1);
		
		JLabel lblMTiKhon = new JLabel("Mã tài khoản:");
		lblMTiKhon.setFont(new Font("Arial", Font.BOLD, 12));
		lblMTiKhon.setBounds(24, 28, 91, 22);
		panel_1_1.add(lblMTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Arial", Font.BOLD, 12));
		lblMtKhu.setBounds(580, 28, 60, 22);
		panel_1_1.add(lblMtKhu);
		
		txtMaTK = new JTextField();
		txtMaTK.setEnabled(false);
		txtMaTK.setEditable(false);
		txtMaTK.setColumns(10);
		txtMaTK.setBounds(125, 30, 426, 19);
		panel_1_1.add(txtMaTK);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(683, 30, 435, 19);
		panel_1_1.add(txtMatKhau);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản:");
		lblTnTiKhon.setFont(new Font("Arial", Font.BOLD, 12));
		lblTnTiKhon.setBounds(24, 71, 91, 22);
		panel_1_1.add(lblTnTiKhon);
		
		txtTenTK = new JTextField();
		txtTenTK.setColumns(10);
		txtTenTK.setBounds(125, 73, 426, 19);
		panel_1_1.add(txtTenTK);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Arial", Font.BOLD, 12));
		lblMNhnVin.setBounds(580, 71, 93, 22);
		panel_1_1.add(lblMNhnVin);
		
		cbMaNhanVien = new JComboBox<String>();
		cbMaNhanVien.setBounds(683, 72, 435, 21);
		panel_1_1.add(cbMaNhanVien);
		
		txtMessageTK = new JTextField();
		txtMessageTK.setToolTipText("");
		txtMessageTK.setText("");
		txtMessageTK.setForeground(Color.RED);
		txtMessageTK.setFont(new Font("Arial", Font.ITALIC, 10));
		txtMessageTK.setColumns(10);
		txtMessageTK.setBackground(UIManager.getColor("Button.background"));
		txtMessageTK.setBounds(24, 107, 1094, 19);
		txtMessageTK.setBorder(null);
		txtMessageTK.setEditable(false);
		panel_1_1.add(txtMessageTK);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 162, 639, 113);
		panelTaiKhoan.add(panel_4);
		
		btnThemTK = new JButton("Thêm");
		btnThemTK.setBounds(41, 34, 136, 57);
		panel_4.add(btnThemTK);
		btnThemTK.setIcon(new ImageIcon(img_iconThem));
		
		btnCapNhatTK = new JButton("Cập nhật");
		btnCapNhatTK.setBounds(204, 34, 136, 57);
		panel_4.add(btnCapNhatTK);
		btnCapNhatTK.setIcon(new ImageIcon(img_iconUpdate));
		
		btnTaoMoiTK = new JButton("Tạo mới");
		btnTaoMoiTK.setBounds(367, 34, 144, 57);
		panel_4.add(btnTaoMoiTK);
		btnTaoMoiTK.setIcon(new ImageIcon(img_iconTaoMoi));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1.setBounds(658, 162, 480, 113);
		panelTaiKhoan.add(panel_2_1);
		
		btnTimTK = new JButton("");
		btnTimTK.setBounds(290, 38, 51, 50);
		panel_2_1.add(btnTimTK);
		btnTimTK.setIcon(new ImageIcon(img_iconFind));
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập tên nhân viên để tìm kiếm:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(37, 38, 236, 21);
		panel_2_1.add(lblNewLabel_1_1);
		
		txtTimTK = new JTextField();
		txtTimTK.setColumns(10);
		txtTimTK.setBounds(37, 69, 236, 19);
		panel_2_1.add(txtTimTK);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(10, 285, 1128, 439);
		panelTaiKhoan.add(panel_3_1);
		
		JScrollPane scrollPane_N_1 = new JScrollPane();
		scrollPane_N_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_N_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_N_1.setBounds(10, 20, 1100, 400);
		panel_3_1.add(scrollPane_N_1);
		
		String[] tb_TK = new String[] { "Mã tài khoản", "Mật khẩu", "Tên tài khoản", "Mã nhân viên"};
				modelTK = new DefaultTableModel(tb_TK, 0);
				tblTaiKhoan = new JTable(modelTK);
		scrollPane_N_1.setViewportView(tblTaiKhoan);
		tblTaiKhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblTaiKhoan.getSelectedRow();
		        try {
					fillFormTK(r);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		
		napDuLieuNhanVienTuCSDL(nhanVien_dao.getAllNhanVien());
	    napDuLieuTaiKhoanTuCSDL(taiKhoan_dao.getAllTaiKhoan());
	    napComboBoxMaNhanVien(nhanVien_dao.getAllNhanVien());
	    
	    btnThem.addActionListener(this);
	    btnCapNhat.addActionListener(this);
	    btnTaoMoi.addActionListener(this);
	    btnTim.addActionListener(this);
	    btnThemTK.addActionListener(this);
	    btnCapNhatTK.addActionListener(this);
	    btnTaoMoiTK.addActionListener(this);
	    btnTimTK.addActionListener(this);
	}
	
	public void napDuLieuNhanVienTuCSDL(ArrayList<NhanVien> ds) {
    	DefaultTableModel dm = (DefaultTableModel) tblNhanVien.getModel();
		dm.getDataVector().removeAllElements();
		for (NhanVien nv : ds) {
			modelNV.addRow(new Object[] { nv.getMaNhanVien(), nv.getHoTenNhanVien(),nv.getNgaySinh(), nv.getDiaChi(), nv.getSoDienThoai(),
					nv.getEmail(), nv.isGioiTinh() ? "Nam" : "Nữ" , nv.getChucVu(),nv.getTinhTrang()});
		}
    }
    
    
    
    
    private void xoaTrangNhanVien() {
		txtMaNhanVien.setText("");
		txtHoTenNhanVien.setText("");
		jdNgaySinh.setCalendar(null);
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		txtEmail.setText("");
		rdNam.setSelected(true);
		cbChucVu.setSelectedIndex(0);
		cbTinhTrang.setSelectedIndex(0);
	}
    
    private boolean validDate() {
    	String hoTen = txtHoTenNhanVien.getText().trim();
    	Date ngaySinh =  jdNgaySinh.getDate();
    	String diaChi = txtDiaChi.getText().trim();
    	String soDienThoai = txtSoDienThoai.getText().trim();
    	String email = txtEmail.getText().trim();
    	
    	if(hoTen.equals("")) {
    		txtMessage.setText("Họ tên nhân viên không được để trống!!!");
    		txtHoTenNhanVien.requestFocus();
    		return false;
    	}
    	if (ngaySinh == null) {
            txtMessage.setText("Bạn hãy chọn ngày sinh cho nhân viên!!!");
            return false;
        } else {
            Date currentDate = new Date();
            if (ngaySinh.after(currentDate)) {
                txtMessage.setText("Ngày sinh phải nhỏ hơn ngày hiện tại!!!");
                return false;
            }
        }
    	if(diaChi.equals("")) {
    		txtMessage.setText("Bạn hãy nhập địa chỉ cho nhân viên!!!");
    		txtDiaChi.requestFocus();
    		return false;
    	}
    	if (soDienThoai.equals("")) {
    		txtMessage.setText("Bạn hãy nhập số điện thoại cho nhân viên");
    		txtSoDienThoai.requestFocus();
    		return false;
    		
		}else if (!soDienThoai.matches("^0\\d{9}")) {
				txtMessage.setText("Số điện thoại phải bắt đầu bằng 0 và có tổng cộng 10 số");
				txtSoDienThoai.requestFocus();
				return false;
			
			
		}
		if (!email.matches(
			"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
			txtMessage.setText("Email sai cú pháp!!!");
			txtEmail.requestFocus();
			return false;
		}
		return true;
    }
    
    private NhanVien revertNhanVienFromFields() {
    	String maNV ="";
    	String hoTen = txtHoTenNhanVien.getText().trim();
    	java.util.Date utilNgaySinh = jdNgaySinh.getDate();
        java.sql.Date ngaySinh = new java.sql.Date(utilNgaySinh.getTime());
    	String diaChi = txtDiaChi.getText().trim();
    	String sdt = txtSoDienThoai.getText().trim();
    	String email = txtEmail.getText().trim();
    	boolean gioiTinh = rdNam.isSelected();
    	String chucVu = (String) cbChucVu.getSelectedItem();
    	String tinhTrang = (String) cbTinhTrang.getSelectedItem();
    	maNV = phatSinhMaNV(chucVu);
    	NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, diaChi, sdt, email, gioiTinh, tinhTrang, chucVu);
		return nv;
    }
    
    private void update() {
    	int r = tblNhanVien.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			if (validDate()) {
				String maNV =txtMaNhanVien.getText().trim();
		    	String hoTen = txtHoTenNhanVien.getText().trim();
		    	java.util.Date utilNgaySinh = jdNgaySinh.getDate();
		        java.sql.Date ngaySinh = new java.sql.Date(utilNgaySinh.getTime());
		    	String diaChi = txtDiaChi.getText().trim();
		    	String sdt = txtSoDienThoai.getText().trim();
		    	String email = txtEmail.getText().trim();
		    	boolean gioiTinh = rdNam.isSelected();
		    	String chucVu = (String) cbChucVu.getSelectedItem();
		    	String tinhTrang = (String) cbTinhTrang.getSelectedItem();
		    	NhanVien nvMoi = new NhanVien(maNV, hoTen, ngaySinh, diaChi, sdt, email, gioiTinh, chucVu, tinhTrang);
				if (!nhanVien_dao.capNhat(nvMoi)) {
					System.out.println(nvMoi);
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					tblNhanVien.clearSelection();
				} else {
					
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				}
			}
		}
    }
    
    public void fillForm(int r) {
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setText(tblNhanVien.getValueAt(r, 0).toString());
		txtHoTenNhanVien.setText(tblNhanVien.getValueAt(r, 1).toString());
		jdNgaySinh.setDate((java.util.Date) tblNhanVien.getValueAt(r, 2));
		txtDiaChi.setText(tblNhanVien.getValueAt(r, 3).toString());
		txtSoDienThoai.setText(tblNhanVien.getValueAt(r, 4).toString());
		txtEmail.setText(tblNhanVien.getValueAt(r, 5).toString());
		String gt = tblNhanVien.getValueAt(r, 6).toString();
		if (gt.equals("Nam")) {
			rdNam.setSelected(true);
		} else {
			rdNu.setSelected(true);
		}
		cbChucVu.setSelectedItem(tblNhanVien.getValueAt(r, 7).toString());
		cbTinhTrang.setSelectedItem(tblNhanVien.getValueAt(r, 8).toString());
	}
    
    public void timTheoSDT() {
		String sdt = txtTimKiem.getText().trim();

		if (sdt.isEmpty() || sdt.trim() == "") {
			napDuLieuNhanVienTuCSDL(nhanVien_dao.getAllNhanVien());
			xoaTrangNhanVien();
		} else {
			ArrayList<NhanVien> nvList = nhanVien_dao.getTheoSDT(sdt);
			if (nvList.size() > 0) {
				napDuLieuNhanVienTuCSDL(nvList);
				xoaTrangNhanVien();

			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}

	}
    
    public String phatSinhMaNV(String chucVu) {
    	String prefix = "";
    	if(chucVu.equals("Nhân viên bán hàng")) {
    		prefix = "NV0";
    	}else if (chucVu.equals("Nhân viên quản lý")) {
    		prefix = "NV1";
    	}
    	return prefix + String.format("%02d", modelNV.getRowCount()+ 1);
    }
    
    
    
//   Tài khoản 
    
    public void napDuLieuTaiKhoanTuCSDL(ArrayList<TaiKhoan> ds) {
    	DefaultTableModel dm = (DefaultTableModel) tblTaiKhoan.getModel();
		dm.getDataVector().removeAllElements();
		for (TaiKhoan tk : ds) {
			modelTK.addRow(new Object[] {tk.getMaTaiKhoan(),tk.getMatKhau(),tk.getTenTaiKhoan(),tk.getNhanVien().getMaNhanVien()});
		}
    }
    
    public void fillFormTK(int r) throws Exception {
    	txtMaTK.setText(tblTaiKhoan.getValueAt(r, 0).toString());
    	txtMatKhau.setText(decrypt(tblTaiKhoan.getValueAt(r, 1).toString()));
    	txtTenTK.setText(tblTaiKhoan.getValueAt(r, 2).toString());
    	cbMaNhanVien.setSelectedItem(tblTaiKhoan.getValueAt(r, 3).toString());
	
	}
    public void napComboBoxMaNhanVien(ArrayList<NhanVien> ds) {
		int n = ds.size();
		String items[] = new String[n];
		int i = 0;
		for (NhanVien nv : ds) {
			items[i] = nv.getMaNhanVien() + "";
			i++;
		}
		cbMaNhanVien.setModel(new DefaultComboBoxModel<String>(items));
	}
    
    private boolean validDateTK() {
    	String matKhau = txtMatKhau.getText().trim();
    	String tenTaiKhoan = txtTenTK.getText().trim();
    	
    	if(matKhau.equals("")) {
    		txtMessageTK.setText("Bạn hãy nhập mật khẩu!!!");
    		txtMatKhau.requestFocus();
    		return false;
    	}
    	if(tenTaiKhoan.equals("")) {
    		txtMessageTK.setText("Bạn hãy nhập tên tài khoản!!!");
    		txtTenTK.requestFocus();
    		return false;
    	}
		return true;
    }
    
    private TaiKhoan revertTaiKhoanFromFields() throws Exception {
    	String maTK ="";
    	String tenTK = txtTenTK.getText().trim();
    	String matKhau = txtMatKhau.getText().trim();
    	String mKMaHoa = encrypt(matKhau);
    	NhanVien nv = new NhanVien((String) cbMaNhanVien.getSelectedItem());
    	maTK= phatSinhMaTK();
    	TaiKhoan tk = new TaiKhoan(maTK, mKMaHoa, tenTK, nv);
    	return tk;
    }
    
    public String phatSinhMaTK() {
    	String prefix = "TK";
    	return prefix + String.format("%03d", modelTK.getRowCount()+ 1);
    }
    
    private void xoaTrangTaiKhoan() {
		txtMaTK.setText("");
		txtTenTK.setText("");
		txtMatKhau.setText("");
		cbMaNhanVien.setSelectedIndex(0);
		txtTenTK.requestFocus();
	}
    
    private void updateTaiKhoan() throws Exception {
    	int r = tblTaiKhoan.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			if(validDateTK()) {
				String maTK = txtMaTK.getText().trim();
	    		String tenTK = txtTenTK.getText().trim();
	    		String matKhau = txtMatKhau.getText().trim();
	    		String mKMaHoa = encrypt(matKhau);
	    		NhanVien nv = new NhanVien((String) cbMaNhanVien.getSelectedItem());
				TaiKhoan tkMoi = new TaiKhoan(maTK, mKMaHoa, tenTK, nv);
				if (!taiKhoan_dao.capNhat(tkMoi)) {
					System.out.println(tkMoi);
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					tblTaiKhoan.clearSelection();
				} else {
					
					JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công");
					napDuLieuTaiKhoanTuCSDL(taiKhoan_dao.getAllTaiKhoan());
					tblTaiKhoan.clearSelection();
				}
			}
		}
    }
    
    public static String encrypt(String plainText) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    public static String decrypt(String encryptedText) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o.equals(btnThem)) {
			if (validDate()) {
				NhanVien nv = revertNhanVienFromFields();
				if (!nhanVien_dao.them(nv)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					napDuLieuNhanVienTuCSDL(nhanVien_dao.getAllNhanVien());
					tblNhanVien.clearSelection();
					txtMessage.setText("");
				}
			}
		}else if(o.equals(btnCapNhat)) {
			update();
	        napDuLieuNhanVienTuCSDL(nhanVien_dao.getAllNhanVien());
			
		}else if(o.equals(btnTaoMoi)) {
			xoaTrangNhanVien();
	        napDuLieuNhanVienTuCSDL(nhanVien_dao.getAllNhanVien());
	        tblNhanVien.clearSelection();
			
		}else if(o.equals(btnTim)) {
			timTheoSDT();
			
		}else if(o.equals(btnThemTK)) {
			if(validDateTK()) {
				TaiKhoan tk = null;
				try {
					tk = revertTaiKhoanFromFields();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!taiKhoan_dao.them(tk)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					napDuLieuTaiKhoanTuCSDL(taiKhoan_dao.getAllTaiKhoan());
					tblTaiKhoan.clearSelection();

				}
			}
			
		}else if(o.equals(btnCapNhatTK)) {
			try {
				updateTaiKhoan();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(o.equals(btnTaoMoiTK)) {
			xoaTrangTaiKhoan();
	        napDuLieuTaiKhoanTuCSDL(taiKhoan_dao.getAllTaiKhoan());
	        tblTaiKhoan.clearSelection();
			
		}else if(o.equals(btnTimTK)) {
			String hoTen = txtTimTK.getText().trim();
			ArrayList<TaiKhoan> dsTK = taiKhoan_dao.getTKTheoTenNV(hoTen);
	    	if (dsTK.size() > 0) {
				napDuLieuTaiKhoanTuCSDL(dsTK);
				xoaTrangTaiKhoan();

			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
			xoaTrangTaiKhoan();
		}
	}

}
