package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.HoaDonDAO;
import com.epu.QuanLyNhaTro.dao.HoaDonDAOImpl;
import com.epu.QuanLyNhaTro.dao.HopDongDAO;
import com.epu.QuanLyNhaTro.dao.HopDongDAOImpl;
import com.epu.QuanLyNhaTro.model.HoaDon;
import com.epu.QuanLyNhaTro.model.HopDong;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.DetailInvoiceForm;
import com.epu.QuanLyNhaTro.view.InvoiceForm;
import com.epu.QuanLyNhaTro.view.SignInForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class InvoiceFormController {
    private final InvoiceForm invoiceForm;

    public InvoiceFormController(InvoiceForm invoiceForm) {
        this.invoiceForm = invoiceForm;
    }

    public void init(){
        showData();
        this.invoiceForm.getMainTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    int selectedRow = invoiceForm.getMainTable().getSelectedRow();
                    if(selectedRow != -1) {
                        DetailInvoiceForm detailInvoiceForm = new DetailInvoiceForm();
                        DetailInvoiceController detailInvoiceController = new DetailInvoiceController(detailInvoiceForm, invoiceForm);
                        detailInvoiceController.init();
                        detailInvoiceForm.setVisible(true);
                    }
                }
            }
        });
        this.invoiceForm.getResetBtn().addActionListener(this::handleResetBtn);
    }

    private void showData(){
        invoiceForm.getTableModel().setRowCount(0);
        if((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Khách Thuê")){
            showDataForTenant();
        }
        else {
            showDataForAdmin();
        }
    }

    private void showDataForTenant(){
        HoaDonDAO hoaDonDAO = new HoaDonDAOImpl();
        List<HoaDon> hoaDonList = hoaDonDAO.getHoaDonByMaKhach(Constant.taiKhoan.getMaTaiKhoan());
        for(HoaDon hoaDon : hoaDonList){
            HopDongDAO hopDongDAO = new HopDongDAOImpl();
            HopDong hopDong = hopDongDAO.getHopDong(hoaDon.getMaHopDong());
            invoiceForm.getTableModel().addRow(new Object[]{
                    hoaDon.getMaHoaDon(),
                    hopDong.getMaHopDong(),
                    hopDong.getMaPhong(),
                    hoaDon.getTongTien(),
                    hoaDon.getTrangThai(),
                    hoaDon.getNgayTao(),
                    hoaDon.getNgayThanhToan() == null ? "null" : hoaDon.getNgayThanhToan()
            });
        }
    }

    private void showDataForAdmin(){
        HoaDonDAO hoaDonDAO = new HoaDonDAOImpl();
        List<HoaDon> hoaDonList = hoaDonDAO.getAllHoaDon();
        for(HoaDon hoaDon : hoaDonList){
            HopDongDAO hopDongDAO = new HopDongDAOImpl();
            HopDong hopDong = hopDongDAO.getHopDong(hoaDon.getMaHopDong());
            invoiceForm.getTableModel().addRow(new Object[]{
                    hoaDon.getMaHoaDon(),
                    hopDong.getMaHopDong(),
                    hopDong.getMaPhong(),
                    hoaDon.getTongTien(),
                    hoaDon.getTrangThai(),
                    hoaDon.getNgayTao(),
                    hoaDon.getNgayThanhToan() == null ? "null" : hoaDon.getNgayThanhToan()
            });
        }
    }

    private void handleResetBtn(ActionEvent e){
        invoiceForm.getTableModel().setRowCount(0);
        showData();
    }
}
