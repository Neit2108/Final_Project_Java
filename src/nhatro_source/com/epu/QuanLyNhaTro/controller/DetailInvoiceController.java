package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.HopDong;
import com.epu.QuanLyNhaTro.model.TienThuTienIch;
import com.epu.QuanLyNhaTro.view.DetailInvoiceForm;
import com.epu.QuanLyNhaTro.view.InvoiceForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class DetailInvoiceController {
    private final DetailInvoiceForm detailInvoiceForm;
    private final InvoiceForm invoiceForm;

    public DetailInvoiceController(DetailInvoiceForm detailInvoiceForm, InvoiceForm invoiceForm) {
        this.detailInvoiceForm = detailInvoiceForm;
        this.invoiceForm = invoiceForm;
    }

    public void init(){
        int i = this.invoiceForm.getMainTable().getSelectedRow();
        int maHopDong = (int) this.invoiceForm.getMainTable().getValueAt(i, 1);
        int maPhong = (int) this.invoiceForm.getMainTable().getValueAt(i, 2);
        handleInfor(maHopDong, maPhong);
        handleTableUsedService(maHopDong, maPhong);
        handleTotal(maPhong);
        this.detailInvoiceForm.getPayBtn().addActionListener(e -> handleThanhToanBtn(e, i));
    }

    private void handleInfor(int maHopDong, int maPhong){
        HopDongDAO hopDongDAO = new HopDongDAOImpl();
        HopDong hopDong = hopDongDAO.getHopDong(maHopDong);
        this.detailInvoiceForm.getNumberOfMemberField().setText(String.valueOf(hopDong.getSoNguoi()));
        this.detailInvoiceForm.getAddressLbl().setText("Địa chỉ : " + "Hà Noi");
        this.detailInvoiceForm.getNumberOfRoomLbl().setText("PHÒNG SỐ " + maPhong);
        this.detailInvoiceForm.getCleanField().setText("50000");
        this.detailInvoiceForm.getVehicleField().setText("50000");
        this.detailInvoiceForm.getInternetField().setText("100000");
        this.detailInvoiceForm.getElecField().setText("4000");
        this.detailInvoiceForm.getWaterField().setText("30000");
    }

    private void handleTableUsedService(int maHopDong, int maPhong){
        TienThuDAO tienThuDAO = new TienThuDAOImpl();
        TienThuTienIch tienThuTienIch = tienThuDAO.getTienThu(maPhong);
        this.detailInvoiceForm.getTableModel().addRow(new Object[]{
                "Dịch vụ điện",
                tienThuTienIch.getSoDienMoi(),
                tienThuTienIch.getSoDienCu(),
                tienThuTienIch.getSoDienDaDung(),
                "4000",
                tienThuTienIch.getSoDienDaDung() * 4000
        });
        this.detailInvoiceForm.getTableModel().addRow(new Object[]{
                "Dịch vụ nước",
                tienThuTienIch.getSoNuocMoi(),
                tienThuTienIch.getSoNuocCu(),
                tienThuTienIch.getSoNuocDaDung(),
                "30000",
                tienThuTienIch.getSoNuocDaDung() * 30000
        });

    }

    private void handleTotal(int maPhong){
        PhongDAO phongDAO = new PhongDAOImpl();
        double giaPhong = phongDAO.getGiaPhong(maPhong);
        this.detailInvoiceForm.getTotalField().setText(
                String.valueOf(
                                Double.parseDouble(this.detailInvoiceForm.getInternetField().getText()) +
                                Double.parseDouble(String.valueOf(Double.parseDouble(this.detailInvoiceForm.getVehicleField().getText()) * Integer.parseInt(this.detailInvoiceForm.getNumberOfMemberField().getText()))) +
                                Double.parseDouble(String.valueOf(Double.parseDouble(this.detailInvoiceForm.getCleanField().getText()) * Integer.parseInt(this.detailInvoiceForm.getNumberOfMemberField().getText()))) +
                                (double) this.detailInvoiceForm.getTableModel().getValueAt(0, 5) +
                                (double) this.detailInvoiceForm.getTableModel().getValueAt(1, 5) +
                                giaPhong

                )
        );
    }

    private void handleThanhToanBtn(ActionEvent event, int selectedRow){
        ThanhToanDAO thanhToanDAO = new ThanhToanDAOImpl();
        String hinhThuc = this.detailInvoiceForm.getPaymentCombo().getSelectedItem().toString();
        String trangThai = this.invoiceForm.getMainTable().getValueAt(selectedRow, 4).toString();
        if(trangThai.equalsIgnoreCase("Đã thanh toán")){
            JOptionPane.showMessageDialog(null, "Hóa đơn đã được thanh toán");
            return;
        }
        if(!hinhThuc.equalsIgnoreCase("Chuyển Khoản")){
            thanhToanDAO.addThanhToan(
                    (int) this.invoiceForm.getMainTable().getValueAt(selectedRow, 0),
                    Double.parseDouble(this.detailInvoiceForm.getTotalField().getText()),
                    hinhThuc,
                    "Đã thanh toán"
            );
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
            this.detailInvoiceForm.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Chức năng chưa được hỗ trợ");
        }
    }
}


