/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dao;

import br.com.projeto_2.dto.FornecedorDTO;
import br.com.projeto_2.dto.ProdutoDTO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author svitorz
 */
public class ProdutoDAO {

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirProduto(ProdutoDTO dto, FornecedorDTO fornecedor) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            String comando = "INSERT INTO produto (nome_prod, desc_prod, cod_bar_prod, p_custo_prod, p_venda_prod, id_for) VALUES ('"
                    + dto.getNome_prod() + "', '"
                    + dto.getDesc_prod() + "', '"
                    + dto.getCod_bar_prod() + "', '"
                    + dto.getP_custo_prod() + "', '"
                    + dto.getP_venda_prod() + "', "
                    + fornecedor.getId_for() + ");";

            stmt.execute(comando.toUpperCase());

            ConexaoDAO.conn.commit();

            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.print("Erro ao inserir produto: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }

    public ResultSet consultarProduto(ProdutoDTO dto, int opcao) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            String consulta = "";

            switch (opcao) {
                case 1:
                    consulta = "SELECT p.* FROM produto p WHERE p.nome_prod ilike '" + dto.getNome_prod() + "%' ORDER BY p.nome_prod";
                    break;
                case 2:
                    consulta = "SELECT p.*, f.nome_for, f.id_for FROM produto p, fornecedor f WHERE p.id_for = f.id_for and p.id_prod = " + dto.getId_prod();
            }

            rs = stmt.executeQuery(consulta.toUpperCase());

            return rs;
        } catch (Exception e) {
            System.out.println("Houve um erro ao consultar produto: " + e.getMessage());
            return rs;
        }
    }

    public boolean atualizarProduto(ProdutoDTO dto) {
        String query = "";

        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            query = "UPDATE produto SET "
                    + "nome_prod = '" + dto.getNome_prod() + "', "
                    + "desc_prod = '" + dto.getDesc_prod() + "',"
                    + "cod_bar_prod = '" + dto.getCod_bar_prod() + "', "
                    + "p_custo_prod = '" + dto.getP_custo_prod() + "', "
                    + "p_venda_prod = '" + dto.getP_venda_prod()+ "', "
                    + "WHERE id_prod = " + dto.getId_prod()+ ";";
            
            stmt.execute(query.toUpperCase());
            ConexaoDAO.conn.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage() + "Comando:" + query);
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }

    public boolean excluirProduto(ProdutoDTO dto) {
        String comando = "";
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.conn.createStatement();

            comando = "DELETE FROM produto WHERE id_prod = " + dto.getId_prod();

            stmt.execute(comando);

            ConexaoDAO.conn.commit();

            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir produto\nErro:" + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDB();
        }
    }
}
