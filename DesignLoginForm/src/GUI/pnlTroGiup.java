package GUI;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


import java.awt.Font;
import java.awt.Image;

import java.awt.Color;


import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pnlTroGiup extends JPanel {

	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public pnlTroGiup() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.BLUE);
		setBounds(0,0, 1163,763);
		setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 1163, 763);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 285, 763);
		panel.add(scrollPane);



		JPanel panel_1 = new JPanel();
		panel_1.setBounds(290, 0, 873, 763);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(0, 0, 873,1000);
//		panel_2.setLayout(null);
//		
//		
//		
//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setBounds(10, 276, 853, 452);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
//		panel_2.add(lblNewLabel_1);
//		Image img = new ImageIcon(this.getClass().getResource("/THD.png")).getImage();
//		lblNewLabel_1.setIcon(new ImageIcon(img));
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBounds(10, 10, 853, 266);
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
//		panel_2.add(lblNewLabel_2);
//		Image img1 = new ImageIcon(this.getClass().getResource("/HDTHDM.png")).getImage();
//		lblNewLabel_2.setIcon(new ImageIcon(img1));
//		
//		JLabel lblNewLabel_3 = new JLabel("");
//		lblNewLabel_3.setBounds(10, 730, 853, 266);
//		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
//		panel_2.add(lblNewLabel_3);
//		Image img2 = new ImageIcon(this.getClass().getResource("/DSHD1.png")).getImage();
//		lblNewLabel_3.setIcon(new ImageIcon(img2));
//		
//		//scrollPane_1.setViewportView(panel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 853, 763);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 10, 853, 266);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_2.add(lblNewLabel_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/HDTHDM.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 276, 853, 452);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_2.add(lblNewLabel_2);
		Image img = new ImageIcon(this.getClass().getResource("/THD.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 730, 853, 266);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_2.add(lblNewLabel_3);
		Image img2 = new ImageIcon(this.getClass().getResource("/HDLT.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 1000, 853, 452);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_2.add(lblNewLabel_4);
		Image img3 = new ImageIcon(this.getClass().getResource("/HD1.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		
		JTextArea jta1= new JTextArea("a.	Tạo mới hóa đơn\r\n"
				+ "Bước 1: Nhân viên nhập số điện thoại khách hàng và nhần tìm kiếm, khi tìm thấy số điện thoại khách hàng thông tin khách hàng sẻ được điền vào\r\n"
				+ "Bước 2: Nhân viên nhập mã sản phẩm vào và nhấn tìm kiếm nếu tìm thấy thì tên sản phẩm và giá sẻ được đưa vào\r\n"
				+ "Bước 3: Sau khi đã tìm thấy mã sản phẩm thì điền số lượng khách hàng mua vào \r\n"
				+ "Bước 4: Sau đó nhấn nút thêm sản phẩm sản phẩm sẻ được đưa vào giỏ hàng, nếu muốn them sản phẩm tiếp thì thược hiện lại từ bước 2 xuống\r\n"
				+ "Bước 5: Nhập số tiên khách hàng đưa, tiền khách hàng đưa phải lớn hơn tông tiền \r\n"
				+ "Bước 6: Nhấn nút thanh toán và chọn có in hóa đơn hay không\r\n"
				+ "");
		JLabel lb = new JLabel("a.	Tạo mới hóa đơn\r\n"
				+ "Bước 1: Nhân viên nhập số điện thoại khách hàng và nhần tìm kiếm, khi tìm thấy số điện thoại khách hàng thông tin khách hàng sẻ được điền vào\r\n"
				+ "Bước 2: Nhân viên nhập mã sản phẩm vào và nhấn tìm kiếm nếu tìm thấy thì tên sản phẩm và giá sẻ được đưa vào\r\n"
				+ "Bước 3: Sau khi đã tìm thấy mã sản phẩm thì điền số lượng khách hàng mua vào \r\n"
				+ "Bước 4: Sau đó nhấn nút thêm sản phẩm sản phẩm sẻ được đưa vào giỏ hàng, nếu muốn them sản phẩm tiếp thì thược hiện lại từ bước 2 xuống\r\n"
				+ "Bước 5: Nhập số tiên khách hàng đưa, tiền khách hàng đưa phải lớn hơn tông tiền \r\n"
				+ "Bước 6: Nhấn nút thanh toán và chọn có in hóa đơn hay không\r\n"
				+ "");
		//jta1.setBounds(10, 1455, 853, 452);
		//jta1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//panel_2.add(jta1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		//scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 0, 873, 763);
		//panel_1.add(scrollPane_1);
		//scrollPane_1.setViewportView(panel_2);

		// hóa đơn bán
		JPanel panel_HDB = new JPanel();
		panel_HDB.setBounds(290, 0, 873, 763);
		panel.add(panel_HDB);
		panel_HDB.setLayout(null);
		panel_2.setBackground(Color.white);
		//JLabel l = new JLabel("sai r em ơi");
		//l.setBounds(412, 5, 49, 13);
		//panel_HDB.add(l);
		
		panel_HDB.add(scrollPane_1);
		scrollPane_1.setViewportView(panel_2);

		// ds hóa đơn bán
		JPanel panel_DSHD = new JPanel();
		panel_DSHD.setBounds(290, 0, 873, 763);
		panel.add(panel_DSHD);
		panel_DSHD.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 853, 763);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		add(panel_3);
		panel_3.setBackground(Color.white);
		
		JLabel lblDSHD = new JLabel("");
		lblDSHD.setBounds(10, 10, 853, 266);
		lblDSHD.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_3.add(lblDSHD);
		Image imgDSHD = new ImageIcon(this.getClass().getResource("/DSHD1.png")).getImage();
		lblDSHD.setIcon(new ImageIcon(imgDSHD));
		
		JLabel lblHDDSHD = new JLabel("");
		lblHDDSHD.setBounds(10, 276, 853, 452);
		lblHDDSHD.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_3.add(lblHDDSHD);
		Image imgHDSSHD = new ImageIcon(this.getClass().getResource("/HDDSHD.png")).getImage();
		lblHDDSHD.setIcon(new ImageIcon(imgHDSSHD));
		
		JScrollPane scrollPane_DSHD = new JScrollPane();
		scrollPane_DSHD.setBounds(0, 0, 873, 763);
		
		panel_DSHD.add(scrollPane_DSHD);
		scrollPane_DSHD.setViewportView(panel_3);

		// quản lý khách hàng
		JPanel panel_QLKH = new JPanel();
		panel_QLKH.setBounds(290, 0, 873, 763);
		panel.add(panel_QLKH);
		panel_QLKH.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 853, 763);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		add(panel_4);
		panel_4.setBackground(Color.white);
		
		JLabel lblKH = new JLabel("");
		lblKH.setBounds(10, 10, 853, 266);
		lblKH.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_4.add(lblKH);
		Image imgKH = new ImageIcon(this.getClass().getResource("/KH.png")).getImage();
		lblKH.setIcon(new ImageIcon(imgKH));
		
		JLabel lblHDKH = new JLabel("");
		lblHDKH.setBounds(10, 276, 853, 452);
		lblHDKH.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_4.add(lblHDKH);
		Image imgHDKH = new ImageIcon(this.getClass().getResource("/HDKH.png")).getImage();
		lblHDKH.setIcon(new ImageIcon(imgHDKH));
		
		JScrollPane scrollPane_DSKH = new JScrollPane();
		scrollPane_DSKH.setBounds(0, 0, 873, 763);
		
		panel_QLKH.add(scrollPane_DSKH);
		scrollPane_DSKH.setViewportView(panel_4);

		// quản lý nhân viên
		JPanel panel_NV = new JPanel();
		panel_NV.setBounds(290, 0, 873, 763);
		panel.add(panel_NV);
		panel_NV.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 853, 763);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		add(panel_5);
		panel_5.setBackground(Color.white);
		
		JLabel lblNV = new JLabel("");
		lblNV.setBounds(10, 10, 853, 266);
		lblNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_5.add(lblNV);
		Image imgNV = new ImageIcon(this.getClass().getResource("/NV.png")).getImage();
		lblNV.setIcon(new ImageIcon(imgNV));
		
		JLabel lblHDNV = new JLabel("");
		lblHDNV.setBounds(10, 276, 853, 452);
		lblHDNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_5.add(lblHDNV);
		Image imgHDNV = new ImageIcon(this.getClass().getResource("/HDNV1.png")).getImage();
		lblHDNV.setIcon(new ImageIcon(imgHDNV));
		
		JLabel lblHDNV2 = new JLabel("");
		lblHDNV2.setBounds(10, 730, 853, 452);
		lblHDNV2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_5.add(lblHDNV2);
		Image imgHDNV2 = new ImageIcon(this.getClass().getResource("/HDNV2.png")).getImage();
		lblHDNV2.setIcon(new ImageIcon(imgHDNV2));
		
		JScrollPane scrollPane_DSNV = new JScrollPane();
		scrollPane_DSNV.setBounds(0, 0, 873, 763);
		
		panel_NV.add(scrollPane_DSNV);
		scrollPane_DSNV.setViewportView(panel_5);

		//quản lý tài khoản
		JPanel panel_TaiKhoan = new JPanel();
		panel_TaiKhoan .setBounds(290, 0, 873, 763);
		panel.add(panel_TaiKhoan);
		panel_TaiKhoan.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 853, 763);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		add(panel_6);
		panel_6.setBackground(Color.white);
		
		JLabel lblTaiK = new JLabel("");
		lblTaiK.setBounds(10, 10, 853, 266);
		lblTaiK.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_6.add(lblTaiK);
		Image imgTaiK = new ImageIcon(this.getClass().getResource("/TaiK.png")).getImage();
		lblTaiK.setIcon(new ImageIcon(imgTaiK));
		
		JLabel lblHDTaiK = new JLabel("");
		lblHDTaiK.setBounds(10, 276, 853, 452);
		lblHDTaiK.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_6.add(lblHDTaiK);
		Image imgHDTaiK = new ImageIcon(this.getClass().getResource("/HDTaiK1.png")).getImage();
		lblHDTaiK.setIcon(new ImageIcon(imgHDTaiK));
		
		JLabel lblHDTaiK2 = new JLabel("");
		lblHDTaiK2.setBounds(10, 730, 853, 452);
		lblHDTaiK2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_6.add(lblHDTaiK2);
		Image imgHDTaiK2 = new ImageIcon(this.getClass().getResource("/HDTaiK2.png")).getImage();
		lblHDTaiK2.setIcon(new ImageIcon(imgHDTaiK2));
		
		JScrollPane scrollPane_DSTaiK = new JScrollPane();
		scrollPane_DSTaiK.setBounds(0, 0, 873, 763);
		
		panel_TaiKhoan.add(scrollPane_DSTaiK);
		scrollPane_DSTaiK.setViewportView(panel_6);

		//quản lý Sách
		JPanel panel_S = new JPanel();
		panel_S.setBounds(290, 0, 873, 763);
		panel.add(panel_S);
		panel_S.setLayout(null);
		
		
		Image imgS = new ImageIcon(this.getClass().getResource("/S.png")).getImage();
		Image imgHDS = new ImageIcon(this.getClass().getResource("/HDS.png")).getImage();
		Image imgS2 = new ImageIcon(this.getClass().getResource("")).getImage();
		vietHuongDan(imgS, imgHDS, imgS2,panel_S);
		
		
		//quản lý văn phòng phẩm
		JPanel panel_VPP = new JPanel();
		panel_VPP.setBounds(290, 0, 873, 763);
		panel.add(panel_VPP);
		panel_VPP.setLayout(null);
		
		Image imgVPP = new ImageIcon(this.getClass().getResource("/VPP.png")).getImage();
		Image imgHDVPP = new ImageIcon(this.getClass().getResource("/HDVPP.png")).getImage();
		Image imgVPP1 = new ImageIcon(this.getClass().getResource("")).getImage();
		vietHuongDan(imgVPP, imgHDVPP, imgVPP1,panel_VPP);
		
		
		//quản lý ke hang
		JPanel panel_keHang = new JPanel();
		panel_keHang.setBounds(290, 0, 873, 763);
		panel.add(panel_keHang);
		panel_keHang.setLayout(null);
		
		Image imgKeH = new ImageIcon(this.getClass().getResource("/KeHang.png")).getImage();
		Image imgHDKeH = new ImageIcon(this.getClass().getResource("/HDKeHang.png")).getImage();
		Image imgHDKeH1 = new ImageIcon(this.getClass().getResource("")).getImage();
		vietHuongDan(imgKeH, imgHDKeH, imgHDKeH1,panel_keHang);
		
		//quản lý danh muc
		JPanel panel_dm = new JPanel();
		panel_dm.setBounds(290, 0, 873, 763);
		panel.add(panel_dm);
		panel_dm.setLayout(null);
		
		Image imgdm = new ImageIcon(this.getClass().getResource("/DM.png")).getImage();
		Image imgHDdm = new ImageIcon(this.getClass().getResource("/HDDM.png")).getImage();
		Image imgHDdm1 = new ImageIcon(this.getClass().getResource("")).getImage();
		vietHuongDan(imgdm, imgHDdm, imgHDdm1,panel_dm);
		
		//quản lý ncc
		JPanel panel_ncc = new JPanel();
		panel_ncc.setBounds(290, 0, 873, 763);
		panel.add(panel_ncc);
		panel_ncc.setLayout(null);
		
		Image imgNCC = new ImageIcon(this.getClass().getResource("/NCC.png")).getImage();
		Image imgHDNCC1 = new ImageIcon(this.getClass().getResource("/HDNCC1.png")).getImage();
		Image imgHDNCC2 = new ImageIcon(this.getClass().getResource("/HDNCC2.png")).getImage();
		vietHuongDan(imgNCC, imgHDNCC1, imgHDNCC2,panel_ncc);
		
		//quản lý km
		JPanel panel_km = new JPanel();
		panel_km.setBounds(290, 0, 873, 763);
		panel.add(panel_km);
		panel_km.setLayout(null);
		
		Image imgkm = new ImageIcon(this.getClass().getResource("/KM.png")).getImage();
		Image imgHDkm1 = new ImageIcon(this.getClass().getResource("/HDKM1.png")).getImage();
		Image imgHDkm2 = new ImageIcon(this.getClass().getResource("/HDKM2.png")).getImage();
		vietHuongDan(imgkm, imgHDkm1, imgHDkm2,panel_km);
		
		//quản lý tk
		JPanel panel_tk = new JPanel();
		panel_tk.setBounds(290, 0, 873, 763);
		panel.add(panel_tk);
		panel_tk.setLayout(null);
		
		
		
		//quản lý dmk
		JPanel panel_dmk = new JPanel();
		panel_dmk.setBounds(290, 0, 873, 763);
		panel.add(panel_dmk);
		panel_dmk.setLayout(null);
		
		Image imgdmk = new ImageIcon(this.getClass().getResource("/DKM.png")).getImage();
		Image imgHDdmk = new ImageIcon(this.getClass().getResource("/HDDMK.png")).getImage();
		Image imgDMK1 = new ImageIcon(this.getClass().getResource("")).getImage();
		vietHuongDan(imgdmk, imgHDdmk, imgDMK1,panel_dmk);
		
//		//quản lý qmk
//		JPanel panel_qmk = new JPanel();
//		panel_qmk.setBounds(290, 0, 873, 763);
//		panel.add(panel_qmk);
//		panel_qmk.setLayout(null);


		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Hướng dẫn sử dụng");

		DefaultMutableTreeNode QLHD = new DefaultMutableTreeNode("Quản lý hóa đơn");
		DefaultMutableTreeNode HDB = new DefaultMutableTreeNode("Hóa đơn bán");
		DefaultMutableTreeNode DSHD = new DefaultMutableTreeNode("Danh sách hóa đơn");

		DefaultMutableTreeNode QLKH = new DefaultMutableTreeNode("Quản lý khách hàng");

		DefaultMutableTreeNode QLNV = new DefaultMutableTreeNode("Quản lý nhân viên");
		DefaultMutableTreeNode NV = new DefaultMutableTreeNode("Nhân viên");
		DefaultMutableTreeNode taiKhoan = new DefaultMutableTreeNode("Tài khoản");

		DefaultMutableTreeNode QLSP = new DefaultMutableTreeNode("Quản lý sản phẩn");
		DefaultMutableTreeNode S = new DefaultMutableTreeNode("Sách");
		DefaultMutableTreeNode VPP = new DefaultMutableTreeNode("Văn phòng phẩm");
		DefaultMutableTreeNode KH = new DefaultMutableTreeNode("Kệ hàng");
		DefaultMutableTreeNode DM = new DefaultMutableTreeNode("Danh mục");

		DefaultMutableTreeNode QLNCC = new DefaultMutableTreeNode("Quản lý nhà cung cấp");
		DefaultMutableTreeNode QLKM = new DefaultMutableTreeNode("Quản lý khuyến mãi");
		DefaultMutableTreeNode TK = new DefaultMutableTreeNode("Thống kê");
		DefaultMutableTreeNode DMK = new DefaultMutableTreeNode("Đổi mật khẩu");
		//DefaultMutableTreeNode QMK = new DefaultMutableTreeNode("Quên mật khẩu");


		QLHD.add(HDB);
		QLHD.add(DSHD);

		QLNV.add(NV);
		QLNV.add(taiKhoan);

		QLSP.add(S);
		QLSP.add(VPP);
		QLSP.add(KH);
		QLSP.add(DM);

		rootNode.add(QLHD);
		rootNode.add(QLKH);
		rootNode.add(QLNV);
		rootNode.add(QLSP);
		rootNode.add(QLNCC);
		rootNode.add(QLKM);
		rootNode.add(TK);
		rootNode.add(DMK);
		//rootNode.add(QMK);

		JTree tree = new JTree(rootNode);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultMutableTreeNode courses = new DefaultMutableTreeNode();
				TreePath selectionPath = tree.getSelectionPath();
				//courses = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
				if(selectionPath != null) {
					courses = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
					String select = courses.getUserObject().toString();
					if(select.equals("Hóa đơn bán")){
						panel_1.setVisible(false);
						panel_HDB.setVisible(true);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
						
					}
					else if(select.equals("Danh sách hóa đơn")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(true);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Quản lý khách hàng")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(true);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Nhân viên")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(true);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Tài khoản")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(true);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Sách")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(true);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Văn phòng phẩm")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(true);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Kệ hàng")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(true);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Danh mục")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(true);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Quản lý nhà cung cấp")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(true);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Quản lý khuyến mãi")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(true);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Thống kê")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(true);
						panel_dmk.setVisible(false);
						//panel_qmk.setVisible(false);
					}
					else if(select.equals("Đổi mật khẩu")) {
						panel_1.setVisible(false);
						panel_HDB.setVisible(false);
						panel_DSHD.setVisible(false);
						panel_QLKH.setVisible(false);
						panel_NV.setVisible(false);
						panel_TaiKhoan.setVisible(false);
						panel_S.setVisible(false);
						panel_VPP.setVisible(false);
						panel_keHang.setVisible(false);
						panel_dm.setVisible(false);
						panel_ncc.setVisible(false);
						panel_km.setVisible(false);
						panel_tk.setVisible(false);
						panel_dmk.setVisible(true);
						//panel_qmk.setVisible(false);
					}
//					else if(select.equals("Quên mật khẩu")) {
//						panel_1.setVisible(false);
//						panel_HDB.setVisible(false);
//						panel_DSHD.setVisible(false);
//						panel_QLKH.setVisible(false);
//						panel_NV.setVisible(false);
//						panel_TaiKhoan.setVisible(false);
//						panel_S.setVisible(false);
//						panel_VPP.setVisible(false);
//						panel_keHang.setVisible(false);
//						panel_dm.setVisible(false);
//						panel_ncc.setVisible(false);
//						panel_km.setVisible(false);
//						panel_tk.setVisible(false);
//						panel_dmk.setVisible(false);
//						//panel_qmk.setVisible(true);
//					}
				}else {
					return;
				}
				
			}
		});
		tree.setVisibleRowCount(50);
		tree.setFont(new Font("Arial", Font.BOLD, 20));
		scrollPane.setViewportView(tree);
		
		

		//		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		//        URL folderIconUrl = pnlTroGiup.class.getResource("/c032.png"); // Đường dẫn đến icon folder
		//        if (folderIconUrl != null) {
		//            ImageIcon folderIcon = new ImageIcon(folderIconUrl);
		//            renderer.setClosedIcon(folderIcon);
		//            renderer.setOpenIcon(folderIcon);
		//        }
		//
		//        tree.setCellRenderer(renderer);


	}
	
	void vietHuongDan(Image img1,Image img2,Image img3, JPanel pnl ) {
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 853, 763);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		add(panel_8);
		
		JLabel lbl8 = new JLabel("");
		lbl8.setBounds(10, 10, 853, 266);
		lbl8.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_8.add(lbl8);
		//Image imgS = new ImageIcon(this.getClass().getResource("/DSHD1.png")).getImage();
		lbl8.setIcon(new ImageIcon(img1));
		
		JLabel lblHD8 = new JLabel("");
		lblHD8.setBounds(10, 276, 853, 452);
		lblHD8.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_8.add(lblHD8);
		//Image imgHD8 = new ImageIcon(this.getClass().getResource("/HDDSHD.png")).getImage();
		lblHD8.setIcon(new ImageIcon(img2));
		
		JLabel lblHD82 = new JLabel("");
		lblHD82.setBounds(10, 730, 853, 452);
		lblHD82.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_8.add(lblHD82);
		//Image imgHD8 = new ImageIcon(this.getClass().getResource("/HDDSHD.png")).getImage();
		lblHD82.setIcon(new ImageIcon(img3));
		
		JScrollPane scrollPane_DS8 = new JScrollPane();
		scrollPane_DS8.setBounds(0, 0, 873, 763);
		
		pnl.add(scrollPane_DS8);
		panel_8.setBackground(Color.white);
		scrollPane_DS8.setViewportView(panel_8);
	}
}
