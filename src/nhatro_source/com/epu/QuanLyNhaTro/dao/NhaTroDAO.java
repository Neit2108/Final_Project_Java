package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.NhaTro;

import java.util.List;

public interface NhaTroDAO {
    List<NhaTro> getAllNhaTroByMaChuNha(int maChuNha);
    List<NhaTro> getAllNhaTro();
}
