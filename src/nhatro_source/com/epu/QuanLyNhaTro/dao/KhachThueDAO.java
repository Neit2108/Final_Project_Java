package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.KhachThue;

import java.util.List;

public interface KhachThueDAO {
    List<KhachThue> getAllKhachThue();
    KhachThue getKhachThue(String maCCCD);
}
