package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.CoSoVatChat;
import com.epu.QuanLyNhaTro.model.DichVu;
import com.epu.QuanLyNhaTro.model.Phong_DichVu;

import java.util.List;

public interface Phong_DichVu_DAO {
    //Phong_DichVu getAllPhong_DichVu(int maPhong);
    List<DichVu> getAllDichVuPhong(int maPhong);
    List<String> getAllTrangThaiPhong(int maPhong);
}
