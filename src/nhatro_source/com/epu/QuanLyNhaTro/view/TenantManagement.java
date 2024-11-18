package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.TenantManagerController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
@Setter
public class TenantManagement extends JPanel {

    private JPanel buttonPanel;
    private JButton addBtn;
    private JButton deleteBtn;
    private JButton editBtn;
    private JPanel inputPanel;
    private JTextField numberField;
    private JTextField cccdField;
    private JTextField nameField;
    private JTextField dateField;
    private JTextField genderField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField searchField;
    private JButton searchBtn;
    private JTable mainTable;
    private JPanel mainTablePanel;
    private JTextField accountNumberField;
    private DefaultTableModel tableModel;

    public TenantManagement() {
        initComponents();
        new TenantManagerController(this).init();
    }

    private void initComponents() {
        setSize(1346, 793); // Đặt kích thước form mới
        setLayout(null); // Dùng layout null để đặt các thành phần với kích thước cụ thể

        // Menu Button
        JButton menuBtn = new JButton("Menu");
        menuBtn.setBounds(10, 10, 100, 30);
        add(menuBtn);

        // Input Panel
        JPanel inputPanel = createInputPanel();
        inputPanel.setBounds(10, 50, 300, 350);
        add(inputPanel);

        // Button Panel
        JPanel buttonPanel = createButtonPanel();
        buttonPanel.setBounds(10, 410, 300, 50); // Đặt nút dưới panel nhập liệu
        add(buttonPanel);

        // Main Table Panel
        JPanel mainTablePanel = createMainTablePanel();
        mainTablePanel.setBounds(330, 10, 1000, 700); // Điều chỉnh bảng chi tiết
        add(mainTablePanel);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Nhập thông tin khách thuê", TitledBorder.CENTER, TitledBorder.TOP));

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

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        addBtn = new JButton("Thêm");
        editBtn = new JButton("Thay đổi");
        deleteBtn = new JButton("Xóa");

        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(deleteBtn);

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
        String[] columnNames = {"Mã khách", "CCCD", "Tên khách", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Mã tài khoản"};
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
        SwingUtilities.invokeLater(() -> {
            TenantManagement form = new TenantManagement();
            JFrame frame = new JFrame("Quản lý khách thuê");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1346, 793); // Kích thước của cửa sổ
            frame.add(form);
            frame.setVisible(true);
        });
    }
}
