package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.HopDongDAO;
import com.epu.QuanLyNhaTro.dao.HopDongDAOImpl;
import com.epu.QuanLyNhaTro.dao.KhachThueDAO;
import com.epu.QuanLyNhaTro.dao.KhachThueDAOImpl;
import com.epu.QuanLyNhaTro.model.HopDong;
import com.epu.QuanLyNhaTro.model.KhachThue;
import com.epu.QuanLyNhaTro.view.ContractForm;

import java.util.List;

public class ContractFormController {
    private final ContractForm contractForm;

    public ContractFormController(ContractForm contractForm) {
        this.contractForm = contractForm;
    }

    public void init(){
        this.showData();
    }

    private void showData(){
        HopDongDAO hopDongDAO = new HopDongDAOImpl();
        List<HopDong> hopDongList = hopDongDAO.getAllHopDong();
        for(HopDong x : hopDongList){
            String[] row = new String[]{String.valueOf(x.getMaHopDong()), String.valueOf(x.getMaPhong()), String.valueOf(x.getMaKhachThue()), String.format("%.2f", x.getTienCoc()), String.valueOf(x.getNgayThue()), String.valueOf(x.getNgayDiDuKien()), x.getTrangThai()};
            this.contractForm.getTableModel().addRow(row);
        }
    }
}
