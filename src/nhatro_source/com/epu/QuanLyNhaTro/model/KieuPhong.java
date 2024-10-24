package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class KieuPhong {
    private int maKieuPhong;
    private String loaiPhong;
    private double dienTich;
    private double giaPhong;
    private LocalDateTime ngayTao;

    public String toString(){
        return "KieuPhong{" +
                "maKieuPhong='" + maKieuPhong + '\''
                + ", loaiPhong='" + loaiPhong + '\''
                + ", dienTich=" + dienTich
                + ", giaPhong=" + giaPhong
                + ", ngayTao=" + ngayTao
                + "}";
    }

}
