package com.epu.QuanLyNhaTro.util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    //check length password
    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    //check ngay sinh
    public static String normalizeDate(String inputDate) {
        // Kiểm tra null
        if (inputDate == null || inputDate.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ngày nhập không được để trống!");
            return null;
        }

        inputDate = inputDate.trim();

        // các định dạng có thể nhap vao
        String[] inputFormats = {"dd/MM/yyyy", "MM-dd-yyyy", "yyyy.MM.dd", "yyyy/MM/dd", "yyyy-MM-dd"};

        // chuẩn
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Thử từng định dạng đầu vào
        for (String format : inputFormats) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(format);
                LocalDate date = LocalDate.parse(inputDate, inputFormatter);
                return date.format(outputFormatter);
            } catch (DateTimeParseException ignored) {
            }
        }

        JOptionPane.showMessageDialog(null,
                "Định dạng ngày không hợp lệ: " + inputDate +
                        "\nVui lòng nhập ngày theo một trong các định dạng sau: " +
                        "\ndd/MM/yyyy, MM-dd-yyyy, yyyy.MM.dd, yyyy/MM/dd, yyyy-MM-dd");
        return null;
    }



    public static void main(String[] args) {
        String input = "21/08/2004";
        System.out.println(normalizeDate(input));
    }

}
