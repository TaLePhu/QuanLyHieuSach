package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import dao.Dao_ChiTietHoaDonBan;
import dao.Dao_HoaDonBan;
import dao.Dao_KhuyenMai;
import dao.Dao_SanPham;
import entity.ChiTietHoaDonBan;
import entity.HoaDonBan;
import entity.KhuyenMai;
import entity.SanPham;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class inHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Dao_HoaDonBan dao_HoaDonBan;
	private Dao_ChiTietHoaDonBan dao_ChiTietHoaDonBan;
	private Dao_SanPham dao_SanPham;
	private Dao_KhuyenMai dao_KhuyenMai;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	
	public inHoaDon(String maHD, String ngayLap, String nv, String kh, String sdt, String diaChi) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THẾ GIỚI SÁCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(150, 10, 200, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DC: 29 Lê Lợi, phường 4, quận Gò Vấp, thành phố Hồ Chí Minh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(70, 50, 360, 20);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.DARK_GRAY));
		panel_1.setBounds(25, 80, 450, 10);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 100, 500, 563);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMaHD = new JLabel("Số hóa đơn:");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaHD.setBounds(10, 40, 90, 20);
		panel_2.add(lblMaHD);
		
		JLabel lblNL = new JLabel("Ngày lập:");
		lblNL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNL.setBounds(10, 70, 90, 20);
		panel_2.add(lblNL);
		
		JLabel lblTenNV = new JLabel("Nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenNV.setBounds(10, 100, 90, 20);
		panel_2.add(lblTenNV);
		
		JLabel lblSDTKH = new JLabel("Số điện thoại:");
		lblSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDTKH.setBounds(270, 70, 90, 20);
		panel_2.add(lblSDTKH);
		
		JLabel lblNewLabel_2_2 = new JLabel("HÓA ĐƠN");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(200, 10, 100, 20);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblMaHD1 = new JLabel(maHD);
		lblMaHD1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaHD1.setBounds(110, 40, 110, 20);
		panel_2.add(lblMaHD1);
		
		JLabel lblNgayLap1 = new JLabel(ngayLap);
		lblNgayLap1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgayLap1.setBounds(110, 70, 110, 20);
		panel_2.add(lblNgayLap1);
		
		JLabel lblNV1 = new JLabel(nv);
		lblNV1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNV1.setBounds(110, 100, 110, 20);
		panel_2.add(lblNV1);
		
		JLabel lblSDT1 = new JLabel(sdt);
		lblSDT1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT1.setBounds(370, 70, 110, 20);
		panel_2.add(lblSDT1);
		
		JLabel lblTenKH = new JLabel("Khách hàng: ");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenKH.setBounds(270, 40, 90, 20);
		panel_2.add(lblTenKH);
		
		JLabel lblTenKH1 = new JLabel(kh);
		lblTenKH1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenKH1.setBounds(370, 40, 110, 20);
		panel_2.add(lblTenKH1);
		
		JLabel lblDC = new JLabel("Địa chỉ: ");
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDC.setBounds(270, 100, 90, 20);
		panel_2.add(lblDC);
		
		JLabel lblDC1 = new JLabel(diaChi);
		lblDC1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDC1.setBounds(370, 100, 110, 20);
		panel_2.add(lblDC1);
		
		
		
		String[] tb = new String[] { "STT", "Tên sản phẩm", "Đơn giá", "Số lượng",
		"Thành tiền" };
		model = new DefaultTableModel(tb, 0);
		table = new JTable(model);
		table.setBounds(0, 145, 490, 270);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 145, 490, 270);
		panel_2.add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		
		dao_HoaDonBan = new Dao_HoaDonBan();
		dao_ChiTietHoaDonBan = new Dao_ChiTietHoaDonBan();
		dao_KhuyenMai = new Dao_KhuyenMai();
		dao_SanPham = new Dao_SanPham();
		
		ArrayList<ChiTietHoaDonBan> ct = dao_ChiTietHoaDonBan.getCTHoaDonBanTheoMa(maHD);
		int STT =0;
		float thanhT =0;
		float GG =0;
		float TTT =0;
		for (ChiTietHoaDonBan ds : ct) {
			SanPham sp = dao_SanPham.getTheoMa(ds.getSanPham().getMaSP());
			model.addRow(new Object[] {++STT,sp.getTenSP(),sp.getGiaBan(),ds.getSoLuong(),ds.getThanhTien()});
			thanhT+=ds.getThanhTien();
		}
		ArrayList<HoaDonBan> hd = dao_HoaDonBan.getHDTheoMa(maHD);
		for (HoaDonBan ds : hd) {
			
			if(ds.getMaKM().getMaKhuyenMai() == null) {
				GG=0;
				TTT = ds.getTongThanhTien();
			}
			else {
				KhuyenMai km = dao_KhuyenMai.getKhuyenMaiTheoMa(ds.getMaKM().getMaKhuyenMai());
				GG=(float) (km.getGiaTriGiamGia()*0.01);
				TTT = ds.getTongThanhTien();
			}
		}
		
		JLabel lblTinSP = new JLabel("Tiền sản phẩm:");
		lblTinSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTinSP.setBounds(10, 430, 120, 20);
		panel_2.add(lblTinSP);
		
		JLabel lblTienSP1 = new JLabel(thanhT+" VND");
		lblTienSP1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienSP1.setBounds(299, 430, 160, 20);
		panel_2.add(lblTienSP1);
		
		JLabel lblKhuynMai = new JLabel("Khuyến mãi:");
		lblKhuynMai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhuynMai.setBounds(10, 460, 120, 20);
		panel_2.add(lblKhuynMai);
		
		JLabel lblKhuynMi_1 = new JLabel(GG+"%");
		lblKhuynMi_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhuynMi_1.setBounds(299, 460, 160, 20);
		panel_2.add(lblKhuynMi_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.DARK_GRAY));
		panel_1_1.setBounds(10, 490, 470, 10);
		panel_2.add(panel_1_1);
		
		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTngTin.setBounds(10, 510, 120, 20);
		panel_2.add(lblTngTin);
		
		JLabel lblTngTin1 = new JLabel(TTT+" VND");
		lblTngTin1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTngTin1.setBounds(299, 510, 160, 20);
		panel_2.add(lblTngTin1);
	}
}
