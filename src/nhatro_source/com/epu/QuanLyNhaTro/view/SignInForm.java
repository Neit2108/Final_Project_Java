package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.SignInController;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

@Getter
@Setter
public class SignInForm extends JFrame {
    private JPanel signInPnl;
    private JTextField emailField;
    private JPasswordField passField;
    private JButton signInBtn;
    private JButton signUpBtn;
    private JPanel rightPnl;
    private JPanel leftPnl;
    private JPanel txtPnl;
    private JLabel emailLbl;
    private JLabel passLbl;

    public SignInForm() throws SQLException {
        signInPnl = new JPanel();
        signInPnl.setLayout(new BorderLayout());
        signInPnl.setBackground(Color.LIGHT_GRAY);

        // Panel bên trái
        rightPnl = new JPanel();
        rightPnl.setBackground(new Color(144, 238, 144)); // Màu xanh nhạt
        rightPnl.setPreferredSize(new Dimension(150, 400));
        signInPnl.add(rightPnl, BorderLayout.WEST);

        // Panel nhập thông tin
        txtPnl = new JPanel();
        txtPnl.setLayout(new GridBagLayout());
        txtPnl.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tiêu đề
        JLabel titleLbl = new JLabel("Đăng Nhập", SwingConstants.CENTER);
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

        passField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        txtPnl.add(passField, gbc);

        // Nút Đăng Nhập
        signInBtn = new JButton("Đăng nhập");
        signInBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signInBtn.setBackground(new Color(100, 149, 237));
        signInBtn.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        txtPnl.add(signInBtn, gbc);

        // Thêm panel nhập thông tin
        signInPnl.add(txtPnl, BorderLayout.CENTER);

        // Phần đăng ký phía dưới
        JPanel bottomPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPnl.setBackground(Color.LIGHT_GRAY);

        JLabel noAccountLbl = new JLabel("Bạn chưa có tài khoản?");
        signUpBtn = new JButton("Đăng ký");
        signUpBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        signUpBtn.setBackground(new Color(192, 192, 192));
        signUpBtn.setForeground(Color.BLACK);

        bottomPnl.add(noAccountLbl);
        bottomPnl.add(signUpBtn);
        signInPnl.add(bottomPnl, BorderLayout.SOUTH);

        // Xử lý sự kiện cho nút
        SignInController signInController = new SignInController(this);
        signInController.initController();

        // Thiết lập JFrame
        this.setContentPane(signInPnl);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new SignInForm();
        frame.setVisible(true);
    }

}
