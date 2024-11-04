package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.TaiKhoan;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;
import com.epu.QuanLyNhaTro.util.PasswordUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {
    private final Connection conn;

    public TaiKhoanDAOImpl() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
        this.conn.setAutoCommit(false);
    }

    @Override
    public void addTaiKhoan(String email, String password, String vaiTro) {
        String query = "insert into TaiKhoan(email, password, vaiTro) values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            String hashedPass = PasswordUtils.hashPassword(password);
            ps.setString(2, hashedPass);
            ps.setString(3, vaiTro);
            ps.executeUpdate();
            this.conn.commit();
        } catch (SQLException e) {
            try {
                this.conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi thêm tài khoản : " + e.getMessage(), e);
        }

    }

    @Override
    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        String query = "select * from TaiKhoan";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
                tk.setEmail(rs.getString("email"));
                tk.setPassword(rs.getString("password"));
                tk.setVaiTro(rs.getString("vaiTro"));
                tk.setNgayTao(rs.getTimestamp("ngayTao").toLocalDateTime());
                list.add(tk);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public TaiKhoan getTaiKhoan(int maTaiKhoan) {
        String query = "select * from TaiKhoan where maTaiKhoan = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
                tk.setEmail(rs.getString("email"));
                tk.setPassword(rs.getString("password"));
                tk.setVaiTro(rs.getString("vaiTro"));
                tk.setNgayTao(rs.getTimestamp("ngayTao").toLocalDateTime());
                return tk;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateTaiKhoan(int maTaiKhoan, String email, String password, String vaiTro) {
        String query = "update TaiKhoan set email = ?, password = ?, vaiTro = ? where maTaiKhoan = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, vaiTro);
            ps.setInt(4, maTaiKhoan);
            ps.executeUpdate();
            this.conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTaiKhoan(int maTaiKhoan) {
        String query = "delete from TaiKhoan where maTaiKhoan = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, maTaiKhoan);
            ps.executeUpdate();
            this.conn.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String pss = "password18";
        String hashed = "dKjsa7pcA/otwCU+yBIL4g==:YXUOl6CxrkDZiv0EBqEj5OhzBCymLwFdxyyVJ2/anx4=";

        boolean check = PasswordUtils.verifyPassword(pss, hashed);
        System.out.println(check);
    }
}