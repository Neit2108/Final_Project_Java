package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.Pack_chua_code_mau_tren_gpt.RoomListWithStyledUI;
import com.epu.QuanLyNhaTro.view.HomePage;
import com.epu.QuanLyNhaTro.view.IntroForm;
import com.epu.QuanLyNhaTro.view.SignInForm;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePageController {
    private final HomePage homePage;

    public HomePageController(HomePage homePage) {
        this.homePage = homePage;
    }

    public void initController() {
        homePage.getHomeLbl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleHome(e);
            }
        });
        homePage.getInforLbl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleInfor(e);
            }
        });
        homePage.getIntroLbl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleIntro(e);
            }
        });
        homePage.getContactLbl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleContact(e);
            }
        });
    }

    void handleHome(MouseEvent e) {
        homePage.dispose();
        new HomePage().setVisible(true);
    }

    void handleInfor(MouseEvent e) {
        try{
            new RoomListWithStyledUI().setVisible(true);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void handleIntro(MouseEvent e) {
        try{
            new IntroForm().setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void handleContact(MouseEvent e) {
        try{
            new SignInForm().setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

