package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.ChuNha;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuNhaDAOImpl implements ChuNhaDAO{
    private final Connection connection;

    public ChuNhaDAOImpl() {
        try{
            connection = DatabaseConnection.getConnection();
            this.connection.setAutoCommit(false);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public ChuNha getChuNha(int maChuNha) {
        String query = "SELECT * FROM ChuNha WHERE maChuNha = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maChuNha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new ChuNha(rs.getString("maCCCD"), rs.getString("tenChuNha"), rs.getDate("ngaySinh").toLocalDate(), rs.getString("gioiTinh"), rs.getString("soDienThoai"), rs.getString("diaChi"), rs.getInt("maChuNha"), rs.getInt("maTaiKhoan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
        System.out.println(chuNhaDAO.getChuNha(3));
    }
}
