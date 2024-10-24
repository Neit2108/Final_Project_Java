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
    private int maHopDong;
    private double soTien;
    private String hinhThucThanhToan;
    private String trangThai;
    private LocalDate ngayThanhToan;

    public String toString(){
        return "ThanhToan{" +
                "maThanhToan='" + maThanhToan + '\''
                + ", maHopDong='" + maHopDong + '\''
                + ", soTien='" + soTien + '\''
                + ", hinhThucThanhToan='" + hinhThucThanhToan + '\''
                + ", trangThai='" + trangThai + '\''
                + ", ngayThanhToan=" + ngayThanhToan
                + "}";
    }
}
