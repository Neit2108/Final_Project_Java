package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.TaiKhoanDAO;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAOImpl;
import com.epu.QuanLyNhaTro.model.TaiKhoan;
import com.epu.QuanLyNhaTro.util.Authenticator;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.util.DatabaseConnection;
import com.epu.QuanLyNhaTro.view.MenuForm;
import com.epu.QuanLyNhaTro.view.SignInForm;
import com.epu.QuanLyNhaTro.view.SignUpForm;
import com.epu.QuanLyNhaTro.view.SignUpInforForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInController {
    private final SignInForm signInForm;
    //private final SignUpController signUpController;
    private final TaiKhoanDAO taiKhoanDAO;

    public SignInController(SignInForm signInForm) throws SQLException {
        this.signInForm = signInForm;
        this.taiKhoanDAO = new TaiKhoanDAOImpl();
    }

    public void initController() {
        this.signInForm.getSignInBtn().addActionListener(this::handleSignIn);
        this.signInForm.getSignUpBtn().addActionListener(this::handleSignUp);
    }

    private boolean checkLogin(String email){
        String query = "select isFirstLogin from TaiKhoan where email = ?";
        try(PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                boolean isFirstLogin = rs.getBoolean("isFirstLogin");
                if(isFirstLogin){
                    updateLogin(email);
                }
                return isFirstLogin;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void updateLogin(String email){
        String query = "update TaiKhoan set isFirstLogin = 0 where email = ?";
        try(PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query)){
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleSignIn(ActionEvent e) {
        String email = signInForm.getEmailField().getText();
        String pass = new String(signInForm.getPassField().getPassword());

        if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (!Authenticator.isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Authenticator.isValidPassword(pass)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 6 ký tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (taiKhoanDAO.getTaiKhoan(email) == null) {
            JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (!Authenticator.isValidUser(email, pass)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                TaiKhoan tk = taiKhoanDAO.getTaiKhoan(email);
                Constant.taiKhoan = tk;
                Constant.role = tk.getVaiTro();
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                if (checkLogin(email)) {
                    signInForm.dispose();
                    SignUpInforForm signUpInforForm = new SignUpInforForm();
                    signUpInforForm.setVisible(true);
                }
                else {
                    signInForm.dispose();
                    new MenuForm().setVisible(true);
                }
            }
        }
    }

    private void handleSignUp(ActionEvent e) {
        try {
            signInForm.dispose();
            new SignUpForm().setVisible(true);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
