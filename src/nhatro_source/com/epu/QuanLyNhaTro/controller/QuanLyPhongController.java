package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.NhaTro;
import com.epu.QuanLyNhaTro.model.Phong;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.QuanLyPhongForm;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseEvent;
import java.util.List;

public class QuanLyPhongController {
    private final QuanLyPhongForm quanLyPhongForm;
    private String absolutePath = "";


    public QuanLyPhongController(QuanLyPhongForm quanLyPhongForm) {
        this.quanLyPhongForm = quanLyPhongForm;
    }

    public void init() {
        showData();
        quanLyPhongForm.getThemBtn().addActionListener(e -> handleThemBtn());
        quanLyPhongForm.getSuaBtn().addActionListener(e -> handleSuaBtn());
        quanLyPhongForm.getXoaBtn().addActionListener(e -> handleXoaBtn());
        //quanLyPhongForm.getLamMoiBtn().addActionListener(e -> handleLamMoiBtn());
        quanLyPhongForm.getChonAnhBtn().addActionListener(e -> handleChonAnhBtn());
    }

    private void showData(){
        PhongDAO phongDAO = new PhongDAOImpl();
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        List<Phong> phongs = phongDAO.getAllPhong();

        if((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Admin")){
            for (int i = 0; i < phongs.size(); i++) {
                int maPhong = phongs.get(i).getMaPhong();
                String tenPhong = phongs.get(i).getTenPhong();
                int maNhaTro = phongs.get(i).getMaNhaTro();
                KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
                String loaiPhong = kieuPhongDAO.getKieuPhong(phongs.get(i).getMaKieuPhong()).getLoaiPhong();
                String giaPhong = String.valueOf(kieuPhongDAO.getKieuPhong(phongs.get(i).getMaKieuPhong()).getGiaPhong());
                String anhPhong = phongs.get(i).getUrlImage();
                quanLyPhongForm.getDanhSachPanel().add(quanLyPhongForm.createPhongPanel(maPhong, tenPhong, maNhaTro, loaiPhong, giaPhong, anhPhong));
            }
        }
        else {
            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
            List<NhaTro> nhaTros = nhaTroDAO.getAllNhaTroByMaChuNha(taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan()));
            System.out.println(taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan()));
            System.out.println(Constant.taiKhoan.getMaTaiKhoan());
            for(NhaTro nhaTro : nhaTros){
                System.out.println(nhaTro.getMaNhaTro());
                List<Phong> phongs1 = phongDAO.getAllPhongByMaNhaTro(nhaTro.getMaNhaTro());
                for (int i = 0; i < phongs1.size(); i++) {
                    int maPhong = phongs1.get(i).getMaPhong();
                    System.out.println(maPhong);
                    String tenPhong = phongs1.get(i).getTenPhong();
                    int maNhaTro = phongs1.get(i).getMaNhaTro();
                    KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
                    String loaiPhong = kieuPhongDAO.getKieuPhong(phongs1.get(i).getMaKieuPhong()).getLoaiPhong();
                    String giaPhong = String.valueOf(kieuPhongDAO.getKieuPhong(phongs1.get(i).getMaKieuPhong()).getGiaPhong());
                    String anhPhong = phongs1.get(i).getUrlImage();
                    quanLyPhongForm.getDanhSachPanel().add(quanLyPhongForm.createPhongPanel(maPhong, tenPhong, maNhaTro, loaiPhong, giaPhong, anhPhong));
                }
            }
        }
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
                absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                quanLyPhongForm.getChonAnhBtn().setText(fileChooser.getSelectedFile().getName());
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn file định dạng PNG!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void clearDanhSachPanel() {
        quanLyPhongForm.getDanhSachPanel().removeAll(); // Xóa tất cả các thành phần con
        quanLyPhongForm.getDanhSachPanel().revalidate(); // Cập nhật bố cục (layout)
        quanLyPhongForm.getDanhSachPanel().repaint();    // Vẽ lại giao diện
    }


    private void handleThemBtn(){
        PhongDAO phongDAO = new PhongDAOImpl();
        KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
        String tenPhong = quanLyPhongForm.getTenPhongField().getText();
        int maKieuPhong = kieuPhongDAO.getKieuPhong(Integer.parseInt(quanLyPhongForm.getLoaiPhongField().getText())).getMaKieuPhong();
        int maNhaTro = Integer.parseInt(quanLyPhongForm.getMaNhaTroField().getText());
        String urlImage = absolutePath;

        if(tenPhong.isEmpty() || urlImage.isEmpty() || quanLyPhongForm.getLoaiPhongField().getText().isEmpty() || quanLyPhongForm.getMaNhaTroField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm phòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(i == JOptionPane.YES_OPTION){
                phongDAO.addPhong(tenPhong, maKieuPhong, maNhaTro, urlImage);
                JOptionPane.showMessageDialog(null, "Thêm phòng thành công!");
                clearDanhSachPanel();
                showData();
            }
        }
    }

    private void handleSuaBtn(){
        PhongDAO phongDAO = new PhongDAOImpl();
        KieuPhongDAO kieuPhongDAO = new KieuPhongDAOImpl();
        int maPhong = Integer.parseInt(quanLyPhongForm.getMaPhongField().getText());
        String tenPhong = quanLyPhongForm.getTenPhongField().getText();
        int maKieuPhong = kieuPhongDAO.getKieuPhong(Integer.parseInt(quanLyPhongForm.getLoaiPhongField().getText())).getMaKieuPhong();
        int maNhaTro = Integer.parseInt(quanLyPhongForm.getMaNhaTroField().getText());
        String urlImage = quanLyPhongForm.getChonAnhBtn().getText();

        if(tenPhong.isEmpty() || urlImage.isEmpty() || quanLyPhongForm.getLoaiPhongField().getText().isEmpty() || quanLyPhongForm.getMaNhaTroField().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa phòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(i == JOptionPane.YES_OPTION){
                phongDAO.updatePhong(maPhong, tenPhong, maKieuPhong, maNhaTro, urlImage);
                JOptionPane.showMessageDialog(null, "Sửa phòng thành công!");
                clearDanhSachPanel();
                showData();
            }
        }
    }

    private void handleXoaBtn(){
        PhongDAO phongDAO = new PhongDAOImpl();
        int maPhong = Integer.parseInt(quanLyPhongForm.getMaPhongField().getText());

        if(maPhong == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                phongDAO.deletePhong(maPhong);
                JOptionPane.showMessageDialog(null, "Xóa phòng thành công!");
                clearDanhSachPanel();
                showData();
            }
        }
    }
}
