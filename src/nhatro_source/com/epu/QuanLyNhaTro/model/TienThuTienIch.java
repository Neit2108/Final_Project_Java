package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TienThuTienIch {
    private int maTienThu;
    private int maPhong;
    private LocalDate ngayThu;
    private double soDienCu;
    private double soDienMoi;
    private double soNuocCu;
    private double soNuocMoi;
    private double soDienDaDung;
    private double soNuocDaDung;
}
