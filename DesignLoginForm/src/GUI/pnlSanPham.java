package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class pnlSanPham extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlSanPham() {
		setBackground(Color.CYAN);
		setForeground(Color.YELLOW);
		setBounds(0,0, 919, 739);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("this is san pham");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel.setBounds(160, 245, 460, 170);
		add(lblNewLabel);
	}

}
