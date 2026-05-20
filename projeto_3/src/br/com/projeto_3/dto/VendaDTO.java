/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.dto;

/**
 *
 * @author svitorz
 */

import java.util.Date;
public class VendaDTO {
    private int id_vend;
    private double val_venda;
    private Date dat_venda;

    public int getId_vend() {
        return id_vend;
    }

    public void setId_vend(int id_vend) {
        this.id_vend = id_vend;
    }

    public double getVal_venda() {
        return val_venda;
    }

    public void setVal_venda(double val_venda) {
        this.val_venda = val_venda;
    }

    public Date getDat_venda() {
        return dat_venda;
    }

    public void setDat_venda(Date dat_venda) {
        this.dat_venda = dat_venda;
    }
}
