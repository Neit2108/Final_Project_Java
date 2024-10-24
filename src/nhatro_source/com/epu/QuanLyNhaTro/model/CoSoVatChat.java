package com.epu.QuanLyNhaTro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class CoSoVatChat {
    private int maCSVC;
    private String tenCSVC;
    private String trangThai;

    public String toString(){
        return "CoSoVatChat{" +
                "maCSVC='" + maCSVC + '\''
                + ", tenCSVC='" + tenCSVC + '\''
                + ", trangThai='" + trangThai + '\''
                + "}";
    }
}

