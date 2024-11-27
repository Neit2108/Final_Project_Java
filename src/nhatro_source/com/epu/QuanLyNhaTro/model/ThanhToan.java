package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThanhToan {
    private int maThanhToan;
    private int maHoaDon;
    private double soTien;
    private String trangThai;
    private LocalDateTime ngayThanhToan;

}
