/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.ctr;

/**
 * imports
 */
import java.sql.ResultSet;
import br.com.projeto_2.dao.FornecedorDAO;
import br.com.projeto_2.dto.FornecedorDTO;
import br.com.projeto_2.dao.ConexaoDAO;

/**
 *
 * @author svitorz
 */
public class FornecedorCTR {

    private FornecedorDAO dao = new FornecedorDAO();

    public FornecedorCTR() {
    }

    public String inserirFornecedorString(FornecedorDTO dto) {
        try {
            if (dao.inserirFornecedor(dto)) {
                return "Fornecedor inserido com sucesso!";
            } else {
                return "Fornecedor não inserido.";
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir fornecedor. Erro:" + e);
            return "Houve um erro ao inserir fornecedor.";
        }
    }

    public String alterarFornecedorString(FornecedorDTO dto) {
        try {
            if (dao.atualizarFornecedor(dto)) {
                return "Fornecedor atualizado com sucesso!";
            } else {
                return "Fornecedor não atualizado.";
            }
        } catch (Exception e) {
            System.out.println("Fornecedor não atualizado. Erro: " + e);
            return "Houve um erro ao atualizar fornecedor";
        }
    }

    public String excluirFornecedorString(FornecedorDTO dto) {
        try {
            if (dao.excluirFornecedor(dto)) {
                return "Fornecedor excluído com sucesso!";
            } else {
                return "Fornecedor não excluído.";
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir fornecedor: " + e);
            return "Houve um erro ao excluir fornecedor.";
        }
    }

    public ResultSet consultarFornecedor(FornecedorDTO dto, int opcao) {
        return dao.consultarFornecedor(dto, opcao);
    }
    
    public void CloseDB() {
        ConexaoDAO.closeDB();
    }
}
