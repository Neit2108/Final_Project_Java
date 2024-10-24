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
public class HopDong {
    private int maHopDong;
    private int maPhong;
    private int maKhachThue;
    private double tienCoc;
    private LocalDate ngayThue;
    private LocalDate ngayDiDuKien;
    private LocalDateTime ngayTao;
    private String trangThai;

    public String toString(){
        return "HopDong{" +
                "maHopDong='" + maHopDong + '\''
                + ", maPhong='" + maPhong + '\''
                + ", maKhachThue='" + maKhachThue + '\''
                + ", tienCoc='" + tienCoc + '\''
                + ", ngayThue='" + ngayThue + '\''
                + ", ngayDiDuKien='" + ngayDiDuKien + '\''
                + ", ngayTao='" + ngayTao + '\''
                + ", trangThai='" + trangThai + '\''
                + "}";
    }
}
