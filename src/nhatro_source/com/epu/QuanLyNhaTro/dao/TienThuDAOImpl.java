package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.TienThuTienIch;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TienThuDAOImpl implements TienThuDAO {
    private final Connection connection;

    public TienThuDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<TienThuTienIch> getAll() {
        List<TienThuTienIch> tienThuTienIchList = new ArrayList<>();
        String sql = "select * from TienThuTienIch";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TienThuTienIch tienThuTienIch = new TienThuTienIch();
                tienThuTienIch.setMaTienThu(resultSet.getInt("maTienThu"));
                tienThuTienIch.setMaPhong(resultSet.getInt("maPhong"));
                tienThuTienIch.setNgayThu(resultSet.getDate("ngayGhiDien").toLocalDate());
                tienThuTienIch.setSoDienCu(resultSet.getDouble("soDienCu"));
                tienThuTienIch.setSoDienMoi(resultSet.getDouble("soDienMoi"));
                tienThuTienIch.setSoNuocCu(resultSet.getDouble("soNuocCu"));
                tienThuTienIch.setSoNuocMoi(resultSet.getDouble("soNuocMoi"));
                tienThuTienIch.setSoDienDaDung(resultSet.getDouble("soDienDaDung"));
                tienThuTienIch.setSoNuocDaDung(resultSet.getDouble("soNuocDaDung"));
                tienThuTienIchList.add(tienThuTienIch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienThuTienIchList;
    }

    @Override
    public TienThuTienIch getTienThu(int maPhong) {
        String query = "select * from TienThuTienIch where maPhong = ?";
        TienThuTienIch tienThuTienIch = new TienThuTienIch();
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, maPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tienThuTienIch.setMaTienThu(rs.getInt("maTienThu"));
                tienThuTienIch.setMaPhong(rs.getInt("maPhong"));
                tienThuTienIch.setNgayThu(rs.getDate("ngayGhiDien").toLocalDate());
                tienThuTienIch.setSoDienCu(rs.getDouble("soDienCu"));
                tienThuTienIch.setSoDienMoi(rs.getDouble("soDienMoi"));
                tienThuTienIch.setSoNuocCu(rs.getDouble("soNuocCu"));
                tienThuTienIch.setSoNuocMoi(rs.getDouble("soNuocMoi"));
                tienThuTienIch.setSoDienDaDung(rs.getDouble("soDienDaDung"));
                tienThuTienIch.setSoNuocDaDung(rs.getDouble("soNuocDaDung"));
            }
        } catch (Exception e) {
            e.printStackTrace();}
        return tienThuTienIch;
    }

    public static void main(String[] args) {
        TienThuDAOImpl tienThuDAO = new TienThuDAOImpl();
        List<TienThuTienIch> tienThuTienIchList = tienThuDAO.getAll();
        for (TienThuTienIch tienThuTienIch : tienThuTienIchList) {
            System.out.println(tienThuTienIch.getMaTienThu());
        }
    }
}
