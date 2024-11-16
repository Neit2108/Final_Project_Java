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
        this.menuForm.getQuanlyBtn().addActionListener(this::handleQuanLyBtn);
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

    private void handleQuanLyBtn(ActionEvent event){
        this.menuForm.getCardLayout().show(this.menuForm.getMainPanel(), "QuanLy");
    }

    private void handleNhaBtn(ActionEvent event){
        System.out.println(2);
    }



}
