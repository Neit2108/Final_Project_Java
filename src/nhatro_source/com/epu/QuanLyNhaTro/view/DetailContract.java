package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.DetailContractController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
@Setter
public class DetailContract extends JFrame {
    private JPanel mainPnl;
    private JPanel vietNamPnl;
    private JLabel titleLbl;
    private JLabel subTitleLbl;
    private JLabel contractNameLbl;
    private JLabel dayOfCreateLbl;
    private JPanel contractPnl;
    private JTextField nameField_A;
    private JTextField cccdField_A;
    private JTextField addressField_A;
    private JTextField nameField_B;
    private JTextField cccdField_B;
    private JTextField addressField_B;
    private JTable priceListTable;
    private JScrollPane scrollPane;
    private JLabel aLbl;
    private JLabel bLbl;
    private JLabel nameLbl_A;
    private JLabel cccdLbl_A;
    private JLabel addressLbl_A;
    private JLabel nameLbl_B;
    private JLabel cccdLbl_B;
    private JLabel addressLbl_B;
    private DefaultTableModel model;

    public DetailContract() {
        // Setup main panel
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout(10, 10));
        mainPnl.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Title section
        vietNamPnl = new JPanel(new GridLayout(4, 1));
        titleLbl = new JLabel("CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM", SwingConstants.CENTER);
        subTitleLbl = new JLabel("Độc lập - Tự do - Hạnh phúc", SwingConstants.CENTER);
        contractNameLbl = new JLabel("HỢP ĐỒNG THUÊ NHÀ Ở", SwingConstants.CENTER);
        dayOfCreateLbl = new JLabel("Hà Nội, ngày ... tháng ... năm ...", SwingConstants.RIGHT);
        titleLbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
        subTitleLbl.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        contractNameLbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        dayOfCreateLbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        vietNamPnl.add(titleLbl);
        vietNamPnl.add(subTitleLbl);
        vietNamPnl.add(contractNameLbl);
        vietNamPnl.add(dayOfCreateLbl);

        // Contract information section
        contractPnl = new JPanel(new GridLayout(7, 1, 10, 10));
        contractPnl.setBorder(BorderFactory.createTitledBorder("Thông tin hợp đồng"));
        aLbl = new JLabel("BÊN CHO THUÊ (Bên A):", SwingConstants.LEFT);
        aLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bLbl = new JLabel("BÊN THUÊ (Bên B):", SwingConstants.LEFT);
        bLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        //contractPnl.add(aLbl);
        addLabeledField(contractPnl, "Họ và tên (Bên A):", nameField_A = new JTextField()); nameField_A.setEditable(false);
        addLabeledField(contractPnl, "CCCD:", cccdField_A = new JTextField()); cccdField_A.setEditable(false);
        addLabeledField(contractPnl, "Nơi đăng ký thường trú:", addressField_A = new JTextField()); addressField_A.setEditable(false);
        //contractPnl.add(bLbl);
        addLabeledField(contractPnl, "Họ và tên (Bên B):", nameField_B = new JTextField()); nameField_B.setEditable(false);
        addLabeledField(contractPnl, "CCCD:", cccdField_B = new JTextField()); cccdField_B.setEditable(false);
        addLabeledField(contractPnl, "Nơi đăng ký thường trú:", addressField_B = new JTextField()); addressField_B.setEditable(false);


        // Price list section
        String[] columns = {"Tên", "Giá", "Ghi chú"};
        String[][] rows = {
                {"Internet", "100000", "Tính theo tháng"},
                {"Điện", "4000", "Tính theo số"},
                {"Nước", "100000", "Tính theo đầu người"},
                {"Đỗ xe", "50000", "Tính theo số xe"},
                {"Thang máy", "100000", "Tính theo phòng"},
                {"Vệ sinh", "10000", "Tính theo đầu người"}
        };
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        priceListTable = new JTable(model);
        priceListTable.getTableHeader().setReorderingAllowed(false);
        priceListTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        priceListTable.setRowHeight(25);

        scrollPane = new JScrollPane(priceListTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Bảng giá dịch vụ"));
        for (String[] row : rows) {
            model.addRow(row);
        }

        // Add sections to main panel
        mainPnl.add(vietNamPnl, BorderLayout.NORTH);
        mainPnl.add(contractPnl, BorderLayout.CENTER);
        mainPnl.add(scrollPane, BorderLayout.SOUTH);

        // Frame setup
        setContentPane(mainPnl);
        setTitle("Hợp Đồng Thuê Nhà Ở");
        setSize(794, 1123); // A4 size in pixels
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addLabeledField(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel.add(label);
        panel.add(textField);
    }



    public static void main(String[] args) {
        DetailContract dt = new DetailContract();
        System.out.println(dt.getContractPnl().getHeight() + " " + dt.getContractPnl().getWidth());
    }
}
