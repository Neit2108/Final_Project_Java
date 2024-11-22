package com.epu.QuanLyNhaTro.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
@Setter
public class DetailInvoiceForm extends JFrame {
    private JPanel mainPnl;
    private JLabel titleLbl;
    private JLabel addressLbl;
    private JPanel detailPnl;
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
    private JPanel paymentBtnPnl;
    private JButton exportBtn;
    private JButton payBtn;
    private DefaultTableModel tableModel;

    public DetailInvoiceForm() {
        setContentPane(mainPnl);
        setSize(800, 600);

        mainPnl = new JPanel();
        mainPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        add(mainPnl, BorderLayout.CENTER);

        titleLbl = new JLabel("HÓA ĐƠN TIỀN TRỌ");
        titleLbl.setFont(new Font("Serif", Font.BOLD, 18));
        addressLbl = new JLabel("Địa chỉ : ");
        addressLbl.setFont(new Font("Serif", Font.PLAIN, 16));

        numberOfRoomLbl = new JLabel("PHÒNG SỐ");
        numberOfRoomLbl.setFont(new Font("Serif", Font.BOLD, 18));

        elecLbl = new JLabel("Điện");
        waterLbl = new JLabel("Nước");
        internetLbl = new JLabel("Internet");
        vehicleLbl = new JLabel("Đỗ xe");
        cleanLbl = new JLabel("Vệ sinh");

        elecField = new JTextField(10);
        waterField = new JTextField(10);
        internetField = new JTextField(10);
        vehicleField = new JTextField(10);
        cleanField = new JTextField(10);

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

        totalLbl = new JLabel("TỔNG CỘNG");
        totalField = new JTextField(10);
        totalField.setEditable(false);

        paymentLbl = new JLabel("Hình thức thanh toán");
        paymentCombo = new JComboBox<>(new String[]{"Chuyển khoản", "Tiền mặt", "Thẻ"});

        exportBtn = new JButton("Xuất Hóa Đơn");
        payBtn = new JButton("Thanh Toán");

        paymentBtnPnl = new JPanel();
        paymentBtnPnl.setLayout(new FlowLayout(FlowLayout.RIGHT));
        paymentBtnPnl.add(exportBtn);
        paymentBtnPnl.add(payBtn);

        GroupLayout layout = new GroupLayout(mainPnl);
        mainPnl.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(titleLbl)
                .addComponent(addressLbl)
                .addComponent(numberOfRoomLbl)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(elecLbl)
                                .addComponent(waterLbl)
                                .addComponent(internetLbl)
                                .addComponent(vehicleLbl)
                                .addComponent(cleanLbl))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(elecField)
                                .addComponent(waterField)
                                .addComponent(internetField)
                                .addComponent(vehicleField)
                                .addComponent(cleanField)))
                .addComponent(scrollPane)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(totalLbl)
                        .addComponent(totalField))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(paymentLbl)
                        .addComponent(paymentCombo))
                .addComponent(paymentBtnPnl)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(titleLbl)
                .addComponent(addressLbl)
                .addComponent(numberOfRoomLbl)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(elecLbl)
                        .addComponent(elecField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(waterLbl)
                        .addComponent(waterField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(internetLbl)
                        .addComponent(internetField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(vehicleLbl)
                        .addComponent(vehicleField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cleanLbl)
                        .addComponent(cleanField))
                .addComponent(scrollPane)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(totalLbl)
                        .addComponent(totalField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(paymentLbl)
                        .addComponent(paymentCombo))
                .addComponent(paymentBtnPnl)
        );
    }

    public static void main(String[] args) {
        DetailInvoiceForm detailInvoiceForm = new DetailInvoiceForm();
        detailInvoiceForm.setVisible(true);
    }

}