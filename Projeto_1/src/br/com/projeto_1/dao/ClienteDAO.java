/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.dao;

import java.sql.*;
import br.com.projeto_1.dto.ClienteDTO;

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
            
            String query = "insert into cliente (nome_cli, logradouro_cli, numero_cli, bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli)" +
                            "values ('"
                            + dto.getNome_cli() + "', '"
                            + dto.getLogradouro_cli() + "',"
                            + dto.getNumero_cli() + ", '"
                            + dto.getBairro_cli() + "','"
                            + dto.getCidade_cli() +"', '"
                            + dto.getEstado_cli() +"','"
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
    
} // fim da classe
