package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.KieuPhong;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class KieuPhongDAOImpl implements KieuPhongDAO{
    private final Connection connection;

    public KieuPhongDAOImpl(){
        this.connection = DatabaseConnection.getConnection();
        try{
            this.connection.setAutoCommit(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void addKieuPhong(String loaiPhong, double dienTich, double giaPhong) {

    }

    @Override
    public void updateKieuPhong(int maKieuPhong, String loaiPhong, double dienTich, double giaPhong) {

    }

    @Override
    public void deleteKieuPhong(int maKieuPhong) {

    }

    @Override
    public KieuPhong getKieuPhong(int maKieuPhong) {
        String query = "select * from KieuPhong where maKieuPhong = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maKieuPhong);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                return new KieuPhong(rs.getInt("maKieuPhong"), rs.getString("loaiPhong"), rs.getDouble("dienTich"), rs.getDouble("giaPhong"), rs.getTimestamp("ngayTao").toLocalDateTime());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<KieuPhong> getAllKieuPhong() {
        return List.of();
    }
}
