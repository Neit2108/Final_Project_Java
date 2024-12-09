package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.ThongBao;

import java.util.List;

public interface ThongBaoDAO {
    void addThongBao(int maNguoiGui, int maNguoiNhan, String noiDung, String trangThai, int maPhong, String loaiThongBao);
    List<ThongBao> getAllThongBao(int maNguoiNhan);
    void updateTrangThaiThongBao(int id);
    ThongBao getThongBao(int maThongBao);
    void deleteThongBao(int maThongBao);
    void deleteAllThongBao(int maNguoiNhan);
}
