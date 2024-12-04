package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.NhaTroDAO;
import com.epu.QuanLyNhaTro.dao.NhaTroDAOImpl;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAO;
import com.epu.QuanLyNhaTro.dao.TaiKhoanDAOImpl;
import com.epu.QuanLyNhaTro.model.NhaTro;
import com.epu.QuanLyNhaTro.util.Constant;
import com.epu.QuanLyNhaTro.view.HouseForm;

import java.util.List;

public class HouseFormController {
    private final HouseForm houseForm;

    public HouseFormController(HouseForm houseForm) {
        this.houseForm = houseForm;
    }

    public void init() {
        showData();
    }

    private void showData() {
        NhaTroDAO nhaTroDAO = new NhaTroDAOImpl();
        List<NhaTro> nhaTros = nhaTroDAO.getAllNhaTro();
        if((Constant.role != null ? Constant.role : "Admin").equalsIgnoreCase("admin")) {
            for(NhaTro nhaTro : nhaTros) {
                houseForm.getDanhSachPanel().add(houseForm.createNhaPanel(String.valueOf(nhaTro.getMaNhaTro()), nhaTro.getTrangThai()));
            }
        } else {
            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAOImpl();
            List<NhaTro> nhaTros1 = nhaTroDAO.getAllNhaTroByMaChuNha(taiKhoanDAO.getMaChuNha(Constant.taiKhoan.getMaTaiKhoan()));
            for(NhaTro nhaTro : nhaTros1) {
                houseForm.getDanhSachPanel().add(houseForm.createNhaPanel(String.valueOf(nhaTro.getMaNhaTro()), nhaTro.getTrangThai()));
            }
        }
    }
}
