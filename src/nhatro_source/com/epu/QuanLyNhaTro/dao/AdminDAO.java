package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.Admin;

import java.time.LocalDate;
import java.util.List;


public interface AdminDAO {
    void addAdmin(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan);
    List<Admin> getAllAdmin();
    Admin getAdmin(String maCCCD);
    void updateAdmin(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maAdmin, int maTaiKhoan);
    void deleteAdmin(String maCCCD);
}
