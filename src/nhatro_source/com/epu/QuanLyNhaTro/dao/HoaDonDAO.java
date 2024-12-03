package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.HoaDon;

import java.util.List;

public interface HoaDonDAO {
    List<HoaDon> getAllHoaDon();
    List<HoaDon> getHoaDonByMaKhach(int maKhach);
}
