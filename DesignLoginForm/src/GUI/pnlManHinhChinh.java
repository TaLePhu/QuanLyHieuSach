package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class pnlManHinhChinh extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public pnlManHinhChinh() {
		setBackground(Color.PINK);
		setForeground(Color.PINK);
		setBounds(0,0, 1163,763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đây là panel Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(169, 175, 485, 293);
		add(lblNewLabel);
	}

}
