package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.NhaTroDAO;
import com.epu.QuanLyNhaTro.dao.NhaTroDAOImpl;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAO;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAOImpl;
import com.epu.QuanLyNhaTro.model.NhaTro;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.HouseForm;
import com.epu.QuanLyNhaTro.view.QuanLyPhongForm;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;

public class HouseFormController {
    private final HouseForm houseForm;
    private String absolutePath = "";

    public HouseFormController(HouseForm houseForm) {
        this.houseForm = houseForm;
    }

    public void init() {
        showData();
        houseForm.getChonAnhBtn().addActionListener(e -> handleChonAnhBtn(e));
        houseForm.getThemBtn().addActionListener(e -> handleAddHouseBtn(e));
        houseForm.getSuaBtn().addActionListener(e -> handleUpdateHouseBtn(e));
        houseForm.getXoaBtn().addActionListener(e -> handleDeleteHouseBtn(e));
        houseForm.getLamMoiBtn().addActionListener(e -> handleLamMoiBtn(e));
    }

    private void showData() {
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        List<NhaTro> nhaTros = nhaTroDAO.getAllNhaTro();
        if((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("admin")) {
            for(NhaTro nhaTro : nhaTros) {
                houseForm.getDanhSachPanel().add(houseForm.createNhaPanel(nhaTro.getMaNhaTro(), nhaTro.getTrangThai()));
            }
        } else {
            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
            List<NhaTro> nhaTros1 = nhaTroDAO.getAllNhaTroByMaChuNha(taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan()));
            for(NhaTro nhaTro : nhaTros1) {
                houseForm.getDanhSachPanel().add(houseForm.createNhaPanel(nhaTro.getMaNhaTro(), nhaTro.getTrangThai()));
            }
        }
    }

    private void handleAddHouseBtn(ActionEvent e) {
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        if(Constant.role.equalsIgnoreCase("Chủ nhà")){
            int id = new TaiKhoanDAOImpl().getMaChuNha(Constant.taiKhoan.getMaTaiKhoan());
            nhaTroDAO.addNhaTro(id, houseForm.getDiaChiField().getText(), Integer.parseInt(houseForm.getSoLuongPhongField().getText()), houseForm.getTrangThaiComboBox().getSelectedItem().toString(), houseForm.getChonAnhBtn().getText());
        } else {
            nhaTroDAO.addNhaTro(new TaiKhoanDAOImpl().getMaAdmin(Constant.taiKhoan.getMaTaiKhoan()), houseForm.getDiaChiField().getText(), Integer.parseInt(houseForm.getSoLuongPhongField().getText()), houseForm.getTrangThaiComboBox().getSelectedItem().toString(), houseForm.getChonAnhBtn().getText());
        }
        JOptionPane.showMessageDialog(null, "Thêm nhà thành công!");
        houseForm.getDanhSachPanel().removeAll();

        //houseForm.repaint();
        showData();
    }

    private void handleUpdateHouseBtn(ActionEvent e) {
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        int id = new TaiKhoanDAOImpl().getMaChuNha(Constant.taiKhoan.getMaTaiKhoan());
        int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.YES_OPTION){
            nhaTroDAO.updateNhaTro(Integer.parseInt(houseForm.getMaNhaField().getText()), id, houseForm.getDiaChiField().getText(), Integer.parseInt(houseForm.getSoLuongPhongField().getText()), houseForm.getTrangThaiComboBox().getSelectedItem().toString(), houseForm.getChonAnhBtn().getText());
            houseForm.getDanhSachPanel().removeAll();
            //houseForm.repaint();
            showData();

        }
    }

    private void handleDeleteHouseBtn(ActionEvent e) {
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thay đổi", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.YES_OPTION){
            nhaTroDAO.deleteNhaTro(Integer.parseInt(houseForm.getMaNhaField().getText()));
            houseForm.getDanhSachPanel().removeAll();
            //houseForm.repaint();
            showData();

        }
    }

    private void handleChonAnhBtn(ActionEvent event){
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().getName().toLowerCase().endsWith(".png")) {
                absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                houseForm.getChonAnhBtn().setText(fileChooser.getSelectedFile().getName());
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn file định dạng PNG!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void handleClickPanel(MouseEvent e, int maNhaTro) {
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        NhaTro nhaTro = nhaTroDAO.getNhaTroByMaNhaTro(maNhaTro);
        houseForm.getMaNhaField().setText(String.valueOf(nhaTro.getMaNhaTro()));
        houseForm.getDiaChiField().setText(nhaTro.getDiaChi());
        houseForm.getSoLuongPhongField().setText(String.valueOf(nhaTro.getSoLuongPhong()));
        houseForm.getTrangThaiComboBox().setSelectedItem(nhaTro.getTrangThai());
        houseForm.getChonAnhBtn().setText(nhaTro.getUrlImage());
    }

    private void handleLamMoiBtn(ActionEvent event){
        houseForm.getDanhSachPanel().removeAll();
        //houseForm.repaint();
        showData();

    }

    private void handleChiTietBtn(){
        JFrame frame = new JFrame("Quản Lý Phòng - Nhà Trọ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1346, 793);
        frame.add(new QuanLyPhongForm());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
