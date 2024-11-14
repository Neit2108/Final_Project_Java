package com.epu.QuanLyNhaTro.view;

import com.epu.QuanLyNhaTro.controller.DetailRoomController;
import com.epu.QuanLyNhaTro.controller.HomePageController;
import com.intellij.uiDesigner.core.GridLayoutManager;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class HomePage extends JFrame{
    private JPanel mainPnl;
    private JPanel headerPnl;
    private JPanel bodyPnl;
    private JPanel footerPnl;
    private JPanel productListPnl;
    private JScrollPane productListScroll;
    private JPanel headerListPnl;
    private JPanel homePnl;
    private JPanel inforPnl;
    private JPanel introPnl;
    private JPanel contactPnl;
    private JLabel homeLbl;
    private JLabel inforLbl;
    private JLabel introLbl;
    private JLabel contactLbl;

    public HomePage() {
        this.setContentPane(mainPnl);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        //Header
        headerPnl.setPreferredSize(new Dimension(800, 10));
        headerListPnl.setPreferredSize(new Dimension(800, 10));
        HomePageController homePageController = new HomePageController(this);
        homePageController.initController();
        //End Header

        //Body
        productListScroll.setPreferredSize(new Dimension(800, 300));
        productListScroll.setViewportView(productListPnl);
        productListPnl.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        int col = 0, row = 0;
        for(int i = 0; i < 8; i ++){
            JPanel productPnl = new JPanel();
            productPnl.setPreferredSize(new Dimension(150, 150));
            productPnl.setBorder(BorderFactory.createTitledBorder("Phòng trọ " + (i + 1)));
            productPnl.setLayout(new BorderLayout(10, 0));
            JLabel priceLbl = new JLabel();
            priceLbl.setIcon(new ImageIcon("src/resources/icons8-house-100.png"));
            JButton detailBtn = new JButton("Chi tiết");
            //Event cho tung nut
            int tmp = i;
            detailBtn.addActionListener(e -> {
                DetailRoom detailRoom = new DetailRoom();
                DetailRoomController detailRoomController = new DetailRoomController(detailRoom, this);
                detailRoomController.handelDetailRoom(tmp + 3);
            });
//            detailBtn.setContentAreaFilled(false);
//            detailBtn.setOpaque(true);
//            detailBtn.setBorderPainted(true);


            productPnl.add(priceLbl, BorderLayout.CENTER);
            productPnl.add(detailBtn, BorderLayout.SOUTH);
            gbc.gridx = col;
            gbc.gridy = row;
            productListPnl.add(productPnl, gbc);
            col++;
            if(col == 4){
                col = 0;
                row++;
            }
        }
        //End Body
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
    }
}
