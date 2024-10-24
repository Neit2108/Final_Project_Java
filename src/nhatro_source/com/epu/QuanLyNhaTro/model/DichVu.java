package com.epu.QuanLyNhaTro.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class DichVu {
    private int maDichVu;
    private String tenDichVu;
    private String trangThai;

    public String toString(){
        return "DichVu{"
                + "maDichVu='" + maDichVu + '\''
                + ", tenDichVu='" + tenDichVu + '\''
                + ", trangThai='" + trangThai + '\''
                + "}";
    }
}
