package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.KhachThueDAO;
import com.epu.QuanLyNhaTro.dao.KhachThueDAOImpl;
import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.util.Authenticator;
import com.epu.QuanLyNhaTro.view.TenantManagement;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class TenantManagerController {
    private final TenantManagement tenantManagement;

    public TenantManagerController(TenantManagement tenantManagement) {
        this.tenantManagement = tenantManagement;
    }

    public void init(){
        this.showData();

        this.tenantManagement.getMainTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMainTable();
            }
        });

        this.tenantManagement.getSearchBtn().addActionListener(this::handleSearchBtn);
        this.tenantManagement.getAddBtn().addActionListener(this::handleAddBtn);
    }

    public void showData(){
        KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
        List<KhachThue> khachThueList = khachThueDAO.getAllKhachThue();
        for(KhachThue x : khachThueList){
            String[] rows = new String[]{String.valueOf(x.getMaKhach()), x.getMaCCCD(), x.getTen(), String.valueOf(x.getNgaySinh()), x.getGioiTinh(), x.getSoDienThoai(), x.getDiaChi(), String.valueOf(x.getMaTaiKhoan())};
            this.tenantManagement.getTableModel().addRow(rows);
        }
    }

    private void handleSearchBtn(ActionEvent event){
        String search = tenantManagement.getSearchField().getText();
        KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
        if(Objects.equals(search, "")){
            this.showData();
            return;
        }
        else {
            KhachThue khachThue = khachThueDAO.getKhachThue(search);
            if (khachThue != null){
                String[] khach = new String[]{String.valueOf(khachThue.getMaKhach()), khachThue.getMaCCCD(), khachThue.getTen(), String.valueOf(khachThue.getNgaySinh()), khachThue.getGioiTinh(), khachThue.getSoDienThoai(), khachThue.getDiaChi(), khachThue.getSoDienThoai()};
                this.tenantManagement.getTableModel().setRowCount(0);
                this.tenantManagement.getTableModel().addRow(khach);
            }
            else {
                this.tenantManagement.getTableModel().setRowCount(0);
                showData();
                JOptionPane.showMessageDialog(null, "Không tìm thấy khách thuê");
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
        if (number.isEmpty() || cccd.isEmpty() || name.isEmpty() || date == null || gender.isEmpty() || phone.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return;
        }
        else{
            KhachThueDAO khachThueDAO = new KhachThueDAOImpl();
            System.out.println(1);
            khachThueDAO.addKhachThue(cccd, name, LocalDate.parse(date), gender, phone, address, account);
            System.out.println(2);
            this.tenantManagement.getTableModel().setRowCount(0);
            System.out.println(3);
            this.showData();
            System.out.println(4);
            JOptionPane.showMessageDialog(null, "Thêm khách thuê thành công");
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lý khách thuê");
        TenantManagement tenantManagement = new TenantManagement();
        TenantManagerController tenantManagerController = new TenantManagerController(tenantManagement);
        frame.add(tenantManagement);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1346, 793);
        frame.setVisible(true);
    }
}
