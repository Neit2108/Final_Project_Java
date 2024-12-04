package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.ChuNha;

import java.time.LocalDate;

public interface ChuNhaDAO {
    void addChuNha(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan);
    ChuNha getChuNha(int maChuNha);
}
