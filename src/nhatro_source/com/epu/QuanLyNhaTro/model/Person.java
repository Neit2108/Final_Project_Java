package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class Person {
    protected String maCCCD;
    protected String ten;
    protected LocalDate ngaySinh;
    protected String gioiTinh;
    protected String soDienThoai;
    protected String diaChi;

}
