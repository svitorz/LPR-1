/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_avaliacao_1.dao;

import br.com.projeto_avaliacao_1.dto.VeiculoDTO;
import java.sql.*;

/**
 *
 * @author svitorz
 */
public class VeiculoDAO implements VeiculoDAOI {
  private Statement stmt = null;

  private ResultSet rs = null;

  public VeiculoDAO() {
  }

  @Override
  public Boolean inserirVeiculo(VeiculoDTO dto) {
    String query = "";
    try {
        ConexaoDAO.ConnectDB();

        stmt = ConexaoDAO.conn.createStatement();

        query = "INSERT INTO veiculos(marca, modelo, ano, cor, placa, chassi, combustivel, quilometragem, preco, proprietario, data_registro)"
                + "VALUES('" 
                + dto.getMarca() + "', '"
                + dto.getModelo() + "'," 
                + dto.getAno() +", '" 
                + dto.getCor() +"', '" 
                + dto.getPlaca() +"', '" 
                + dto.getChassi() +"', '" 
                + dto.getCombustivel() +"', '"
                + dto.getQuilometragem() +"', " 
                + dto.getPreco() +", "
                + dto.getProprietario() +", "
                + dto.getData_cadastro()+");";
        
        stmt.execute(query);
        
        ConexaoDAO.conn.commit();

        stmt.close();

        return true;
    } catch (Exception e) {
      System.out.print(e);
      return false;
    } finally {
      ConexaoDAO.closeDB();
    }
  }

  @Override
  public ResultSet buscarVeiculo(VeiculoDTO dto) {
    
  }

  @Override
  public Boolean alterarVeiculo(VeiculoDTO dto) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                   // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public Boolean excluirVeiculo(VeiculoDTO dto) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                   // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

}
