package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class pnlThongKeNV extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public pnlThongKeNV() {
		setBackground(Color.BLUE);
		setForeground(Color.ORANGE);
		setSize(1163,763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thong ke nhan vien");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(123, 212, 599, 228);
		add(lblNewLabel);
	}

}
