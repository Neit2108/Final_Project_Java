package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class KhachThueDAOImpl implements KhachThueDAO {
    private final Connection connection;

    public KhachThueDAOImpl() {
        try{
            this.connection = DatabaseConnection.getConnection();
            this.connection.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KhachThue> getAllKhachThue() {
        List<KhachThue> khachThueList = null;
        String query = "select * from KhachThue";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                KhachThue khachThue = new KhachThue();
                khachThue.setMaKhach(rs.getInt("maKhach"));
                khachThue.setMaCCCD(rs.getString("maCCCD"));
                khachThue.setTen(rs.getString("tenKhach"));
                khachThue.setNgaySinh(rs.getDate("ngaySinh").toLocalDate());
                khachThue.setGioiTinh(rs.getString("gioiTinh"));
                khachThue.setSoDienThoai(rs.getString("soDienThoai"));
                khachThue.setDiaChi(rs.getString("diaChi"));
                khachThue.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
                khachThueList.add(khachThue);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return khachThueList;
    }

    @Override
    public KhachThue getKhachThue(String maCCCD) {
        KhachThue khachThue = null;
        String query = "select * from KhachThue where maCCCD = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setString(1, maCCCD);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                khachThue = new KhachThue();
                khachThue.setMaKhach(rs.getInt("maKhach"));
                khachThue.setMaCCCD(rs.getString("maCCCD"));
                khachThue.setTen(rs.getString("tenKhach"));
                khachThue.setNgaySinh(rs.getDate("ngaySinh").toLocalDate());
                khachThue.setGioiTinh(rs.getString("gioiTinh"));
                khachThue.setSoDienThoai(rs.getString("soDienThoai"));
                khachThue.setDiaChi(rs.getString("diaChi"));
                khachThue.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return khachThue;
    }

}
