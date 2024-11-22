package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.*;
import com.epu.QuanLyNhaTro.model.*;
import com.epu.QuanLyNhaTro.view.ContractForm;
import com.epu.QuanLyNhaTro.view.DetailContract;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

public class DetailContractController {
    private final DetailContract detailContract;
    private final ContractForm contractForm;
    public DetailContractController(DetailContract detailContract, ContractForm contractForm) {
        this.detailContract = detailContract;
        this.contractForm = contractForm;
    }

    public void init(){
        handleDate();
        handleInformation();
        handleListService();
    }

    private void handleDate(){
        LocalDate date = LocalDate.parse(contractForm.getNgaytaoField().getText());
        this.detailContract.getDayOfCreateLbl().setText("Hà Nội, ngày " + date.getDayOfMonth() + " tháng " + date.getMonthValue() + " năm " + date.getYear());
    }

    private void handleInformation(){
        KhachThueDAO khachThueDAO = new KhachThueDAOImpl();

        //Lấy khach thue theo ma khach
        int idKhach = Integer.parseInt(contractForm.getMakhachField().getText());
        KhachThue khachThue = khachThueDAO.getKhachThue(idKhach);
        detailContract.getCccdField_B().setText(khachThue.getMaCCCD());
        detailContract.getNameField_B().setText(khachThue.getTen());
        detailContract.getAddressField_B().setText(khachThue.getDiaChi());

        //Lay chu nha
        PhongDAO phongDAO = new PhongDAOImpl();
        int idPhong = Integer.parseInt(contractForm.getMaphongField().getText());
        System.out.println(idPhong);
        int idChuNha = phongDAO.getMaChuNha(idPhong);
        System.out.println(idChuNha);
        ChuNhaDAO chuNhaDAO = new ChuNhaDAOImpl();
        ChuNha chuNha = chuNhaDAO.getChuNha(idChuNha);
        detailContract.getCccdField_A().setText(chuNha.getMaCCCD());
        detailContract.getNameField_A().setText(chuNha.getTen());
        detailContract.getAddressField_A().setText(chuNha.getDiaChi());

    }

    private void handleListService(){
        Phong_DichVu_DAO phong_dichVu_dao = new Phong_DichVu_DAOImpl();
        int idPhong = Integer.parseInt(contractForm.getMaphongField().getText());
        PhongDAO phongDAO = new PhongDAOImpl();

        //Lay tien phong va tien coc
        String giaPhong = String.valueOf(phongDAO.getGiaPhong(idPhong));
        String tienCoc = contractForm.getTiencocField().getText();

        String[][] rows = new String[][]{
                {"Tiền phòng", giaPhong, "Tính theo tháng"},
                {"Tiền cọc", tienCoc, "Sẽ được hoàn trả khi hết hợp đồng"}
        };

        for(int i = 0; i <= 1; i++){
            detailContract.getModel().insertRow(i, rows[i]);
        }

        //lay csvc
        CoSoVatChatDAO coSoVatChatDAO = new CoSoVatChatDAOImpl();
        List<CoSoVatChat>  coSoVatChatList = coSoVatChatDAO.getAllCoSoVatChat(idPhong);
        for(CoSoVatChat x : coSoVatChatList){
            String[] row = new String[]{x.getTenCSVC(), "free", x.getTrangThai()};
            detailContract.getModel().addRow(row);
        }
    }
}
