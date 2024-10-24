package com.epu.QuanLyNhaTro.dao;

import java.time.LocalDate;

public interface KhachDAO {
    void addKhach(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan);
}
