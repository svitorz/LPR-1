/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.projeto_avaliacao_1.dao;

import br.com.projeto_avaliacao_1.dto.VeiculoDTO;
import java.sql.ResultSet;
/**
 *
 * @author svitorz
 */
public interface VeiculoDAOI {
    public Boolean inserirVeiculo(VeiculoDTO dto);
    public ResultSet buscarVeiculo(VeiculoDTO dto, int opcao);
    public Boolean alterarVeiculo(VeiculoDTO dto);
    public Boolean excluirVeiculo(VeiculoDTO dto);
}
