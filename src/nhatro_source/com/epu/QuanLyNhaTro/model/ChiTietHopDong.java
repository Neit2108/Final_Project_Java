package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHopDong {
    private int maChiTiet;
    private int maHopDong;
    private int maDichVu;
    private int maCSVC;
    private String ghiChu;
}
