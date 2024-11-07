package com.epu.QuanLyNhaTro.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

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

    //check email format
    public static boolean isValidEmail(String email) {
        String regex =
  "^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    //check length of password
    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    public static void main(String[] args) {
        String email = "tienld.22810310329@gmail.com";
        boolean check = isValidEmail(email);
        System.out.println(check);
    }

}
