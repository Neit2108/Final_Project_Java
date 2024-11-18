package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.KhachThue;

import java.time.LocalDate;
import java.util.List;

public interface KhachThueDAO {
    List<KhachThue> getAllKhachThue();
    KhachThue getKhachThue(String maCCCD);
    void addKhachThue(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan);
    void updateKhachThue(String maCCCD, String ten, String ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan);
    void deleteKhachThue(String maCCCD);
}
