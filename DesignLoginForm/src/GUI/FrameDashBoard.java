package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class FrameDashBoard extends JFrame {

	private JPanel contentPane;
	
	private pnlHoadon pnlHoaDon;
	private pnlNhanVien pnlNhanvien;
	private pnlKhachHang pnlKhachhang;
	private pnlSanPham pnlSanPham;
	private pnlQLThongKe pnlThongKe;
	private pnlTroGiup pnlHelp;
	private pnlNhaCungCap pnlNCC;
	private pnlKhuyenMai pnlKhuyenMai;
	private JTextField txtTenNV_DN;
	private pnlManHinhChinh pnlManHinhChinh;
	
	Color DefaultColor = new Color(230, 230, 250);
	Color ClickColor = new Color(60, 179, 113);
	private JTextField txtChucVu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashBoard frame = new FrameDashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameDashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		//setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//chuyển màn hình
		pnlHoaDon = new pnlHoadon();
		pnlHoaDon.setBounds(0, 0, 1166, 763);
		pnlKhachhang = new pnlKhachHang();
		pnlSanPham = new pnlSanPham();
		pnlNhanvien = new pnlNhanVien();
		pnlThongKe = new pnlQLThongKe();
		pnlHelp = new pnlTroGiup();
		pnlNCC = new pnlNhaCungCap();
		pnlKhuyenMai = new pnlKhuyenMai();
		pnlManHinhChinh = new pnlManHinhChinh();
		

		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(224, 255, 255));
		pnlMenu.setBounds(0, 0, 323, 763);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlMenu.add(lblIconLogo);
		lblIconLogo.setBounds(0, 0, 101, 72);
		Image img = new ImageIcon(this.getClass().getResource("/logo_s.png")).getImage();
		lblIconLogo.setIcon(new ImageIcon(img));

		JPanel pnlQLHoaDon = new JPanel();
		pnlQLHoaDon.addMouseListener(new PanelbtnMouseAdapter(pnlQLHoaDon) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlHoaDon);
			}
		});
		pnlQLHoaDon.setBackground(new Color(230, 230, 250));
		pnlQLHoaDon.setBounds(10, 145, 300, 60);
		pnlMenu.add(pnlQLHoaDon);
		pnlQLHoaDon.setLayout(null);

		// quản lý hóa đơn
		JLabel lblOrder = new JLabel("Quản lý hóa đơn");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setFont(new Font("Arial", Font.BOLD, 20));
		lblOrder.setBounds(80, 5, 181, 50);
		pnlQLHoaDon.add(lblOrder);

		JLabel lblIconOrder = new JLabel("");
		lblIconOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconOrder.setBounds(10, 5, 50, 50);
		pnlQLHoaDon.add(lblIconOrder);
		Image img_iconHoaDon = new ImageIcon(this.getClass().getResource("/order_icon_s.png")).getImage();
		lblIconOrder.setIcon(new ImageIcon(img_iconHoaDon));

		// quản lý khách hàng
		JPanel pnlQLKhachHang = new JPanel();

		pnlQLKhachHang.addMouseListener(new PanelbtnMouseAdapter(pnlQLKhachHang) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlKhachhang);
			}
		});
		pnlQLKhachHang.setBackground(new Color(230, 230, 250));
		pnlQLKhachHang.setBounds(10, 210, 300, 60);
		pnlMenu.add(pnlQLKhachHang);
		pnlQLKhachHang.setLayout(null);

		JLabel lblCustomer = new JLabel("Quản lý khách hàng");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Arial", Font.BOLD, 20));
		lblCustomer.setBounds(80, 5, 200, 50);
		pnlQLKhachHang.add(lblCustomer);

		JLabel lblIcon_customers = new JLabel("");
		lblIcon_customers.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon_customers.setBounds(10, 5, 50, 50);
		pnlQLKhachHang.add(lblIcon_customers);
		Image img_iconCustomer = new ImageIcon(this.getClass().getResource("/icon_customers_s.png")).getImage();
		lblIcon_customers.setIcon(new ImageIcon(img_iconCustomer));

		// menu employee
		JPanel pnlQLNhanVien = new JPanel();
		pnlQLNhanVien.addMouseListener(new PanelbtnMouseAdapter(pnlQLNhanVien) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlNhanvien);
			}
		});
		pnlQLNhanVien.setBackground(new Color(230, 230, 250));
		pnlQLNhanVien.setBounds(10, 275, 300, 60);
		pnlMenu.add(pnlQLNhanVien);
		pnlQLNhanVien.setLayout(null);

		JLabel lblEmployee = new JLabel("Quản lý nhân viên");
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmployee.setBounds(80, 5, 200, 50);
		pnlQLNhanVien.add(lblEmployee);

		JLabel lblIconEmployee = new JLabel("");
		lblIconEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEmployee.setBounds(10, 5, 50, 50);
		pnlQLNhanVien.add(lblIconEmployee);
		Image img_iconEmployee = new ImageIcon(this.getClass().getResource("/icon_employee_s.png")).getImage();
		lblIconEmployee.setIcon(new ImageIcon(img_iconEmployee));

		// menu product
		JPanel pnlQLSanPham = new JPanel();
		pnlQLSanPham.addMouseListener(new PanelbtnMouseAdapter(pnlQLSanPham) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlSanPham);
			}
		});
		pnlQLSanPham.setBackground(new Color(230, 230, 250));
		pnlQLSanPham.setBounds(10, 340, 300, 60);
		pnlMenu.add(pnlQLSanPham);
		pnlQLSanPham.setLayout(null);

		JLabel lblProduct = new JLabel("Quản lý sản phẩm ");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("Arial", Font.BOLD, 20));
		lblProduct.setBounds(80, 5, 200, 50);
		pnlQLSanPham.add(lblProduct);

		JLabel lblIconProduct = new JLabel("");
		lblIconProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconProduct.setBounds(10, 5, 50, 50);
		pnlQLSanPham.add(lblIconProduct);
		Image img_iconProduct = new ImageIcon(this.getClass().getResource("/icon_book_s.png")).getImage();
		lblIconProduct.setIcon(new ImageIcon(img_iconProduct));

		// menu Thongke
		JPanel pnlQLThongKe = new JPanel();
		pnlQLThongKe.addMouseListener(new PanelbtnMouseAdapter(pnlQLThongKe) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlThongKe);
			}
		});
		pnlQLThongKe.setBackground(new Color(230, 230, 250));
		pnlQLThongKe.setBounds(10, 535, 300, 60);
		pnlMenu.add(pnlQLThongKe);
		pnlQLThongKe.setLayout(null);

		JLabel lblThongKe = new JLabel("Thống kê");
		lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKe.setBounds(91, 5, 133, 50);
		pnlQLThongKe.add(lblThongKe);
		lblThongKe.setFont(new Font("Arial", Font.BOLD, 20));

		JLabel lblIconThongKe = new JLabel("");
		lblIconThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconThongKe.setBounds(10, 5, 50, 50);
		pnlQLThongKe.add(lblIconThongKe);
		Image img_iconThongke = new ImageIcon(this.getClass().getResource("/icon_thongke_s.png")).getImage();
		lblIconThongKe.setIcon(new ImageIcon(img_iconThongke));

		// menu help
		JPanel pnlQLHelp = new JPanel();
		pnlQLHelp.addMouseListener(new PanelbtnMouseAdapter(pnlQLHelp) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlHelp);
			}
		});
		pnlQLHelp.setLayout(null);
		pnlQLHelp.setBackground(new Color(230, 230, 250));
		pnlQLHelp.setBounds(10, 600, 300, 60);
		pnlMenu.add(pnlQLHelp);

		JLabel lblHelp = new JLabel("Trợ giúp");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setFont(new Font("Arial", Font.BOLD, 20));
		lblHelp.setBounds(80, 5, 140, 50);
		pnlQLHelp.add(lblHelp);

		JLabel lblIconHelp = new JLabel("");
		lblIconHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHelp.setBounds(10, 5, 50, 50);
		pnlQLHelp.add(lblIconHelp);
		Image img_iconHelp = new ImageIcon(this.getClass().getResource("/icon_help_s.png")).getImage();
		lblIconHelp.setIcon(new ImageIcon(img_iconHelp));
		
		JPanel pnlHome = new JPanel();
		pnlHome.setLayout(null);
		pnlHome.setBackground(ClickColor);
		pnlHome.setBounds(10, 80, 300, 60);
		pnlMenu.add(pnlHome);
		
		JLabel lblHome = new JLabel("Trang chủ");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Arial", Font.BOLD, 20));
		lblHome.setBounds(80, 5, 150, 50);
		pnlHome.add(lblHome);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHome.setBounds(10, 5, 50, 50);
		pnlHome.add(lblIconHome);
		Image img_iconHome = new ImageIcon(this.getClass().getResource("/iconHome_s.png")).getImage();
		lblIconHome.setIcon(new ImageIcon(img_iconHome));
		
		JPanel pnlQLKhuyenMai = new JPanel();
		pnlQLKhuyenMai.setLayout(null);
		pnlQLKhuyenMai.setBackground(new Color(230, 230, 250));
		pnlQLKhuyenMai.setBounds(10, 470, 300, 60);
		pnlMenu.add(pnlQLKhuyenMai);
		
		JLabel lblKhuyenMai = new JLabel("Quản lý khuyến mãi");
		lblKhuyenMai.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhuyenMai.setFont(new Font("Arial", Font.BOLD, 20));
		lblKhuyenMai.setBounds(80, 5, 210, 50);
		pnlQLKhuyenMai.add(lblKhuyenMai);
		
		JLabel lblIconKhuyenMai = new JLabel("");
		lblIconKhuyenMai.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKhuyenMai.setBounds(10, 5, 50, 50);
		pnlQLKhuyenMai.add(lblIconKhuyenMai);
		Image img_iconSale = new ImageIcon(this.getClass().getResource("/icon_sale.png")).getImage();
		lblIconKhuyenMai.setIcon(new ImageIcon(img_iconSale));
		pnlQLKhuyenMai.addMouseListener(new PanelbtnMouseAdapter(pnlQLKhuyenMai) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlKhuyenMai);
			}
		});
		
		JPanel pnlQLNCC = new JPanel();
		pnlQLNCC.setLayout(null);
		pnlQLNCC.setBackground(new Color(230, 230, 250));
		pnlQLNCC.setBounds(10, 405, 300, 60);
		pnlMenu.add(pnlQLNCC);
		
		JLabel lblIconNCC = new JLabel("");
		lblIconNCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNCC.setBounds(10, 5, 50, 50);
		pnlQLNCC.add(lblIconNCC);
		
		Image img_iconNCC = new ImageIcon(this.getClass().getResource("/icon_workshop.png")).getImage();
		lblIconNCC.setIcon(new ImageIcon(img_iconNCC));
		pnlQLNCC.addMouseListener(new PanelbtnMouseAdapter(pnlQLNCC) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlNCC);
			}
		});
		
		JLabel lblNhaCC = new JLabel("Quản lý nhà cung cấp");
		lblNhaCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhaCC.setFont(new Font("Arial", Font.BOLD, 20));
		lblNhaCC.setBounds(80, 5, 210, 50);
		pnlQLNCC.add(lblNhaCC);
		
		
		JPanel pnlDangXuat = new JPanel();
		pnlDangXuat.setLayout(null);
		pnlDangXuat.setBackground(SystemColor.textHighlight);
		pnlDangXuat.setBounds(10, 665, 300, 95);
		pnlMenu.add(pnlDangXuat);
		
		txtTenNV_DN = new JTextField();
		txtTenNV_DN.setEnabled(false);
		txtTenNV_DN.setBounds(120, 5, 175, 25);
		pnlDangXuat.add(txtTenNV_DN);
		txtTenNV_DN.setColumns(10);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangXuat.setBounds(5, 60, 140, 30);
		pnlDangXuat.add(btnDangXuat);
		
		JButton btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiMatKhau.setBounds(155, 60, 140, 30);
		pnlDangXuat.add(btnDoiMatKhau);
		
		txtChucVu = new JTextField();
		txtChucVu.setEnabled(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(120, 33, 175, 25);
		pnlDangXuat.add(txtChucVu);
		
		JLabel lblChucVu = new JLabel("Tên nhân viên");
		lblChucVu.setForeground(Color.WHITE);
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChucVu.setBounds(5, 5, 110, 25);
		pnlDangXuat.add(lblChucVu);
		
		JLabel lblChucVu1 = new JLabel("Chức vụ");
		lblChucVu1.setForeground(Color.WHITE);
		lblChucVu1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChucVu1.setBounds(5, 33, 110, 25);
		pnlDangXuat.add(lblChucVu1);
		
		JLabel lblTenHieuSach = new JLabel("Thế giới sách");
		lblTenHieuSach.setForeground(Color.BLUE);
		lblTenHieuSach.setFont(new Font("Arial", Font.BOLD, 25));
		lblTenHieuSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenHieuSach.setBounds(111, 10, 186, 62);
		pnlMenu.add(lblTenHieuSach);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(323, 0, 1163, 763);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(ClickColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
			
		});
		pnlHome.addMouseListener(new PanelbtnMouseAdapter(pnlManHinhChinh) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlManHinhChinh);
			}
		});
		
		pnlQLHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(ClickColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
		});
		
		pnlQLKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(ClickColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
		});
		
		pnlQLNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(ClickColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
		});
		
		pnlQLSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(ClickColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
		});
		
		pnlQLKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(ClickColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
		});
		
		pnlQLNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(ClickColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
		});
		pnlQLThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(ClickColor);
				pnlQLHelp.setBackground(DefaultColor);
			}
		});
		
		pnlQLHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLNhanVien.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLKhuyenMai.setBackground(DefaultColor);
				pnlQLNCC.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
				pnlQLHelp.setBackground(ClickColor);
			}
		});
		
//		JLabel lblExit = new JLabel("X");
//		lblExit.setForeground(Color.WHITE);
//		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
//		lblExit.setFont(new Font("Arial", Font.BOLD, 16));
//		lblExit.setBounds(1460, 0, 30, 30);
//		lblExit.addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				if(JOptionPane.showConfirmDialog(null,"ban co chac muon thoat?","canh bao",JOptionPane.YES_NO_OPTION) == 0) {
//					FrameDashBoard.this.dispose();
//				}
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				lblExit.setForeground(Color.red);
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				lblExit.setForeground(Color.white);
//			}
//		});
//		contentPane.add(lblExit);
		
//		JPanel panelMainContent =  new JPanel();
//		panelMainContent.setBounds(324, 105, 1166, 685);
//		contentPane.add(panelMainContent);
//		panelMainContent.setLayout(null);
//		
		pnlMainContent.add(pnlHoaDon);
		pnlMainContent.add(pnlKhachhang);
		pnlMainContent.add(pnlNhanvien);
		pnlMainContent.add(pnlSanPham);
		pnlMainContent.add(pnlThongKe);
		pnlMainContent.add(pnlHelp);
		pnlMainContent.add(pnlNCC);
		pnlMainContent.add(pnlKhuyenMai);
		pnlMainContent.add(pnlManHinhChinh);
		

		menuClicked(pnlManHinhChinh);
		
//		JLabel lblTitle = new JLabel("Quản lý hiệu sách tư nhân");
//		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitle.setBounds(563, 21, 418, 47);
//		contentPane.add(lblTitle);
		 
		
	}
	
	// xử lý sự kiện chuyển màn hình
	public void menuClicked(JPanel panel) {
		pnlHoaDon.setVisible(false);
		pnlKhachhang.setVisible(false);
		pnlNhanvien.setVisible(false);
		pnlSanPham.setVisible(false);
		pnlThongKe.setVisible(false);
		pnlHelp.setVisible(false);
		pnlKhuyenMai.setVisible(false);
		pnlNCC.setVisible(false);
		pnlManHinhChinh.setVisible(false);
		
		panel.setVisible(true);
	}
	
	
	// xử lý sự kiện nhấp chuột 
	private class PanelbtnMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelbtnMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		/*Phương thức này được gọi khi con trỏ chuột vào 
		 đối tượng JPanel mà đối tượng PanelbtnMouseAdapter được gắn vào
		 * */
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			panel.setBackground(new Color(176, 196, 222));
//		}
//
//		/*Phương thức này được gọi khi con trỏ chuột rời khỏi đối tượng JPanel
//		 * */
//		@Override
//		public void mouseExited(MouseEvent e) {
//			panel.setBackground(new Color(230, 230, 250));
//		}
//
//		 /*Phương thức này được gọi khi người 
//		  * dùng nhấn chuột lên đối tượng JPanel*/
//		@Override
//		public void mousePressed(MouseEvent e) {
//			panel.setBackground(new Color(60, 179, 113));
//		}
//
//		
//		/*
//		 * Phương thức này được gọi khi người dùng thả chuột sau khi đã nhấn*/
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			panel.setBackground(new Color(230, 230, 250));
//		}

	}
}
