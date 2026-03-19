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
          + dto.getAno() + ", '"
          + dto.getCor() + "', '"
          + dto.getPlaca() + "', '"
          + dto.getChassi() + "', '"
          + dto.getCombustivel() + "', '"
          + dto.getQuilometragem() + "', "
          + dto.getPreco() + ", "
          + dto.getProprietario() + ", "
          + dto.getData_cadastro() + ");";

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
  public ResultSet buscarVeiculo(VeiculoDTO dto, int opcao) {
    String query = "";
    try {

      ConexaoDAO.ConnectDB();

      stmt = ConexaoDAO.conn.createStatement();

      switch (opcao) {
        // Busca pelo modelo do veículo
        case 1:
          query = "SELECT * FROM veiculos WHERE modelo LIKE %" + dto.getModelo();
          break;

        // Busca pelo nome do proprietario do carro
        case 2:
          query = "SELECT * FROM veiculos WHERE proprietario LIKE %" + dto.getProprietario();
          break;

        case 3:
          query = "SELECT * FROM veiculos ORDER BY id DESC";
          break;
        default:
          break;
      }

      rs = stmt.executeQuery(query);
      return rs;
    } catch (Exception e) {
      System.out.println("Houve um erro ao consultar: " + e.getMessage());
      return rs;
    }
  }

  @Override
  public Boolean alterarVeiculo(VeiculoDTO dto) {
    String query = "";
    try {
      ConexaoDAO.ConnectDB();

      stmt = ConexaoDAO.conn.createStatement();

      query = "UPDATE veiculos SET"
          + " marca = " + dto.getMarca() + "', '"
          + " modelo = " + dto.getModelo() + "',"
          + " ano = " + dto.getAno() + ", '"
          + " cor = " + dto.getCor() + "', '"
          + " placa = " + dto.getPlaca() + "', '"
          + " chassi = " + dto.getChassi() + "', '"
          + " combustivel = " + dto.getCombustivel() + "', '"
          + " quilometragem = " + dto.getQuilometragem() + "', "
          + " preco = " + dto.getPreco() + ", "
          + " proprietario = " + dto.getProprietario() + ", "
          + " data_registro = " + dto.getData_cadastro() + ");";

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
  public Boolean excluirVeiculo(VeiculoDTO dto) {
    String query = "";
    try {
      ConexaoDAO.ConnectDB();

      stmt = ConexaoDAO.conn.createStatement();

      query = "DELETE FROM veiculos WHERE id = " + dto.getId();

      stmt.execute(query);

      ConexaoDAO.conn.commit();

      stmt.close();

      return true;
    } catch (Exception e) {
      System.out.println("Erro ao excluir cliente: " + dto.getId() + "\nErro:" + e.getMessage());
      return false;
    } finally {
      ConexaoDAO.closeDB();
    }
  }

}
