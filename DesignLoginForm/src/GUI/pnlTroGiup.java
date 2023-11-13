package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class pnlTroGiup extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlTroGiup() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.BLUE);
		setBounds(0,0, 1163,763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tính năng đang được phát triển");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(331, 262, 505, 188);
		add(lblNewLabel);
	}

}
