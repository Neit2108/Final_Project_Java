package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.NhaTro;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaTroDAOImpl implements NhaTroDAO{
    private Connection connection;

    public NhaTroDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
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
}
