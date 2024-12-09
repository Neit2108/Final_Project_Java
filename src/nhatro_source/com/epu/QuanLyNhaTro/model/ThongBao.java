package com.epu.QuanLyNhaTro.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ThongBao {
    private int id;
    private int maNguoiGui;
    private int maNguoiNhan;
    private int maPhong;
    private String noiDung;
    private String trangThai;
    private LocalDate ngayTao;
    private String loaiThongBao;

    @Override
    public String toString() {
        return "ThongBao{" +
                "id=" + id +
                ", maNguoiGui=" + maNguoiGui +
                ", maNguoiNhan=" + maNguoiNhan +
                ", maPhong=" + maPhong +
                ", noiDung='" + noiDung + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", ngayTao=" + ngayTao +
                ", loaiThongBao='" + loaiThongBao + '\'' +
                '}';
    }
}
