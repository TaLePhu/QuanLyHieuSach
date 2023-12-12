package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import com.toedter.calendar.JDateChooser;

import crypto.AESCrypto;
import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.VerificationCode;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class FrameLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, VerificationCode> verificationCodes = new HashMap<>();
    private Dao_TaiKhoan taiKhoan_dao = new Dao_TaiKhoan();
    private Dao_NhanVien nhanVien_dao = new Dao_NhanVien();
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 600, 400);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 586, 363);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Thế giới sách");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel_1.setBounds(0, -1, 275, 101);
		panel.add(lblNewLabel_1);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Tên đăng nhập:");
		jLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		jLabel1.setBounds(56, 122, 119, 29);
		panel.add(jLabel1);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setBounds(207, 122, 343, 29);
		txtTenDangNhap.setText("Admin");
		panel.add(txtTenDangNhap);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Mật khẩu:");
		jLabel2.setFont(new Font("Arial", Font.BOLD, 16));
		jLabel2.setBounds(56, 189, 119, 28);
		panel.add(jLabel2);
		
		JButton btnForgotPassword = new JButton();
		btnForgotPassword.setText("Quên mật khẩu?");
		btnForgotPassword.setFont(new Font("Arial", Font.BOLD, 16));
		btnForgotPassword.setBorder(null);
		btnForgotPassword.setBounds(425, 232, 125, 28);
		panel.add(btnForgotPassword);
		btnForgotPassword.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                sendVerificationCode();
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    });
		
		JButton btnLogin = new JButton();
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
                     checkLogin();
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }    
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setText("Đăng nhập");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(new Color(0, 0, 128));
		btnLogin.setBounds(190, 278, 184, 41);
		panel.add(btnLogin);
		
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(207, 186, 343, 29);
		txtMatKhau.setBackground(new Color(255, 255, 255));
		txtMatKhau.setBounds(207, 189, 343, 26);
		panel.add(txtMatKhau);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, -1, 586, 364);
		panel.add(bg);
		Image img_iconUpdate = new ImageIcon(this.getClass().getResource("/BGLogin2.png")).getImage();
		bg.setIcon(new ImageIcon(img_iconUpdate));
		
		txtTenDangNhap.setText("NV101");
		txtMatKhau.setText("MatKhau123");
	}
	
	private boolean checkLogin() throws Exception {
		ArrayList<TaiKhoan> dsTK = taiKhoan_dao.getAllTaiKhoan();

		String user = txtTenDangNhap.getText().trim();
		String pass =AESCrypto.encrypt(txtMatKhau.getText().trim());
		StringBuilder sb = new StringBuilder();
		if (user.equals("")) {
			sb.append("Vui lòng nhập tên đăng nhập!!!\n");
		}
		if (pass.equals("")) {
			sb.append("Vui lòng nhập mật khẩu!!! \n");
		}
		if (sb.length() > 0) {
			JOptionPane.showMessageDialog(this, sb.toString(), "Cảnh báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		for (TaiKhoan tk : dsTK) {
			if (user.equals(tk.getTenTaiKhoan())) {
				if (pass.equals(tk.getMatKhau())) {
					NhanVien nv = tk.getNhanVien();
					NhanVien findNV = nhanVien_dao.getTheoMaNV(nv.getMaNhanVien());
					if(findNV.getTinhTrang().equals("Tạm ngưng")) {
						JOptionPane.showMessageDialog(this, "Bạn đang ở tình trạng tạm ngưng làm việc không có quyền truy cập vào ứng dụng", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
						return false;
					}else {
						if(findNV.getChucVu().equals("Nhân viên quản lý")) {
							setVisible(false);
							FrameDashBoard dashboard = new FrameDashBoard(tk);
					          dashboard.setVisible(true);
					          setVisible(false);
					          return true;
						}else {
							setVisible(false);
							FrameDashBoardNVBH dashboardBH = new FrameDashBoardNVBH(tk);
					          dashboardBH.setVisible(true);
					          setVisible(false);
					          return true;
						}
					}
					
				} else {
					JOptionPane.showMessageDialog(this, "Nhập sai mật khẩu", "Nhập lại", JOptionPane.ERROR_MESSAGE);
					txtMatKhau.requestFocus();
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(this, "Nhập sai thông tin", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
		txtTenDangNhap.requestFocus();
		return false;
	}
	
	private void sendVerificationCode() {
	    String userEmail = JOptionPane.showInputDialog(this, "Nhập email của bạn:");

	    if (userEmail != null) {
	        try {
	            String verificationCode = generateVerificationCode();
	            
	         // Store the verification code and associated VerificationCode object in the map
	            VerificationCode codeObject = new VerificationCode(verificationCode);
	            verificationCodes.put(userEmail, codeObject);

	            // Send email with verification code
	            EmailSender.sendVerificationEmail(userEmail, verificationCode);
	            System.out.println(verificationCode);

	            // Prompt user to enter the verification code
	            String enteredCode = JOptionPane.showInputDialog(this, "Kiểm tra email của bạn để lấy mã đăng nhập:");

	            // Verify the entered code
	            if (verifyCode(userEmail, enteredCode)) {
	                resetPassword(userEmail);
	            } else {
	                JOptionPane.showMessageDialog(this, "Mã đăng nhập không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	private String generateVerificationCode() {
        SecureRandom random = new SecureRandom();
        // Generate a random alphanumeric code (you can customize this)
        return String.format("%04d", random.nextInt(10000));
    }
    private boolean verifyCode(String userEmail, String enteredCode) {
        VerificationCode storedCode = verificationCodes.get(userEmail);
        if (storedCode != null && storedCode.getCode().equals(enteredCode) && System.currentTimeMillis() < storedCode.getExpiryTime()) {
            verificationCodes.remove(userEmail);  // Remove the code after successful verification
            return true;
        }
        return false;
    }
    private void resetPassword(String userEmail) {
        String matKhauMoi = JOptionPane.showInputDialog(this, "Nhập mật khẩu mới");
        if (matKhauMoi != null) {  // Check if the user entered a new password
            int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn muốn đổi mật khẩu mới?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (confirmResult == JOptionPane.YES_OPTION) {
                // Get the user's existing account information
                ArrayList<TaiKhoan> tkList = taiKhoan_dao.getTKTheoEmailNV(userEmail);

                if (!tkList.isEmpty()) {
                    TaiKhoan existingTaiKhoan = tkList.get(0);
                    TaiKhoan tkMoi = null;
					try {
						tkMoi = new TaiKhoan(existingTaiKhoan.getMaTaiKhoan(),AESCrypto.encrypt(matKhauMoi),existingTaiKhoan.getTenTaiKhoan(), existingTaiKhoan.getNhanVien());
					} catch (Exception e) {
						e.printStackTrace();
					}
					taiKhoan_dao.capNhat(tkMoi);
					JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu mới thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy tài khoản với email này");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }
    }


	
}
