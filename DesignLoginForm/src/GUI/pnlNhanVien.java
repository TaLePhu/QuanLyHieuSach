package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class pnlNhanVien extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlNhanVien() {
		setBackground(Color.PINK);
		setForeground(Color.PINK);
		setBounds(0,0, 1166,685);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("this is nhan vien");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(169, 175, 485, 293);
		add(lblNewLabel);
	}

}
