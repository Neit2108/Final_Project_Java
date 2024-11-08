package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.TaiKhoanDAO;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAOImpl;
import com.epu.QuanLyNhaTro.util.Authenticator;
import com.epu.QuanLyNhaTro.util.EmailVerification;
import com.epu.QuanLyNhaTro.view.SignInForm;
import com.epu.QuanLyNhaTro.view.SignUpForm;
import com.epu.QuanLyNhaTro.view.signUpCode;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Objects;

public class SignUpController {
    private final SignUpForm signUpForm;
    private final signUpCode signUpCode;
    private final TaiKhoanDAO taiKhoanDAO;
    private final EmailVerification emailVerification;
    private String verifyCode;

    public SignUpController(SignUpForm signUpForm, signUpCode signUpCode) throws SQLException {
        this.signUpForm = signUpForm;
        this.signUpCode = signUpCode;
        this.taiKhoanDAO = new TaiKhoanDAOImpl();
        this.emailVerification = new EmailVerification();
        this.verifyCode = "";
    }

    public void initController() {
        this.signUpForm.getSignUpBtn().addActionListener(this::handleSignUp);
        this.signUpCode.getOkBtn().addActionListener(this::handleGetCode);
    }

    public void handleSignUp(ActionEvent e){
        String email = signUpForm.getEmailField().getText();
        String password = new String(signUpForm.getPasswordField1().getPassword());
        String confirmPassword = new String(signUpForm.getPasswordField2().getPassword());
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            if (!Authenticator.isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Authenticator.isValidPassword(password)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 6 ký tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(!Objects.equals(password, confirmPassword)){
            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(taiKhoanDAO.getTaiKhoan(email) != null){
            JOptionPane.showMessageDialog(null, "Email đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        verifyCode = emailVerification.sendVerificationEmail(email);
        this.signUpCode.setVisible(true);
    }

    public void handleGetCode(ActionEvent e){
        String email = signUpForm.getEmailField().getText();
        String password = new String(signUpForm.getPasswordField1().getPassword());
        String confirmPass = new String(signUpForm.getPasswordField2().getPassword());
        String code = signUpCode.getCodeField().getText();
        if(code.equals(verifyCode)){
            try{
                taiKhoanDAO.addTaiKhoan(email, password, "Admin");
                JOptionPane.showMessageDialog(null, "Đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                signUpCode.dispose();
                signUpForm.dispose();
                SignInForm signInForm = new SignInForm();
                signInForm.setVisible(true);
            }
            catch (SQLException exception){
                JOptionPane.showMessageDialog(null, "Đăng ký thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "Mã xác thực không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


}
