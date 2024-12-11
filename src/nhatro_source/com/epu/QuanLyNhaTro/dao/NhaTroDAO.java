package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.NhaTro;

import java.util.List;

public interface NhaTroDAO {
    List<NhaTro> getAllNhaTroByMaChuNha(int maChuNha);
    List<NhaTro> getAllNhaTro();
    void addNhaTro(int maChuNha, String diaChi, int soLuongPhong, String trangThai, String urlImage);
    void updateNhaTro(int maNhaTro, int maChuNha, String diaChi, int soLuongPhong, String trangThai, String urlImage);
    void deleteNhaTro(int maNhaTro);
    NhaTro getNhaTroByMaNhaTro(int maNhaTro);
}
