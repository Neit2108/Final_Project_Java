// src/View/LoginForm.java

//Mau xu ly controller

package com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;
    private AuthController authController; // Khởi tạo controller

    public LoginForm() {
        setTitle("Login/Register Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        authController = new AuthController(); // Tạo instance của AuthController

        // Panel chứa form
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Input cho tên người dùng và mật khẩu
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Nút đăng ký và đăng nhập
        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        // Xử lý sự kiện nhấn nút bằng lambda
        registerButton.addActionListener(e -> handleRegister());
        loginButton.addActionListener(e -> handleLogin());

        panel.add(registerButton);
        panel.add(loginButton);

        add(panel);
    }

    // Gọi phương thức đăng ký trong controller
    private void handleRegister() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        authController.registerUser(username, password);
    }

    // Gọi phương thức đăng nhập trong controller
    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        authController.loginUser(username, password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm form = new LoginForm();
            form.setVisible(true);
        });
    }
}
