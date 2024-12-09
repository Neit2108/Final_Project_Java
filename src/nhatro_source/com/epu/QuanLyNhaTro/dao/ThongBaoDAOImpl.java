package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.ThongBao;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongBaoDAOImpl implements ThongBaoDAO{
    private Connection conn;

    public ThongBaoDAOImpl(){
        try{
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addThongBao(int maNguoiGui, int maNguoiNhan, String noiDung, String trangThai, int maPhong, String loaiThongBao) {
        String query = "insert into ThongBao(maNguoiGui, maNguoiNhan, noiDung, trangThai, maPhong, loaiThongBao) values(?,?,?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maNguoiGui);
            ps.setInt(2, maNguoiNhan);
            ps.setString(3, noiDung);
            ps.setString(4, trangThai);
            ps.setInt(5, maPhong);
            ps.setString(6, loaiThongBao);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi thêm thông báo : " + e.getMessage(), e);
        }
    }

    @Override
    public List<ThongBao> getAllThongBao(int maNguoiNhan) {
        String query = "select * from ThongBao where maNguoiNhan = ?";
        List<ThongBao> thongBaoList = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maNguoiNhan);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                ThongBao thongBao = new ThongBao();
                thongBao.setId(resultSet.getInt("id"));
                thongBao.setMaNguoiGui(resultSet.getInt("maNguoiGui"));
                thongBao.setMaNguoiNhan(resultSet.getInt("maNguoiNhan"));
                thongBao.setNoiDung(resultSet.getString("noiDung"));
                thongBao.setTrangThai(resultSet.getString("trangThai"));
                thongBao.setNgayTao(resultSet.getDate("ngayTao").toLocalDate());
                thongBaoList.add(thongBao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongBaoList;
    }

    @Override
    public void updateTrangThaiThongBao(int id) {
        String query = "update ThongBao set trangThai = N'Đã xem' where id = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi cập nhật trạng thái thông báo : " + e.getMessage(), e);
        }
    }

    @Override
    public ThongBao getThongBao(int maThongBao) {
        String query = "select * from ThongBao where id = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maThongBao);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                ThongBao thongBao = new ThongBao();
                thongBao.setId(resultSet.getInt("id"));
                thongBao.setMaNguoiGui(resultSet.getInt("maNguoiGui"));
                thongBao.setMaNguoiNhan(resultSet.getInt("maNguoiNhan"));
                thongBao.setNoiDung(resultSet.getString("noiDung"));
                thongBao.setTrangThai(resultSet.getString("trangThai"));
                thongBao.setNgayTao(resultSet.getDate("ngayTao").toLocalDate());
                thongBao.setMaPhong(resultSet.getInt("maPhong"));
                thongBao.setLoaiThongBao(resultSet.getString("loaiThongBao"));
                return thongBao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteThongBao(int maThongBao) {
        String query = "delete from ThongBao where id = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maThongBao);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi xóa thông báo : " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteAllThongBao(int maNguoiNhan) {
        String query = "delete from ThongBao where maNguoiNhan = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maNguoiNhan);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi xóa tất cả thông báo : " + e.getMessage(), e);
        }
    }
}
