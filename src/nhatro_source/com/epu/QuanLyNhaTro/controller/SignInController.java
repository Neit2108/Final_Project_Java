package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.TaiKhoanDAO;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAOImpl;
import com.epu.QuanLyNhaTro.util.Authenticator;
import com.epu.QuanLyNhaTro.view.SignInForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
    }

    public void handleSignIn(ActionEvent e){
        String email = signInForm.getEmailField().getText();
        String pass = new String(signInForm.getPassField().getPassword());

        if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            if (!Authenticator.isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Authenticator.isValidPassword(pass)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 6 ký tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(taiKhoanDAO.getTaiKhoan(email) == null){
            JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            if (!Authenticator.isValidUser(email, pass)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
