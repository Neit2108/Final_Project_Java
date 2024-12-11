package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.ChuNha;
import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.model.TaiKhoan;
import com.epu.QuanLyNhaTro.util.Authenticator;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.SignInForm;
import com.epu.QuanLyNhaTro.view.TenantManagement;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class TenantManagerController {
    private final TenantManagement tenantManagement;

    public TenantManagerController(TenantManagement tenantManagement) {
        this.tenantManagement = tenantManagement;
    }

    public void init(){
        this.tenantManagement.getMainTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMainTable();
            }

        });
        this.tenantManagement.getSearchBtn().addActionListener(this::handleSearchBtn);
        this.tenantManagement.getAddBtn().addActionListener(this::handleAddBtn);
        this.tenantManagement.getEditBtn().addActionListener(this::handleUpdateBtn);
        this.tenantManagement.getDeleteBtn().addActionListener(this::handleDeleteBtn);
        this.tenantManagement.getResetBtn().addActionListener(this::handleResetBtn);

        if((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("Chủ nhà")){
            showDataForChuNha();
            this.tenantManagement.getHostBtn().setVisible(false);
            this.tenantManagement.getTenantBtn().setVisible(false);
        }
        else {
            this.tenantManagement.getTenantBtn().addActionListener(e -> {
                showDataKhachThue();
            });
            this.tenantManagement.getHostBtn().addActionListener(e -> {
                showDataChuNha();
            });
        }
        addRightClick();
    }

    private void showDataKhachThue(){
        KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
        List<KhachThue> khachThueList = khachThueDAO.getAllKhachThue();
        this.tenantManagement.getTableModel().setRowCount(0);
        for(KhachThue x : khachThueList){
            String[] rows = new String[]{String.valueOf(x.getMaKhach()), x.getMaCCCD(), x.getTen(), String.valueOf(x.getNgaySinh()), x.getGioiTinh(), x.getSoDienThoai(), x.getDiaChi(), String.valueOf(x.getMaTaiKhoan())};
            this.tenantManagement.getTableModel().addRow(rows);
        }
    }

    private void showDataChuNha(){
        ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
        List<ChuNha> chuNhaList = chuNhaDAO.getAllChuNha();
        this.tenantManagement.getTableModel().setRowCount(0);
        for(ChuNha x : chuNhaList){
            String[] rows = new String[]{String.valueOf(x.getMaChuNha()), x.getMaCCCD(), x.getTen(), String.valueOf(x.getNgaySinh()), x.getGioiTinh(), x.getSoDienThoai(), x.getDiaChi(), String.valueOf(x.getMaTaiKhoan())};
            this.tenantManagement.getTableModel().addRow(rows);
        }
    }

    private void showDataForChuNha(){
        // Hien all khach thue nha cua chu nha
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
        List<KhachThue> khachThueList = new KhachThueDAOImpl().getKhachThueByMaChuNha(taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan()));
        this.tenantManagement.getTableModel().setRowCount(0);
        for(KhachThue x : khachThueList){
            String[] rows = new String[]{String.valueOf(x.getMaKhach()), x.getMaCCCD(), x.getTen(), String.valueOf(x.getNgaySinh()), x.getGioiTinh(), x.getSoDienThoai(), x.getDiaChi(), String.valueOf(x.getMaTaiKhoan())};
            this.tenantManagement.getTableModel().addRow(rows);
        }
    }

    private void handleSearchBtn(ActionEvent event){
        String search = tenantManagement.getSearchField().getText();
        KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
        ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
        if(Objects.equals(search, "")){
            this.tenantManagement.getTableModel().setRowCount(0);
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần tìm kiếm");
            return;
        }
        else {
            KhachThue khachThue = khachThueDAO.getKhachThue(search);
            ChuNha chuNhathue = chuNhaDAO.getChuNhaByCCCD(search);
            System.out.println(khachThue);
            System.out.println(chuNhathue);
            if (khachThue != null) {
                String[] khach = new String[]{String.valueOf(khachThue.getMaKhach()), khachThue.getMaCCCD(), khachThue.getTen(), String.valueOf(khachThue.getNgaySinh()), khachThue.getGioiTinh(), khachThue.getSoDienThoai(), khachThue.getDiaChi(), khachThue.getSoDienThoai()};
                this.tenantManagement.getTableModel().setRowCount(0);
                this.tenantManagement.getTableModel().addRow(khach);
            }
            if(chuNhathue != null){
                String[] chuNha = new String[]{String.valueOf(chuNhathue.getMaChuNha()), chuNhathue.getMaCCCD(), chuNhathue.getTen(), String.valueOf(chuNhathue.getNgaySinh()), chuNhathue.getGioiTinh(), chuNhathue.getSoDienThoai(), chuNhathue.getDiaChi(), chuNhathue.getSoDienThoai()};
                this.tenantManagement.getTableModel().setRowCount(0);
                this.tenantManagement.getTableModel().addRow(chuNha);
            }
            if(khachThue == null && chuNhathue == null){
                this.tenantManagement.getTableModel().setRowCount(0);
                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin");
            }
        }
    }

    private void handleMainTable(){
        int row = tenantManagement.getMainTable().getSelectedRow();  // Không cần khai báo lại tenantManagement
        if(row != -1){
            String number = tenantManagement.getMainTable().getModel().getValueAt(row, 0).toString();
            String cccd = tenantManagement.getMainTable().getModel().getValueAt(row, 1).toString();
            String name = tenantManagement.getMainTable().getModel().getValueAt(row, 2).toString();
            String date = tenantManagement.getMainTable().getModel().getValueAt(row, 3).toString();
            String gender = tenantManagement.getMainTable().getModel().getValueAt(row, 4).toString();
            String phone = tenantManagement.getMainTable().getModel().getValueAt(row, 5).toString();
            String address = tenantManagement.getMainTable().getModel().getValueAt(row, 6).toString();
            String account = tenantManagement.getMainTable().getModel().getValueAt(row, 7).toString();
            // Cập nhật các JTextField với dữ liệu từ dòng đã chọn
            tenantManagement.getNumberField().setText(number);
            tenantManagement.getCccdField().setText(cccd);
            tenantManagement.getNameField().setText(name);
            tenantManagement.getDateField().setText(date);
            tenantManagement.getGenderField().setText(gender);
            tenantManagement.getPhoneField().setText(phone);
            tenantManagement.getAddressField().setText(address);
            tenantManagement.getAccountNumberField().setText(account);
        }
    }

    private void setNull(){
        tenantManagement.getNumberField().setText("");
        tenantManagement.getCccdField().setText("");
        tenantManagement.getNameField().setText("");
        tenantManagement.getDateField().setText("");
        tenantManagement.getGenderField().setText("");
        tenantManagement.getPhoneField().setText("");
        tenantManagement.getAddressField().setText("");
        tenantManagement.getAccountNumberField().setText("");
    }

    private void handleAddBtn(ActionEvent event){
        String number = tenantManagement.getNumberField().getText();
        String cccd = tenantManagement.getCccdField().getText();
        String name = tenantManagement.getNameField().getText();
        String date = tenantManagement.getDateField().getText();
        date = Authenticator.normalizeDate(date);
        String gender = tenantManagement.getGenderField().getText();
        String phone = tenantManagement.getPhoneField().getText();
        String address = tenantManagement.getAddressField().getText();
        int account = Integer.parseInt(tenantManagement.getAccountNumberField().getText());
        System.out.println(0);
        if (cccd.isEmpty() || name.isEmpty() || date == null || gender.isEmpty() || phone.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return;
        }
        else{
            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm khách thuê này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(i == JOptionPane.YES_OPTION){
                KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
                System.out.println(1);
                khachThueDAO.addKhachThue(cccd, name, LocalDate.parse(date), gender, phone, address, account);
                System.out.println(2);
                setNull();
                this.tenantManagement.getTableModel().setRowCount(0);
                System.out.println(3);
                this.showDataKhachThue();
                JOptionPane.showMessageDialog(null, "Thêm khách thuê thành công");
            }
        }
    }

    private void handleUpdateBtn(ActionEvent event) {
        String number = tenantManagement.getNumberField().getText();
        String cccd = tenantManagement.getCccdField().getText();
        String name = tenantManagement.getNameField().getText();
        String date = tenantManagement.getDateField().getText();
        date = Authenticator.normalizeDate(date);
        String gender = tenantManagement.getGenderField().getText();
        String phone = tenantManagement.getPhoneField().getText();
        String address = tenantManagement.getAddressField().getText();
        int account = Integer.parseInt(tenantManagement.getAccountNumberField().getText());

        if (cccd.isEmpty() || name.isEmpty() || date == null || gender.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return;
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật thông tin khách thuê này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
                if(khachThueDAO.getKhachThue(cccd) == null){
                    //JOptionPane.showMessageDialog(null, "Không tìm thấy khách thuê");
                    return;
                }
                else {
                    khachThueDAO.updateKhachThue(cccd, name, LocalDate.parse(date), gender, phone, address, account);
                    this.tenantManagement.getTableModel().setRowCount(0);
                    showDataKhachThue();
                    setNull();
                }

                ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
                if(chuNhaDAO.getChuNhaByCCCD(cccd) == null){
                    //JOptionPane.showMessageDialog(null, "Không tìm thấy chủ nhà");
                    return;
                }
                else {
                    chuNhaDAO.updateChuNha(cccd, name, LocalDate.parse(date), gender, phone, address, account);
                    setNull();
                    this.tenantManagement.getTableModel().setRowCount(0);
                    showDataChuNha();
                }
                JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công");
            }
        }
    }

    private void handleDeleteBtn(ActionEvent event) {
        String cccd = tenantManagement.getCccdField().getText();
        if (cccd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách thuê cần xóa");
            return;
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách thuê này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
                khachThueDAO.deleteKhachThue(cccd);
                setNull();
                this.tenantManagement.getTableModel().setRowCount(0);
                this.showDataKhachThue();
                JOptionPane.showMessageDialog(null, "Xóa khách thuê thành công");
            }
        }
    }

    private void handleResetBtn(ActionEvent event) {
        setNull();
    }

    private void addRightClick(){
        JPopupMenu rightClickMenu = new JPopupMenu();
        JMenuItem changeRoleItem = new JMenuItem("Đổi vai trò");

        changeRoleItem.addActionListener(e -> {
            int selectedRow = tenantManagement.getMainTable().getSelectedRow();
            if (selectedRow != -1) {
                String cccd = tenantManagement.getMainTable().getValueAt(selectedRow, 1).toString();
                KhachThue khachThue = new KhachThueDAOImpl().getKhachThue(cccd);
                ChuNha chuNha = new ChuNhaDAOImpl().getChuNhaByCCCD(cccd);

                if(khachThue != null){
                    TaiKhoan tk = new TaiKhoanDAOImpl().getTaiKhoan(khachThue.getMaTaiKhoan());
                    new TaiKhoanDAOImpl().updateTaiKhoan(tk.getEmail(), "Chủ nhà");
                }
                else if(chuNha != null){
                    TaiKhoan tk = new TaiKhoanDAOImpl().getTaiKhoan(chuNha.getMaTaiKhoan());
                    new TaiKhoanDAOImpl().updateTaiKhoan(tk.getEmail(), "Khách thuê");
                }
            }
        });

        rightClickMenu.add(changeRoleItem);

        tenantManagement.getMainTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = tenantManagement.getMainTable().rowAtPoint(e.getPoint());
                    tenantManagement.getMainTable().setRowSelectionInterval(row, row);
                    rightClickMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = tenantManagement.getMainTable().rowAtPoint(e.getPoint());
                    tenantManagement.getMainTable().setRowSelectionInterval(row, row);
                    rightClickMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

}
