package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.ChuNha;
import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.model.KieuPhong;
import com.epu.QuanLyNhaTro.model.Phong;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.DetailRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class DetailRoomController {
    private final DetailRoom detailRoom;
    private final PhongDAO phongDAO;

    public DetailRoomController(DetailRoom detailRoom) {
        this.detailRoom = detailRoom;
        this.phongDAO = new PhongDAOImpl();
    }

    public void init(int maPhong){
        if(!(Constant.role.equalsIgnoreCase("Khách thuê"))){
            detailRoom.getThuephongBtn().setVisible(false);
        }
        Phong phong = phongDAO.getPhong(maPhong);
        if(phong.getTrangThai().equalsIgnoreCase("Đã thuê")) {
            detailRoom.getThuephongBtn().setVisible(false);
        }
        detailRoom.getThuephongBtn().addActionListener(e -> handleThuePhongBtn(maPhong));
        handelDetailRoom(maPhong);
    }

    public void handelDetailRoom(int maPhong) {
        Phong phong = phongDAO.getPhong(maPhong);
        //set ảnh
        detailRoom.getImageLbl().setPreferredSize(new Dimension(200, 200));
        ImageIcon icon = new ImageIcon(phong.getUrlImage());
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

    private void handleThuePhongBtn(int maPhong) {
        Phong phong = phongDAO.getPhong(maPhong);
        if(phong.getTrangThai().equalsIgnoreCase("Đã thuê")) {
            JOptionPane.showMessageDialog(detailRoom, "Phòng đã được thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(detailRoom, "Bạn có chắc chắn muốn thuê phòng này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION) {
                KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
                KhachThue khachThue = khachThueDAO.getKhachThue(new TaiKhoanDAOImpl().getMaKhachThue(Constant.taiKhoan.getMaTaiKhoan()));
                String txt = "Khách hàng " + (khachThue.getTen() == null ? "Lê Anh Khoa" : khachThue.getTen()) + " đã gửi yêu cầu thuê phòng " + phong.getTenPhong() + " (Mã phòng : " + phong.getMaPhong() + " ) cho bạn";
                int maChuNha = phongDAO.getMaChuNha(maPhong);
                ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
                ChuNha chuNha = chuNhaDAO.getChuNhaByMa(maChuNha);
                ThongBaoDAO thongBaoDAO = new ThongBaoDAOImpl();
                thongBaoDAO.addThongBao(Constant.taiKhoan.getMaTaiKhoan(), chuNha.getMaTaiKhoan(), txt, "Chưa xem", maPhong, "ThuePhong");
                JOptionPane.showMessageDialog(detailRoom, "Yêu cầu thuê phòng đã được gửi đến chủ nhà", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}
