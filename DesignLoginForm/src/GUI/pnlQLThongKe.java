package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class pnlQLThongKe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public pnlQLThongKe() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.ORANGE);
		setSize(1163,763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tính năng đang được phát triển");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(357, 225, 493, 228);
		add(lblNewLabel);
	}

}
