package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.Phong;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PhongDAOImpl implements PhongDAO{
    private final Connection connection;

    public PhongDAOImpl() {
        try{
            connection = DatabaseConnection.getConnection();
            this.connection.setAutoCommit(false);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addPhong(String tenPhong, int maKieuPhong, int maNhaTro, String urlImage) {

    }

    @Override
    public void updatePhong(int maPhong, String tenPhong, int maKieuPhong, int maNhaTro, String urlImage) {

    }

    @Override
    public void deletePhong(int maPhong) {

    }

    @Override
    public Phong getPhong(int maPhong) {
        String query = "SELECT * FROM Phong WHERE maPhong = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maPhong);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Phong(rs.getInt("maPhong"), rs.getString("tenPhong"), rs.getInt("maKieuPhong"), rs.getInt("maNhaTro"), rs.getString("urlImage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phong> getAllPhong() {
        return List.of();
    }

    @Override
    public double getGiaPhong(int maPhong) {
        return 0;
    }
}
