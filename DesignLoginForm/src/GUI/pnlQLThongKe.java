package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pnlQLThongKe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSoLuong;
	private JTextField txtDoanhThu;
	private JTable tblThongKe;
	private DefaultTableModel modelTK;
	private	JTable table;
	private JDateChooser csTu, csDen;
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
		
		JButton btnInThngK = new JButton("In thống kê");
		btnInThngK.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInThngK.setBounds(169, 304, 136, 39);
		pnlTKDoanhThu.add(btnInThngK);
		
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
		csTu = new JDateChooser();
		csTu.setDateFormatString("dd/MM/yyyy");
		csTu.setBounds(24, 215, 252, 30);
		pnlTKDoanhThu.add(csTu);
		
		csDen = new JDateChooser();
		csDen.setDateFormatString("dd/MM/yyyy");
		csDen.setBounds(24, 107, 252, 30);
		pnlTKDoanhThu.add(csDen);
		
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
		
		//gọi hàm xuất dữ liệu ra bảng
		getAllHD();
		
		JPanel pnlTK = new JPanel();
		tabbedPane.addTab("New tab", null, pnlTK, null);
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
				obj[3] =rs.getString(4);
				obj[4] = rs.getString(5);
				modelTK.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
