package com.epu.QuanLyNhaTro.dao;

import com.epu.QuanLyNhaTro.model.CoSoVatChat;

import java.util.List;

public interface CoSoVatChatDAO {
    CoSoVatChat getCoSoVatChat(int maCoSoVatChat);
    List<CoSoVatChat> getAllCoSoVatChat(int maPhong);
}
