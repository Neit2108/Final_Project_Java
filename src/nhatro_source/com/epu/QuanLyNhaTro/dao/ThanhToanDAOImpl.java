package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThanhToanDAOImpl implements ThanhToanDAO {
    private Connection connection;

    public ThanhToanDAOImpl() {
        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addThanhToan(int maHoaDon, double soTien, String trangThai) {
        String query = "insert into ThanhToan(maHoaDon, soTien, trangThai) values(?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, maHoaDon);
            ps.setDouble(2, soTien);
            ps.setString(3, trangThai);
            int i = ps.executeUpdate();
            if(i == 1) {
                connection.commit();
            }
            else {
                connection.rollback();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


