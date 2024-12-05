package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.ChuNha;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
    public void addChuNha(String maCCCD, String ten, LocalDate ngaySinh, String gioiTinh, String soDienThoai, String diaChi, int maTaiKhoan) {
        String query = "INSERT INTO ChuNha(maCCCD, tenChuNha, ngaySinh, gioiTinh, soDienThoai, diaChi, maTaiKhoan) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setString(1, maCCCD);
            pstm.setString(2, ten);
            pstm.setDate(3, java.sql.Date.valueOf(ngaySinh));
            pstm.setString(4, gioiTinh);
            pstm.setString(5, soDienThoai);
            pstm.setString(6, diaChi);
            pstm.setInt(7, maTaiKhoan);
            pstm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
