package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.HopDong;

import java.time.LocalDate;
import java.util.List;

public interface HopDongDAO {
    void addHopDong(int maPhong, int maKhachThue, double tienCoc, LocalDate ngayThue, int thoiHanHopDong, String trangThai, int soNguoi);
    HopDong getHopDong(int maHopDong);
    List<HopDong> getAllHopDong();
    List<HopDong> getHopDongByMaKhach(int maKhach);
    List<HopDong> getHopDongByMaChuNha(int maChuNha);
}
