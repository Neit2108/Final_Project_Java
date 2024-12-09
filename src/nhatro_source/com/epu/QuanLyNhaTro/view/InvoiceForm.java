package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.InvoiceFormController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
@Setter
public class InvoiceForm extends JPanel{
    private JPanel mainTablePnl;
    private JTable mainTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchBtn;
    private JPanel inputPanel;
    private JTextField numberField;
    private JTextField cccdField;
    private JTextField nameField;
    private JTextField dateField;
    private JTextField genderField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField accountNumberField;
    private JButton addBtn;
    private JButton editBtn;
    private JButton deleteBtn;
    private JButton resetBtn;
    private JButton autoAddBtn;


    public InvoiceForm() {
        initComponents();
        new InvoiceFormController(this).init();
    }

    private void initComponents() {
        setSize(1346, 793); // Đặt kích thước form mới
        setLayout(null); // Dùng layout null để đặt các thành phần với kích thước cụ thể

        JPanel mainTablePanel = createMainTablePanel();
        mainTablePanel.setBounds(330, 10, 1000, 700); // Điều chỉnh bảng chi tiết
        add(mainTablePanel);

        JPanel buttonPanel = createButtonPanel();
        buttonPanel.setBounds(10, 410, 300, 100); // Đặt nút dưới panel nhập liệu
        add(buttonPanel);

        JPanel inputPanel = createInputPanel();
        inputPanel.setBounds(10, 50, 300, 350);
        add(inputPanel);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        addBtn = new JButton("Thêm");
        editBtn = new JButton("Thay đổi");
        deleteBtn = new JButton("Xóa");
        resetBtn = new JButton("Làm mới");
        autoAddBtn = new JButton("Tự động thêm");

        //panel.add(addBtn);
        panel.add(editBtn);
        panel.add(deleteBtn);
        panel.add(resetBtn);
        panel.add(autoAddBtn);

        return panel;
    }
    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Thông tin hóa đơn", TitledBorder.CENTER, TitledBorder.TOP));

        numberField = new JTextField(20);
        cccdField = new JTextField(20);
        nameField = new JTextField(20);
        dateField = new JTextField(20);
        genderField = new JTextField(20);
        phoneField = new JTextField(20);
        addressField = new JTextField(20);
        accountNumberField = new JTextField(20);

        panel.add(new JLabel("Mã khách:"));
        panel.add(numberField);
        numberField.setEditable(false);

        panel.add(new JLabel("CCCD:"));
        panel.add(cccdField);

        panel.add(new JLabel("Tên khách:"));
        panel.add(nameField);

        panel.add(new JLabel("Ngày sinh:"));
        panel.add(dateField);

        panel.add(new JLabel("Giới tính:"));
        panel.add(genderField);

        panel.add(new JLabel("Số điện thoại:"));
        panel.add(phoneField);

        panel.add(new JLabel("Địa chỉ:"));
        panel.add(addressField);

        panel.add(new JLabel("Mã tài khoản:"));
        panel.add(accountNumberField);

        return panel;
    }
    private JPanel createMainTablePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Thông tin chi tiết", TitledBorder.CENTER, TitledBorder.TOP));

        // Search Field Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel searchLabel = new JLabel("Tìm kiếm:");
        searchField = new JTextField(30); // Kéo dài trường tìm kiếm
        searchBtn = new JButton("Tìm");
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Mã hóa đơn", "Mã Hợp Đồng", "Mã Phòng", "Tổng Tiền", "Trạng thái", "Ngày Tạo", "Ngày thanh toán"};

        this.tableModel = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mainTable = new JTable(tableModel);
        mainTable.setRowHeight(30);
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        mainTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(mainTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1346, 793);
        frame.add(new InvoiceForm());
        frame.setVisible(true);
    }
}
