package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class pnlManHinhChinh extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public pnlManHinhChinh() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.PINK);
		setBounds(0,0, 1163,763);
		setLayout(null);
		Image bgHome = new ImageIcon(this.getClass().getResource("/bgHome 1.png")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("Phần mềm quản lý hiệu sách tư nhân");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(227, 612, 751, 105);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 0, 1143, 753);
		add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(bgHome));
	}
}
