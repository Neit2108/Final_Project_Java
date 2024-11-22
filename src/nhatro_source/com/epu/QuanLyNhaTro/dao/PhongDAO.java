package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.Phong;

import java.util.List;

public interface PhongDAO {
    void addPhong(String tenPhong, int maKieuPhong, int maNhaTro, String urlImage);
    void updatePhong(int maPhong, String tenPhong, int maKieuPhong, int maNhaTro, String urlImage);
    void deletePhong(int maPhong);
    Phong getPhong(int maPhong);
    List<Phong> getAllPhong();
    double getGiaPhong(int maPhong);
    int getMaChuNha(int maPhong);
}
