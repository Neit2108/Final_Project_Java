package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor

public class KhachThue extends Person{
    private int maKhach;
    private int maTaiKhoan;

    public KhachThue(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maKhach, int maTaiKhoan) {
        super(maCCCD, ten, ngaySinh, gioiTinh, soDienThoai, diaChi);
        this.maKhach = maKhach;
        this.maTaiKhoan = maTaiKhoan;
    }

    public String toString(){
        return "KhachThue{" +
                "maCCCD='" + maCCCD + '\''
                + ", ten='" + ten + '\''
                + ", ngaySinh='" + ngaySinh + '\''
                + ", gioiTinh='" + gioiTinh + '\''
                + ", soDienThoai='" + soDienThoai + '\''
                + ", diaChi='" + diaChi + '\''
                + ", maKhach=" + maKhach
                + ", maTaiKhoan=" + maTaiKhoan
                + "}";
    }
}
