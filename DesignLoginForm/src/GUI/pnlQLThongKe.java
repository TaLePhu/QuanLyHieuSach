package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class pnlQLThongKe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSoLuong;
	private JTextField textField;

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
		lblNgayBD.setBounds(27, 65, 117, 39);
		pnlTKDoanhThu.add(lblNgayBD);
		
		JLabel lblnNgy = new JLabel("Đến ngày");
		lblnNgy.setHorizontalAlignment(SwingConstants.CENTER);
		lblnNgy.setFont(new Font("Arial", Font.PLAIN, 15));
		lblnNgy.setBounds(27, 162, 117, 39);
		pnlTKDoanhThu.add(lblnNgy);
		
		JButton btnXemTK = new JButton("Xem thống kê");
		btnXemTK.setFont(new Font("Arial", Font.PLAIN, 15));
		btnXemTK.setBounds(10, 255, 136, 39);
		pnlTKDoanhThu.add(btnXemTK);
		
		JButton btnInThngK = new JButton("In thống kê");
		btnInThngK.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInThngK.setBounds(169, 255, 136, 39);
		pnlTKDoanhThu.add(btnInThngK);
		
		JLabel lblSoLuongHD = new JLabel("Số lượng hóa đơn bán được:");
		lblSoLuongHD.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSoLuongHD.setBounds(10, 328, 206, 39);
		pnlTKDoanhThu.add(lblSoLuongHD);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(209, 339, 96, 19);
		pnlTKDoanhThu.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Doanh Thu:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(85, 397, 108, 29);
		pnlTKDoanhThu.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(209, 397, 96, 19);
		pnlTKDoanhThu.add(textField);
		textField.setColumns(10);
		
		JPanel pnlTK = new JPanel();
		tabbedPane.addTab("New tab", null, pnlTK, null);
	}
}
