create database final_QuanLyNhaTro
use final_QuanLyNhaTro

select * from TaiKhoan
delete from ThongBao where maNguoiGui = 26 or maNguoiNhan = 26
delete from TaiKhoan where maTaiKhoan = 26
delete from KhachThue where maTaiKhoan = 26

select * from Phong
create table TaiKhoan(
	maTaiKhoan int identity(1,1) unique,
	email varchar(255) primary key,
	password varchar(255) not null,
	vaiTro nvarchar(50) not null,
	ngayTao datetime default getdate(),
	constraint chk_taikhoan_vaitro check (vaiTro in (N'Admin', N'Khách Thuê', N'Chủ Nhà'))
)
alter table TaiKhoan add isFirstLogin bit default 1
select * from ChuNha where maTaiKhoan = 2
--Tài khoản quan hệ 1 - 1 với admin, khách và chủ
select * from TaiKhoan 
select * from HoaDon
select * from ChuNha where maTaiKhoan = 2
select * from HopDong where maKhachThue = 1
select * from KhachThue where maTaiKhoan = 25
select * from TaiKhoan
delete from TaiKhoan where maTaiKhoan = 24
select * from ThongBao
select * from Phong where maPhong = 38
select * from Phong p
join HopDong hd on hd.maPhong = p.maPhong
join KhachThue kt on kt.maKhachThue = hd.maKhachThue
where kt.maKhachThue = 1

SELECT HD.*
FROM HopDong HD
JOIN Phong P ON HD.maPhong = P.maPhong
JOIN NhaTro NT ON P.maNhaTro = NT.maNhaTro
WHERE NT.maChuNha = 10;

select * from ThongBao where maNguoiNhan = 10

select * from NhaTro_Phong where [Mã nhà trọ] = 1

select * from Phong
join NhaTro on Phong.maNhaTro = NhaTro.maNhaTro
where maChuNha = 10 and Phong.trangThai = N'Chưa thuê'

select * from Phong where maPhong = 23


select * from KieuPhong, KhachThue

insert into Phong(tenPhong, maKieuPhong, maNhaTro, trangThai, urlImage)
values 
(N'Phòng 13B', 13, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 11C', 11, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 14D', 14, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 20A', 20, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 19B', 19, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 9C', 9, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 7D', 7, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 6A', 6, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 8B', 8, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png')


(N'Phòng 7A', 2, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 5A', 4, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 5B', 2, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 5C', 3, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 5D', 1, 1, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 6A', 4, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 6C', 1, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 6B', 3, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png'),
(N'Phòng 6D', 2, 2, N'Chưa thuê', 'D:\MyProjects\final_QuanLyNhaTro\src\resources\home2.png')

insert into HopDong(maPhong, maKhachThue, tienCoc, ngayThue, thoiHanHopDong, trangThai, soNguoi)
values (21, 4, 2500000, GETDATE(), 6, N'Còn hiệu lực', 3),
(22, 6, 1500000, GETDATE(), 6, N'Còn hiệu lực', 1),
(23, 1, 500000, GETDATE(), 6, N'Còn hiệu lực', 2),
(24, 3, 3500000, GETDATE(), 6, N'Còn hiệu lực', 4),
(25, 2, 2000000, GETDATE(), 6, N'Còn hiệu lực', 1),
(26, 4, 1000000, GETDATE(), 6, N'Còn hiệu lực', 1),
(27, 7, 500000, GETDATE(), 6, N'Còn hiệu lực', 2),
(28, 5, 1200000, GETDATE(), 6, N'Còn hiệu lực', 3)

SELECT * FROM NhaTro WHERE maChuNha = 10
select * from HoaDon
join HopDong hd on HoaDon.maHopDong = hd.maHopDong
join Phong p on p.maPhong = hd.maPhong
where p.maNhaTro = 2 or p.maNhaTro = 1

SELECT DISTINCT KT.*
FROM ChuNha CN
JOIN NhaTro NT ON CN.maChuNha = NT.maChuNha
JOIN Phong P ON NT.maNhaTro = P.maNhaTro
JOIN HopDong HD ON P.maPhong = HD.maPhong
JOIN KhachThue KT ON HD.maKhachThue = KT.maKhachThue
WHERE CN.maChuNha = 10;


create table Admin(
	maAdmin int identity(1, 1) primary key,
	maCCCD varchar(20) not null unique,
	tenAdmin nvarchar(255) not null,
	ngaySinh date not null,
	gioiTinh nvarchar(20) not null check (gioiTinh in (N'Nam', N'Nữ')),
	soDienThoai varchar(15) not null unique,
	diaChi nvarchar(255) not null,
	maTaiKhoan int unique not null,
	constraint fk_admin_matk foreign key (maTaiKhoan) references TaiKhoan(maTaiKhoan),
	constraint chk_admin_sdt check (len(soDienThoai) = 10 and soDienThoai like '0[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
	constraint chk_admin_cccd check (len(maCCCD) = 12 or len(maCCCD) = 9)
)

create table KhachThue(
	maKhachThue int identity(1,1) primary key,
	maCCCD varchar(20) not null unique,
	tenKhach nvarchar(255) not null,
	ngaySinh date not null,
	gioiTinh nvarchar(20) not null check (gioiTinh in (N'Nam', N'Nữ')),
	soDienThoai varchar(15) not null unique,
	diaChi nvarchar(255) not null,
	maTaiKhoan int unique not null,
	constraint fk_khachthue_matk foreign key (maTaiKhoan) references TaiKhoan(maTaiKhoan),
	constraint chk_khach_sdt check (len(soDienThoai) = 10 and soDienThoai like '0[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	constraint chk_khach_cccd check (len(maCCCD) = 12)
)

create table ChuNha(
	maChuNha int identity(1,1) primary key,
	maCCCD varchar(20) not null unique,
	tenChuNha nvarchar(255) not null,
	ngaySinh date not null,
	gioiTinh nvarchar(20) not null check (gioiTinh in (N'Nam', N'Nữ')),
	soDienThoai varchar(15) not null unique,
	diaChi nvarchar(255) not null,
	maTaiKhoan int unique not null,
	constraint fk_chunha_matk foreign key (maTaiKhoan) references TaiKhoan(maTaiKhoan),
	constraint chk_chunha_sdt check ( len(soDienThoai) = 10 and soDienThoai like '0[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
	constraint chk_chunha_cccd check (len(maCCCD) = 12)
)

create table CoSoVatChat(
	maCSVC int identity(1,1) primary key,
	tenCSVC nvarchar(255) not null,
	trangThai nvarchar(255) not null
)

create table KieuPhong(
	maKieuPhong int identity(1,1) primary key,
	loaiPhong nvarchar(255) not null,
	dienTich decimal not null,
	giaPhong decimal not null,
	ngayTao datetime default getdate(),
	constraint chk_kieuphong_dientich check ( dienTich > 0),
	constraint chk_kieuphong_gia check (giaPhong > 0)
)
--trung gian giữa kiểu phòng và csvc (n - n)
create table KieuPhong_CoSoVatChat(
	maCSVC int not null,
	maKieuPhong int not null,
	ghiChu nvarchar(255) not null,
	primary key(maCSVC, maKieuPhong),
	constraint fk_trunggian_macsvc foreign key (maCSVC) references CoSoVatChat(maCSVC),
	constraint fk_trunggian_makieuphong foreign key (maKieuPhong) references KieuPhong(maKieuPhong)
)

create table NhaTro(
	maNhaTro int identity(1,1) primary key,
	maChuNha int not null,
	diaChi nvarchar(255) not null,
	soLuongPhong int not null,
	trangThai nvarchar(255) not null,
	urlImage varchar(255) not null,
	constraint fk_nhatro_machunha foreign key (maChuNha) references ChuNha(maChuNha),
	constraint chk_nhatro_soluong check (soLuongPhong > 0),
	constraint chk_nhatro_trangthai check (trangThai in ( N'Hoạt động', N'Không hoạt động'))
)
alter table NhaTro drop constraint chk_nhatro_trangthai
alter table NhaTro add constraint chk_nhatro_trangthai check (trangThai in ( N'Đang hoạt động', N'Không hoạt động'))
create table Phong(
	maPhong int identity(1,1) primary key,
	tenPhong nvarchar(255),
	maKieuPhong int not null,
	maNhaTro int not null,
	unique (tenPhong, maNhaTro),
	trangThai nvarchar(255) not null,
	urlImage varchar(255) not null,
	constraint fk_phong_makieuphong foreign key (maKieuPhong) references KieuPhong(maKieuPhong),
	constraint fk_phong_manhatro foreign key (maNhaTro) references NhaTro(maNhaTro),
	constraint chk_phong_trangthai check (trangThai in (N'Đã thuê', N'Chưa thuê', N'Không hoạt động'))
)

create table DichVu(
	maDichVu int identity(1,1) primary key,
	tenDichVu nvarchar(255) not null unique,
	giaDichVu decimal not null,
	trangThai nvarchar(255) not null,
	constraint chk_dichvu_gia check (giaDichVu > 0)
)
sp_rename 'DichVu.trangThai', 'ghiChu', 'COLUMN';

--Phòng quan hệ n - n với Dịch vụ
create table Phong_DichVu(
	maPhong int not null,
	maDichVu int not null,
	ghiChu nvarchar(255) not null,
	primary key(maPhong, maDichVu),
	constraint fk_trunggian_phong foreign key (maPhong) references Phong(maPhong),
	constraint fk_trunggian_dichvu foreign key (maDichVu) references DichVu(maDichVu)
)

--Phòng quan hệ n - n với khách
create table Phong_Khach(
	maPhong int not null,
	maKhachThue int not null,
	ghiChu nvarchar(255) not null,
	primary key(maPhong, maKhachThue),
	constraint fk_trunggian_khach_phong foreign key (maPhong) references Phong(maPhong),
	constraint fk_trunggian_phong_khach foreign key (maKhachThue) references KhachThue(maKhachThue)
)

create table HopDong(
	maHopDong int identity(1,1) primary key,
	maPhong int not null unique,
	maKhachThue int not null,
	tienCoc decimal not null,
	ngayThue date not null,
	thoiHanHopDong int not null, -- thời hạn ở tối thiểu
	trangThai nvarchar(255) not null,
	ngayTao datetime default getdate(),
	constraint fk_hopdong_makhach foreign key (maKhachThue) references KhachThue(maKhachThue),
	constraint fk_hopdong_phong foreign key (maPhong) references Phong(maPhong),
	constraint chk_hopdong_tiencoc check (tienCoc >= 0),
	constraint chk_hopdong_trangthai check ( trangThai in ( N'Còn hiệu lực', N'Hết hiệu lực')),
	constraint chk_hopdong_thoihan check ( thoiHanHopDong > 0)
)
alter table HopDong add soNguoi int not null default 1
alter table HopDong add constraint fk_hopdong_makhach foreign key (maKhachThue) references KhachThue(maKhachThue) on delete	cascade
select * from HoaDon
CREATE TABLE HoaDon (
    maHoaDon INT IDENTITY(1,1) PRIMARY KEY,
	maHopDong int not null,
    ngayTao DATETIME DEFAULT GETDATE() NOT NULL,
    tongTien DECIMAL(18,2) NOT NULL,
    trangThai NVARCHAR(255) NOT NULL,
	constraint chk_hoadon_tongtien check (tongTien >=0),
	constraint chk_hoadon_trangthai check ( trangThai in (N'Chưa thanh toán', N'Đã thanh toán', N'Quá hạn', N'Chờ xác nhận'))
);
alter table HoaDon add constraint fk_hoadon_hopdong foreign key (maHopDong) references HopDong(maHopDong)
ALTER TABLE HoaDon
ADD ngayThanhToan DATETIME NULL;

select * from ThongBao 

create table ChiTietHoaDon(
	maChiTiet int identity(1,1) primary key,
	maHoaDon int not null,
	ghiChu nvarchar(255),
	constraint fk_cthd_hopdong foreign key (maHoaDon) references HoaDon(maHoaDon)
)

create table ChiTiet_DichVu(
	maChiTiet int not null,
	maDichVu int not null,
	ghiChu nvarchar(255),
	primary key (maChiTiet, maDichVu),
	constraint fk_ctdv_chitiet foreign key (maChiTiet) references ChiTietHoaDon(maChiTiet),
	constraint fk_ctdv_dichvu foreign key (maDichVu) references DichVu(maDichVu)
)

create table ChiTiet_CSVC(
	maChiTiet int not null, 
	maCSVC int not null,
	ghiChu nvarchar(255),
	primary key (maChiTiet, maCSVC),
	constraint fk_ctcsvc_chitiet foreign key (maChiTiet) references ChiTietHoaDon(maChiTiet),
	constraint fk_ctcsvc_csvc foreign key (maCSVC) references CoSoVatChat(maCSVC)
)

CREATE TABLE TienThuTienIch (
	maTienThu int identity(1,1),
    maPhong INT NOT NULL,
    ngayGhiDien DATETIME DEFAULT GETDATE(),
    soDienCu decimal(10, 2) NOT NULL,    -- Số điện cũ
    soDienMoi decimal(10, 2) NOT NULL,   -- Số điện mới
    soDienDaDung AS (soDienMoi - soDienCu) PERSISTED, -- Số điện đã dùng 
    soNuocCu decimal(10, 2) NOT NULL,    -- Số nước cũ
    soNuocMoi decimal(10, 2) NOT NULL,   -- Số nước mới
    soNuocDaDung AS (soNuocMoi - soNuocCu) PERSISTED, -- Số nước đã dùng 
    PRIMARY KEY (maPhong, ngayGhiDien),
    FOREIGN KEY (maPhong) REFERENCES Phong(maPhong)
); 

create table ThongBao(
	id int identity(1,1) primary key,
	maNguoiGui int not null,
	maNguoiNhan int not null,
	noiDung nvarchar(255) not null,
	trangThai nvarchar(50) not null default N'Chưa xem',
	ngayTao datetime default getdate(),
	constraint chk_trangthai_thongbao check ( trangThai in ( N'Đã xem', N'Chưa xem')),
	constraint fk_nguoigui_thongbao foreign key (maNguoiGui) references TaiKhoan(maTaiKhoan),
	constraint fk_nguoinhan_thongbao foreign key (maNguoiNhan) references TaiKhoan(maTaiKhoan)
)
alter table ThongBao add constraint fk_maphong_thongbao foreign key (maPhong) references Phong(maPhong)
alter table ThongBao add loaiThongBao nvarchar(255)
select * from ThongBao
INSERT INTO TienThuTienIch (maPhong, soDienCu, soDienMoi, soNuocCu, soNuocMoi) VALUES
(21, 100.00, 150.00, 30.00, 50.00),
(22, 120.00, 170.00, 40.00, 60.00),
(23, 110.00, 160.00, 35.00, 55.00),
(24, 130.00, 180.00, 45.00, 65.00),
(25, 140.00, 190.00, 50.00, 70.00),
(26, 150.00, 200.00, 55.00, 75.00),
(27, 160.00, 210.00, 60.00, 80.00),
(28, 170.00, 220.00, 65.00, 85.00),
(1, 100.00, 150.00, 30.00, 50.00),
(2, 120.00, 170.00, 40.00, 60.00),
(3, 110.00, 160.00, 35.00, 55.00),
(4, 130.00, 180.00, 45.00, 65.00),
(5, 140.00, 190.00, 50.00, 70.00),
(6, 150.00, 200.00, 55.00, 75.00),
(7, 160.00, 210.00, 60.00, 80.00),
(8, 170.00, 220.00, 65.00, 85.00),
(9, 180.00, 230.00, 70.00, 90.00),
(10, 190.00, 240.00, 75.00, 95.00),
(11, 200.00, 250.00, 80.00, 100.00),
(12, 210.00, 260.00, 85.00, 105.00),
(13, 220.00, 270.00, 90.00, 110.00),
(14, 230.00, 280.00, 95.00, 115.00),
(15, 240.00, 290.00, 100.00, 120.00),
(16, 250.00, 300.00, 105.00, 125.00),
(17, 260.00, 310.00, 110.00, 130.00),
(18, 270.00, 320.00, 115.00, 135.00),
(19, 280.00, 330.00, 120.00, 140.00),
(20, 290.00, 340.00, 125.00, 145.00);

select * from TienThuTienIch
create table ThanhToan(
	maThanhToan int identity(1,1) primary key,
	maHoaDon int not null,
	soTien decimal not null,
	hinhThucThanhToan nvarchar(50) not null,
	trangThai nvarchar(255) not null,
	ngayThanhToan date not null default getdate(),
	constraint chk_thanhtoan_hinhthuc check( hinhThucThanhToan in (N'Chuyển Khoản', N'Tiền Mặt', N'Thẻ')),
)
alter table ThanhToan
add constraint fk_thanhtoan_hoadon foreign key (maHoaDon) references HoaDon(maHoaDon)


--Xem chủ nhà này có những nhà nào
create view ChuNha_NhaTro as
select cn.maChuNha as N'Mã chủ nhà', cn.tenChuNha as N'Tên chủ nhà', nt.maNhaTro as N'Mã nhà trọ',
nt.diaChi as N'Địa chỉ', nt.soLuongPhong as N'Số lượng phòng', nt.trangThai as N'Trạng thái'
from ChuNha cn
join NhaTro nt on cn.maChuNha = nt.maChuNha

select * from ChuNha_NhaTro where [Mã chủ nhà] = 1;



--xem Nhà trọ này có những phòng nào
create view NhaTro_Phong as
select nt.maNhaTro as N'Mã nhà trọ', nt.diaChi as N'Địa chỉ', p.maPhong as N'Mã phòng', p.tenPhong as N'Tên phòng', kp.loaiPhong as N'Loại phòng'
from NhaTro nt
join Phong p on nt.maNhaTro = p.maNhaTro
join KieuPhong kp on p.maKieuPhong = kp.maKieuPhong

--xem gia  phong thuoc loai nao, gia bao nhieu
create view PhongView as
select maPhong, giaPhong, loaiPhong
from Phong
left join KieuPhong on Phong.maKieuPhong = KieuPhong.maKieuPhong

SELECT 
    p.maPhong AS N'Mã phòng',
    kp.loaiPhong AS N'Loại phòng',
    csvc.tenCSVC AS N'Tên cơ sở vật chất'
FROM 
    Phong p
JOIN 
    KieuPhong kp ON p.maKieuPhong = kp.maKieuPhong
JOIN 
    KieuPhong_CoSoVatChat kpcsvc ON kp.maKieuPhong = kpcsvc.maKieuPhong
JOIN 
    CoSoVatChat csvc ON kpcsvc.maCSVC = csvc.maCSVC;

select csvc.maCSVC from Phong
join KieuPhong on Phong.maKieuPhong = KieuPhong.maKieuPhong
join KieuPhong_CoSoVatChat kpcsvc on KieuPhong.maKieuPhong = kpcsvc.maKieuPhong
join CoSoVatChat csvc on kpcsvc.maCSVC = csvc.maCSVC
where maPhong = 4


--cập nhật trạng thái nếu thanh toán
CREATE TRIGGER trgThanhToanHoaDon
ON ThanhToan
AFTER INSERT
AS
BEGIN
    -- Cập nhật trạng thái và ngày thanh toán của hóa đơn
    UPDATE HoaDon
    SET 
        trangThai = N'Đã thanh toán',
        ngayThanhToan = (
            SELECT TOP 1 ngayThanhToan
            FROM ThanhToan
            WHERE ThanhToan.maHoaDon = HoaDon.maHoaDon
            ORDER BY ngayThanhToan DESC
        )
    WHERE maHoaDon IN (
        SELECT maHoaDon FROM Inserted
    )
      AND trangThai = N'Chưa thanh toán';
END;

CREATE TRIGGER trgCapNhatHoaDonQuaHan
ON HoaDon
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    UPDATE HoaDon
    SET trangThai = N'Quá hạn'
    WHERE trangThai = N'Chưa thanh toán' 
      AND DATEDIFF(DAY, ngayTao, GETDATE()) > 30;
END;

select * from HopDong

CREATE TRIGGER trg_UpdateRole
ON TaiKhoan
AFTER UPDATE
AS
BEGIN
    -- Chỉ xử lý khi vai trò thay đổi
    IF UPDATE(vaiTro)
    BEGIN
        DECLARE @maTaiKhoan INT, @vaiTro NVARCHAR(50);

        -- Lấy mã tài khoản và vai trò mới từ bản ghi vừa cập nhật
        SELECT @maTaiKhoan = INSERTED.maTaiKhoan, 
               @vaiTro = INSERTED.vaiTro
        FROM INSERTED;

        -- Nếu vai trò mới là 'Chủ Nhà'
        IF @vaiTro = N'Chủ Nhà'
        BEGIN
            -- Chuyển thông tin từ KhachThue sang ChuNha
            INSERT INTO ChuNha (maCCCD, tenChuNha, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan)
            SELECT maCCCD, tenKhach, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan
            FROM KhachThue
            WHERE maTaiKhoan = @maTaiKhoan;

            -- Xóa thông tin từ bảng KhachThue
            DELETE FROM KhachThue WHERE maTaiKhoan = @maTaiKhoan;
        END
        -- Nếu vai trò mới là 'Khách Thuê'
        ELSE IF @vaiTro = N'Khách Thuê'
        BEGIN
            -- Chuyển thông tin từ ChuNha sang KhachThue
            INSERT INTO KhachThue (maCCCD, tenKhach, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan)
            SELECT maCCCD, tenChuNha, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan
            FROM ChuNha
            WHERE maTaiKhoan = @maTaiKhoan;

            -- Xóa thông tin từ bảng ChuNha
            DELETE FROM ChuNha WHERE maTaiKhoan = @maTaiKhoan;
        END
    END
END;

-- Cập nhật trạng thái của phòng thành 'Đã thuê' cho những phòng đã có hợp đồng
UPDATE Phong
SET trangThai = N'Đã thuê'
WHERE maPhong IN (
    SELECT DISTINCT maPhong
    FROM HopDong
    WHERE trangThai = N'Còn hiệu lực'  -- Điều kiện hợp đồng còn hiệu lực
);

select * from Phong
BEGIN TRANSACTION;

-- Thêm hợp đồng vào bảng HopDong
INSERT INTO HopDong (maPhong, maKhachThue, tienCoc, ngayThue, thoiHanHopDong, trangThai)
VALUES (@maPhong, @maKhachThue, @tienCoc, @ngayThue, @thoiHanHopDong, N'Còn hiệu lực');

-- Cập nhật trạng thái của phòng thành 'Đã thuê'
UPDATE Phong
SET trangThai = N'Đã thuê'
WHERE maPhong = @maPhong;

COMMIT TRANSACTION;



select * from HoaDon where maHoaDon = 22;
UPDATE HoaDon
SET tongTien = (
    -- Tiền phòng (lấy từ KieuPhong qua maPhong từ Phong thông qua HopDong)
    (SELECT top 1 k.giaPhong
     FROM Phong p
     JOIN KieuPhong k ON p.maKieuPhong = k.maKieuPhong
     WHERE p.maPhong = (SELECT top 1 maPhong FROM HopDong WHERE maHopDong = HopDong.maHopDong))
	 +
	 200000
    + 
    -- Tiền tiện ích (tính từ TienThuTienIch)
    (SELECT top 1
        ((tp.soDienDaDung) * 4000) + -- Tiền điện
        ((tp.soNuocDaDung) * 30000)  -- Tiền nước
     FROM TienThuTienIch tp
     WHERE tp.maPhong = (SELECT top 1 maPhong FROM HopDong WHERE maHopDong = HopDong.maHopDong))
)
WHERE maHopDong IN (SELECT maHopDong FROM HopDong);

DECLARE @donGiaDien DECIMAL = 4000; -- Đơn giá điện
DECLARE @donGiaNuoc DECIMAL = 30000; -- Đơn giá nước
DECLARE @giaTienCuaNguoi DECIMAL = 100000;

UPDATE HoaDon 
SET tongTien = (
    -- Tiền phòng
    (SELECT k.giaPhong
     FROM Phong p
     JOIN KieuPhong k ON p.maKieuPhong = k.maKieuPhong
     WHERE p.maPhong = (SELECT maPhong FROM HopDong WHERE maHopDong = HoaDon.maHopDong))
	 + 100000 +
    -- Tiền theo số người (lấy từ bảng HopDong)
    (SELECT hd.soNguoi * @giaTienCuaNguoi
     FROM HopDong hd
     WHERE hd.maHopDong = HoaDon.maHopDong)
    + 
    -- Tiền tiện ích (tính từ TienThuTienIch)
    (SELECT 
        SUM((tp.soDienDaDung) * @donGiaDien) + -- Tiền điện
        SUM((tp.soNuocDaDung) * @donGiaNuoc)  -- Tiền nước
     FROM TienThuTienIch tp
     WHERE tp.maPhong = (SELECT maPhong FROM HopDong WHERE maHopDong = HoaDon.maHopDong))
)
WHERE HoaDon.maHopDong IN (SELECT maHopDong FROM HopDong);

 -- Cập nhật tổng tiền trong bảng HoaDon
CREATE TRIGGER trg_UpdateTongTien_TienThuTienIch
ON TienThuTienIch
AFTER INSERT, UPDATE
AS
BEGIN
    DECLARE @donGiaDien DECIMAL = 4000;  
    DECLARE @donGiaNuoc DECIMAL = 30000; 

   
    UPDATE h
    SET h.tongTien = (
        (SELECT k.giaPhong
         FROM Phong p
         JOIN KieuPhong k ON p.maKieuPhong = k.maKieuPhong
         WHERE p.maPhong = hd.maPhong)

        +
        (SELECT 
            SUM((tp.soDienDaDung) * @donGiaDien) + 
            SUM((tp.soNuocDaDung) * @donGiaNuoc)
         FROM TienThuTienIch tp
         WHERE tp.maPhong = hd.maPhong)

        +
        (hd.soNguoi * 100000)
    )
    FROM HoaDon h
    JOIN HopDong hd ON h.maHopDong = hd.maHopDong
    JOIN Inserted i ON i.maPhong = hd.maPhong;
END;

select * from TienThuTienIch
select * from HoaDon

ALTER PROCEDURE sp_TaoHoaDonTuDong
    @ngayGoc DATE = NULL, 
    @maChuNha INT -- Thêm tham số cho chủ nhà
AS
BEGIN
    DECLARE @donGiaDien DECIMAL(10, 2) = 4000;  
    DECLARE @donGiaNuoc DECIMAL(10, 2) = 30000;
    DECLARE @maHoaDon INT; -- Mã hóa đơn
    DECLARE @maChiTiet INT; -- Mã chi tiết hóa đơn
    DECLARE @maHopDong INT; -- Mã hợp đồng

    SET @ngayGoc = ISNULL(@ngayGoc, GETDATE());

    -- Bảng tạm để lưu mã hóa đơn và mã hợp đồng
    DECLARE @HoaDonTable TABLE (maHoaDon INT, maHopDong INT);

    -- Tạo hóa đơn và lưu vào bảng HoaDon, lấy mã hóa đơn và mã hợp đồng
    INSERT INTO HoaDon (maHopDong, tongTien, trangThai)
    OUTPUT INSERTED.maHoaDon, INSERTED.maHopDong INTO @HoaDonTable
    SELECT 
        hd.maHopDong,
        (
            ISNULL((SELECT k.giaPhong
                    FROM Phong p
                    JOIN KieuPhong k ON p.maKieuPhong = k.maKieuPhong
                    WHERE p.maPhong = hd.maPhong), 0)
            
            +
            
            ISNULL((SELECT SUM(tp.soDienDaDung * @donGiaDien) + SUM(tp.soNuocDaDung * @donGiaNuoc)
                    FROM TienThuTienIch tp
                    WHERE tp.maPhong = hd.maPhong
                    AND MONTH(tp.ngayGhiDien) = MONTH(@ngayGoc)
                    AND YEAR(tp.ngayGhiDien) = YEAR(@ngayGoc)), 0)
            
            +
            
            (hd.soNguoi * 100000)
        ) AS tongTien,
        N'Chưa thanh toán' AS trangThai
    FROM HopDong hd
    WHERE hd.trangThai = N'Còn hiệu lực'
      AND EXISTS ( -- Kiểm tra xem hợp đồng có thuộc chủ nhà hay không
          SELECT 1
          FROM Phong p
          JOIN NhaTro n ON p.maNhaTro = n.maNhaTro
          WHERE n.maChuNha = @maChuNha -- Kiểm tra chủ nhà
            AND hd.maPhong = p.maPhong
      )
      AND NOT EXISTS (
          SELECT 1 
          FROM HoaDon h
          WHERE h.maHopDong = hd.maHopDong
            AND MONTH(h.ngayTao) = MONTH(@ngayGoc)
            AND YEAR(h.ngayTao) = YEAR(@ngayGoc)
      );

    -- Lặp qua từng hóa đơn trong bảng @HoaDonTable và tạo chi tiết hóa đơn cho mỗi hóa đơn
    DECLARE @loop_maHoaDon INT, @loop_maHopDong INT;
    DECLARE cur CURSOR FOR
        SELECT maHoaDon, maHopDong
        FROM @HoaDonTable;
    
    OPEN cur;
    FETCH NEXT FROM cur INTO @loop_maHoaDon, @loop_maHopDong;
    
    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Tạo chi tiết hóa đơn cho mỗi hóa đơn
        INSERT INTO ChiTietHoaDon (maHoaDon, ghiChu)
        VALUES (@loop_maHoaDon, N'Chi tiết hóa đơn cho hợp đồng ' + CAST(@loop_maHoaDon AS NVARCHAR));

        -- Tạo chi tiết dịch vụ cho mỗi hóa đơn
        INSERT INTO ChiTiet_DichVu (maChiTiet, maDichVu, ghiChu)
        SELECT 
            @loop_maHoaDon, -- MaHoaDon cho chi tiết dịch vụ
            pd.maDichVu,
            N'Dịch vụ cho hợp đồng ' + CAST(@loop_maHopDong AS NVARCHAR)
        FROM HopDong hd
        JOIN Phong_DichVu pd ON hd.maPhong = pd.maPhong
        WHERE hd.trangThai = N'Còn hiệu lực'
          AND hd.maHopDong = @loop_maHopDong
          AND EXISTS ( -- Kiểm tra chủ nhà
              SELECT 1
              FROM Phong p
              JOIN NhaTro n ON p.maNhaTro = n.maNhaTro
              WHERE n.maChuNha = @maChuNha
                AND hd.maPhong = p.maPhong
          );

        -- Tạo chi tiết cơ sở vật chất cho mỗi hóa đơn
        INSERT INTO ChiTiet_CSVC (maChiTiet, maCSVC, ghiChu)
        SELECT 
            @loop_maHoaDon, -- MaHoaDon cho chi tiết cơ sở vật chất
            kpc.maCSVC,
            N'Cơ sở vật chất cho hợp đồng ' + CAST(@loop_maHopDong AS NVARCHAR)
        FROM HopDong hd
        JOIN Phong p ON hd.maPhong = p.maPhong
        JOIN KieuPhong k ON p.maKieuPhong = k.maKieuPhong
        JOIN KieuPhong_CoSoVatChat kpc ON k.maKieuPhong = kpc.maKieuPhong
        WHERE hd.trangThai = N'Còn hiệu lực'
          AND hd.maHopDong = @loop_maHopDong
          AND EXISTS ( -- Kiểm tra chủ nhà
              SELECT 1
              FROM Phong p
              JOIN NhaTro n ON p.maNhaTro = n.maNhaTro
              WHERE n.maChuNha = @maChuNha
                AND hd.maPhong = p.maPhong
          );

        FETCH NEXT FROM cur INTO @loop_maHoaDon, @loop_maHopDong;
    END;
    
    CLOSE cur;
    DEALLOCATE cur;
END;



select * from HoaDon where MONTH(ngayTao) = DATEADD(MONTH, 1, GETDATE()) and YEAR(ngayTao) = YEAR(getdate())
select * from HopDong
join NhaTro_Phong on NhaTro_Phong.[Mã phòng] = HopDong.maPhong
where NhaTro_Phong.[Mã nhà trọ] = 1 or NhaTro_Phong.[Mã nhà trọ] = 2
declare @ngayGoc date
declare @maChuNha int = 10;
EXEC sp_TaoHoaDonTuDong @ngayGoc, @maChuNha;
delete  from HoaDon
delete  from ChiTietHoaDon
delete  from ChiTiet_CSVC
delete  from ChiTiet_DichVu
select * from ThanhToan 
select * from HopDong
select * from HoaDon
select * from ThanhToan
select * from ChiTiet_CSVC
select * from ChiTiet_DichVu
select * from ChiTietHoaDon
DBCC CHECKIDENT ('ChiTietHoaDon', RESEED, 0);
select * from HoaDon where MONTH(ngayTao) = '01' and YEAR(ngayTao) = '2025'
select * from ChiTietHoaDon
select * from ChiTiet_CSVC
select * from ChiTiet_DichVu
select * from Phong_DichVu
select * from KieuPhong_CoSoVatChat

alter PROCEDURE sp_ThemTienDienNuocTuDong
    @maChuNha INT -- Thêm tham số cho chủ nhà
AS
BEGIN
    DECLARE @ngayHienTai DATE = GETDATE();
    DECLARE @thangTruoc DATE = DATEADD(MONTH, -1, @ngayHienTai);

    INSERT INTO TienThuTienIch (maPhong, ngayGhiDien, soDienCu, soDienMoi, soNuocCu, soNuocMoi)
    SELECT 
        p.maPhong,
        DATEADD(DAY, -DAY(@ngayHienTai) + 1, @ngayHienTai), 
        COALESCE(MAX(tt.soDienMoi), 0), 
        COALESCE(MAX(tt.soDienMoi), 0) + 50, 
        COALESCE(MAX(tt.soNuocMoi), 0), 
        COALESCE(MAX(tt.soNuocMoi), 0) + 10
    FROM Phong p
    LEFT JOIN TienThuTienIch tt ON p.maPhong = tt.maPhong
    WHERE (MONTH(tt.ngayGhiDien) = MONTH(@thangTruoc)
      AND YEAR(tt.ngayGhiDien) = YEAR(@thangTruoc)) 
      OR tt.ngayGhiDien IS NULL
      AND EXISTS ( -- Kiểm tra chủ nhà
          SELECT 1
          FROM HopDong hd
          WHERE hd.maPhong = p.maPhong
            AND EXISTS (
                SELECT 1
                FROM NhaTro n
                WHERE n.maChuNha = @maChuNha
                  AND n.maNhaTro = p.maNhaTro
            )
      )
    GROUP BY p.maPhong;
END;


select * from ChiTietHoaDon
delete from TienThuTienIch
select * from TienThuTienIch
declare @maChuNha int = 10
EXEC sp_ThemTienDienNuocTuDong @maChuNha;
select * from Phong

CREATE PROCEDURE sp_KiemTraHoaDonThang (@thang DATE)
AS
BEGIN
    -- Kiểm tra xem đã có hóa đơn cho tháng này chưa
    IF EXISTS (
        SELECT 1
        FROM HoaDon h
        WHERE MONTH(h.ngayTao) = MONTH(@thang)
          AND YEAR(h.ngayTao) = YEAR(@thang)
    )
    BEGIN
        -- Nếu đã có, trả về 1 (hoa đơn đã tạo)
        SELECT 1 AS HoaDonDaTao;
    END
    ELSE
    BEGIN
        -- Nếu chưa có, trả về 0 (hoa đơn chưa tạo)
        SELECT 0 AS HoaDonDaTao;
    END
END;

exec sp_KiemTraHoaDonThang '2025-01-01'

drop TRIGGER after_insert_hopdong
ON HopDong
FOR INSERT
AS
BEGIN
    -- Cập nhật trạng thái phòng thành 'Đã thuê' khi hợp đồng mới được thêm
    UPDATE Phong
    SET trangThai = 'Đã thuê'
    FROM Phong p
    INNER JOIN inserted i ON p.maPhong = i.maPhong;

	UPDATE Phong
    SET trangThai = 'Đã thuê'
    WHERE maPhong IN (SELECT DISTINCT maPhong FROM HopDong);
END;

select * from Phong where maPhong = 35
select * from HopDong where maPhong = 35