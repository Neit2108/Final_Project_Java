package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.HopDong;
import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.ContractForm;
import com.epu.QuanLyNhaTro.view.DetailContract;
import com.epu.QuanLyNhaTro.view.DetailRoom;

import java.awt.*;
import java.util.List;

public class ContractFormController {
    private final ContractForm contractForm;

    public ContractFormController(ContractForm contractForm) {
        this.contractForm = contractForm;
    }

    public void init() {
        this.showData();
        this.contractForm.getMainTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                handleTable();
            }
        });

        this.contractForm.getMainTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = contractForm.getMainTable().getSelectedRow();
                    if (selectedRow != -1) {
                        DetailContract detailContract = new DetailContract();
                        DetailContractController detailContractController = new DetailContractController(detailContract, contractForm);
                        detailContractController.init();
                        detailContract.setVisible(true);
                    }
                }
            }
        });
    }

    private void showData() {
        contractForm.getTableModel().setRowCount(0);
        if ((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Khách Thuê")) {
            showDataForTenant();
        }
        else if ((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Chủ Nhà")) {
            showDataForLanLord();
        }
        else {
            showDataforAdmin();
        }
    }

    private void showDataforAdmin(){
        HopDongDAO hopDongDAO = new HopDongDAOImpl();
        List<HopDong> hopDongList = hopDongDAO.getAllHopDong();
        for (HopDong x : hopDongList) {
            String[] row = new String[]{String.valueOf(x.getMaHopDong()), String.valueOf(x.getMaPhong()), String.valueOf(x.getMaKhachThue()), String.format("%.2f", x.getTienCoc()), String.valueOf(x.getNgayThue()), String.valueOf(x.getThoiHanHopDong() + " tháng"), String.valueOf(x.getNgayTao().toLocalDate()), x.getTrangThai()};
            this.contractForm.getTableModel().addRow(row);
        }
    }

    private void showDataForLanLord(){
        HopDongDAO hopDongDAO = new HopDongDAOImpl();
        ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
        List<HopDong> hopDongList = hopDongDAO.getHopDongByMaChuNha(taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan()));
        for (HopDong x : hopDongList) {
            String[] row = new String[]{String.valueOf(x.getMaHopDong()), String.valueOf(x.getMaPhong()), String.valueOf(x.getMaKhachThue()), String.format("%.2f", x.getTienCoc()), String.valueOf(x.getNgayThue()), String.valueOf(x.getThoiHanHopDong() + " tháng"), String.valueOf(x.getNgayTao().toLocalDate()), x.getTrangThai()};
            this.contractForm.getTableModel().addRow(row);
        }
    }

    private void showDataForTenant() {
        HopDongDAO hopDongDAO = new HopDongDAOImpl();
        KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
        List<HopDong> hopDongList = hopDongDAO.getHopDongByMaKhach(taiKhoanDAO.getMaKhachThue(Constant.taiKhoan.getMaTaiKhoan()));
        for (HopDong x : hopDongList) {
            KhachThue khachThue = khachThueDAO.getKhachThue(x.getMaKhachThue());
            String[] row = new String[]{String.valueOf(x.getMaHopDong()), String.valueOf(x.getMaPhong()), String.valueOf(khachThue.getMaKhach()), String.format("%.2f", x.getTienCoc()), String.valueOf(x.getNgayThue()), String.valueOf(x.getThoiHanHopDong() + " tháng"), String.valueOf(x.getNgayTao().toLocalDate()), x.getTrangThai()};
            this.contractForm.getTableModel().addRow(row);
        }
    }

        private void handleTable () {
            int selectedRow = this.contractForm.getMainTable().getSelectedRow();
            if (selectedRow != -1) {
                String maHopDong = this.contractForm.getMainTable().getValueAt(selectedRow, 0).toString();
                String maPhong = this.contractForm.getMainTable().getValueAt(selectedRow, 1).toString();
                String maKhachThue = this.contractForm.getMainTable().getValueAt(selectedRow, 2).toString();
                String tienCoc = this.contractForm.getMainTable().getValueAt(selectedRow, 3).toString();
                String ngayThue = this.contractForm.getMainTable().getValueAt(selectedRow, 4).toString();
                String thoiHanHopDong = this.contractForm.getMainTable().getValueAt(selectedRow, 5).toString();
                String ngayTao = this.contractForm.getMainTable().getValueAt(selectedRow, 6).toString();
                String trangThai = this.contractForm.getMainTable().getValueAt(selectedRow, 7).toString();

                this.contractForm.getMahdField().setText(maHopDong);
                this.contractForm.getMaphongField().setText(maPhong);
                this.contractForm.getMakhachField().setText(maKhachThue);
                this.contractForm.getTiencocField().setText(tienCoc);
                this.contractForm.getNgaythueField().setText(ngayThue);
                this.contractForm.getTimeField().setText(thoiHanHopDong);
                this.contractForm.getNgaytaoField().setText(ngayTao);
                this.contractForm.getTrangthaiField().setText(trangThai);
            }
        }

        public void setNull () {
            this.contractForm.getMahdField().setText("");
            this.contractForm.getMaphongField().setText("");
            this.contractForm.getMakhachField().setText("");
            this.contractForm.getTiencocField().setText("");
            this.contractForm.getNgaythueField().setText("");
            this.contractForm.getTimeField().setText("");
            this.contractForm.getNgaytaoField().setText("");
            this.contractForm.getTrangthaiField().setText("");
        }
    }
