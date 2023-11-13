package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import crypto.AESCrypto;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class FrameDashBoardNVBH extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private pnlHoadon pnlHoaDon;
	private pnlKhachHang pnlKhachhang;
	private pnlSanPham pnlSanPham;
	private pnlThongKeNV pnlThongKeNV;
	private pnlTroGiup pnlHelp;
	private JTextField txtTenNV_DN;
	private pnlManHinhChinh pnlManHinhChinh;
	
	Color DefaultColor = new Color(230, 230, 250);
	Color ClickColor = new Color(60, 179, 113);
	private JTextField txtChucVu;
	public static TaiKhoan taiKhoanLogin;
	private JButton btnDangXuat, btnDoiMatKhau;
	private Dao_TaiKhoan taiKhoan_dao = new Dao_TaiKhoan();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashBoard frame = new FrameDashBoard(taiKhoanLogin);
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
	public FrameDashBoardNVBH(TaiKhoan tk) {
		taiKhoanLogin = tk;
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
		pnlThongKeNV = new pnlThongKeNV();
		pnlHelp = new pnlTroGiup();
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


		// menu product
		JPanel pnlQLSanPham = new JPanel();
		pnlQLSanPham.addMouseListener(new PanelbtnMouseAdapter(pnlQLSanPham) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(pnlSanPham);
			}
		});
		pnlQLSanPham.setBackground(new Color(230, 230, 250));
		pnlQLSanPham.setBounds(10, 280, 300, 60);
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
						menuClicked(pnlThongKeNV);
					}
				});
				pnlQLThongKe.setBackground(new Color(230, 230, 250));
				pnlQLThongKe.setBounds(10, 350, 300, 60);
				pnlMenu.add(pnlQLThongKe);
				pnlQLThongKe.setLayout(null);

				JLabel lblThongKe = new JLabel("Thống kê doanh thu");
				lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
				lblThongKe.setBounds(70, 5, 220, 50);
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
		pnlQLHelp.setBounds(10, 420, 300, 60);
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
		
		
//		Check nhân viên login
		Dao_NhanVien nhanVien_dao = new Dao_NhanVien();
		NhanVien nvLogin = taiKhoanLogin.getNhanVien();
		NhanVien findNVLogin = nhanVien_dao.getTheoMaNV(nvLogin.getMaNhanVien());
	
		JPanel pnlDangXuat = new JPanel();
		pnlDangXuat.setLayout(null);
		pnlDangXuat.setBackground(SystemColor.textHighlight);
		pnlDangXuat.setBounds(10, 665, 300, 95);
		pnlMenu.add(pnlDangXuat);
		
		txtTenNV_DN = new JTextField();
		txtTenNV_DN.setFont(new Font("Arial", Font.BOLD, 14));
		txtTenNV_DN.setEnabled(false);
		txtTenNV_DN.setBounds(120, 5, 175, 25);
		pnlDangXuat.add(txtTenNV_DN);
		txtTenNV_DN.setColumns(10);
		txtTenNV_DN.setText(findNVLogin.getHoTenNhanVien());
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangXuat.setBounds(5, 60, 140, 30);
		pnlDangXuat.add(btnDangXuat);
		
		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiMatKhau.setBounds(155, 60, 140, 30);
		pnlDangXuat.add(btnDoiMatKhau);
		
		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Arial", Font.BOLD, 14));
		txtChucVu.setEnabled(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(120, 33, 175, 25);
		pnlDangXuat.add(txtChucVu);
		txtChucVu.setText(findNVLogin.getChucVu());
		
		
		
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
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
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
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
			}
		});
		
		pnlQLKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(ClickColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
			}
		});
		
		
		pnlQLSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(ClickColor);
				pnlQLHelp.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(DefaultColor);
			}
		});
		
		
		
		pnlQLHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLHelp.setBackground(ClickColor);
				pnlQLThongKe.setBackground(DefaultColor);
			}
		});
		
		pnlQLThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHome.setBackground(DefaultColor);
				pnlQLHoaDon.setBackground(DefaultColor);
				pnlQLKhachHang.setBackground(DefaultColor);
				pnlQLSanPham.setBackground(DefaultColor);
				pnlQLHelp.setBackground(DefaultColor);
				pnlQLThongKe.setBackground(ClickColor);
			}
		});
		
	
		pnlMainContent.add(pnlHoaDon);
		pnlMainContent.add(pnlKhachhang);
		pnlMainContent.add(pnlSanPham);
		pnlMainContent.add(pnlHelp);
		pnlMainContent.add(pnlManHinhChinh);
		pnlMainContent.add(pnlThongKeNV);
		

		menuClicked(pnlManHinhChinh);
		
		btnDangXuat.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		
		
	}
	
	// xử lý sự kiện chuyển màn hình
	public void menuClicked(JPanel panel) {
		pnlHoaDon.setVisible(false);
		pnlKhachhang.setVisible(false);
		pnlSanPham.setVisible(false);
		pnlHelp.setVisible(false);
		pnlManHinhChinh.setVisible(false);
		pnlThongKeNV.setVisible(false);
		
		panel.setVisible(true);
	}
	
	
	// xử lý sự kiện nhấp chuột 
	private class PanelbtnMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelbtnMouseAdapter(JPanel panel) {
			this.panel = panel;
		}


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDangXuat)) {
			if (JOptionPane.showConfirmDialog(this, "Đăng xuất?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				setVisible(false);
				new FrameLogin().setVisible(true);
			}
		}
		if (o.equals(btnDoiMatKhau)) {
			String matKhauCu = JOptionPane.showInputDialog("Nhập mật khẩu hiện tại");
			try {
				if (matKhauCu.equals(AESCrypto.decrypt(taiKhoanLogin.getMatKhau()))) {
					String matKhauMoi = JOptionPane.showInputDialog("Nhập mật khẩu mới");
					if (JOptionPane.showConfirmDialog(this, "Bạn muốn đổi mật khẩu mới", "Thông báo",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						TaiKhoan tkMoi = new TaiKhoan(taiKhoanLogin.getMaTaiKhoan(),AESCrypto.encrypt(matKhauMoi),taiKhoanLogin.getTenTaiKhoan(), taiKhoanLogin.getNhanVien());
						taiKhoan_dao.capNhat(tkMoi);
					} else {
						JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Sai mật khẩu!!!");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
	}
}
