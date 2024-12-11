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
    public List<HoaDon> getHoaDonByMaKhach(int maKhach) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String query = "select * from HoaDon\n" +
                "join dbo.HopDong HD on HoaDon.maHopDong = HD.maHopDong\n" +
                "join dbo.KhachThue KT on HD.maKhachThue = KT.maKhachThue\n" +
                "where HD.maKhachThue = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maKhach);
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

    @Override
    public List<HoaDon> getHoaDonByMaNhaTro(int maNhaTro) {
        String query = "select * from HoaDon\n" +
                "join HopDong hd on HoaDon.maHopDong = hd.maHopDong\n" +
                "join Phong p on p.maPhong = hd.maPhong\n" +
                "where p.maNhaTro = ?";
        List<HoaDon> hoaDonList = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maNhaTro);
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

    @Override
    public boolean isCreatedHoaDon(Date date) {
        int result = 0;
        String query = "{call sp_KiemTraHoaDonThang(?)}";
        try(PreparedStatement ps = conn.prepareCall(query)){
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            ps.setDate(1, sqlDate);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = rs.getInt("HoaDonDaTao");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    @Override
    public void autoCreateHoaDon(int maChuNha, Date date) {
        String query1 = "{call sp_TaoHoaDonTuDong(?, ?)}";
        String query2 = "{call sp_ThemTienDienNuocTuDong(?)}";

        try(PreparedStatement ps = conn.prepareCall(query1)){
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//            ps.setDate(1, sqlDate);
            ps.setNull(1, java.sql.Types.DATE);
            ps.setInt(2, maChuNha);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try(PreparedStatement ps = conn.prepareCall(query2)){
            ps.setInt(1, maChuNha);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteHoaDon(int maHoaDon) {
        String sql = "BEGIN TRANSACTION; " +
                "DELETE FROM ChiTiet_DichVu WHERE maChiTiet IN (" +
                "    SELECT maChiTiet FROM ChiTietHoaDon WHERE maHoaDon = ?);" +
                "DELETE FROM ChiTiet_CSVC WHERE maChiTiet IN (" +
                "    SELECT maChiTiet FROM ChiTietHoaDon WHERE maHoaDon = ?);" +
                "DELETE FROM ChiTietHoaDon WHERE maHoaDon = ?;" +
                "DELETE FROM HoaDon WHERE maHoaDon = ?;" +
                "COMMIT TRANSACTION;";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, maHoaDon);
            ps.setInt(2, maHoaDon);
            ps.setInt(3, maHoaDon);
            ps.setInt(4, maHoaDon);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTrangThai(int maHoaDon) {
        String sql = "UPDATE HoaDon SET trangThai = N'Chờ xác nhận' WHERE maHoaDon = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, maHoaDon);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HoaDon getHoaDon(int maHoaDon) {
        String query = "SELECT * FROM HoaDon WHERE maHoaDon = ?";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Date ngayThanhToanDate = rs.getDate("ngayThanhToan");
                LocalDate ngayThanhToan = (ngayThanhToanDate == null) ? null : ((java.sql.Date) ngayThanhToanDate).toLocalDate();
                return new HoaDon(rs.getInt("maHoaDon"), rs.getInt("maHopDong"), rs.getDouble("tongTien"), (rs.getDate("ngayTao").toLocalDate() != null) ? rs.getDate("ngayTao").toLocalDate() : null, ngayThanhToan , rs.getString("trangThai"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
