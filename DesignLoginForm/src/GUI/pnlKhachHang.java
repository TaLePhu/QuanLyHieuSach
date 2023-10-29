package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class pnlKhachHang extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlKhachHang() {
		setBounds(0,0, 1163, 763);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("this is khach hang");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(173, 194, 465, 273);
		add(lblNewLabel);
	}

}
