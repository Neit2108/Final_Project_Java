package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.KieuPhong;
import com.epu.QuanLyNhaTro.model.Phong;
import com.epu.QuanLyNhaTro.view.DetailRoom;
import com.epu.QuanLyNhaTro.view.HomePage;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class DetailRoomController {
    private final DetailRoom detailRoom;
    private final PhongDAO phongDAO;
    private final HomePage homePage;
    public DetailRoomController(DetailRoom detailRoom, HomePage homePage) {
        this.detailRoom = detailRoom;
        this.homePage = homePage;
        this.phongDAO = new PhongDAOImpl();
    }


    public void handelDetailRoom(int maPhong) {
        Phong phong = phongDAO.getPhong(maPhong);
        //set ảnh
        detailRoom.getImageLbl().setPreferredSize(new Dimension(200, 200));
        ImageIcon icon = new ImageIcon("src/resources/home.png");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        detailRoom.getImageLbl().setIcon(icon);
        detailRoom.getImageLbl().revalidate();
        detailRoom.getImageLbl().repaint();
        
        //set list service
        Phong_DichVu_DAO phong_dichVu_dao = new Phong_DichVu_DAOImpl();
        detailRoom.getDetailServiceList().setListData(phong_dichVu_dao.getAllTrangThaiPhong(maPhong).toArray());

        //set gia phong vao table
        KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
        KieuPhong kieuPhong = kieuPhongDAO.getKieuPhong(phong.getMaKieuPhong());
        double price = kieuPhong.getGiaPhong();
        double area = kieuPhong.getDienTich();
        DecimalFormat df = new DecimalFormat("#.##");
        detailRoom.getTable1().setValueAt(df.format(area) + " (m2)", 1, 1);
        detailRoom.getTable1().setValueAt(df.format(price) + " (tháng)", 2, 1);

        detailRoom.setVisible(true);

    }
}
