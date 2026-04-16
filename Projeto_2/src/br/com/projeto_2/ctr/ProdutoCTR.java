/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.ctr;

import br.com.projeto_2.dao.ConexaoDAO;
import br.com.projeto_2.dao.ProdutoDAO;
import br.com.projeto_2.dto.ProdutoDTO;
import br.com.projeto_2.dto.FornecedorDTO;

import java.sql.ResultSet;

/**
 *
 * @author svitorz
 */
public class ProdutoCTR {
    private ProdutoDAO dao = new ProdutoDAO();

    public ProdutoCTR() {
    }
    
        public String inserirProdutoString(ProdutoDTO dto, FornecedorDTO fornecedor) {
        try {
            if (dao.inserirProduto(dto, fornecedor)) {
                return "Produto inserido com sucesso!";
            } else {
                return "Produto não inserido.";
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir Produto. Erro:" + e);
            return "Houve um erro ao inserir Produto.";
        }
    }

    public String alterarProdutoString(ProdutoDTO dto) {
        try {
            if (dao.atualizarProduto(dto)) {
                return "Produto atualizado com sucesso!";
            } else {
                return "Produto não atualizado.";
            }
        } catch (Exception e) {
            System.out.println("Produto não atualizado. Erro: " + e);
            return "Houve um erro ao atualizar Produto";
        }
    }

    public String excluirProdutoString(ProdutoDTO dto) {
        try {
            if (dao.excluirProduto(dto)) {
                return "Produto excluído com sucesso!";
            } else {
                return "Produto não excluído.";
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir Produto: " + e);
            return "Houve um erro ao excluir Produto.";
        }
    }

    public ResultSet consultarProduto(ProdutoDTO dto, int opcao) {
        return dao.consultarProduto(dto, opcao);
    }
    
    public void CloseDB() {
        ConexaoDAO.closeDB();
    }
}
