package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.Phong;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String query = "INSERT INTO Phong(tenPhong, maKieuPhong, maNhaTro, trangThai, urlImage) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setString(1, tenPhong);
            pstm.setInt(2, maKieuPhong);
            pstm.setInt(3, maNhaTro);
            pstm.setString(4, "Chưa thuê");
            pstm.setString(5, urlImage);
            pstm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhong(int maPhong, String tenPhong, int maKieuPhong, int maNhaTro, String urlImage) {
        String query = "UPDATE Phong SET tenPhong = ?, maKieuPhong = ?, maNhaTro = ?, urlImage = ? WHERE maPhong = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setString(1, tenPhong);
            pstm.setInt(2, maKieuPhong);
            pstm.setInt(3, maNhaTro);
            pstm.setString(4, urlImage);
            pstm.setInt(5, maPhong);
            pstm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePhong(int maPhong) {
        String query = "DELETE FROM Phong WHERE maPhong = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maPhong);
            pstm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Phong getPhong(int maPhong) {
        String query = "SELECT * FROM Phong WHERE maPhong = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maPhong);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Phong(rs.getInt("maPhong"), rs.getString("tenPhong"), rs.getInt("maKieuPhong"), rs.getInt("maNhaTro"), rs.getString("trangThai"), rs.getString("urlImage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phong> getAllPhong() {
        List<Phong> phongs = new ArrayList<>();
        String query = "SELECT * FROM Phong";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                phongs.add(new Phong(rs.getInt("maPhong"), rs.getString("tenPhong"), rs.getInt("maKieuPhong"), rs.getInt("maNhaTro"), rs.getString("trangThai"), rs.getString("urlImage")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return phongs;
    }

    @Override
    public List<Phong> getAllPhongByMaNhaTro(int maNhaTro) {
        String query = "select * from Phong" +
                " where maNhaTro = ?";
        List<Phong> phongs = new ArrayList<>();
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setInt(1, maNhaTro);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                phongs.add(new Phong(rs.getInt("maPhong"), rs.getString("tenPhong"), rs.getInt("maKieuPhong"), rs.getInt("maNhaTro"), rs.getString("trangThai"), rs.getString("urlImage")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return phongs;
    }

    @Override
    public double getGiaPhong(int maPhong) {
        String query = "select * from PhongView where maPhong = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, maPhong);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getDouble("giaPhong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getMaChuNha(int maPhong) {
        int id = -1;
        String query = "select maChuNha\n" +
                "from Phong\n" +
                "join NhaTro on Phong.maNhaTro = NhaTro.maNhaTro\n" +
                "where maPhong = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setInt(1, maPhong);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                id = rs.getInt("maChuNha");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void updateTrangThaiPhong(int maPhong, String trangThai) {
        String query = "UPDATE Phong SET trangThai = ? WHERE maPhong = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setString(1, trangThai);
            pstm.setInt(2, maPhong);
            pstm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PhongDAO phongDAO = new PhongDAOImpl();
        List<Phong> phongs = phongDAO.getAllPhong();
        System.out.println(phongs.size());
        for (Phong phong : phongs) {
            System.out.println(phong.getMaPhong());
        }
    }
}
