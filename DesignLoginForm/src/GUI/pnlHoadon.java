package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;

public class pnlHoadon extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public pnlHoadon() {
		setBackground(Color.YELLOW);
		setForeground(Color.GREEN);
		setBounds(0,0, 1166, 685);
		setLayout(null);
//		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("this is Hoadon");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(206, 205, 414, 200);
		add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(147, 410, 675, 234);
		add(table);
	}
}
