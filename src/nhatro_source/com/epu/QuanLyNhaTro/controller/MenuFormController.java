package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.MenuForm;
import com.epu.QuanLyNhaTro.view.SignInForm;
import com.epu.QuanLyNhaTro.view.TenantManagement;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class MenuFormController {
    private final MenuForm menuForm;

    public MenuFormController(MenuForm menuForm) {
        this.menuForm = menuForm;
    }

    public void init(){
        if((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Khách Thuê")){
            this.menuForm.getQuanlyBtn().setVisible(false);
            this.menuForm.getPctBtn().setVisible(false);
            this.menuForm.getNhaBtn().setVisible(false);
        }

        this.menuForm.getDangxuatBtn().addActionListener(this::handleDangXuatBtn);
        this.menuForm.getHomePageBtn().addActionListener(this::handleHomePageBtn);
        this.menuForm.getQuanlyBtn().addActionListener(this::handleKhachThueBtn);
        this.menuForm.getPctBtn().addActionListener(this::handleQuanLyPhongBtn);
        this.menuForm.getNhaBtn().addActionListener(this::handleNhaBtn);
        this.menuForm.getHopdongBtn().addActionListener(this::handleContractBtn);
        this.menuForm.getHoadonBtn().addActionListener(this::handleInvoiceBtn);
    }

    private void handleDangXuatBtn(ActionEvent event){
        try{
            this.menuForm.dispose();
            new SignInForm().setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleNhaBtn(ActionEvent event){
        System.out.println(2);
    }

    private void handleKhachThueBtn(ActionEvent event){
        this.menuForm.getCardLayout().show(this.menuForm.getMainPanel(), "QuanLyKhachThue");
    }

    private void handleQuanLyPhongBtn(ActionEvent event){
        this.menuForm.getCardLayout().show(this.menuForm.getMainPanel(), "QuanLyPhong");
    }

    private void handleHomePageBtn(ActionEvent event){
        this.menuForm.getCardLayout().show(this.menuForm.getMainPanel(), "HomePage");
    }

    private void handleContractBtn(ActionEvent event){
        this.menuForm.getCardLayout().show(this.menuForm.getMainPanel(), "HopDong");
    }

    private void handleInvoiceBtn(ActionEvent event){
        this.menuForm.getCardLayout().show(this.menuForm.getMainPanel(), "HoaDon");
    }

}
