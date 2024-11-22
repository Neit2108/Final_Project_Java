package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {
    private int maHoaDon;
    private int maHopDong;
    private double tongTien;
    private LocalDate ngayTao;
    private LocalDate ngayThanhToan;
    private String trangThai;
}
