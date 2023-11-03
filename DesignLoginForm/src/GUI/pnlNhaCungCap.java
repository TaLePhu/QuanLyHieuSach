package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;

public class pnlNhaCungCap extends JPanel {
	private JTable table;

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
		
		table = new JTable();
		table.setBounds(245, 477, 384, 98);
		add(table);
		
		JLabel lblNewLabel_1 = new JLabel("jix");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(175, 102, 501, 135);
		add(lblNewLabel_1);
	}
}
