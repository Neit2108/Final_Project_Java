package com.epu.QuanLyNhaTro.controller;

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
        this.menuForm.getDangxuatBtn().addActionListener(this::handleDangXuatBtn);
        this.menuForm.getHomePageBtn().addActionListener(this::handleHomePageBtn);
        this.menuForm.getQuanlyBtn().addActionListener(this::handleKhachThueBtn);
        this.menuForm.getPctBtn().addActionListener(this::handleQuanLyPhongBtn);
        this.menuForm.getNhaBtn().addActionListener(this::handleNhaBtn);
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



}
