package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameLogin extends JFrame {

	
	
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(150, 189, 283, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Arial", Font.BOLD, 12));
		txtUserName.setText("userName");
		txtUserName.setBounds(21, 10, 164, 20);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setBounds(210, 0, 73, 40);
		panel.add(lblIconUsername);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(150, 239, 283, 40);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("password");
		txtPassword.setBounds(21, 10, 158, 20);
		panel1.add(txtPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setBounds(210, 0, 73, 40);
		panel1.add(lblIconPassword);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(570, 10, 20, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(150, 38, 283, 141);
		contentPane.add(lblIconLogo);
		Image img = new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		lblIconLogo.setIcon(new ImageIcon(img));
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});	
		btnLogin.setBounds(150, 309, 283, 61);
		contentPane.add(btnLogin);
		setLocationRelativeTo(null);
	}
}
