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
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import dao.Dao_KhuyenMai;
import entity.KhuyenMai;
import entity.NhaCungCap;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class pnlKhuyenMai extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtMessage;
	private JTextField txtGiamGia;
	private JTextField txtTim;
	private JDateChooser jdNgayBatDau, jdNgayKetThuc;
	private JComboBox<String> cbDoiTuong;
	private JComboBox<String> cbTinhTrang;
	private Dao_KhuyenMai khuyenMai_dao = new Dao_KhuyenMai();
	private DefaultTableModel modelKM;
	private JTable tblKhuyenMai;
	private JButton btnThem, btnCapNhat, btnTaoMoi, btnTim;

	/**
	 * Create the panel.
	 */
	public pnlKhuyenMai() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.cyan);
		setBounds(0,0, 1163,763);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 10, 1143, 152);
		add(panel_1);
		
		JLabel lblMKhuynMi = new JLabel("Mã khuyến mãi:");
		lblMKhuynMi.setFont(new Font("Arial", Font.BOLD, 12));
		lblMKhuynMi.setBounds(24, 28, 111, 22);
		panel_1.add(lblMKhuynMi);
		
		JLabel lblTnKhuynMi = new JLabel("Tên khuyến mãi:");
		lblTnKhuynMi.setFont(new Font("Arial", Font.BOLD, 12));
		lblTnKhuynMi.setBounds(226, 28, 111, 22);
		panel_1.add(lblTnKhuynMi);
		
		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setEditable(false);
		txtMa.setColumns(10);
		txtMa.setBounds(123, 30, 82, 19);
		panel_1.add(txtMa);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(328, 30, 248, 19);
		panel_1.add(txtTen);
		
		JLabel lbliTngp = new JLabel("Đối tượng áp dụng:");
		lbliTngp.setFont(new Font("Arial", Font.BOLD, 12));
		lbliTngp.setBounds(795, 28, 111, 22);
		panel_1.add(lbliTngp);
		
		JLabel lblNgyBtu = new JLabel("Ngày bắt đầu:");
		lblNgyBtu.setFont(new Font("Arial", Font.BOLD, 12));
		lblNgyBtu.setBounds(24, 71, 91, 22);
		panel_1.add(lblNgyBtu);
		
		JLabel lblNgyKtThc = new JLabel("Ngày kết thúc:");
		lblNgyKtThc.setFont(new Font("Arial", Font.BOLD, 12));
		lblNgyKtThc.setBounds(408, 71, 96, 22);
		panel_1.add(lblNgyKtThc);
		
		JLabel lblTnhTrng = new JLabel("Tình trạng:");
		lblTnhTrng.setFont(new Font("Arial", Font.BOLD, 12));
		lblTnhTrng.setBounds(795, 71, 68, 22);
		panel_1.add(lblTnhTrng);
		
		cbTinhTrang = new JComboBox();
		cbTinhTrang.setModel(new DefaultComboBoxModel(new String[] {"Đang diễn ra", "Sắp diễn ra", "Đã kết thúc"}));
		cbTinhTrang.setBounds(926, 72, 192, 21);
		panel_1.add(cbTinhTrang);
		
		txtMessage = new JTextField();
		txtMessage.setToolTipText("");
		txtMessage.setForeground(Color.RED);
		txtMessage.setFont(new Font("Arial", Font.ITALIC, 10));
		txtMessage.setEditable(false);
		txtMessage.setColumns(10);
		txtMessage.setBorder(null);
		txtMessage.setBounds(24, 107, 1094, 19);
		panel_1.add(txtMessage);
		
		JLabel lblGiTrGim = new JLabel("Giá trị giảm giá:");
		lblGiTrGim.setFont(new Font("Arial", Font.BOLD, 12));
		lblGiTrGim.setBounds(590, 28, 96, 22);
		panel_1.add(lblGiTrGim);
		
		txtGiamGia = new JTextField();
		txtGiamGia.setColumns(10);
		txtGiamGia.setBounds(692, 30, 76, 19);
		panel_1.add(txtGiamGia);
		
		cbDoiTuong = new JComboBox();
		cbDoiTuong.setModel(new DefaultComboBoxModel(new String[] {"Sản phẩm", "Hóa đơn"}));
		cbDoiTuong.setBounds(923, 29, 192, 21);
		panel_1.add(cbDoiTuong);
		
		jdNgayBatDau = new JDateChooser();
		jdNgayBatDau.setDateFormatString("yyyy-MM-dd");
		jdNgayBatDau.setBounds(123, 71, 172, 19);
		panel_1.add(jdNgayBatDau);
		
		jdNgayKetThuc = new JDateChooser();
		jdNgayKetThuc.setDateFormatString("yyyy-MM-dd");
		jdNgayKetThuc.setBounds(501, 71, 172, 19);
		panel_1.add(jdNgayKetThuc);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Nhập tên khuyến mãi:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(37, 38, 236, 21);
		panel_2.add(lblNewLabel_1);
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(37, 69, 236, 19);
		panel_2.add(txtTim);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 291, 1143, 462);
		add(panel_3);
		
		JScrollPane scrollPane_N = new JScrollPane();
		scrollPane_N.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_N.setBounds(10, 20, 1123, 432);
		panel_3.add(scrollPane_N);
		
		String[] tb_N = new String[] { "Mã khuyến mãi", "Tên khuyến mãi", "Giá trị giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Đối tượng áp dụng", "Tình trạng" };
		modelKM = new DefaultTableModel(tb_N, 0);
		tblKhuyenMai = new JTable(modelKM);
				
		//table = new JTable();
		scrollPane_N.setViewportView(tblKhuyenMai);
		tblKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblKhuyenMai.getSelectedRow();
		        fillForm(r);

			}
		});	
		
		napDuLieuTuCSDL(khuyenMai_dao.getAllKhuyenMai());
		
		btnThem.addActionListener(this);
	    btnCapNhat.addActionListener(this);
	    btnTaoMoi.addActionListener(this);
	    btnTim.addActionListener(this);
		
	}
	
	public void napDuLieuTuCSDL(ArrayList<KhuyenMai> ds) {
    	DefaultTableModel dm = (DefaultTableModel) tblKhuyenMai.getModel();
		dm.getDataVector().removeAllElements();
		for (KhuyenMai km : ds) {
			modelKM.addRow(new Object[] {km.getMaKhuyenMai(),km.getTenKhuyenMai(),km.getGiaTriGiamGia(),km.getNgayBatDau(),km.getNgayKetThuc(),km.getDoiTuongApDung(),km.getTinhTrang()});
		}
    }
    
    private void xoaTrang() {
    	txtMa.setText("");
    	txtTen.setText("");
    	txtGiamGia.setText("");
        Calendar currentDate = Calendar.getInstance();
        jdNgayBatDau.setCalendar(currentDate);
        Calendar nextDay = Calendar.getInstance();
        nextDay.add(Calendar.DAY_OF_MONTH, 1);
        jdNgayKetThuc.setCalendar(nextDay);
    	cbDoiTuong.setSelectedIndex(0);
    	cbTinhTrang.setSelectedIndex(0);
    }
    
    private boolean validDate() {
    	String tenKM = txtTen.getText().trim();
    	String giamGiaStr = txtGiamGia.getText().trim();
    	Date ngayBatDau = jdNgayBatDau.getDate();
    	Date ngayKetThuc = jdNgayKetThuc.getDate();
    	
    	
    	if(tenKM.equals("")) {
    		txtMessage.setText("Tên khuyến mãi không được để trống!!!");
    		return false;
    	}
    	if (giamGiaStr.equals("")) {
            txtMessage.setText("Bạn hãy nhập giá trị giảm giá!!!");
            return false;
        } else {
            try {
                int giamGia = Integer.parseInt(giamGiaStr);
                if (giamGia <= 0) {
                    txtMessage.setText("Giá trị giảm giá phải là số nguyên lớn hơn 0!!!");
                    return false;
                }
            } catch (NumberFormatException e) {
                txtMessage.setText("Giá trị giảm giá không hợp lệ. Vui lòng nhập số nguyên lớn hơn 0!!!");
                return false;
            }
        }
    	if (ngayBatDau == null || ngayKetThuc == null) {
            txtMessage.setText("Vui lòng chọn ngày bắt đầu và ngày kết thúc!!");
            return false;
        }

        Date currentDate = new Date();
        if (ngayBatDau.before(currentDate)) {
            txtMessage.setText("Ngày bắt đầu phải từ ngày hiện tại trở đi!!!");
            return false;
        }

        if (ngayKetThuc.before(ngayBatDau)) {
            txtMessage.setText("Ngày kết thúc phải sau ngày bắt đầu!!!");
            return false;
        }
    	
    	    	
    	
    	return true;
    }
    
    private KhuyenMai revertKhuyenMaiFromFields() {
    	String maKM = phatSinhMaKM();
    	String tenKM = txtTen.getText().trim();
    	int giamGia = Integer.parseInt(txtGiamGia.getText().trim());
    	java.util.Date utilNgayBatDau = jdNgayBatDau.getDate();
        java.sql.Date ngayBatDau = new java.sql.Date(utilNgayBatDau.getTime());
        java.util.Date utilNgayKetThuc = jdNgayKetThuc.getDate();
        java.sql.Date ngayKetThuc = new java.sql.Date(utilNgayKetThuc.getTime());
    	String doiTuongApDung = cbDoiTuong.getSelectedItem().toString();
    	String tinhTrang = cbTinhTrang.getSelectedItem().toString();
    	KhuyenMai km = new KhuyenMai(maKM, tenKM, giamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
    	return km;
    }
    
    public String phatSinhMaKM() {
    	String prefix = "KM";
    	return prefix + String.format("%03d", modelKM.getRowCount()+ 1);
    }
    
    
    private void update() {
    	int r = tblKhuyenMai.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để cập nhật thông tin");
		} else {
			String maKM = txtMa.getText().trim();
			String tenKM = txtTen.getText().trim();
			int giamGia = Integer.parseInt(txtGiamGia.getText().trim());
	    	java.util.Date utilNgayBatDau = jdNgayBatDau.getDate();
	        java.sql.Date ngayBatDau = new java.sql.Date(utilNgayBatDau.getTime());
	        java.util.Date utilNgayKetThuc = jdNgayKetThuc.getDate();
	        java.sql.Date ngayKetThuc = new java.sql.Date(utilNgayKetThuc.getTime());
	    	String doiTuongApDung = cbDoiTuong.getSelectedItem().toString();
	    	String tinhTrang = cbTinhTrang.getSelectedItem().toString();
	    	KhuyenMai kmMoi = new KhuyenMai(maKM, tenKM, giamGia, ngayBatDau, ngayKetThuc, doiTuongApDung, tinhTrang);
			if (!khuyenMai_dao.capNhat(kmMoi)) {
				JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
				tblKhuyenMai.clearSelection();
			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				napDuLieuTuCSDL(khuyenMai_dao.getAllKhuyenMai());
			}
		}
    }
    
    public void fillForm(int r) {
    	txtMa.setText(tblKhuyenMai.getValueAt(r, 0).toString());
    	txtTen.setText(tblKhuyenMai.getValueAt(r, 1).toString());
    	txtGiamGia.setText(tblKhuyenMai.getValueAt(r, 2).toString());
    	jdNgayBatDau.setDate((java.util.Date) tblKhuyenMai.getValueAt(r, 3));
    	jdNgayKetThuc.setDate((java.util.Date) tblKhuyenMai.getValueAt(r, 4));
    	cbDoiTuong.setSelectedItem(tblKhuyenMai.getValueAt(r, 5).toString());
    	cbTinhTrang.setSelectedItem(tblKhuyenMai.getValueAt(r, 6).toString());
    }
    
    public void timKMTheoTen() {
    	String ten = txtTim.getText().trim();
    	if (ten.trim() == "") {
			napDuLieuTuCSDL(khuyenMai_dao.getAllKhuyenMai());
			xoaTrang();
		} else {
			ArrayList<KhuyenMai> kmList = khuyenMai_dao.getKhuyenMaiTheoTen(ten);
			if (kmList.size() > 0) {
				napDuLieuTuCSDL(kmList);
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
				KhuyenMai km = revertKhuyenMaiFromFields();
				if (!khuyenMai_dao.them(km)) {
					JOptionPane.showMessageDialog(this, "Thêm thất bại. Đã xảy ra lỗi!!!");
				} else {
					napDuLieuTuCSDL(khuyenMai_dao.getAllKhuyenMai());
					tblKhuyenMai.clearSelection();
					txtMessage.setText("");
				}
			}
		}else if(o.equals(btnCapNhat)) {
			update();
	        napDuLieuTuCSDL(khuyenMai_dao.getAllKhuyenMai());
	        tblKhuyenMai.clearSelection();
			
		}else if(o.equals(btnTaoMoi)) {
			xoaTrang();
	        napDuLieuTuCSDL(khuyenMai_dao.getAllKhuyenMai());
	        tblKhuyenMai.clearSelection();
			
		}else if(o.equals(btnTim)) {
			timKMTheoTen();
			
		}
	}
}
