package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhaTro {
    private int maNhaTro;
    private int maChuNha;
    private String diaChi;
    private int soLuongPhong;
    private String trangThai;
    private String urlImage;

    public String toString(){
        return "NhaTro{" +
                "maNhaTro='" + maNhaTro + '\''
                + ", maChuNha='" + maChuNha + '\''
                + ", diaChi='" + diaChi + '\''
                + ", soLuongPhong='" + soLuongPhong + '\''
                + ", trangThai='" + trangThai + '\''
                + ", urlImage='" + urlImage + '\''
                + "}";
    }
}
