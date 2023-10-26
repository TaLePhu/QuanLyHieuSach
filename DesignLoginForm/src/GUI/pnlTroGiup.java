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
		setBackground(Color.MAGENTA);
		setForeground(Color.BLUE);
		setBounds(0,0, 1166,685);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("this is help");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(210, 261, 313, 188);
		add(lblNewLabel);
	}

}
