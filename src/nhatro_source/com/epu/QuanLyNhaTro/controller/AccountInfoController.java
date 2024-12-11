package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.Admin;
import com.epu.QuanLyNhaTro.model.ChuNha;
import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.model.TaiKhoan;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.AccountInfoFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class AccountInfoController {
    private final AccountInfoFrame accountInfoFrame;

    public AccountInfoController(AccountInfoFrame accountInfoFrame) {
        this.accountInfoFrame = accountInfoFrame;
    }

    public void init(){
        handleInfo();
        accountInfoFrame.getAddressTextField().setEditable(false);
        accountInfoFrame.getBirthTextField().setEditable(false);
        accountInfoFrame.getCccdTextField().setEditable(false);
        accountInfoFrame.getEmailTextField().setEditable(false);
        accountInfoFrame.getGenderTextField().setEditable(false);
        accountInfoFrame.getPhoneTextField().setEditable(false);
        accountInfoFrame.getNameTextField().setEditable(false);

        accountInfoFrame.getSaveButton().setEnabled(false);
        accountInfoFrame.getEditButton().addActionListener(this::handleEditButton);
        accountInfoFrame.getSaveButton().addActionListener(this::handleSaveButton);
    }

    private void handleEditButton(ActionEvent event){
        accountInfoFrame.getAddressTextField().setEditable(true);
        accountInfoFrame.getBirthTextField().setEditable(true);
        accountInfoFrame.getCccdTextField().setEditable(true);
        accountInfoFrame.getEmailTextField().setEditable(true);
        accountInfoFrame.getGenderTextField().setEditable(true);
        accountInfoFrame.getPhoneTextField().setEditable(true);
        accountInfoFrame.getNameTextField().setEditable(true);

        accountInfoFrame.getSaveButton().setEnabled(true);
    }

    private void handleSaveButton(ActionEvent event){
        String email = accountInfoFrame.getEmailTextField().getText();
        String phone = accountInfoFrame.getPhoneTextField().getText();
        String address = accountInfoFrame.getAddressTextField().getText();
        String name = accountInfoFrame.getNameTextField().getText();
        String birth = accountInfoFrame.getBirthTextField().getText();
        String cccd = accountInfoFrame.getCccdTextField().getText();
        String gender = accountInfoFrame.getGenderTextField().getText();

        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
        int maTaiKhoan = Constant.taiKhoan.getMaTaiKhoan();

        if(Constant.role.equalsIgnoreCase("Khách Thuê")){
            int id = taiKhoanDAO.getMaKhachThue(maTaiKhoan);
            new KhachThueDAOImpl().updateKhachThueByMa(id, cccd, name, LocalDate.parse(birth), gender, phone, address, maTaiKhoan);
        }
        else if(Constant.role.equalsIgnoreCase("Chủ Nhà")){
            int id = taiKhoanDAO.getMaChuNha(maTaiKhoan);
            new ChuNhaDAOImpl().updateChuNhaByMa(id, cccd, name, LocalDate.parse(birth), gender, phone, address, maTaiKhoan);
        }
        else if(Constant.role.equalsIgnoreCase("Admin")){
            int id = taiKhoanDAO.getMaAdmin(maTaiKhoan);
            new AdminDAOImpl().updateAdmin(cccd, name, LocalDate.parse(birth), gender, phone, address, id, maTaiKhoan);
        }

        accountInfoFrame.getAddressTextField().setEditable(false);
        accountInfoFrame.getBirthTextField().setEditable(false);
        accountInfoFrame.getCccdTextField().setEditable(false);
        accountInfoFrame.getEmailTextField().setEditable(false);
        accountInfoFrame.getGenderTextField().setEditable(false);
        accountInfoFrame.getPhoneTextField().setEditable(false);
        accountInfoFrame.getNameTextField().setEditable(false);

        JOptionPane.showMessageDialog(accountInfoFrame, "Cập nhật thông tin thành công");
        accountInfoFrame.getSaveButton().setEnabled(false);
    }

    private void handleInfo(){
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
        int maTaiKhoan = Constant.taiKhoan.getMaTaiKhoan();
        if(Constant.role.equalsIgnoreCase("Khách Thuê")){
            int id = taiKhoanDAO.getMaKhachThue(maTaiKhoan);
            KhachThue khachThue = new KhachThueDAOImpl().getKhachThue(id);
            accountInfoFrame.getNameLabel().setText(khachThue.getTen());
            accountInfoFrame.getNameTextField().setText(khachThue.getTen());
            accountInfoFrame.getEmailTextField().setText(Constant.taiKhoan.getEmail());
            accountInfoFrame.getPhoneTextField().setText(khachThue.getSoDienThoai());
            accountInfoFrame.getAddressTextField().setText(khachThue.getDiaChi());
            accountInfoFrame.getGenderTextField().setText(khachThue.getGioiTinh());
            accountInfoFrame.getBirthTextField().setText(khachThue.getNgaySinh().toString());
            accountInfoFrame.getCccdTextField().setText(khachThue.getMaCCCD());
        }
        else if(Constant.role.equalsIgnoreCase("Chủ Nhà")){
            int id = taiKhoanDAO.getMaChuNha(maTaiKhoan);
            ChuNha chuNha = new ChuNhaDAOImpl().getChuNhaByMa(id);
            accountInfoFrame.getNameLabel().setText(chuNha.getTen());
            accountInfoFrame.getNameTextField().setText(chuNha.getTen());
            accountInfoFrame.getEmailTextField().setText(Constant.taiKhoan.getEmail());
            accountInfoFrame.getPhoneTextField().setText(chuNha.getSoDienThoai());
            accountInfoFrame.getAddressTextField().setText(chuNha.getDiaChi());
            accountInfoFrame.getGenderTextField().setText(chuNha.getGioiTinh());
            accountInfoFrame.getBirthTextField().setText(chuNha.getNgaySinh().toString());
            accountInfoFrame.getCccdTextField().setText(chuNha.getMaCCCD());
        }
        else if(Constant.role.equalsIgnoreCase("Admin")){
            int id = taiKhoanDAO.getMaAdmin(maTaiKhoan);
            Admin admin = new AdminDAOImpl().getAdminByMa(id);
            accountInfoFrame.getNameLabel().setText(admin.getTen());
            accountInfoFrame.getNameTextField().setText(admin.getTen());
            accountInfoFrame.getEmailTextField().setText(Constant.taiKhoan.getEmail());
            accountInfoFrame.getPhoneTextField().setText(admin.getSoDienThoai());
            accountInfoFrame.getAddressTextField().setText(admin.getDiaChi());
            accountInfoFrame.getGenderTextField().setText(admin.getGioiTinh());
            accountInfoFrame.getBirthTextField().setText(admin.getNgaySinh().toString());
            accountInfoFrame.getCccdTextField().setText(admin.getMaCCCD());
        }
    }
}
