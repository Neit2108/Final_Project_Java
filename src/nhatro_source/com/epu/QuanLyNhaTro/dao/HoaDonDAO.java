package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.HoaDon;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HoaDonDAO {
    List<HoaDon> getAllHoaDon();
    List<HoaDon> getHoaDonByMaKhach(int maKhach);
    List<HoaDon> getHoaDonByMaNhaTro(int maNhaTro);
    boolean isCreatedHoaDon(Date date);
    void autoCreateHoaDon(int maChuNha, Date date);
    void deleteHoaDon(int maHoaDon);
}
