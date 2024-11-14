package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.DichVu;
import com.epu.QuanLyNhaTro.model.Phong;
import com.epu.QuanLyNhaTro.model.Phong_DichVu;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Phong_DichVu_DAOImpl implements Phong_DichVu_DAO {
    private final Connection connection;
    public Phong_DichVu_DAOImpl() {
        try {
            connection = DatabaseConnection.getConnection();
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DichVu> getAllDichVuPhong(int maPhong) {
        List<DichVu> dichVuList = new ArrayList<DichVu>();
        String query = "select maDichVu from Phong_DichVu where maPhong = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maPhong);
            ResultSet rs = pstm.executeQuery();
            DichVuDAO dichVuDAO = new DichVuDAOImpl();
            while (rs.next()) {
                DichVu dichVu = dichVuDAO.getDichVu(rs.getInt("maDichVu"));
                dichVuList.add(dichVu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dichVuList;
    }

    @Override
    public List<String> getAllTrangThaiPhong(int maPhong) {
        List<String> trangThaiList = new ArrayList<String>();
        String query = "select ghiChu from Phong_DichVu where maPhong = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maPhong);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                trangThaiList.add(rs.getString("ghiChu"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trangThaiList;
    }
}
