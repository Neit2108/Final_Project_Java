package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.TenantManagerController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

@Setter
@Getter
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
    private JPanel searchInputPanel;
    private JTextField searchField;
    private JButton searchBtn;
    private JTable searchTable;
    private JPanel mainTablePanel;
    private JTable mainTable;
    private ArrayList inputFields;

    public TenantManagement() {
        initComponents();

    }

    private void initComponents() {
//        setTitle("Quản lý khách thuê");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);  // Increased form size
        setLayout(null); // Using null layout for precise positioning

        // Menu Button
        JButton menuBtn = new JButton("Menu");
        menuBtn.setBounds(10, 10, 100, 30);
        add(menuBtn);

        // Input Panel
        JPanel inputPanel = createInputPanel();
        inputPanel.setBounds(10, 50, 300, 350);  // Increased width and height
        add(inputPanel);

        // Button Panel
        JPanel buttonPanel = createButtonPanel();
        buttonPanel.setBounds(10, 410, 300, 50);  // Positioned below input panel
        add(buttonPanel);

        // Main Table Panel
        JPanel mainTablePanel = createMainTablePanel();
        mainTablePanel.setBounds(330, 10, 740, 300);  // Made it wider and taller
        add(mainTablePanel);

        // Search Panel
        JPanel searchPanel = createSearchPanel();
        searchPanel.setBounds(330, 320, 740, 300);  // Positioned below main table panel
        add(searchPanel);

        TenantManagerController controller = new TenantManagerController(this);
        controller.init();
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10)); // Increased spacing for better readability
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Nhập thông tin khách thuê", TitledBorder.CENTER, TitledBorder.TOP));

        // Added larger text fields

        this.numberField = new JTextField(20);
        this.cccdField = new JTextField(20);
        this.nameField = new JTextField(20);
        this.dateField = new JTextField(20);
        this.genderField = new JTextField(20);
        this.phoneField = new JTextField(20);
        this.addressField = new JTextField(20);


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

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));  // Adjusted spacing

        this.addBtn = new JButton("Thêm");
        this.editBtn = new JButton("Thay đổi");
        this.deleteBtn = new JButton("Xóa");

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

        String[] columnNames = {"Mã khách", "CCCD", "Tên khách", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Mã tài khoản"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.mainTable = new JTable(dtm);
        mainTable.setRowHeight(30);  // Increased row height for better readability
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        mainTable.getTableHeader().setReorderingAllowed(false);
        dtm.addRow(new Object[]{"1", "123456789", "Nguyễn Văn A", "01/01/1990", "Nam", "0123456789", "123 Đường ABC", "1"});

        JScrollPane scrollPane = new JScrollPane(mainTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Chi tiết tìm kiếm:", TitledBorder.CENTER, TitledBorder.TOP));

        JPanel searchInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel label1 = new JLabel("Nhập mã khách cần tìm:");
        JTextField searchField = new JTextField(20);  // Larger search field
        JButton searchBtn = new JButton("Tìm kiếm");

        searchInputPanel.add(label1);
        searchInputPanel.add(searchField);
        searchInputPanel.add(searchBtn);
        panel.add(searchInputPanel, BorderLayout.NORTH);

        String[] searchColumnNames = {"Mã khách", "CCCD", "Tên khách", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Mã tài khoản"};
        DefaultTableModel dtm = new DefaultTableModel(searchColumnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.searchTable = new JTable(new Object[][]{}, searchColumnNames);
        searchTable.setRowHeight(30);  // Increased row height for better readability
        searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        searchTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane searchScrollPane = new JScrollPane(searchTable);
        panel.add(searchScrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TenantManagement form = new TenantManagement();
            form.setVisible(true);
        });
    }
}
