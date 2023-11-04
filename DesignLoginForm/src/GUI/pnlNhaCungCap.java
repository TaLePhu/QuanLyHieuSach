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
import java.util.Date;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.Dao_NhaCungCap;
import entity.NhaCungCap;
import entity.NhanVien;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class pnlNhaCungCap extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;
	private JTextField txtMessage;
	private JTextField txtTimKiem;
	private JComboBox<String> cbTinhTrang;
	private Dao_NhaCungCap nhaCungCap_dao = new Dao_NhaCungCap();
	private DefaultTableModel modelNCC;
	private JTable tblNhaCungCap;
	private JButton btnThem, btnCapNhat, btnTaoMoi, btnTim;

	/**
	 * Create the panel.
	 */
	public pnlNhaCungCap() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.GREEN);
		setBounds(0,0, 1163,763);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 10, 1143, 152);
		add(panel_1);
		
		JLabel lblMNhCung = new JLabel("Mã nhà cung cấp:");
		lblMNhCung.setFont(new Font("Arial", Font.BOLD, 12));
		lblMNhCung.setBounds(24, 28, 111, 22);
		panel_1.add(lblMNhCung);
		
		JLabel lblTnNhCung = new JLabel("Tên nhà cung cấp:");
		lblTnNhCung.setFont(new Font("Arial", Font.BOLD, 12));
		lblTnNhCung.setBounds(302, 28, 111, 22);
		panel_1.add(lblTnNhCung);
		
		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setEditable(false);
		txtMa.setColumns(10);
		txtMa.setBounds(145, 30, 141, 19);
		panel_1.add(txtMa);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(423, 30, 248, 19);
		panel_1.add(txtTen);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Arial", Font.BOLD, 12));
		lblaCh.setBounds(692, 28, 49, 22);
		panel_1.add(lblaCh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(766, 30, 352, 19);
		panel_1.add(txtDiaChi);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 12));
		lblSinThoi.setBounds(24, 71, 91, 22);
		panel_1.add(lblSinThoi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(145, 73, 141, 19);
		panel_1.add(txtSoDienThoai);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(302, 71, 45, 22);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(423, 73, 248, 19);
		panel_1.add(txtEmail);
		
		JLabel lblTnhTrng = new JLabel("Tình trạng:");
		lblTnhTrng.setFont(new Font("Arial", Font.BOLD, 12));
		lblTnhTrng.setBounds(692, 71, 68, 22);
		panel_1.add(lblTnhTrng);
		
		cbTinhTrang = new JComboBox();
		cbTinhTrang.setModel(new DefaultComboBoxModel(new String[] {"Đang hoạt động", "Ngừng hoạt động"}));
		cbTinhTrang.setBounds(766, 72, 352, 21);
		panel_1.add(cbTinhTrang);
		
		txtMessage = new JTextField();
		txtMessage.setToolTipText("");
		txtMessage.setForeground(Color.RED);
		txtMessage.setFont(new Font("Arial", Font.ITALIC, 10));
		txtMessage.setColumns(10);
		txtMessage.setBorder(null);
		txtMessage.setEditable(false);
		txtMessage.setBounds(24, 107, 1094, 19);
		panel_1.add(txtMessage);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 168, 639, 113);
		add(panel);
		
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
		panel_2.setBounds(659, 168, 494, 113);
		add(panel_2);
		
		btnTim = new JButton("");
		btnTim.setBounds(290, 38, 51, 50);
		panel_2.add(btnTim);
		Image img_iconFind = new ImageIcon(this.getClass().getResource("/find.png")).getImage();
		btnTim.setIcon(new ImageIcon(img_iconFind));
		
		JLabel lblNewLabel_1 = new JLabel("Nhập tên nhà cung cấp:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(37, 38, 236, 21);
		panel_2.add(lblNewLabel_1);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(37, 69, 236, 19);
		panel_2.add(txtTimKiem);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 287, 1143, 439);
		add(panel_3);
		
		JScrollPane scrollPane_N = new JScrollPane();
		scrollPane_N.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setBounds(10, 20, 1123, 400);
		panel_3.add(scrollPane_N);
		
		String[] tb_N = new String[] { "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email", "Tình trạng" };
		modelNCC = new DefaultTableModel(tb_N, 0);
		tblNhaCungCap = new JTable(modelNCC);
				
		//table = new JTable();
		scrollPane_N.setViewportView(tblNhaCungCap);
		tblNhaCungCap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblNhaCungCap.getSelectedRow();
		        fillForm(r);

			}
		});	
		
		napDuLieuTuCSDL(nhaCungCap_dao.getAllNhaCungCap());
		
		btnThem.addActionListener(this);
	    btnCapNhat.addActionListener(this);
	    btnTaoMoi.addActionListener(this);
	    btnTim.addActionListener(this);
	}
	
	public void napDuLieuTuCSDL(ArrayList<NhaCungCap> ds) {
    	DefaultTableModel dm = (DefaultTableModel) tblNhaCungCap.getModel();
    	dm.getDataVector().removeAllElements();
    	for (NhaCungCap ncc : ds) {
			modelNCC.addRow(new Object[] {ncc.getMaNhaCungCap(),ncc.getTenNhaCungCap(),ncc.getDiaChi(),ncc.getSoDienThoai(),ncc.getEmail(),ncc.getTinhTrang()});
		}
    }
    
    private void xoaTrang() {
    	txtMa.setText("");
    	txtTen.setText("");
    	txtDiaChi.setText("");
    	txtSoDienThoai.setText("");
    	txtEmail.setText("");
    	cbTinhTrang.setSelectedIndex(0);
    	txtTen.requestFocus();
    }
    
    public String phatSinhMaNCC() {
    	String prefix = "NCC";
    	return prefix + String.format("%03d", modelNCC.getRowCount()+ 1);
    }
    
    private NhaCungCap revertNCCFromFields() {
    	String maNCC = phatSinhMaNCC();
    	String tenNCC = txtTen.getText().trim();
    	String diaChi = txtDiaChi.getText().trim();
    	String sdt = txtSoDienThoai.getText().trim();
    	String email = txtEmail.getText().trim();
    	String tinhTrang = cbTinhTrang.getSelectedItem().toString();
    	NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt, email, tinhTrang);
    	return ncc;
    }
    
    private boolean validDate() {
    	String tenNCC = txtTen.getText().trim();
    	String diaChi = txtDiaChi.getText().trim();
    	String soDienThoai = txtSoDienThoai.getText().trim();
    	String email = txtEmail.getText().trim();
    	if(tenNCC.equals("")) {
    		txtMessage.setText("Bạn hãy nhập tên nhà cung cấp!!!");
    		txtTen.requestFocus();
    		return false;
    	}
    	if(diaChi.equals("")) {
    		txtMessage.setText("Bạn hãy nhập địa chỉ của nhà cung cấp!!!");
    		txtDiaChi.requestFocus();
    		return false;
    	}
    	if (soDienThoai.equals("")) {
    		txtMessage.setText("Bạn hãy nhập số điện thoại của nhà cung cấp");
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
    
    private void update() {
    	int r = tblNhaCungCap.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			String maNCC = txtMa.getText().trim();
			String tenNCC = txtTen.getText().trim();
	    	String diaChi = txtDiaChi.getText().trim();
	    	String sdt = txtSoDienThoai.getText().trim();
	    	String email = txtEmail.getText().trim();
	    	String tinhTrang = cbTinhTrang.getSelectedItem().toString();
	    	NhaCungCap nccMoi = new NhaCungCap(maNCC, tenNCC, diaChi, sdt, email, tinhTrang);
			if (!nhaCungCap_dao.capNhat(nccMoi)) {
				JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
				tblNhaCungCap.clearSelection();
			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				napDuLieuTuCSDL(nhaCungCap_dao.getAllNhaCungCap());
			}
		}
    }
    
    public void fillForm(int r) {
    	txtMa.setText(tblNhaCungCap.getValueAt(r, 0).toString());
    	txtTen.setText(tblNhaCungCap.getValueAt(r, 1).toString());
    	txtDiaChi.setText(tblNhaCungCap.getValueAt(r, 2).toString());
    	txtSoDienThoai.setText(tblNhaCungCap.getValueAt(r, 3).toString());
    	txtEmail.setText(tblNhaCungCap.getValueAt(r, 4).toString());
    	cbTinhTrang.setSelectedItem(tblNhaCungCap.getValueAt(r, 5).toString());
    }
    
    public void timNCCTheoTen() {
    	String ten = txtTimKiem.getText().trim();
    	if (ten.trim() == "") {
			napDuLieuTuCSDL(nhaCungCap_dao.getAllNhaCungCap());
			xoaTrang();
		} else {
			ArrayList<NhaCungCap> nccList = nhaCungCap_dao.getNCCTheoTen(ten);
			if (nccList.size() > 0) {
				napDuLieuTuCSDL(nccList);
				xoaTrang();

			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if (validDate()) {
				NhaCungCap ncc = revertNCCFromFields();
				if (!nhaCungCap_dao.them(ncc)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					napDuLieuTuCSDL(nhaCungCap_dao.getAllNhaCungCap());
					tblNhaCungCap.clearSelection();
					txtMessage.setText("");
				}
			}
		}else if(o.equals(btnCapNhat)) {
			update();
	        napDuLieuTuCSDL(nhaCungCap_dao.getAllNhaCungCap());
	        tblNhaCungCap.clearSelection();
			
		}else if(o.equals(btnTaoMoi)) {
			xoaTrang();
	        napDuLieuTuCSDL(nhaCungCap_dao.getAllNhaCungCap());
	        tblNhaCungCap.clearSelection();
			
		}else if(o.equals(btnTim)) {
			timNCCTheoTen();
			
		}
		
	}
	
	
}
