package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.CoSoVatChat;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoSoVatChatDAOImpl implements CoSoVatChatDAO{
    private final Connection connection;

    public CoSoVatChatDAOImpl(){
        try{
            connection = DatabaseConnection.getConnection();
            this.connection.setAutoCommit(false);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CoSoVatChat getCoSoVatChat(int maCoSoVatChat) {
        String query = "SELECT * FROM CoSoVatChat WHERE maCSVC = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setInt(1, maCoSoVatChat);
            var rs = pstm.executeQuery();
            if(rs.next()){
                return new CoSoVatChat(rs.getInt("maCSVC"), rs.getString("tenCSVC"), rs.getString("trangThai"));
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<CoSoVatChat> getAllCoSoVatChat(int maPhong) {
        List<CoSoVatChat> coSoVatChatList = new ArrayList<>();
        String query = "SELECT csvc.maCSVC FROM Phong\n" +
                "join KieuPhong on Phong.maKieuPhong = KieuPhong.maKieuPhong\n" +
                "join KieuPhong_CoSoVatChat kpcsvc on KieuPhong.maKieuPhong = kpcsvc.maKieuPhong\n" +
                "join CoSoVatChat csvc on kpcsvc.maCSVC = csvc.maCSVC\n" +
                "WHERE maPhong = ?";
        try(PreparedStatement pstm = connection.prepareStatement(query)){
            pstm.setInt(1, maPhong);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                CoSoVatChat coSoVatChat = getCoSoVatChat(rs.getInt("maCSVC"));
                coSoVatChatList.add(coSoVatChat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return coSoVatChatList;
    }

    public static void main(String[] args) {
        CoSoVatChatDAO coSoVatChatDAO = new CoSoVatChatDAOImpl();
        System.out.println(coSoVatChatDAO.getAllCoSoVatChat(4));
    }
}
