use final_QuanLyNhaTro

insert into DichVu(tenDichVu, giaDichVu, ghiChu) values
(N'Điện', 4000, N'Tính theo số'),
(N'Nước', 100000, N'Tính theo đầu người'),
(N'Internet', 200000, N'Tính theo phòng'),
(N'Đỗ xe', 50000, N'Tính theo số xe'),
(N'Thang máy', 100000, N'Tính theo phòng'),
(N'Vệ sinh', 10000, N'Tính theo đầu người')

insert into CoSoVatChat(tenCSVC, trangThai) values
(N'Điều hòa', N'Hoạt động'),
(N'Ti vi', N'Hoạt động'),
(N'Tủ lạnh', N'Hoạt động'),
(N'Máy giặt', N'Hoạt động'),
(N'Tủ quần áo', N'Hoạt động'),
(N'Bàn học', N'Hoạt động'),
(N'Bếp từ', N'Hoạt động')

insert into TaiKhoan (email, password, vaiTro) values 
('admin1@example.com', 'password1', N'Admin'),
('admin2@example.com', 'password2', N'Admin'),
('khach1@example.com', 'password3', N'Khách Thuê'),
('khach2@example.com', 'password4', N'Khách Thuê'),
('chunha1@example.com', 'password5', N'Chủ Nhà'),
('chunha2@example.com', 'password6', N'Chủ Nhà'),
('admin3@example.com', 'password7', N'Admin'),
('admin4@example.com', 'password8', N'Admin'),
('khach3@example.com', 'password9', N'Khách Thuê'),
('khach4@example.com', 'password10', N'Khách Thuê'),
('chunha3@example.com', 'password11', N'Chủ Nhà'),
('chunha4@example.com', 'password12', N'Chủ Nhà'),
('admin5@example.com', 'password13', N'Admin'),
('admin6@example.com', 'password14', N'Admin'),
('khach5@example.com', 'password15', N'Khách Thuê'),
('khach6@example.com', 'password16', N'Khách Thuê'),
('chunha5@example.com', 'password17', N'Chủ Nhà'),
('chunha6@example.com', 'password18', N'Chủ Nhà'),
('admin7@example.com', 'password19', N'Admin'),
('admin8@example.com', 'password20', N'Admin');

insert into Admin (maCCCD, tenAdmin, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan) values 
('123456789012', N'Trần Văn A', '1985-01-01', N'Nam', '0123456789', N'1 Nguyễn Thị Minh Khai', 1),
('123456789013', N'Nguyễn Thị B', '1980-02-02', N'Nữ', '0123456790', N'2 Trần Hưng Đạo', 2),
('123456789014', N'Nguyễn Văn C', '1990-03-03', N'Nam', '0123456791', N'3 Lê Lợi', 3),
('123456789015', N'Nguyễn Thị D', '1992-04-04', N'Nữ', '0123456792', N'4 Phan Đình Phùng', 4),
('123456789016', N'Trần Văn E', '1988-05-05', N'Nam', '0123456793', N'5 Đinh Tiên Hoàng', 5),
('123456789017', N'Nguyễn Thị F', '1984-06-06', N'Nữ', '0123456794', N'6 Hàng Bài', 6),
('123456789018', N'Trần Văn G', '1979-07-07', N'Nam', '0123456795', N'7 Bến Thành', 7),
('123456789019', N'Nguyễn Thị H', '1982-08-08', N'Nữ', '0123456796', N'8 Phan Chu Trinh', 8),
('123456789020', N'Nguyễn Văn I', '1995-09-09', N'Nam', '0123456797', N'9 Lê Duẩn', 9),
('123456789021', N'Nguyễn Thị J', '1981-10-10', N'Nữ', '0123456798', N'10 Hàng Đào', 10),
('123456789022', N'Trần Văn K', '1994-11-11', N'Nam', '0123456799', N'11 Ngô Quyền', 11),
('123456789023', N'Nguyễn Thị L', '1983-12-12', N'Nữ', '0123456700', N'12 Lê Văn Sĩ', 12),
('123456789024', N'Trần Văn M', '1996-01-01', N'Nam', '0123456701', N'13 Lê Lợi', 13),
('123456789025', N'Nguyễn Thị N', '1991-02-02', N'Nữ', '0123456702', N'14 Trần Quốc Toản', 14),
('123456789026', N'Nguyễn Văn O', '1987-03-03', N'Nam', '0123456703', N'15 Nguyễn Thái Học', 15),
('123456789027', N'Nguyễn Thị P', '1986-04-04', N'Nữ', '0123456704', N'16 Hàm Nghi', 16),
('123456789028', N'Trần Văn Q', '1993-05-05', N'Nam', '0123456705', N'17 Hàng Bông', 17),
('123456789029', N'Nguyễn Thị R', '1998-06-06', N'Nữ', '0123456706', N'18 Đinh Tiên Hoàng', 18),
('123456789030', N'Trần Văn S', '1999-07-07', N'Nam', '0123456707', N'19 Bùi Viện', 19),
('123456789031', N'Nguyễn Thị T', '2000-08-08', N'Nữ', '0123456708', N'20 Trần Hưng Đạo', 20);

insert into KhachThue (maCCCD, tenKhach, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan) values 
('123456789032', N'Lê Văn U', '1995-01-01', N'Nam', '0123456709', N'21 Nguyễn Thị Minh Khai', 3),
('123456789033', N'Trần Thị V', '1997-02-02', N'Nữ', '0123456710', N'22 Trần Hưng Đạo', 4),
('123456789034', N'Nguyễn Văn X', '1990-03-03', N'Nam', '0123456711', N'23 Lê Lợi', 5),
('123456789035', N'Nguyễn Thị Y', '1989-04-04', N'Nữ', '0123456712', N'24 Phan Đình Phùng', 6),
('123456789036', N'Trần Văn Z', '1988-05-05', N'Nam', '0123456713', N'25 Đinh Tiên Hoàng', 7),
('123456789037', N'Nguyễn Thị A1', '1992-06-06', N'Nữ', '0123456714', N'26 Hàng Bài', 8),
('123456789038', N'Nguyễn Văn B2', '1991-07-07', N'Nam', '0123456715', N'27 Bến Thành', 9),
('123456789039', N'Trần Thị C3', '1990-08-08', N'Nữ', '0123456716', N'28 Phan Chu Trinh', 10),
('123456789040', N'Lê Văn D4', '1995-09-09', N'Nam', '0123456717', N'29 Lê Duẩn', 11),
('123456789041', N'Nguyễn Thị E5', '1997-10-10', N'Nữ', '0123456718', N'30 Hàng Đào', 12),
('123456789042', N'Trần Văn F6', '1992-11-11', N'Nam', '0123456719', N'31 Ngô Quyền', 13),
('123456789043', N'Nguyễn Thị G7', '1983-12-12', N'Nữ', '0123456720', N'32 Lê Văn Sĩ', 14),
('123456789044', N'Lê Văn H8', '1988-01-01', N'Nam', '0123456721', N'33 Lê Lợi', 15),
('123456789045', N'Nguyễn Thị I9', '1996-02-02', N'Nữ', '0123456722', N'34 Trần Quốc Toản', 16),
('123456789046', N'Nguyễn Văn J0', '1994-03-03', N'Nam', '0123456723', N'35 Nguyễn Thái Học', 17),
('123456789047', N'Trần Thị K1', '1985-04-04', N'Nữ', '0123456724', N'36 Hàm Nghi', 18),
('123456789048', N'Nguyễn Văn L2', '1982-05-05', N'Nam', '0123456725', N'37 Hàng Bông', 19),
('123456789049', N'Nguyễn Thị M3', '1999-06-06', N'Nữ', '0123456726', N'38 Đinh Tiên Hoàng', 20);

insert into ChuNha (maCCCD, tenChuNha, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan) values 
('123456789050', N'Lê Văn N', '1985-01-01', N'Nam', '0123456727', N'39 Nguyễn Thị Minh Khai', 3),
('123456789051', N'Trần Thị O', '1990-02-02', N'Nữ', '0123456728', N'40 Trần Hưng Đạo', 4),
('123456789052', N'Nguyễn Văn P', '1987-03-03', N'Nam', '0123456729', N'41 Lê Lợi', 5),
('123456789053', N'Nguyễn Thị Q', '1989-04-04', N'Nữ', '0123456730', N'42 Phan Đình Phùng', 6),
('123456789054', N'Trần Văn R', '1988-05-05', N'Nam', '0123456731', N'43 Đinh Tiên Hoàng', 7),
('123456789055', N'Nguyễn Thị S', '1986-06-06', N'Nữ', '0123456732', N'44 Hàng Bài', 8),
('123456789056', N'Lê Văn T', '1994-07-07', N'Nam', '0123456733', N'45 Bến Thành', 9),
('123456789057', N'Nguyễn Thị U', '1993-08-08', N'Nữ', '0123456734', N'46 Phan Chu Trinh', 10),
('123456789058', N'Nguyễn Văn V', '1991-09-09', N'Nam', '0123456735', N'47 Lê Duẩn', 11),
('123456789059', N'Nguyễn Thị W', '1980-10-10', N'Nữ', '0123456736', N'48 Hàng Đào', 12),
('123456789060', N'Lê Văn X', '1985-11-11', N'Nam', '0123456737', N'49 Ngô Quyền', 13),
('123456789061', N'Nguyễn Thị Y', '1992-12-12', N'Nữ', '0123456738', N'50 Lê Văn Sĩ', 14),
('123456789062', N'Trần Văn Z', '1989-01-01', N'Nam', '0123456739', N'51 Lê Lợi', 15),
('123456789063', N'Nguyễn Văn A1', '1997-02-02', N'Nam', '0123456740', N'52 Trần Quốc Toản', 16),
('123456789064', N'Nguyễn Thị B2', '1988-03-03', N'Nữ', '0123456741', N'53 Nguyễn Thái Học', 17),
('123456789065', N'Lê Văn C3', '1984-04-04', N'Nam', '0123456742', N'54 Hàm Nghi', 18),
('123456789066', N'Nguyễn Thị D4', '1986-05-05', N'Nữ', '0123456743', N'55 Hàng Bông', 19),
('123456789067', N'Nguyễn Văn E5', '1993-06-06', N'Nam', '0123456744', N'56 Đinh Tiên Hoàng', 20);

INSERT INTO NhaTro(maChuNha, diaChi, soLuongPhong, trangThai, urlImage) VALUES 
(1, N'Số 54 đường 427, Huyện Thường Tín', 20, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(1, N'Số 123 Đường Nguyễn Trãi, Quận Thanh Xuân', 10, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(2, N'Số 456 Đường Láng, Quận Đống Đa', 15, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(3, N'Số 789 Đường Hoàng Quốc Việt, Quận Cầu Giấy', 20, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(4, N'Số 101 Đường Trần Duy Hưng, Quận Cầu Giấy', 12, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(5, N'Số 202 Đường Kim Mã, Quận Ba Đình', 8, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(6, N'Số 303 Đường Nguyễn Thị Định, Quận Thanh Xuân', 10, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(7, N'Số 404 Đường Xuân Thủy, Quận Cầu Giấy', 5, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(8, N'Số 505 Đường Bạch Mai, Quận Hai Bà Trưng', 18, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(9, N'Số 606 Đường Đê La Thành, Quận Đống Đa', 9, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(10, N'Số 707 Đường Thanh Niên, Quận Tây Hồ', 7, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(11, N'Số 808 Đường Thái Hà, Quận Đống Đa', 14, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(12, N'Số 909 Đường Trần Khát Chân, Quận Hai Bà Trưng', 11, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(13, N'Số 121 Đường Hoàng Mai, Quận Hoàng Mai', 16, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(14, N'Số 131 Đường Kim Liên, Quận Đống Đa', 8, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(15, N'Số 141 Đường Lê Đức Thọ, Quận Nam Từ Liêm', 13, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(16, N'Số 151 Đường Hoàng Cầu, Quận Đống Đa', 10, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(17, N'Số 161 Đường Trường Chinh, Quận Thanh Xuân', 5, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png'),
(18, N'Số 171 Đường Đại Cồ Việt, Quận Hai Bà Trưng', 20, N'Đang hoạt động', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home.png')

INSERT INTO KieuPhong(loaiPhong, dienTich, giaPhong) VALUES
(N'Phòng đơn', 20, 2000000),
(N'Phòng đôi', 30, 3000000),
(N'Phòng ba', 40, 4000000),
(N'Phòng có bếp', 35, 3500000),
(N'Phòng VIP', 50, 5000000),
(N'Phòng tập thể', 25, 1500000),
(N'Phòng có ban công', 30, 3200000),
(N'Phòng có máy lạnh', 30, 2800000),
(N'Phòng có view đẹp', 45, 4500000),
(N'Phòng có dịch vụ dọn dẹp', 30, 3600000),
(N'Phòng không có nội thất', 20, 1200000),
(N'Phòng có toilet riêng', 25, 2700000),
(N'Phòng đầy đủ nội thất', 35, 4000000),
(N'Phòng có bồn tắm', 40, 3800000),
(N'Phòng có tủ lạnh', 30, 2900000),
(N'Phòng có bàn làm việc', 30, 3100000),
(N'Phòng có máy sưởi', 25, 2600000),
(N'Phòng có điều hòa không khí', 40, 4200000),
(N'Phòng có tivi', 35, 3000000),
(N'Phòng có cửa sổ lớn', 30, 3500000);

INSERT INTO Phong(tenPhong, maKieuPhong, maNhaTro, urlImage, trangThai) VALUES
(N'Phòng 1A', 1, 6, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 1B', 1, 6, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 1C', 2, 6, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 1D', 3, 6, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 1E', 4, 6, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 1F', 5, 6, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 2A', 1, 7, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 2B', 2, 7, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 2C', 3, 7, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 2D', 4, 7, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 2E', 5, 7, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 3A', 1, 3, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 3B', 2, 3, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 3C', 3, 3, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 3D', 4, 3, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 3E', 5, 3, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 4A', 1, 4, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 4B', 2, 4, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 4C', 3, 4, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê'),
(N'Phòng 4D', 4, 4, 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png', N'Chưa thuê');

INSERT INTO HopDong(maPhong, maKhachThue, tienCoc, ngayThue, thoiHanHopDong, trangThai) VALUES
(4, 5, 3000000, N'2024-05-01', 6, N'Còn hiệu lực'),
(5, 1, 1000000, N'2024-06-01', 6, N'Còn hiệu lực'),
(6, 2, 2000000, N'2024-07-01', 12, N'Còn hiệu lực'),
(7, 3, 2500000, N'2024-08-01', 12, N'Còn hiệu lực'),
(8, 4, 1500000, N'2024-09-01', 12, N'Còn hiệu lực'),
(9, 5, 3500000, N'2024-10-01', 12, N'Còn hiệu lực'),
(10, 1, 4000000, N'2024-11-01', 12, N'Còn hiệu lực'),
(11, 2, 5000000, N'2024-12-01', 12, N'Còn hiệu lực'),
(12, 3, 6000000, N'2025-01-01', 12, N'Còn hiệu lực'),
(13, 4, 7000000, N'2025-02-01', 12, N'Còn hiệu lực'),
(14, 5, 8000000, N'2025-03-01', 12, N'Còn hiệu lực'),
(15, 1, 9000000, N'2025-04-01', 12, N'Còn hiệu lực'),
(16, 2, 10000000, N'2025-05-01', 12, N'Còn hiệu lực'),
(17, 3, 11000000, N'2025-06-01', 12, N'Còn hiệu lực'),
(18, 4, 12000000, N'2025-07-01', 12, N'Còn hiệu lực'),
(19, 5, 13000000, N'2025-08-01', 12, N'Còn hiệu lực');
DBCC CHECKIDENT ('HopDong', RESEED, 1);

delete from HopDong
-- Phòng đơn (maKieuPhong = 1)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 1, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 1, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 1, N'Tủ lạnh');

-- Phòng đôi (maKieuPhong = 2)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 2, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 2, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (4, 2, N'Máy giặt');

-- Phòng ba (maKieuPhong = 3)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 3, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 3, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 3, N'Tủ quần áo');

-- Phòng có bếp (maKieuPhong = 4)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (7, 4, N'Bếp từ');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 4, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (6, 4, N'Bàn học');

-- Phòng VIP (maKieuPhong = 5)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 5, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 5, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (4, 5, N'Máy giặt');

-- Phòng tập thể (maKieuPhong = 6)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (6, 6, N'Bàn học');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 6, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 6, N'Tủ quần áo');

-- Phòng có ban công (maKieuPhong = 7)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 7, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 7, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (6, 7, N'Bàn học');

-- Phòng có máy lạnh (maKieuPhong = 8)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 8, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 8, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 8, N'Tủ quần áo');
-- Phòng có view đẹp (maKieuPhong = 9)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 9, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 9, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 9, N'Tủ quần áo');

-- Phòng có dịch vụ dọn dẹp (maKieuPhong = 10)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (4, 10, N'Máy giặt');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 10, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 10, N'Máy lạnh');

-- Phòng không có nội thất (maKieuPhong = 11)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (6, 11, N'Bàn học');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 11, N'Tủ quần áo');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 11, N'Tủ lạnh');

-- Phòng có toilet riêng (maKieuPhong = 12)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 12, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 12, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (7, 12, N'Bếp từ');

-- Phòng đầy đủ nội thất (maKieuPhong = 13)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 13, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 13, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 13, N'Tủ quần áo');

-- Phòng có bồn tắm (maKieuPhong = 14)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 14, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 14, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (4, 14, N'Máy giặt');

-- Phòng có tủ lạnh (maKieuPhong = 15)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 15, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 15, N'Tủ quần áo');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (6, 15, N'Bàn học');

-- Phòng có bàn làm việc (maKieuPhong = 16)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (6, 16, N'Bàn học');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 16, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 16, N'Máy lạnh');

-- Phòng có máy sưởi (maKieuPhong = 17)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 17, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (4, 17, N'Máy giặt');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 17, N'Tủ quần áo');

-- Phòng có điều hòa không khí (maKieuPhong = 18)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 18, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 18, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 18, N'Tủ lạnh');

-- Phòng có tivi (maKieuPhong = 19)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (2, 19, N'Tivi');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 19, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (4, 19, N'Máy giặt');

-- Phòng có cửa sổ lớn (maKieuPhong = 20)
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (1, 20, N'Máy lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (3, 20, N'Tủ lạnh');
INSERT INTO KieuPhong_CoSoVatChat (maCSVC, maKieuPhong, ghiChu) VALUES (5, 20, N'Tủ quần áo');


-- Thêm 20 hóa đơn
INSERT INTO HoaDon (maHopDong, tongTien, trangThai)
VALUES 
(2, 1000000, N'Chưa thanh toán'),
(3, 2000000, N'Chưa thanh toán'),
(4, 1500000, N'Chưa thanh toán'),
(5, 1750000, N'Chưa thanh toán'),
(6, 2100000, N'Chưa thanh toán'),
(7, 3000000, N'Chưa thanh toán'),
(8, 2500000, N'Chưa thanh toán'),
(9, 1800000, N'Chưa thanh toán'),
(10, 2200000, N'Chưa thanh toán'),
(11, 2700000, N'Chưa thanh toán'),
(12, 3500000, N'Chưa thanh toán'),
(13, 1200000, N'Chưa thanh toán'),
(14, 1900000, N'Chưa thanh toán'),
(15, 2400000, N'Chưa thanh toán'),
(16, 3100000, N'Chưa thanh toán'),
(17, 4000000, N'Chưa thanh toán'),
(2, 1500000, N'Chưa thanh toán'),
(3, 1800000, N'Chưa thanh toán'),
(4, 1300000, N'Chưa thanh toán'),
(5, 2500000, N'Chưa thanh toán');

-- Thêm chi tiết hóa đơn
-- Giả sử chúng ta có 20 hóa đơn với mã từ 1 đến 20 trong bảng HoaDon
INSERT INTO ChiTietHoaDon (maHoaDon, ghiChu)
VALUES 
(1, N'Chi tiết hóa đơn 1'),
(2, N'Chi tiết hóa đơn 2'),
(3, N'Chi tiết hóa đơn 3'),
(4, N'Chi tiết hóa đơn 4'),
(5, N'Chi tiết hóa đơn 5'),
(6, N'Chi tiết hóa đơn 6'),
(7, N'Chi tiết hóa đơn 7'),
(8, N'Chi tiết hóa đơn 8'),
(9, N'Chi tiết hóa đơn 9'),
(10, N'Chi tiết hóa đơn 10'),
(11, N'Chi tiết hóa đơn 11'),
(12, N'Chi tiết hóa đơn 12'),
(13, N'Chi tiết hóa đơn 13'),
(14, N'Chi tiết hóa đơn 14'),
(15, N'Chi tiết hóa đơn 15'),
(16, N'Chi tiết hóa đơn 16'),
(17, N'Chi tiết hóa đơn 17'),
(18, N'Chi tiết hóa đơn 18'),
(19, N'Chi tiết hóa đơn 19'),
(20, N'Chi tiết hóa đơn 20');

-- Thêm chi tiết dịch vụ cho các hóa đơn
INSERT INTO ChiTiet_DichVu (maChiTiet, maDichVu, ghiChu)
VALUES 
(1, 1, N'Dịch vụ cơ bản'),
(1, 2, N'Dịch vụ phụ trợ'),
(2, 3, N'Dịch vụ thuê xe'),
(2, 4, N'Dịch vụ vệ sinh'),
(3, 5, N'Dịch vụ bổ sung'),
(4, 6, N'Dịch vụ tiện ích'),
(5, 1, N'Dịch vụ cơ bản'),
(6, 2, N'Dịch vụ phụ trợ'),
(7, 3, N'Dịch vụ thuê xe'),
(8, 4, N'Dịch vụ vệ sinh'),
(9, 5, N'Dịch vụ bổ sung'),
(10, 6, N'Dịch vụ tiện ích'),
(11, 1, N'Dịch vụ cơ bản'),
(12, 2, N'Dịch vụ phụ trợ'),
(13, 3, N'Dịch vụ thuê xe'),
(14, 4, N'Dịch vụ vệ sinh'),
(15, 5, N'Dịch vụ bổ sung'),
(16, 6, N'Dịch vụ tiện ích'),
(17, 1, N'Dịch vụ cơ bản'),
(18, 2, N'Dịch vụ phụ trợ'),
(19, 3, N'Dịch vụ thuê xe'),
(20, 4, N'Dịch vụ vệ sinh');


-- Thêm chi tiết cơ sở vật chất cho các hóa đơn
INSERT INTO ChiTiet_CSVC (maChiTiet, maCSVC, ghiChu)
VALUES 
(1, 1, N'Sử dụng bàn ghế'),
(2, 2, N'Sử dụng giường'),
(3, 3, N'Sử dụng điều hòa'),
(4, 4, N'Trang bị tủ lạnh'),
(5, 5, N'Sử dụng TV'),
(6, 6, N'Sử dụng quạt'),
(7, 7, N'Trang bị máy giặt'),
(8, 1, N'Sử dụng bàn ghế'),
(9, 2, N'Sử dụng giường'),
(10, 3, N'Sử dụng điều hòa'),
(11, 4, N'Trang bị tủ lạnh'),
(12, 5, N'Sử dụng TV'),
(13, 6, N'Sử dụng quạt'),
(14, 7, N'Trang bị máy giặt'),
(15, 1, N'Sử dụng bàn ghế'),
(16, 2, N'Sử dụng giường'),
(17, 3, N'Sử dụng điều hòa'),
(18, 4, N'Trang bị tủ lạnh'),
(19, 5, N'Sử dụng TV'),
(20, 6, N'Sử dụng quạt');

-- Kiểm tra bảng HoaDon
SELECT * FROM HoaDon;

-- Kiểm tra bảng ChiTietHoaDon
SELECT * FROM ChiTietHoaDon;

-- Kiểm tra bảng ChiTiet_DichVu
SELECT * FROM ChiTiet_DichVu;

-- Kiểm tra bảng ChiTiet_CSVC
SELECT * FROM ChiTiet_CSVC;

delete from Phong -- xong
delete from TienThuTienIch -- xong
delete from HopDong -- xong
delete from HoaDon -- xong
delete from ChiTietHoaDon -- xong
delete from ChuNha -- xong
delete from NhaTro -- xong
delete from KhachThue -- xong
delete from DichVu -- xong
delete from ChiTiet_CSVC -- xong
delete from ChiTiet_CSVC -- xomg
delete from CoSoVatChat -- xong
delete from Admin -- xong
delete from TaiKhoan -- xong
delete from ThanhToan -- xong
delete from Phong_DichVu -- xong
delete from Phong_Khach -- xong
delete from KieuPhong -- xong
delete from KieuPhong_CoSoVatChat --- xong

DECLARE @sql NVARCHAR(MAX) = '';

-- Tìm các bảng có cột IDENTITY trong cơ sở dữ liệu
SELECT @sql = @sql + 
    'DBCC CHECKIDENT (''' + TABLE_SCHEMA + '.' + TABLE_NAME + ''', RESEED, 0);' + CHAR(13)
FROM INFORMATION_SCHEMA.TABLES
WHERE OBJECTPROPERTY(OBJECT_ID(TABLE_SCHEMA + '.' + TABLE_NAME), 'TableHasIdentity') = 1;

-- Thực thi lệnh Reseed cho từng bảng
EXEC sp_executesql @sql;

select * from Admin