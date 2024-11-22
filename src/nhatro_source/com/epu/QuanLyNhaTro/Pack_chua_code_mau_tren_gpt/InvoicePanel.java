package com.epu.QuanLyNhaTro.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InvoicePanel extends JPanel {
    private JLabel titleLbl;
    private JLabel addressLbl;
    private JLabel numberOfRoomLbl;
    private JTextField elecField;
    private JTextField waterField;
    private JTextField internetField;
    private JTextField vehicleField;
    private JTextField cleanField;
    private JTable usedServiceTbl;
    private JScrollPane scrollPane;
    private JLabel elecLbl;
    private JLabel waterLbl;
    private JLabel internetLbl;
    private JLabel vehicleLbl;
    private JLabel cleanLbl;
    private JTextField totalField;
    private JLabel totalLbl;
    private JComboBox<String> paymentCombo;
    private JLabel paymentLbl;
    private JButton exportBtn;
    private JButton payBtn;
    private DefaultTableModel tableModel;

    public InvoicePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title Panel
        JPanel titlePnl = new JPanel(new GridLayout(2, 1));
        titleLbl = new JLabel("HÓA ĐƠN TIỀN TRỢ", JLabel.CENTER);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 20));
        addressLbl = new JLabel("Địa chỉ:", JLabel.CENTER);
        addressLbl.setFont(new Font("Arial", Font.PLAIN, 16));
        titlePnl.add(titleLbl);
        titlePnl.add(addressLbl);
        add(titlePnl, BorderLayout.NORTH);

        // Details Panel
        JPanel detailPnl = new JPanel(new BorderLayout(10, 10));

        // Table
        String[] columns = {"", "Số mới", "Số cũ", "Số tiêu thụ", "Đơn giá", "Thành tiền"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        usedServiceTbl = new JTable(tableModel);
        usedServiceTbl.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(usedServiceTbl);
        detailPnl.add(scrollPane, BorderLayout.CENTER);

        // Input Fields
        JPanel inputPnl = new JPanel(new GridLayout(6, 2, 10, 10));
        elecLbl = new JLabel("Điện:");
        elecField = new JTextField();
        waterLbl = new JLabel("Nước:");
        waterField = new JTextField();
        internetLbl = new JLabel("Internet:");
        internetField = new JTextField();
        vehicleLbl = new JLabel("Đỗ xe:");
        vehicleField = new JTextField();
        cleanLbl = new JLabel("Vệ sinh:");
        cleanField = new JTextField();
        totalLbl = new JLabel("TỔNG CỘNG:");
        totalField = new JTextField();
        totalField.setEditable(false);

        inputPnl.add(elecLbl);
        inputPnl.add(elecField);
        inputPnl.add(waterLbl);
        inputPnl.add(waterField);
        inputPnl.add(internetLbl);
        inputPnl.add(internetField);
        inputPnl.add(vehicleLbl);
        inputPnl.add(vehicleField);
        inputPnl.add(cleanLbl);
        inputPnl.add(cleanField);
        inputPnl.add(totalLbl);
        inputPnl.add(totalField);

        detailPnl.add(inputPnl, BorderLayout.SOUTH);
        add(detailPnl, BorderLayout.CENTER);

        // Payment Panel
        JPanel paymentPnl = new JPanel(new GridLayout(1, 3, 10, 10));
        paymentLbl = new JLabel("Hình thức thanh toán:");
        paymentCombo = new JComboBox<>(new String[]{"Chuyển khoản", "Tiền mặt"});
        exportBtn = new JButton("Xuất Hóa Đơn");
        payBtn = new JButton("Thanh Toán");

        paymentPnl.add(paymentLbl);
        paymentPnl.add(paymentCombo);
        paymentPnl.add(exportBtn);
        paymentPnl.add(payBtn);
        add(paymentPnl, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Invoice Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setContentPane(new InvoicePanel());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
