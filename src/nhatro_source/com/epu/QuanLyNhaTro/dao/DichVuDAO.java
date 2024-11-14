package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.DichVu;

import java.util.List;

public interface DichVuDAO {
    void addDichVu(int maDichVu, String tenDichVu, String trangThai);
    void updateDichVu(int maDichVu, String tenDichVu, String trangThai);
    void deleteDichVu(int maDichVu);
    DichVu getDichVu(int maDichVu);
    List<DichVu> getAllDichVu();
}
