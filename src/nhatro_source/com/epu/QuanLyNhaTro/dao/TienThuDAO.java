package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.TienThuTienIch;

import java.util.List;

public interface TienThuDAO {
    List<TienThuTienIch> getAll();
    TienThuTienIch getTienThu(int maTienThu);
}
