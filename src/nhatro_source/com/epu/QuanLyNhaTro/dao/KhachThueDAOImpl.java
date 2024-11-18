package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
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
        List<KhachThue> khachThueList = new ArrayList<>();
        String query = "select * from KhachThue";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                KhachThue khachThue = new KhachThue();
                khachThue.setMaKhach(rs.getInt("maKhachThue"));
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
        KhachThue khachThue = new KhachThue();
        String query = "select * from KhachThue where maCCCD = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setString(1, maCCCD);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                khachThue.setMaKhach(rs.getInt("maKhachThue"));
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

    @Override
    public void addKhachThue(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan) {
        String query = "insert into KhachThue(maCCCD, tenKhach, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan) values(?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setString(1, maCCCD);
            pstm.setString(2, ten);
            pstm.setDate(3, Date.valueOf(ngaySinh));
            pstm.setString(4, gioiTinh);
            pstm.setString(5, soDienThoai);
            pstm.setString(6, diaChi);
            pstm.setInt(7, maTaiKhoan);

            int i = pstm.executeUpdate();
            if (i == 1){
                connection.commit();
                System.out.println("Thêm thành công");
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateKhachThue(String maCCCD, String ten, String ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan) {
        String query = "update KhachThue set tenKhach = ?, ngaySinh = ?, gioiTinh = ?, soDienThoai = ?, diaChi = ?, maTaiKhoan = ? where maCCCD = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setString(1, ten);
            pstm.setString(2, ngaySinh);
            pstm.setString(3, gioiTinh);
            pstm.setString(4, soDienThoai);
            pstm.setString(5, diaChi);
            pstm.setInt(6, maTaiKhoan);
            pstm.setString(7, maCCCD);
            pstm.executeUpdate();
            connection.commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteKhachThue(String maCCCD) {
        String query = "delete from KhachThue where maCCCD = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setString(1, maCCCD);
            pstm.executeUpdate();
            connection.commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
