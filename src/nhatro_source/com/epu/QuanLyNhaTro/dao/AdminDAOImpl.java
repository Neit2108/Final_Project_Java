package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.Admin;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl extends AbstractDAO implements AdminDAO{
    private final Connection conn;

    public AdminDAOImpl() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
        this.conn.setAutoCommit(false);
    }
    @Override
    public void addAdmin(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan) {
        String sql = "INSERT INTO admin(maCCCD, tenAdmin, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan) VALUES(?,?,?,?,?,?,?)";
        insertPerson(conn, sql, maCCCD, ten, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan);
    }

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> admins = new ArrayList<Admin>();
        String sql = "SELECT * FROM admin";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setMaAdmin(rs.getInt("maAdmin"));
                admin.setMaCCCD(rs.getString("maCCCD"));
                admin.setTen(rs.getString("tenAdmin"));
                admin.setGioiTinh(rs.getString("gioiTinh"));
                admin.setNgaySinh(rs.getDate("ngaySinh").toLocalDate());
                admin.setSoDienThoai(rs.getString("soDienThoai"));
                admin.setDiaChi(rs.getString("diaChi"));
                admin.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }

    @Override
    public Admin getAdmin(String maCCCD) {
        String query = "SELECT * FROM admin WHERE maCCCD = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maCCCD);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Admin admin = new Admin();
                admin.setMaAdmin(rs.getInt("maAdmin"));
                admin.setMaCCCD(rs.getString("maCCCD"));
                admin.setTen(rs.getString("tenAdmin"));
                admin.setGioiTinh(rs.getString("gioiTinh"));
                admin.setNgaySinh(rs.getDate("ngaySinh").toLocalDate());
                admin.setSoDienThoai(rs.getString("soDienThoai"));
                admin.setDiaChi(rs.getString("diaChi"));
                admin.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
                return admin;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateAdmin(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maAdmin, int maTaiKhoan) {
        String sql = "update Admin set maCCCD = ?, tenAdmin = ?, ngaySinh = ?, gioiTinh = ?, soDienThoai = ?, diaChi = ?, maTaiKhoan = ? where maAdmin = ?";
        updatePerson(conn, sql, maCCCD, ten, ngaySinh, gioiTinh, soDienThoai, diaChi, maAdmin, maTaiKhoan);
    }

    @Override
    public void deleteAdmin(String maCCCD) {
        String sql = "DELETE FROM admin WHERE maCCCD = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maCCCD);
            ps.executeUpdate();
            this.conn.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
