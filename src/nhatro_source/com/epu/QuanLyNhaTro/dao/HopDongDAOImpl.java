package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.HopDong;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HopDongDAOImpl implements HopDongDAO {
    private final Connection conn;

    public HopDongDAOImpl() {
        try {
            this.conn = DatabaseConnection.getConnection();
            this.conn.setAutoCommit(false);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addHopDong(int maHopDong, int maPhong, int maKhachThue, double tienCoc, LocalDate ngayThue, LocalDate ngayDiDuKien, LocalDate ngayTao, String trangThai) {

    }

    @Override
    public HopDong getHopDong(int maHopDong) {
        String query = "select * from HopDong where maHopDong = ?";
        try(PreparedStatement ps = this.conn.prepareStatement(query)) {
            ps.setInt(1, maHopDong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return new HopDong(rs.getInt("maHopDong"), rs.getInt("maPhong"), rs.getInt("maKhachThue"), rs.getDouble("tienCoc"), rs.getDate("ngayThue").toLocalDate(), rs.getInt("thoiHanHopDong"), rs.getTimestamp("ngayTao").toLocalDateTime(), rs.getString("trangThai"));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<HopDong> getAllHopDong() {
        List<HopDong> hopDongList = new ArrayList<>();
        String query = "select * from HopDong";
        try(PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HopDong hd = new HopDong(rs.getInt("maHopDong"), rs.getInt("maPhong"), rs.getInt("maKhachThue"), rs.getDouble("tienCoc"), rs.getDate("ngayThue").toLocalDate(), rs.getInt("thoiHanHopDong"), rs.getTimestamp("ngayTao").toLocalDateTime(), rs.getString("trangThai"));;
                hopDongList.add(hd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hopDongList;
    }

    public static void main(String[] args) {
        HopDongDAO hopDongDAO = new HopDongDAOImpl();
        List<HopDong> hopDongList = hopDongDAO.getAllHopDong();
        for (HopDong hd : hopDongList) {
            System.out.println(hd);
        }
    }
}
