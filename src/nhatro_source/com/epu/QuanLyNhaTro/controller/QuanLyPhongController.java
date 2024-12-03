package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.KieuPhongDAO;
import com.epu.QuanLyNhaTro.dao.KieuPhongDAOImpl;
import com.epu.QuanLyNhaTro.dao.PhongDAO;
import com.epu.QuanLyNhaTro.dao.PhongDAOImpl;
import com.epu.QuanLyNhaTro.model.Phong;
import com.epu.QuanLyNhaTro.view.QuanLyPhongForm;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseEvent;

public class QuanLyPhongController {
    private final QuanLyPhongForm quanLyPhongForm;

    public QuanLyPhongController(QuanLyPhongForm quanLyPhongForm) {
        this.quanLyPhongForm = quanLyPhongForm;
    }

    public void init() {
        quanLyPhongForm.getThemBtn().addActionListener(e -> handleThemBtn());
        quanLyPhongForm.getSuaBtn().addActionListener(e -> handleSuaBtn());
        quanLyPhongForm.getXoaBtn().addActionListener(e -> handleXoaBtn());
        //quanLyPhongForm.getLamMoiBtn().addActionListener(e -> handleLamMoiBtn());
        quanLyPhongForm.getChonAnhBtn().addActionListener(e -> handleChonAnhBtn());
    }

    public void handleRoomClick(MouseEvent event, int maPhong) {
        PhongDAO phongDAO = new PhongDAOImpl();
        KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
        Phong phong = phongDAO.getPhong(maPhong);
        quanLyPhongForm.getMaPhongField().setText(String.valueOf(maPhong));
        quanLyPhongForm.getGiaPhongField().setText(String.valueOf(phongDAO.getGiaPhong(maPhong)));
        quanLyPhongForm.getMaNhaTroField().setText(String.valueOf(phong.getMaNhaTro()));
        quanLyPhongForm.getLoaiPhongField().setText(String.valueOf(kieuPhongDAO.getKieuPhong(phong.getMaKieuPhong()).getMaKieuPhong()));
        quanLyPhongForm.getTenPhongField().setText(phong.getTenPhong());
        quanLyPhongForm.getChonAnhBtn().setText(phong.getUrlImage());
    }

    private void handleChonAnhBtn() {
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().getName().toLowerCase().endsWith(".png")) {
                quanLyPhongForm.getChonAnhBtn().setText(fileChooser.getSelectedFile().getName());
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn file định dạng PNG!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleThemBtn(){
        PhongDAO phongDAO = new PhongDAOImpl();
        KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
        String tenPhong = quanLyPhongForm.getTenPhongField().getText();
        int maKieuPhong = kieuPhongDAO.getKieuPhong(Integer.parseInt(quanLyPhongForm.getLoaiPhongField().getText())).getMaKieuPhong();
        int maNhaTro = Integer.parseInt(quanLyPhongForm.getMaNhaTroField().getText());
        String urlImage = quanLyPhongForm.getChonAnhBtn().getText();
        phongDAO.addPhong(tenPhong, maKieuPhong, maNhaTro, urlImage);
    }

    private void handleSuaBtn(){
        PhongDAO phongDAO = new PhongDAOImpl();
        KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
        int maPhong = Integer.parseInt(quanLyPhongForm.getMaPhongField().getText());
        String tenPhong = quanLyPhongForm.getTenPhongField().getText();
        int maKieuPhong = kieuPhongDAO.getKieuPhong(Integer.parseInt(quanLyPhongForm.getLoaiPhongField().getText())).getMaKieuPhong();
        int maNhaTro = Integer.parseInt(quanLyPhongForm.getMaNhaTroField().getText());
        String urlImage = quanLyPhongForm.getChonAnhBtn().getText();
        phongDAO.updatePhong(maPhong, tenPhong, maKieuPhong, maNhaTro, urlImage);
    }

    private void handleXoaBtn(){
        PhongDAO phongDAO = new PhongDAOImpl();
        int maPhong = Integer.parseInt(quanLyPhongForm.getMaPhongField().getText());
        phongDAO.deletePhong(maPhong);
    }
}
