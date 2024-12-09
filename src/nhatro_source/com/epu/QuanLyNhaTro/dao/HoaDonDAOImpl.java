package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.HoaDon;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonDAOImpl implements HoaDonDAO {
    private final Connection conn;

    public HoaDonDAOImpl() {
        try {
            this.conn = DatabaseConnection.getConnection();
            this.conn.setAutoCommit(false);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT * FROM HoaDon";
        try(PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getInt("maHoaDon"));
                hoaDon.setMaHopDong(rs.getInt("maHopDong"));
                hoaDon.setTongTien(rs.getDouble("tongTien"));
                hoaDon.setNgayTao(rs.getDate("ngayTao").toLocalDate());
                Date ngayThanhToanDate = rs.getDate("ngayThanhToan");
                LocalDate ngayThanhToan = (ngayThanhToanDate == null) ? null : ((java.sql.Date) ngayThanhToanDate).toLocalDate();
                hoaDon.setNgayThanhToan(ngayThanhToan);
                hoaDon.setTrangThai(rs.getString("trangThai"));
                hoaDonList.add(hoaDon);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hoaDonList;
    }

    @Override
    public List<HoaDon> getHoaDonByMaKhach(int maTaiKhoan) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String query = "select * from HoaDon\n" +
                "join dbo.HopDong HD on HoaDon.maHopDong = HD.maHopDong\n" +
                "join dbo.KhachThue KT on HD.maKhachThue = KT.maKhachThue\n" +
                "where maTaiKhoan = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maTaiKhoan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Date ngayThanhToanDate = rs.getDate("ngayThanhToan");
                LocalDate ngayThanhToan = (ngayThanhToanDate == null) ? null : ((java.sql.Date) ngayThanhToanDate).toLocalDate();
                HoaDon hd = new HoaDon(rs.getInt("maHoaDon"), rs.getInt("maHopDong"), rs.getDouble("tongTien"), (rs.getDate("ngayTao").toLocalDate() != null) ? rs.getDate("ngayTao").toLocalDate() : null, ngayThanhToan , rs.getString("trangThai"));
                hoaDonList.add(hd);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hoaDonList;
    }
}
