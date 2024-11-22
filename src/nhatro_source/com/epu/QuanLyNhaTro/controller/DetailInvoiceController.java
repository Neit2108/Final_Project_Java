package com.epu.QuanLyNhaTro.controller;

import com.epu.QuanLyNhaTro.dao.TienThuDAO;
import com.epu.QuanLyNhaTro.dao.TienThuDAOImpl;
import com.epu.QuanLyNhaTro.model.TienThuTienIch;
import com.epu.QuanLyNhaTro.view.DetailInvoiceForm;
import com.epu.QuanLyNhaTro.view.InvoiceForm;

import java.util.List;

public class DetailInvoiceController {
    private final DetailInvoiceForm detailInvoiceForm;
    private final InvoiceForm invoiceForm;

    public DetailInvoiceController(DetailInvoiceForm detailInvoiceForm, InvoiceForm invoiceForm) {
        this.detailInvoiceForm = detailInvoiceForm;
        this.invoiceForm = invoiceForm;
    }

    public void init(){

    }

    private void handleInfor(){

    }

    private void handleTableUsedService(){
        TienThuDAO tienThuDAO = new TienThuDAOImpl();
        List<TienThuTienIch> tienThuDAOList = tienThuDAO.getAll();
//        {"Điện", String.valueOf(x.getSoDienMoi()), String.valueOf(x.getSoDienCu()), String.valueOf(x.getSoDienDaDung()), "4000", String.valueOf(x.getSoDienDaDung() * 4000)},
//        {"Nước", String.valueOf(x.getSoNuocMoi()), String.valueOf(x.getSoNuocCu()), String.valueOf(x.getSoNuocDaDung()), "30000", String.valueOf(x.getSoNuocDaDung() * 30000)}

    }
}


