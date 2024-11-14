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
	--soNguoi int not null, --chú ý
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
	constraint chk_nhatro_soluong check (soLuongPhong > 0) 
)

create table Phong(
	maPhong int identity(1,1) primary key,
	tenPhong nvarchar(255),
	maKieuPhong int not null,
	maNhaTro int not null,
	unique (tenPhong, maNhaTro),
	urlImage varchar(255) not null,
	constraint fk_phong_makieuphong foreign key (maKieuPhong) references KieuPhong(maKieuPhong),
	constraint fk_phong_manhatro foreign key (maNhaTro) references NhaTro(maNhaTro)
)

create table DichVu(
	maDichVu int identity(1,1) primary key,
	tenDichVu nvarchar(255) not null unique,
	giaDichVu decimal not null,
	trangThai nvarchar(255) not null
)

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
	maPhong int not null,
	maKhachThue int not null,
	tienCoc decimal not null,
	ngayThue date not null,
	ngayDiDuKien date,
	trangThai nvarchar(255) not null,
	ngayTao datetime default getdate(),
	constraint fk_hopdong_makhach foreign key (maKhachThue) references KhachThue(maKhachThue),
	constraint fk_hopdong_phong foreign key (maPhong) references Phong(maPhong)
)

create table ThanhToan(
	maThanhToan int identity(1,1) primary key,
	maHopDong int not null,
	soTien decimal not null,
	hinhThucThanhToan nvarchar(50) not null,
	trangThai nvarchar(255) not null,
	ngayThanhToan date not null default getdate(),
	constraint fk_thanhtoan_hopdong foreign key (maHopDong) references HopDong(maHopDong),
	constraint chk_thanhtoan_hinhthuc check( hinhThucThanhToan in (N'Chuyển Khoản', N'Tiền Mặt', N'Thẻ')),
)

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

select * from NhaTro_Phong