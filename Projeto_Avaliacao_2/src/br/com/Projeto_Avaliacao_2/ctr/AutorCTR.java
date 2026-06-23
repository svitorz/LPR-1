/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Projeto_Avaliacao_2.ctr;

import br.com.Projeto_Avaliacao_2.dao.AutorDAO;
import br.com.Projeto_Avaliacao_2.dao.ConexaoDAO;
import br.com.Projeto_Avaliacao_2.dto.AutorDTO;
import java.sql.ResultSet;

/**
 *
 * @author svitorz
 */
public class AutorCTR {
    
    AutorDAO autorDAO = new AutorDAO();
    
    public String inserirAutorString(AutorDTO autorDTO) {
        try {
            if (autorDAO.inserirAutor(autorDTO)) {
                return "Autor inserido com sucesso.";
            } else {
                return "Autor não inserido.";
            }
        } catch (Exception erTab) {
            return "Erro ao inserir Autor.\n" + erTab;
        }
    }

    public String alterarAutorString(AutorDTO autorDTO) {
        try {
            if (autorDAO.alterarAutor(autorDTO)) {
                return "Autor alterado com sucesso.";
            } else {
                return "Autor não alterado.";
            }
        } catch (Exception erTab) {
            return "Erro ao inserir alterado.\n" + erTab;
        }
    }

    public String excluirAutorString(AutorDTO autorDTO) {
        try {
            if (autorDAO.excluirAutor(autorDTO)) {
                return "Autor excluida com sucesso.";
            } else {
                return "Autor não excluida.";
            }
        } catch (Exception erTab) {
            return "Erro ao excluir Autor.\n" + erTab;
        }
    }
    
    public ResultSet consultarAutorString(AutorDTO autorDTO, int opcao) {
        return autorDAO.consultarAutor(autorDTO, opcao);
    }
    
    public void closeDb(){
        try {
            ConexaoDAO.CloseDB();
        } catch (Exception e) {
            System.out.println("Erro ao fechar banco de dados" + e);
        }
    }
}
