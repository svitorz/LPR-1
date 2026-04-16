/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dao;

import br.com.projeto_2.dto.FornecedorDTO;
import java.text.SimpleDateFormat;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author svitorz
 */
public class FornecedorDAO {

    SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirFornecedor(FornecedorDTO dto) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            String comando = "INSERT INTO fornecedor(nome_for, cnpj_for, tel_for, data_cad_for) VALUES ('"
                    + dto.getNome_for() + "','"
                    + dto.getCnpj_for() + "','"
                    + dto.getTel_for() + "',"
                    + " to_date('" + data_format.format(dto.getData_cad_for()) + "','dd/mm/yyyy'));";
            stmt.execute(comando.toUpperCase());

            ConexaoDAO.conn.commit();

            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.print("Erro ao inserir fornecedor: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }

    public ResultSet consultarFornecedor(FornecedorDTO dto, int opcao) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            String consulta = "";

            switch (opcao) {
                case 1:
                    consulta = "select id_for, nome_for from fornecedor where nome_for ilike '"
                            + dto.getNome_for() + "%' order by nome_for;";
                    break;
                case 2:
                    consulta = "select nome_for, cnpj_for, tel_for, to_char(data_cad_for, 'dd/mm/yyyy') as data_cad_for from fornecedor "
                            + "where id_for = " + dto.getId_for();
            }
            
            rs = stmt.executeQuery(consulta.toUpperCase());

            return rs;
        } catch (Exception e) {
            System.out.println("Houve um erro ao consultar fornecedor: " + e.getMessage());
            return rs;
        }
    }

    public boolean atualizarFornecedor(FornecedorDTO dto) {
        String query = "";

        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            query = "UPDATE fornecedor SET "
                    + "nome_for = '" + dto.getNome_for() + "', "
                    + "cnpj_for = '" + dto.getCnpj_for() + "',"
                    + "tel_for = '" + dto.getTel_for() + "', "
                    + "data_cad_for = to_date('" + data_format.format(dto.getData_cad_for()) + "','dd/mm/yyyy')'"
                    + "WHERE id_cli = " + dto.getId_for() + ";";
            stmt.execute(query.toUpperCase());
            ConexaoDAO.conn.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar fornecedor: " + e.getMessage() + "Comando:" + query);
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }

    public boolean excluirFornecedor(FornecedorDTO dto) {
        String comando = "";
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            comando = "DELETE FROM fornecedor WHERE id_for = " + dto.getId_for();

            stmt.execute(comando);

            ConexaoDAO.conn.commit();

            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir fornecedor\nErro:" + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }
}
