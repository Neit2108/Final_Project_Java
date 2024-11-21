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
public class ContractForm extends JPanel {

    private JPanel buttonPanel;
    private JButton addBtn;
    private JButton deleteBtn;
    private JButton editBtn;
    private JPanel inputPanel;
    private JTextField mahdField;
    private JTextField maphongField;
    private JTextField makhachField;
    private JTextField tiencocField;
    private JTextField ngaythueField;
    private JTextField timeField;
    private JTextField ngaytaoField;
    private JTextField trangthaiField;
    private JTextField tienDienField;
    private JTextField tienNuocField;
    private JTextField tienInternetField;
    private JTextField tienDauxeField;
    private JTextField tienThangmayField;
    private JTextField tienVesinhField;

    private JButton searchBtn;
    private JTable mainTable;
    private JPanel mainTablePanel;
    private DefaultTableModel tableModel;

    public ContractForm() {
        initComponents();
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
        inputPanel.setBounds(10, 50, 320, 600);
        add(inputPanel);

        // Main Table Panel
        JPanel mainTablePanel = createMainTablePanel();
        mainTablePanel.setBounds(330, 10, 1000, 640); // Điều chỉnh chiều cao của bảng để dành chỗ cho buttonPanel
        add(mainTablePanel);

        // Button Panel (đặt phía dưới bảng)
        JPanel buttonPanel = createButtonPanel();
        buttonPanel.setBounds(330, 660, 1000, 60); // Nằm ngay dưới mainTablePanel, cùng chiều rộng
        add(buttonPanel);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14, 2, 10, 10)); // 14 hàng x 2 cột, khoảng cách hợp lý giữa các thành phần

        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Thông tin hợp đồng ", TitledBorder.CENTER, TitledBorder.TOP));

        // Khởi tạo các JTextField
        mahdField = new JTextField(25); // Tăng kích thước
        maphongField = new JTextField(25);
        makhachField = new JTextField(25);
        tiencocField = new JTextField(25);
        ngaythueField = new JTextField(25);
        timeField = new JTextField(25);
        ngaytaoField = new JTextField(25);
        trangthaiField = new JTextField(25);

        tienDienField = new JTextField(25);
        tienNuocField = new JTextField(25);
        tienInternetField = new JTextField(25);
        tienDauxeField = new JTextField(25);
        tienThangmayField = new JTextField(25);
        tienVesinhField = new JTextField(25);

        // Thêm các thành phần vào panel
        panel.add(new JLabel("Mã hợp đồng:"));
        panel.add(mahdField);

        panel.add(new JLabel("Mã phòng:"));
        panel.add(maphongField);

        panel.add(new JLabel("Mã khách:"));
        panel.add(makhachField);

        panel.add(new JLabel("Tiền cọc:"));
        panel.add(tiencocField);

        panel.add(new JLabel("Ngày thuê:"));
        panel.add(ngaythueField);

        panel.add(new JLabel("Thời hạn hợp đồng:"));
        panel.add(timeField);

        panel.add(new JLabel("Ngày tạo:"));
        panel.add(ngaytaoField);

        panel.add(new JLabel("Trạng thái:"));
        panel.add(trangthaiField);

        panel.add(new JLabel("Tiền điện:"));
        panel.add(tienDienField);

        panel.add(new JLabel("Tiền nước:"));
        panel.add(tienNuocField);

        panel.add(new JLabel("Tiền Internet:"));
        panel.add(tienInternetField);

        panel.add(new JLabel("Tiền đậu xe:"));
        panel.add(tienDauxeField);

        panel.add(new JLabel("Tiền thang máy:"));
        panel.add(tienThangmayField);

        panel.add(new JLabel("Tiền vệ sinh:"));
        panel.add(tienVesinhField);

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
        trangthaiField = new JTextField(30); // Kéo dài trường tìm kiếm
        searchBtn = new JButton("Tìm");
        searchPanel.add(searchLabel);
        searchPanel.add(trangthaiField);
        searchPanel.add(searchBtn);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Mã hợp đồng", "Mã phòng", "Mã khách", "Tiền cọc", "Ngày thuê",
                "Thời hạn hợp đồng", "Ngày tạo", "Trạng thái"};
        this.tableModel = new DefaultTableModel(columnNames, 0) {
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
            ContractForm form = new ContractForm();
            JFrame frame = new JFrame("Quản lý Hợp đồng");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1346, 793); // Kích thước của cửa sổ
            frame.add(form);
            frame.setVisible(true);
        });
    }
}
