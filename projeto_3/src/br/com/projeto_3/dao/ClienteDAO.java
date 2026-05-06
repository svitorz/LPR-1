/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.dao;

import java.sql.*;
import br.com.projeto_3.dto.ClienteDTO;

/**
 *
 * @author svitorz
 */
public class ClienteDAO {

  /**
   * Construtor da classe
   */
  public ClienteDAO() {
  }

  private ResultSet rs = null;

  private Statement stmt = null;

  public Boolean inserirCliente(ClienteDTO dto) {
    try {
      ConexaoDAO.ConnectDB();

      stmt = ConexaoDAO.conn.createStatement();

      String query = "insert into cliente (nome_cli, logradouro_cli, numero_cli, bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli)"
          +
          "values ('"
          + dto.getNome_cli() + "', '"
          + dto.getLogradouro_cli() + "',"
          + dto.getNumero_cli() + ", '"
          + dto.getBairro_cli() + "','"
          + dto.getCidade_cli() + "', '"
          + dto.getEstado_cli() + "','"
          + dto.getCep_cli() + "','"
          + dto.getCpf_cli() + "','"
          + dto.getRg_cli() + "');";

      stmt.execute(query.toUpperCase());

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

  public ResultSet consultarCliente(ClienteDTO dto, int opcao) {
    try {
      ConexaoDAO.ConnectDB();

      stmt = ConexaoDAO.conn.createStatement();

      String consulta = "";

      switch (opcao) {
        case 1:
          consulta = "select c.* from cliente c where c.nome_cli like '"
              + dto.getNome_cli() + "%' order by c.nome_cli;";
          break;
        case 2:
          consulta = "select c.* from cliente c where c.id_cli = "
              + dto.getId_cli() + ";";
          break;
        case 3:
          consulta = "select c.* from cliente c;";
          break;
      }

      rs = stmt.executeQuery(consulta.toUpperCase());

      return rs;
    } catch (Exception e) {
      System.out.println("Houve um erro ao consultar: " + e.getMessage());
      return rs;
    }
  }

  public boolean atualizarCliente(ClienteDTO dto) {
    String query = "";

    try {
      ConexaoDAO.ConnectDB();

      stmt = ConexaoDAO.conn.createStatement();

      query = "UPDATE cliente SET "
          + "nome_cli = '" + dto.getNome_cli() + "', "
          + "logradouro_cli = '" + dto.getLogradouro_cli() + "',"
          + "numero_cli = '" + dto.getNumero_cli() + "', "
          + "bairro_cli = '" + dto.getBairro_cli() + "', "
          + "cidade_cli = '" + dto.getCidade_cli() + "', "
          + "estado_cli = '" + dto.getEstado_cli() + "',"
          + "cep_cli = '" + dto.getCep_cli() + "', "
          + "cpf_cli = '" + dto.getCpf_cli() + "', "
          + "rg_cli = '" + dto.getRg_cli() + "' "
          + "WHERE id_cli = " + dto.getId_cli() + ";";
      stmt.execute(query.toUpperCase());
      ConexaoDAO.conn.commit();
      stmt.close();
      return true;
    } catch (Exception e) {
        System.out.println("Erro ao atualizar cliente: " + dto.getId_cli() + "\nErro:" + e.getMessage() + "Comando:" + query);
        return false;
    } finally {
        ConexaoDAO.closeDB();
    }
  }
  
  public boolean excluirCliente(ClienteDTO dto) {
      String query = "";
      try {
          ConexaoDAO.ConnectDB();
          
          stmt = ConexaoDAO.conn.createStatement();
          
          query = "DELETE FROM cliente WHERE id_cli = " + dto.getId_cli();
          
          stmt.execute(query);
          
          ConexaoDAO.conn.commit();
          
          stmt.close();
          
          return true;
      } catch(Exception e){
          System.out.println("Erro ao excluir cliente: " + dto.getId_cli() + "\nErro:" + e.getMessage());
          return false;
      } finally {
          ConexaoDAO.closeDB();
      }
  }
} // fim da classe
