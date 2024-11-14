package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.KieuPhong;

import java.util.List;

public interface KieuPhongDAO {
    void addKieuPhong(String loaiPhong, double dienTich, double giaPhong);
    void updateKieuPhong(int maKieuPhong, String loaiPhong, double dienTich, double giaPhong);
    void deleteKieuPhong(int maKieuPhong);
    KieuPhong getKieuPhong(int maKieuPhong);
    List<KieuPhong> getAllKieuPhong();
}
