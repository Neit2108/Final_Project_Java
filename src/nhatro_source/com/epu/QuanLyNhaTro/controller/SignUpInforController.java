package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.MenuForm;
import com.epu.QuanLyNhaTro.view.SignUpInforForm;

import javax.swing.*;
import java.time.LocalDate;

public class SignUpInforController {
    private final SignUpInforForm signUpInforForm;

    public SignUpInforController(SignUpInforForm signUpInforForm) {
        this.signUpInforForm = signUpInforForm;
    }

    public void init(){

    }

    private void handleSubmitBtn(){
        String cccd = signUpInforForm.getCccdField().getText();
        String name = signUpInforForm.getNameField().getText();
        String birthday = signUpInforForm.getBirthdayField().getText();
        String gender = signUpInforForm.getGenderField().getText();
        String phoneNumber = signUpInforForm.getPhoneNumberField().getText();
        String address = signUpInforForm.getAddressField().getText();

        if(cccd.isEmpty() || name.isEmpty() || birthday.isEmpty() || gender.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(Constant.role.equalsIgnoreCase("Chủ Nhà")){
            ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
            chuNhaDAO.addChuNha(cccd, name, LocalDate.parse(birthday), gender, phoneNumber, address, Constant.taiKhoan.getMaTaiKhoan());
        }
        if (Constant.role.equalsIgnoreCase("Khách Thuê")){
            KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
            khachThueDAO.addKhachThue(cccd, name, LocalDate.parse(birthday), gender, phoneNumber, address, Constant.taiKhoan.getMaTaiKhoan());
        }
        JOptionPane.showMessageDialog(null, "Thông tin đã được lưu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        signUpInforForm.dispose();
        new MenuForm().setVisible(true);
    }
}
