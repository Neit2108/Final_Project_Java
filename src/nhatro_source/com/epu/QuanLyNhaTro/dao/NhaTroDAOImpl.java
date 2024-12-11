package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.NhaTro;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaTroDAOImpl implements NhaTroDAO{
    private Connection connection;

    public NhaTroDAOImpl() {
        try {
            this.connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NhaTro> getAllNhaTroByMaChuNha(int maChuNha) {
        List<NhaTro> nhaTros = new ArrayList<>();
        String query = "SELECT * FROM NhaTro WHERE maChuNha = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, maChuNha);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nhaTros.add(new NhaTro(rs.getInt("maNhaTro"), rs.getInt("maChuNha"), rs.getString("diaChi"), rs.getInt("soLuongPhong"), rs.getString("trangThai"), rs.getString("urlImage")));
            }
            return nhaTros;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NhaTro> getAllNhaTro() {
        List<NhaTro> nhaTros = new ArrayList<>();
        String query = "SELECT * FROM NhaTro";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nhaTros.add(new NhaTro(rs.getInt("maNhaTro"), rs.getInt("maChuNha"), rs.getString("diaChi"), rs.getInt("soLuongPhong"), rs.getString("trangThai"), rs.getString("urlImage")));
            }
            return nhaTros;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNhaTro(int maChuNha, String diaChi, int soLuongPhong, String trangThai, String urlImage) {
        String query = "INSERT INTO NhaTro(maChuNha, diaChi, soLuongPhong, trangThai, urlImage) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maChuNha);
            pstm.setString(2, diaChi);
            pstm.setInt(3, soLuongPhong);
            pstm.setString(4, trangThai);
            pstm.setString(5, urlImage);
            pstm.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateNhaTro(int maNhaTro, int maChuNha, String diaChi, int soLuongPhong, String trangThai, String urlImage) {
        String query = "UPDATE NhaTro SET maChuNha = ?, diaChi = ?, soLuongPhong = ?, trangThai = ?, urlImage = ? WHERE maNhaTro = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, maChuNha);
            ps.setString(2, diaChi);
            ps.setInt(3, soLuongPhong);
            ps.setString(4, trangThai);
            ps.setString(5, urlImage);
            ps.setInt(6, maNhaTro);
            ps.executeUpdate();
            connection.commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteNhaTro(int maNhaTro) {
        String query1 = "DELETE FROM Phong WHERE maNhaTro = ?";
        String query2 = "DELETE FROM NhaTro WHERE maNhaTro = ?";
        try(PreparedStatement ps = connection.prepareStatement(query1); PreparedStatement ps1 = connection.prepareStatement(query2)){
            ps.setInt(1, maNhaTro);
            ps.executeUpdate();

            ps1.setInt(1, maNhaTro);
            ps1.executeUpdate();

            connection.commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public NhaTro getNhaTroByMaNhaTro(int maNhaTro) {
        String query = "SELECT * FROM NhaTro WHERE maNhaTro = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, maNhaTro);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new NhaTro(rs.getInt("maNhaTro"), rs.getInt("maChuNha"), rs.getString("diaChi"), rs.getInt("soLuongPhong"), rs.getString("trangThai"), rs.getString("urlImage"));
            }
            return null;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
