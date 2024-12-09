package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.HoaDon;
import com.epu.QuanLyNhaTro.model.HopDong;
import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.model.NhaTro;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.DetailInvoiceForm;
import com.epu.QuanLyNhaTro.view.InvoiceForm;
import com.epu.QuanLyNhaTro.view.SignInForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        this.invoiceForm.getAutoAddBtn().addActionListener(this::handleAutoAddBtn);
        this.invoiceForm.getDeleteBtn().addActionListener(this::handleDeleteBtn);
    }

    private void showData(){
        invoiceForm.getTableModel().setRowCount(0);
        if((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Khách Thuê")){
            showDataForTenant();
        }
        else if ((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Chủ Nhà")){
            showDataForLanlord();
        }
        else {
            showDataForAdmin();
        }
    }

    private void showDataForTenant(){
        HoaDonDAO hoaDonDAO = new HoaDonDAOImpl();
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
        List<HoaDon> hoaDonList = hoaDonDAO.getHoaDonByMaKhach(taiKhoanDAO.getMaKhachThue(Constant.taiKhoan.getMaTaiKhoan()));
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

    private void showDataForLanlord(){
        HoaDonDAO hoaDonDAO = new HoaDonDAOImpl();
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        List<NhaTro> nhaTros = nhaTroDAO.getAllNhaTroByMaChuNha(taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan()));
        for(NhaTro x : nhaTros){
            List<HoaDon> hoaDonList = hoaDonDAO.getHoaDonByMaNhaTro(x.getMaNhaTro());
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
    }
    private void handleResetBtn(ActionEvent e){
        invoiceForm.getTableModel().setRowCount(0);
        showData();
    }

    private void handleAutoAddBtn(ActionEvent event){
        HoaDonDAO hoaDonDAO = new HoaDonDAOImpl();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        boolean isCreated = hoaDonDAO.isCreatedHoaDon(currentDate);
        if(isCreated){
            JOptionPane.showMessageDialog(null, "Hóa đơn tháng này đã được tạo!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            if (Constant.role.equalsIgnoreCase("Chủ nhà")) {
                TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
                int maChuNha = taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan());
                hoaDonDAO.autoCreateHoaDon(maChuNha, currentDate);
                JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
                List<KhachThue> khachThueList = khachThueDAO.getKhachThueByMaChuNha(maChuNha);
                String txt = "Yêu cầu thanh toán hóa đơn cho tháng " + month + " năm " + year + " đã được gửi tới bạn";
                for(KhachThue khachThue : khachThueList){
                    ThongBaoDAO thongBaoDAO = new ThongBaoDAOImpl();
                    thongBaoDAO.addThongBao(Constant.taiKhoan.getMaTaiKhoan(), khachThue.getMaTaiKhoan(), txt, "Chưa xem", 1, "YeuCauThanhToan");
                }
                this.invoiceForm.getTableModel().setRowCount(0);
                showData();
            } else if (Constant.role.equalsIgnoreCase("Admin")) {
                List<NhaTro> nhaTroList = new NhaTroDAOImpl().getAllNhaTro();
                for(NhaTro x : nhaTroList){
                    hoaDonDAO.autoCreateHoaDon(x.getMaChuNha(), currentDate);
                    JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
                    List<KhachThue> khachThueList = khachThueDAO.getKhachThueByMaChuNha(x.getMaChuNha());
                    String txt = "Yêu cầu thanh toán hóa đơn cho tháng " + month + " năm " + year + " đã được gửi tới bạn";
                    for(KhachThue khachThue : khachThueList){
                        ThongBaoDAO thongBaoDAO = new ThongBaoDAOImpl();
                        thongBaoDAO.addThongBao(Constant.taiKhoan.getMaTaiKhoan(), khachThue.getMaTaiKhoan(), txt, "Chưa xem", 1, "YeuCauThanhToan");
                    }
                    this.invoiceForm.getTableModel().setRowCount(0);
                    showData();
                }
            }
        }
    }

    private void handleDeleteBtn(ActionEvent event){
        int selectedRow = invoiceForm.getMainTable().getSelectedRow();
        if(selectedRow != -1) {
            int maHoaDon = (int) invoiceForm.getMainTable().getValueAt(selectedRow, 0);
            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hóa đơn này ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            HoaDonDAO hoaDonDAO = new HoaDonDAOImpl();
            if(i == JOptionPane.YES_OPTION){
                hoaDonDAO.deleteHoaDon(maHoaDon);
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                invoiceForm.getTableModel().setRowCount(0);
                showData();
            }
        }
    }

}
