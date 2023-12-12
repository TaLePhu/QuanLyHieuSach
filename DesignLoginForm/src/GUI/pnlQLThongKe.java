package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class pnlQLThongKe extends JPanel implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSoLuong;
	private JTextField txtDoanhThu;
	private DefaultTableModel modelTK, modelSP;
	private	JTable table;
	private JDateChooser csDenN, cstuN;


	private JTable table_1;
	private JTextField txtTongTien;
	private JTextField txtTongSP;

	private JButton btnXemTK, btnLoadTable,btnInThongKe, btnXemBieuDo ;

		
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
		
		JLabel lblTitle = new JLabel("THỐNG KÊ DOANH THU");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(277, 10, 467, 39);
		pnlTKDoanhThu.add(lblTitle);
		
		JLabel lblNgayBD = new JLabel("Từ ngày:");
		lblNgayBD.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgayBD.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayBD.setBounds(70, 59, 96, 39);
		pnlTKDoanhThu.add(lblNgayBD);
		
		JLabel lblnNgy = new JLabel("Đến ngày:");
		lblnNgy.setHorizontalAlignment(SwingConstants.CENTER);
		lblnNgy.setFont(new Font("Arial", Font.PLAIN, 20));
		lblnNgy.setBounds(70, 176, 96, 29);
		pnlTKDoanhThu.add(lblnNgy);
		
		//btn xem Thống kê
		btnXemTK = new JButton("Xem thống kê");
		btnXemTK.setFont(new Font("Arial", Font.PLAIN, 15));
		btnXemTK.setBounds(10, 304, 136, 39);
		pnlTKDoanhThu.add(btnXemTK);
		
		btnInThongKe = new JButton("In thống kê");
		btnInThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInThongKe.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInThongKe.setBounds(10, 358, 136, 39);
		pnlTKDoanhThu.add(btnInThongKe);
		
		JLabel lblSoLuongHD = new JLabel("Tổng hóa đơn bán được:");
		lblSoLuongHD.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoLuongHD.setBounds(8, 547, 212, 39);
		pnlTKDoanhThu.add(lblSoLuongHD);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(230, 554, 96, 30);
		pnlTKDoanhThu.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Doanh Thu:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(95, 610, 96, 29);
		pnlTKDoanhThu.add(lblNewLabel);
		
		txtDoanhThu = new JTextField();
		txtDoanhThu.setBounds(230, 612, 96, 30);
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
		pnlThongKe.setBounds(336, 71, 780, 645);
		pnlTKDoanhThu.add(pnlThongKe);
		pnlThongKe.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 760, 637);
		pnlThongKe.add(scrollPane);
		
		//create table
		String[] cols = new String[] {"Mã hóa đơn" , "Tên khách hàng", "Tên nhân viên","Ngày tạo","Tổng thành tiên"};
		modelTK = new DefaultTableModel(cols, 0);
		
		table = new JTable(modelTK);
		scrollPane.setViewportView(table);
		
		//btn Load Table
		btnLoadTable = new JButton("Làm mới");

		btnLoadTable.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLoadTable.setBounds(176, 304, 136, 39);
		pnlTKDoanhThu.add(btnLoadTable);
		
		btnXemBieuDo = new JButton("Xem Biểu đồ doanh thu theo tháng");
		btnXemBieuDo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnXemBieuDo.setBounds(24, 455, 288, 39);
		pnlTKDoanhThu.add(btnXemBieuDo);
		
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
		
		
		//Thống kê sản phẩm
		JPanel pnlTKSanPham = new JPanel();
		tabbedPane.addTab("Thống kê sản phẩm", null, pnlTKSanPham, null);
		pnlTKSanPham.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("THỐNG KÊ SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(300, 10, 467, 39);
		pnlTKSanPham.add(lblNewLabel_1);
		
		JPanel pnlNgay = new JPanel();
		pnlNgay.setBounds(10, 59, 401, 103);
		pnlTKSanPham.add(pnlNgay);
		pnlNgay.setLayout(null);
		
		JLabel lblNgayBD_1 = new JLabel("Từ ngày:");
		lblNgayBD_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayBD_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgayBD_1.setBounds(20, 20, 89, 30);
		pnlNgay.add(lblNgayBD_1);
		
		JDateChooser csNgayBD = new JDateChooser();
		csNgayBD.setDateFormatString("dd/MM/yyyy");
		csNgayBD.setBounds(132, 20, 252, 30);
		pnlNgay.add(csNgayBD);
		
		JLabel lblNgayKT_1 = new JLabel("Đến ngày:");
		lblNgayKT_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayKT_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgayKT_1.setBounds(20, 63, 96, 30);
		pnlNgay.add(lblNgayKT_1);
		
		JDateChooser csNgayKT = new JDateChooser();
		csNgayKT.setDateFormatString("dd/MM/yyyy");
		csNgayKT.setBounds(132, 63, 252, 30);
		pnlNgay.add(csNgayKT);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBounds(421, 59, 695, 103);
		pnlTKSanPham.add(pnlChucNang);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sản phẩm bán nhiều nhất", "Sản phẩm có doanh thu cao nhất"}));
		comboBox.setBounds(10, 20, 247, 55);
		pnlChucNang.add(comboBox);
		
		JButton btnXemThongKe = new JButton("Xem thống kê");
		btnXemThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemThongKe.setBounds(267, 20, 204, 55);
		pnlChucNang.add(btnXemThongKe);
		Image img_iconXemThongKe = new ImageIcon(this.getClass().getResource("/icon_customers_s.png")).getImage();
		btnXemThongKe.setIcon(new ImageIcon(img_iconXemThongKe));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBounds(481, 20, 204, 55);
		pnlChucNang.add(btnLamMoi);
		Image img_iconLamMoi = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnLamMoi.setIcon(new ImageIcon(img_iconLamMoi));
		
		JPanel pnlThongTinChiTiet = new JPanel();
		pnlThongTinChiTiet.setBounds(10, 182, 1106, 456);
		pnlTKSanPham.add(pnlThongTinChiTiet);
		pnlThongTinChiTiet.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1106, 456);
		pnlThongTinChiTiet.add(scrollPane_1);
		
		String[] cols_1 = new String[] {"Mã sản phẩm" , "Tên sản phẩm", "Số lượng bán", "Giá bán", "Thành tiền"};
		modelSP = new DefaultTableModel(cols_1, 0);
		table_1 = new JTable(modelSP);
		scrollPane_1.setViewportView(table_1);

		modelSP.addTableModelListener(new TableModelListener() {
		    @Override
		    public void tableChanged(TableModelEvent e) {
		        if (e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
		            // Gọi các phương thức 
//		            tongTienSP();
		            tongSPBan();
		        }
		    }
		});

		// Gọi dữ liệu lên thống kê sản phẩm
		getAllSP();
		
		JPanel pnlThongSo = new JPanel();
		pnlThongSo.setBounds(10, 648, 1106, 58);
		pnlTKSanPham.add(pnlThongSo);
		pnlThongSo.setLayout(null);
		
		JLabel lblTongTien = new JLabel("Tổng tiền: ");
		lblTongTien.setBounds(167, 14, 110, 30);
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setFont(new Font("Arial", Font.PLAIN, 20));
		pnlThongSo.add(lblTongTien);
		
		JLabel lblTongSP = new JLabel("Tổng số lượng sản phẩm đã bán: ");
		lblTongSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongSP.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTongSP.setBounds(578, 14, 342, 30);
		pnlThongSo.add(lblTongSP);
		
		txtTongTien = new JTextField();
		txtTongTien.setBounds(280, 14, 247, 30);
		pnlThongSo.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		txtTongSP = new JTextField();
		txtTongSP.setColumns(10);
		txtTongSP.setBounds(898, 14, 186, 30);
		pnlThongSo.add(txtTongSP);
		
		//đăng ký sự kiện
		btnXemTK.addActionListener(this);
		btnLoadTable.addActionListener(this);
		btnInThongKe.addActionListener(this);
		btnXemBieuDo.addActionListener(this);
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
			if(cstuN.getDate() == null) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày bắt đầu");
				cstuN.requestFocus();
				return ;
			}
			if(csDenN.getDate() == null) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày kết thúc");
				cstuN.requestFocus();
				return ;
			}
			//gọi hàm lấy hóa đơn theo ngày
			getHDTheoDate(cstuN.getDate(), csDenN.getDate());
		}
		
		if(o.equals(btnLoadTable)) {
			cstuN.setDate(null);
			csDenN.setDate(null);
			deleteTable();
			getAllHD();
		}
		
		if(o.equals(btnInThongKe)) {
			
			try {
				JOptionPane.showMessageDialog(null, "da in file thanh cong");
				excelExport.ExcelExporterTKDT.exportTable(table, cstuN.getDate(), csDenN.getDate(), "reportDT.xls", txtSoLuong.getText(), txtDoanhThu.getText());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		if(o.equals(btnXemBieuDo)) {
			dataModalDoanhThu();
		}
	}
	//lấy tất cả hóa đơn
	public void getAllHD() {
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT hd.MAHOADONBAN, kh.HOTENKHACHHANG,nv.HOTENNHANVIEN, hd.NGAYGIAODICH, SUM(hd.TONGTHANHTIEN) AS TONGTHANHTIEN "
				+ "FROM HOADONBAN AS hd "
				+ "JOIN KHACHHANG AS kh ON hd.MAKHACHHANG = kh.MAKHACHHANG "
				+ "JOIN NHANVIEN AS nv ON hd.MANHANVIEN = nv.MANHANVIEN "
				+ "GROUP BY hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH, nv.HOTENNHANVIEN ";
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
	        String sql = "SELECT hd.MAHOADONBAN, kh.HOTENKHACHHANG,nv.HOTENNHANVIEN, hd.NGAYGIAODICH, SUM(hd.TONGTHANHTIEN) AS TONGTHANHTIEN " +
	                "FROM HOADONBAN AS hd " +
	                "JOIN KHACHHANG AS kh ON hd.MAKHACHHANG = kh.MAKHACHHANG " +
	                "JOIN NHANVIEN AS nv ON hd.MANHANVIEN = nv.MANHANVIEN " +
	                "WHERE hd.NGAYGIAODICH BETWEEN ? AND ? " +
	                "GROUP BY hd.MAHOADONBAN, kh.HOTENKHACHHANG, hd.NGAYGIAODICH,nv.HOTENNHANVIEN ";
	        
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
	
	public void getAllSP() {
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT sp.MASANPHAM, sp.TENSANPHAM, sp.SOLUONG, sp.GIABAN, sp.SOLUONG * sp.GIABAN AS THANHTIEN FROM SANPHAM AS sp";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		Object obj[] = new Object[10];
		while(rs.next()) {
			obj[0] = rs.getString(1);
			obj[1] = rs.getString(2);
			obj[2] = rs.getInt(3);
			obj[3] =rs.getFloat(4);
			obj[4] = rs.getDouble(5);
			modelSP.addRow(obj);
		}
	} catch (Exception e) {
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
	

	// Tính tổng tiền
	public void tongTienSP() {
	    double tongTien = 0;
	    for (int i = 0; i < modelSP.getRowCount(); i++) {
	        double thanhTien = Double.parseDouble(modelSP.getValueAt(i, 4).toString());
	        tongTien += thanhTien;
	    }
	    txtTongTien.setText(formatTien(tongTien));
	}

	// Tính tổng sản phẩm
	public void tongSPBan() {
	    int rowCount = modelSP.getRowCount();
	    int totalQuantity = 0;

	    for (int i = 0; i < rowCount; i++) {
	        int quantity = (int) modelSP.getValueAt(i, 2);
	        totalQuantity += quantity;
	    }
	    txtTongSP.setText(String.valueOf(totalQuantity));
	}

//	delete table
	public void deleteTable() {
		while(modelTK.getRowCount()>0) {
			modelTK.removeRow(0);
		}
	}
	
//	biểu đồ
	public void dataModalDoanhThu() {
		try {
		    ConnectDB.getInstance();
		    Connection con = ConnectDB.getConnection();

		    // Create a dataset for all months
		    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		    for (int month = 1; month <= 12; month++) {
		        dataset.addValue(0.0, "Tổng tiền", "Tháng " + month);
		    }

		    String sql = "SELECT MONTH(hd.NGAYGIAODICH) AS THANG, SUM(hd.TONGTHANHTIEN) AS TONGTHANHTIEN " +
		            "FROM HOADONBAN AS hd " +
		            "GROUP BY MONTH(hd.NGAYGIAODICH)";
		    PreparedStatement sta = con.prepareStatement(sql);
//		    sta.setString(1, nvLogin.getMaNhanVien());
		    ResultSet rs = sta.executeQuery();

		    // Update values for months with invoices
		    while (rs.next()) {
		        int thang = rs.getInt("THANG");
		        double tongTien = rs.getDouble("TONGTHANHTIEN");
		        dataset.setValue(tongTien, "Tổng tiền", "Tháng " + thang);
		    }

		    // Táº¡o biá»ƒu Ä‘á»“ cá»™t tá»« dataset
		    JFreeChart chart = ChartFactory.createBarChart("Tổng tiền từng tháng", "Tháng", "Tổng tiền",
		                dataset, PlotOrientation.VERTICAL, false, true, false);

		    // Hiá»ƒn thá»‹ biá»ƒu Ä‘á»“ cá»™t trong cá»­a sá»• má»›i
		    ChartFrame chartFrame = new ChartFrame("Biểu đồ doanh thu theo tháng", chart);
		    chartFrame.pack();
		    chartFrame.setVisible(true);
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
