package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phong {
    private int maPhong;
    private String tenPhong;
    private int maKieuPhong;
    private int maNhaTro;
    private String trangThai;
    private String urlImage;

    public String toString(){
        return "Phong{" +
                "maPhong='" + maPhong + '\''
                + ", tenPhong='" + tenPhong + '\''
                + ", maKieuPhong=" + maKieuPhong
                + ", maNhaTro=" + maNhaTro
                + ", urlImage='" + urlImage + '\''
                + "}";
    }
}
