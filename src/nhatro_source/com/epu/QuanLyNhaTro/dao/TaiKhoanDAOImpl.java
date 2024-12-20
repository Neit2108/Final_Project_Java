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

    public TaiKhoanDAOImpl() {
        try{
            this.conn = DatabaseConnection.getConnection();
            this.conn.setAutoCommit(false);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

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
    public TaiKhoan getTaiKhoan(String email) {
        String query = "select * from TaiKhoan where email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
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
    public void updateTaiKhoan(String email, String vaiTro) {
        String query = "update TaiKhoan set vaiTro = ? where email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, vaiTro);
            ps.setString(2, email);
            ps.executeUpdate();
            this.conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTaiKhoan(String email) {
        String query = "delete from TaiKhoan where email = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.executeUpdate();
            this.conn.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getMaChuNha(int maTaiKhoan) {
        String query = "select maChuNha from ChuNha where maTaiKhoan = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("maChuNha");
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getMaKhachThue(int maTaiKhoan) {
        String query = "select maKhachThue from KhachThue where maTaiKhoan = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("maKhachThue");
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getMaAdmin(int maTaiKhoan) {
        String query = "select maAdmin from Admin where maTaiKhoan = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("maAdmin");
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkLogin(String email) {
        String query = "select isFirstLogin from TaiKhoan where email = ?";
        try(PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                boolean isFirstLogin = rs.getBoolean("isFirstLogin");
                return isFirstLogin;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void updateLogin(String email) {
        String query = "update TaiKhoan set isFirstLogin = 0 where email = ?";
        try(PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)){
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TaiKhoanDAOImpl tk = new TaiKhoanDAOImpl();
        tk.updateTaiKhoan("ldtien.210804@gmail.com", "Chủ nhà");
    }
}