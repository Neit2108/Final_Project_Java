package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.DichVu;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DichVuDAOImpl implements DichVuDAO{
    private final Connection connection;

    public DichVuDAOImpl() {
        try {
            connection = DatabaseConnection.getConnection();
            this.connection.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addDichVu(int maDichVu, String tenDichVu, String trangThai) {

    }

    @Override
    public void updateDichVu(int maDichVu, String tenDichVu, String trangThai) {

    }

    @Override
    public void deleteDichVu(int maDichVu) {

    }

    @Override
    public DichVu getDichVu(int maDichVu) {
        String query = "select * from DichVu where maDichVu = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maDichVu);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                return new DichVu(rs.getInt("maDichVu"), rs.getString("tenDichVu"), rs.getInt("giaDichVu"), rs.getString("trangThai"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<DichVu> getAllDichVu() {
        return List.of();
    }
}
