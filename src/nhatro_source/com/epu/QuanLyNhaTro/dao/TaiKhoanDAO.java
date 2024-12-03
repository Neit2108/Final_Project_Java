package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanDAO {
    void addTaiKhoan(String email, String password, String vaiTro);
    List<TaiKhoan> getAllTaiKhoan();
    TaiKhoan getTaiKhoan(String email);
    void updateTaiKhoan(String email, String vaiTro);
    void deleteTaiKhoan(String email);
}
