package com.epu.QuanLyNhaTro.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ChuNha extends Person{
    private int maChuNha;
    private int maTaiKhoan;

    public ChuNha(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maChuNha, int maTaiKhoan) {
        super(maCCCD, ten, ngaySinh, gioiTinh, soDienThoai, diaChi);
        this.maChuNha = maChuNha;
        this.maTaiKhoan = maTaiKhoan;
    }

    public String toString(){
        return "ChuNha{" +
                "maCCCD='" + maCCCD + '\''
                + ", ten='" + ten + '\''
                + ", ngaySinh='" + ngaySinh + '\''
                + ", gioiTinh='" + gioiTinh + '\''
                + ", soDienThoai='" + soDienThoai + '\''
                + ", diaChi='" + diaChi + '\''
                + ", maChuNha=" + maChuNha
                + ", maTaiKhoan=" + maTaiKhoan
                + "}";
    }
}
