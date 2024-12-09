package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.ChuNha;

import java.time.LocalDate;
import java.util.List;

public interface ChuNhaDAO {
    void addChuNha(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan);
    ChuNha getChuNhaByMa(int maChuNha);
    ChuNha getChuNhaByCCCD(String maCCCD);
    List<ChuNha> getAllChuNha();
    void updateChuNha(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan);
}
