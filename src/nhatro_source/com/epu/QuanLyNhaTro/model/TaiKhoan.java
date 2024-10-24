package com.epu.QuanLyNhaTro.model;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TaiKhoan {
    private int maTaiKhoan;
    private String email;
    private String password;
    private String vaiTro;
    private LocalDateTime ngayTao;

    public String toString(){
        return "TaiKhoan{" +
                "maTaiKhoan='" + maTaiKhoan + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", vaiTro='" + vaiTro + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                "}";
    }
}
