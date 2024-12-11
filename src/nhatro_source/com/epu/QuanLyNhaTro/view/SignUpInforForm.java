package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.SignUpInforController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class SignUpInforForm extends JFrame {
    private JPanel mainPnl;
    private JTextField cccdField;
    private JTextField nameField;
    private JTextField birthdayField;
    private JTextField genderField;
    private JTextField phoneNumberField;
    private JTextField addressField;
    private JLabel cccdLbl;
    private JLabel nameLbl;
    private JLabel birthdayLbl;
    private JLabel genderLbl;
    private JLabel phoneNumberLbl;
    private JLabel addressLbl;
    private JButton submitBtn;

    public SignUpInforForm() {
        // Thiết lập JFrame
        setTitle("Sign Up Information");
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        // Khởi tạo giao diện
        mainPnl = new JPanel(new GridLayout(7, 2, 10, 10));
        mainPnl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        cccdLbl = new JLabel("CCCD:");
        cccdField = new JTextField();

        nameLbl = new JLabel("Name:");
        nameField = new JTextField();

        birthdayLbl = new JLabel("Birthday:");
        birthdayField = new JTextField();

        genderLbl = new JLabel("Gender:");
        genderField = new JTextField();

        phoneNumberLbl = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();

        addressLbl = new JLabel("Address:");
        addressField = new JTextField();

        submitBtn = new JButton("Submit");

        // Thêm các thành phần vào panel
        mainPnl.add(cccdLbl);
        mainPnl.add(cccdField);
        mainPnl.add(nameLbl);
        mainPnl.add(nameField);
        mainPnl.add(birthdayLbl);
        mainPnl.add(birthdayField);
        mainPnl.add(genderLbl);
        mainPnl.add(genderField);
        mainPnl.add(phoneNumberLbl);
        mainPnl.add(phoneNumberField);
        mainPnl.add(addressLbl);
        mainPnl.add(addressField);
        mainPnl.add(new JLabel()); // Placeholder
        mainPnl.add(submitBtn);

        SignUpInforController signUpInforFormController = new SignUpInforController(this);
        signUpInforFormController.init();
        // Thêm panel vào JFrame
        add(mainPnl);
    }

    public static void main(String[] args) {
        new SignUpInforForm().setVisible(true);
    }
}
