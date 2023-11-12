CREATE DATABASE QLHIEUSACH
GO

USE QLHIEUSACH
GO

CREATE TABLE NHACUNGCAP(
 MANHACUNGCAP CHAR(10) NOT NULL,
 TENNHACUNGCAP NVARCHAR(50),
 DIACHI NVARCHAR(100) ,
 SODIENTHOAI VARCHAR(10) ,
 EMAIL NVARCHAR(30) ,
 TINHTRANG NVARCHAR(20),
 CONSTRAINT pk_NHACUNGCAP PRIMARY KEY (MANHACUNGCAP)
)
GO

CREATE TABLE KEHANG(
 MAKEHANG CHAR(10) NOT NULL,
 TENKEHANG NVARCHAR(30) ,
 VITRI NVARCHAR(100),
 SUCCHUA INT,
 TINHTRANG NVARCHAR(20),
 CONSTRAINT pk_KEHANG PRIMARY KEY (MAKEHANG)
)
GO

CREATE TABLE KHUYENMAI(
 MAKHUYENMAI CHAR(10) NOT NULL,
 TENKHUYENMAI NVARCHAR(50) NOT NULL,
 GIATRIGIAMGIA INT,
 NGAYBATDAU DATE,
 NGAYKETTHUC DATE,
 DOITUONGAPDUNG NVARCHAR(100),
 TINHTRANG NVARCHAR(20) NOT NULL,
 CONSTRAINT pk_KHUYENMAI PRIMARY KEY (MAKHUYENMAI)
)
GO

CREATE TABLE DANHMUC(
 MADANHMUC CHAR(10) NOT NULL,
 TENDANHMUC NVARCHAR(100),

 CONSTRAINT pk_DANHMUC PRIMARY KEY (MADANHMUC)
)
GO

CREATE TABLE SANPHAM(
 MASANPHAM CHAR(10) NOT NULL,
 TENSANPHAM NVARCHAR(100) ,
 GIAMUA FLOAT,
 SOLUONG INT,
 GIABAN FLOAT,
 NHAXUATBAN NVARCHAR(50),
 TACGIA NVARCHAR(50),
 NAMXUATBAN INT,
 SOTRANG INT,
 THUEVAT FLOAT,
 MADANHMUC CHAR(10),
 MAKEHANG CHAR(10),
 MAKHUYENMAI CHAR(10),
 MANHACUNGCAP CHAR(10),
 THUONGHIEU NVARCHAR(50),
 XUATXU NVARCHAR(50),
 MAUSAC NVARCHAR(50),
 CHATLIEU NVARCHAR(50),
 TINHTRANG NVARCHAR(20),
 CONSTRAINT pk_SANPHAM PRIMARY KEY (MASANPHAM),

 CONSTRAINT fk_KEHANG_SANPHAM FOREIGN KEY(MAKEHANG) REFERENCES KEHANG(MAKEHANG),
 CONSTRAINT fk_KHUYENMAI_SANPHAM FOREIGN KEY(MAKHUYENMAI) REFERENCES KHUYENMAI(MAKHUYENMAI),
 CONSTRAINT fk_DANHMUC_SANPHAM FOREIGN KEY(MADANHMUC) REFERENCES DANHMUC(MADANHMUC),
 CONSTRAINT fk_NHACUNGCAP_SANPHAM FOREIGN KEY(MANHACUNGCAP) REFERENCES NHACUNGCAP(MANHACUNGCAP),
)
GO

CREATE TABLE NHANVIEN(
 MANHANVIEN CHAR(10) NOT NULL,
 HOTENNHANVIEN NVARCHAR(50) ,
 NGAYSINH DATE ,
 DIACHI NVARCHAR(100),
 SODIENTHOAI NVARCHAR(10),
 EMAIL NVARCHAR(30),
 GIOITINH BIT,
 CHUCVU NVARCHAR(50),
 TINHTRANG NVARCHAR(20),

 CONSTRAINT pk_NHANVIEN PRIMARY KEY (MANHANVIEN),
)
GO

CREATE TABLE TAIKHOAN(
 MATAIKHOAN CHAR(10) NOT NULL,
 MATKHAU NVARCHAR(30) ,
 TENTAIKHOAN NVARCHAR(50) ,
 MANHANVIEN CHAR(10),
 CONSTRAINT pk_TAIKHOAN PRIMARY KEY (MATAIKHOAN),

 CONSTRAINT fk_NHANVIEN_TAIKHOAN FOREIGN KEY(MANHANVIEN) REFERENCES NHANVIEN(MANHANVIEN),
)
GO



CREATE TABLE KHACHHANG(
 MAKHACHHANG CHAR(10) NOT NULL,
 HOTENKHACHHANG NVARCHAR(50),
 NGAYSINH DATE ,
 DIACHI NVARCHAR(100),
 SODIENTHOAI NVARCHAR(10),
 EMAIL NVARCHAR(30),
 GIOITINH BIT,

 CONSTRAINT pk_KHACHHANG PRIMARY KEY (MAKHACHHANG)
)
GO

CREATE TABLE HOADONBAN(
 MAHOADONBAN CHAR(20) NOT NULL,
 MANHANVIEN CHAR(10),
 MAKHACHHANG CHAR(10),
 MAKHUYENMAI CHAR(10),
 NGAYGIAODICH DATETIME,
 TRANGTHAI NVARCHAR(30),
 TONGTHANHTIEN FLOAT,
 

 CONSTRAINT pk_HOADONBAN PRIMARY KEY (MAHOADONBAN),

 CONSTRAINT fk_NHANVIEN_HOADONBAN FOREIGN KEY(MANHANVIEN) REFERENCES NHANVIEN(MANHANVIEN),
 CONSTRAINT fk_KHACHHANG_HOADONBAN FOREIGN KEY(MAKHACHHANG) REFERENCES KHACHHANG(MAKHACHHANG),
 CONSTRAINT fk_KHUYENMAI_HOADONBAN FOREIGN KEY(MAKHUYENMAI) REFERENCES KHUYENMAI(MAKHUYENMAI),
)
GO

CREATE TABLE CHITIETHOADONBAN(
 MAHOADONBAN CHAR(20) NOT NULL,
 MASANPHAM CHAR(10) NOT NULL,
 SOLUONG INT,
 THANHTIEN FLOAT,

 CONSTRAINT pk_CHITIETHOADONBAN PRIMARY KEY (MAHOADONBAN,MASANPHAM),

 CONSTRAINT fk_HOADON_CHITIETHOADONBAN FOREIGN KEY(MAHOADONBAN) REFERENCES HOADONBAN(MAHOADONBAN),
 CONSTRAINT fk_SANPHAM_CHITIETHOADONBAN FOREIGN KEY(MASANPHAM) REFERENCES SANPHAM(MASANPHAM),
)
GO



INSERT INTO NHACUNGCAP (MANHACUNGCAP, TENNHACUNGCAP, DIACHI, SODIENTHOAI, EMAIL, TINHTRANG)
VALUES
    ('NCC001', N'Công ty Cổ Phần Phát Hành Sách Tp. HCM', N'60-62 Lê Lợi, P. Bến Nghé, Quận 1, TP.HCM', '0288225798', 'congtya@email.com', N'Đang hoạt động'),
    ('NCC002', N'Trí Tuệ - Công ty Cổ Phần Sách', N'187 Giảng Võ, Quận Đống Đa, Hà Nội', '0438515567', 'congtyb@email.com', N'Đang hoạt động'),
    ('NCC003', N'Công Ty TNHH Văn Hóa Việt Long', N'14/35, Đào Duy Anh, P.9, Q. Phú Nhuận, Tp. Hồ Chí Minh', '0369852147', 'congtyc@email.com', N'Đang hoạt động'),
    ('NCC004', N'Nhà Sách Trực Tuyến BOOKBUY.VN', N'147 Pasteur, P. 6, Q. 3, Tp. Hồ Chí Minh', '0557123468', 'congtyd@email.com', N'Ngừng hoạt động'),
    ('NCC005', N'Nhà Sách Bích Quân', N'249 Lý Thường Kiệt, KP. Thống Nhất 1, Dĩ An, Bình Dương, Việt Nam', '0944566788', 'congtye@email.com', N'Đang hoạt động'),
	('NCC006', N'Công Ty Cổ Phần Văn Hóa Nhân Văn', N'1 Trường Chinh, P. 1, Q. Tân Bình, Tp. Hồ Chí Minh, Việt Nam', '0123456789', 'congtya@email.com', N'Đang hoạt động'),
    ('NCC007', N'Nhà Sách An Dương Vương', N'87/1 Trần Phú, P. 4, Q. 5, Tp. Hồ Chí Minh, Việt Nam', '0987654321', 'congtyb@email.com', N'Ngừng hoạt động'),
    ('NCC008', N'Hiệu Sách Tiến Thành', N'Số 11-13 Đường 53, P. 10, Q. 6, Tp. Hồ Chí Minh, Việt Nam', '0369852147', 'congtyc@email.com', N'Đang hoạt động'),
	('NCC009', N'Nhà Xuất Bản Kim Đồng', N'Số 11-13 Đường 53, P. 10, Q. 6, Tp. Hồ Chí Minh, Việt Nam', '0369852147', 'congtyc@email.com', N'Đang hoạt động');

INSERT INTO KEHANG (MAKEHANG, TENKEHANG, VITRI, SUCCHUA, TINHTRANG)
VALUES
    ('KH001', N'Kệ Sách Giáo Khoa', N'Vị trí 1, Tầng 1',200, N'Còn trống'),
    ('KH002', N'Kệ Sách Tham Khảo', N'Vị trí 2, Tầng 1',150, N'Còn trống'),
    ('KH003', N'Kệ Sách Thiếu Nhi', N'Vị trí 3, Tầng 1',170, N'Còn trống'),
    ('KH004', N'Kệ Sách Ngoại Ngữ', N'Vị trí 4, Tầng 1',200, N'Còn trống'),
    ('KH005', N'Kệ Sách Tin Học', N'Vị trí 5, Tầng 1', 250, N'Còn trống'),
    ('KH006', N'Kệ Sách Văn Học', N'Vị trí 6, Tầng 1',100, N'Còn trống'),
    ('KH007', N'Dụng cụ học tập', N'Vị trí 1, Tầng 2',300, N'Còn trống'),
    ('KH008', N'Kệ Quà Lưu Niệm', N'Vị trí 2, Tầng 2',150, N'Còn trống');

INSERT INTO KHUYENMAI (MAKHUYENMAI, TENKHUYENMAI, GIATRIGIAMGIA, NGAYBATDAU, NGAYKETTHUC, DOITUONGAPDUNG, TINHTRANG)
VALUES
    ('KM001', N'Khuyến mãi nhân diệp 20/11', 10, '2023-11-19', '2023-11-20', N'Hóa đơn', N'Sắp diễn ra'),
    ('KM002', N'Khuyến mãi nhân diệp ngày Quốc tế đọc sách', 10, '2023-09-07', '2023-09-09', N'Hóa đơn', N'Đã kết thúc'),
    ('KM003', N'Khuyến mãi nhân ngày Sách thế giới', 20, '2023-04-23', '2023-04-23', N'Hóa đơn', N'Sắp diễn ra'),
	('KM004', N'Khuyến mãi 20%', 20, NULL, NULL, N'Sản phẩm', N'Đang diễn ra'),
	('KM005', N'Khuyến mãi 10%', 10, NULL, NULL, N'Sản phẩm', N'Đang diễn ra'),
	('KM006', N'Khuyến mãi 5%', 5, NULL, NULL, N'Sản phẩm', N'Đang diễn ra');

INSERT INTO DANHMUC (MADANHMUC, TENDANHMUC)
VALUES
	('DM001','Sách giáo khoa'),
	('DM002','Sách tham khảo'),
	('DM003','Sách thiếu nhi'),
	('DM004','Sách ngoại ngữ'),
	('DM005','Sách tin học'),
	('DM006','Sách văn học'),
	('DM007','Dụng cụ học tập'),
	('DM008','Quà lưu niệm');

INSERT INTO SANPHAM (MASANPHAM, TENSANPHAM, GIAMUA, SOLUONG, GIABAN, NAMXUATBAN, NHAXUATBAN, SOTRANG, TACGIA,THUEVAT, MAKEHANG, MAKHUYENMAI, MADANHMUC, MANHACUNGCAP)
VALUES
    ('S0001', N'Sách Giáo Khoa Toán 10', 10000, 50, 11000, 2020, N'Nhà Xuất Bản Giáo Dục', 300, N'Hồ Xuân Thái',0, 'KH001', NULL, 'DM001','NCC001'),
    ('S0002', N'Sách Giáo Khoa Văn 9', 8000, 40, 8800, 2021, N'Nhà Xuất Bản Trẻ', 250, N'Nguyễn Vĩnh Ngiêm',0, 'KH001', NULL, 'DM001','NCC002'),
    ('S0003', N'Sách Giáo Khoa Lịch Sử 11', 12000, 60, 13200, 2019, N'Nhà Xuất Bản Chính Trị Quốc Gia', 350, N'Nguyễn Mai Chi',0, 'KH001', NULL, 'DM001', 'NCC003'),
    ('S0004', N'Sách Giáo Khoa Ngữ Văn 12', 15000, 70, 16500, 2018, N'Nhà Xuất Bản Học Viện Ngân Hàng', 400, N'Đỗ Bích Thúy',0, 'KH001', NULL, 'DM001', 'NCC001'),
    ('S0005', N'Sách Giáo Khoa Hóa Học 11', 11000, 55, 12100, 2020, N'Nhà Xuất Bản Đại Học Khoa Học Tự Nhiên', 320, N'Hồ Ngọc Hải',0, 'KH001', NULL, 'DM001','NCC004'),
    ('S0006', N'Sách Giáo Khoa Tiếng Anh 10', 9000, 45, 9900, 2022, N'Nhà Xuất Bản Tiếng Anh', 280, N'Nguyễn Gia Long',0, 'KH001', NULL, 'DM001','NCC005'),
    ('S0007', N'Sách Giáo Khoa Địa Lý 9', 8000, 40, 8800, 2021, N'Nhà Xuất Bản Địa Lý', 260, N'Đào Huy Cừ',0, 'KH001', NULL, 'DM001','NCC002'),
    ('S0008', N'Sách Giáo Khoa Sinh Học 12', 14000, 70, 15400, 2019, N'Nhà Xuất Bản Sinh Học', 380, N'Nguyễn Bích Phụng',0, 'KH001', NULL, 'DM001','NCC006'),
    ('S0009', N'Sách Giáo Khoa Công Nghệ 11', 11500, 58, 12650, 2021, N'Nhà Xuất Bản Công Nghệ', 300, N'Trần Văn Ơn',0, 'KH001', NULL, 'DM001','NCC001'),
    ('S0010', N'Sách Giáo Khoa Toán 9', 8500, 42, 9350, 2022, N'Nhà Xuất Bản Giáo Dục', 270, N'Phạm Ngọc Tiên',0, 'KH001', NULL, 'DM001','NCC002'),

	('S0011', N'Sách Tham Khảo Toán 10', 10000, 50, 11000, 2020, N'Nhà Xuất Bản Giáo Dục', 300, N'Hồ Xuân Thái',0.05, 'KH002', NULL, 'DM002','NCC001'),
    ('S0012', N'Sách Tham Khảo Văn 9', 8000, 40, 8800, 2021, N'Nhà Xuất Bản Trẻ', 250, N'Nguyễn Vĩnh Ngiêm',0.05, 'KH002', NULL, 'DM002','NCC001'),
    ('S0013', N'Sách Tham Khảo Lịch Sử 11', 12000, 60, 13200, 2019, N'Nhà Xuất Bản Chính Trị Quốc Gia', 350, N'Nguyễn Mai Chi',0.05, 'KH002', NULL, 'DM002','NCC001'),
    ('S0014', N'Sách Tham Khảo Ngữ Văn 12', 15000, 70, 16500, 2018, N'Nhà Xuất Bản Học Viện Ngân Hàng', 400, N'Đỗ Bích Thúy',0.05, 'KH002', NULL, 'DM002','NCC001'),
    ('S0015', N'Sách Tham Khảo Hóa Học 11', 11000, 55, 12100, 2020, N'Nhà Xuất Bản Đại Học Khoa Học Tự Nhiên', 320, N'Hồ Ngọc Hải',0.05, 'KH002', NULL, 'DM002','NCC002'),
    ('S0016', N'Sách Tham Khảo Tiếng Anh 10', 9000, 45, 9900, 2022, N'Nhà Xuất Bản Tiếng Anh', 280, N'Nguyễn Gia Long',0.05, 'KH002', NULL, 'DM002','NCC002'),
    ('S0017', N'Sách Tham Khảo Địa Lý 9', 8000, 40, 8800, 2021, N'Nhà Xuất Bản Địa Lý', 260, N'Đào Huy Cừ',0.05, 'KH002', NULL, 'DM002','NCC003'),
    ('S0018', N'Sách Tham Khảo Sinh Học 12', 14000, 70, 15400, 2019, N'Nhà Xuất Bản Sinh Học', 380, N'Nguyễn Bích Phụng',0.05, 'KH002', NULL, 'DM002','NCC001'),
    ('S0019', N'Sách Tham Khảo Công Nghệ 11', 11500, 58, 12650, 2021, N'Nhà Xuất Bản Công Nghệ', 300, N'Trần Văn Ơn',0.05, 'KH002', NULL, 'DM002','NCC001'),
    ('S0020', N'Sách Tham Khảo Toán 9', 8500, 42, 9350, 2022, N'Nhà Xuất Bản Giáo Dục', 270, N'Phạm Ngọc Tiên',0.05, 'KH002', NULL, 'DM002','NCC001'),

	('S0021', N'Đất Rừng Phương Nam', 80000, 15, 88000, 2020, N'Nhà Xuất Bản Kim Đồng', 90, N'Đoàn Giỏi',0.05, 'KH003', NULL, 'DM003','NCC004'),
	('S0022', N'Hoàng Tử Bé', 70000, 4, 77000, 2020, N'Nhà Xuất Bản Văn Học', 180, N'Antoine de Saint-Exupéry',0.05, 'KH003', NULL, 'DM003','NCC004'),
	('S0023', N'Tuổi thơ dữ dội', 50000, 6, 55000, 2018, N'NXB Kim Đồng', 111, N'Phùng Quán',0.05, 'KH003', NULL, 'DM003','NCC004'),
	('S0024', N'Thám Tử Lừng Danh Conan - Tập 1', 20000, 30, 22000, 2018, N'NXB Kim Đồng', 320, N'Gosho Aoyama',0.05, 'KH003', NULL, 'DM003','NCC004'),
	('S0025', N'Thám Tử Lừng Danh Conan - Tập 2', 20000, 50, 22000, 2018, N'NXB Kim Đồng', 300, N'Gosho Aoyama',0.05, 'KH003', NULL, 'DM003','NCC004'),

	('S0026', N'Từ Điển Việt - Nga', 200000, 30, 220000, 2018, N'NXB Thế Giới', 300, N'Bùi Hiền',0.05, 'KH004', NULL, 'DM004','NCC005'),
	('S0027', N'Combo Sách Ngữ Pháp Tiếng Anh Mai Lan Hương (Bộ 2 Cuốn)', 300000, 11, 330000, 2018, N'Đà Nẵng', 300, N'Nguyễn Thanh Loan',0.05, 'KH004', 'KM004', 'DM004','NCC005'),
	('S0028', N'Combo Sách Destination - Grammar And Vocabulary with Answer Key - B1 + B2 (Bộ 2 Cuốn)', 200000, 3, 220000, 2018, N'Hồng Đức', 300, N'Malcome Mann',0.05, 'KH004', 'KM005', 'DM004','NCC005'),
	('S0029', N'Combo Sách Hackers Ielts Trọn Bộ - Writing + Listening + Reading + Speaking (Bộ 4 Cuốn)', 800000, 3, 880000, 2018, N'NXB Thế Giới', 300, N'Hackers',0.05, 'KH004', NULL, 'DM004','NCC005'),
	('S0030', N'Ielts Writing Recent Actual Tests', 200000, 6, 220000, 2018, N'Tổng Hợp Tphcm', 300, N'Trịnh Khánh Lợi, Đỗ Tư Tấn',0.05, 'KH004', NULL, 'DM004','NCC005'),

	('S0031', N'Clean Code - Mã Sạch Và Con Đường Trở Thành Lập Trình Viên Giỏi', 300000, 10, 330000, 2018, N'Dân trí', 150, N'Nguyễn Văn Trung',0.05, 'KH005', NULL, 'DM005','NCC005'),
	('S0032', N'Em Học Python - Sách Hướng Dẫn Vui Học Lập Trình', 100000, 14, 110000, 2022, N'Đại Học Quốc Gia Hà Nội', 500, N'Jason R. Briggs',0.05, 'KH005', NULL, 'DM005','NCC005'),
	('S0033', N'Data Strategy - Chiến Lược Dữ Liệu', 50000, 20, 55000, 2010, N'Tổng Hợp Tphcm', 140, N'Bernard Marr',0.05, 'KH005', NULL, 'DM005','NCC005'),
	
	('S0034', N'Combo Sách Nhà Giả Kim + Hành Trình Về Phương Đông', 150000, 4, 165000, 2018, N'Dân trí', 150, N'Paulo Coelho, Baird T Spalding',0.05, 'KH006', NULL, 'DM006','NCC006'),
	('S0035', N'Hồn Trương Ba Da Hàng Thịt', 40000, 10, 44000, 2022, N'NXB Kim Đồng', 500, N'Lưu Quang Vũ',0.05, 'KH006', NULL, 'DM006','NCC006'),
	('S0036', N'Yêu Những Điều Không Hoàn Hảo', 50000, 12, 55000, 2010, N'Nhã Nam', 140, N'Hae Min, Haruki Murakami',0.05, 'KH006', NULL, 'DM006','NCC006'),
	('S0037', N'Combo Sách Ứng Dụng Văn Phòng - Từ Cơ Bản Đến Nâng Cao - Word + Excel (Bộ 2 Cuốn)', 300000, 5, 330000, 2020, N'Nhã Nam', 1500, N'Nguyễn Quang Vinh',0.05, 'KH006', 'KM005', 'DM006','NCC006');

INSERT INTO SANPHAM (MASANPHAM, TENSANPHAM, GIAMUA, SOLUONG, GIABAN, THUONGHIEU, XUATXU, MAUSAC, CHATLIEU,THUEVAT, MAKEHANG, MAKHUYENMAI, MADANHMUC, MANHACUNGCAP)
VALUES
	('VPP0001', N'Bộ Đồ Dùng Học Tập Lớp Học Mật Ngữ Ở Nhà Màu Hồng Đầu Tiên', 60000, 20, 66000, N'HooHooHaHa', N'Việt Nam', N'Hồng', N'Nhựa',0.1, 'KH007', 'KM005', 'DM007','NCC007'),
	('VPP0002', N'Sổ May Gáy Sunshine A4 200 Trang 3675', 20000, 50, 22000, N'Hải Tiến', N'Việt Nam', null, null,0.1, 'KH007', NULL, 'DM007','NCC007'),
	('VPP0003', N'Vỉ 5 Bút Bi 0.5 mm Thiên Long TL-027', 20000, 10, 22000, N'Thiên Long', N'Việt Nam', null, N'Nhựa',0.1, 'KH007', NULL, 'DM007','NCC007'),
	('VPP0004', N'Bút Bi 0.5 mm Thiên Long TL-027', 4000, 30, 4400, N'Thiên Long', N'Việt Nam', null, N'Nhựa',0.1, 'KH007', NULL, 'DM007','NCC007'),
	('VPP0005', N'Bút Bi 0.5 mm Laris - Thiên Long TL-095 - Mực Xanh', 4000, 9, 4400, N'Thiên Long', N'Việt Nam', null, N'Nhựa',0.1, 'KH007', 'KM006', 'DM007','NCC007'),
	('VPP0006', N'Bút Bi Pro 027 0.5 mm - Thiên Long TL-105 - Mực Đỏ', 4000, 11, 4400, N'Thiên Long', N'Việt Nam', null, N'Nhựa',0.1, 'KH007', NULL, 'DM007','NCC007'),
	('VPP0007', N'Viết Bic Bấm 10 Ngòi Hình Thú ', 20000, 8, 22000, N'OEM', N'Trung Quốc', null, null,0.1, 'KH007', NULL, 'DM007','NCC007'),
	('VPP0008', N'Vỉ 5 Bút Bi 0.5 mm Thiên Long TL-027', 20000, 220, 22000, N'Thiên Long', N'Việt Nam', N'Xanh', N'Nhựa',0.1, 'KH007', 'KM005', 'DM007','NCC008'),
	('VPP0009', N'Bút Chì Gỗ 2B Thiên Long', 4000, 200, 4400, N'Thiên Long', N'Việt Nam', N'Đen', null,0.1, 'KH007', NULL, 'DM007','NCC008'),
	('VPP0010', N'Tẩy Chì Học Sinh Staedtler', 5000, 100, 5500, N'Staedtler', N'Đức', null, N'Nhựa',0.1, 'KH007', NULL, 'DM007','NCC008'),
	('VPP0011', N'Ba Lô Mini', 400000, 10, 440000, N'Clever Hippo', N'Việt Nam',N'Đỏ', N'Nhựa,vải',0.1, 'KH007', NULL, 'DM007','NCC008'),
	('VPP0012', N'Cặp Đa Năng Flash 20', 200000, 8, 220000, N'SAKOS', N'Việt Nam', N'Đen', N'Vải',0.1, 'KH007', NULL, 'DM007','NCC008'),
	('VPP0013', N'Túi Đựng Phụ Kiện Đa Năng New Compact', 30000, 10, 33000, N'SAKOS', N'Việt Nam', N'Xanh dương', N'Nhựa, vải',0.1, 'KH007', 'KM004', 'DM007','NCC008'),

	('VPP0014', N'Bảng Học Tập Đa Năng Bằng Gỗ - Đếm Số Và Câu Cá', 200000, 5, 220000, N'TÙNG PHÁT', N'Việt Nam', N'Nhiều màu', N'Gỗ',0.1, 'KH008', NULL, 'DM008','NCC009'),
	('VPP0015', N'Quạt Đeo Cổ Mini', 100000, 5, 110000, N'GIVELONG', N'Trung Quốc', N'Hồng', N'Nhựa',0.1, 'KH008', NULL, 'DM008','NCC009'),
	('VPP0016', N'Quạt Đeo Cổ Mini', 100000, 7, 110000, N'GIVELONG', N'Trung Quốc', N'Xanh', N'Nhựa',0.1, 'KH008', NULL, 'DM008','NCC009'),
	('VPP0017', N'Rubik 3x3', 30000, 12, 33000, N'FanXin', N'Việt Nam', N'Đủ màu', N'Nhựa',0.1, 'KH008', NULL, 'DM008','NCC009');

INSERT INTO NHANVIEN (MANHANVIEN, HOTENNHANVIEN, NGAYSINH, DIACHI, SODIENTHOAI, EMAIL, GIOITINH, CHUCVU, TINHTRANG)
VALUES
    ('NV101', N'Trần Văn Bình', '2003-08-08', N'Phường 3, Gò Vấp', '0375926965', 'binhpro50@example.com', 1, N'Nhân viên quản lý', N'Đang làm việc'),
    ('NV002', N'Trần Thị Bích Phượng', '1995-08-20', N'12 Nguyễn Văn Bảo, Gò Vấp', '0987654321', 'tranthib@example.com', 0, N'Nhân viên bán hàng', N'Đang làm việc'),
    ('NV003', N'Phạm Văn Cảnh', '1988-03-10', N'789 Đường Nguyễn Trãi, Quận 3', '0369852147', 'phamvanc@example.com', 1, N'Nhân viên bán hàng', N'Đang làm việc'),
    ('NV004', N'Lê Thị Diễm', '1993-11-05', N'101 Đường số 6, Quận 4', '0712345678', 'lethid@example.com', 0, N'Nhân viên bán hàng', N'Đang làm việc'),
    ('NV005', N'Nguyễn Văn Tài Em', '1991-07-25', N'246 Đường Lê Lợi, Quận 5', '0923456781', 'nguyenvane@example.com', 1, N'Nhân viên bán hàng', N'Tạm ngưng');

INSERT INTO TAIKHOAN (MATAIKHOAN, MATKHAU, TENTAIKHOAN, MANHANVIEN)
VALUES
    ('TK001', N'0Hm4gUveFkvsE91YfmTeFA==', N'Admin', 'NV101'),
    ('TK002', N'0Hm4gUveFkvsE91YfmTeFA==', N'User', 'NV002'),
    ('TK003', N'+yOROB7FvH8PthmgRgehPA==', N'Văn Cảnh', 'NV003'),
    ('TK004', N'ExoJ/SnFkaiAYBJpGXrKnQ==', N'Diễm', 'NV004'),
    ('TK005', N'QTMnc22og1UzCGXlsKEbjw==', N'Tài Em', 'NV005');

INSERT INTO KHACHHANG (MAKHACHHANG, HOTENKHACHHANG, NGAYSINH, DIACHI, SODIENTHOAI, EMAIL, GIOITINH)
VALUES
    ('KH0000001', N'Nguyễn Văn Anh', '1990-01-15', N'123 Đường ABC, Quận 1', '0123456781', 'khachhang1@gmail.com', 1),
    ('KH0000002', N'Trần Thị Ngọc', '1985-05-20', N'456 Đường XYZ, Quận 2', '0987654322', 'khachhang2@gmail.com', 0),
    ('KH0000003', N'Phạm Văn Cảnh', '1988-03-10', N'789 Đường LMN, Quận 3', '0369852143', 'khachhang3@gmail.com', 1),
    ('KH0000004', N'Lê Thị Tuyết Mai', '1992-11-05', N'101 Đường XYZ, Quận 4', '0712345674', 'khachhang4@gmail.com', 0),
    ('KH0000005', N'Nguyễn Ngọc Trung Quân', '1991-07-25', N'246 Đường PQR, Quận 5', '0923456785', 'khachhang5@gmail.com', 1),
    ('KH0000006', N'Phan Ngọc Bích', '1987-04-12', N'369 Đường DEF, Quận 6', '0654321986', 'khachhang6@gmail.com', 0),
    ('KH0000007', N'Phạm Tấn Long', '1989-09-30', N'147 Đường MNO, Quận 7', '0312345677', 'khachhang7@gmail.com', 1),
    ('KH0000008', N'Lê Thị Mỹ', '1994-01-28', N'258 Đường GHI, Quận 8', '0987654328', 'khachhang8@gmail.com', 0),
    ('KH0000009', N'Nguyễn Văn Bình', '1992-06-17', N'963 Đường STU, Quận 9', '0712345679', 'khachhang9@gmail.com', 1),
    ('KH0000010', N'Trần Thị Mỹ Hạnh', '1997-02-08', N'852 Đường KLM, Quận 10', '0923456780', 'khachhang10@gmail.com', 0),
    ('KH0000011', N'Hoàng Văn Bách', '1995-10-05', N'321 Đường QWE, Quận 11', '0612345671', 'khachhang11@gmail.com', 1),
    ('KH0000012', N'Mai Thị Tuyết Mai', '1993-12-15', N'456 Đường ASD, Quận 12', '0789123456', 'khachhang12@gmail.com', 0),
    ('KH0000013', N'Đặng Văn Lâm', '1986-03-20', N'789 Đường ZXC, Quận 3', '0369852142', 'khachhang13@gmail.com', 1),
    ('KH0000014', N'Lý Thị Hoa', '1998-04-18', N'101 Đường VBN, Quận 4', '0712345672', 'khachhang14@gmail.com', 0),
    ('KH0000015', N'Huỳnh Văn Lộc', '1990-11-30', N'246 Đường UIO, Quận 5', '0923456783', 'khachhang15@gmail.com', 1),
    ('KH0000016', N'Võ Thị Kiều Linh', '1984-08-08', N'369 Đường MNB, Quận 6', '0654321984', 'khachhang16@gmail.com', 0),
    ('KH0000017', N'Hoàng Văn Nam', '1987-02-20', N'147 Đường XZA, Quận 7', '0312345673', 'khachhang17@gmail.com', 1),
    ('KH0000018', N'Nguyễn Thị Diễm', '1993-06-28', N'258 Đường PLK, Quận 8', '0987654327', 'khachhang18@gmail.com', 0),
    ('KH0000019', N'Nguyễn Văn Hoài Nam', '1995-03-15', N'963 Đường LKO, Quận 9', '0712345673', 'khachhang19@gmail.com', 1),
    ('KH0000020', N'Trần Thị Bích Phương', '1991-01-25', N'852 Đường JHK, Quận 10', '0923456789', 'khachhang20@gmail.com', 0);

INSERT INTO HOADONBAN (MAHOADONBAN, MANHANVIEN, MAKHACHHANG, MAKHUYENMAI, NGAYGIAODICH, TRANGTHAI, TONGTHANHTIEN)
VALUES
    ('HD2301250001', 'NV101', 'KH0000001','KM003', '2023-01-25 10:30:00', N'Đã thanh toán', 120000),
    ('HD2301280001', 'NV002', 'KH0000002',NULL, '2023-01-28 11:15:00', N'Đã thanh toán', 100000),
    ('HD2301280002', 'NV003', 'KH0000003',NULL, '2023-01-28 16:45:00', N'Đã thanh toán', 150000),

    ('HD2302010001', 'NV002', 'KH0000004',NULL, '2023-02-01 14:20:00', N'Đã thanh toán', 1910000),
    ('HD2302020001', 'NV002', 'KH0000005',NULL, '2023-02-02 16:00:00', N'Đã thanh toán', 100000),
	('HD2302020002', 'NV002', 'KH0000006',NULL, '2023-02-02 16:05:00', N'Đã thanh toán', 97000),
    ('HD2302020003', 'NV002', 'KH0000001',NULL, '2023-02-02 16:10:00', N'Đã thanh toán', 100000),
    ('HD2302020004', 'NV002', 'KH0000007',NULL, '2023-02-02 17:00:00', N'Đã thanh toán', 42000),
    ('HD2302100001', 'NV003', 'KH0000008',NULL, '2023-02-10 14:20:00', N'Đã thanh toán', 352000),
    ('HD2302130001', 'NV003', 'KH0000009',NULL, '2023-02-13 16:00:00', N'Đã thanh toán', 50000),
	('HD2302150001', 'NV004', 'KH0000002',NULL, '2023-02-15 10:30:00', N'Đã thanh toán', 120000),

    ('HD2303100001', 'NV002', 'KH0000010',NULL, '2023-03-10 11:15:00', N'Đã thanh toán', 100000),
    ('HD2303280001', 'NV003', 'KH0000011',NULL, '2023-03-28 16:45:00', N'Đã thanh toán', 150000),

    ('HD2304010001', 'NV002', 'KH0000012',NULL, '2023-04-01 14:20:00', N'Đã thanh toán', 200000),
    ('HD2304030001', 'NV002', 'KH0000013',NULL, '2023-04-03 16:00:00', N'Đã thanh toán', 100000),
	('HD2304050001', 'NV002', 'KH0000006',NULL, '2023-04-05 10:30:00', N'Đã thanh toán', 100000),

    ('HD2305020001', 'NV002', 'KH0000001','KM002', '2023-05-02 11:15:00', N'Đã thanh toán', 100000),
    ('HD2305020002', 'NV002', 'KH0000014','KM002', '2023-05-02 16:45:00', N'Đã thanh toán', 50000),
    ('HD2305100001', 'NV003', 'KH0000015','KM002', '2023-05-10 14:20:00', N'Đã thanh toán', 500000),
    ('HD2305130001', 'NV003', 'KH0000016','KM002', '2023-05-13 16:00:00', N'Đã thanh toán', 1000000),

	('HD2306010001', 'NV002', 'KH0000017',NULL, '2023-06-01 14:20:00', N'Đã thanh toán', 200000),
    ('HD2306020001', 'NV004', 'KH0000018',NULL, '2023-06-02 16:00:00', N'Đã thanh toán', 100000),
	('HD2306020002', 'NV004', 'KH0000004',NULL, '2023-06-02 16:05:00', N'Đã thanh toán', 300000),
    ('HD2306020003', 'NV004', 'KH0000019',NULL, '2023-06-02 16:10:00', N'Đã thanh toán', 100000),
    ('HD2306050001', 'NV002', 'KH0000020',NULL, '2023-06-05 17:00:00', N'Đã thanh toán', 50000),
    ('HD2306100001', 'NV003', 'KH0000001',NULL, '2023-06-10 14:20:00', N'Đã thanh toán', 500000),
    ('HD2306130001', 'NV003', 'KH0000020',NULL, '2023-06-13 16:00:00', N'Đã thanh toán', 50000),

	('HD2309100001', 'NV005', 'KH0000015',NULL, '2023-09-10 14:20:00', N'Đã thanh toán', 400000),
    ('HD2309130001', 'NV005', 'KH0000016',NULL, '2023-09-13 16:00:00', N'Đã thanh toán', 1000000),

	('HD2310020001', 'NV004', 'KH0000018',NULL, '2023-10-02 16:00:00', N'Đã thanh toán', 100000),
	('HD2310050001', 'NV004', 'KH0000004',NULL, '2023-10-05 16:05:00', N'Đã thanh toán', 300000),
    ('HD2310220001', 'NV004', 'KH0000019',NULL, '2023-10-22 16:10:00', N'Đã thanh toán', 100000),
    ('HD2310230001', 'NV002', 'KH0000003',NULL, '2023-10-23 17:00:00', N'Đã thanh toán', 200000),
    ('HD2310230002', 'NV003', 'KH0000001',NULL, '2023-10-23 14:20:00', N'Đã thanh toán', 500000),
    ('HD2310250001', 'NV003', 'KH0000002',NULL, '2023-10-25 16:00:00', N'Đã thanh toán', 50000);

INSERT INTO CHITIETHOADONBAN (MAHOADONBAN, MASANPHAM, SOLUONG, THANHTIEN)
VALUES
    ('HD2301250001', 'S0001', 1, 45000),
    ('HD2301250001', 'S0021', 1, 55000),
    ('HD2301280001', 'S0003', 1, 80000),
	('HD2301280002', 'S0003', 1, 80000),
	('HD2301280002', 'S0004', 2, 60000),

	('HD2302010001', 'S0005', 3, 170000),
	('HD2302020001', 'S0004', 1, 30000),
    ('HD2302020001', 'S0008', 1, 35000),
    ('HD2302020002', 'VPP0003', 1, 80000),
	('HD2302020003', 'VPP0005', 1, 82000),
	('HD2302020004', 'S0008', 2, 30000),
	('HD2302100001', 'S0001', 1, 45000),
    ('HD2302100001', 'S0021', 1, 55000),
    ('HD2302100001', 'S0003', 3, 80000),
	('HD2302100001', 'S0010', 1, 80000),
	('HD2302130001', 'S0012', 1, 40000),
	('HD2302150001', 'S0005', 3, 70000),
	('HD2302150001', 'S0015', 3, 50000),

	('HD2303100001', 'S0017', 1, 40000),
    ('HD2303100001', 'S0008', 1, 4000),
    ('HD2303100001', 'VPP0003', 1, 30000),
	('HD2303280001', 'VPP0005', 1, 82000),
	('HD2303280001', 'S0031', 2, 30000),

	('HD2304010001', 'S0025', 1, 40000),
    ('HD2304030001', 'S0008', 1, 4000),
    ('HD2304030001', 'VPP0007', 1, 30000),
	('HD2304050001', 'VPP0009', 1, 82000),
	('HD2304050001', 'S0032', 2, 30000),

	('HD2305020001', 'S0034', 1, 100000),
    ('HD2305020002', 'VPP0012', 1, 80000),
    ('HD2305100001', 'VPP0013', 1, 30000),
	('HD2305100001', 'VPP0009', 3, 82000),
	('HD2305130001', 'S0034', 2, 30000),

	('HD2306010001', 'S0036', 1, 100000),
    ('HD2306020001', 'VPP0017', 2, 80000),
    ('HD2306020002', 'VPP0013', 1, 30000),
	('HD2306020002', 'VPP0009', 3, 82000),
	('HD2306020003', 'S0034', 2, 30000),

	('HD2306050001', 'S0025', 1, 100000),
    ('HD2306050001', 'VPP0016', 2, 80000),
    ('HD2306050001', 'VPP0012', 1, 30000),
	('HD2306100001', 'VPP0008', 3, 82000),
	('HD2306100001', 'S0030', 2, 30000),
	('HD2306130001', 'S0032', 1, 100000),
    ('HD2306130001', 'VPP0016', 2, 80000),
    ('HD2306130001', 'VPP0001', 1, 30000),
	('HD2306130001', 'VPP0002', 3, 82000),
	('HD2306130001', 'S0024', 2, 30000),

	('HD2309100001', 'VPP0003', 1, 30000),
	('HD2309130001', 'S0025', 3, 82000),
	('HD2309130001', 'S0017', 2, 30000),

	('HD2310020001', 'S0011', 1, 100000),
    ('HD2310020001', 'VPP0015', 2, 80000),
    ('HD2310050001', 'VPP0012', 1, 30000),
	('HD2310220001', 'VPP0008', 3, 82000),
	('HD2310220001', 'S0026', 2, 30000),
	('HD2310220001', 'S0008', 1, 100000),

    ('HD2310230001', 'VPP0016', 2, 80000),
    ('HD2310230001', 'VPP0008', 1, 30000),
	('HD2310230001', 'VPP0012', 3, 82000),
	('HD2310230002', 'S0022', 2, 30000),
	('HD2310250001', 'S0032', 2, 30000),
	('HD2310250001', 'S0028', 2, 30000);








    







