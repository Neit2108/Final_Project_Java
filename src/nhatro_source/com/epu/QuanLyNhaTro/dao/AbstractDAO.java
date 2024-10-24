package com.epu.QuanLyNhaTro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public abstract class AbstractDAO {
    protected void insertPerson(Connection conn, String sql, String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan){
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maCCCD);
            ps.setString(2, ten);
            ps.setDate(3, Date.valueOf(ngaySinh));
            ps.setString(4, gioiTinh);
            ps.setString(5, soDienThoai);
            ps.setString(6, diaChi);
            ps.setInt(7, maTaiKhoan);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void updatePerson(Connection conn, String sql, String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maAdmin, int maTaiKhoan){
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maCCCD);
            ps.setString(2, ten);
            ps.setDate(3, Date.valueOf(ngaySinh));
            ps.setString(4, gioiTinh);
            ps.setString(5, soDienThoai);
            ps.setString(6, diaChi);
            ps.setInt(7, maTaiKhoan);
            ps.setInt(8, maAdmin);
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
