package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanDAO {
    void addTaiKhoan(String email, String password, String vaiTro);
    List<TaiKhoan> getAllTaiKhoan();
    TaiKhoan getTaiKhoan(int maTaiKhoan);
    TaiKhoan getTaiKhoan(String email);
    void updateTaiKhoan(String email, String vaiTro);
    void deleteTaiKhoan(String email);
    int getMaChuNha(int maTaiKhoan);
    int getMaKhachThue(int maTaiKhoan);
    int getMaAdmin(int maTaiKhoan);
    boolean checkLogin(String email);
    void updateLogin(String email);
}
