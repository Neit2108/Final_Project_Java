create database final_QuanLyNhaTro
use final_QuanLyNhaTro

create table TaiKhoan(
	maTaiKhoan int identity(1,1) unique,
	email varchar(255) primary key,
	password varchar(255) not null,
	vaiTro nvarchar(50) not null,
	ngayTao datetime default getdate(),
	constraint chk_taikhoan_vaitro check (vaiTro in (N'Admin', N'Khách Thuê', N'Chủ Nhà'))
)
--Tài khoản quan hệ 1 - 1 với admin, khách và chủ

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
	constraint chk_phong_trangthai check (trangThai in (N'Đã thuê', N'Chưa thuê'))
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

CREATE TABLE HoaDon (
    maHoaDon INT IDENTITY(1,1) PRIMARY KEY,
	maHopDong int not null,
    ngayTao DATETIME DEFAULT GETDATE() NOT NULL,
    tongTien DECIMAL(18,2) NOT NULL,
    trangThai NVARCHAR(255) NOT NULL,
	constraint chk_hoadon_tongtien check (tongTien >=0),
	constraint chk_hoadon_trangthai check ( trangThai in (N'Chưa thanh toán', N'Đã thanh toán', N'Quá hạn'))
);
alter table HoaDon add constraint fk_hoadon_hopdong foreign key (maHopDong) references HopDong(maHopDong)
ALTER TABLE HoaDon
ADD ngayThanhToan DATETIME NULL;

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

INSERT INTO TienThuTienIch (maPhong, soDienCu, soDienMoi, soNuocCu, soNuocMoi) VALUES
(21, 100.00, 150.00, 30.00, 50.00),
(22, 120.00, 170.00, 40.00, 60.00),
(23, 110.00, 160.00, 35.00, 55.00),
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
    UPDATE HoaDon
    SET trangThai = N'Đã thanh toán'
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


select * from Phong