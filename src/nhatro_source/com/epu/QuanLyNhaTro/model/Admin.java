package com.epu.QuanLyNhaTro.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class Admin extends Person{
    private int maAdmin;
    private int maTaiKhoan;

    public Admin(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maAdmin, int maTaiKhoan) {
        super(maCCCD, ten, ngaySinh, gioiTinh, soDienThoai, diaChi);
        this.maAdmin = maAdmin;
        this.maTaiKhoan = maTaiKhoan;
    }

    public String toString(){
        return "Admin{" +
                "maCCCD='" + maCCCD + '\''
                + ", ten='" + ten + '\''
                + ", ngaySinh='" + ngaySinh + '\''
                + ", gioiTinh='" + gioiTinh + '\''
                + ", soDienThoai='" + soDienThoai + '\''
                + ", diaChi='" + diaChi + '\''
                + ", maAdmin=" + maAdmin + '\''
                + ", maTaiKhoan=" + maTaiKhoan
                + "}";
    }
}
