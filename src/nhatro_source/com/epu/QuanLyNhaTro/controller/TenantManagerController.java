package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.view.TenantManagement;


import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                int row = tenantManagement.getMainTable().getSelectedRow();  // Không cần khai báo lại tenantManagement
                if(row != -1){
                    String number = tenantManagement.getMainTable().getModel().getValueAt(row, 0).toString();
                    String cccd = tenantManagement.getMainTable().getModel().getValueAt(row, 1).toString();
                    String name = tenantManagement.getMainTable().getModel().getValueAt(row, 2).toString();
                    String date = tenantManagement.getMainTable().getModel().getValueAt(row, 3).toString();
                    String gender = tenantManagement.getMainTable().getModel().getValueAt(row, 4).toString();
                    String phone = tenantManagement.getMainTable().getModel().getValueAt(row, 5).toString();
                    String address = tenantManagement.getMainTable().getModel().getValueAt(row, 6).toString();

                    // Cập nhật các JTextField với dữ liệu từ dòng đã chọn
                    tenantManagement.getNumberField().setText(number);
                    tenantManagement.getCccdField().setText(cccd);
                    tenantManagement.getNameField().setText(name);
                    tenantManagement.getDateField().setText(date);
                    tenantManagement.getGenderField().setText(gender);
                    tenantManagement.getPhoneField().setText(phone);
                    tenantManagement.getAddressField().setText(address);
                }
            }
        });
    }


//    private void handleMainTable(){
//        int row = this.tenantManagement.getMainTable().getSelectedRow();
//        if(row != -1){
//            String number = this.tenantManagement.getMainTable().getModel().getValueAt(row, 0).toString();
//            String cccd = this.tenantManagement.getMainTable().getModel().getValueAt(row, 1).toString();
//            String name = this.tenantManagement.getMainTable().getModel().getValueAt(row, 2).toString();
//            String date = this.tenantManagement.getMainTable().getModel().getValueAt(row, 3).toString();
//            String gender = this.tenantManagement.getMainTable().getModel().getValueAt(row, 4).toString();
//            String phone = this.tenantManagement.getMainTable().getModel().getValueAt(row, 5).toString();
//            String address = this.tenantManagement.getMainTable().getModel().getValueAt(row, 6).toString();
//
//            // Cập nhật các JTextField với dữ liệu từ dòng đã chọn
//            this.tenantManagement.getNumberField().setText(number);
//            this.tenantManagement.getCccdField().setText(cccd);
//            this.tenantManagement.getNameField().setText(name);
//            this.tenantManagement.getDateField().setText(date);
//            this.tenantManagement.getGenderField().setText(gender);
//            this.tenantManagement.getPhoneField().setText(phone);
//            this.tenantManagement.getAddressField().setText(address);
//        }
//
//    }

}
