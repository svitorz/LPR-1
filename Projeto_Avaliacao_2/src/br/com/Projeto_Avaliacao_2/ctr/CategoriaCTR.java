/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Projeto_Avaliacao_2.ctr;

import br.com.Projeto_Avaliacao_2.dao.CategoriaDAO;
import br.com.Projeto_Avaliacao_2.dto.CategoriaDTO;
import java.sql.ResultSet;
import br.com.Projeto_Avaliacao_2.dao.ConexaoDAO;


/**
 *
 * @author svitorz
 */
public class CategoriaCTR {

    CategoriaDAO categoriaDAO = new CategoriaDAO();

    public String inserirCategoriaString(CategoriaDTO categoriaDTO) {
        try {
            if (categoriaDAO.inserirCategoria(categoriaDTO)) {
                return "Categoria inserida com sucesso.";
            } else {
                return "Categoria não inserida.";
            }
        } catch (Exception erTab) {
            return "Erro ao inserir categoria.\n" + erTab;
        }
    }

    public String alterarCategoriaString(CategoriaDTO categoriaDTO) {
        try {
            if (categoriaDAO.alterarCategoria(categoriaDTO)) {
                return "Categoria alterado com sucesso.";
            } else {
                return "Categoria não alterado.";
            }
        } catch (Exception erTab) {
            return "Erro ao inserir alterado.\n" + erTab;
        }
    }

    public String excluirCategoriaString(CategoriaDTO categoriaDTO) {
        try {
            if (categoriaDAO.excluirCategoria(categoriaDTO)) {
                return "Categoria excluida com sucesso.";
            } else {
                return "Categoria não excluida.";
            }
        } catch (Exception erTab) {
            return "Erro ao excluir categoria.\n" + erTab;
        }
    }
    
    public ResultSet consultarCategoriaString(CategoriaDTO categoriaDTO, int opcao) {
        return categoriaDAO.consultarCliente(categoriaDTO, opcao);
    }
    
    public void closeDb(){
        try {
            ConexaoDAO.CloseDB();
        } catch (Exception e) {
            System.out.println("Erro ao fechar banco de dados" + e);
        }
    }
}
