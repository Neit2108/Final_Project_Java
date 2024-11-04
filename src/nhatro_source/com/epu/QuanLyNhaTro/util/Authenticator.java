package com.epu.QuanLyNhaTro.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator {
    private static final Connection conn = DatabaseConnection.getConnection();

    //Kiểm tra thông tin đăng nhập
    public static boolean isValidUser(String email, String password) {
        String sql = "select password from TaiKhoan where email = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String hashedPassword = rs.getString("password");
                return PasswordUtils.verifyPassword(password, hashedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
