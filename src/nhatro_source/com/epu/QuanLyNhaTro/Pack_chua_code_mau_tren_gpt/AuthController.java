// src/Controller/AuthController.java
package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import javax.swing.JOptionPane;

public class AuthController {

    public void registerUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields to register.");
            return;
        }
        // Thực hiện logic đăng ký (ví dụ: lưu vào database)
        JOptionPane.showMessageDialog(null, "Registration successful for user: " + username);
    }

    public void loginUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields to login.");
            return;
        }
        // Thực hiện logic đăng nhập (ví dụ: kiểm tra thông tin từ database)
        JOptionPane.showMessageDialog(null, "Login successful for user: " + username);
    }
}
