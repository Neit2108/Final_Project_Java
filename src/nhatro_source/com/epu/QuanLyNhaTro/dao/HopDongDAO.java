package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.HopDong;

import java.time.LocalDate;
import java.util.List;

public interface HopDongDAO {
    void addHopDong(int maHopDong, int maPhong, int maKhachThue, double tienCoc, LocalDate ngayThue, LocalDate ngayDiDuKien, LocalDate ngayTao, String trangThai);
    HopDong getHopDong(int maHopDong);
    List<HopDong> getAllHopDong();
    List<HopDong> getHopDongByMaKhach(int maKhach);
}
