package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import entity.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hpsf.Decimal;

public class pnlQLThongKe extends JPanel implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSoLuong;
	private JTextField txtDoanhThu;
	private DefaultTableModel modelTK;
	private	JTable table;
	private JDateChooser csDenN, cstuN;
	private JButton btnXemTK;
		
	/**
	 * Create the panel.
	 */
	public pnlQLThongKe() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.ORANGE);
		setSize(1163,763);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1131, 743);
		add(tabbedPane);
		
		JPanel pnlTKDoanhThu = new JPanel();
		tabbedPane.addTab("Thống Kê Doanh Thu", null, pnlTKDoanhThu, null);
		pnlTKDoanhThu.setLayout(null);
		
		JLabel lblTKDT = new JLabel("THỐNG KÊ DOANH THU");
		lblTKDT.setFont(new Font("Arial", Font.BOLD, 20));
		lblTKDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTKDT.setBounds(277, 10, 467, 39);
		pnlTKDoanhThu.add(lblTKDT);
		
		JLabel lblNgayBD = new JLabel("Từ ngày:");
		lblNgayBD.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNgayBD.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayBD.setBounds(70, 59, 96, 39);
		pnlTKDoanhThu.add(lblNgayBD);
		
		JLabel lblnNgy = new JLabel("Đến ngày:");
		lblnNgy.setHorizontalAlignment(SwingConstants.CENTER);
		lblnNgy.setFont(new Font("Arial", Font.PLAIN, 15));
		lblnNgy.setBounds(70, 176, 96, 29);
		pnlTKDoanhThu.add(lblnNgy);
		
		//btn xem Thống kê
		btnXemTK = new JButton("Xem thống kê");
		btnXemTK.setFont(new Font("Arial", Font.PLAIN, 15));
		btnXemTK.setBounds(10, 304, 136, 39);
		pnlTKDoanhThu.add(btnXemTK);
		
		JButton btnInThongKe = new JButton("In thống kê");
		btnInThongKe.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInThongKe.setBounds(169, 304, 136, 39);
		pnlTKDoanhThu.add(btnInThongKe);
		
		JLabel lblSoLuongHD = new JLabel("Số lượng hóa đơn bán được:");
		lblSoLuongHD.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSoLuongHD.setBounds(10, 423, 206, 39);
		pnlTKDoanhThu.add(lblSoLuongHD);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(230, 434, 96, 30);
		pnlTKDoanhThu.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Doanh Thu:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(70, 501, 108, 29);
		pnlTKDoanhThu.add(lblNewLabel);
		
		txtDoanhThu = new JTextField();
		txtDoanhThu.setBounds(230, 502, 96, 30);
		pnlTKDoanhThu.add(txtDoanhThu);
		txtDoanhThu.setColumns(10);
		
		//jdate chooser:
		csDenN = new JDateChooser();
		csDenN.setDateFormatString("dd/MM/yyyy");
		csDenN.setBounds(24, 215, 252, 30);
		pnlTKDoanhThu.add(csDenN);
		
		cstuN = new JDateChooser();
		cstuN.setDateFormatString("dd/MM/yyyy");
		cstuN.setBounds(24, 107, 252, 30);
		pnlTKDoanhThu.add(cstuN);
		
		JPanel pnlThongKe = new JPanel();
		pnlThongKe.setBounds(336, 59, 780, 647);
		pnlTKDoanhThu.add(pnlThongKe);
		pnlThongKe.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 760, 627);
		pnlThongKe.add(scrollPane);
		
		//create table
		String[] cols = new String[] {"Mã hóa đơn" , "Tên khách hàng", "Tên Nhân Viên","Ngày tạo","Tổng thành tiên"};
		modelTK = new DefaultTableModel(cols, 0);
		
		table = new JTable(modelTK);
		scrollPane.setViewportView(table);
		
		modelTK.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
					///
					doanhThu();
					tongHoaDon();
				}
				
			}
		});
		
		//gọi hàm xuất dữ liệu ra bảng
		getAllHD();
		
		JPanel pnlTK = new JPanel();
		tabbedPane.addTab("New tab", null, pnlTK, null);
		
		//đăng ký sự kiện
		btnXemTK.addActionListener(this);
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXemTK)) {
			getHDTheoDate(cstuN.getDate(), csDenN.getDate());
		}
	}
	
	//lấy tất cả hóa đơn
	public void getAllHD() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT hd.MAHOADONBAN, kh.HOTENKHACHHANG,hd.MANHANVIEN, hd.NGAYGIAODICH, SUM(hd.TONGTHANHTIEN) AS TONGTHANHTIEN "
					+ "FROM HOADONBAN AS hd "
					+ "JOIN KHACHHANG AS kh ON hd.MAKHACHHANG = kh.MAKHACHHANG "
					+ "JOIN NHANVIEN AS nv ON hd.MANHANVIEN = nv.MANHANVIEN "
					+ "GROUP BY hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH, hd.MANHANVIEN ";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Object obj[] = new Object[15];
			while(rs.next()) {
				obj[0] = rs.getString(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getString(3);
				obj[3] =rs.getDate(4);
				obj[4] = rs.getDouble(5);
				modelTK.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getHDTheoDate(Date fromDate, Date toDate) {
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT hd.MAHOADONBAN, kh.HOTENKHACHHANG,hd.MANHANVIEN, hd.NGAYGIAODICH, SUM(hd.TONGTHANHTIEN) AS TONGTHANHTIEN " +
	                "FROM HOADONBAN AS hd " +
	                "JOIN KHACHHANG AS kh ON hd.MAKHACHHANG = kh.MAKHACHHANG " +
	                "JOIN NHANVIEN AS nv ON hd.MANHANVIEN = nv.MANHANVIEN " +
	                "WHERE hd.NGAYGIAODICH BETWEEN ? AND ? " +
	                "GROUP BY hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH,hd.MANHANVIEN ";
	        
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setDate(1, new java.sql.Date(fromDate.getTime()));
	        pst.setDate(2, new java.sql.Date(toDate.getTime()));
	        DefaultTableModel dm=(DefaultTableModel) table.getModel();
            dm.setRowCount(0);
	        ResultSet rs = pst.executeQuery();
	        Object obj[] = new Object[15];
	        while (rs.next()) {
	            obj[0] = rs.getString(1);
	            obj[1] = rs.getString(2);
	            obj[2] = rs.getString(3);
				obj[3] =rs.getDate(4);
				obj[4] = rs.getDouble(5);
	            dm.addRow(obj);
	            ;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	//
	public String formatTien(double tien) {
		DecimalFormat df = new DecimalFormat("#,##0VND");
		String s = df.format(tien);
		return s;
	}
	
	//tinh doanh thu
	public void doanhThu() {
		double doanhThu = 0;
		for(int i=0;i < modelTK.getRowCount();i++) {
			double thanhTien = Double.parseDouble(modelTK.getValueAt(i,4).toString());
			doanhThu+=thanhTien;
		}
		txtDoanhThu.setText(formatTien(doanhThu));
	}
	
	//tổng hóa đơn
	public void tongHoaDon() {
		int soHD = 0;
		soHD = modelTK.getRowCount();
		txtSoLuong.setText(String.valueOf(soHD));
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
