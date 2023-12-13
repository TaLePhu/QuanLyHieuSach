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
import java.sql.Statement;
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
import dao.Dao_SanPham;
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


	private JTable tableSP;
	private JTextField txtDangBan;
	private JTextField txtTongSP;
	private JComboBox<String> cbLoc;

	private JButton btnXemTK, btnLoadTable,btnInThongKe, btnXemBieuDo ;
	private JTextField txtNgungBan;
	private Dao_SanPham sanPham_dao = new Dao_SanPham();
	

		
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
		
		//btn biểu đồ
		btnXemBieuDo = new JButton("Xem Biểu đồ doanh thu theo tháng");
		btnXemBieuDo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnXemBieuDo.setBounds(10, 457, 316, 57);
		Image img_BieuDo = new ImageIcon(this.getClass().getResource("/icon_thongke_s.png")).getImage();
		btnXemBieuDo.setIcon(new ImageIcon(img_BieuDo));
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
		pnlNgay.setBounds(10, 59, 354, 103);
		pnlTKSanPham.add(pnlNgay);
		pnlNgay.setLayout(null);
		
		JLabel lblNgayBD_1 = new JLabel("Từ ngày:");
		lblNgayBD_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayBD_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgayBD_1.setBounds(20, 20, 89, 30);
		pnlNgay.add(lblNgayBD_1);
		
		JDateChooser csNgayBD = new JDateChooser();
		csNgayBD.setDateFormatString("dd/MM/yyyy");
		csNgayBD.setBounds(132, 20, 200, 30);
		pnlNgay.add(csNgayBD);
		
		JLabel lblNgayKT_1 = new JLabel("Đến ngày:");
		lblNgayKT_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayKT_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgayKT_1.setBounds(20, 63, 96, 30);
		pnlNgay.add(lblNgayKT_1);
		
		JDateChooser csNgayKT = new JDateChooser();
		csNgayKT.setDateFormatString("dd/MM/yyyy");
		csNgayKT.setBounds(132, 63, 200, 30);
		pnlNgay.add(csNgayKT);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBounds(371, 59, 745, 103);
		pnlTKSanPham.add(pnlChucNang);
		
		cbLoc = new JComboBox();
		cbLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbLoc.setModel(new DefaultComboBoxModel(new String[] {"Top 10 sản phẩm bán chạy nhất", "Top 10 sản phẩm bán ít nhất", "Các sản phẩm chưa bán được"}));
		cbLoc.setBounds(10, 20, 297, 55);
		pnlChucNang.add(cbLoc);
		
		JButton btnXemThongKe = new JButton("Xem thống kê");
		btnXemThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemThongKe.setBounds(317, 20, 204, 55);
		pnlChucNang.add(btnXemThongKe);
		Image img_iconXemThongKe = new ImageIcon(this.getClass().getResource("/icon_customers_s.png")).getImage();
		btnXemThongKe.setIcon(new ImageIcon(img_iconXemThongKe));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLamMoi.setBounds(531, 20, 204, 55);
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
		
		
		String[] tb_SP = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Số lượng đã bán"};
		modelSP = new DefaultTableModel(tb_SP, 0);
		tableSP = new JTable(modelSP);
		scrollPane_1.setViewportView(tableSP);

		
		
		JPanel pnlThongSo = new JPanel();
		pnlThongSo.setBounds(10, 648, 1106, 58);
		pnlTKSanPham.add(pnlThongSo);
		pnlThongSo.setLayout(null);
		
		JLabel lblTongTien = new JLabel("Đang bán: ");
		lblTongTien.setBounds(25, 18, 110, 30);
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setFont(new Font("Arial", Font.PLAIN, 20));
		pnlThongSo.add(lblTongTien);
		
		JLabel lblTongSP = new JLabel("Tổng số sản phẩm:");
		lblTongSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongSP.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTongSP.setBounds(666, 14, 222, 30);
		pnlThongSo.add(lblTongSP);
		
		txtDangBan = new JTextField();
		txtDangBan.setBounds(149, 18, 124, 30);
		pnlThongSo.add(txtDangBan);
		txtDangBan.setColumns(10);
		txtDangBan.setText("53");
		
		txtTongSP = new JTextField();
		txtTongSP.setColumns(10);
		txtTongSP.setBounds(898, 14, 186, 30);
		pnlThongSo.add(txtTongSP);
		txtTongSP.setText(String.valueOf(setTotalProductCount()));
		
		JLabel lblNgngBn = new JLabel("Ngưng bán:");
		lblNgngBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgngBn.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgngBn.setBounds(327, 18, 110, 30);
		pnlThongSo.add(lblNgngBn);
		
		txtNgungBan = new JTextField();
		txtNgungBan.setColumns(10);
		txtNgungBan.setBounds(458, 18, 124, 30);
		pnlThongSo.add(txtNgungBan);
		txtNgungBan.setText(String.valueOf(sanPham_dao.getSPTheoTinhTrang("Ngưng bán").size()));
		
		//đăng ký sự kiện
		btnXemTK.addActionListener(this);
		btnLoadTable.addActionListener(this);
		btnInThongKe.addActionListener(this);
		btnXemBieuDo.addActionListener(this);
		cbLoc.addActionListener(this);
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
		if(o.equals(cbLoc)) {
			String selectedOption = cbLoc.getSelectedItem().toString();
			if(selectedOption.equals("Top 10 sản phẩm bán chạy nhất")) {
				modelSP.setRowCount(0);
				getTop10Selling();
			}else if(selectedOption.equals("Top 10 sản phẩm bán ít nhất")) {
				modelSP.setRowCount(0);
				getTop10Leasting();
			}else {
				modelSP.setRowCount(0);
				getNotSelling();
			}
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
	
//	Thống kê sản phẩm
	public void getTop10Selling() {
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT TOP 10 SANPHAM.MASANPHAM, SANPHAM.TENSANPHAM, SUM(CHITIETHOADONBAN.SOLUONG) AS TONGSOLUONGBAN " +
	                     "FROM SANPHAM " +
	                     "JOIN CHITIETHOADONBAN ON SANPHAM.MASANPHAM = CHITIETHOADONBAN.MASANPHAM " +
	                     "GROUP BY SANPHAM.MASANPHAM, SANPHAM.TENSANPHAM " +
	                     "ORDER BY TONGSOLUONGBAN DESC;";
	        Statement sta = con.createStatement();
	        ResultSet rs = sta.executeQuery(sql);
	        Object obj[] = new Object[3];
	        while (rs.next()) {
	            obj[0] = rs.getString(1);
	            obj[1] = rs.getString(2);
	            obj[2] = rs.getInt(3);
	            modelSP.addRow(obj);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void getTop10Leasting() {
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT TOP 10 SANPHAM.MASANPHAM, SANPHAM.TENSANPHAM, SUM(CHITIETHOADONBAN.SOLUONG) AS TONGSOLUONGBAN " +
	                     "FROM SANPHAM " +
	                     "JOIN CHITIETHOADONBAN ON SANPHAM.MASANPHAM = CHITIETHOADONBAN.MASANPHAM " +
	                     "GROUP BY SANPHAM.MASANPHAM, SANPHAM.TENSANPHAM " +
	                     "ORDER BY TONGSOLUONGBAN ASC;";
	        Statement sta = con.createStatement();
	        ResultSet rs = sta.executeQuery(sql);
	        Object obj[] = new Object[3];
	        while (rs.next()) {
	            obj[0] = rs.getString(1);
	            obj[1] = rs.getString(2);
	            obj[2] = rs.getInt(3);
	            modelSP.addRow(obj);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void getNotSelling() {
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT SANPHAM.MASANPHAM, SANPHAM.TENSANPHAM FROM SANPHAM " +
                    "WHERE SANPHAM.MASANPHAM NOT IN (SELECT DISTINCT MASANPHAM FROM CHITIETHOADONBAN);";
	        Statement sta = con.createStatement();
	        ResultSet rs = sta.executeQuery(sql);
	        Object obj[] = new Object[3];
	        while (rs.next()) {
	            obj[0] = rs.getString(1);
	            obj[1] = rs.getString(2);
	            obj[2] = 0;
	            modelSP.addRow(obj);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public int setTotalProductCount() {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT COUNT(*) AS TongSoLuongSanPham FROM SANPHAM;";
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sql);

            // Đảm bảo ResultSet chỉ có một dòng kết quả
            if (rs.next()) {
                int tongSoLuongSanPham = rs.getInt("TongSoLuongSanPham");

                return tongSoLuongSanPham;
                // Đặt giá trị vào JTextField
//                txtTongSP.setText(String.valueOf(tongSoLuongSanPham));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return 0;
    }
	
	public int setTotalProductNCount() {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT COUNT(*) AS TongSoLuongSanPham FROM SANPHAM WHERE TINHTRANG = ?;";
            PreparedStatement sta = con.prepareStatement(sql);
            sta.setString(1, "Đang bán");
            ResultSet rs = sta.executeQuery();

            // Đảm bảo ResultSet chỉ có một dòng kết quả
            if (rs.next()) {
                int tongSoLuongSanPham = rs.getInt("TongSoLuongSanPham");

                return tongSoLuongSanPham;
                // Đặt giá trị vào JTextField
//                txtTongSP.setText(String.valueOf(tongSoLuongSanPham));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return 0;
    }
	


	
	
}
