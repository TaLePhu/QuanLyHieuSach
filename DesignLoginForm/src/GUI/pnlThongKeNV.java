package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import entity.NhanVien;

import javax.swing.JComboBox;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class pnlThongKeNV extends JPanel implements ActionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCaoNhat;
	private JTextField txtThapNhat;
	private JTextField txtSoHD;
	private JTextField txtTongDoanhThu;
	private JButton btnLoc, btnXuatBaoCao, btnHienThiBieuDo;
	private JDateChooser csTu,csDen;
	private JComboBox<String> cbLoc;
	private DefaultTableModel modelHD, modelCTHD;
	private JTable tblHD, tblCTHD;
	private JPopupMenu popupMenu;
	private JMenuItem itXemChiTiet;
	private Dao_NhanVien nhanVien_dao;
	private NhanVien nvLogin;

	public pnlThongKeNV() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.ORANGE);
		setSize(1163,763);
		setLayout(null);
		
		JPanel pnNorth = new JPanel();
		pnNorth.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnNorth.setLayout(null);
		pnNorth.setPreferredSize(new Dimension(900, 170));
		pnNorth.setBounds(10, 10, 1129, 158);
		add(pnNorth);
		
		JLabel lblTu = new JLabel("Từ ngày:");
		lblTu.setFont(new Font("Arial", Font.BOLD, 14));
		lblTu.setBounds(20, 20, 83, 30);
		pnNorth.add(lblTu);
		
		csTu = new JDateChooser();
		csTu.setDateFormatString("dd/MM/yyyy");
		csTu.setBounds(142, 20, 150, 30);
		pnNorth.add(csTu);
		
		JLabel lblDen = new JLabel("Đến ngày:");
		lblDen.setFont(new Font("Arial", Font.BOLD, 14));
		lblDen.setBounds(20, 70, 83, 30);
		pnNorth.add(lblDen);
		
		csDen = new JDateChooser();
		csDen.setDateFormatString("dd/MM/yyyy");
		csDen.setBounds(142, 70, 150, 30);
		pnNorth.add(csDen);
		
		JLabel lblLocTheo = new JLabel("Lọc theo:");
		lblLocTheo.setFont(new Font("Arial", Font.BOLD, 14));
		lblLocTheo.setBounds(20, 118, 83, 30);
		pnNorth.add(lblLocTheo);
		
		cbLoc = new JComboBox<String>();
		cbLoc.setPreferredSize(new Dimension(150, 30));
		cbLoc.setBounds(142, 119, 150, 30);
		pnNorth.add(cbLoc);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setBounds(319, 70, 60, 30);
		pnNorth.add(btnLoc);
		
		btnHienThiBieuDo = new JButton("Hiển thị dưới dạng biểu đồ");
		btnHienThiBieuDo.setBounds(549, 119, 250, 30);
		pnNorth.add(btnHienThiBieuDo);
		
		btnXuatBaoCao = new JButton("Xuất báo cáo");
		btnXuatBaoCao.setBounds(819, 119, 150, 30);
		pnNorth.add(btnXuatBaoCao);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "H\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 178, 1129, 294);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setPreferredSize(new Dimension(900, 165));
		scrollPane.setBounds(10, 22, 1109, 263);
		panel.add(scrollPane);
		
		String[] tb_N = new String[] { "Mã hóa đơn", "Tên khách hàng", "Ngày giao dịch", "Tổng tiền"};
		modelHD = new DefaultTableModel(tb_N, 0);
		tblHD = new JTable(modelHD);		
		scrollPane.setViewportView(tblHD);
		
		modelHD.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    tinhTongTien();
                    tinhSoHoaDon();
                    setMinMaxTotal();
                }
            }
        });
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 482, 1129, 201);
		add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setPreferredSize(new Dimension(900, 165));
		scrollPane_1.setBounds(10, 18, 1109, 143);
		panel_1.add(scrollPane_1);
		
		String[] tb_CT = new String[] { "STT", "Tên sản phẩm", "Giá bán", "Số lượng", "Thành tiền"};
		modelCTHD = new DefaultTableModel(tb_CT, 0);
		tblCTHD = new JTable(modelCTHD);		
		scrollPane_1.setViewportView(tblCTHD);
		
		
		
		JLabel lblNewLabel = new JLabel("Cao nhất:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 708, 67, 26);
		add(lblNewLabel);
		
		txtCaoNhat = new JTextField();
		txtCaoNhat.setBounds(97, 713, 111, 19);
		add(txtCaoNhat);
		txtCaoNhat.setColumns(10);
		
		JLabel lblThpNht = new JLabel("Thấp nhất:");
		lblThpNht.setFont(new Font("Arial", Font.BOLD, 14));
		lblThpNht.setBounds(228, 708, 85, 26);
		add(lblThpNht);
		
		txtThapNhat = new JTextField();
		txtThapNhat.setColumns(10);
		txtThapNhat.setBounds(310, 713, 116, 19);
		add(txtThapNhat);
		
		JLabel lblTngSHa = new JLabel("Tổng số hóa đơn:");
		lblTngSHa.setFont(new Font("Arial", Font.BOLD, 14));
		lblTngSHa.setBounds(568, 708, 123, 26);
		add(lblTngSHa);
		
		txtSoHD = new JTextField();
		txtSoHD.setColumns(10);
		txtSoHD.setBounds(701, 713, 116, 19);
		add(txtSoHD);
		
		
		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu:");
		lblTngDoanhThu.setFont(new Font("Arial", Font.BOLD, 14));
		lblTngDoanhThu.setBounds(834, 708, 123, 26);
		add(lblTngDoanhThu);
		
		txtTongDoanhThu = new JTextField();
		txtTongDoanhThu.setColumns(10);
		txtTongDoanhThu.setBounds(967, 713, 116, 19);
		txtTongDoanhThu.setText(0+"");
		add(txtTongDoanhThu);
		
		popupMenu=new JPopupMenu();
		itXemChiTiet=new JMenuItem("Xem chi tiết hóa đơn");
		popupMenu.add(itXemChiTiet);
		
		// lấy thông tin nhân viên
		nvLogin = null;
		if (FrameDashBoard.taiKhoanLogin != null) {
		    nvLogin = FrameDashBoard.taiKhoanLogin.getNhanVien();
		}
		else {
		    nvLogin = FrameDashBoardNVBH.taiKhoanLogin.getNhanVien();
		}
		getHDByNV(nvLogin);
		
		tinhTongTien();
		tinhSoHoaDon();
		setMinMaxTotal();
		
		itXemChiTiet.addActionListener(this);
		btnHienThiBieuDo.addActionListener(this);
		btnXuatBaoCao.addActionListener(this);
		btnLoc.addActionListener(this);
		tblHD.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			int r = tblHD.rowAtPoint(e.getPoint());
			if (r >= 0 && r < tblHD.getRowCount()) {
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(itXemChiTiet)) {
			int rowIndex=tblHD.getSelectedRow();
			  if(rowIndex>=0) {
				  String maHD=tblHD.getValueAt(rowIndex, 0).toString();
				  PreparedStatement sta=null;
				  try {
					  ConnectDB.getInstance();
				      Connection con = ConnectDB.getConnection();
					  DefaultTableModel dm=(DefaultTableModel) tblCTHD.getModel();
			          dm.setRowCount(0);
			          String sql = "Select cthd.MAHOADONBAN, sp.TENSANPHAM, sp.GIABAN, cthd.SOLUONG, cthd.THANHTIEN " +
			                    "FROM HOADONBAN AS hd " +
			                    "JOIN CHITIETHOADONBAN AS cthd ON hd.MAHOADONBAN = cthd.MAHOADONBAN " +
			                    "JOIN SANPHAM AS sp ON cthd.MASANPHAM = sp.MASANPHAM " +
			                    "WHERE cthd.MAHOADONBAN = ? " +
			                    "GROUP BY cthd.MAHOADONBAN, sp.TENSANPHAM, sp.GIABAN, cthd.SOLUONG, cthd.THANHTIEN";
			            sta = con.prepareStatement(sql);
			            sta.setString(1, maHD);
			            ResultSet rs = sta.executeQuery();

			            Object obj[] = new Object[6]; // Increased the array size to accommodate the new column

			            int stt = 1; // Variable to keep track of row numbers
			            while (rs.next()) {
			                obj[0] = stt; // STT column
			                obj[1] = rs.getString(2);
			                obj[2] = rs.getDouble(3);
			                obj[3] = rs.getInt(4);
			                obj[4] = rs.getDouble(5);
			                dm.addRow(obj);
			                stt++;
					  }
				  }catch (Exception e1) {
					// TODO: handle exception
					  e1.printStackTrace();
				}
			  }
		}else if(o.equals(btnLoc)) {
			getHDByNVBW(nvLogin, csTu, csDen);
		}
		
	}
	
	public void getHDByNV(NhanVien nv) {
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH, SUM(hd.TONGTHANHTIEN) AS TONGTHANHTIEN " +
	                "FROM HOADONBAN AS hd " +
	                "JOIN KHACHHANG AS kh ON hd.MAKHACHHANG = kh.MAKHACHHANG " +
	                "JOIN NHANVIEN AS nv ON hd.MANHANVIEN = nv.MANHANVIEN " +
	                "WHERE nv.MANHANVIEN = ? " +
	                "GROUP BY hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH";
	        
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, nv.getMaNhanVien());  
	        
	        ResultSet rs = pst.executeQuery();
	        Object obj[] = new Object[15];
	        while (rs.next()) {
	            obj[0] = rs.getString(1);
	            obj[1] = rs.getString(2);
	            obj[2] = rs.getDate(3);
	            obj[3] = rs.getDouble(4);

	            modelHD.addRow(obj);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public String formatTien(double tien) {
		DecimalFormat df = new DecimalFormat("#,##0VND");
		String s = df.format(tien);
		return s;
	}
	
	public void tinhTongTien() {
		double tongTien=0;
        for(int i=0;i<modelHD.getRowCount();i++) {
        	double thanhTien=Double.parseDouble(modelHD.getValueAt(i, 3).toString());
        	tongTien+=thanhTien;
        }txtTongDoanhThu.setText(formatTien(tongTien));
	}
	public void tinhSoHoaDon() {
		int soHD = 0;
		soHD= modelHD.getRowCount();
		txtSoHD.setText(String.valueOf(soHD));
	}
	
	public void setMinMaxTotal() {
	    double caoNhat = Double.MIN_VALUE;
	    double thapNhat = Double.MAX_VALUE;

	    for (int i = 0; i < modelHD.getRowCount(); i++) {
	        double tongThanhTien = Double.parseDouble(modelHD.getValueAt(i, 3).toString());

	        // Tìm giá trị cao nhất
	        if (tongThanhTien > caoNhat) {
	            caoNhat = tongThanhTien;
	        }

	        // Tìm giá trị thấp nhất
	        if (tongThanhTien < thapNhat) {
	            thapNhat = tongThanhTien;
	        }
	    }

	    // Đặt giá trị cho JTextField
	    txtCaoNhat.setText(String.valueOf(caoNhat));
	    txtThapNhat.setText(String.valueOf(thapNhat));
	}
	public void getHDByNVBW(NhanVien nv, JDateChooser jdTu, JDateChooser jdDen) {
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH, SUM(hd.TONGTHANHTIEN) AS TONGTHANHTIEN " +
	                "FROM HOADONBAN AS hd " +
	                "JOIN KHACHHANG AS kh ON hd.MAKHACHHANG = kh.MAKHACHHANG " +
	                "JOIN NHANVIEN AS nv ON hd.MANHANVIEN = nv.MANHANVIEN " +
	                "WHERE nv.MANHANVIEN = ? " +
	                "AND hd.NGAYGIAODICH BETWEEN ? AND ? " +
	                "GROUP BY hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH";
	        
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, nv.getMaNhanVien());
	        pst.setDate(2, new java.sql.Date(jdTu.getDate().getTime()));
	        pst.setDate(3, new java.sql.Date(jdDen.getDate().getTime()));
	        DefaultTableModel dm=(DefaultTableModel) tblHD.getModel();
            dm.setRowCount(0);
	        ResultSet rs = pst.executeQuery();
	        Object obj[] = new Object[15];
	        while (rs.next()) {
	            obj[0] = rs.getString(1);
	            obj[1] = rs.getString(2);
	            obj[2] = rs.getDate(3);
	            obj[3] = rs.getDouble(4);
	            dm.addRow(obj);
	            ;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
