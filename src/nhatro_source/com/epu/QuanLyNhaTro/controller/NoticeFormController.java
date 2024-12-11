package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.ThongBao;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.DetailInvoiceForm;
import com.epu.QuanLyNhaTro.view.InforContractForm;
import com.epu.QuanLyNhaTro.view.NoticeForm;
import com.epu.QuanLyNhaTro.view.PaymentDetailsForm;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

public class NoticeFormController {
    private final NoticeForm noticeForm;
    private final ThongBaoDAO thongBaoDAO;

    public NoticeFormController(NoticeForm noticeForm) {
        this.noticeForm = noticeForm;
        this.thongBaoDAO = new ThongBaoDAOImpl();
    }

    public void init(){
        handleTable();
        noticeForm.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleCheckBox(evt);
            }
        });
        noticeForm.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleClickOnTable(evt);
            }
        });
        noticeForm.getBtnDeleteAll().addActionListener(e -> {
            thongBaoDAO.deleteAllThongBao(Constant.taiKhoan.getMaTaiKhoan());
            noticeForm.getTableModel().setRowCount(0);
        });
    }

    private void handleTable(){
        List<ThongBao> thongBaoList = thongBaoDAO.getAllThongBao(Constant.taiKhoan.getMaTaiKhoan());
        int i = 1;
        for(ThongBao x : thongBaoList){
            noticeForm.getTableModel().addRow(
                    new Object[]{
                            x.getId(),
                            i++,
                            x.getNoiDung(),
                            x.getNgayTao(),
                            x.getTrangThai().equalsIgnoreCase("Chưa xem") ? false : true
                    }
            );
        }
    }

    private void handleCheckBox(MouseEvent event){
        int row = noticeForm.getTable().rowAtPoint(event.getPoint());
        int col = noticeForm.getTable().columnAtPoint(event.getPoint());

        if(col == 4){
            boolean check = (boolean) noticeForm.getTable().getValueAt(row, col);
            if(check){
                noticeForm.getTable().setValueAt(true, row, col);
                int id = (int) noticeForm.getTable().getValueAt(row, 0);
                thongBaoDAO.updateTrangThaiThongBao(id);
                noticeForm.getTable().repaint();
            } else {
                noticeForm.getTable().setValueAt(false, row, col);
            }
        }
    }

    private void handleClickOnTable(MouseEvent event){
        int clicked = event.getClickCount();
        if(clicked == 2 && Constant.role.equalsIgnoreCase("Chủ nhà")){
            int row = noticeForm.getTable().getSelectedRow();
            int id = (int) noticeForm.getTable().getValueAt(row, 0);
            ThongBao thongBao = thongBaoDAO.getThongBao(id);
            System.out.println(thongBao);
            String txt = "Nội dung: " + thongBao.getNoiDung() + "\n" +
                    "Ngày nhận: " + thongBao.getNgayTao() + "\n" +
                    "Trạng thái: " + thongBao.getTrangThai() + "\n";
            //int res = JOptionPane.showConfirmDialog(null, txt, "Thông báo", JOptionPane.YES_NO_OPTION);
            if((thongBao.getLoaiThongBao() != null ? thongBao.getLoaiThongBao() : "ThuePhong").equalsIgnoreCase("ThuePhong")){
                int res = JOptionPane.showConfirmDialog(null, txt, "Thông báo", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
                    int maKhach = taiKhoanDAO.getMaKhachThue(thongBao.getMaNguoiGui());
                    InforContractForm inforContractForm = new InforContractForm();
                    inforContractForm.setVisible(true);
                    inforContractForm.getTxtMaKhach().setText(String.valueOf(maKhach));
                    inforContractForm.getTxtMaPhong().setText(String.valueOf(thongBao.getMaPhong()));
                    inforContractForm.getTxtNgayThue().setText(String.valueOf(LocalDate.now().plusDays(1)));
                    inforContractForm.getBtnLuu().addActionListener(e -> {
                        int thoiHan = Integer.parseInt(inforContractForm.getTxtThoiHan().getText());
                        int soNguoi = Integer.parseInt(inforContractForm.getTxtSoNguoi().getText());
                        double tienCoc = Double.parseDouble(inforContractForm.getTxtTienCoc().getText());
                        HopDongDAO hopDongDAO = new HopDongDAOImpl();
                        hopDongDAO.addHopDong(thongBao.getMaPhong(), maKhach, tienCoc, LocalDate.now().plusDays(1), thoiHan, "Còn hiệu lực", soNguoi);
                        new PhongDAOImpl().updateTrangThaiPhong(thongBao.getMaPhong());
                        thongBaoDAO.updateTrangThaiThongBao(id);
                        noticeForm.getTableModel().setValueAt(true, row, 4);
                        JOptionPane.showMessageDialog(null, "Đã thêm hợp đồng thành công và gửi thông báo tới khách thuê");
                        String txt2 = "Yêu cầu thuê phòng" + new PhongDAOImpl().getPhong(thongBao.getMaPhong()).getTenPhong() + "(Mã phòng : " + thongBao.getMaPhong() + ") của bạn đã được chấp nhận";
                        thongBaoDAO.addThongBao(Constant.taiKhoan.getMaTaiKhoan(), thongBao.getMaNguoiGui(), txt2, "Chưa xem", thongBao.getMaPhong(), "YeuCauThuePhong");
                        inforContractForm.dispose();
                    });
                }
                else {
                    thongBaoDAO.updateTrangThaiThongBao(id);
                    String txt3 = "Yêu cầu thuê phòng" + new PhongDAOImpl().getPhong(thongBao.getMaPhong()).getTenPhong() + "(Mã phòng : " + thongBao.getMaPhong() + ") của bạn đã bị từ chối";
                    thongBaoDAO.addThongBao(Constant.taiKhoan.getMaTaiKhoan(), thongBao.getMaNguoiGui(), txt3, "Chưa xem", thongBao.getMaPhong(), "YeuCauThuePhong");
                    noticeForm.getTableModel().setValueAt(true, row, 4);
                    JOptionPane.showMessageDialog(null, "Đã từ chối yêu cầu thuê phòng");
                }
            }
            if((thongBao.getLoaiThongBao() != null ? thongBao.getLoaiThongBao() : "ThanhToan").equalsIgnoreCase("ThanhToan")){
                int res = JOptionPane.showConfirmDialog(null, txt, "Thông báo", JOptionPane.YES_NO_OPTION);
                if(res == JOptionPane.YES_OPTION || res == JOptionPane.NO_OPTION){
                    thongBaoDAO.updateTrangThaiThongBao(id);
                    noticeForm.getTableModel().setValueAt(true, row, 4);
                }
            }
        }

        if(clicked == 2 && Constant.role.equalsIgnoreCase("Khách thuê")){
            int row = noticeForm.getTable().getSelectedRow();
            int id = (int) noticeForm.getTable().getValueAt(row, 0);
            ThongBao thongBao = thongBaoDAO.getThongBao(id);
            String txt = "Nội dung: " + thongBao.getNoiDung() + "\n" +
                    "Ngày nhận: " + thongBao.getNgayTao() + "\n" +
                    "Trạng thái: " + thongBao.getTrangThai() + "\n";

            if(thongBao.getTrangThai().equalsIgnoreCase("YeuCauThuePhong")){
                JOptionPane.showMessageDialog(null, txt);
                noticeForm.getTableModel().setValueAt(true, row, 4);
                thongBaoDAO.updateTrangThaiThongBao(id);
            }
            else if(thongBao.getTrangThai().equalsIgnoreCase("YeuCauThanhToan")){
                int i = JOptionPane.showConfirmDialog(null, txt);
                if(i == JOptionPane.YES_OPTION){
                    noticeForm.getTableModel().setValueAt(true, row, 4);
                    thongBaoDAO.updateTrangThaiThongBao(id);
                    //Hien len form thanh toan

                }
            }

        }


    }
}
