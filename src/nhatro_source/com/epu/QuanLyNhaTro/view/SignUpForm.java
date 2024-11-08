package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.SignUpController;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import lombok.Getter;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.sql.SQLException;
import java.util.Locale;

public class SignUpForm extends JFrame {
    private JPanel loginPnl;

    @Getter
    private JTextField emailField;
    @Getter
    private JButton signUpBtn;
    @Getter
    private JTextField verifyField;
    @Getter
    private JPasswordField passwordField1;
    @Getter
    private JPasswordField passwordField2;
    @Getter
    private JButton getCodeButton;
    @Getter
    private JButton logBtn;

    private JPanel rightPnl;
    private JPanel txtPnl;

    private JLabel emailLbl;
    private JLabel passLbl;
    private JLabel pass2Lbl;
    private JPanel leftPnl;


    public SignUpForm() throws SQLException {
        loginPnl = new JPanel();
        loginPnl.setLayout(new BorderLayout());
        loginPnl.setBackground(Color.LIGHT_GRAY);

        // Panel bên trái với màu sắc riêng biệt
        rightPnl = new JPanel();
        rightPnl.setBackground(new Color(144, 238, 144)); // Màu xanh nhạt
        rightPnl.setPreferredSize(new Dimension(150, 400));
        loginPnl.add(rightPnl, BorderLayout.WEST);

        // Panel chính để nhập thông tin
        txtPnl = new JPanel();
        txtPnl.setLayout(new GridBagLayout());
        txtPnl.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tiêu đề
        JLabel titleLbl = new JLabel("Đăng Ký", SwingConstants.CENTER);
        titleLbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLbl.setForeground(Color.DARK_GRAY);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        txtPnl.add(titleLbl, gbc);

        // Nhãn Email
        emailLbl = new JLabel("Email");
        emailLbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        txtPnl.add(emailLbl, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        txtPnl.add(emailField, gbc);

        // Nhãn Mật Khẩu
        passLbl = new JLabel("Mật Khẩu");
        passLbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        txtPnl.add(passLbl, gbc);

        passwordField1 = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        txtPnl.add(passwordField1, gbc);

        // Nhãn Nhập lại mật khẩu
        pass2Lbl = new JLabel("Nhập lại mật khẩu");
        pass2Lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        txtPnl.add(pass2Lbl, gbc);

        passwordField2 = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        txtPnl.add(passwordField2, gbc);

        // Nút Đăng Ký
        signUpBtn = new JButton("Đăng ký");
        signUpBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signUpBtn.setBackground(new Color(100, 149, 237));
        signUpBtn.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 5;
        txtPnl.add(signUpBtn, gbc);

        // Thêm panel vào giao diện chính
        loginPnl.add(txtPnl, BorderLayout.CENTER);

        // Phần đăng nhập phía dưới
        JPanel bottomPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPnl.setBackground(Color.LIGHT_GRAY);

        JLabel haveAccountLbl = new JLabel("Bạn đã có tài khoản ?");
        logBtn = new JButton("Đăng nhập");
        logBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        logBtn.setBackground(new Color(192, 192, 192)); // Màu xám nhạt
        logBtn.setForeground(Color.BLACK);

        bottomPnl.add(haveAccountLbl);
        bottomPnl.add(logBtn);
        loginPnl.add(bottomPnl, BorderLayout.SOUTH);

        //xu ly su kien nut dang ky
        SignUpController signUpController = new SignUpController(this, new signUpCode());
        signUpController.initController();

        this.setContentPane(loginPnl);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


    public static void main(String[] args) throws SQLException {
        new SignUpForm();

    }


}
