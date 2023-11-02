package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class pnlNhaCungCap extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlNhaCungCap() {
		setBackground(Color.green);
		setForeground(Color.GREEN);
		setBounds(0,0, 1163,763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("this is NCC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(210, 261, 313, 188);
		add(lblNewLabel);
	}

}
